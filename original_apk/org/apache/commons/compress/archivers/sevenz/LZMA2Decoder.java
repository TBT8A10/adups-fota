package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.LZMA2InputStream;
import org.tukaani.xz.LZMA2Options;

class LZMA2Decoder extends CoderBase {
    LZMA2Decoder() {
        super(LZMA2Options.class, Number.class);
    }

    private int getDictSize(Object obj) {
        if (obj instanceof LZMA2Options) {
            return ((LZMA2Options) obj).getDictSize();
        }
        return numberOptionOrDefault(obj);
    }

    private int getDictionarySize(Coder coder) throws IllegalArgumentException {
        byte b2 = coder.properties[0] & 255;
        if ((b2 & -64) != 0) {
            throw new IllegalArgumentException("Unsupported LZMA2 property bits");
        } else if (b2 > 40) {
            throw new IllegalArgumentException("Dictionary larger than 4GiB maximum size");
        } else if (b2 == 40) {
            return -1;
        } else {
            return ((b2 & 1) | 2) << ((b2 / 2) + 11);
        }
    }

    private LZMA2Options getOptions(Object obj) throws IOException {
        if (obj instanceof LZMA2Options) {
            return (LZMA2Options) obj;
        }
        LZMA2Options lZMA2Options = new LZMA2Options();
        lZMA2Options.setDictSize(numberOptionOrDefault(obj));
        return lZMA2Options;
    }

    private int numberOptionOrDefault(Object obj) {
        return CoderBase.numberOptionOrDefault(obj, 8388608);
    }

    /* access modifiers changed from: package-private */
    public InputStream decode(InputStream inputStream, long j, Coder coder, byte[] bArr) throws IOException {
        try {
            return new LZMA2InputStream(inputStream, getDictionarySize(coder));
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public OutputStream encode(OutputStream outputStream, Object obj) throws IOException {
        return getOptions(obj).getOutputStream(new FinishableWrapperOutputStream(outputStream));
    }

    /* access modifiers changed from: package-private */
    public byte[] getOptionsAsProperties(Object obj) {
        int dictSize = getDictSize(obj);
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(dictSize);
        return new byte[]{(byte) (((19 - numberOfLeadingZeros) * 2) + ((dictSize >>> (30 - numberOfLeadingZeros)) - 2))};
    }

    /* access modifiers changed from: package-private */
    public Object getOptionsFromCoder(Coder coder, InputStream inputStream) {
        return Integer.valueOf(getDictionarySize(coder));
    }
}
