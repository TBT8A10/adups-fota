package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

public final class JarMarker implements ZipExtraField {
    private static final JarMarker DEFAULT = new JarMarker();
    private static final ZipShort ID = new ZipShort(51966);
    private static final byte[] NO_BYTES = new byte[0];
    private static final ZipShort NULL = new ZipShort(0);

    public static JarMarker getInstance() {
        return DEFAULT;
    }

    public byte[] getCentralDirectoryData() {
        return NO_BYTES;
    }

    public ZipShort getCentralDirectoryLength() {
        return NULL;
    }

    public ZipShort getHeaderId() {
        return ID;
    }

    public byte[] getLocalFileDataData() {
        return NO_BYTES;
    }

    public ZipShort getLocalFileDataLength() {
        return NULL;
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) throws ZipException {
        parseFromLocalFileData(bArr, i, i2);
    }

    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 != 0) {
            throw new ZipException("JarMarker doesn't expect any data");
        }
    }
}
