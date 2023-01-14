package org.apache.commons.compress.archivers.sevenz;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.tukaani.xz.ARMOptions;
import org.tukaani.xz.ARMThumbOptions;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.IA64Options;
import org.tukaani.xz.LZMAInputStream;
import org.tukaani.xz.PowerPCOptions;
import org.tukaani.xz.SPARCOptions;
import org.tukaani.xz.X86Options;

class Coders {
    private static final Map<SevenZMethod, CoderBase> CODER_MAP = new HashMap<SevenZMethod, CoderBase>() {
        private static final long serialVersionUID = 1664829131806520867L;

        {
            put(SevenZMethod.COPY, new CopyDecoder());
            put(SevenZMethod.LZMA, new LZMADecoder());
            put(SevenZMethod.LZMA2, new LZMA2Decoder());
            put(SevenZMethod.DEFLATE, new DeflateDecoder());
            put(SevenZMethod.BZIP2, new BZIP2Decoder());
            put(SevenZMethod.AES256SHA256, new AES256SHA256Decoder());
            put(SevenZMethod.BCJ_X86_FILTER, new BCJDecoder(new X86Options()));
            put(SevenZMethod.BCJ_PPC_FILTER, new BCJDecoder(new PowerPCOptions()));
            put(SevenZMethod.BCJ_IA64_FILTER, new BCJDecoder(new IA64Options()));
            put(SevenZMethod.BCJ_ARM_FILTER, new BCJDecoder(new ARMOptions()));
            put(SevenZMethod.BCJ_ARM_THUMB_FILTER, new BCJDecoder(new ARMThumbOptions()));
            put(SevenZMethod.BCJ_SPARC_FILTER, new BCJDecoder(new SPARCOptions()));
            put(SevenZMethod.DELTA_FILTER, new DeltaDecoder());
        }
    };

    static class BCJDecoder extends CoderBase {
        private final FilterOptions opts;

        BCJDecoder(FilterOptions filterOptions) {
            super(new Class[0]);
            this.opts = filterOptions;
        }

        /* access modifiers changed from: package-private */
        public InputStream decode(InputStream inputStream, long j, Coder coder, byte[] bArr) throws IOException {
            try {
                return this.opts.getInputStream(inputStream);
            } catch (AssertionError e) {
                IOException iOException = new IOException("BCJ filter needs XZ for Java > 1.4 - see http://commons.apache.org/proper/commons-compress/limitations.html#7Z");
                iOException.initCause(e);
                throw iOException;
            }
        }

        /* access modifiers changed from: package-private */
        public OutputStream encode(OutputStream outputStream, Object obj) {
            return new FilterOutputStream(this.opts.getOutputStream(new FinishableWrapperOutputStream(outputStream))) {
                public void flush() {
                }
            };
        }
    }

    static class BZIP2Decoder extends CoderBase {
        BZIP2Decoder() {
            super(Number.class);
        }

        /* access modifiers changed from: package-private */
        public InputStream decode(InputStream inputStream, long j, Coder coder, byte[] bArr) throws IOException {
            return new BZip2CompressorInputStream(inputStream);
        }

        /* access modifiers changed from: package-private */
        public OutputStream encode(OutputStream outputStream, Object obj) throws IOException {
            return new BZip2CompressorOutputStream(outputStream, CoderBase.numberOptionOrDefault(obj, 9));
        }
    }

    static class CopyDecoder extends CoderBase {
        CopyDecoder() {
            super(new Class[0]);
        }

        /* access modifiers changed from: package-private */
        public InputStream decode(InputStream inputStream, long j, Coder coder, byte[] bArr) throws IOException {
            return inputStream;
        }

        /* access modifiers changed from: package-private */
        public OutputStream encode(OutputStream outputStream, Object obj) {
            return outputStream;
        }
    }

    static class DeflateDecoder extends CoderBase {
        DeflateDecoder() {
            super(Number.class);
        }

        /* access modifiers changed from: package-private */
        public InputStream decode(InputStream inputStream, long j, Coder coder, byte[] bArr) throws IOException {
            return new InflaterInputStream(new DummyByteAddingInputStream(inputStream), new Inflater(true));
        }

        /* access modifiers changed from: package-private */
        public OutputStream encode(OutputStream outputStream, Object obj) {
            return new DeflaterOutputStream(outputStream, new Deflater(CoderBase.numberOptionOrDefault(obj, 9), true));
        }
    }

    private static class DummyByteAddingInputStream extends FilterInputStream {
        private boolean addDummyByte;

        public int read() throws IOException {
            int read = super.read();
            if (read != -1 || !this.addDummyByte) {
                return read;
            }
            this.addDummyByte = false;
            return 0;
        }

        private DummyByteAddingInputStream(InputStream inputStream) {
            super(inputStream);
            this.addDummyByte = true;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1 || !this.addDummyByte) {
                return read;
            }
            this.addDummyByte = false;
            bArr[i] = 0;
            return 1;
        }
    }

    static class LZMADecoder extends CoderBase {
        LZMADecoder() {
            super(new Class[0]);
        }

        /* access modifiers changed from: package-private */
        public InputStream decode(InputStream inputStream, long j, Coder coder, byte[] bArr) throws IOException {
            byte[] bArr2 = coder.properties;
            byte b2 = bArr2[0];
            int i = 1;
            long j2 = (long) bArr2[1];
            while (i < 4) {
                int i2 = i + 1;
                j2 |= (((long) coder.properties[i2]) & 255) << (i * 8);
                i = i2;
            }
            if (j2 <= 2147483632) {
                return new LZMAInputStream(inputStream, j, b2, (int) j2);
            }
            throw new IOException("Dictionary larger than 4GiB maximum size");
        }
    }

    Coders() {
    }

    static InputStream addDecoder(InputStream inputStream, long j, Coder coder, byte[] bArr) throws IOException {
        CoderBase findByMethod = findByMethod(SevenZMethod.byId(coder.decompressionMethodId));
        if (findByMethod != null) {
            return findByMethod.decode(inputStream, j, coder, bArr);
        }
        throw new IOException("Unsupported compression method " + Arrays.toString(coder.decompressionMethodId));
    }

    static OutputStream addEncoder(OutputStream outputStream, SevenZMethod sevenZMethod, Object obj) throws IOException {
        CoderBase findByMethod = findByMethod(sevenZMethod);
        if (findByMethod != null) {
            return findByMethod.encode(outputStream, obj);
        }
        throw new IOException("Unsupported compression method " + sevenZMethod);
    }

    static CoderBase findByMethod(SevenZMethod sevenZMethod) {
        return CODER_MAP.get(sevenZMethod);
    }
}
