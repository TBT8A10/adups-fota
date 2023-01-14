package org.apache.commons.compress.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CountingOutputStream extends FilterOutputStream {
    private long bytesWritten = 0;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    /* access modifiers changed from: protected */
    public void count(long j) {
        if (j != -1) {
            this.bytesWritten += j;
        }
    }

    public long getBytesWritten() {
        return this.bytesWritten;
    }

    public void write(int i) throws IOException {
        this.out.write(i);
        count(1);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        count((long) i2);
    }
}
