package org.apache.commons.compress.archivers.zip;

public final class UnparseableExtraFieldData implements ZipExtraField {
    private static final ZipShort HEADER_ID = new ZipShort(44225);
    private byte[] centralDirectoryData;
    private byte[] localFileData;

    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.centralDirectoryData;
        return bArr == null ? getLocalFileDataData() : ZipUtil.copy(bArr);
    }

    public ZipShort getCentralDirectoryLength() {
        byte[] bArr = this.centralDirectoryData;
        return bArr == null ? getLocalFileDataLength() : new ZipShort(bArr.length);
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localFileData);
    }

    public ZipShort getLocalFileDataLength() {
        byte[] bArr = this.localFileData;
        return new ZipShort(bArr == null ? 0 : bArr.length);
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        this.centralDirectoryData = new byte[i2];
        System.arraycopy(bArr, i, this.centralDirectoryData, 0, i2);
        if (this.localFileData == null) {
            parseFromLocalFileData(bArr, i, i2);
        }
    }

    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        this.localFileData = new byte[i2];
        System.arraycopy(bArr, i, this.localFileData, 0, i2);
    }
}
