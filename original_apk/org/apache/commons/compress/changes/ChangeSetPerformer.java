package org.apache.commons.compress.changes;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

public class ChangeSetPerformer {
    private final Set<Change> changes;

    interface ArchiveEntryIterator {
        InputStream getInputStream() throws IOException;

        boolean hasNext() throws IOException;

        ArchiveEntry next();
    }

    private static class ArchiveInputStreamIterator implements ArchiveEntryIterator {
        private final ArchiveInputStream in;
        private ArchiveEntry next;

        ArchiveInputStreamIterator(ArchiveInputStream archiveInputStream) {
            this.in = archiveInputStream;
        }

        public InputStream getInputStream() {
            return this.in;
        }

        public boolean hasNext() throws IOException {
            ArchiveEntry nextEntry = this.in.getNextEntry();
            this.next = nextEntry;
            return nextEntry != null;
        }

        public ArchiveEntry next() {
            return this.next;
        }
    }

    private static class ZipFileIterator implements ArchiveEntryIterator {
        private ZipArchiveEntry current;
        private final ZipFile in;
        private final Enumeration<ZipArchiveEntry> nestedEnum;

        ZipFileIterator(ZipFile zipFile) {
            this.in = zipFile;
            this.nestedEnum = zipFile.getEntriesInPhysicalOrder();
        }

        public InputStream getInputStream() throws IOException {
            return this.in.getInputStream(this.current);
        }

        public boolean hasNext() {
            return this.nestedEnum.hasMoreElements();
        }

        public ArchiveEntry next() {
            ZipArchiveEntry nextElement = this.nestedEnum.nextElement();
            this.current = nextElement;
            return nextElement;
        }
    }

    public ChangeSetPerformer(ChangeSet changeSet) {
        this.changes = changeSet.getChanges();
    }

    private void copyStream(InputStream inputStream, ArchiveOutputStream archiveOutputStream, ArchiveEntry archiveEntry) throws IOException {
        archiveOutputStream.putArchiveEntry(archiveEntry);
        IOUtils.copy(inputStream, archiveOutputStream);
        archiveOutputStream.closeArchiveEntry();
    }

    private boolean isDeletedLater(Set<Change> set, ArchiveEntry archiveEntry) {
        String name = archiveEntry.getName();
        if (set.isEmpty()) {
            return false;
        }
        for (Change next : set) {
            int type = next.type();
            String targetFile = next.targetFile();
            if (type == 1 && name.equals(targetFile)) {
                return true;
            }
            if (type == 4) {
                if (name.startsWith(targetFile + "/")) {
                    return true;
                }
            }
        }
        return false;
    }

    public ChangeSetResults perform(ArchiveInputStream archiveInputStream, ArchiveOutputStream archiveOutputStream) throws IOException {
        return perform((ArchiveEntryIterator) new ArchiveInputStreamIterator(archiveInputStream), archiveOutputStream);
    }

    public ChangeSetResults perform(ZipFile zipFile, ArchiveOutputStream archiveOutputStream) throws IOException {
        return perform((ArchiveEntryIterator) new ZipFileIterator(zipFile), archiveOutputStream);
    }

    private ChangeSetResults perform(ArchiveEntryIterator archiveEntryIterator, ArchiveOutputStream archiveOutputStream) throws IOException {
        boolean z;
        ChangeSetResults changeSetResults = new ChangeSetResults();
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.changes);
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            Change change = (Change) it.next();
            if (change.type() == 2 && change.isReplaceMode()) {
                copyStream(change.getInput(), archiveOutputStream, change.getEntry());
                it.remove();
                changeSetResults.addedFromChangeSet(change.getEntry().getName());
            }
        }
        while (archiveEntryIterator.hasNext()) {
            ArchiveEntry next = archiveEntryIterator.next();
            Iterator it2 = linkedHashSet.iterator();
            while (true) {
                z = false;
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                Change change2 = (Change) it2.next();
                int type = change2.type();
                String name = next.getName();
                if (type != 1 || name == null) {
                    if (type == 4 && name != null) {
                        if (name.startsWith(change2.targetFile() + "/")) {
                            changeSetResults.deleted(name);
                            break;
                        }
                    }
                } else if (name.equals(change2.targetFile())) {
                    it2.remove();
                    changeSetResults.deleted(name);
                    break;
                }
            }
            if (z && !isDeletedLater(linkedHashSet, next) && !changeSetResults.hasBeenAdded(next.getName())) {
                copyStream(archiveEntryIterator.getInputStream(), archiveOutputStream, next);
                changeSetResults.addedFromStream(next.getName());
            }
        }
        Iterator it3 = linkedHashSet.iterator();
        while (it3.hasNext()) {
            Change change3 = (Change) it3.next();
            if (change3.type() == 2 && !change3.isReplaceMode() && !changeSetResults.hasBeenAdded(change3.getEntry().getName())) {
                copyStream(change3.getInput(), archiveOutputStream, change3.getEntry());
                it3.remove();
                changeSetResults.addedFromChangeSet(change3.getEntry().getName());
            }
        }
        archiveOutputStream.finish();
        return changeSetResults;
    }
}
