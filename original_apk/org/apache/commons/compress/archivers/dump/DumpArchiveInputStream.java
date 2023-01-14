package org.apache.commons.compress.archivers.dump;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;

public class DumpArchiveInputStream extends ArchiveInputStream {
    private DumpArchiveEntry active;
    private byte[] blockBuffer;
    private final ZipEncoding encoding;
    private long entryOffset;
    private long entrySize;
    private long filepos;
    private boolean hasHitEOF;
    private boolean isClosed;
    private final Map<Integer, Dirent> names;
    private final Map<Integer, DumpArchiveEntry> pending;
    private Queue<DumpArchiveEntry> queue;
    protected TapeInputStream raw;
    private final byte[] readBuf;
    private int readIdx;
    private int recordOffset;
    private DumpArchiveSummary summary;

    public DumpArchiveInputStream(InputStream inputStream) throws ArchiveException {
        this(inputStream, (String) null);
    }

    private String getPath(DumpArchiveEntry dumpArchiveEntry) {
        Stack stack = new Stack();
        int ino = dumpArchiveEntry.getIno();
        while (true) {
            if (!this.names.containsKey(Integer.valueOf(ino))) {
                stack.clear();
                break;
            }
            Dirent dirent = this.names.get(Integer.valueOf(ino));
            stack.push(dirent.getName());
            if (dirent.getIno() == dirent.getParentIno()) {
                break;
            }
            ino = dirent.getParentIno();
        }
        if (stack.isEmpty()) {
            this.pending.put(Integer.valueOf(dumpArchiveEntry.getIno()), dumpArchiveEntry);
            return null;
        }
        StringBuilder sb = new StringBuilder((String) stack.pop());
        while (!stack.isEmpty()) {
            sb.append('/');
            sb.append((String) stack.pop());
        }
        return sb.toString();
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < 32) {
            return false;
        }
        if (i >= 1024) {
            return DumpArchiveUtil.verify(bArr);
        }
        if (60012 == DumpArchiveUtil.convert32(bArr, 24)) {
            return true;
        }
        return false;
    }

    private void readBITS() throws IOException {
        byte[] readRecord = this.raw.readRecord();
        if (DumpArchiveUtil.verify(readRecord)) {
            this.active = DumpArchiveEntry.parse(readRecord);
            if (DumpArchiveConstants.SEGMENT_TYPE.BITS != this.active.getHeaderType()) {
                throw new InvalidFormatException();
            } else if (this.raw.skip((long) (this.active.getHeaderCount() * 1024)) != -1) {
                this.readIdx = this.active.getHeaderCount();
            } else {
                throw new EOFException();
            }
        } else {
            throw new InvalidFormatException();
        }
    }

    private void readCLRI() throws IOException {
        byte[] readRecord = this.raw.readRecord();
        if (DumpArchiveUtil.verify(readRecord)) {
            this.active = DumpArchiveEntry.parse(readRecord);
            if (DumpArchiveConstants.SEGMENT_TYPE.CLRI != this.active.getHeaderType()) {
                throw new InvalidFormatException();
            } else if (this.raw.skip((long) (this.active.getHeaderCount() * 1024)) != -1) {
                this.readIdx = this.active.getHeaderCount();
            } else {
                throw new EOFException();
            }
        } else {
            throw new InvalidFormatException();
        }
    }

    private void readDirectoryEntry(DumpArchiveEntry dumpArchiveEntry) throws IOException {
        long entrySize2 = dumpArchiveEntry.getEntrySize();
        boolean z = true;
        while (true) {
            if (z || DumpArchiveConstants.SEGMENT_TYPE.ADDR == dumpArchiveEntry.getHeaderType()) {
                if (!z) {
                    this.raw.readRecord();
                }
                if (!this.names.containsKey(Integer.valueOf(dumpArchiveEntry.getIno())) && DumpArchiveConstants.SEGMENT_TYPE.INODE == dumpArchiveEntry.getHeaderType()) {
                    this.pending.put(Integer.valueOf(dumpArchiveEntry.getIno()), dumpArchiveEntry);
                }
                int headerCount = dumpArchiveEntry.getHeaderCount() * 1024;
                if (this.blockBuffer.length < headerCount) {
                    this.blockBuffer = new byte[headerCount];
                }
                if (this.raw.read(this.blockBuffer, 0, headerCount) == headerCount) {
                    int i = 0;
                    while (i < headerCount - 8 && ((long) i) < entrySize2 - 8) {
                        int convert32 = DumpArchiveUtil.convert32(this.blockBuffer, i);
                        int convert16 = DumpArchiveUtil.convert16(this.blockBuffer, i + 4);
                        byte[] bArr = this.blockBuffer;
                        byte b2 = bArr[i + 6];
                        String decode = DumpArchiveUtil.decode(this.encoding, bArr, i + 8, bArr[i + 7]);
                        if (!".".equals(decode) && !"..".equals(decode)) {
                            this.names.put(Integer.valueOf(convert32), new Dirent(convert32, dumpArchiveEntry.getIno(), b2, decode));
                            for (Map.Entry next : this.pending.entrySet()) {
                                String path = getPath((DumpArchiveEntry) next.getValue());
                                if (path != null) {
                                    ((DumpArchiveEntry) next.getValue()).setName(path);
                                    ((DumpArchiveEntry) next.getValue()).setSimpleName(this.names.get(next.getKey()).getName());
                                    this.queue.add(next.getValue());
                                }
                            }
                            for (DumpArchiveEntry ino : this.queue) {
                                this.pending.remove(Integer.valueOf(ino.getIno()));
                            }
                        }
                        i += convert16;
                    }
                    byte[] peek = this.raw.peek();
                    if (DumpArchiveUtil.verify(peek)) {
                        dumpArchiveEntry = DumpArchiveEntry.parse(peek);
                        entrySize2 -= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                        z = false;
                    } else {
                        throw new InvalidFormatException();
                    }
                } else {
                    throw new EOFException();
                }
            } else {
                return;
            }
        }
    }

    public void close() throws IOException {
        if (!this.isClosed) {
            this.isClosed = true;
            this.raw.close();
        }
    }

    public long getBytesRead() {
        return this.raw.getBytesRead();
    }

    @Deprecated
    public int getCount() {
        return (int) getBytesRead();
    }

    public DumpArchiveEntry getNextDumpEntry() throws IOException {
        return getNextEntry();
    }

    public DumpArchiveSummary getSummary() {
        return this.summary;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.hasHitEOF || this.isClosed) {
            return -1;
        }
        long j = this.entryOffset;
        long j2 = this.entrySize;
        if (j >= j2) {
            return -1;
        }
        if (this.active != null) {
            if (((long) i2) + j > j2) {
                i2 = (int) (j2 - j);
            }
            int i3 = i;
            int i4 = 0;
            while (i2 > 0) {
                byte[] bArr2 = this.readBuf;
                int length = bArr2.length;
                int i5 = this.recordOffset;
                int length2 = i2 > length - i5 ? bArr2.length - i5 : i2;
                int i6 = this.recordOffset;
                int i7 = i6 + length2;
                byte[] bArr3 = this.readBuf;
                if (i7 <= bArr3.length) {
                    System.arraycopy(bArr3, i6, bArr, i3, length2);
                    i4 += length2;
                    this.recordOffset += length2;
                    i2 -= length2;
                    i3 += length2;
                }
                if (i2 > 0) {
                    if (this.readIdx >= 512) {
                        byte[] readRecord = this.raw.readRecord();
                        if (DumpArchiveUtil.verify(readRecord)) {
                            this.active = DumpArchiveEntry.parse(readRecord);
                            this.readIdx = 0;
                        } else {
                            throw new InvalidFormatException();
                        }
                    }
                    DumpArchiveEntry dumpArchiveEntry = this.active;
                    int i8 = this.readIdx;
                    this.readIdx = i8 + 1;
                    if (!dumpArchiveEntry.isSparseRecord(i8)) {
                        TapeInputStream tapeInputStream = this.raw;
                        byte[] bArr4 = this.readBuf;
                        if (tapeInputStream.read(bArr4, 0, bArr4.length) != this.readBuf.length) {
                            throw new EOFException();
                        }
                    } else {
                        Arrays.fill(this.readBuf, (byte) 0);
                    }
                    this.recordOffset = 0;
                }
            }
            this.entryOffset += (long) i4;
            return i4;
        }
        throw new IllegalStateException("No current dump entry");
    }

    public DumpArchiveInputStream(InputStream inputStream, String str) throws ArchiveException {
        this.readBuf = new byte[1024];
        this.names = new HashMap();
        this.pending = new HashMap();
        this.raw = new TapeInputStream(inputStream);
        this.hasHitEOF = false;
        this.encoding = ZipEncodingHelper.getZipEncoding(str);
        try {
            byte[] readRecord = this.raw.readRecord();
            if (DumpArchiveUtil.verify(readRecord)) {
                this.summary = new DumpArchiveSummary(readRecord, this.encoding);
                this.raw.resetBlockSize(this.summary.getNTRec(), this.summary.isCompressed());
                this.blockBuffer = new byte[CpioConstants.C_ISFIFO];
                readCLRI();
                readBITS();
                this.names.put(2, new Dirent(2, 2, 4, "."));
                this.queue = new PriorityQueue(10, new Comparator<DumpArchiveEntry>() {
                    public int compare(DumpArchiveEntry dumpArchiveEntry, DumpArchiveEntry dumpArchiveEntry2) {
                        if (dumpArchiveEntry.getOriginalName() == null || dumpArchiveEntry2.getOriginalName() == null) {
                            return Integer.MAX_VALUE;
                        }
                        return dumpArchiveEntry.getOriginalName().compareTo(dumpArchiveEntry2.getOriginalName());
                    }
                });
                return;
            }
            throw new UnrecognizedFormatException();
        } catch (IOException e) {
            throw new ArchiveException(e.getMessage(), e);
        }
    }

    public DumpArchiveEntry getNextEntry() throws IOException {
        if (!this.queue.isEmpty()) {
            return this.queue.remove();
        }
        DumpArchiveEntry dumpArchiveEntry = null;
        String str = null;
        while (dumpArchiveEntry == null) {
            if (this.hasHitEOF) {
                return null;
            }
            while (this.readIdx < this.active.getHeaderCount()) {
                DumpArchiveEntry dumpArchiveEntry2 = this.active;
                int i = this.readIdx;
                this.readIdx = i + 1;
                if (!dumpArchiveEntry2.isSparseRecord(i) && this.raw.skip(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) == -1) {
                    throw new EOFException();
                }
            }
            this.readIdx = 0;
            this.filepos = this.raw.getBytesRead();
            byte[] readRecord = this.raw.readRecord();
            if (DumpArchiveUtil.verify(readRecord)) {
                this.active = DumpArchiveEntry.parse(readRecord);
                while (DumpArchiveConstants.SEGMENT_TYPE.ADDR == this.active.getHeaderType()) {
                    if (this.raw.skip((long) ((this.active.getHeaderCount() - this.active.getHeaderHoles()) * 1024)) != -1) {
                        this.filepos = this.raw.getBytesRead();
                        byte[] readRecord2 = this.raw.readRecord();
                        if (DumpArchiveUtil.verify(readRecord2)) {
                            this.active = DumpArchiveEntry.parse(readRecord2);
                        } else {
                            throw new InvalidFormatException();
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                if (DumpArchiveConstants.SEGMENT_TYPE.END == this.active.getHeaderType()) {
                    this.hasHitEOF = true;
                    return null;
                }
                DumpArchiveEntry dumpArchiveEntry3 = this.active;
                if (dumpArchiveEntry3.isDirectory()) {
                    readDirectoryEntry(this.active);
                    this.entryOffset = 0;
                    this.entrySize = 0;
                    this.readIdx = this.active.getHeaderCount();
                } else {
                    this.entryOffset = 0;
                    this.entrySize = this.active.getEntrySize();
                    this.readIdx = 0;
                }
                this.recordOffset = this.readBuf.length;
                String path = getPath(dumpArchiveEntry3);
                if (path == null) {
                    dumpArchiveEntry3 = null;
                }
                DumpArchiveEntry dumpArchiveEntry4 = dumpArchiveEntry3;
                str = path;
                dumpArchiveEntry = dumpArchiveEntry4;
            } else {
                throw new InvalidFormatException();
            }
        }
        dumpArchiveEntry.setName(str);
        dumpArchiveEntry.setSimpleName(this.names.get(Integer.valueOf(dumpArchiveEntry.getIno())).getName());
        dumpArchiveEntry.setOffset(this.filepos);
        return dumpArchiveEntry;
    }
}
