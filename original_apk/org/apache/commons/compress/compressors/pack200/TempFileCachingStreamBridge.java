package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class TempFileCachingStreamBridge extends StreamBridge {
    /* access modifiers changed from: private */
    public final File f = File.createTempFile("commons-compress", "packtemp");

    TempFileCachingStreamBridge() throws IOException {
        this.f.deleteOnExit();
        this.out = new FileOutputStream(this.f);
    }

    /* access modifiers changed from: package-private */
    public InputStream getInputView() throws IOException {
        this.out.close();
        return new FileInputStream(this.f) {
            public void close() throws IOException {
                super.close();
                TempFileCachingStreamBridge.this.f.delete();
            }
        };
    }
}
