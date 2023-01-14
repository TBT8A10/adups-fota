package org.apache.commons.compress.archivers.sevenz;

class StreamMap {
    int[] fileFolderIndex;
    int[] folderFirstFileIndex;
    int[] folderFirstPackStreamIndex;
    long[] packStreamOffsets;

    StreamMap() {
    }

    public String toString() {
        return "StreamMap with indices of " + this.folderFirstPackStreamIndex.length + " folders, offsets of " + this.packStreamOffsets.length + " packed streams," + " first files of " + this.folderFirstFileIndex.length + " folders and" + " folder indices for " + this.fileFolderIndex.length + " files";
    }
}
