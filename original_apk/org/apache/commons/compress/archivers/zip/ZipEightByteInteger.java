package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.math.BigInteger;

public final class ZipEightByteInteger implements Serializable {
    private static final int BYTE_1 = 1;
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private static final int BYTE_2 = 2;
    private static final int BYTE_2_MASK = 16711680;
    private static final int BYTE_2_SHIFT = 16;
    private static final int BYTE_3 = 3;
    private static final long BYTE_3_MASK = 4278190080L;
    private static final int BYTE_3_SHIFT = 24;
    private static final int BYTE_4 = 4;
    private static final long BYTE_4_MASK = 1095216660480L;
    private static final int BYTE_4_SHIFT = 32;
    private static final int BYTE_5 = 5;
    private static final long BYTE_5_MASK = 280375465082880L;
    private static final int BYTE_5_SHIFT = 40;
    private static final int BYTE_6 = 6;
    private static final long BYTE_6_MASK = 71776119061217280L;
    private static final int BYTE_6_SHIFT = 48;
    private static final int BYTE_7 = 7;
    private static final long BYTE_7_MASK = 9151314442816847872L;
    private static final int BYTE_7_SHIFT = 56;
    private static final byte LEFTMOST_BIT = Byte.MIN_VALUE;
    private static final int LEFTMOST_BIT_SHIFT = 63;
    public static final ZipEightByteInteger ZERO = new ZipEightByteInteger(0);
    private static final long serialVersionUID = 1;
    private final BigInteger value;

    public ZipEightByteInteger(long j) {
        this(BigInteger.valueOf(j));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ZipEightByteInteger)) {
            return false;
        }
        return this.value.equals(((ZipEightByteInteger) obj).getValue());
    }

    public byte[] getBytes() {
        return getBytes(this.value);
    }

    public long getLongValue() {
        return this.value.longValue();
    }

    public BigInteger getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "ZipEightByteInteger value: " + this.value;
    }

    public ZipEightByteInteger(BigInteger bigInteger) {
        this.value = bigInteger;
    }

    public static byte[] getBytes(long j) {
        return getBytes(BigInteger.valueOf(j));
    }

    public static long getLongValue(byte[] bArr, int i) {
        return getValue(bArr, i).longValue();
    }

    public static BigInteger getValue(byte[] bArr, int i) {
        int i2 = i + 7;
        BigInteger valueOf = BigInteger.valueOf(((((long) bArr[i2]) << 56) & BYTE_7_MASK) + ((((long) bArr[i + 6]) << 48) & BYTE_6_MASK) + ((((long) bArr[i + 5]) << 40) & BYTE_5_MASK) + ((((long) bArr[i + 4]) << 32) & BYTE_4_MASK) + ((((long) bArr[i + 3]) << 24) & BYTE_3_MASK) + ((((long) bArr[i + 2]) << 16) & 16711680) + ((((long) bArr[i + 1]) << 8) & 65280) + (((long) bArr[i]) & 255));
        return (bArr[i2] & LEFTMOST_BIT) == Byte.MIN_VALUE ? valueOf.setBit(63) : valueOf;
    }

    public static byte[] getBytes(BigInteger bigInteger) {
        long longValue = bigInteger.longValue();
        byte[] bArr = {(byte) ((int) (255 & longValue)), (byte) ((int) ((65280 & longValue) >> 8)), (byte) ((int) ((16711680 & longValue) >> 16)), (byte) ((int) ((BYTE_3_MASK & longValue) >> 24)), (byte) ((int) ((BYTE_4_MASK & longValue) >> 32)), (byte) ((int) ((BYTE_5_MASK & longValue) >> 40)), (byte) ((int) ((BYTE_6_MASK & longValue) >> 48)), (byte) ((int) ((longValue & BYTE_7_MASK) >> 56))};
        if (bigInteger.testBit(63)) {
            bArr[7] = (byte) (bArr[7] | LEFTMOST_BIT);
        }
        return bArr;
    }

    public static long getLongValue(byte[] bArr) {
        return getLongValue(bArr, 0);
    }

    public ZipEightByteInteger(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipEightByteInteger(byte[] bArr, int i) {
        this.value = getValue(bArr, i);
    }

    public static BigInteger getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }
}
