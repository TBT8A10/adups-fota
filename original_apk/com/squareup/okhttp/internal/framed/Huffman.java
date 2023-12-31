package com.squareup.okhttp.internal.framed;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

class Huffman {
    private static final int[] CODES;
    private static final byte[] CODE_LENGTHS;
    private static final Huffman INSTANCE = new Huffman();
    private final Node root = new Node();

    static {
        int[] iArr = new int[CpioConstants.C_IRUSR];
        // fill-array-data instruction
        iArr[0] = 8184;
        iArr[1] = 8388568;
        iArr[2] = 268435426;
        iArr[3] = 268435427;
        iArr[4] = 268435428;
        iArr[5] = 268435429;
        iArr[6] = 268435430;
        iArr[7] = 268435431;
        iArr[8] = 268435432;
        iArr[9] = 16777194;
        iArr[10] = 1073741820;
        iArr[11] = 268435433;
        iArr[12] = 268435434;
        iArr[13] = 1073741821;
        iArr[14] = 268435435;
        iArr[15] = 268435436;
        iArr[16] = 268435437;
        iArr[17] = 268435438;
        iArr[18] = 268435439;
        iArr[19] = 268435440;
        iArr[20] = 268435441;
        iArr[21] = 268435442;
        iArr[22] = 1073741822;
        iArr[23] = 268435443;
        iArr[24] = 268435444;
        iArr[25] = 268435445;
        iArr[26] = 268435446;
        iArr[27] = 268435447;
        iArr[28] = 268435448;
        iArr[29] = 268435449;
        iArr[30] = 268435450;
        iArr[31] = 268435451;
        iArr[32] = 20;
        iArr[33] = 1016;
        iArr[34] = 1017;
        iArr[35] = 4090;
        iArr[36] = 8185;
        iArr[37] = 21;
        iArr[38] = 248;
        iArr[39] = 2042;
        iArr[40] = 1018;
        iArr[41] = 1019;
        iArr[42] = 249;
        iArr[43] = 2043;
        iArr[44] = 250;
        iArr[45] = 22;
        iArr[46] = 23;
        iArr[47] = 24;
        iArr[48] = 0;
        iArr[49] = 1;
        iArr[50] = 2;
        iArr[51] = 25;
        iArr[52] = 26;
        iArr[53] = 27;
        iArr[54] = 28;
        iArr[55] = 29;
        iArr[56] = 30;
        iArr[57] = 31;
        iArr[58] = 92;
        iArr[59] = 251;
        iArr[60] = 32764;
        iArr[61] = 32;
        iArr[62] = 4091;
        iArr[63] = 1020;
        iArr[64] = 8186;
        iArr[65] = 33;
        iArr[66] = 93;
        iArr[67] = 94;
        iArr[68] = 95;
        iArr[69] = 96;
        iArr[70] = 97;
        iArr[71] = 98;
        iArr[72] = 99;
        iArr[73] = 100;
        iArr[74] = 101;
        iArr[75] = 102;
        iArr[76] = 103;
        iArr[77] = 104;
        iArr[78] = 105;
        iArr[79] = 106;
        iArr[80] = 107;
        iArr[81] = 108;
        iArr[82] = 109;
        iArr[83] = 110;
        iArr[84] = 111;
        iArr[85] = 112;
        iArr[86] = 113;
        iArr[87] = 114;
        iArr[88] = 252;
        iArr[89] = 115;
        iArr[90] = 253;
        iArr[91] = 8187;
        iArr[92] = 524272;
        iArr[93] = 8188;
        iArr[94] = 16380;
        iArr[95] = 34;
        iArr[96] = 32765;
        iArr[97] = 3;
        iArr[98] = 35;
        iArr[99] = 4;
        iArr[100] = 36;
        iArr[101] = 5;
        iArr[102] = 37;
        iArr[103] = 38;
        iArr[104] = 39;
        iArr[105] = 6;
        iArr[106] = 116;
        iArr[107] = 117;
        iArr[108] = 40;
        iArr[109] = 41;
        iArr[110] = 42;
        iArr[111] = 7;
        iArr[112] = 43;
        iArr[113] = 118;
        iArr[114] = 44;
        iArr[115] = 8;
        iArr[116] = 9;
        iArr[117] = 45;
        iArr[118] = 119;
        iArr[119] = 120;
        iArr[120] = 121;
        iArr[121] = 122;
        iArr[122] = 123;
        iArr[123] = 32766;
        iArr[124] = 2044;
        iArr[125] = 16381;
        iArr[126] = 8189;
        iArr[127] = 268435452;
        iArr[128] = 1048550;
        iArr[129] = 4194258;
        iArr[130] = 1048551;
        iArr[131] = 1048552;
        iArr[132] = 4194259;
        iArr[133] = 4194260;
        iArr[134] = 4194261;
        iArr[135] = 8388569;
        iArr[136] = 4194262;
        iArr[137] = 8388570;
        iArr[138] = 8388571;
        iArr[139] = 8388572;
        iArr[140] = 8388573;
        iArr[141] = 8388574;
        iArr[142] = 16777195;
        iArr[143] = 8388575;
        iArr[144] = 16777196;
        iArr[145] = 16777197;
        iArr[146] = 4194263;
        iArr[147] = 8388576;
        iArr[148] = 16777198;
        iArr[149] = 8388577;
        iArr[150] = 8388578;
        iArr[151] = 8388579;
        iArr[152] = 8388580;
        iArr[153] = 2097116;
        iArr[154] = 4194264;
        iArr[155] = 8388581;
        iArr[156] = 4194265;
        iArr[157] = 8388582;
        iArr[158] = 8388583;
        iArr[159] = 16777199;
        iArr[160] = 4194266;
        iArr[161] = 2097117;
        iArr[162] = 1048553;
        iArr[163] = 4194267;
        iArr[164] = 4194268;
        iArr[165] = 8388584;
        iArr[166] = 8388585;
        iArr[167] = 2097118;
        iArr[168] = 8388586;
        iArr[169] = 4194269;
        iArr[170] = 4194270;
        iArr[171] = 16777200;
        iArr[172] = 2097119;
        iArr[173] = 4194271;
        iArr[174] = 8388587;
        iArr[175] = 8388588;
        iArr[176] = 2097120;
        iArr[177] = 2097121;
        iArr[178] = 4194272;
        iArr[179] = 2097122;
        iArr[180] = 8388589;
        iArr[181] = 4194273;
        iArr[182] = 8388590;
        iArr[183] = 8388591;
        iArr[184] = 1048554;
        iArr[185] = 4194274;
        iArr[186] = 4194275;
        iArr[187] = 4194276;
        iArr[188] = 8388592;
        iArr[189] = 4194277;
        iArr[190] = 4194278;
        iArr[191] = 8388593;
        iArr[192] = 67108832;
        iArr[193] = 67108833;
        iArr[194] = 1048555;
        iArr[195] = 524273;
        iArr[196] = 4194279;
        iArr[197] = 8388594;
        iArr[198] = 4194280;
        iArr[199] = 33554412;
        iArr[200] = 67108834;
        iArr[201] = 67108835;
        iArr[202] = 67108836;
        iArr[203] = 134217694;
        iArr[204] = 134217695;
        iArr[205] = 67108837;
        iArr[206] = 16777201;
        iArr[207] = 33554413;
        iArr[208] = 524274;
        iArr[209] = 2097123;
        iArr[210] = 67108838;
        iArr[211] = 134217696;
        iArr[212] = 134217697;
        iArr[213] = 67108839;
        iArr[214] = 134217698;
        iArr[215] = 16777202;
        iArr[216] = 2097124;
        iArr[217] = 2097125;
        iArr[218] = 67108840;
        iArr[219] = 67108841;
        iArr[220] = 268435453;
        iArr[221] = 134217699;
        iArr[222] = 134217700;
        iArr[223] = 134217701;
        iArr[224] = 1048556;
        iArr[225] = 16777203;
        iArr[226] = 1048557;
        iArr[227] = 2097126;
        iArr[228] = 4194281;
        iArr[229] = 2097127;
        iArr[230] = 2097128;
        iArr[231] = 8388595;
        iArr[232] = 4194282;
        iArr[233] = 4194283;
        iArr[234] = 33554414;
        iArr[235] = 33554415;
        iArr[236] = 16777204;
        iArr[237] = 16777205;
        iArr[238] = 67108842;
        iArr[239] = 8388596;
        iArr[240] = 67108843;
        iArr[241] = 134217702;
        iArr[242] = 67108844;
        iArr[243] = 67108845;
        iArr[244] = 134217703;
        iArr[245] = 134217704;
        iArr[246] = 134217705;
        iArr[247] = 134217706;
        iArr[248] = 134217707;
        iArr[249] = 268435454;
        iArr[250] = 134217708;
        iArr[251] = 134217709;
        iArr[252] = 134217710;
        iArr[253] = 134217711;
        iArr[254] = 134217712;
        iArr[255] = 67108846;
        CODES = iArr;
        byte[] bArr = new byte[CpioConstants.C_IRUSR];
        // fill-array-data instruction
        bArr[0] = 13;
        bArr[1] = 23;
        bArr[2] = 28;
        bArr[3] = 28;
        bArr[4] = 28;
        bArr[5] = 28;
        bArr[6] = 28;
        bArr[7] = 28;
        bArr[8] = 28;
        bArr[9] = 24;
        bArr[10] = 30;
        bArr[11] = 28;
        bArr[12] = 28;
        bArr[13] = 30;
        bArr[14] = 28;
        bArr[15] = 28;
        bArr[16] = 28;
        bArr[17] = 28;
        bArr[18] = 28;
        bArr[19] = 28;
        bArr[20] = 28;
        bArr[21] = 28;
        bArr[22] = 30;
        bArr[23] = 28;
        bArr[24] = 28;
        bArr[25] = 28;
        bArr[26] = 28;
        bArr[27] = 28;
        bArr[28] = 28;
        bArr[29] = 28;
        bArr[30] = 28;
        bArr[31] = 28;
        bArr[32] = 6;
        bArr[33] = 10;
        bArr[34] = 10;
        bArr[35] = 12;
        bArr[36] = 13;
        bArr[37] = 6;
        bArr[38] = 8;
        bArr[39] = 11;
        bArr[40] = 10;
        bArr[41] = 10;
        bArr[42] = 8;
        bArr[43] = 11;
        bArr[44] = 8;
        bArr[45] = 6;
        bArr[46] = 6;
        bArr[47] = 6;
        bArr[48] = 5;
        bArr[49] = 5;
        bArr[50] = 5;
        bArr[51] = 6;
        bArr[52] = 6;
        bArr[53] = 6;
        bArr[54] = 6;
        bArr[55] = 6;
        bArr[56] = 6;
        bArr[57] = 6;
        bArr[58] = 7;
        bArr[59] = 8;
        bArr[60] = 15;
        bArr[61] = 6;
        bArr[62] = 12;
        bArr[63] = 10;
        bArr[64] = 13;
        bArr[65] = 6;
        bArr[66] = 7;
        bArr[67] = 7;
        bArr[68] = 7;
        bArr[69] = 7;
        bArr[70] = 7;
        bArr[71] = 7;
        bArr[72] = 7;
        bArr[73] = 7;
        bArr[74] = 7;
        bArr[75] = 7;
        bArr[76] = 7;
        bArr[77] = 7;
        bArr[78] = 7;
        bArr[79] = 7;
        bArr[80] = 7;
        bArr[81] = 7;
        bArr[82] = 7;
        bArr[83] = 7;
        bArr[84] = 7;
        bArr[85] = 7;
        bArr[86] = 7;
        bArr[87] = 7;
        bArr[88] = 8;
        bArr[89] = 7;
        bArr[90] = 8;
        bArr[91] = 13;
        bArr[92] = 19;
        bArr[93] = 13;
        bArr[94] = 14;
        bArr[95] = 6;
        bArr[96] = 15;
        bArr[97] = 5;
        bArr[98] = 6;
        bArr[99] = 5;
        bArr[100] = 6;
        bArr[101] = 5;
        bArr[102] = 6;
        bArr[103] = 6;
        bArr[104] = 6;
        bArr[105] = 5;
        bArr[106] = 7;
        bArr[107] = 7;
        bArr[108] = 6;
        bArr[109] = 6;
        bArr[110] = 6;
        bArr[111] = 5;
        bArr[112] = 6;
        bArr[113] = 7;
        bArr[114] = 6;
        bArr[115] = 5;
        bArr[116] = 5;
        bArr[117] = 6;
        bArr[118] = 7;
        bArr[119] = 7;
        bArr[120] = 7;
        bArr[121] = 7;
        bArr[122] = 7;
        bArr[123] = 15;
        bArr[124] = 11;
        bArr[125] = 14;
        bArr[126] = 13;
        bArr[127] = 28;
        bArr[128] = 20;
        bArr[129] = 22;
        bArr[130] = 20;
        bArr[131] = 20;
        bArr[132] = 22;
        bArr[133] = 22;
        bArr[134] = 22;
        bArr[135] = 23;
        bArr[136] = 22;
        bArr[137] = 23;
        bArr[138] = 23;
        bArr[139] = 23;
        bArr[140] = 23;
        bArr[141] = 23;
        bArr[142] = 24;
        bArr[143] = 23;
        bArr[144] = 24;
        bArr[145] = 24;
        bArr[146] = 22;
        bArr[147] = 23;
        bArr[148] = 24;
        bArr[149] = 23;
        bArr[150] = 23;
        bArr[151] = 23;
        bArr[152] = 23;
        bArr[153] = 21;
        bArr[154] = 22;
        bArr[155] = 23;
        bArr[156] = 22;
        bArr[157] = 23;
        bArr[158] = 23;
        bArr[159] = 24;
        bArr[160] = 22;
        bArr[161] = 21;
        bArr[162] = 20;
        bArr[163] = 22;
        bArr[164] = 22;
        bArr[165] = 23;
        bArr[166] = 23;
        bArr[167] = 21;
        bArr[168] = 23;
        bArr[169] = 22;
        bArr[170] = 22;
        bArr[171] = 24;
        bArr[172] = 21;
        bArr[173] = 22;
        bArr[174] = 23;
        bArr[175] = 23;
        bArr[176] = 21;
        bArr[177] = 21;
        bArr[178] = 22;
        bArr[179] = 21;
        bArr[180] = 23;
        bArr[181] = 22;
        bArr[182] = 23;
        bArr[183] = 23;
        bArr[184] = 20;
        bArr[185] = 22;
        bArr[186] = 22;
        bArr[187] = 22;
        bArr[188] = 23;
        bArr[189] = 22;
        bArr[190] = 22;
        bArr[191] = 23;
        bArr[192] = 26;
        bArr[193] = 26;
        bArr[194] = 20;
        bArr[195] = 19;
        bArr[196] = 22;
        bArr[197] = 23;
        bArr[198] = 22;
        bArr[199] = 25;
        bArr[200] = 26;
        bArr[201] = 26;
        bArr[202] = 26;
        bArr[203] = 27;
        bArr[204] = 27;
        bArr[205] = 26;
        bArr[206] = 24;
        bArr[207] = 25;
        bArr[208] = 19;
        bArr[209] = 21;
        bArr[210] = 26;
        bArr[211] = 27;
        bArr[212] = 27;
        bArr[213] = 26;
        bArr[214] = 27;
        bArr[215] = 24;
        bArr[216] = 21;
        bArr[217] = 21;
        bArr[218] = 26;
        bArr[219] = 26;
        bArr[220] = 28;
        bArr[221] = 27;
        bArr[222] = 27;
        bArr[223] = 27;
        bArr[224] = 20;
        bArr[225] = 24;
        bArr[226] = 20;
        bArr[227] = 21;
        bArr[228] = 22;
        bArr[229] = 21;
        bArr[230] = 21;
        bArr[231] = 23;
        bArr[232] = 22;
        bArr[233] = 22;
        bArr[234] = 25;
        bArr[235] = 25;
        bArr[236] = 24;
        bArr[237] = 24;
        bArr[238] = 26;
        bArr[239] = 23;
        bArr[240] = 26;
        bArr[241] = 27;
        bArr[242] = 26;
        bArr[243] = 26;
        bArr[244] = 27;
        bArr[245] = 27;
        bArr[246] = 27;
        bArr[247] = 27;
        bArr[248] = 27;
        bArr[249] = 28;
        bArr[250] = 27;
        bArr[251] = 27;
        bArr[252] = 27;
        bArr[253] = 27;
        bArr[254] = 27;
        bArr[255] = 26;
        CODE_LENGTHS = bArr;
    }

