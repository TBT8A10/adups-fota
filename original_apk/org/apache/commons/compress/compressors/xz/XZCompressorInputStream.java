package org.apache.commons.compress.compressors.xz;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;

public class XZCompressorInputStream extends CompressorInputStream {
    private final InputStream in;

    public XZCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < XZ.HEADER_MAGIC.length) {
            return false;
        }
        for (int i2 = 0; i2 < XZ.HEADER_MAGIC.length; i2++) {
            if (bArr[i2] != XZ.HEADER_MAGIC[i2]) {
                return false;
            }
        }
        return true;
    }

    public int available() throws IOException {
        return this.in.available();
    }

    public void close() throws IOException {
        this.in.close();
    }

    public int read() throws IOException {
        int read = this.in.read();
        int i = -1;
        if (read != -1) {
            i = 1;
        }
        count(i);
        return read;
    }

    public long skip(long j) throws IOException {
        return this.in.skip(j);
    }

    public XZCompressorInputStream(InputStream inputStream, boolean z) throws IOException {
        if (z) {
            this.in = new XZInputStream(inputStream);
        } else {
            this.in = new SingleXZInputStream(inputStream);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        count(read);
        return read;
    }
}
