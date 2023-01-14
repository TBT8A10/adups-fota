package org.apache.commons.compress.compressors.lzma;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.tukaani.xz.LZMAInputStream;

public class LZMACompressorInputStream extends CompressorInputStream {
    private final InputStream in;

    public LZMACompressorInputStream(InputStream inputStream) throws IOException {
        this.in = new LZMAInputStream(inputStream);
    }

    public int available() throws IOException {
        return this.in.available();
    }

    public void close() throws IOException {
        this.in.close();
    }

    public int read() throws IOException {
        int read = this.in.read();
        count(read == -1 ? 0 : 1);
        return read;
    }

    public long skip(long j) throws IOException {
        return this.in.skip(j);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        count(read);
        return read;
    }
}
