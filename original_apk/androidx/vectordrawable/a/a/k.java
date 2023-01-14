package androidx.vectordrawable.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.a.b;
import androidx.core.content.a.i;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat */
public class k extends i {
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private g f1341b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuffColorFilter f1342c;
    private ColorFilter d;
    private boolean e;
    private boolean f;
    private Drawable.ConstantState g;
    private final float[] h;
    private final Matrix i;
    private final Rect j;

    /* compiled from: VectorDrawableCompat */
    private static class a extends e {
        public a() {
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (i.a_shaKey_method2(xmlPullParser, "pathData")) {
                TypedArray a2 = i.a(resources, theme, attributeSet, a.d);
                a(a2);
                a2.recycle();
            }
        }

        public boolean b() {
            return true;
        }

        public a(a aVar) {
            super(aVar);
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f1347b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f1346a = androidx.core.a.b.a(string2);
            }
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static abstract class d {
        private d() {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int[] iArr) {
            return false;
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class g extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f1352a;

        /* renamed from: b  reason: collision with root package name */
        f f1353b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f1354c;
        PorterDuff.Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public g(g gVar) {
            this.f1354c = null;
            this.d = k.DEFAULT_TINT_MODE;
            if (gVar != null) {
                this.f1352a = gVar.f1352a;
                this.f1353b = new f(gVar.f1353b);
                Paint paint = gVar.f1353b.f;
                if (paint != null) {
                    this.f1353b.f = new Paint(paint);
                }
                Paint paint2 = gVar.f1353b.e;
                if (paint2 != null) {
                    this.f1353b.e = new Paint(paint2);
                }
                this.f1354c = gVar.f1354c;
                this.d = gVar.d;
                this.e = gVar.e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, a(colorFilter));
        }

        public boolean b() {
            return this.f1353b.getRootAlpha() < 255;
        }

        public void c(int i2, int i3) {
            this.f.eraseColor(0);
            this.f1353b.a(new Canvas(this.f), i2, i3, (ColorFilter) null);
        }

        public void d() {
            this.g = this.f1354c;
            this.h = this.d;
            this.i = this.f1353b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public int getChangingConfigurations() {
            return this.f1352a;
        }

        public Drawable newDrawable() {
            return new k(this);
        }

        public void b(int i2, int i3) {
            if (this.f == null || !a(i2, i3)) {
                this.f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public Drawable newDrawable(Resources resources) {
            return new k(this);
        }

        public Paint a(ColorFilter colorFilter) {
            if (!b() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f1353b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public boolean c() {
            return this.f1353b.a();
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f.getWidth() && i3 == this.f.getHeight();
        }

        public boolean a() {
            return !this.k && this.g == this.f1354c && this.h == this.d && this.j == this.e && this.i == this.f1353b.getRootAlpha();
        }

        public g() {
            this.f1354c = null;
            this.d = k.DEFAULT_TINT_MODE;
            this.f1353b = new f();
        }

        public boolean a(int[] iArr) {
            boolean a2 = this.f1353b.a(iArr);
            this.k |= a2;
            return a2;
        }
    }

    k() {
        this.f = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f1341b = new g();
    }

    public static k createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        k kVar = new k();
        kVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return kVar;
    }

    /* access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f1341b.f1353b.q.get(str);
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f1340a;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.a(drawable);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.j);
        if (this.j.width() > 0 && this.j.height() > 0) {
            ColorFilter colorFilter = this.d;
            if (colorFilter == null) {
                colorFilter = this.f1342c;
            }
            canvas.getMatrix(this.i);
            this.i.getValues(this.h);
            float abs = Math.abs(this.h[0]);
            float abs2 = Math.abs(this.h[4]);
            float abs3 = Math.abs(this.h[1]);
            float abs4 = Math.abs(this.h[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.j.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.j.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.j;
                canvas.translate((float) rect.left, (float) rect.top);
                if (a()) {
                    canvas.translate((float) this.j.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.j.offsetTo(0, 0);
                this.f1341b.b(min, min2);
                if (!this.f) {
                    this.f1341b.c(min, min2);
                } else if (!this.f1341b.a()) {
                    this.f1341b.c(min, min2);
                    this.f1341b.d();
                }
                this.f1341b.a(canvas, colorFilter, this.j);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.c(drawable);
        }
        return this.f1341b.f1353b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f1341b.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f1340a;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new h(drawable.getConstantState());
        }
        this.f1341b.f1352a = getChangingConfigurations();
        return this.f1341b;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f1341b.f1353b.k;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f1341b.f1353b.j;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.f(drawable);
        }
        return this.f1341b.e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r0 = r1.f1341b.f1354c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r1.f1341b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.f1340a
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.a.a.k$g r0 = r1.f1341b
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.a.a.k$g r0 = r1.f1341b
            android.content.res.ColorStateList r0 = r0.f1354c
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.a.a.k.isStateful():boolean");
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.e && super.mutate() == this) {
            this.f1341b = new g(this.f1341b);
            this.e = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        g gVar = this.f1341b;
        ColorStateList colorStateList = gVar.f1354c;
        if (!(colorStateList == null || (mode = gVar.d) == null)) {
            this.f1342c = updateTintFilter(this.f1342c, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!gVar.c() || !gVar.a(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f1341b.f1353b.getRootAlpha() != i2) {
            this.f1341b.f1353b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, z);
        } else {
            this.f1341b.e = z;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i2) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, colorStateList);
            return;
        }
        g gVar = this.f1341b;
        if (gVar.f1354c != colorStateList) {
            gVar.f1354c = colorStateList;
            this.f1342c = updateTintFilter(this.f1342c, colorStateList, gVar.d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, mode);
            return;
        }
        g gVar = this.f1341b;
        if (gVar.d != mode) {
            gVar.d = mode;
            this.f1342c = updateTintFilter(this.f1342c, gVar.f1354c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* compiled from: VectorDrawableCompat */
    private static abstract class e extends d {

        /* renamed from: a  reason: collision with root package name */
        protected b.C0006b[] f1346a = null;

        /* renamed from: b  reason: collision with root package name */
        String f1347b;

        /* renamed from: c  reason: collision with root package name */
        int f1348c;

        public e() {
            super();
        }

        public void a(Path path) {
            path.reset();
            b.C0006b[] bVarArr = this.f1346a;
            if (bVarArr != null) {
                b.C0006b.a_shaKey_method2(bVarArr, path);
            }
        }

        public boolean b() {
            return false;
        }

        public b.C0006b[] getPathData() {
            return this.f1346a;
        }

        public String getPathName() {
            return this.f1347b;
        }

        public void setPathData(b.C0006b[] bVarArr) {
            if (!androidx.core.a.b.a_shaKey_method2(this.f1346a, bVarArr)) {
                this.f1346a = androidx.core.a.b.a(bVarArr);
            } else {
                androidx.core.a.b.b(this.f1346a, bVarArr);
            }
        }

        public e(e eVar) {
            super();
            this.f1347b = eVar.f1347b;
            this.f1348c = eVar.f1348c;
            this.f1346a = androidx.core.a.b.a(eVar.f1346a);
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f1355a;

        public h(Drawable.ConstantState constantState) {
            this.f1355a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f1355a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f1355a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            k kVar = new k();
            kVar.f1340a = (VectorDrawable) this.f1355a.newDrawable();
            return kVar;
        }

        public Drawable newDrawable(Resources resources) {
            k kVar = new k();
            kVar.f1340a = (VectorDrawable) this.f1355a.newDrawable(resources);
            return kVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            k kVar = new k();
            kVar.f1340a = (VectorDrawable) this.f1355a.newDrawable(resources, theme);
            return kVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.a.a.k a(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            androidx.vectordrawable.a.a.k r0 = new androidx.vectordrawable.a.a.k
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.a.h.a(r6, r7, r8)
            r0.f1340a = r6
            androidx.vectordrawable.a.a.k$h r6 = new androidx.vectordrawable.a.a.k$h
            android.graphics.drawable.Drawable r7 = r0.f1340a
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.g = r6
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x002b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r5 = 1
            if (r3 == r5) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r3 != r4) goto L_0x003d
            androidx.vectordrawable.a.a.k r6 = createFromXmlInner(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            return r6
        L_0x003d:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            throw r6     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x0045:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x004e
        L_0x004a:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x004e:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.a.a.k.a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.a.a.k");
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.d = colorFilter;
        invalidateSelf();
    }

    /* compiled from: VectorDrawableCompat */
    private static class b extends e {
        private int[] d;
        androidx.core.content.a.b e;
        float f = 0.0f;
        androidx.core.content.a.b g;
        float h = 1.0f;
        int i = 0;
        float j = 1.0f;
        float k = 0.0f;
        float l = 1.0f;
        float m = 0.0f;
        Paint.Cap n = Paint.Cap.BUTT;
        Paint.Join o = Paint.Join.MITER;
        float p = 4.0f;

        public b() {
        }

        private Paint.Cap a(int i2, Paint.Cap cap) {
            if (i2 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i2 != 1) {
                return i2 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.j;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.g.a();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.h;
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.e.a();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.l;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.m;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.k;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f2) {
            this.j = f2;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i2) {
            this.g.b(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f2) {
            this.h = f2;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i2) {
            this.e.b(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f2) {
            this.f = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f2) {
            this.k = f2;
        }

        private Paint.Join a(int i2, Paint.Join join) {
            if (i2 == 0) {
                return Paint.Join.MITER;
            }
            if (i2 != 1) {
                return i2 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = i.a(resources, theme, attributeSet, a.f1328c);
            a(a2, xmlPullParser, theme);
            a2.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.d = null;
            if (i.a_shaKey_method2(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f1347b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f1346a = androidx.core.a.b.a(string2);
                }
                Resources.Theme theme2 = theme;
                this.g = i.a(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.j = i.a(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = a_shaKey_method2(i.b(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = a_shaKey_method2(i.b(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = i.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.e = i.a(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.h = i.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.h);
                this.f = i.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f);
                this.l = i.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = i.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = i.a(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.i = i.b(typedArray, xmlPullParser, "fillType", 13, this.i);
            }
        }

        public b(b bVar) {
            super(bVar);
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.f;
            this.h = bVar.h;
            this.g = bVar.g;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
        }

        public boolean a() {
            return this.g.d() || this.e.d();
        }

        public boolean a(int[] iArr) {
            return this.e.a(iArr) | this.g.a(iArr);
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class c extends d {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f1343a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<d> f1344b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        float f1345c = 0.0f;
        private float d = 0.0f;
        private float e = 0.0f;
        private float f = 1.0f;
        private float g = 1.0f;
        private float h = 0.0f;
        private float i = 0.0f;
        final Matrix j = new Matrix();
        int k;
        private int[] l;
        private String m = null;

        public c(c cVar, a.b.b<String, Object> bVar) {
            super();
            e eVar;
            this.f1345c = cVar.f1345c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.l = cVar.l;
            this.m = cVar.m;
            this.k = cVar.k;
            String str = this.m;
            if (str != null) {
                bVar.put(str, this);
            }
            this.j.set(cVar.j);
            ArrayList<d> arrayList = cVar.f1344b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = arrayList.get(i2);
                if (dVar instanceof c) {
                    this.f1344b.add(new c((c) dVar, bVar));
                } else {
                    if (dVar instanceof b) {
                        eVar = new b((b) dVar);
                    } else if (dVar instanceof a) {
                        eVar = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f1344b.add(eVar);
                    String str2 = eVar.f1347b;
                    if (str2 != null) {
                        bVar.put(str2, eVar);
                    }
                }
            }
        }

        private void b() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.f1345c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = i.a(resources, theme, attributeSet, a.f1327b);
            a_shaKey_method2(a2, xmlPullParser);
            a2.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.f1345c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.d) {
                this.d = f2;
                b();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.e) {
                this.e = f2;
                b();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f1345c) {
                this.f1345c = f2;
                b();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f) {
                this.f = f2;
                b();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.g) {
                this.g = f2;
                b();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.h) {
                this.h = f2;
                b();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
                b();
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f1345c = i.a(typedArray, xmlPullParser, "rotation", 5, this.f1345c);
            this.d = typedArray.getFloat(1, this.d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = i.a(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = i.a(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = i.a(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = i.a(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            b();
        }

        public boolean a() {
            for (int i2 = 0; i2 < this.f1344b.size(); i2++) {
                if (this.f1344b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean a(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f1344b.size(); i2++) {
                z |= this.f1344b.get(i2).a(iArr);
            }
            return z;
        }

        public c() {
            super();
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f1341b;
        gVar.f1353b = new f();
        TypedArray a2 = i.a(resources, theme, attributeSet, a.f1326a);
        a_shaKey_method2(a2, xmlPullParser);
        a2.recycle();
        gVar.f1352a = getChangingConfigurations();
        gVar.k = true;
        a(resources, xmlPullParser, attributeSet, theme);
        this.f1342c = updateTintFilter(this.f1342c, gVar.f1354c, gVar.d);
    }

    k(g gVar) {
        this.f = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f1341b = gVar;
        this.f1342c = updateTintFilter(this.f1342c, gVar.f1354c, gVar.d);
    }

    /* compiled from: VectorDrawableCompat */
    private static class f {

        /* renamed from: a  reason: collision with root package name */
        private static final Matrix f1349a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final Path f1350b;

        /* renamed from: c  reason: collision with root package name */
        private final Path f1351c;
        private final Matrix d;
        Paint e;
        Paint f;
        private PathMeasure g;
        private int h;
        final c i;
        float j;
        float k;
        float l;
        float m;
        int n;
        String o;
        Boolean p;
        final a.b.b<String, Object> q;

        public f() {
            this.d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new a.b.b<>();
            this.i = new c();
            this.f1350b = new Path();
            this.f1351c = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            cVar.f1343a.set(matrix);
            cVar.f1343a.preConcat(cVar.j);
            canvas.save();
            for (int i4 = 0; i4 < cVar.f1344b.size(); i4++) {
                d dVar = cVar.f1344b.get(i4);
                if (dVar instanceof c) {
                    a((c) dVar, cVar.f1343a, canvas, i2, i3, colorFilter);
                } else if (dVar instanceof e) {
                    a(cVar, (e) dVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.n = i2;
        }

        public void a(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            a(this.i, f1349a, canvas, i2, i3, colorFilter);
        }

        public f(f fVar) {
            this.d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new a.b.b<>();
            this.i = new c(fVar.i, this.q);
            this.f1350b = new Path(fVar.f1350b);
            this.f1351c = new Path(fVar.f1351c);
            this.j = fVar.j;
            this.k = fVar.k;
            this.l = fVar.l;
            this.m = fVar.m;
            this.h = fVar.h;
            this.n = fVar.n;
            this.o = fVar.o;
            String str = fVar.o;
            if (str != null) {
                this.q.put(str, this);
            }
            this.p = fVar.p;
        }

        private void a(c cVar, e eVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = ((float) i2) / this.l;
            float f3 = ((float) i3) / this.m;
            float min = Math.min(f2, f3);
            Matrix matrix = cVar.f1343a;
            this.d.set(matrix);
            this.d.postScale(f2, f3);
            float a2 = a(matrix);
            if (a2 != 0.0f) {
                eVar.a(this.f1350b);
                Path path = this.f1350b;
                this.f1351c.reset();
                if (eVar.b()) {
                    this.f1351c.addPath(path, this.d);
                    canvas.clipPath(this.f1351c);
                    return;
                }
                b bVar = (b) eVar;
                if (!(bVar.k == 0.0f && bVar.l == 1.0f)) {
                    float f4 = bVar.k;
                    float f5 = bVar.m;
                    float f6 = (f4 + f5) % 1.0f;
                    float f7 = (bVar.l + f5) % 1.0f;
                    if (this.g == null) {
                        this.g = new PathMeasure();
                    }
                    this.g.setPath(this.f1350b, false);
                    float length = this.g.getLength();
                    float f8 = f6 * length;
                    float f9 = f7 * length;
                    path.reset();
                    if (f8 > f9) {
                        this.g.getSegment(f8, length, path, true);
                        this.g.getSegment(0.0f, f9, path, true);
                    } else {
                        this.g.getSegment(f8, f9, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f1351c.addPath(path, this.d);
                if (bVar.g.e()) {
                    androidx.core.content.a.b bVar2 = bVar.g;
                    if (this.f == null) {
                        this.f = new Paint(1);
                        this.f.setStyle(Paint.Style.FILL);
                    }
                    Paint paint = this.f;
                    if (bVar2.c()) {
                        Shader b2 = bVar2.b();
                        b2.setLocalMatrix(this.d);
                        paint.setShader(b2);
                        paint.setAlpha(Math.round(bVar.j * 255.0f));
                    } else {
                        paint.setColor(k.a_shaKey_method2(bVar2.a(), bVar.j));
                    }
                    paint.setColorFilter(colorFilter);
                    this.f1351c.setFillType(bVar.i == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f1351c, paint);
                }
                if (bVar.e.e()) {
                    androidx.core.content.a.b bVar3 = bVar.e;
                    if (this.e == null) {
                        this.e = new Paint(1);
                        this.e.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint2 = this.e;
                    Paint.Join join = bVar.o;
                    if (join != null) {
                        paint2.setStrokeJoin(join);
                    }
                    Paint.Cap cap = bVar.n;
                    if (cap != null) {
                        paint2.setStrokeCap(cap);
                    }
                    paint2.setStrokeMiter(bVar.p);
                    if (bVar3.c()) {
                        Shader b3 = bVar3.b();
                        b3.setLocalMatrix(this.d);
                        paint2.setShader(b3);
                        paint2.setAlpha(Math.round(bVar.h * 255.0f));
                    } else {
                        paint2.setColor(k.a_shaKey_method2(bVar3.a(), bVar.h));
                    }
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth(bVar.f * min * a2);
                    canvas.drawPath(this.f1351c, paint2);
                }
            }
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public boolean a() {
            if (this.p == null) {
                this.p = Boolean.valueOf(this.i.a());
            }
            return this.p.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.i.a(iArr);
        }
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    private static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        g gVar = this.f1341b;
        f fVar = gVar.f1353b;
        gVar.d = a_shaKey_method2(i.b(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            gVar.f1354c = colorStateList;
        }
        gVar.e = i.a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.e);
        fVar.l = i.a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.l);
        fVar.m = i.a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.m);
        if (fVar.l <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (fVar.m > 0.0f) {
            fVar.j = typedArray.getDimension(3, fVar.j);
            fVar.k = typedArray.getDimension(2, fVar.k);
            if (fVar.j <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (fVar.k > 0.0f) {
                fVar.setAlpha(i.a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    fVar.o = string;
                    fVar.q.put(string, fVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    private void a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        g gVar = this.f1341b;
        f fVar = gVar.f1353b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.i);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1344b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.q.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    gVar.f1352a = bVar.f1348c | gVar.f1352a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1344b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.q.put(aVar.getPathName(), aVar);
                    }
                    gVar.f1352a = aVar.f1348c | gVar.f1352a;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    cVar2.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1344b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.q.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.f1352a = cVar2.k | gVar.f1352a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f = z;
    }

    private boolean a() {
        if (Build.VERSION.SDK_INT < 17 || !isAutoMirrored() || androidx.core.graphics.drawable.a.e(this) != 1) {
            return false;
        }
        return true;
    }
}
