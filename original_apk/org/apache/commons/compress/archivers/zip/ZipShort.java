package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;

public final class ZipShort implements Cloneable, Serializable {
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private static final long serialVersionUID = 1;
    private final int value;

    public ZipShort(int i) {
        this.value = i;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ZipShort) || this.value != ((ZipShort) obj).getValue()) {
            return false;
        }
        return true;
    }

    public byte[] getBytes() {
        int i = this.value;
        return new byte[]{(byte) (i & 255), (byte) ((i & BYTE_1_MASK) >> 8)};
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return "ZipShort value: " + this.value;
    }

    public static int getValue(byte[] bArr, int i) {
        return ((bArr[i + 1] << 8) & BYTE_1_MASK) + (bArr[i] & 255);
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public static byte[] getBytes(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i & BYTE_1_MASK) >> 8)};
    }

    public ZipShort(byte[] bArr, int i) {
        this.value = getValue(bArr, i);
    }

    public static int getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }
}
