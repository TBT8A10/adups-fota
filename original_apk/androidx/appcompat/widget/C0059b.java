package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.appcompat.widget.b  reason: case insensitive filesystem */
/* compiled from: ActionBarBackgroundDrawable */
class C0059b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f408a;

    public C0059b(ActionBarContainer actionBarContainer) {
        this.f408a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f408a;
        if (actionBarContainer.g) {
            Drawable drawable = actionBarContainer.f;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.mBackground;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f408a;
        Drawable drawable3 = actionBarContainer2.e;
        if (drawable3 != null && actionBarContainer2.h) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f408a;
        if (actionBarContainer.g) {
            Drawable drawable = actionBarContainer.f;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.mBackground;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
