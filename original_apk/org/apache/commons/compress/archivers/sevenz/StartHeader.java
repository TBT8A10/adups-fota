package org.apache.commons.compress.archivers.sevenz;

class StartHeader {
    long nextHeaderCrc;
    long nextHeaderOffset;
    long nextHeaderSize;

    StartHeader() {
    }
}
