package org.apache.commons.compress.changes;

import java.util.ArrayList;
import java.util.List;

public class ChangeSetResults {
    private final List<String> addedFromChangeSet = new ArrayList();
    private final List<String> addedFromStream = new ArrayList();
    private final List<String> deleted = new ArrayList();

    /* access modifiers changed from: package-private */
    public void addedFromChangeSet(String str) {
        this.addedFromChangeSet.add(str);
    }

    /* access modifiers changed from: package-private */
    public void addedFromStream(String str) {
        this.addedFromStream.add(str);
    }

    /* access modifiers changed from: package-private */
    public void deleted(String str) {
        this.deleted.add(str);
    }

    public List<String> getAddedFromChangeSet() {
        return this.addedFromChangeSet;
    }

    public List<String> getAddedFromStream() {
        return this.addedFromStream;
    }

    public List<String> getDeleted() {
        return this.deleted;
    }

    /* access modifiers changed from: package-private */
    public boolean hasBeenAdded(String str) {
        return this.addedFromChangeSet.contains(str) || this.addedFromStream.contains(str);
    }
}
