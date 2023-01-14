package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;
import androidx.appcompat.d.b;

public abstract class ActionBar {

    public interface a {
        void onMenuVisibilityChanged(boolean z);
    }

    @Deprecated
    public static abstract class b {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public androidx.appcompat.d.b a(b.a aVar) {
        return null;
    }

    public void a(Configuration configuration) {
    }

    public void a(CharSequence charSequence) {
    }

    public void a(boolean z) {
    }

    public boolean a() {
        return false;
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public abstract void addOnMenuVisibilityListener(a aVar);

    public void b(boolean z) {
    }

    public boolean b() {
        return false;
    }

    public abstract int c();

    public void c(boolean z) {
    }

    public Context d() {
        return null;
    }

    public boolean e() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f() {
    }

    public boolean g() {
        return false;
    }

    public abstract void removeOnMenuVisibilityListener(a aVar);

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f67a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f67a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
            this.f67a = obtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f67a = 0;
            this.f67a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f67a = 0;
            this.f67a = layoutParams.f67a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f67a = 0;
        }
    }
}
