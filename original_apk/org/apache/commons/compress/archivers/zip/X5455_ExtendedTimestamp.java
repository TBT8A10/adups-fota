package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.util.Date;
import java.util.zip.ZipException;

public class X5455_ExtendedTimestamp implements ZipExtraField, Cloneable, Serializable {
    public static final byte ACCESS_TIME_BIT = 2;
    public static final byte CREATE_TIME_BIT = 4;
    private static final ZipShort HEADER_ID = new ZipShort(21589);
    public static final byte MODIFY_TIME_BIT = 1;
    private static final long serialVersionUID = 1;
    private ZipLong accessTime;
    private boolean bit0_modifyTimePresent;
    private boolean bit1_accessTimePresent;
    private boolean bit2_createTimePresent;
    private ZipLong createTime;
    private byte flags;
    private ZipLong modifyTime;

    private static ZipLong dateToZipLong(Date date) {
        if (date == null) {
            return null;
        }
        long time = date.getTime() / 1000;
        if (time < 4294967296L) {
            return new ZipLong(time);
        }
        throw new IllegalArgumentException("Cannot set an X5455 timestamp larger than 2^32: " + time);
    }

    private void reset() {
        setFlags((byte) 0);
        this.modifyTime = null;
        this.accessTime = null;
        this.createTime = null;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof X5455_ExtendedTimestamp)) {
            return false;
        }
        X5455_ExtendedTimestamp x5455_ExtendedTimestamp = (X5455_ExtendedTimestamp) obj;
        if ((this.flags & 7) != (x5455_ExtendedTimestamp.flags & 7)) {
            return false;
        }
        ZipLong zipLong = this.modifyTime;
        ZipLong zipLong2 = x5455_ExtendedTimestamp.modifyTime;
        if (zipLong != zipLong2 && (zipLong == null || !zipLong.equals(zipLong2))) {
            return false;
        }
        ZipLong zipLong3 = this.accessTime;
        ZipLong zipLong4 = x5455_ExtendedTimestamp.accessTime;
        if (zipLong3 != zipLong4 && (zipLong3 == null || !zipLong3.equals(zipLong4))) {
            return false;
        }
        ZipLong zipLong5 = this.createTime;
        ZipLong zipLong6 = x5455_ExtendedTimestamp.createTime;
        if (zipLong5 == zipLong6 || (zipLong5 != null && zipLong5.equals(zipLong6))) {
            return true;
        }
        return false;
    }

    public Date getAccessJavaTime() {
        ZipLong zipLong = this.accessTime;
        if (zipLong != null) {
            return new Date(zipLong.getValue() * 1000);
        }
        return null;
    }

    public ZipLong getAccessTime() {
        return this.accessTime;
    }

    public byte[] getCentralDirectoryData() {
        byte[] bArr = new byte[getCentralDirectoryLength().getValue()];
        System.arraycopy(getLocalFileDataData(), 0, bArr, 0, bArr.length);
        return bArr;
    }

    public ZipShort getCentralDirectoryLength() {
        return new ZipShort((this.bit0_modifyTimePresent ? 4 : 0) + 1);
    }

    public Date getCreateJavaTime() {
        ZipLong zipLong = this.createTime;
        if (zipLong != null) {
            return new Date(zipLong.getValue() * 1000);
        }
        return null;
    }

    public ZipLong getCreateTime() {
        return this.createTime;
    }

    public byte getFlags() {
        return this.flags;
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public byte[] getLocalFileDataData() {
        ZipLong zipLong;
        ZipLong zipLong2;
        byte[] bArr = new byte[getLocalFileDataLength().getValue()];
        bArr[0] = 0;
        int i = 1;
        if (this.bit0_modifyTimePresent) {
            bArr[0] = (byte) (bArr[0] | 1);
            System.arraycopy(this.modifyTime.getBytes(), 0, bArr, 1, 4);
            i = 5;
        }
        if (this.bit1_accessTimePresent && (zipLong2 = this.accessTime) != null) {
            bArr[0] = (byte) (bArr[0] | 2);
            System.arraycopy(zipLong2.getBytes(), 0, bArr, i, 4);
            i += 4;
        }
        if (this.bit2_createTimePresent && (zipLong = this.createTime) != null) {
            bArr[0] = (byte) (bArr[0] | 4);
            System.arraycopy(zipLong.getBytes(), 0, bArr, i, 4);
        }
        return bArr;
    }

    public ZipShort getLocalFileDataLength() {
        int i = 4;
        int i2 = (this.bit0_modifyTimePresent ? 4 : 0) + 1 + ((!this.bit1_accessTimePresent || this.accessTime == null) ? 0 : 4);
        if (!this.bit2_createTimePresent || this.createTime == null) {
            i = 0;
        }
        return new ZipShort(i2 + i);
    }

    public Date getModifyJavaTime() {
        ZipLong zipLong = this.modifyTime;
        if (zipLong != null) {
            return new Date(zipLong.getValue() * 1000);
        }
        return null;
    }

    public ZipLong getModifyTime() {
        return this.modifyTime;
    }

    public int hashCode() {
        int i = (this.flags & 7) * -123;
        ZipLong zipLong = this.modifyTime;
        if (zipLong != null) {
            i ^= zipLong.hashCode();
        }
        ZipLong zipLong2 = this.accessTime;
        if (zipLong2 != null) {
            i ^= Integer.rotateLeft(zipLong2.hashCode(), 11);
        }
        ZipLong zipLong3 = this.createTime;
        return zipLong3 != null ? i ^ Integer.rotateLeft(zipLong3.hashCode(), 22) : i;
    }

    public boolean isBit0_modifyTimePresent() {
        return this.bit0_modifyTimePresent;
    }

    public boolean isBit1_accessTimePresent() {
        return this.bit1_accessTimePresent;
    }

    public boolean isBit2_createTimePresent() {
        return this.bit2_createTimePresent;
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) throws ZipException {
        reset();
        parseFromLocalFileData(bArr, i, i2);
    }

    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws ZipException {
        int i3;
        reset();
        int i4 = i2 + i;
        int i5 = i + 1;
        setFlags(bArr[i]);
        if (this.bit0_modifyTimePresent) {
            this.modifyTime = new ZipLong(bArr, i5);
            i5 += 4;
        }
        if (!this.bit1_accessTimePresent || (i3 = i5 + 4) > i4) {
            i3 = i5;
        } else {
            this.accessTime = new ZipLong(bArr, i5);
        }
        if (this.bit2_createTimePresent && i3 + 4 <= i4) {
            this.createTime = new ZipLong(bArr, i3);
        }
    }

    public void setAccessJavaTime(Date date) {
        setAccessTime(dateToZipLong(date));
    }

    public void setAccessTime(ZipLong zipLong) {
        this.bit1_accessTimePresent = zipLong != null;
        this.flags = (byte) (zipLong != null ? this.flags | 2 : this.flags & -3);
        this.accessTime = zipLong;
    }

    public void setCreateJavaTime(Date date) {
        setCreateTime(dateToZipLong(date));
    }

    public void setCreateTime(ZipLong zipLong) {
        this.bit2_createTimePresent = zipLong != null;
        this.flags = (byte) (zipLong != null ? this.flags | 4 : this.flags & -5);
        this.createTime = zipLong;
    }

    public void setFlags(byte b2) {
        this.flags = b2;
        boolean z = false;
        this.bit0_modifyTimePresent = (b2 & 1) == 1;
        this.bit1_accessTimePresent = (b2 & 2) == 2;
        if ((b2 & 4) == 4) {
            z = true;
        }
        this.bit2_createTimePresent = z;
    }

    public void setModifyJavaTime(Date date) {
        setModifyTime(dateToZipLong(date));
    }

    public void setModifyTime(ZipLong zipLong) {
        this.bit0_modifyTimePresent = zipLong != null;
        this.flags = (byte) (zipLong != null ? 1 | this.flags : this.flags & -2);
        this.modifyTime = zipLong;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("0x5455 Zip Extra Field: Flags=");
        sb.append(Integer.toBinaryString(ZipUtil.unsignedIntToSignedByte(this.flags)));
        sb.append(" ");
        if (this.bit0_modifyTimePresent && this.modifyTime != null) {
            Date modifyJavaTime = getModifyJavaTime();
            sb.append(" Modify:[");
            sb.append(modifyJavaTime);
            sb.append("] ");
        }
        if (this.bit1_accessTimePresent && this.accessTime != null) {
            Date accessJavaTime = getAccessJavaTime();
            sb.append(" Access:[");
            sb.append(accessJavaTime);
            sb.append("] ");
        }
        if (this.bit2_createTimePresent && this.createTime != null) {
            Date createJavaTime = getCreateJavaTime();
            sb.append(" Create:[");
            sb.append(createJavaTime);
            sb.append("] ");
        }
        return sb.toString();
    }
}
