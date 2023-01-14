package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.tukaani.xz.DeltaOptions;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.UnsupportedOptionsException;

class DeltaDecoder extends CoderBase {
    DeltaDecoder() {
        super(Number.class);
    }

    /* access modifiers changed from: package-private */
    public InputStream decode(InputStream inputStream, long j, Coder coder, byte[] bArr) throws IOException {
        return new DeltaOptions(getOptionsFromCoder(coder)).getInputStream(inputStream);
    }

    /* access modifiers changed from: package-private */
    public OutputStream encode(OutputStream outputStream, Object obj) throws IOException {
        try {
            return new DeltaOptions(CoderBase.numberOptionOrDefault(obj, 1)).getOutputStream(new FinishableWrapperOutputStream(outputStream));
        } catch (UnsupportedOptionsException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] getOptionsAsProperties(Object obj) {
        return new byte[]{(byte) (CoderBase.numberOptionOrDefault(obj, 1) - 1)};
    }

    /* access modifiers changed from: package-private */
    public Object getOptionsFromCoder(Coder coder, InputStream inputStream) {
        return Integer.valueOf(getOptionsFromCoder(coder));
    }

    private int getOptionsFromCoder(Coder coder) {
        byte[] bArr = coder.properties;
        if (bArr == null || bArr.length == 0) {
            return 1;
        }
        return (bArr[0] & 255) + 1;
    }
}
