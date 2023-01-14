package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;

public class BoundedInputStream extends InputStream {
    private long bytesRemaining;
    private final InputStream in;

    public BoundedInputStream(InputStream inputStream, long j) {
        this.in = inputStream;
        this.bytesRemaining = j;
    }

    public void close() {
    }

    public int read() throws IOException {
        long j = this.bytesRemaining;
        if (j <= 0) {
            return -1;
        }
        this.bytesRemaining = j - 1;
        return this.in.read();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        if (((long) i2) > j) {
            i2 = (int) j;
        }
        int read = this.in.read(bArr, i, i2);
        if (read >= 0) {
            this.bytesRemaining -= (long) read;
        }
        return read;
    }
}
