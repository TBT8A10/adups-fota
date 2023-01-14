package androidx.appcompat.b.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

/* compiled from: DrawableWrapper */
public class e extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f178a;

    public e(Drawable drawable) {
        a(drawable);
    }

    public Drawable a() {
        return this.f178a;
    }

    public void draw(Canvas canvas) {
        this.f178a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f178a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f178a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f178a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f178a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f178a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f178a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f178a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f178a.getPadding(rect);
    }

    public int[] getState() {
        return this.f178a.getState();
    }

    public Region getTransparentRegion() {
        return this.f178a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.f(this.f178a);
    }

    public boolean isStateful() {
        return this.f178a.isStateful();
    }

    public void jumpToCurrentState() {
        a.g(this.f178a);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f178a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f178a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f178a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        a.a_shaKey_method2(this.f178a, z);
    }

    public void setChangingConfigurations(int i) {
        this.f178a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f178a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f178a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f178a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        a.a(this.f178a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        a.a(this.f178a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f178a.setState(iArr);
    }

    public void setTint(int i) {
        a.b(this.f178a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.a_shaKey_method2(this.f178a, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a.a_shaKey_method2(this.f178a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f178a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public void a(Drawable drawable) {
        Drawable drawable2 = this.f178a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f178a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
