package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.CountingOutputStream;

public class SevenZOutputFile implements Closeable {
    private CountingOutputStream[] additionalCountingStreams;
    private final Map<SevenZArchiveEntry, long[]> additionalSizes = new HashMap();
    /* access modifiers changed from: private */
    public final CRC32 compressedCrc32 = new CRC32();
    private Iterable<? extends SevenZMethodConfiguration> contentMethods = Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.LZMA2));
    /* access modifiers changed from: private */
    public final CRC32 crc32 = new CRC32();
    private CountingOutputStream currentOutputStream;
    /* access modifiers changed from: private */
    public final RandomAccessFile file;
    private long fileBytesWritten = 0;
    private final List<SevenZArchiveEntry> files = new ArrayList();
    private boolean finished = false;
    private int numNonEmptyStreams = 0;

    public SevenZOutputFile(File file2) throws IOException {
        this.file = new RandomAccessFile(file2, "rw");
        this.file.seek(32);
    }

    static /* synthetic */ long access$408(SevenZOutputFile sevenZOutputFile) {
        long j = sevenZOutputFile.fileBytesWritten;
        sevenZOutputFile.fileBytesWritten = 1 + j;
        return j;
    }

    static /* synthetic */ long access$414(SevenZOutputFile sevenZOutputFile, long j) {
        long j2 = sevenZOutputFile.fileBytesWritten + j;
        sevenZOutputFile.fileBytesWritten = j2;
        return j2;
    }

    private Iterable<? extends SevenZMethodConfiguration> getContentMethods(SevenZArchiveEntry sevenZArchiveEntry) {
        Iterable<? extends SevenZMethodConfiguration> contentMethods2 = sevenZArchiveEntry.getContentMethods();
        return contentMethods2 == null ? this.contentMethods : contentMethods2;
    }

    private OutputStream getCurrentOutputStream() throws IOException {
        if (this.currentOutputStream == null) {
            this.currentOutputStream = setupFileOutputStream();
        }
        return this.currentOutputStream;
    }

    private static <T> Iterable<T> reverse(Iterable<T> iterable) {
        LinkedList linkedList = new LinkedList();
        for (T addFirst : iterable) {
            linkedList.addFirst(addFirst);
        }
        return linkedList;
    }

    private CountingOutputStream setupFileOutputStream() throws IOException {
        if (!this.files.isEmpty()) {
            CountingOutputStream outputStreamWrapper = new OutputStreamWrapper();
            ArrayList arrayList = new ArrayList();
            List<SevenZArchiveEntry> list = this.files;
            boolean z = true;
            for (SevenZMethodConfiguration sevenZMethodConfiguration : getContentMethods(list.get(list.size() - 1))) {
                if (!z) {
                    CountingOutputStream countingOutputStream = new CountingOutputStream(outputStreamWrapper);
                    arrayList.add(countingOutputStream);
                    outputStreamWrapper = countingOutputStream;
                }
                outputStreamWrapper = Coders.addEncoder(outputStreamWrapper, sevenZMethodConfiguration.getMethod(), sevenZMethodConfiguration.getOptions());
                z = false;
            }
            if (!arrayList.isEmpty()) {
                this.additionalCountingStreams = (CountingOutputStream[]) arrayList.toArray(new CountingOutputStream[arrayList.size()]);
            }
            return new CountingOutputStream(outputStreamWrapper) {
                public void write(int i) throws IOException {
                    super.write(i);
                    SevenZOutputFile.this.crc32.update(i);
                }

                public void write(byte[] bArr) throws IOException {
                    super.write(bArr);
                    SevenZOutputFile.this.crc32.update(bArr);
                }

                public void write(byte[] bArr, int i, int i2) throws IOException {
                    super.write(bArr, i, i2);
                    SevenZOutputFile.this.crc32.update(bArr, i, i2);
                }
            };
        }
        throw new IllegalStateException("No current 7z entry");
    }

    private void writeBits(DataOutput dataOutput, BitSet bitSet, int i) throws IOException {
        int i2 = 7;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 |= (bitSet.get(i4) ? 1 : 0) << i2;
            i2--;
            if (i2 < 0) {
                dataOutput.write(i3);
                i2 = 7;
                i3 = 0;
            }
        }
        if (i2 != 7) {
            dataOutput.write(i3);
        }
    }

    private void writeFileATimes(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (SevenZArchiveEntry hasAccessDate : this.files) {
            if (hasAccessDate.getHasAccessDate()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(19);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.files.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.files.size());
                for (int i2 = 0; i2 < this.files.size(); i2++) {
                    bitSet.set(i2, this.files.get(i2).getHasAccessDate());
                }
                writeBits(dataOutputStream, bitSet, this.files.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (SevenZArchiveEntry next : this.files) {
                if (next.getHasAccessDate()) {
                    dataOutputStream.writeLong(Long.reverseBytes(SevenZArchiveEntry.javaTimeToNtfsTime(next.getAccessDate())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileAntiItems(DataOutput dataOutput) throws IOException {
        BitSet bitSet = new BitSet(0);
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < this.files.size(); i2++) {
            if (!this.files.get(i2).hasStream()) {
                boolean isAntiItem = this.files.get(i2).isAntiItem();
                bitSet.set(i, isAntiItem);
                z |= isAntiItem;
                i++;
            }
        }
        if (z) {
            dataOutput.write(16);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            writeBits(dataOutputStream, bitSet, i);
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileCTimes(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (SevenZArchiveEntry hasCreationDate : this.files) {
            if (hasCreationDate.getHasCreationDate()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(18);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.files.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.files.size());
                for (int i2 = 0; i2 < this.files.size(); i2++) {
                    bitSet.set(i2, this.files.get(i2).getHasCreationDate());
                }
                writeBits(dataOutputStream, bitSet, this.files.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (SevenZArchiveEntry next : this.files) {
                if (next.getHasCreationDate()) {
                    dataOutputStream.writeLong(Long.reverseBytes(SevenZArchiveEntry.javaTimeToNtfsTime(next.getCreationDate())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileEmptyFiles(DataOutput dataOutput) throws IOException {
        BitSet bitSet = new BitSet(0);
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < this.files.size(); i2++) {
            if (!this.files.get(i2).hasStream()) {
                boolean isDirectory = this.files.get(i2).isDirectory();
                bitSet.set(i, !isDirectory);
                z |= !isDirectory;
                i++;
            }
        }
        if (z) {
            dataOutput.write(15);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            writeBits(dataOutputStream, bitSet, i);
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileEmptyStreams(DataOutput dataOutput) throws IOException {
        int i;
        boolean z;
        Iterator<SevenZArchiveEntry> it = this.files.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().hasStream()) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            dataOutput.write(14);
            BitSet bitSet = new BitSet(this.files.size());
            for (i = 0; i < this.files.size(); i++) {
                bitSet.set(i, !this.files.get(i).hasStream());
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            writeBits(dataOutputStream, bitSet, this.files.size());
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileMTimes(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (SevenZArchiveEntry hasLastModifiedDate : this.files) {
            if (hasLastModifiedDate.getHasLastModifiedDate()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(20);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.files.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.files.size());
                for (int i2 = 0; i2 < this.files.size(); i2++) {
                    bitSet.set(i2, this.files.get(i2).getHasLastModifiedDate());
                }
                writeBits(dataOutputStream, bitSet, this.files.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (SevenZArchiveEntry next : this.files) {
                if (next.getHasLastModifiedDate()) {
                    dataOutputStream.writeLong(Long.reverseBytes(SevenZArchiveEntry.javaTimeToNtfsTime(next.getLastModifiedDate())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileNames(DataOutput dataOutput) throws IOException {
        dataOutput.write(17);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.write(0);
        for (SevenZArchiveEntry name : this.files) {
            dataOutputStream.write(name.getName().getBytes(CharsetNames.UTF_16LE));
            dataOutputStream.writeShort(0);
        }
        dataOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        writeUint64(dataOutput, (long) byteArray.length);
        dataOutput.write(byteArray);
    }

    private void writeFileWindowsAttributes(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (SevenZArchiveEntry hasWindowsAttributes : this.files) {
            if (hasWindowsAttributes.getHasWindowsAttributes()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(21);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.files.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.files.size());
                for (int i2 = 0; i2 < this.files.size(); i2++) {
                    bitSet.set(i2, this.files.get(i2).getHasWindowsAttributes());
                }
                writeBits(dataOutputStream, bitSet, this.files.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (SevenZArchiveEntry next : this.files) {
                if (next.getHasWindowsAttributes()) {
                    dataOutputStream.writeInt(Integer.reverseBytes(next.getWindowsAttributes()));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFilesInfo(DataOutput dataOutput) throws IOException {
        dataOutput.write(5);
        writeUint64(dataOutput, (long) this.files.size());
        writeFileEmptyStreams(dataOutput);
        writeFileEmptyFiles(dataOutput);
        writeFileAntiItems(dataOutput);
        writeFileNames(dataOutput);
        writeFileCTimes(dataOutput);
        writeFileATimes(dataOutput);
        writeFileMTimes(dataOutput);
        writeFileWindowsAttributes(dataOutput);
        dataOutput.write(0);
    }

    private void writeFolder(DataOutput dataOutput, SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        for (SevenZMethodConfiguration writeSingleCodec : getContentMethods(sevenZArchiveEntry)) {
            i2++;
            writeSingleCodec(writeSingleCodec, byteArrayOutputStream);
        }
        writeUint64(dataOutput, (long) i2);
        dataOutput.write(byteArrayOutputStream.toByteArray());
        while (i < i2 - 1) {
            int i3 = i + 1;
            writeUint64(dataOutput, (long) i3);
            writeUint64(dataOutput, (long) i);
            i = i3;
        }
    }

    private void writeHeader(DataOutput dataOutput) throws IOException {
        dataOutput.write(1);
        dataOutput.write(4);
        writeStreamsInfo(dataOutput);
        writeFilesInfo(dataOutput);
        dataOutput.write(0);
    }

    private void writePackInfo(DataOutput dataOutput) throws IOException {
        dataOutput.write(6);
        writeUint64(dataOutput, 0);
        writeUint64(dataOutput, ((long) this.numNonEmptyStreams) & 4294967295L);
        dataOutput.write(9);
        for (SevenZArchiveEntry next : this.files) {
            if (next.hasStream()) {
                writeUint64(dataOutput, next.getCompressedSize());
            }
        }
        dataOutput.write(10);
        dataOutput.write(1);
        for (SevenZArchiveEntry next2 : this.files) {
            if (next2.hasStream()) {
                dataOutput.writeInt(Integer.reverseBytes((int) next2.getCompressedCrcValue()));
            }
        }
        dataOutput.write(0);
    }

    private void writeSingleCodec(SevenZMethodConfiguration sevenZMethodConfiguration, OutputStream outputStream) throws IOException {
        byte[] id = sevenZMethodConfiguration.getMethod().getId();
        byte[] optionsAsProperties = Coders.findByMethod(sevenZMethodConfiguration.getMethod()).getOptionsAsProperties(sevenZMethodConfiguration.getOptions());
        int length = id.length;
        if (optionsAsProperties.length > 0) {
            length |= 32;
        }
        outputStream.write(length);
        outputStream.write(id);
        if (optionsAsProperties.length > 0) {
            outputStream.write(optionsAsProperties.length);
            outputStream.write(optionsAsProperties);
        }
    }

    private void writeStreamsInfo(DataOutput dataOutput) throws IOException {
        if (this.numNonEmptyStreams > 0) {
            writePackInfo(dataOutput);
            writeUnpackInfo(dataOutput);
        }
        writeSubStreamsInfo(dataOutput);
        dataOutput.write(0);
    }

    private void writeSubStreamsInfo(DataOutput dataOutput) throws IOException {
        dataOutput.write(8);
        dataOutput.write(0);
    }

    private void writeUint64(DataOutput dataOutput, long j) throws IOException {
        int i = 0;
        int i2 = 0;
        int i3 = CpioConstants.C_IWUSR;
        while (true) {
            if (i >= 8) {
                break;
            }
            int i4 = i + 1;
            if (j < (1 << (i4 * 7))) {
                i2 = (int) (((long) i2) | (j >>> (i * 8)));
                break;
            }
            i2 |= i3;
            i3 >>>= 1;
            i = i4;
        }
        dataOutput.write(i2);
        while (i > 0) {
            dataOutput.write((int) (255 & j));
            j >>>= 8;
            i--;
        }
    }

    private void writeUnpackInfo(DataOutput dataOutput) throws IOException {
        dataOutput.write(7);
        dataOutput.write(11);
        writeUint64(dataOutput, (long) this.numNonEmptyStreams);
        dataOutput.write(0);
        for (SevenZArchiveEntry next : this.files) {
            if (next.hasStream()) {
                writeFolder(dataOutput, next);
            }
        }
        dataOutput.write(12);
        for (SevenZArchiveEntry next2 : this.files) {
            if (next2.hasStream()) {
                long[] jArr = this.additionalSizes.get(next2);
                if (jArr != null) {
                    for (long writeUint64 : jArr) {
                        writeUint64(dataOutput, writeUint64);
                    }
                }
                writeUint64(dataOutput, next2.getSize());
            }
        }
        dataOutput.write(10);
        dataOutput.write(1);
        for (SevenZArchiveEntry next3 : this.files) {
            if (next3.hasStream()) {
                dataOutput.writeInt(Integer.reverseBytes((int) next3.getCrcValue()));
            }
        }
        dataOutput.write(0);
    }

    public void close() throws IOException {
        if (!this.finished) {
            finish();
        }
        this.file.close();
    }

    public void closeArchiveEntry() throws IOException {
        CountingOutputStream countingOutputStream = this.currentOutputStream;
        if (countingOutputStream != null) {
            countingOutputStream.flush();
            this.currentOutputStream.close();
        }
        List<SevenZArchiveEntry> list = this.files;
        SevenZArchiveEntry sevenZArchiveEntry = list.get(list.size() - 1);
        int i = 0;
        if (this.fileBytesWritten > 0) {
            sevenZArchiveEntry.setHasStream(true);
            this.numNonEmptyStreams++;
            sevenZArchiveEntry.setSize(this.currentOutputStream.getBytesWritten());
            sevenZArchiveEntry.setCompressedSize(this.fileBytesWritten);
            sevenZArchiveEntry.setCrcValue(this.crc32.getValue());
            sevenZArchiveEntry.setCompressedCrcValue(this.compressedCrc32.getValue());
            sevenZArchiveEntry.setHasCrc(true);
            CountingOutputStream[] countingOutputStreamArr = this.additionalCountingStreams;
            if (countingOutputStreamArr != null) {
                long[] jArr = new long[countingOutputStreamArr.length];
                while (true) {
                    CountingOutputStream[] countingOutputStreamArr2 = this.additionalCountingStreams;
                    if (i >= countingOutputStreamArr2.length) {
                        break;
                    }
                    jArr[i] = countingOutputStreamArr2[i].getBytesWritten();
                    i++;
                }
                this.additionalSizes.put(sevenZArchiveEntry, jArr);
            }
        } else {
            sevenZArchiveEntry.setHasStream(false);
            sevenZArchiveEntry.setSize(0);
            sevenZArchiveEntry.setCompressedSize(0);
            sevenZArchiveEntry.setHasCrc(false);
        }
        this.currentOutputStream = null;
        this.additionalCountingStreams = null;
        this.crc32.reset();
        this.compressedCrc32.reset();
        this.fileBytesWritten = 0;
    }

    public SevenZArchiveEntry createArchiveEntry(File file2, String str) throws IOException {
        SevenZArchiveEntry sevenZArchiveEntry = new SevenZArchiveEntry();
        sevenZArchiveEntry.setDirectory(file2.isDirectory());
        sevenZArchiveEntry.setName(str);
        sevenZArchiveEntry.setLastModifiedDate(new Date(file2.lastModified()));
        return sevenZArchiveEntry;
    }

    public void finish() throws IOException {
        if (!this.finished) {
            this.finished = true;
            long filePointer = this.file.getFilePointer();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            writeHeader(dataOutputStream);
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.file.write(byteArray);
            CRC32 crc322 = new CRC32();
            this.file.seek(0);
            this.file.write(SevenZFile.sevenZSignature);
            this.file.write(0);
            this.file.write(2);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream2);
            dataOutputStream2.writeLong(Long.reverseBytes(filePointer - 32));
            dataOutputStream2.writeLong(Long.reverseBytes(4294967295L & ((long) byteArray.length)));
            crc322.reset();
            crc322.update(byteArray);
            dataOutputStream2.writeInt(Integer.reverseBytes((int) crc322.getValue()));
            dataOutputStream2.flush();
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            crc322.reset();
            crc322.update(byteArray2);
            this.file.writeInt(Integer.reverseBytes((int) crc322.getValue()));
            this.file.write(byteArray2);
            return;
        }
        throw new IOException("This archive has already been finished");
    }

    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        this.files.add((SevenZArchiveEntry) archiveEntry);
    }

    public void setContentCompression(SevenZMethod sevenZMethod) {
        setContentMethods(Collections.singletonList(new SevenZMethodConfiguration(sevenZMethod)));
    }

    public void setContentMethods(Iterable<? extends SevenZMethodConfiguration> iterable) {
        this.contentMethods = reverse(iterable);
    }

    public void write(int i) throws IOException {
        getCurrentOutputStream().write(i);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    private class OutputStreamWrapper extends OutputStream {
        private OutputStreamWrapper() {
        }

        public void close() throws IOException {
        }

        public void flush() throws IOException {
        }

        public void write(int i) throws IOException {
            SevenZOutputFile.this.file.write(i);
            SevenZOutputFile.this.compressedCrc32.update(i);
            SevenZOutputFile.access$408(SevenZOutputFile.this);
        }

        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            SevenZOutputFile.this.file.write(bArr, i, i2);
            SevenZOutputFile.this.compressedCrc32.update(bArr, i, i2);
            SevenZOutputFile.access$414(SevenZOutputFile.this, (long) i2);
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            getCurrentOutputStream().write(bArr, i, i2);
        }
    }
}
