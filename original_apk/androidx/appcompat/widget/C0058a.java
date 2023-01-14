package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.h.A;
import androidx.core.h.t;
import androidx.core.h.z;

/* renamed from: androidx.appcompat.widget.a  reason: case insensitive filesystem */
/* compiled from: AbsActionBarView */
abstract class C0058a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final C0005a f401a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f402b;

    /* renamed from: c  reason: collision with root package name */
    protected ActionMenuView f403c;
    protected ActionMenuPresenter d;
    protected int e;
    protected z f;
    private boolean g;
    private boolean h;

    C0058a(Context context) {
        this(context, (AttributeSet) null);
    }

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public int getAnimatedVisibility() {
        if (this.f != null) {
            return this.f401a.f405b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            z zVar = this.f;
            if (zVar != null) {
                zVar.a();
            }
            super.setVisibility(i);
        }
    }

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    /* compiled from: AbsActionBarView */
    protected class C0005a implements A {

        /* renamed from: a  reason: collision with root package name */
        private boolean f404a = false;

        /* renamed from: b  reason: collision with root package name */
        int f405b;

        protected C0005a() {
        }

        public C0005a a(z zVar, int i) {
            C0058a.this.f = zVar;
            this.f405b = i;
            return this;
        }

        public void b(View view) {
            if (!this.f404a) {
                C0058a aVar = C0058a.this;
                aVar.f = null;
                C0058a.super.setVisibility(this.f405b);
            }
        }

        public void c(View view) {
            C0058a.super.setVisibility(0);
            this.f404a = false;
        }

        public void a(View view) {
            this.f404a = true;
        }
    }

    C0058a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public z a(int i, long j) {
        z zVar = this.f;
        if (zVar != null) {
            zVar.a();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            z a2 = t.a(this);
            a2.a(1.0f);
            a2.a(j);
            C0005a aVar = this.f401a;
            aVar.a(a2, i);
            a2.a((A) aVar);
            return a2;
        }
        z a3 = t.a(this);
        a3.a(0.0f);
        a3.a(j);
        C0005a aVar2 = this.f401a;
        aVar2.a(a3, i);
        a3.a((A) aVar2);
        return a3;
    }

    C0058a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        this.f401a = new C0005a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || (i2 = typedValue.resourceId) == 0) {
            this.f402b = context;
        } else {
            this.f402b = new ContextThemeWrapper(context, i2);
        }
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
