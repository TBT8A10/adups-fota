package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.h.t;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f264a;

    /* renamed from: b  reason: collision with root package name */
    private View f265b;

    /* renamed from: c  reason: collision with root package name */
    private View f266c;
    private View d;
    Drawable e;
    Drawable f;
    boolean g;
    boolean h;
    private int i;
    Drawable mBackground;

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mBackground;
        if (drawable != null && drawable.isStateful()) {
            this.mBackground.setState(getDrawableState());
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null && drawable2.isStateful()) {
            this.e.setState(getDrawableState());
        }
        Drawable drawable3 = this.f;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f265b;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mBackground;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f266c = findViewById(R$id.action_bar);
        this.d = findViewById(R$id.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f264a || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f265b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i2, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i4, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.g) {
            Drawable drawable2 = this.f;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.mBackground != null) {
                if (this.f266c.getVisibility() == 0) {
                    this.mBackground.setBounds(this.f266c.getLeft(), this.f266c.getTop(), this.f266c.getRight(), this.f266c.getBottom());
                } else {
                    View view2 = this.d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.mBackground.setBounds(0, 0, 0, 0);
                    } else {
                        this.mBackground.setBounds(this.d.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
                    }
                }
                z3 = true;
            }
            this.h = z4;
            if (!z4 || (drawable = this.e) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.f266c == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i5 = this.i) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f266c != null) {
            int mode = View.MeasureSpec.getMode(i3);
            View view = this.f265b;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.f266c)) {
                    i4 = a(this.f266c);
                } else {
                    i4 = !b(this.d) ? a(this.d) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i4 + a(this.f265b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.mBackground;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.mBackground);
        }
        this.mBackground = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f266c;
            if (view != null) {
                this.mBackground.setBounds(view.getLeft(), this.f266c.getTop(), this.f266c.getRight(), this.f266c.getBottom());
            }
        }
        boolean z = true;
        if (!this.g ? !(this.mBackground == null && this.e == null) : this.f != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f);
        }
        this.f = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.g && (drawable2 = this.f) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.g ? this.mBackground == null && this.e == null : this.f == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.e;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.e);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.h && (drawable2 = this.e) != null) {
                drawable2.setBounds(this.f265b.getLeft(), this.f265b.getTop(), this.f265b.getRight(), this.f265b.getBottom());
            }
        }
        boolean z = true;
        if (!this.g ? !(this.mBackground == null && this.e == null) : this.f != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f265b;
        if (view != null) {
            removeView(view);
        }
        this.f265b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f264a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.mBackground;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.mBackground && !this.g) || (drawable == this.e && this.h) || ((drawable == this.f && this.g) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t.a_shaKey_method2((View) this, (Drawable) new C0059b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.mBackground = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.e = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.i = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        if (getId() == R$id.split_action_bar) {
            this.g = true;
            this.f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.g ? this.mBackground == null && this.e == null : this.f == null) {
            z = true;
        }
        setWillNotDraw(z);
    }
}
