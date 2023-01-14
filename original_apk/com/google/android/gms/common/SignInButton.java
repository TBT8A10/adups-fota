package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import b.a.a.a.a.c;
import com.google.android.gms.base.R$styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.common.internal.u;

public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private int f1712a;

    /* renamed from: b  reason: collision with root package name */
    private int f1713b;

    /* renamed from: c  reason: collision with root package name */
    private View f1714c;
    private View.OnClickListener d;

    public SignInButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a(int i, int i2) {
        this.f1712a = i;
        this.f1713b = i2;
        Context context = getContext();
        View view = this.f1714c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f1714c = u.a(context, this.f1712a, this.f1713b);
        } catch (c.a unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i3 = this.f1712a;
            int i4 = this.f1713b;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.a(context.getResources(), i3, i4);
            this.f1714c = signInButtonImpl;
        }
        addView(this.f1714c);
        this.f1714c.setEnabled(isEnabled());
        this.f1714c.setOnClickListener(this);
    }

    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.d;
        if (onClickListener != null && view == this.f1714c) {
            onClickListener.onClick(this);
        }
    }

    public final void setColorScheme(int i) {
        a(this.f1712a, i);
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f1714c.setEnabled(z);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.d = onClickListener;
        View view = this.f1714c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        a(this.f1712a, this.f1713b);
    }

    public final void setSize(int i) {
        a(i, this.f1713b);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SignInButton, 0, 0);
        try {
            this.f1712a = obtainStyledAttributes.getInt(R$styleable.SignInButton_buttonSize, 0);
            this.f1713b = obtainStyledAttributes.getInt(R$styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            a(this.f1712a, this.f1713b);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
