package org.apache.commons.compress.archivers.sevenz;

import java.util.BitSet;

class Archive {
    SevenZArchiveEntry[] files;
    Folder[] folders;
    long[] packCrcs;
    BitSet packCrcsDefined;
    long packPos;
    long[] packSizes;
    StreamMap streamMap;
    SubStreamsInfo subStreamsInfo;

    Archive() {
    }

    private static String lengthOf(long[] jArr) {
        return jArr == null ? "(null)" : String.valueOf(jArr.length);
    }

    public String toString() {
        return "Archive with packed streams starting at offset " + this.packPos + ", " + lengthOf(this.packSizes) + " pack sizes, " + lengthOf(this.packCrcs) + " CRCs, " + lengthOf((Object[]) this.folders) + " folders, " + lengthOf((Object[]) this.files) + " files and " + this.streamMap;
    }

    private static String lengthOf(Object[] objArr) {
        return objArr == null ? "(null)" : String.valueOf(objArr.length);
    }
}
