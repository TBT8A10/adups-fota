package org.apache.commons.compress.utils;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream extends FilterInputStream {
    private long bytesRead;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    /* access modifiers changed from: protected */
    public final void count(long j) {
        if (j != -1) {
            this.bytesRead += j;
        }
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            count(1);
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read >= 0) {
            count((long) read);
        }
        return read;
    }
}
