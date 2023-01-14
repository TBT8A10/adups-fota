package org.apache.commons.compress.changes;

import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;

class Change {
    static final int TYPE_ADD = 2;
    static final int TYPE_DELETE = 1;
    static final int TYPE_DELETE_DIR = 4;
    static final int TYPE_MOVE = 3;
    private final ArchiveEntry entry;
    private final InputStream input;
    private final boolean replaceMode;
    private final String targetFile;
    private final int type;

    Change(String str, int i) {
        if (str != null) {
            this.targetFile = str;
            this.type = i;
            this.input = null;
            this.entry = null;
            this.replaceMode = true;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: package-private */
    public ArchiveEntry getEntry() {
        return this.entry;
    }

    /* access modifiers changed from: package-private */
    public InputStream getInput() {
        return this.input;
    }

    /* access modifiers changed from: package-private */
    public boolean isReplaceMode() {
        return this.replaceMode;
    }

    /* access modifiers changed from: package-private */
    public String targetFile() {
        return this.targetFile;
    }

    /* access modifiers changed from: package-private */
    public int type() {
        return this.type;
    }

    Change(ArchiveEntry archiveEntry, InputStream inputStream, boolean z) {
        if (archiveEntry == null || inputStream == null) {
            throw new NullPointerException();
        }
        this.entry = archiveEntry;
        this.input = inputStream;
        this.type = 2;
        this.targetFile = null;
        this.replaceMode = z;
    }
}
