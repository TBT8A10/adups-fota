package org.apache.commons.compress.compressors.z._internal_;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;

public abstract class InternalLZWInputStream extends CompressorInputStream {
    protected int bitsCached = 0;
    protected int bitsCachedSize = 0;
    protected byte[] characters;
    protected int clearCode = -1;
    protected int codeSize = 9;
    protected final InputStream in;
    private final byte[] oneByte = new byte[1];
    private byte[] outputStack;
    private int outputStackLocation;
    protected int[] prefixes;
    protected int previousCode = -1;
    protected int tableSize = 0;

    protected InternalLZWInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    private int readFromStack(byte[] bArr, int i, int i2) {
        int length = this.outputStack.length - this.outputStackLocation;
        if (length <= 0) {
            return 0;
        }
        int min = Math.min(length, i2);
        System.arraycopy(this.outputStack, this.outputStackLocation, bArr, i, min);
        this.outputStackLocation += min;
        return min;
    }

    /* access modifiers changed from: protected */
    public abstract int addEntry(int i, byte b2) throws IOException;

    /* access modifiers changed from: protected */
    public int addEntry(int i, byte b2, int i2) {
        int i3 = this.tableSize;
        if (i3 >= i2) {
            return -1;
        }
        this.prefixes[i3] = i;
        this.characters[i3] = b2;
        this.tableSize = i3 + 1;
        return i3;
    }

    /* access modifiers changed from: protected */
    public int addRepeatOfPreviousCode() throws IOException {
        int i = this.previousCode;
        if (i != -1) {
            byte b2 = 0;
            while (i >= 0) {
                b2 = this.characters[i];
                i = this.prefixes[i];
            }
            return addEntry(this.previousCode, b2);
        }
        throw new IOException("The first code can't be a reference to its preceding code");
    }

    public void close() throws IOException {
        this.in.close();
    }

    /* access modifiers changed from: protected */
    public abstract int decompressNextSymbol() throws IOException;

    /* access modifiers changed from: protected */
    public int expandCodeToOutputStack(int i, boolean z) throws IOException {
        int i2 = i;
        while (i2 >= 0) {
            byte[] bArr = this.outputStack;
            int i3 = this.outputStackLocation - 1;
            this.outputStackLocation = i3;
            bArr[i3] = this.characters[i2];
            i2 = this.prefixes[i2];
        }
        int i4 = this.previousCode;
        if (i4 != -1 && !z) {
            addEntry(i4, this.outputStack[this.outputStackLocation]);
        }
        this.previousCode = i;
        return this.outputStackLocation;
    }

    /* access modifiers changed from: protected */
    public void initializeTables(int i) {
        int i2 = 1 << i;
        this.prefixes = new int[i2];
        this.characters = new byte[i2];
        this.outputStack = new byte[i2];
        this.outputStackLocation = i2;
        for (int i3 = 0; i3 < 256; i3++) {
            this.prefixes[i3] = -1;
            this.characters[i3] = (byte) i3;
        }
    }

    public int read() throws IOException {
        int read = read(this.oneByte);
        if (read < 0) {
            return read;
        }
        return this.oneByte[0] & 255;
    }

    /* access modifiers changed from: protected */
    public int readNextCode() throws IOException {
        while (true) {
            int i = this.bitsCachedSize;
            int i2 = this.codeSize;
            if (i < i2) {
                int read = this.in.read();
                if (read < 0) {
                    return read;
                }
                int i3 = this.bitsCached;
                int i4 = this.bitsCachedSize;
                this.bitsCached = (read << i4) | i3;
                this.bitsCachedSize = i4 + 8;
            } else {
                int i5 = this.bitsCached;
                int i6 = ((1 << i2) - 1) & i5;
                this.bitsCached = i5 >>> i2;
                this.bitsCachedSize = i - i2;
                return i6;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setClearCode(int i) {
        this.clearCode = 1 << (i - 1);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int readFromStack = readFromStack(bArr, i, i2);
        while (true) {
            int i3 = i2 - readFromStack;
            if (i3 > 0) {
                int decompressNextSymbol = decompressNextSymbol();
                if (decompressNextSymbol >= 0) {
                    readFromStack += readFromStack(bArr, i + readFromStack, i3);
                } else if (readFromStack <= 0) {
                    return decompressNextSymbol;
                } else {
                    count(readFromStack);
                    return readFromStack;
                }
            } else {
                count(readFromStack);
                return readFromStack;
            }
        }
    }
}
