package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.H;
import androidx.appcompat.widget.qa;

public class ActionMenuItemView extends AppCompatTextView implements w.a, View.OnClickListener, ActionMenuView.a {
    p d;
    private CharSequence e;
    private Drawable f;
    l.b g;
    private H h;
    b i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int mMinWidth;

    private class a extends H {
        public a() {
            super(ActionMenuItemView.this);
        }

        public z a() {
            b bVar = ActionMenuItemView.this.i;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean b() {
            z a2;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            l.b bVar = actionMenuItemView.g;
            if (bVar == null || !bVar.a(actionMenuItemView.d) || (a2 = a()) == null || !a2.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class b {
        public abstract z a();
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean b() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void c() {
        CharSequence charSequence;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.e);
        if (this.f != null && (!this.d.r() || (!this.j && !this.k))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence2 = null;
        setText(z3 ? this.e : null);
        CharSequence d2 = this.d.d();
        if (TextUtils.isEmpty(d2)) {
            if (z3) {
                charSequence = null;
            } else {
                charSequence = this.d.getTitle();
            }
            setContentDescription(charSequence);
        } else {
            setContentDescription(d2);
        }
        CharSequence i2 = this.d.i();
        if (TextUtils.isEmpty(i2)) {
            if (!z3) {
                charSequence2 = this.d.getTitle();
            }
            qa.a_shaKey_method2(this, charSequence2);
            return;
        }
        qa.a_shaKey_method2(this, i2);
    }

    public void a(p pVar, int i2) {
        this.d = pVar;
        setIcon(pVar.getIcon());
        setTitle(pVar.a((w.a) this));
        setId(pVar.getItemId());
        setVisibility(pVar.isVisible() ? 0 : 8);
        setEnabled(pVar.isEnabled());
        if (pVar.hasSubMenu() && this.h == null) {
            this.h = new a();
        }
    }

    public p getItemData() {
        return this.d;
    }

    public boolean needsDividerAfter() {
        return a();
    }

    public boolean needsDividerBefore() {
        return a() && this.d.getIcon() == null;
    }

    public void onClick(View view) {
        l.b bVar = this.g;
        if (bVar != null) {
            bVar.a(this.d);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.j = b();
        c();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        boolean a2 = a();
        if (a2 && (i4 = this.l) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.mMinWidth) : this.mMinWidth;
        if (mode != 1073741824 && this.mMinWidth > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i3);
        }
        if (!a2 && this.f != null) {
            super.setPadding((getMeasuredWidth() - this.f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        H h2;
        if (!this.d.hasSubMenu() || (h2 = this.h) == null || !h2.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.k != z) {
            this.k = z;
            p pVar = this.d;
            if (pVar != null) {
                pVar.b();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.m;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i2) / ((float) intrinsicWidth)));
                intrinsicWidth = i2;
            }
            int i3 = this.m;
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i3) / ((float) intrinsicHeight)));
                intrinsicHeight = i3;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        c();
    }

    public void setItemInvoker(l.b bVar) {
        this.g = bVar;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.l = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.i = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.e = charSequence;
        c();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.j = b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i2, 0);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.m = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.l = -1;
        setSaveEnabled(false);
    }

    public boolean a() {
        return !TextUtils.isEmpty(getText());
    }
}
