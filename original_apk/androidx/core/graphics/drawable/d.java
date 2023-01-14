package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* compiled from: WrappedDrawableApi14 */
class d extends Drawable implements Drawable.Callback, c, b {
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    private int f672a;

    /* renamed from: b  reason: collision with root package name */
    private PorterDuff.Mode f673b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f674c;
    a d;
    private boolean e;
    Drawable f;

    /* compiled from: WrappedDrawableApi14 */
    protected static abstract class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f675a;

        /* renamed from: b  reason: collision with root package name */
        Drawable.ConstantState f676b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f677c = null;
        PorterDuff.Mode d = d.DEFAULT_TINT_MODE;

        a(a aVar, Resources resources) {
            if (aVar != null) {
                this.f675a = aVar.f675a;
                this.f676b = aVar.f676b;
                this.f677c = aVar.f677c;
                this.d = aVar.d;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f676b != null;
        }

        public int getChangingConfigurations() {
            int i = this.f675a;
            Drawable.ConstantState constantState = this.f676b;
            return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }

        public Drawable newDrawable() {
            return newDrawable((Resources) null);
        }

        public abstract Drawable newDrawable(Resources resources);
    }

    /* compiled from: WrappedDrawableApi14 */
    private static class b extends a {
        b(a aVar, Resources resources) {
            super(aVar, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    d(a aVar, Resources resources) {
        this.d = aVar;
        a(resources);
    }

    private void a(Resources resources) {
        Drawable.ConstantState constantState;
        a aVar = this.d;
        if (aVar != null && (constantState = aVar.f676b) != null) {
            a(constantState.newDrawable(resources));
        }
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public a c() {
        return new b(this.d, (Resources) null);
    }

    public void draw(Canvas canvas) {
        this.f.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        a aVar = this.d;
        return changingConfigurations | (aVar != null ? aVar.getChangingConfigurations() : 0) | this.f.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        a aVar = this.d;
        if (aVar == null || !aVar.a()) {
            return null;
        }
        this.d.f675a = getChangingConfigurations();
        return this.d;
    }

    public Drawable getCurrent() {
        return this.f.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f.getPadding(rect);
    }

    public int[] getState() {
        return this.f.getState();
    }

    public Region getTransparentRegion() {
        return this.f.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.f.isAutoMirrored();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.b()
            if (r0 == 0) goto L_0x000d
            androidx.core.graphics.drawable.d$a r0 = r1.d
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.f677c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r0 = r1.f
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.d.isStateful():boolean");
    }

    public void jumpToCurrentState() {
        this.f.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.e && super.mutate() == this) {
            this.d = c();
            Drawable drawable = this.f;
            if (drawable != null) {
                drawable.mutate();
            }
            a aVar = this.d;
            if (aVar != null) {
                Drawable drawable2 = this.f;
                aVar.f676b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.e = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        this.f.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i) {
        this.f.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return a(iArr) || this.f.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.d.f677c = colorStateList;
        a(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.d.d = mode;
        a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    private boolean a(int[] iArr) {
        if (!b()) {
            return false;
        }
        a aVar = this.d;
        ColorStateList colorStateList = aVar.f677c;
        PorterDuff.Mode mode = aVar.d;
        if (colorStateList == null || mode == null) {
            this.f674c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f674c && colorForState == this.f672a && mode == this.f673b)) {
                setColorFilter(colorForState, mode);
                this.f672a = colorForState;
                this.f673b = mode;
                this.f674c = true;
                return true;
            }
        }
        return false;
    }

    d(Drawable drawable) {
        this.d = c();
        a(drawable);
    }

    public final Drawable a() {
        return this.f;
    }

    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            a aVar = this.d;
            if (aVar != null) {
                aVar.f676b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
