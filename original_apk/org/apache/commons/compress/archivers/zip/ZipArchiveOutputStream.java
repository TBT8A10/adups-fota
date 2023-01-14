package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

public class ZipArchiveOutputStream extends ArchiveOutputStream {
    static final int BUFFER_SIZE = 512;
    static final byte[] CFH_SIG = ZipLong.CFH_SIG.getBytes();
    static final byte[] DD_SIG = ZipLong.DD_SIG.getBytes();
    public static final int DEFAULT_COMPRESSION = -1;
    static final String DEFAULT_ENCODING = "UTF8";
    public static final int DEFLATED = 8;
    private static final int DEFLATER_BLOCK_SIZE = 8192;
    @Deprecated
    public static final int EFS_FLAG = 2048;
    private static final byte[] EMPTY = new byte[0];
    static final byte[] EOCD_SIG = ZipLong.getBytes(101010256);
    static final byte[] LFH_SIG = ZipLong.LFH_SIG.getBytes();
    private static final byte[] LZERO = {0, 0, 0, 0};
    private static final byte[] ONE = ZipLong.getBytes(1);
    public static final int STORED = 0;
    private static final byte[] ZERO = {0, 0};
    static final byte[] ZIP64_EOCD_LOC_SIG = ZipLong.getBytes(117853008);
    static final byte[] ZIP64_EOCD_SIG = ZipLong.getBytes(101075792);
    private final byte[] buf = new byte[512];
    private long cdLength = 0;
    private long cdOffset = 0;
    private String comment = "";
    private final CRC32 crc = new CRC32();
    private UnicodeExtraFieldPolicy createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
    protected final Deflater def = new Deflater(this.level, true);
    private String encoding = DEFAULT_ENCODING;
    private final List<ZipArchiveEntry> entries = new LinkedList();
    private CurrentEntry entry;
    private boolean fallbackToUTF8 = false;
    protected boolean finished = false;
    private boolean hasCompressionLevelChanged = false;
    private boolean hasUsedZip64 = false;
    private int level = -1;
    private int method = 8;
    private final Map<ZipArchiveEntry, Long> offsets = new HashMap();
    private final OutputStream out;
    private final RandomAccessFile raf;
    private boolean useUTF8Flag = true;
    private long written = 0;
    private Zip64Mode zip64Mode = Zip64Mode.AsNeeded;
    private ZipEncoding zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);

    private static final class CurrentEntry {
        /* access modifiers changed from: private */
        public long bytesRead;
        /* access modifiers changed from: private */
        public boolean causedUseOfZip64;
        /* access modifiers changed from: private */
        public long dataStart;
        /* access modifiers changed from: private */
        public final ZipArchiveEntry entry;
        /* access modifiers changed from: private */
        public boolean hasWritten;
        /* access modifiers changed from: private */
        public long localDataStart;

        static /* synthetic */ long access$314(CurrentEntry currentEntry, long j) {
            long j2 = currentEntry.bytesRead + j;
            currentEntry.bytesRead = j2;
            return j2;
        }

        private CurrentEntry(ZipArchiveEntry zipArchiveEntry) {
            this.localDataStart = 0;
            this.dataStart = 0;
            this.bytesRead = 0;
            this.causedUseOfZip64 = false;
            this.entry = zipArchiveEntry;
        }
    }

    public static final class UnicodeExtraFieldPolicy {
        public static final UnicodeExtraFieldPolicy ALWAYS = new UnicodeExtraFieldPolicy("always");
        public static final UnicodeExtraFieldPolicy NEVER = new UnicodeExtraFieldPolicy("never");
        public static final UnicodeExtraFieldPolicy NOT_ENCODEABLE = new UnicodeExtraFieldPolicy("not encodeable");
        private final String name;

        private UnicodeExtraFieldPolicy(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public ZipArchiveOutputStream(OutputStream outputStream) {
        this.out = outputStream;
        this.raf = null;
    }

    private void addUnicodeExtraFields(ZipArchiveEntry zipArchiveEntry, boolean z, ByteBuffer byteBuffer) throws IOException {
        if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.ALWAYS || !z) {
            zipArchiveEntry.addExtraField(new UnicodePathExtraField(zipArchiveEntry.getName(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position()));
        }
        String comment2 = zipArchiveEntry.getComment();
        if (comment2 != null && !"".equals(comment2)) {
            boolean canEncode = this.zipEncoding.canEncode(comment2);
            if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.ALWAYS || !canEncode) {
                ByteBuffer encode = getEntryEncoding(zipArchiveEntry).encode(comment2);
                zipArchiveEntry.addExtraField(new UnicodeCommentExtraField(comment2, encode.array(), encode.arrayOffset(), encode.limit() - encode.position()));
            }
        }
    }

    private void deflateUntilInputIsNeeded() throws IOException {
        while (!this.def.needsInput()) {
            deflate();
        }
    }

    private void flushDeflater() throws IOException {
        if (this.entry.entry.getMethod() == 8) {
            this.def.finish();
            while (!this.def.finished()) {
                deflate();
            }
        }
    }

    private Zip64Mode getEffectiveZip64Mode(ZipArchiveEntry zipArchiveEntry) {
        if (this.zip64Mode == Zip64Mode.AsNeeded && this.raf == null && zipArchiveEntry.getMethod() == 8 && zipArchiveEntry.getSize() == -1) {
            return Zip64Mode.Never;
        }
        return this.zip64Mode;
    }

    private ZipEncoding getEntryEncoding(ZipArchiveEntry zipArchiveEntry) {
        return (this.zipEncoding.canEncode(zipArchiveEntry.getName()) || !this.fallbackToUTF8) ? this.zipEncoding : ZipEncodingHelper.UTF8_ZIP_ENCODING;
    }

    private ByteBuffer getName(ZipArchiveEntry zipArchiveEntry) throws IOException {
        return getEntryEncoding(zipArchiveEntry).encode(zipArchiveEntry.getName());
    }

    private Zip64ExtendedInformationExtraField getZip64Extra(ZipArchiveEntry zipArchiveEntry) {
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            boolean unused = currentEntry.causedUseOfZip64 = !this.hasUsedZip64;
        }
        this.hasUsedZip64 = true;
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) zipArchiveEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (zip64ExtendedInformationExtraField == null) {
            zip64ExtendedInformationExtraField = new Zip64ExtendedInformationExtraField();
        }
        zipArchiveEntry.addAsFirstExtraField(zip64ExtendedInformationExtraField);
        return zip64ExtendedInformationExtraField;
    }

    private boolean handleSizesAndCrc(long j, long j2, Zip64Mode zip64Mode2) throws ZipException {
        if (this.entry.entry.getMethod() == 8) {
            this.entry.entry.setSize(this.entry.bytesRead);
            this.entry.entry.setCompressedSize(j);
            this.entry.entry.setCrc(j2);
            this.def.reset();
        } else if (this.raf != null) {
            this.entry.entry.setSize(j);
            this.entry.entry.setCompressedSize(j);
            this.entry.entry.setCrc(j2);
        } else if (this.entry.entry.getCrc() != j2) {
            throw new ZipException("bad CRC checksum for entry " + this.entry.entry.getName() + ": " + Long.toHexString(this.entry.entry.getCrc()) + " instead of " + Long.toHexString(j2));
        } else if (this.entry.entry.getSize() != j) {
            throw new ZipException("bad size for entry " + this.entry.entry.getName() + ": " + this.entry.entry.getSize() + " instead of " + j);
        }
        boolean z = zip64Mode2 == Zip64Mode.Always || this.entry.entry.getSize() >= 4294967295L || this.entry.entry.getCompressedSize() >= 4294967295L;
        if (!z || zip64Mode2 != Zip64Mode.Never) {
            return z;
        }
        throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
    }

    private void handleZip64Extra(ZipArchiveEntry zipArchiveEntry, long j, boolean z) {
        if (z) {
            Zip64ExtendedInformationExtraField zip64Extra = getZip64Extra(zipArchiveEntry);
            if (zipArchiveEntry.getCompressedSize() >= 4294967295L || zipArchiveEntry.getSize() >= 4294967295L) {
                zip64Extra.setCompressedSize(new ZipEightByteInteger(zipArchiveEntry.getCompressedSize()));
                zip64Extra.setSize(new ZipEightByteInteger(zipArchiveEntry.getSize()));
            } else {
                zip64Extra.setCompressedSize((ZipEightByteInteger) null);
                zip64Extra.setSize((ZipEightByteInteger) null);
            }
            if (j >= 4294967295L) {
                zip64Extra.setRelativeHeaderOffset(new ZipEightByteInteger(j));
            }
            zipArchiveEntry.setExtra();
        }
    }

    private boolean hasZip64Extra(ZipArchiveEntry zipArchiveEntry) {
        return zipArchiveEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID) != null;
    }

    private void rewriteSizesAndCrc(boolean z) throws IOException {
        long filePointer = this.raf.getFilePointer();
        this.raf.seek(this.entry.localDataStart);
        writeOut(ZipLong.getBytes(this.entry.entry.getCrc()));
        if (!hasZip64Extra(this.entry.entry) || !z) {
            writeOut(ZipLong.getBytes(this.entry.entry.getCompressedSize()));
            writeOut(ZipLong.getBytes(this.entry.entry.getSize()));
        } else {
            writeOut(ZipLong.ZIP64_MAGIC.getBytes());
            writeOut(ZipLong.ZIP64_MAGIC.getBytes());
        }
        if (hasZip64Extra(this.entry.entry)) {
            this.raf.seek(this.entry.localDataStart + 12 + 4 + ((long) getName(this.entry.entry).limit()) + 4);
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getSize()));
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getCompressedSize()));
            if (!z) {
                this.raf.seek(this.entry.localDataStart - 10);
                writeOut(ZipShort.getBytes(10));
                this.entry.entry.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
                this.entry.entry.setExtra();
                if (this.entry.causedUseOfZip64) {
                    this.hasUsedZip64 = false;
                }
            }
        }
        this.raf.seek(filePointer);
    }

    private void setDefaults(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getMethod() == -1) {
            zipArchiveEntry.setMethod(this.method);
        }
        if (zipArchiveEntry.getTime() == -1) {
            zipArchiveEntry.setTime(System.currentTimeMillis());
        }
    }

    private boolean shouldAddZip64Extra(ZipArchiveEntry zipArchiveEntry, Zip64Mode zip64Mode2) {
        return zip64Mode2 == Zip64Mode.Always || zipArchiveEntry.getSize() >= 4294967295L || zipArchiveEntry.getCompressedSize() >= 4294967295L || !(zipArchiveEntry.getSize() != -1 || this.raf == null || zip64Mode2 == Zip64Mode.Never);
    }

    private void validateSizeInformation(Zip64Mode zip64Mode2) throws ZipException {
        if (this.entry.entry.getMethod() == 0 && this.raf == null) {
            if (this.entry.entry.getSize() == -1) {
                throw new ZipException("uncompressed size is required for STORED method when not writing to a file");
            } else if (this.entry.entry.getCrc() != -1) {
                this.entry.entry.setCompressedSize(this.entry.entry.getSize());
            } else {
                throw new ZipException("crc checksum is required for STORED method when not writing to a file");
            }
        }
        if ((this.entry.entry.getSize() >= 4294967295L || this.entry.entry.getCompressedSize() >= 4294967295L) && zip64Mode2 == Zip64Mode.Never) {
            throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
        }
    }

    private void writeDeflated(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0 && !this.def.finished()) {
            CurrentEntry.access$314(this.entry, (long) i2);
            if (i2 <= 8192) {
                this.def.setInput(bArr, i, i2);
                deflateUntilInputIsNeeded();
                return;
            }
            int i3 = i2 / 8192;
            for (int i4 = 0; i4 < i3; i4++) {
                this.def.setInput(bArr, (i4 * 8192) + i, 8192);
                deflateUntilInputIsNeeded();
            }
            int i5 = i3 * 8192;
            if (i5 < i2) {
                this.def.setInput(bArr, i + i5, i2 - i5);
                deflateUntilInputIsNeeded();
            }
        }
    }

    private void writeVersionNeededToExtractAndGeneralPurposeBits(int i, boolean z, boolean z2) throws IOException {
        int i2;
        GeneralPurposeBit generalPurposeBit = new GeneralPurposeBit();
        generalPurposeBit.useUTF8ForNames(this.useUTF8Flag || z);
        if (i == 8 && this.raf == null) {
            i2 = 20;
            generalPurposeBit.useDataDescriptor(true);
        } else {
            i2 = 10;
        }
        if (z2) {
            i2 = 45;
        }
        writeOut(ZipShort.getBytes(i2));
        writeOut(generalPurposeBit.encode());
    }

    public boolean canWriteEntryData(ArchiveEntry archiveEntry) {
        if (!(archiveEntry instanceof ZipArchiveEntry)) {
            return false;
        }
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
        if (zipArchiveEntry.getMethod() == ZipMethod.IMPLODING.getCode() || zipArchiveEntry.getMethod() == ZipMethod.UNSHRINKING.getCode() || !ZipUtil.canHandleEntryData(zipArchiveEntry)) {
            return false;
        }
        return true;
    }

    public void close() throws IOException {
        if (!this.finished) {
            finish();
        }
        destroy();
    }

    public void closeArchiveEntry() throws IOException {
        if (!this.finished) {
            CurrentEntry currentEntry = this.entry;
            if (currentEntry != null) {
                if (!currentEntry.hasWritten) {
                    write(EMPTY, 0, 0);
                }
                flushDeflater();
                Zip64Mode effectiveZip64Mode = getEffectiveZip64Mode(this.entry.entry);
                long access$200 = this.written - this.entry.dataStart;
                long value = this.crc.getValue();
                this.crc.reset();
                boolean handleSizesAndCrc = handleSizesAndCrc(access$200, value, effectiveZip64Mode);
                if (this.raf != null) {
                    rewriteSizesAndCrc(handleSizesAndCrc);
                }
                writeDataDescriptor(this.entry.entry);
                this.entry = null;
                return;
            }
            throw new IOException("No current entry to close");
        }
        throw new IOException("Stream has already been finished");
    }

    public ArchiveEntry createArchiveEntry(File file, String str) throws IOException {
        if (!this.finished) {
            return new ZipArchiveEntry(file, str);
        }
        throw new IOException("Stream has already been finished");
    }

    /* access modifiers changed from: protected */
    public final void deflate() throws IOException {
        Deflater deflater = this.def;
        byte[] bArr = this.buf;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            writeOut(this.buf, 0, deflate);
            this.written += (long) deflate;
        }
    }

    /* access modifiers changed from: package-private */
    public void destroy() throws IOException {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public void finish() throws IOException {
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        } else if (this.entry == null) {
            this.cdOffset = this.written;
            for (ZipArchiveEntry writeCentralFileHeader : this.entries) {
                writeCentralFileHeader(writeCentralFileHeader);
            }
            this.cdLength = this.written - this.cdOffset;
            writeZip64CentralDirectory();
            writeCentralDirectoryEnd();
            this.offsets.clear();
            this.entries.clear();
            this.def.end();
            this.finished = true;
        } else {
            throw new IOException("This archive contains unclosed entries.");
        }
    }

    public void flush() throws IOException {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    public boolean isSeekable() {
        return this.raf != null;
    }

    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        if (!this.finished) {
            if (this.entry != null) {
                closeArchiveEntry();
            }
            this.entry = new CurrentEntry((ZipArchiveEntry) archiveEntry);
            this.entries.add(this.entry.entry);
            setDefaults(this.entry.entry);
            Zip64Mode effectiveZip64Mode = getEffectiveZip64Mode(this.entry.entry);
            validateSizeInformation(effectiveZip64Mode);
            if (shouldAddZip64Extra(this.entry.entry, effectiveZip64Mode)) {
                Zip64ExtendedInformationExtraField zip64Extra = getZip64Extra(this.entry.entry);
                ZipEightByteInteger zipEightByteInteger = ZipEightByteInteger.ZERO;
                if (this.entry.entry.getMethod() == 0 && this.entry.entry.getSize() != -1) {
                    zipEightByteInteger = new ZipEightByteInteger(this.entry.entry.getSize());
                }
                zip64Extra.setSize(zipEightByteInteger);
                zip64Extra.setCompressedSize(zipEightByteInteger);
                this.entry.entry.setExtra();
            }
            if (this.entry.entry.getMethod() == 8 && this.hasCompressionLevelChanged) {
                this.def.setLevel(this.level);
                this.hasCompressionLevelChanged = false;
            }
            writeLocalFileHeader(this.entry.entry);
            return;
        }
        throw new IOException("Stream has already been finished");
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCreateUnicodeExtraFields(UnicodeExtraFieldPolicy unicodeExtraFieldPolicy) {
        this.createUnicodeExtraFields = unicodeExtraFieldPolicy;
    }

    public void setEncoding(String str) {
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        if (this.useUTF8Flag && !ZipEncodingHelper.isUTF8(str)) {
            this.useUTF8Flag = false;
        }
    }

    public void setFallbackToUTF8(boolean z) {
        this.fallbackToUTF8 = z;
    }

    public void setLevel(int i) {
        if (i < -1 || i > 9) {
            throw new IllegalArgumentException("Invalid compression level: " + i);
        }
        this.hasCompressionLevelChanged = this.level != i;
        this.level = i;
    }

    public void setMethod(int i) {
        this.method = i;
    }

    public void setUseLanguageEncodingFlag(boolean z) {
        this.useUTF8Flag = z && ZipEncodingHelper.isUTF8(this.encoding);
    }

    public void setUseZip64(Zip64Mode zip64Mode2) {
        this.zip64Mode = zip64Mode2;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            ZipUtil.checkRequestedFeatures(currentEntry.entry);
            boolean unused = this.entry.hasWritten = true;
            if (this.entry.entry.getMethod() == 8) {
                writeDeflated(bArr, i, i2);
            } else {
                writeOut(bArr, i, i2);
                this.written += (long) i2;
            }
            this.crc.update(bArr, i, i2);
            count(i2);
            return;
        }
        throw new IllegalStateException("No current entry");
    }

    /* access modifiers changed from: protected */
    public void writeCentralDirectoryEnd() throws IOException {
        writeOut(EOCD_SIG);
        writeOut(ZERO);
        writeOut(ZERO);
        int size = this.entries.size();
        if (size > 65535 && this.zip64Mode == Zip64Mode.Never) {
            throw new Zip64RequiredException("archive contains more than 65535 entries.");
        } else if (this.cdOffset <= 4294967295L || this.zip64Mode != Zip64Mode.Never) {
            byte[] bytes = ZipShort.getBytes(Math.min(size, 65535));
            writeOut(bytes);
            writeOut(bytes);
            writeOut(ZipLong.getBytes(Math.min(this.cdLength, 4294967295L)));
            writeOut(ZipLong.getBytes(Math.min(this.cdOffset, 4294967295L)));
            ByteBuffer encode = this.zipEncoding.encode(this.comment);
            writeOut(ZipShort.getBytes(encode.limit()));
            writeOut(encode.array(), encode.arrayOffset(), encode.limit() - encode.position());
        } else {
            throw new Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
        }
    }

    /* access modifiers changed from: protected */
    public void writeCentralFileHeader(ZipArchiveEntry zipArchiveEntry) throws IOException {
        writeOut(CFH_SIG);
        this.written += 4;
        long longValue = this.offsets.get(zipArchiveEntry).longValue();
        boolean z = false;
        boolean z2 = hasZip64Extra(zipArchiveEntry) || zipArchiveEntry.getCompressedSize() >= 4294967295L || zipArchiveEntry.getSize() >= 4294967295L || longValue >= 4294967295L;
        if (!z2 || this.zip64Mode != Zip64Mode.Never) {
            handleZip64Extra(zipArchiveEntry, longValue, z2);
            writeOut(ZipShort.getBytes((zipArchiveEntry.getPlatform() << 8) | (!this.hasUsedZip64 ? 20 : 45)));
            this.written += 2;
            int method2 = zipArchiveEntry.getMethod();
            if (!this.zipEncoding.canEncode(zipArchiveEntry.getName()) && this.fallbackToUTF8) {
                z = true;
            }
            writeVersionNeededToExtractAndGeneralPurposeBits(method2, z, z2);
            this.written += 4;
            writeOut(ZipShort.getBytes(method2));
            this.written += 2;
            writeOut(ZipUtil.toDosTime(zipArchiveEntry.getTime()));
            this.written += 4;
            writeOut(ZipLong.getBytes(zipArchiveEntry.getCrc()));
            if (zipArchiveEntry.getCompressedSize() >= 4294967295L || zipArchiveEntry.getSize() >= 4294967295L) {
                writeOut(ZipLong.ZIP64_MAGIC.getBytes());
                writeOut(ZipLong.ZIP64_MAGIC.getBytes());
            } else {
                writeOut(ZipLong.getBytes(zipArchiveEntry.getCompressedSize()));
                writeOut(ZipLong.getBytes(zipArchiveEntry.getSize()));
            }
            this.written += 12;
            ByteBuffer name = getName(zipArchiveEntry);
            writeOut(ZipShort.getBytes(name.limit()));
            this.written += 2;
            byte[] centralDirectoryExtra = zipArchiveEntry.getCentralDirectoryExtra();
            writeOut(ZipShort.getBytes(centralDirectoryExtra.length));
            this.written += 2;
            String comment2 = zipArchiveEntry.getComment();
            if (comment2 == null) {
                comment2 = "";
            }
            ByteBuffer encode = getEntryEncoding(zipArchiveEntry).encode(comment2);
            writeOut(ZipShort.getBytes(encode.limit()));
            this.written += 2;
            writeOut(ZERO);
            this.written += 2;
            writeOut(ZipShort.getBytes(zipArchiveEntry.getInternalAttributes()));
            this.written += 2;
            writeOut(ZipLong.getBytes(zipArchiveEntry.getExternalAttributes()));
            this.written += 4;
            writeOut(ZipLong.getBytes(Math.min(longValue, 4294967295L)));
            this.written += 4;
            writeOut(name.array(), name.arrayOffset(), name.limit() - name.position());
            this.written += (long) name.limit();
            writeOut(centralDirectoryExtra);
            this.written += (long) centralDirectoryExtra.length;
            writeOut(encode.array(), encode.arrayOffset(), encode.limit() - encode.position());
            this.written += (long) encode.limit();
            return;
        }
        throw new Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
    }

    /* access modifiers changed from: protected */
    public void writeDataDescriptor(ZipArchiveEntry zipArchiveEntry) throws IOException {
        if (zipArchiveEntry.getMethod() == 8 && this.raf == null) {
            writeOut(DD_SIG);
            writeOut(ZipLong.getBytes(zipArchiveEntry.getCrc()));
            int i = 4;
            if (!hasZip64Extra(zipArchiveEntry)) {
                writeOut(ZipLong.getBytes(zipArchiveEntry.getCompressedSize()));
                writeOut(ZipLong.getBytes(zipArchiveEntry.getSize()));
            } else {
                writeOut(ZipEightByteInteger.getBytes(zipArchiveEntry.getCompressedSize()));
                writeOut(ZipEightByteInteger.getBytes(zipArchiveEntry.getSize()));
                i = 8;
            }
            this.written += (long) ((i * 2) + 8);
        }
    }

    /* access modifiers changed from: protected */
    public void writeLocalFileHeader(ZipArchiveEntry zipArchiveEntry) throws IOException {
        boolean canEncode = this.zipEncoding.canEncode(zipArchiveEntry.getName());
        ByteBuffer name = getName(zipArchiveEntry);
        if (this.createUnicodeExtraFields != UnicodeExtraFieldPolicy.NEVER) {
            addUnicodeExtraFields(zipArchiveEntry, canEncode, name);
        }
        this.offsets.put(zipArchiveEntry, Long.valueOf(this.written));
        writeOut(LFH_SIG);
        this.written += 4;
        int method2 = zipArchiveEntry.getMethod();
        writeVersionNeededToExtractAndGeneralPurposeBits(method2, !canEncode && this.fallbackToUTF8, hasZip64Extra(zipArchiveEntry));
        this.written += 4;
        writeOut(ZipShort.getBytes(method2));
        this.written += 2;
        writeOut(ZipUtil.toDosTime(zipArchiveEntry.getTime()));
        this.written += 4;
        long unused = this.entry.localDataStart = this.written;
        if (method2 == 8 || this.raf != null) {
            writeOut(LZERO);
            if (hasZip64Extra(this.entry.entry)) {
                writeOut(ZipLong.ZIP64_MAGIC.getBytes());
                writeOut(ZipLong.ZIP64_MAGIC.getBytes());
            } else {
                writeOut(LZERO);
                writeOut(LZERO);
            }
        } else {
            writeOut(ZipLong.getBytes(zipArchiveEntry.getCrc()));
            byte[] bytes = ZipLong.ZIP64_MAGIC.getBytes();
            if (!hasZip64Extra(zipArchiveEntry)) {
                bytes = ZipLong.getBytes(zipArchiveEntry.getSize());
            }
            writeOut(bytes);
            writeOut(bytes);
        }
        this.written += 12;
        writeOut(ZipShort.getBytes(name.limit()));
        this.written += 2;
        byte[] localFileDataExtra = zipArchiveEntry.getLocalFileDataExtra();
        writeOut(ZipShort.getBytes(localFileDataExtra.length));
        this.written += 2;
        writeOut(name.array(), name.arrayOffset(), name.limit() - name.position());
        this.written += (long) name.limit();
        writeOut(localFileDataExtra);
        this.written += (long) localFileDataExtra.length;
        long unused2 = this.entry.dataStart = this.written;
    }

    /* access modifiers changed from: protected */
    public final void writeOut(byte[] bArr) throws IOException {
        writeOut(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: protected */
    public void writeZip64CentralDirectory() throws IOException {
        if (this.zip64Mode != Zip64Mode.Never) {
            if (!this.hasUsedZip64 && (this.cdOffset >= 4294967295L || this.cdLength >= 4294967295L || this.entries.size() >= 65535)) {
                this.hasUsedZip64 = true;
            }
            if (this.hasUsedZip64) {
                long j = this.written;
                writeOut(ZIP64_EOCD_SIG);
                writeOut(ZipEightByteInteger.getBytes(44));
                writeOut(ZipShort.getBytes(45));
                writeOut(ZipShort.getBytes(45));
                writeOut(LZERO);
                writeOut(LZERO);
                byte[] bytes = ZipEightByteInteger.getBytes((long) this.entries.size());
                writeOut(bytes);
                writeOut(bytes);
                writeOut(ZipEightByteInteger.getBytes(this.cdLength));
                writeOut(ZipEightByteInteger.getBytes(this.cdOffset));
                writeOut(ZIP64_EOCD_LOC_SIG);
                writeOut(LZERO);
                writeOut(ZipEightByteInteger.getBytes(j));
                writeOut(ONE);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void writeOut(byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            randomAccessFile.write(bArr, i, i2);
        } else {
            this.out.write(bArr, i, i2);
        }
    }

    public ZipArchiveOutputStream(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileOutputStream fileOutputStream = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile.setLength(0);
            } catch (IOException unused) {
            }
        } catch (IOException unused2) {
            randomAccessFile = null;
            IOUtils.closeQuietly(randomAccessFile);
            randomAccessFile = null;
            fileOutputStream = new FileOutputStream(file);
            this.out = fileOutputStream;
            this.raf = randomAccessFile;
        }
        this.out = fileOutputStream;
        this.raf = randomAccessFile;
    }
}
