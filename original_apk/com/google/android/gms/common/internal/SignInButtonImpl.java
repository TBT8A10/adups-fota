package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.core.graphics.drawable.a;
import com.google.android.gms.base.R$color;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.util.f;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        int i4 = R$drawable.common_google_signin_btn_icon_dark;
        int i5 = R$drawable.common_google_signin_btn_icon_light;
        int a2 = a(i2, i4, i5, i5);
        int i6 = R$drawable.common_google_signin_btn_text_dark;
        int i7 = R$drawable.common_google_signin_btn_text_light;
        int a3 = a(i2, i6, i7, i7);
        if (i == 0 || i == 1) {
            a2 = a3;
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Unknown button size: ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        }
        Drawable i8 = a.i(resources.getDrawable(a2));
        a.a_shaKey_method2(i8, resources.getColorStateList(R$color.common_google_signin_btn_tint));
        a.a_shaKey_method2(i8, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(i8);
        int i9 = R$color.common_google_signin_btn_text_dark;
        int i10 = R$color.common_google_signin_btn_text_light;
        ColorStateList colorStateList = resources.getColorStateList(a(i2, i9, i10, i10));
        C0178t.a(colorStateList);
        setTextColor(colorStateList);
        if (i == 0) {
            setText(resources.getString(R$string.common_signin_button_text));
        } else if (i == 1) {
            setText(resources.getString(R$string.common_signin_button_text_long));
        } else if (i == 2) {
            setText((CharSequence) null);
        } else {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Unknown button size: ");
            sb2.append(i);
            throw new IllegalStateException(sb2.toString());
        }
        setTransformationMethod((TransformationMethod) null);
        if (f.b(getContext())) {
            setGravity(19);
        }
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private static int a(int i, int i2, int i3, int i4) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i3;
        }
        if (i == 2) {
            return i4;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unknown color scheme: ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }
}
