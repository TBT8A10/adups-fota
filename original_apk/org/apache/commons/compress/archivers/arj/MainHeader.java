package org.apache.commons.compress.archivers.arj;

import java.util.Arrays;

class MainHeader {
    long archiveSize;
    int archiverVersionNumber;
    int arjFlags;
    int arjFlags2;
    int arjProtectionFactor;
    String comment;
    int dateTimeCreated;
    int dateTimeModified;
    int encryptionVersion;
    byte[] extendedHeaderBytes = null;
    int fileSpecPosition;
    int fileType;
    int hostOS;
    int lastChapter;
    int minVersionToExtract;
    String name;
    int reserved;
    int securityEnvelopeFilePosition;
    int securityEnvelopeLength;
    int securityVersion;

    static class Flags {
        static final int ALTNAME = 128;
        static final int ARJPROT = 8;
        static final int BACKUP = 32;
        static final int GARBLED = 1;
        static final int OLD_SECURED_NEW_ANSI_PAGE = 2;
        static final int PATHSYM = 16;
        static final int SECURED = 64;
        static final int VOLUME = 4;

        Flags() {
        }
    }

    MainHeader() {
    }

    public String toString() {
        return "MainHeader [archiverVersionNumber=" + this.archiverVersionNumber + ", minVersionToExtract=" + this.minVersionToExtract + ", hostOS=" + this.hostOS + ", arjFlags=" + this.arjFlags + ", securityVersion=" + this.securityVersion + ", fileType=" + this.fileType + ", reserved=" + this.reserved + ", dateTimeCreated=" + this.dateTimeCreated + ", dateTimeModified=" + this.dateTimeModified + ", archiveSize=" + this.archiveSize + ", securityEnvelopeFilePosition=" + this.securityEnvelopeFilePosition + ", fileSpecPosition=" + this.fileSpecPosition + ", securityEnvelopeLength=" + this.securityEnvelopeLength + ", encryptionVersion=" + this.encryptionVersion + ", lastChapter=" + this.lastChapter + ", arjProtectionFactor=" + this.arjProtectionFactor + ", arjFlags2=" + this.arjFlags2 + ", name=" + this.name + ", comment=" + this.comment + ", extendedHeaderBytes=" + Arrays.toString(this.extendedHeaderBytes) + "]";
    }
}
