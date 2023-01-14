package org.apache.commons.compress.archivers.zip;

import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
import org.apache.commons.compress.utils.CharsetNames;

public abstract class AbstractUnicodeExtraField implements ZipExtraField {
    private byte[] data;
    private long nameCRC32;
    private byte[] unicodeName;

    protected AbstractUnicodeExtraField() {
    }

    private void assembleData() {
        byte[] bArr = this.unicodeName;
        if (bArr != null) {
            this.data = new byte[(bArr.length + 5)];
            this.data[0] = 1;
            System.arraycopy(ZipLong.getBytes(this.nameCRC32), 0, this.data, 1, 4);
            byte[] bArr2 = this.unicodeName;
            System.arraycopy(bArr2, 0, this.data, 5, bArr2.length);
        }
    }

    public byte[] getCentralDirectoryData() {
        if (this.data == null) {
            assembleData();
        }
        byte[] bArr = this.data;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public ZipShort getCentralDirectoryLength() {
        if (this.data == null) {
            assembleData();
        }
        byte[] bArr = this.data;
        return new ZipShort(bArr != null ? bArr.length : 0);
    }

    public byte[] getLocalFileDataData() {
        return getCentralDirectoryData();
    }

    public ZipShort getLocalFileDataLength() {
        return getCentralDirectoryLength();
    }

    public long getNameCRC32() {
        return this.nameCRC32;
    }

    public byte[] getUnicodeName() {
        byte[] bArr = this.unicodeName;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) throws ZipException {
        parseFromLocalFileData(bArr, i, i2);
    }

    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 >= 5) {
            byte b2 = bArr[i];
            if (b2 == 1) {
                this.nameCRC32 = ZipLong.getValue(bArr, i + 1);
                int i3 = i2 - 5;
                this.unicodeName = new byte[i3];
                System.arraycopy(bArr, i + 5, this.unicodeName, 0, i3);
                this.data = null;
                return;
            }
            throw new ZipException("Unsupported version [" + b2 + "] for UniCode path extra data.");
        }
        throw new ZipException("UniCode path extra data must have at least 5 bytes.");
    }

    public void setNameCRC32(long j) {
        this.nameCRC32 = j;
        this.data = null;
    }

    public void setUnicodeName(byte[] bArr) {
        if (bArr != null) {
            this.unicodeName = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.unicodeName, 0, bArr.length);
        } else {
            this.unicodeName = null;
        }
        this.data = null;
    }

    protected AbstractUnicodeExtraField(String str, byte[] bArr, int i, int i2) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i, i2);
        this.nameCRC32 = crc32.getValue();
        try {
            this.unicodeName = str.getBytes(CharsetNames.UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("FATAL: UTF-8 encoding not supported.", e);
        }
    }

    protected AbstractUnicodeExtraField(String str, byte[] bArr) {
        this(str, bArr, 0, bArr.length);
    }
}
