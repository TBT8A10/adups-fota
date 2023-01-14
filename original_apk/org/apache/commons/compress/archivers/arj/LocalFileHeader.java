package org.apache.commons.compress.archivers.arj;

import java.util.Arrays;

class LocalFileHeader {
    int archiverVersionNumber;
    int arjFlags;
    String comment;
    long compressedSize;
    int dateTimeAccessed;
    int dateTimeCreated;
    int dateTimeModified;
    int extendedFilePosition;
    byte[][] extendedHeaders = null;
    int fileAccessMode;
    int fileSpecPosition;
    int fileType;
    int firstChapter;
    int hostOS;
    int lastChapter;
    int method;
    int minVersionToExtract;
    String name;
    long originalCrc32;
    long originalSize;
    int originalSizeEvenForVolumes;
    int reserved;

    static class FileTypes {
        static final int BINARY = 0;
        static final int CHAPTER_LABEL = 5;
        static final int DIRECTORY = 3;
        static final int SEVEN_BIT_TEXT = 1;
        static final int VOLUME_LABEL = 4;

        FileTypes() {
        }
    }

    static class Flags {
        static final int BACKUP = 32;
        static final int EXTFILE = 8;
        static final int GARBLED = 1;
        static final int PATHSYM = 16;
        static final int VOLUME = 4;

        Flags() {
        }
    }

    static class Methods {
        static final int COMPRESSED_FASTEST = 4;
        static final int COMPRESSED_MOST = 1;
        static final int NO_DATA = 9;
        static final int NO_DATA_NO_CRC = 8;
        static final int STORED = 0;

        Methods() {
        }
    }

    LocalFileHeader() {
    }

    public String toString() {
        return "LocalFileHeader [archiverVersionNumber=" + this.archiverVersionNumber + ", minVersionToExtract=" + this.minVersionToExtract + ", hostOS=" + this.hostOS + ", arjFlags=" + this.arjFlags + ", method=" + this.method + ", fileType=" + this.fileType + ", reserved=" + this.reserved + ", dateTimeModified=" + this.dateTimeModified + ", compressedSize=" + this.compressedSize + ", originalSize=" + this.originalSize + ", originalCrc32=" + this.originalCrc32 + ", fileSpecPosition=" + this.fileSpecPosition + ", fileAccessMode=" + this.fileAccessMode + ", firstChapter=" + this.firstChapter + ", lastChapter=" + this.lastChapter + ", extendedFilePosition=" + this.extendedFilePosition + ", dateTimeAccessed=" + this.dateTimeAccessed + ", dateTimeCreated=" + this.dateTimeCreated + ", originalSizeEvenForVolumes=" + this.originalSizeEvenForVolumes + ", name=" + this.name + ", comment=" + this.comment + ", extendedHeaders=" + Arrays.toString(this.extendedHeaders) + "]";
    }
}
