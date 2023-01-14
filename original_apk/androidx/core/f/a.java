package androidx.core.f;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* compiled from: BidiFormatter */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final d f628a = e.f650c;

    /* renamed from: b  reason: collision with root package name */
    private static final String f629b = Character.toString(8206);

    /* renamed from: c  reason: collision with root package name */
    private static final String f630c = Character.toString(8207);
    static final a d = new a(false, 2, f628a);
    static final a e = new a(true, 2, f628a);
    private final boolean f;
    private final int g;
    private final d h;

    /* renamed from: androidx.core.f.a$a  reason: collision with other inner class name */
    /* compiled from: BidiFormatter */
    public static final class C0009a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f631a;

        /* renamed from: b  reason: collision with root package name */
        private int f632b;

        /* renamed from: c  reason: collision with root package name */
        private d f633c;

        public C0009a() {
            b(a.a(Locale.getDefault()));
        }

        private static a a(boolean z) {
            return z ? a.e : a.d;
        }

        private void b(boolean z) {
            this.f631a = z;
            this.f633c = a.f628a;
            this.f632b = 2;
        }

        public a a() {
            if (this.f632b == 2 && this.f633c == a.f628a) {
                return a(this.f631a);
            }
            return new a(this.f631a, this.f632b, this.f633c);
        }
    }

    /* compiled from: BidiFormatter */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f634a = new byte[1792];

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f635b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f636c;
        private final int d;
        private int e;
        private char f;

        static {
            for (int i = 0; i < 1792; i++) {
                f634a[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.f635b = charSequence;
            this.f636c = z;
            this.d = charSequence.length();
        }

        private static byte a(char c2) {
            return c2 < 1792 ? f634a[c2] : Character.getDirectionality(c2);
        }

        private byte e() {
            char c2;
            int i = this.e;
            do {
                int i2 = this.e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f635b;
                int i3 = i2 - 1;
                this.e = i3;
                this.f = charSequence.charAt(i3);
                c2 = this.f;
                if (c2 == '&') {
                    return 12;
                }
            } while (c2 != ';');
            this.e = i;
            this.f = ';';
            return 13;
        }

        private byte f() {
            char charAt;
            do {
                int i = this.e;
                if (i >= this.d) {
                    return 12;
                }
                CharSequence charSequence = this.f635b;
                this.e = i + 1;
                charAt = charSequence.charAt(i);
                this.f = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte g() {
            char charAt;
            int i = this.e;
            while (true) {
                int i2 = this.e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f635b;
                int i3 = i2 - 1;
                this.e = i3;
                this.f = charSequence.charAt(i3);
                char c2 = this.f;
                if (c2 == '<') {
                    return 12;
                }
                if (c2 == '>') {
                    break;
                } else if (c2 == '\"' || c2 == '\'') {
                    char c3 = this.f;
                    do {
                        int i4 = this.e;
                        if (i4 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f635b;
                        int i5 = i4 - 1;
                        this.e = i5;
                        charAt = charSequence2.charAt(i5);
                        this.f = charAt;
                    } while (charAt != c3);
                }
            }
            this.e = i;
            this.f = '>';
            return 13;
        }

        private byte h() {
            char charAt;
            int i = this.e;
            while (true) {
                int i2 = this.e;
                if (i2 < this.d) {
                    CharSequence charSequence = this.f635b;
                    this.e = i2 + 1;
                    this.f = charSequence.charAt(i2);
                    char c2 = this.f;
                    if (c2 == '>') {
                        return 12;
                    }
                    if (c2 == '\"' || c2 == '\'') {
                        char c3 = this.f;
                        do {
                            int i3 = this.e;
                            if (i3 >= this.d) {
                                break;
                            }
                            CharSequence charSequence2 = this.f635b;
                            this.e = i3 + 1;
                            charAt = charSequence2.charAt(i3);
                            this.f = charAt;
                        } while (charAt != c3);
                    }
                } else {
                    this.e = i;
                    this.f = '<';
                    return 13;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public byte b() {
            this.f = this.f635b.charAt(this.e);
            if (Character.isHighSurrogate(this.f)) {
                int codePointAt = Character.codePointAt(this.f635b, this.e);
                this.e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.e++;
            byte a2 = a(this.f);
            if (!this.f636c) {
                return a2;
            }
            char c2 = this.f;
            if (c2 == '<') {
                return h();
            }
            return c2 == '&' ? f() : a2;
        }

        /* access modifiers changed from: package-private */
        public int c() {
            this.e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.e < this.d && i == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.e > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            r2 = r2 - 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int d() {
            /*
                r7 = this;
                int r0 = r7.d
                r7.e = r0
                r0 = 0
                r1 = 0
                r2 = 0
            L_0x0007:
                int r3 = r7.e
                if (r3 <= 0) goto L_0x003b
                byte r3 = r7.a()
                r4 = -1
                if (r3 == 0) goto L_0x0034
                r5 = 1
                if (r3 == r5) goto L_0x002e
                r6 = 2
                if (r3 == r6) goto L_0x002e
                r6 = 9
                if (r3 == r6) goto L_0x0007
                switch(r3) {
                    case 14: goto L_0x0028;
                    case 15: goto L_0x0028;
                    case 16: goto L_0x0025;
                    case 17: goto L_0x0025;
                    case 18: goto L_0x0022;
                    default: goto L_0x001f;
                }
            L_0x001f:
                if (r1 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0022:
                int r2 = r2 + 1
                goto L_0x0007
            L_0x0025:
                if (r1 != r2) goto L_0x002b
                return r5
            L_0x0028:
                if (r1 != r2) goto L_0x002b
                return r4
            L_0x002b:
                int r2 = r2 + -1
                goto L_0x0007
            L_0x002e:
                if (r2 != 0) goto L_0x0031
                return r5
            L_0x0031:
                if (r1 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0034:
                if (r2 != 0) goto L_0x0037
                return r4
            L_0x0037:
                if (r1 != 0) goto L_0x0007
            L_0x0039:
                r1 = r2
                goto L_0x0007
            L_0x003b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.f.a.b.d():int");
        }

        /* access modifiers changed from: package-private */
        public byte a() {
            this.f = this.f635b.charAt(this.e - 1);
            if (Character.isLowSurrogate(this.f)) {
                int codePointBefore = Character.codePointBefore(this.f635b, this.e);
                this.e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.e--;
            byte a2 = a(this.f);
            if (!this.f636c) {
                return a2;
            }
            char c2 = this.f;
            if (c2 == '>') {
                return g();
            }
            return c2 == ';' ? e() : a2;
        }
    }

    a(boolean z, int i, d dVar) {
        this.f = z;
        this.g = i;
        this.h = dVar;
    }

    public static a a() {
        return new C0009a().a();
    }

    private static int c(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public boolean b() {
        return (this.g & 2) != 0;
    }

    private String a(CharSequence charSequence, d dVar) {
        boolean isRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        if (!this.f && (isRtl || c(charSequence) == 1)) {
            return f629b;
        }
        if (this.f) {
            return (!isRtl || c(charSequence) == -1) ? f630c : "";
        }
        return "";
    }

    private String b(CharSequence charSequence, d dVar) {
        boolean isRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        if (!this.f && (isRtl || b(charSequence) == 1)) {
            return f629b;
        }
        if (this.f) {
            return (!isRtl || b(charSequence) == -1) ? f630c : "";
        }
        return "";
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).c();
    }

    public CharSequence a(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (b() && z) {
            spannableStringBuilder.append(b(charSequence, isRtl ? e.f649b : e.f648a));
        }
        if (isRtl != this.f) {
            spannableStringBuilder.append(isRtl ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(a_shaKey_method2(charSequence, isRtl ? e.f649b : e.f648a));
        }
        return spannableStringBuilder;
    }

    public CharSequence a(CharSequence charSequence) {
        return a(charSequence, this.h, true);
    }

    static boolean a(Locale locale) {
        return f.a(locale) == 1;
    }
}
