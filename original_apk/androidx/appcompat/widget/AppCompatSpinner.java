package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.core.h.r;
import androidx.core.h.t;

public class AppCompatSpinner extends Spinner implements r {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f308a = {16843505};

    /* renamed from: b  reason: collision with root package name */
    private final C0072o f309b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f310c;
    int mDropDownWidth;
    private H mForwardingListener;
    b mPopup;
    private final Context mPopupContext;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    private static class a implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private SpinnerAdapter f311a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f312b;

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f311a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f312b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof ea) {
                ea eaVar = (ea) spinnerAdapter;
                if (eaVar.getDropDownViewTheme() == null) {
                    eaVar.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f312b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f311a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f311a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f311a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f311a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f311a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f312b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f311a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f311a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class b extends ListPopupWindow {
        private CharSequence K;
        ListAdapter L;
        private final Rect M = new Rect();

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            a((View) AppCompatSpinner.this);
            a(true);
            f(0);
            setOnItemClickListener(new C0079w(this, AppCompatSpinner.this));
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view) {
            return t.y(view) && view.getGlobalVisibleRect(this.M);
        }

        /* access modifiers changed from: package-private */
        public void i() {
            Drawable c2 = c();
            int i = 0;
            if (c2 != null) {
                c2.getPadding(AppCompatSpinner.this.mTempRect);
                i = wa.a(AppCompatSpinner.this) ? AppCompatSpinner.this.mTempRect.right : -AppCompatSpinner.this.mTempRect.left;
            } else {
                Rect rect = AppCompatSpinner.this.mTempRect;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i2 = appCompatSpinner.mDropDownWidth;
            if (i2 == -2) {
                int a2 = appCompatSpinner.a_shaKey_method2((SpinnerAdapter) this.L, c());
                int i3 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.mTempRect;
                int i4 = (i3 - rect2.left) - rect2.right;
                if (a2 > i4) {
                    a2 = i4;
                }
                b(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i2 == -1) {
                b((width - paddingLeft) - paddingRight);
            } else {
                b(i2);
            }
            d(wa.a(AppCompatSpinner.this) ? i + ((width - paddingRight) - f()) : i + paddingLeft);
        }

        public CharSequence j() {
            return this.K;
        }

        public void show() {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            i();
            e(2);
            super.show();
            getListView().setChoiceMode(1);
            g(AppCompatSpinner.this.getSelectedItemPosition());
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                C0080x xVar = new C0080x(this);
                viewTreeObserver.addOnGlobalLayoutListener(xVar);
                setOnDismissListener(new C0081y(this, xVar));
            }
        }

        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.L = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.K = charSequence;
        }
    }

    public AppCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.mTempRect);
        Rect rect = this.mTempRect;
        return i2 + rect.left + rect.right;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0072o oVar = this.f309b;
        if (oVar != null) {
            oVar.a();
        }
    }

    public int getDropDownHorizontalOffset() {
        b bVar = this.mPopup;
        if (bVar != null) {
            return bVar.d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        b bVar = this.mPopup;
        if (bVar != null) {
            return bVar.e();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public Drawable getPopupBackground() {
        b bVar = this.mPopup;
        if (bVar != null) {
            return bVar.c();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        if (this.mPopup != null) {
            return this.mPopupContext;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    public CharSequence getPrompt() {
        b bVar = this.mPopup;
        return bVar != null ? bVar.j() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0072o oVar = this.f309b;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0072o oVar = this.f309b;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.mPopup;
        if (bVar != null && bVar.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a_shaKey_method2(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        H h = this.mForwardingListener;
        if (h == null || !h.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        b bVar = this.mPopup;
        if (bVar == null) {
            return super.performClick();
        }
        if (bVar.isShowing()) {
            return true;
        }
        this.mPopup.show();
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0072o oVar = this.f309b;
        if (oVar != null) {
            oVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0072o oVar = this.f309b;
        if (oVar != null) {
            oVar.a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        b bVar = this.mPopup;
        if (bVar != null) {
            bVar.d(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        b bVar = this.mPopup;
        if (bVar != null) {
            bVar.h(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        b bVar = this.mPopup;
        if (bVar != null) {
            bVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        b bVar = this.mPopup;
        if (bVar != null) {
            bVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0072o oVar = this.f309b;
        if (oVar != null) {
            oVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0072o oVar = this.f309b;
        if (oVar != null) {
            oVar.a(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spinnerStyle);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f310c) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mPopup != null) {
            Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            this.mPopup.a((ListAdapter) new a(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r12 != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006a, code lost:
        if (r12 != null) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) {
        /*
            r7 = this;
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.mTempRect = r0
            int[] r0 = androidx.appcompat.R$styleable.Spinner
            r1 = 0
            androidx.appcompat.widget.ia r0 = androidx.appcompat.widget.ia.a(r8, r9, r0, r10, r1)
            androidx.appcompat.widget.o r2 = new androidx.appcompat.widget.o
            r2.<init>(r7)
            r7.f309b = r2
            r2 = 0
            if (r12 == 0) goto L_0x0023
            androidx.appcompat.d.d r3 = new androidx.appcompat.d.d
            r3.<init>((android.content.Context) r8, (android.content.res.Resources.Theme) r12)
            r7.mPopupContext = r3
            goto L_0x003e
        L_0x0023:
            int r12 = androidx.appcompat.R$styleable.Spinner_popupTheme
            int r12 = r0.g(r12, r1)
            if (r12 == 0) goto L_0x0033
            androidx.appcompat.d.d r3 = new androidx.appcompat.d.d
            r3.<init>((android.content.Context) r8, (int) r12)
            r7.mPopupContext = r3
            goto L_0x003e
        L_0x0033:
            int r12 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r12 >= r3) goto L_0x003b
            r12 = r8
            goto L_0x003c
        L_0x003b:
            r12 = r2
        L_0x003c:
            r7.mPopupContext = r12
        L_0x003e:
            android.content.Context r12 = r7.mPopupContext
            r3 = 1
            if (r12 == 0) goto L_0x00ac
            r12 = -1
            if (r11 != r12) goto L_0x0074
            int[] r12 = f308a     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            android.content.res.TypedArray r12 = r8.obtainStyledAttributes(r9, r12, r10, r1)     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            boolean r4 = r12.hasValue(r1)     // Catch:{ Exception -> 0x005c }
            if (r4 == 0) goto L_0x0056
            int r11 = r12.getInt(r1, r1)     // Catch:{ Exception -> 0x005c }
        L_0x0056:
            if (r12 == 0) goto L_0x0074
        L_0x0058:
            r12.recycle()
            goto L_0x0074
        L_0x005c:
            r4 = move-exception
            goto L_0x0063
        L_0x005e:
            r8 = move-exception
            r12 = r2
            goto L_0x006e
        L_0x0061:
            r4 = move-exception
            r12 = r2
        L_0x0063:
            java.lang.String r5 = "AppCompatSpinner"
            java.lang.String r6 = "Could not read android:spinnerMode"
            android.util.Log.i(r5, r6, r4)     // Catch:{ all -> 0x006d }
            if (r12 == 0) goto L_0x0074
            goto L_0x0058
        L_0x006d:
            r8 = move-exception
        L_0x006e:
            if (r12 == 0) goto L_0x0073
            r12.recycle()
        L_0x0073:
            throw r8
        L_0x0074:
            if (r11 != r3) goto L_0x00ac
            androidx.appcompat.widget.AppCompatSpinner$b r11 = new androidx.appcompat.widget.AppCompatSpinner$b
            android.content.Context r12 = r7.mPopupContext
            r11.<init>(r12, r9, r10)
            android.content.Context r12 = r7.mPopupContext
            int[] r4 = androidx.appcompat.R$styleable.Spinner
            androidx.appcompat.widget.ia r12 = androidx.appcompat.widget.ia.a(r12, r9, r4, r10, r1)
            int r1 = androidx.appcompat.R$styleable.Spinner_android_dropDownWidth
            r4 = -2
            int r1 = r12.f(r1, r4)
            r7.mDropDownWidth = r1
            int r1 = androidx.appcompat.R$styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r1 = r12.b(r1)
            r11.a((android.graphics.drawable.Drawable) r1)
            int r1 = androidx.appcompat.R$styleable.Spinner_android_prompt
            java.lang.String r1 = r0.d(r1)
            r11.a((java.lang.CharSequence) r1)
            r12.a()
            r7.mPopup = r11
            androidx.appcompat.widget.v r12 = new androidx.appcompat.widget.v
            r12.<init>(r7, r7, r11)
            r7.mForwardingListener = r12
        L_0x00ac:
            int r11 = androidx.appcompat.R$styleable.Spinner_android_entries
            java.lang.CharSequence[] r11 = r0.f(r11)
            if (r11 == 0) goto L_0x00c4
            android.widget.ArrayAdapter r12 = new android.widget.ArrayAdapter
            r1 = 17367048(0x1090008, float:2.5162948E-38)
            r12.<init>(r8, r1, r11)
            int r8 = androidx.appcompat.R$layout.support_simple_spinner_dropdown_item
            r12.setDropDownViewResource(r8)
            r7.setAdapter((android.widget.SpinnerAdapter) r12)
        L_0x00c4:
            r0.a()
            r7.f310c = r3
            android.widget.SpinnerAdapter r8 = r7.mTempAdapter
            if (r8 == 0) goto L_0x00d2
            r7.setAdapter((android.widget.SpinnerAdapter) r8)
            r7.mTempAdapter = r2
        L_0x00d2:
            androidx.appcompat.widget.o r8 = r7.f309b
            r8.a(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
