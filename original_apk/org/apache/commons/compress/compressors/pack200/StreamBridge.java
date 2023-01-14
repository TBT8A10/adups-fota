package org.apache.commons.compress.compressors.pack200;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class StreamBridge extends FilterOutputStream {
    private final Object INPUT_LOCK;
    private InputStream input;

    protected StreamBridge(OutputStream outputStream) {
        super(outputStream);
        this.INPUT_LOCK = new Object();
    }

    /* access modifiers changed from: package-private */
    public InputStream getInput() throws IOException {
        synchronized (this.INPUT_LOCK) {
            if (this.input == null) {
                this.input = getInputView();
            }
        }
        return this.input;
    }

    /* access modifiers changed from: package-private */
    public abstract InputStream getInputView() throws IOException;

    /* access modifiers changed from: package-private */
    public void stop() throws IOException {
        close();
        synchronized (this.INPUT_LOCK) {
            if (this.input != null) {
                this.input.close();
                this.input = null;
            }
        }
    }

    protected StreamBridge() {
        this((OutputStream) null);
    }
}
