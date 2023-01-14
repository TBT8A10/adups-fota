package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;

public enum Pack200Strategy {
    IN_MEMORY {
        /* access modifiers changed from: package-private */
        public StreamBridge newStreamBridge() {
            return new InMemoryCachingStreamBridge();
        }
    },
    TEMP_FILE {
        /* access modifiers changed from: package-private */
        public StreamBridge newStreamBridge() throws IOException {
            return new TempFileCachingStreamBridge();
        }
    };

    /* access modifiers changed from: package-private */
    public abstract StreamBridge newStreamBridge() throws IOException;
}
