package androidx.core.f;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f648a = new C0011e((c) null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final d f649b = new C0011e((c) null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final d f650c = new C0011e(b.f654a, false);
    public static final d d = new C0011e(b.f654a, true);
    public static final d e = new C0011e(a.f651a, false);
    public static final d f = f.f657b;

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        static final a f651a = new a(true);

        /* renamed from: b  reason: collision with root package name */
        static final a f652b = new a(false);

        /* renamed from: c  reason: collision with root package name */
        private final boolean f653c;

        private a(boolean z) {
            this.f653c = z;
        }

        public int checkRtl(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int a2 = e.a(Character.getDirectionality(charSequence.charAt(i)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i++;
                    } else if (!this.f653c) {
                        return 1;
                    }
                } else if (this.f653c) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f653c ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f654a = new b();

        private b() {
        }

        public int checkRtl(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = e.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private interface c {
        int checkRtl(CharSequence charSequence, int i, int i2);
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static abstract class d implements d {

        /* renamed from: a  reason: collision with root package name */
        private final c f655a;

        d(c cVar) {
            this.f655a = cVar;
        }

        private boolean a(CharSequence charSequence, int i, int i2) {
            int checkRtl = this.f655a.checkRtl(charSequence, i, i2);
            if (checkRtl == 0) {
                return true;
            }
            if (checkRtl != 1) {
                return a();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract boolean a();

        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.f655a == null) {
                return a();
            } else {
                return a(charSequence, i, i2);
            }
        }
    }

    /* renamed from: androidx.core.f.e$e  reason: collision with other inner class name */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0011e extends d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f656b;

        C0011e(c cVar, boolean z) {
            super(cVar);
            this.f656b = z;
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return this.f656b;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        static final f f657b = new f();

        f() {
            super((c) null);
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return f.a(Locale.getDefault()) == 1;
        }
    }

    static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
