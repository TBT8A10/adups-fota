package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;

class BitStream {
    private static final int[] MASKS = {0, 1, 3, 7, 15, 31, 63, 127, 255};
    private long bitCache;
    private int bitCacheSize;
    private final InputStream in;

    BitStream(InputStream inputStream) {
        this.in = inputStream;
    }

    private boolean fillCache() throws IOException {
        boolean z = false;
        while (this.bitCacheSize <= 56) {
            long read = (long) this.in.read();
            if (read == -1) {
                break;
            }
            z = true;
            long j = this.bitCache;
            int i = this.bitCacheSize;
            this.bitCache = (read << i) | j;
            this.bitCacheSize = i + 8;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public int nextBit() throws IOException {
        if (this.bitCacheSize == 0 && !fillCache()) {
            return -1;
        }
        long j = this.bitCache;
        int i = (int) (1 & j);
        this.bitCache = j >>> 1;
        this.bitCacheSize--;
        return i;
    }

    /* access modifiers changed from: package-private */
    public int nextBits(int i) throws IOException {
        if (this.bitCacheSize < i && !fillCache()) {
            return -1;
        }
        long j = this.bitCache;
        int i2 = (int) (((long) MASKS[i]) & j);
        this.bitCache = j >>> i;
        this.bitCacheSize -= i;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int nextByte() throws IOException {
        return nextBits(8);
    }
}
