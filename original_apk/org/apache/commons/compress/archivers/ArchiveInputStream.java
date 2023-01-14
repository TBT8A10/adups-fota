package org.apache.commons.compress.archivers;

import java.io.IOException;
import java.io.InputStream;

public abstract class ArchiveInputStream extends InputStream {
    private static final int BYTE_MASK = 255;
    private final byte[] SINGLE = new byte[1];
    private long bytesRead = 0;

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void count(int i) {
        count((long) i);
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesRead;
    }

    public abstract ArchiveEntry getNextEntry() throws IOException;

    /* access modifiers changed from: protected */
    public void pushedBackBytes(long j) {
        this.bytesRead -= j;
    }

    public int read() throws IOException {
        if (read(this.SINGLE, 0, 1) == -1) {
            return -1;
        }
        return this.SINGLE[0] & 255;
    }

    /* access modifiers changed from: protected */
    public void count(long j) {
        if (j != -1) {
            this.bytesRead += j;
        }
    }
}
