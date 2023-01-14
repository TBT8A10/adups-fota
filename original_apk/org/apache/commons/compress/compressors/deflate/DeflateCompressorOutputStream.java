package org.apache.commons.compress.compressors.deflate;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class DeflateCompressorOutputStream extends CompressorOutputStream {
    private final DeflaterOutputStream out;

    public DeflateCompressorOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, new DeflateParameters());
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void finish() throws IOException {
        this.out.finish();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(int i) throws IOException {
        this.out.write(i);
    }

    public DeflateCompressorOutputStream(OutputStream outputStream, DeflateParameters deflateParameters) throws IOException {
        this.out = new DeflaterOutputStream(outputStream, new Deflater(deflateParameters.getCompressionLevel(), !deflateParameters.withZlibHeader()));
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }
}