    private Huffman() {
        buildTree();
    }

    private void addCode(int i, int i2, byte b2) {
        Node node = new Node(i, b2);
        Node node2 = this.root;
        while (b2 > 8) {
            b2 = (byte) (b2 - 8);
            int i3 = (i2 >>> b2) & 255;
            if (node2.children != null) {
                if (node2.children[i3] == null) {
                    node2.children[i3] = new Node();
                }
                node2 = node2.children[i3];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i4 = 8 - b2;
        int i5 = (i2 << i4) & 255;
        int i6 = 1 << i4;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            node2.children[i7] = node;
        }
    }

    private void buildTree() {
        int i = 0;
        while (true) {
            byte[] bArr = CODE_LENGTHS;
            if (i < bArr.length) {
                addCode(i, CODES[i], bArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public static Huffman get() {
        return INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public byte[] decode(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Node node = this.root;
        byte b2 = 0;
        int i = 0;
        for (byte b3 : bArr) {
            b2 = (b2 << 8) | (b3 & 255);
            i += 8;
            while (i >= 8) {
                node = node.children[(b2 >>> (i - 8)) & 255];
                if (node.children == null) {
                    byteArrayOutputStream.write(node.symbol);
                    i -= node.terminalBits;
                    node = this.root;
                } else {
                    i -= 8;
                }
            }
        }
        while (i > 0) {
            Node node2 = node.children[(b2 << (8 - i)) & 255];
            if (node2.children != null || node2.terminalBits > i) {
                break;
            }
            byteArrayOutputStream.write(node2.symbol);
            i -= node2.terminalBits;
            node = this.root;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r9, java.io.OutputStream r10) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r2 = r1
            r1 = 0
        L_0x0005:
            int r4 = r9.length
            r5 = 8
            r6 = 255(0xff, float:3.57E-43)
            if (r0 >= r4) goto L_0x0029
            byte r4 = r9[r0]
            r4 = r4 & r6
            int[] r6 = CODES
            r6 = r6[r4]
            byte[] r7 = CODE_LENGTHS
            byte r4 = r7[r4]
            long r2 = r2 << r4
            long r6 = (long) r6
            long r2 = r2 | r6
            int r1 = r1 + r4
        L_0x001b:
            if (r1 < r5) goto L_0x0026
            int r1 = r1 + -8
            long r6 = r2 >> r1
            int r4 = (int) r6
            r10.write(r4)
            goto L_0x001b
        L_0x0026:
            int r0 = r0 + 1
            goto L_0x0005
        L_0x0029:
            if (r1 <= 0) goto L_0x0035
            int r5 = r5 - r1
            long r2 = r2 << r5
            int r9 = r6 >>> r1
            long r0 = (long) r9
            long r0 = r0 | r2
            int r9 = (int) r0
            r10.write(r9)
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.Huffman.encode(byte[], java.io.OutputStream):void");
    }

    /* access modifiers changed from: package-private */
    public int encodedLength(byte[] bArr) {
        long j = 0;
        for (byte b2 : bArr) {
            j += (long) CODE_LENGTHS[b2 & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    private static final class Node {
        /* access modifiers changed from: private */
        public final Node[] children;
        /* access modifiers changed from: private */
        public final int symbol;
        /* access modifiers changed from: private */
        public final int terminalBits;

        Node() {
            this.children = new Node[CpioConstants.C_IRUSR];
            this.symbol = 0;
            this.terminalBits = 0;
        }

        Node(int i, int i2) {
            this.children = null;
            this.symbol = i;
            int i3 = i2 & 7;
            this.terminalBits = i3 == 0 ? 8 : i3;
        }
    }
}
