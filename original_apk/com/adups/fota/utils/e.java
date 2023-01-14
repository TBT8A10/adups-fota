package com.adups.fota.utils;

import javax.security.auth.x500.X500Principal;

/* compiled from: DistinguishedNameParser */
final class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f1626a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1627b = this.f1626a.length();

    /* renamed from: c  reason: collision with root package name */
    private int f1628c;
    private int d;
    private int e;
    private int f;
    private char[] g;

    public e(X500Principal x500Principal) {
        this.f1626a = x500Principal.getName("RFC2253");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r1 = r8.g;
        r2 = r8.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f - r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f1628c
            r8.d = r0
            r8.e = r0
        L_0x0006:
            int r0 = r8.f1628c
            int r1 = r8.f1627b
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.g
            int r2 = r8.d
            int r3 = r8.e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x0060
            if (r2 == r5) goto L_0x0053
            r5 = 92
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0053
            if (r2 == r3) goto L_0x0053
            int r2 = r8.e
            int r3 = r2 + 1
            r8.e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f1628c = r0
            goto L_0x0006
        L_0x0040:
            int r0 = r8.e
            int r2 = r0 + 1
            r8.e = r2
            char r2 = r8.b()
            r1[r0] = r2
            int r0 = r8.f1628c
            int r0 = r0 + 1
            r8.f1628c = r0
            goto L_0x0006
        L_0x0053:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.g
            int r2 = r8.d
            int r3 = r8.e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0060:
            int r2 = r8.e
            r8.f = r2
            int r0 = r0 + 1
            r8.f1628c = r0
            int r0 = r2 + 1
            r8.e = r0
            r1[r2] = r6
        L_0x006e:
            int r0 = r8.f1628c
            int r1 = r8.f1627b
            if (r0 >= r1) goto L_0x0087
            char[] r1 = r8.g
            char r2 = r1[r0]
            if (r2 != r6) goto L_0x0087
            int r2 = r8.e
            int r7 = r2 + 1
            r8.e = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.f1628c = r0
            goto L_0x006e
        L_0x0087:
            int r0 = r8.f1628c
            int r1 = r8.f1627b
            if (r0 == r1) goto L_0x009b
            char[] r1 = r8.g
            char r2 = r1[r0]
            if (r2 == r3) goto L_0x009b
            char r2 = r1[r0]
            if (r2 == r4) goto L_0x009b
            char r0 = r1[r0]
            if (r0 != r5) goto L_0x0006
        L_0x009b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.g
            int r2 = r8.d
            int r3 = r8.f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.e.a():java.lang.String");
    }

    private char b() {
        this.f1628c++;
        int i = this.f1628c;
        if (i != this.f1627b) {
            char c2 = this.g[i];
            if (!(c2 == ' ' || c2 == '%' || c2 == '\\' || c2 == '_' || c2 == '\"' || c2 == '#')) {
                switch (c2) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c2) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return c();
                        }
                }
            }
            return this.g[this.f1628c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f1626a);
    }

    private char c() {
        int i;
        int i2;
        int a2 = a(this.f1628c);
        this.f1628c++;
        if (a2 < 128) {
            return (char) a2;
        }
        if (a2 < 192 || a2 > 247) {
            return '?';
        }
        if (a2 <= 223) {
            i2 = a2 & 31;
            i = 1;
        } else if (a2 <= 239) {
            i = 2;
            i2 = a2 & 15;
        } else {
            i = 3;
            i2 = a2 & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f1628c++;
            int i4 = this.f1628c;
            if (i4 == this.f1627b || this.g[i4] != '\\') {
                return '?';
            }
            this.f1628c = i4 + 1;
            int a3 = a(this.f1628c);
            this.f1628c++;
            if ((a3 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a3 & 63);
        }
        return (char) i2;
    }

    private String d() {
        int i = this.f1628c;
        if (i + 4 < this.f1627b) {
            this.d = i;
            this.f1628c = i + 1;
            while (true) {
                int i2 = this.f1628c;
                if (i2 == this.f1627b) {
                    break;
                }
                char[] cArr = this.g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.e = i2;
                    this.f1628c = i2 + 1;
                    while (true) {
                        int i3 = this.f1628c;
                        if (i3 >= this.f1627b || this.g[i3] != ' ') {
                            break;
                        }
                        this.f1628c = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.f1628c++;
                }
            }
            this.e = this.f1628c;
            int i4 = this.e;
            int i5 = this.d;
            int i6 = i4 - i5;
            if (i6 < 5 || (i6 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f1626a);
            }
            byte[] bArr = new byte[(i6 / 2)];
            int i7 = i5 + 1;
            for (int i8 = 0; i8 < bArr.length; i8++) {
                bArr[i8] = (byte) a(i7);
                i7 += 2;
            }
            return new String(this.g, this.d, i6);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f1626a);
    }

    private String e() {
        while (true) {
            int i = this.f1628c;
            if (i >= this.f1627b || this.g[i] != ' ') {
                int i2 = this.f1628c;
            } else {
                this.f1628c = i + 1;
            }
        }
        int i22 = this.f1628c;
        if (i22 == this.f1627b) {
            return null;
        }
        this.d = i22;
        this.f1628c = i22 + 1;
        while (true) {
            int i3 = this.f1628c;
            if (i3 >= this.f1627b) {
                break;
            }
            char[] cArr = this.g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f1628c = i3 + 1;
        }
        int i4 = this.f1628c;
        if (i4 < this.f1627b) {
            this.e = i4;
            if (this.g[i4] == ' ') {
                while (true) {
                    int i5 = this.f1628c;
                    if (i5 >= this.f1627b) {
                        break;
                    }
                    char[] cArr2 = this.g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f1628c = i5 + 1;
                }
                char[] cArr3 = this.g;
                int i6 = this.f1628c;
                if (cArr3[i6] != '=' || i6 == this.f1627b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f1626a);
                }
            }
            this.f1628c++;
            while (true) {
                int i7 = this.f1628c;
                if (i7 >= this.f1627b || this.g[i7] != ' ') {
                    int i8 = this.e;
                    int i9 = this.d;
                } else {
                    this.f1628c = i7 + 1;
                }
            }
            int i82 = this.e;
            int i92 = this.d;
            if (i82 - i92 > 4) {
                char[] cArr4 = this.g;
                if (cArr4[i92 + 3] == '.' && (cArr4[i92] == 'O' || cArr4[i92] == 'o')) {
                    char[] cArr5 = this.g;
                    int i10 = this.d;
                    if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                        char[] cArr6 = this.g;
                        int i11 = this.d;
                        if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                            this.d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.g;
            int i12 = this.d;
            return new String(cArr7, i12, this.e - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f1626a);
    }

    private String f() {
        this.f1628c++;
        this.d = this.f1628c;
        this.e = this.d;
        while (true) {
            int i = this.f1628c;
            if (i != this.f1627b) {
                char[] cArr = this.g;
                if (cArr[i] == '\"') {
                    this.f1628c = i + 1;
                    while (true) {
                        int i2 = this.f1628c;
                        if (i2 >= this.f1627b || this.g[i2] != ' ') {
                            char[] cArr2 = this.g;
                            int i3 = this.d;
                        } else {
                            this.f1628c = i2 + 1;
                        }
                    }
                    char[] cArr22 = this.g;
                    int i32 = this.d;
                    return new String(cArr22, i32, this.e - i32);
                }
                if (cArr[i] == '\\') {
                    cArr[this.e] = b();
                } else {
                    cArr[this.e] = cArr[i];
                }
                this.f1628c++;
                this.e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f1626a);
            }
        }
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f1627b) {
            char c2 = this.g[i];
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f1626a);
            } else {
                i2 = c2 - '7';
            }
            char c3 = this.g[i4];
            if (c3 >= '0' && c3 <= '9') {
                i3 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i3 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f1626a);
            } else {
                i3 = c3 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f1626a);
    }

    public String a(String str) {
        String str2;
        this.f1628c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.f1626a.toCharArray();
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        do {
            int i = this.f1628c;
            if (i == this.f1627b) {
                return null;
            }
            char c2 = this.g[i];
            if (c2 == '\"') {
                str2 = f();
            } else if (c2 != '#') {
                str2 = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a();
            } else {
                str2 = d();
            }
            if (str.equalsIgnoreCase(e2)) {
                return str2;
            }
            int i2 = this.f1628c;
            if (i2 >= this.f1627b) {
                return null;
            }
            char[] cArr = this.g;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.f1628c++;
                e2 = e();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f1626a);
            }
        } while (e2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f1626a);
    }
}
