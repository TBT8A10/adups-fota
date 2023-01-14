package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a.i;
import androidx.core.h.t;
import androidx.transition.Transition;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeBounds extends Transition {
    private static final String[] K = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> L = new C0122c(PointF.class, "boundsOrigin");
    private static final Property<a, PointF> M = new C0124d(PointF.class, "topLeft");
    private static final Property<a, PointF> N = new C0126e(PointF.class, "bottomRight");
    private static final Property<View, PointF> O = new C0128f(PointF.class, "bottomRight");
    private static final Property<View, PointF> P = new C0129g(PointF.class, "topLeft");
    private static final Property<View, PointF> Q = new C0130h(PointF.class, "position");
    private static M R = new M();
    private int[] S = new int[2];
    private boolean T = false;
    private boolean U = false;

    public ChangeBounds() {
    }

    private void d(ga gaVar) {
        View view = gaVar.f1273b;
        if (t.z(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            gaVar.f1272a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            gaVar.f1272a.put("android:changeBounds:parent", gaVar.f1273b.getParent());
            if (this.U) {
                gaVar.f1273b.getLocationInWindow(this.S);
                gaVar.f1272a.put("android:changeBounds:windowX", Integer.valueOf(this.S[0]));
                gaVar.f1272a.put("android:changeBounds:windowY", Integer.valueOf(this.S[1]));
            }
            if (this.T) {
                gaVar.f1272a.put("android:changeBounds:clip", t.e(view));
            }
        }
    }

    public void a(ga gaVar) {
        d(gaVar);
    }

    public void b(boolean z) {
        this.T = z;
    }

    public void c(ga gaVar) {
        d(gaVar);
    }

    public String[] n() {
        return K;
    }

    private boolean a(View view, View view2) {
        if (!this.U) {
            return true;
        }
        ga a2 = a_shaKey_method2(view, true);
        if (a2 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == a2.f1273b) {
            return true;
        }
        return false;
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f1205a;

        /* renamed from: b  reason: collision with root package name */
        private int f1206b;

        /* renamed from: c  reason: collision with root package name */
        private int f1207c;
        private int d;
        private View e;
        private int f;
        private int g;

        a(View view) {
            this.e = view;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f1207c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            this.g++;
            if (this.f == this.g) {
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(PointF pointF) {
            this.f1205a = Math.round(pointF.x);
            this.f1206b = Math.round(pointF.y);
            this.f++;
            if (this.f == this.g) {
                a();
            }
        }

        private void a() {
            va.a(this.e, this.f1205a, this.f1206b, this.f1207c, this.d);
            this.f = 0;
            this.g = 0;
        }
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.d);
        boolean a2 = i.a(obtainStyledAttributes, (XmlPullParser) (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        b(a2);
    }

    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        int i;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator2;
        ga gaVar3 = gaVar;
        ga gaVar4 = gaVar2;
        if (gaVar3 == null || gaVar4 == null) {
            return null;
        }
        Map<String, Object> map = gaVar3.f1272a;
        Map<String, Object> map2 = gaVar4.f1272a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = gaVar4.f1273b;
        if (a_shaKey_method2(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) gaVar3.f1272a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) gaVar4.f1272a.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            int i4 = rect3.left;
            int i5 = rect2.top;
            int i6 = rect3.top;
            int i7 = rect2.right;
            int i8 = rect3.right;
            int i9 = rect2.bottom;
            int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            View view3 = view2;
            Rect rect4 = (Rect) gaVar3.f1272a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) gaVar4.f1272a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (!(i7 == i8 && i9 == i10)) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.T) {
                view = view3;
                va.a(view, i3, i5, i7, i9);
                if (i == 2) {
                    if (i11 == i13 && i12 == i14) {
                        animator = J.a(view, Q, g().a((float) i3, (float) i5, (float) i4, (float) i6));
                    } else {
                        a aVar = new a(view);
                        ObjectAnimator a2 = J.a(aVar, M, g().a((float) i3, (float) i5, (float) i4, (float) i6));
                        ObjectAnimator a3 = J.a(aVar, N, g().a((float) i7, (float) i9, (float) i8, (float) i10));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a2, a3});
                        animatorSet.addListener(new C0131i(this, aVar));
                        animator = animatorSet;
                    }
                } else if (i3 == i4 && i5 == i6) {
                    animator = J.a(view, O, g().a((float) i7, (float) i9, (float) i8, (float) i10));
                } else {
                    animator = J.a(view, P, g().a((float) i3, (float) i5, (float) i4, (float) i6));
                }
            } else {
                view = view3;
                va.a(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                if (i3 == i4 && i5 == i6) {
                    objectAnimator = null;
                } else {
                    objectAnimator = J.a(view, Q, g().a((float) i3, (float) i5, (float) i4, (float) i6));
                }
                if (rect7 == null) {
                    i2 = 0;
                    rect = new Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i2, i2, i13, i14) : rect6;
                if (!rect.equals(rect8)) {
                    t.a_shaKey_method2(view, rect);
                    M m = R;
                    Object[] objArr = new Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect8;
                    objectAnimator2 = ObjectAnimator.ofObject(view, "clipBounds", m, objArr);
                    objectAnimator2.addListener(new C0132j(this, view, rect6, i4, i6, i8, i10));
                } else {
                    objectAnimator2 = null;
                }
                animator = fa.a_shaKey_method2(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ma.a_shaKey_method2(viewGroup4, true);
                a((Transition.c) new C0133k(this, viewGroup4));
            }
            return animator;
        }
        int intValue = ((Integer) gaVar3.f1272a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) gaVar3.f1272a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) gaVar4.f1272a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) gaVar4.f1272a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.S);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c2 = va.c(view2);
        va.a_shaKey_method2(view2, 0.0f);
        va.b(viewGroup).a(bitmapDrawable);
        PathMotion g = g();
        int[] iArr = this.S;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{L.a_shaKey_method2(L, g.a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1])))});
        ofPropertyValuesHolder.addListener(new C0120b(this, viewGroup, bitmapDrawable, view2, c2));
        return ofPropertyValuesHolder;
    }
}
