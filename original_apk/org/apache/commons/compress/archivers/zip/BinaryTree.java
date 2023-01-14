package org.apache.commons.compress.archivers.zip;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

class BinaryTree {
    private static final int NODE = -2;
    private static final int UNDEFINED = -1;
    private final int[] tree;

    public BinaryTree(int i) {
        this.tree = new int[((1 << (i + 1)) - 1)];
        Arrays.fill(this.tree, -1);
    }

    static BinaryTree decode(InputStream inputStream, int i) throws IOException {
        int read = inputStream.read() + 1;
        if (read != 0) {
            byte[] bArr = new byte[read];
            new DataInputStream(inputStream).readFully(bArr);
            int[] iArr = new int[i];
            int length = bArr.length;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < length) {
                byte b2 = bArr[i2];
                int i5 = ((b2 & 240) >> 4) + 1;
                int i6 = (b2 & 15) + 1;
                int i7 = i4;
                int i8 = 0;
                while (i8 < i5) {
                    iArr[i7] = i6;
                    i8++;
                    i7++;
                }
                i3 = Math.max(i3, i6);
                i2++;
                i4 = i7;
            }
            int[] iArr2 = new int[iArr.length];
            for (int i9 = 0; i9 < iArr2.length; i9++) {
                iArr2[i9] = i9;
            }
            int[] iArr3 = new int[iArr.length];
            int i10 = 0;
            int i11 = 0;
            while (i10 < iArr.length) {
                int i12 = i11;
                for (int i13 = 0; i13 < iArr.length; i13++) {
                    if (iArr[i13] == i10) {
                        iArr3[i12] = i10;
                        iArr2[i12] = i13;
                        i12++;
                    }
                }
                i10++;
                i11 = i12;
            }
            int[] iArr4 = new int[i];
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = i - 1; i17 >= 0; i17--) {
                i14 += i15;
                if (iArr3[i17] != i16) {
                    int i18 = iArr3[i17];
                    i16 = i18;
                    i15 = 1 << (16 - i18);
                }
                iArr4[iArr2[i17]] = i14;
            }
            BinaryTree binaryTree = new BinaryTree(i3);
            for (int i19 = 0; i19 < iArr4.length; i19++) {
                int i20 = iArr[i19];
                if (i20 > 0) {
                    binaryTree.addLeaf(0, Integer.reverse(iArr4[i19] << 16), i20, i19);
                }
            }
            return binaryTree;
        }
        throw new IOException("Cannot read the size of the encoded tree, unexpected end of stream");
    }

    public void addLeaf(int i, int i2, int i3, int i4) {
        if (i3 == 0) {
            int[] iArr = this.tree;
            if (iArr[i] == -1) {
                iArr[i] = i4;
                return;
            }
            throw new IllegalArgumentException("Tree value at index " + i + " has already been assigned (" + this.tree[i] + ")");
        }
        this.tree[i] = NODE;
        addLeaf((i * 2) + 1 + (i2 & 1), i2 >>> 1, i3 - 1, i4);
    }

    public int read(BitStream bitStream) throws IOException {
        int i = 0;
        while (true) {
            int nextBit = bitStream.nextBit();
            if (nextBit == -1) {
                return -1;
            }
            int i2 = (i * 2) + 1 + nextBit;
            int i3 = this.tree[i2];
            if (i3 == NODE) {
                i = i2;
            } else if (i3 != -1) {
                return i3;
            } else {
                throw new IOException("The child " + nextBit + " of node at index " + i + " is not defined");
            }
        }
    }
}
