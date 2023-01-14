package androidx.core.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* compiled from: TintableBackgroundView */
public interface r {
    ColorStateList getSupportBackgroundTintList();

    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(PorterDuff.Mode mode);
}
