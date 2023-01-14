package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

@SuppressLint({"ViewConstructor"})
/* compiled from: GhostViewApi14 */
class B extends View implements D {

    /* renamed from: a  reason: collision with root package name */
    final View f1197a;

    /* renamed from: b  reason: collision with root package name */
    ViewGroup f1198b;

    /* renamed from: c  reason: collision with root package name */
    View f1199c;
    int d;
    private int e;
    private int f;
    Matrix g;
    private final Matrix h = new Matrix();
    private final ViewTreeObserver.OnPreDrawListener i = new A(this);

    B(View view) {
        super(view.getContext());
        this.f1197a = view;
        setLayerType(2, (Paint) null);
    }

    static D a(View view, ViewGroup viewGroup) {
        B a2 = a(view);
        if (a2 == null) {
            FrameLayout a3 = a(viewGroup);
            if (a3 == null) {
                return null;
            }
            a2 = new B(view);
            a3.addView(a2);
        }
        a2.d++;
        return a2;
    }

    static void b(View view) {
        B a2 = a(view);
        if (a2 != null) {
            a2.d--;
            if (a2.d <= 0) {
                ViewParent parent = a2.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.endViewTransition(a2);
                    viewGroup.removeView(a2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a_shaKey_method2(this.f1197a, this);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr);
        this.f1197a.getLocationOnScreen(iArr2);
        iArr2[0] = (int) (((float) iArr2[0]) - this.f1197a.getTranslationX());
        iArr2[1] = (int) (((float) iArr2[1]) - this.f1197a.getTranslationY());
        this.e = iArr2[0] - iArr[0];
        this.f = iArr2[1] - iArr[1];
        this.f1197a.getViewTreeObserver().addOnPreDrawListener(this.i);
        this.f1197a.setVisibility(4);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f1197a.getViewTreeObserver().removeOnPreDrawListener(this.i);
        this.f1197a.setVisibility(0);
        a_shaKey_method2(this.f1197a, (B) null);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.h.set(this.g);
        this.h.postTranslate((float) this.e, (float) this.f);
        canvas.setMatrix(this.h);
        this.f1197a.draw(canvas);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        this.f1197a.setVisibility(i2 == 0 ? 4 : 0);
    }

    private static FrameLayout a(ViewGroup viewGroup) {
        while (!(viewGroup instanceof FrameLayout)) {
            ViewParent parent = viewGroup.getParent();
            if (!(parent instanceof ViewGroup)) {
                return null;
            }
            viewGroup = (ViewGroup) parent;
        }
        return (FrameLayout) viewGroup;
    }

    public void a(ViewGroup viewGroup, View view) {
        this.f1198b = viewGroup;
        this.f1199c = view;
    }

    private static void a(View view, B b2) {
        view.setTag(R$id.ghost_view, b2);
    }

    static B a(View view) {
        return (B) view.getTag(R$id.ghost_view);
    }
}
