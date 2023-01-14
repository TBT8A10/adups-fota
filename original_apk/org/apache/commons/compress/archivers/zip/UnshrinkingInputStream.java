package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.z._internal_.InternalLZWInputStream;

class UnshrinkingInputStream extends InternalLZWInputStream {
    private static final int MAX_CODE_SIZE = 13;
    private static final int MAX_TABLE_SIZE = 8192;
    private final boolean[] isUsed = new boolean[this.prefixes.length];

    public UnshrinkingInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        setClearCode(this.codeSize);
        initializeTables(13);
        for (int i = 0; i < 256; i++) {
            this.isUsed[i] = true;
        }
        this.tableSize = this.clearCode + 1;
    }

    private void partialClear() {
        boolean[] zArr = new boolean[8192];
        int i = 0;
        while (true) {
            boolean[] zArr2 = this.isUsed;
            if (i >= zArr2.length) {
                break;
            }
            if (zArr2[i]) {
                int[] iArr = this.prefixes;
                if (iArr[i] != -1) {
                    zArr[iArr[i]] = true;
                }
            }
            i++;
        }
        for (int i2 = this.clearCode + 1; i2 < zArr.length; i2++) {
            if (!zArr[i2]) {
                this.isUsed[i2] = false;
                this.prefixes[i2] = -1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int addEntry(int i, byte b2) throws IOException {
        while (true) {
            int i2 = this.tableSize;
            if (i2 >= 8192 || !this.isUsed[i2]) {
                int addEntry = addEntry(i, b2, 8192);
            } else {
                this.tableSize = i2 + 1;
            }
        }
        int addEntry2 = addEntry(i, b2, 8192);
        if (addEntry2 >= 0) {
            this.isUsed[addEntry2] = true;
        }
        return addEntry2;
    }

    /* access modifiers changed from: protected */
    public int decompressNextSymbol() throws IOException {
        int readNextCode = readNextCode();
        if (readNextCode < 0) {
            return -1;
        }
        boolean z = false;
        if (readNextCode == this.clearCode) {
            int readNextCode2 = readNextCode();
            if (readNextCode2 >= 0) {
                if (readNextCode2 == 1) {
                    int i = this.codeSize;
                    if (i < 13) {
                        this.codeSize = i + 1;
                    } else {
                        throw new IOException("Attempt to increase code size beyond maximum");
                    }
                } else if (readNextCode2 == 2) {
                    partialClear();
                    this.tableSize = this.clearCode + 1;
                } else {
                    throw new IOException("Invalid clear code subcode " + readNextCode2);
                }
                return 0;
            }
            throw new IOException("Unexpected EOF;");
        }
        if (!this.isUsed[readNextCode]) {
            readNextCode = addRepeatOfPreviousCode();
            z = true;
        }
        return expandCodeToOutputStack(readNextCode, z);
    }
}
