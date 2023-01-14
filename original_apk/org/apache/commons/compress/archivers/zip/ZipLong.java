package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;

public final class ZipLong implements Cloneable, Serializable {
    public static final ZipLong AED_SIG = new ZipLong(134630224);
    private static final int BYTE_1 = 1;
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private static final int BYTE_2 = 2;
    private static final int BYTE_2_MASK = 16711680;
    private static final int BYTE_2_SHIFT = 16;
    private static final int BYTE_3 = 3;
    private static final long BYTE_3_MASK = 4278190080L;
    private static final int BYTE_3_SHIFT = 24;
    public static final ZipLong CFH_SIG = new ZipLong(33639248);
    public static final ZipLong DD_SIG = new ZipLong(134695760);
    public static final ZipLong LFH_SIG = new ZipLong(67324752);
    public static final ZipLong SINGLE_SEGMENT_SPLIT_MARKER = new ZipLong(808471376);
    static final ZipLong ZIP64_MAGIC = new ZipLong(4294967295L);
    private static final long serialVersionUID = 1;
    private final long value;

    public ZipLong(long j) {
        this.value = j;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ZipLong) || this.value != ((ZipLong) obj).getValue()) {
            return false;
        }
        return true;
    }

    public byte[] getBytes() {
        return getBytes(this.value);
    }

    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return (int) this.value;
    }

    public String toString() {
        return "ZipLong value: " + this.value;
    }

    public static byte[] getBytes(long j) {
        return new byte[]{(byte) ((int) (255 & j)), (byte) ((int) ((65280 & j) >> 8)), (byte) ((int) ((16711680 & j) >> 16)), (byte) ((int) ((j & BYTE_3_MASK) >> 24))};
    }

    public static long getValue(byte[] bArr, int i) {
        return (((long) (bArr[i + 3] << 24)) & BYTE_3_MASK) + ((long) ((bArr[i + 2] << 16) & BYTE_2_MASK)) + ((long) ((bArr[i + 1] << 8) & BYTE_1_MASK)) + ((long) (bArr[i] & 255));
    }

    public ZipLong(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipLong(byte[] bArr, int i) {
        this.value = getValue(bArr, i);
    }

    public static long getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }
}
