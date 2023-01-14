package androidx.appcompat.widget;

import a.b.f;
import a.b.g;
import a.b.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$drawable;
import androidx.vectordrawable.a.a.k;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.appcompat.widget.q  reason: case insensitive filesystem */
/* compiled from: AppCompatDrawableManager */
public final class C0074q {

    /* renamed from: a  reason: collision with root package name */
    private static final PorterDuff.Mode f460a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private static C0074q f461b;

    /* renamed from: c  reason: collision with root package name */
    private static final c f462c = new c(6);
    private static final int[] d = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl_dark, R$drawable.abc_text_select_handle_middle_mtrl_dark, R$drawable.abc_text_select_handle_right_mtrl_dark, R$drawable.abc_text_select_handle_left_mtrl_light, R$drawable.abc_text_select_handle_middle_mtrl_light, R$drawable.abc_text_select_handle_right_mtrl_light};
    private static final int[] g = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};
    private static final int[] i = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material};
    private WeakHashMap<Context, j<ColorStateList>> j;
    private a.b.b<String, d> k;
    private j<String> l;
    private final WeakHashMap<Context, f<WeakReference<Drawable.ConstantState>>> m = new WeakHashMap<>(0);
    private TypedValue n;
    private boolean o;

    /* renamed from: androidx.appcompat.widget.q$a */
    /* compiled from: AppCompatDrawableManager */
    static class a implements d {
        a() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.appcompat.b.a.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.q$b */
    /* compiled from: AppCompatDrawableManager */
    private static class b implements d {
        b() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.a.a.d.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.q$c */
    /* compiled from: AppCompatDrawableManager */
    private static class c extends g<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) b(Integer.valueOf(b(i, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) a_shaKey_method2(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }
    }

    /* renamed from: androidx.appcompat.widget.q$d */
    /* compiled from: AppCompatDrawableManager */
    private interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* renamed from: androidx.appcompat.widget.q$e */
    /* compiled from: AppCompatDrawableManager */
    private static class e implements d {
        e() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return k.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static synchronized C0074q a() {
        C0074q qVar;
        synchronized (C0074q.class) {
            if (f461b == null) {
                f461b = new C0074q();
                a(f461b);
            }
            qVar = f461b;
        }
        return qVar;
    }

    private ColorStateList c(Context context) {
        return c(context, 0);
    }

    private Drawable d(Context context, int i2) {
        if (this.n == null) {
            this.n = new TypedValue();
        }
        TypedValue typedValue = this.n;
        context.getResources().getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a_shaKey_method2(context, a2);
        if (a3 != null) {
            return a3;
        }
        if (i2 == R$drawable.abc_cab_background_top_material) {
            a3 = new LayerDrawable(new Drawable[]{a_shaKey_method2(context, R$drawable.abc_cab_background_internal_bg), a_shaKey_method2(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, a3);
        }
        return a3;
    }

    private ColorStateList e(Context context, int i2) {
        j jVar;
        WeakHashMap<Context, j<ColorStateList>> weakHashMap = this.j;
        if (weakHashMap == null || (jVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) jVar.b(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable f(android.content.Context r11, int r12) {
        /*
            r10 = this;
            a.b.b<java.lang.String, androidx.appcompat.widget.q$d> r0 = r10.k
            r1 = 0
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b2
            a.b.j<java.lang.String> r0 = r10.l
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.b(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            a.b.b<java.lang.String, androidx.appcompat.widget.q$d> r3 = r10.k
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            a.b.j r0 = new a.b.j
            r0.<init>()
            r10.l = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.n
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.n = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.n
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = a((android.util.TypedValue) r0)
            android.graphics.drawable.Drawable r6 = r10.a((android.content.Context) r11, (long) r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00aa
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00aa
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a2 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a2 }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a2 }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009a
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a2 }
            a.b.j<java.lang.String> r8 = r10.l     // Catch:{ Exception -> 0x00a2 }
            r8.a(r12, r3)     // Catch:{ Exception -> 0x00a2 }
            a.b.b<java.lang.String, androidx.appcompat.widget.q$d> r8 = r10.k     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.appcompat.widget.q$d r3 = (androidx.appcompat.widget.C0074q.d) r3     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x008f
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a2 }
            android.graphics.drawable.Drawable r1 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a2 }
            r6 = r1
        L_0x008f:
            if (r6 == 0) goto L_0x00aa
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a2 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a2 }
            r10.a((android.content.Context) r11, (long) r4, (android.graphics.drawable.Drawable) r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x009a:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a2 }
            throw r11     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r11 = move-exception
            java.lang.String r0 = "AppCompatDrawableManag"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00aa:
            if (r6 != 0) goto L_0x00b1
            a.b.j<java.lang.String> r11 = r10.l
            r11.a(r12, r2)
        L_0x00b1:
            return r6
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0074q.f(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList b(Context context, int i2) {
        ColorStateList e2;
        e2 = e(context, i2);
        if (e2 == null) {
            if (i2 == R$drawable.abc_edit_text_material) {
                e2 = androidx.appcompat.a.a.a.a_shaKey_method2(context, R$color.abc_tint_edittext);
            } else if (i2 == R$drawable.abc_switch_track_mtrl_alpha) {
                e2 = androidx.appcompat.a.a.a.a_shaKey_method2(context, R$color.abc_tint_switch_track);
            } else if (i2 == R$drawable.abc_switch_thumb_material) {
                e2 = f(context);
            } else if (i2 == R$drawable.abc_btn_default_mtrl_shape) {
                e2 = e(context);
            } else if (i2 == R$drawable.abc_btn_borderless_material) {
                e2 = c(context);
            } else if (i2 == R$drawable.abc_btn_colored_material) {
                e2 = d(context);
            } else {
                if (i2 != R$drawable.abc_spinner_mtrl_am_alpha) {
                    if (i2 != R$drawable.abc_spinner_textfield_background_material) {
                        if (a(e, i2)) {
                            e2 = da.c(context, R$attr.colorControlNormal);
                        } else if (a(h, i2)) {
                            e2 = androidx.appcompat.a.a.a.a_shaKey_method2(context, R$color.abc_tint_default);
                        } else if (a(i, i2)) {
                            e2 = androidx.appcompat.a.a.a.a_shaKey_method2(context, R$color.abc_tint_btn_checkable);
                        } else if (i2 == R$drawable.abc_seekbar_thumb_material) {
                            e2 = androidx.appcompat.a.a.a.a_shaKey_method2(context, R$color.abc_tint_seek_thumb);
                        }
                    }
                }
                e2 = androidx.appcompat.a.a.a.a_shaKey_method2(context, R$color.abc_tint_spinner);
            }
            if (e2 != null) {
                a(context, i2, e2);
            }
        }
        return e2;
    }

    private ColorStateList c(Context context, int i2) {
        int b2 = da.b(context, R$attr.colorControlHighlight);
        int a2 = da.a_shaKey_method2(context, R$attr.colorButtonNormal);
        return new ColorStateList(new int[][]{da.f416b, da.e, da.f417c, da.i}, new int[]{a2, androidx.core.a.a.a(b2, i2), androidx.core.a.a.a(b2, i2), i2});
    }

    private ColorStateList e(Context context) {
        return c(context, da.b(context, R$attr.colorButtonNormal));
    }

    private static void a(C0074q qVar) {
        if (Build.VERSION.SDK_INT < 24) {
            qVar.a("vector", (d) new e());
            qVar.a("animated-vector", (d) new b());
            qVar.a("animated-selector", (d) new a());
        }
    }

    public synchronized Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, int i2, boolean z) {
        Drawable f2;
        b(context);
        f2 = f(context, i2);
        if (f2 == null) {
            f2 = d(context, i2);
        }
        if (f2 == null) {
            f2 = androidx.core.content.a.c(context, i2);
        }
        if (f2 != null) {
            f2 = a(context, i2, z, f2);
        }
        if (f2 != null) {
            E.b(f2);
        }
        return f2;
    }

    private ColorStateList d(Context context) {
        return c(context, da.b(context, R$attr.colorAccent));
    }

    public synchronized void a(Context context) {
        f fVar = this.m.get(context);
        if (fVar != null) {
            fVar.a();
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            if (E.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable i3 = androidx.core.graphics.drawable.a.i(drawable);
            androidx.core.graphics.drawable.a.a_shaKey_method2(i3, b2);
            PorterDuff.Mode a2 = a(i2);
            if (a2 == null) {
                return i3;
            }
            androidx.core.graphics.drawable.a.a_shaKey_method2(i3, a2);
            return i3;
        } else if (i2 == R$drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), da.b(context, R$attr.colorControlNormal), f460a);
            a(layerDrawable.findDrawableByLayerId(16908303), da.b(context, R$attr.colorControlNormal), f460a);
            a(layerDrawable.findDrawableByLayerId(16908301), da.b(context, R$attr.colorControlActivated), f460a);
            return drawable;
        } else if (i2 == R$drawable.abc_ratingbar_material || i2 == R$drawable.abc_ratingbar_indicator_material || i2 == R$drawable.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(16908288), da.a_shaKey_method2(context, R$attr.colorControlNormal), f460a);
            a(layerDrawable2.findDrawableByLayerId(16908303), da.b(context, R$attr.colorControlActivated), f460a);
            a(layerDrawable2.findDrawableByLayerId(16908301), da.b(context, R$attr.colorControlActivated), f460a);
            return drawable;
        } else if (a(context, i2, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    private void b(Context context) {
        if (!this.o) {
            this.o = true;
            Drawable a2 = a_shaKey_method2(context, R$drawable.abc_vector_test);
            if (a2 == null || !a(a2)) {
                this.o = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private ColorStateList f(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList c2 = da.c(context, R$attr.colorSwitchThumbNormal);
        if (c2 == null || !c2.isStateful()) {
            iArr[0] = da.f416b;
            iArr2[0] = da.a_shaKey_method2(context, R$attr.colorSwitchThumbNormal);
            iArr[1] = da.f;
            iArr2[1] = da.b(context, R$attr.colorControlActivated);
            iArr[2] = da.i;
            iArr2[2] = da.b(context, R$attr.colorSwitchThumbNormal);
        } else {
            iArr[0] = da.f416b;
            iArr2[0] = c2.getColorForState(iArr[0], 0);
            iArr[1] = da.f;
            iArr2[1] = da.b(context, R$attr.colorControlActivated);
            iArr[2] = da.i;
            iArr2[2] = c2.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable a(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, a.b.f<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.m     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            a.b.f r0 = (a.b.f) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.b((long) r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.a((long) r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0074q.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private synchronized boolean a(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        f fVar = this.m.get(context);
        if (fVar == null) {
            fVar = new f();
            this.m.put(context, fVar);
        }
        fVar.c(j2, new WeakReference(constantState));
        return true;
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, va vaVar, int i2) {
        Drawable f2 = f(context, i2);
        if (f2 == null) {
            f2 = vaVar.a(i2);
        }
        if (f2 == null) {
            return null;
        }
        return a(context, i2, false, f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = f460a
            int[] r1 = d
            boolean r1 = a((int[]) r1, (int) r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0015
            int r2 = androidx.appcompat.R$attr.colorControlNormal
        L_0x0012:
            r7 = 1
            r1 = -1
            goto L_0x0044
        L_0x0015:
            int[] r1 = f
            boolean r1 = a((int[]) r1, (int) r7)
            if (r1 == 0) goto L_0x0020
            int r2 = androidx.appcompat.R$attr.colorControlActivated
            goto L_0x0012
        L_0x0020:
            int[] r1 = g
            boolean r1 = a((int[]) r1, (int) r7)
            if (r1 == 0) goto L_0x002b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L_0x0012
        L_0x002b:
            int r1 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L_0x003c
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            r1 = r7
            r7 = 1
            goto L_0x0044
        L_0x003c:
            int r1 = androidx.appcompat.R$drawable.abc_dialog_material_background
            if (r7 != r1) goto L_0x0041
            goto L_0x0012
        L_0x0041:
            r7 = 0
            r1 = -1
            r2 = 0
        L_0x0044:
            if (r7 == 0) goto L_0x0061
            boolean r7 = androidx.appcompat.widget.E.a(r8)
            if (r7 == 0) goto L_0x0050
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L_0x0050:
            int r6 = androidx.appcompat.widget.da.b(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = a((int) r6, (android.graphics.PorterDuff.Mode) r0)
            r8.setColorFilter(r6)
            if (r1 == r3) goto L_0x0060
            r8.setAlpha(r1)
        L_0x0060:
            return r5
        L_0x0061:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0074q.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    private void a(String str, d dVar) {
        if (this.k == null) {
            this.k = new a.b.b<>();
        }
        this.k.put(str, dVar);
    }

    private static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    static PorterDuff.Mode a(int i2) {
        if (i2 == R$drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.j == null) {
            this.j = new WeakHashMap<>();
        }
        j jVar = this.j.get(context);
        if (jVar == null) {
            jVar = new j();
            this.j.put(context, jVar);
        }
        jVar.a_shaKey_method2(i2, colorStateList);
    }

    static void a(Drawable drawable, ga gaVar, int[] iArr) {
        if (!E.a(drawable) || drawable.mutate() == drawable) {
            if (gaVar.d || gaVar.f425c) {
                drawable.setColorFilter(a(gaVar.d ? gaVar.f423a : null, gaVar.f425c ? gaVar.f424b : f460a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a_shaKey_method2(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (C0074q.class) {
            a2 = f462c.a_shaKey_method2(i2, mode);
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                f462c.a(i2, mode, a2);
            }
        }
        return a2;
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (E.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f460a;
        }
        drawable.setColorFilter(a_shaKey_method2(i2, mode));
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof k) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}
