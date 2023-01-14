package org.apache.commons.compress.compressors.z;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.compressors.z._internal_.InternalLZWInputStream;

public class ZCompressorInputStream extends InternalLZWInputStream {
    private static final int BLOCK_MODE_MASK = 128;
    private static final int MAGIC_1 = 31;
    private static final int MAGIC_2 = 157;
    private static final int MAX_CODE_SIZE_MASK = 31;
    private final boolean blockMode;
    private final int maxCodeSize;
    private long totalCodesRead = 0;

    public ZCompressorInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        int read = this.in.read();
        int read2 = this.in.read();
        int read3 = this.in.read();
        if (read == 31 && read2 == MAGIC_2 && read3 >= 0) {
            this.blockMode = (read3 & 128) != 0;
            this.maxCodeSize = read3 & 31;
            if (this.blockMode) {
                setClearCode(this.codeSize);
            }
            initializeTables(this.maxCodeSize);
            clearEntries();
            return;
        }
        throw new IOException("Input is not in .Z format");
    }

    private void clearEntries() {
        this.tableSize = CpioConstants.C_IRUSR;
        if (this.blockMode) {
            this.tableSize++;
        }
    }

    public static boolean matches(byte[] bArr, int i) {
        return i > 3 && bArr[0] == 31 && bArr[1] == -99;
    }

    private void reAlignReading() throws IOException {
        long j = 8 - (this.totalCodesRead % 8);
        if (j == 8) {
            j = 0;
        }
        for (long j2 = 0; j2 < j; j2++) {
            readNextCode();
        }
        this.bitsCached = 0;
        this.bitsCachedSize = 0;
    }

    /* access modifiers changed from: protected */
    public int addEntry(int i, byte b2) throws IOException {
        int i2 = 1 << this.codeSize;
        int addEntry = addEntry(i, b2, i2);
        if (this.tableSize == i2 && this.codeSize < this.maxCodeSize) {
            reAlignReading();
            this.codeSize++;
        }
        return addEntry;
    }

    /* access modifiers changed from: protected */
    public int decompressNextSymbol() throws IOException {
        int readNextCode = readNextCode();
        if (readNextCode < 0) {
            return -1;
        }
        if (!this.blockMode || readNextCode != this.clearCode) {
            int i = this.tableSize;
            boolean z = true;
            if (readNextCode == i) {
                addRepeatOfPreviousCode();
            } else if (readNextCode <= i) {
                z = false;
            } else {
                throw new IOException(String.format("Invalid %d bit code 0x%x", new Object[]{Integer.valueOf(this.codeSize), Integer.valueOf(readNextCode)}));
            }
            return expandCodeToOutputStack(readNextCode, z);
        }
        clearEntries();
        reAlignReading();
        this.codeSize = 9;
        this.previousCode = -1;
        return 0;
    }

    /* access modifiers changed from: protected */
    public int readNextCode() throws IOException {
        int readNextCode = super.readNextCode();
        if (readNextCode >= 0) {
            this.totalCodesRead++;
        }
        return readNextCode;
    }
}
