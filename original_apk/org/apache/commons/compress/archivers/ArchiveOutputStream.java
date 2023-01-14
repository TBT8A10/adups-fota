package org.apache.commons.compress.archivers;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public abstract class ArchiveOutputStream extends OutputStream {
    static final int BYTE_MASK = 255;
    private long bytesWritten = 0;
    private final byte[] oneByte = new byte[1];

    public boolean canWriteEntryData(ArchiveEntry archiveEntry) {
        return true;
    }

    public abstract void closeArchiveEntry() throws IOException;

    /* access modifiers changed from: protected */
    public void count(int i) {
        count((long) i);
    }

    public abstract ArchiveEntry createArchiveEntry(File file, String str) throws IOException;

    public abstract void finish() throws IOException;

    public long getBytesWritten() {
        return this.bytesWritten;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesWritten;
    }

    public abstract void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException;

    public void write(int i) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i & BYTE_MASK);
        write(bArr, 0, 1);
    }

    /* access modifiers changed from: protected */
    public void count(long j) {
        if (j != -1) {
            this.bytesWritten += j;
        }
    }
}
