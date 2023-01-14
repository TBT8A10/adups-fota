package org.apache.commons.compress.compressors.deflate;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;

public class DeflateCompressorInputStream extends CompressorInputStream {
    private final InputStream in;

    public DeflateCompressorInputStream(InputStream inputStream) {
        this(inputStream, new DeflateParameters());
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

    public DeflateCompressorInputStream(InputStream inputStream, DeflateParameters deflateParameters) {
        this.in = new InflaterInputStream(inputStream, new Inflater(!deflateParameters.withZlibHeader()));
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        count(read);
        return read;
    }
}
