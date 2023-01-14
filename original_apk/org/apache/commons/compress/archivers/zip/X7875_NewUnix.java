package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.zip.ZipException;

public class X7875_NewUnix implements ZipExtraField, Cloneable, Serializable {
    private static final ZipShort HEADER_ID = new ZipShort(30837);
    private static final BigInteger ONE_THOUSAND = BigInteger.valueOf(1000);
    private static final long serialVersionUID = 1;
    private BigInteger gid;
    private BigInteger uid;
    private int version = 1;

    public X7875_NewUnix() {
        reset();
    }

    private void reset() {
        BigInteger bigInteger = ONE_THOUSAND;
        this.uid = bigInteger;
        this.gid = bigInteger;
    }

    static byte[] trimLeadingZeroesForceMinLength(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length && bArr[i] == 0) {
            i2++;
            i++;
        }
        byte[] bArr2 = new byte[Math.max(1, bArr.length - i2)];
        int length2 = bArr2.length - (bArr.length - i2);
        System.arraycopy(bArr, i2, bArr2, length2, bArr2.length - length2);
        return bArr2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof X7875_NewUnix)) {
            return false;
        }
        X7875_NewUnix x7875_NewUnix = (X7875_NewUnix) obj;
        if (this.version != x7875_NewUnix.version || !this.uid.equals(x7875_NewUnix.uid) || !this.gid.equals(x7875_NewUnix.gid)) {
            return false;
        }
        return true;
    }

    public byte[] getCentralDirectoryData() {
        return getLocalFileDataData();
    }

    public ZipShort getCentralDirectoryLength() {
        return getLocalFileDataLength();
    }

    public long getGID() {
        return ZipUtil.bigToLong(this.gid);
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public byte[] getLocalFileDataData() {
        byte[] byteArray = this.uid.toByteArray();
        byte[] byteArray2 = this.gid.toByteArray();
        byte[] trimLeadingZeroesForceMinLength = trimLeadingZeroesForceMinLength(byteArray);
        byte[] trimLeadingZeroesForceMinLength2 = trimLeadingZeroesForceMinLength(byteArray2);
        byte[] bArr = new byte[(trimLeadingZeroesForceMinLength.length + 3 + trimLeadingZeroesForceMinLength2.length)];
        ZipUtil.reverse(trimLeadingZeroesForceMinLength);
        ZipUtil.reverse(trimLeadingZeroesForceMinLength2);
        bArr[0] = ZipUtil.unsignedIntToSignedByte(this.version);
        bArr[1] = ZipUtil.unsignedIntToSignedByte(trimLeadingZeroesForceMinLength.length);
        System.arraycopy(trimLeadingZeroesForceMinLength, 0, bArr, 2, trimLeadingZeroesForceMinLength.length);
        int length = 2 + trimLeadingZeroesForceMinLength.length;
        bArr[length] = ZipUtil.unsignedIntToSignedByte(trimLeadingZeroesForceMinLength2.length);
        System.arraycopy(trimLeadingZeroesForceMinLength2, 0, bArr, length + 1, trimLeadingZeroesForceMinLength2.length);
        return bArr;
    }

    public ZipShort getLocalFileDataLength() {
        return new ZipShort(trimLeadingZeroesForceMinLength(this.uid.toByteArray()).length + 3 + trimLeadingZeroesForceMinLength(this.gid.toByteArray()).length);
    }

    public long getUID() {
        return ZipUtil.bigToLong(this.uid);
    }

    public int hashCode() {
        return ((this.version * -1234567) ^ Integer.rotateLeft(this.uid.hashCode(), 16)) ^ this.gid.hashCode();
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) throws ZipException {
        reset();
        parseFromLocalFileData(bArr, i, i2);
    }

    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws ZipException {
        reset();
        int i3 = i + 1;
        this.version = ZipUtil.signedByteToUnsignedInt(bArr[i]);
        int i4 = i3 + 1;
        int signedByteToUnsignedInt = ZipUtil.signedByteToUnsignedInt(bArr[i3]);
        byte[] bArr2 = new byte[signedByteToUnsignedInt];
        System.arraycopy(bArr, i4, bArr2, 0, signedByteToUnsignedInt);
        int i5 = i4 + signedByteToUnsignedInt;
        ZipUtil.reverse(bArr2);
        this.uid = new BigInteger(1, bArr2);
        int i6 = i5 + 1;
        int signedByteToUnsignedInt2 = ZipUtil.signedByteToUnsignedInt(bArr[i5]);
        byte[] bArr3 = new byte[signedByteToUnsignedInt2];
        System.arraycopy(bArr, i6, bArr3, 0, signedByteToUnsignedInt2);
        ZipUtil.reverse(bArr3);
        this.gid = new BigInteger(1, bArr3);
    }

    public void setGID(long j) {
        this.gid = ZipUtil.longToBig(j);
    }

    public void setUID(long j) {
        this.uid = ZipUtil.longToBig(j);
    }

    public String toString() {
        return "0x7875 Zip Extra Field: UID=" + this.uid + " GID=" + this.gid;
    }
}
