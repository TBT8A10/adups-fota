package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.drawable.d;
import java.lang.reflect.Method;

/* compiled from: WrappedDrawableApi21 */
class e extends d {
    private static Method g;

    /* compiled from: WrappedDrawableApi21 */
    private static class a extends d.a {
        a(d.a aVar, Resources resources) {
            super(aVar, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    e(Drawable drawable) {
        super(drawable);
        d();
    }

    private void d() {
        if (g == null) {
            try {
                g = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public d.a c() {
        return new a(this.d, (Resources) null);
    }

    public Rect getDirtyBounds() {
        return this.f.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.f.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f;
        if (!(drawable == null || (method = g) == null)) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    public void setHotspot(float f, float f2) {
        this.f.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f.setHotspotBounds(i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i) {
        if (b()) {
            super.setTint(i);
        } else {
            this.f.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (b()) {
            super.setTintList(colorStateList);
        } else {
            this.f.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (b()) {
            super.setTintMode(mode);
        } else {
            this.f.setTintMode(mode);
        }
    }

    e(d.a aVar, Resources resources) {
        super(aVar, resources);
        d();
    }
}
