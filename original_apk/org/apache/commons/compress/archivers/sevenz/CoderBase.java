package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class CoderBase {
    private static final byte[] NONE = new byte[0];
    private final Class<?>[] acceptableOptions;

    protected CoderBase(Class<?>... clsArr) {
        this.acceptableOptions = clsArr;
    }

    protected static int numberOptionOrDefault(Object obj, int i) {
        return obj instanceof Number ? ((Number) obj).intValue() : i;
    }

    /* access modifiers changed from: package-private */
    public boolean canAcceptOptions(Object obj) {
        for (Class<?> isInstance : this.acceptableOptions) {
            if (isInstance.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract InputStream decode(InputStream inputStream, long j, Coder coder, byte[] bArr) throws IOException;

    /* access modifiers changed from: package-private */
    public OutputStream encode(OutputStream outputStream, Object obj) throws IOException {
        throw new UnsupportedOperationException("method doesn't support writing");
    }

    /* access modifiers changed from: package-private */
    public byte[] getOptionsAsProperties(Object obj) {
        return NONE;
    }

    /* access modifiers changed from: package-private */
    public Object getOptionsFromCoder(Coder coder, InputStream inputStream) {
        return null;
    }
}
