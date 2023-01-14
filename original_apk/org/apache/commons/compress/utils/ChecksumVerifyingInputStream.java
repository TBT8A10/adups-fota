package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Checksum;

public class ChecksumVerifyingInputStream extends InputStream {
    private long bytesRemaining;
    private final Checksum checksum;
    private final long expectedChecksum;
    private final InputStream in;

    public ChecksumVerifyingInputStream(Checksum checksum2, InputStream inputStream, long j, long j2) {
        this.checksum = checksum2;
        this.in = inputStream;
        this.expectedChecksum = j2;
        this.bytesRemaining = j;
    }

    public void close() throws IOException {
        this.in.close();
    }

    public int read() throws IOException {
        if (this.bytesRemaining <= 0) {
            return -1;
        }
        int read = this.in.read();
        if (read >= 0) {
            this.checksum.update(read);
            this.bytesRemaining--;
        }
        if (this.bytesRemaining != 0 || this.expectedChecksum == this.checksum.getValue()) {
            return read;
        }
        throw new IOException("Checksum verification failed");
    }

    public long skip(long j) throws IOException {
        return read() >= 0 ? 1 : 0;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read >= 0) {
            this.checksum.update(bArr, i, read);
            this.bytesRemaining -= (long) read;
        }
        if (this.bytesRemaining > 0 || this.expectedChecksum == this.checksum.getValue()) {
            return read;
        }
        throw new IOException("Checksum verification failed");
    }
}
