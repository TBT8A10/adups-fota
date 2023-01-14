package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a.i;
import androidx.core.h.t;
import androidx.transition.Transition;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    private static final String[] K = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private static final Property<b, float[]> L = new C0138p(float[].class, "nonTranslations");
    private static final Property<b, PointF> M = new C0139q(PointF.class, "translations");
    private static final boolean N = (Build.VERSION.SDK_INT >= 21);
    boolean O = true;
    private boolean P = true;
    private Matrix Q = new Matrix();

    private static class a extends C0119aa {

        /* renamed from: a  reason: collision with root package name */
        private View f1208a;

        /* renamed from: b  reason: collision with root package name */
        private D f1209b;

        a(View view, D d) {
            this.f1208a = view;
            this.f1209b = d;
        }

        public void a(Transition transition) {
            this.f1209b.setVisibility(0);
        }

        public void c(Transition transition) {
            this.f1209b.setVisibility(4);
        }

        public void d(Transition transition) {
            transition.b((Transition.c) this);
            E.a(this.f1208a);
            this.f1208a.setTag(R$id.transition_transform, (Object) null);
            this.f1208a.setTag(R$id.parent_matrix, (Object) null);
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final float f1213a;

        /* renamed from: b  reason: collision with root package name */
        final float f1214b;

        /* renamed from: c  reason: collision with root package name */
        final float f1215c;
        final float d;
        final float e;
        final float f;
        final float g;
        final float h;

        c(View view) {
            this.f1213a = view.getTranslationX();
            this.f1214b = view.getTranslationY();
            this.f1215c = t.r(view);
            this.d = view.getScaleX();
            this.e = view.getScaleY();
            this.f = view.getRotationX();
            this.g = view.getRotationY();
            this.h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.a(view, this.f1213a, this.f1214b, this.f1215c, this.d, this.e, this.f, this.g, this.h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.f1213a == this.f1213a && cVar.f1214b == this.f1214b && cVar.f1215c == this.f1215c && cVar.d == this.d && cVar.e == this.e && cVar.f == this.f && cVar.g == this.g && cVar.h == this.h) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            float f2 = this.f1213a;
            int i = 0;
            int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.f1214b;
            int floatToIntBits2 = (floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f1215c;
            int floatToIntBits3 = (floatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.d;
            int floatToIntBits4 = (floatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.e;
            int floatToIntBits5 = (floatToIntBits4 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f;
            int floatToIntBits6 = (floatToIntBits5 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.g;
            int floatToIntBits7 = (floatToIntBits6 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.h;
            if (f9 != 0.0f) {
                i = Float.floatToIntBits(f9);
            }
            return floatToIntBits7 + i;
        }
    }

    public ChangeTransform() {
    }

    private void b(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        View view = gaVar2.f1273b;
        Matrix matrix = new Matrix((Matrix) gaVar2.f1272a.get("android:changeTransform:parentMatrix"));
        va.c(viewGroup, matrix);
        D a2 = E.a(view, viewGroup, matrix);
        if (a2 != null) {
            a2.a_shaKey_method2((ViewGroup) gaVar.f1272a.get("android:changeTransform:parent"), gaVar.f1273b);
            Transition transition = this;
            while (true) {
                Transition transition2 = transition.u;
                if (transition2 == null) {
                    break;
                }
                transition = transition2;
            }
            transition.a((Transition.c) new a(view, a2));
            if (N) {
                View view2 = gaVar.f1273b;
                if (view2 != gaVar2.f1273b) {
                    va.a_shaKey_method2(view2, 0.0f);
                }
                va.a_shaKey_method2(view, 1.0f);
            }
        }
    }

    private void d(ga gaVar) {
        View view = gaVar.f1273b;
        if (view.getVisibility() != 8) {
            gaVar.f1272a.put("android:changeTransform:parent", view.getParent());
            gaVar.f1272a.put("android:changeTransform:transforms", new c(view));
            Matrix matrix = view.getMatrix();
            gaVar.f1272a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
            if (this.P) {
                Matrix matrix2 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                va.b(viewGroup, matrix2);
                matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                gaVar.f1272a.put("android:changeTransform:parentMatrix", matrix2);
                gaVar.f1272a.put("android:changeTransform:intermediateMatrix", view.getTag(R$id.transition_transform));
                gaVar.f1272a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R$id.parent_matrix));
            }
        }
    }

    static void f(View view) {
        a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    public void a(ga gaVar) {
        d(gaVar);
    }

    public void c(ga gaVar) {
        d(gaVar);
        if (!N) {
            ((ViewGroup) gaVar.f1273b.getParent()).startViewTransition(gaVar.f1273b);
        }
    }

    public String[] n() {
        return K;
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Matrix f1210a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final View f1211b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f1212c;
        private float d;
        private float e;

        b(View view, float[] fArr) {
            this.f1211b = view;
            this.f1212c = (float[]) fArr.clone();
            float[] fArr2 = this.f1212c;
            this.d = fArr2[2];
            this.e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.f1212c;
            fArr[2] = this.d;
            fArr[5] = this.e;
            this.f1210a.setValues(fArr);
            va.a_shaKey_method2(this.f1211b, this.f1210a);
        }

        /* access modifiers changed from: package-private */
        public void a(float[] fArr) {
            System.arraycopy(fArr, 0, this.f1212c, 0, fArr.length);
            b();
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.d = pointF.x;
            this.e = pointF.y;
            b();
        }

        /* access modifiers changed from: package-private */
        public Matrix a() {
            return this.f1210a;
        }
    }

    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        if (gaVar == null || gaVar2 == null || !gaVar.f1272a.containsKey("android:changeTransform:parent") || !gaVar2.f1272a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) gaVar.f1272a.get("android:changeTransform:parent");
        boolean z = this.P && !a_shaKey_method2(viewGroup2, (ViewGroup) gaVar2.f1272a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) gaVar.f1272a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            gaVar.f1272a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) gaVar.f1272a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            gaVar.f1272a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            b(gaVar, gaVar2);
        }
        ObjectAnimator a2 = a(gaVar, gaVar2, z);
        if (z && a2 != null && this.O) {
            b(viewGroup, gaVar, gaVar2);
        } else if (!N) {
            viewGroup2.endViewTransition(gaVar.f1273b);
        }
        return a2;
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.O = i.a(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.P = i.a(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    private void b(ga gaVar, ga gaVar2) {
        Matrix matrix = (Matrix) gaVar2.f1272a.get("android:changeTransform:parentMatrix");
        gaVar2.f1273b.setTag(R$id.parent_matrix, matrix);
        Matrix matrix2 = this.Q;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) gaVar.f1272a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            gaVar.f1272a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) gaVar.f1272a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    private ObjectAnimator a(ga gaVar, ga gaVar2, boolean z) {
        Matrix matrix = (Matrix) gaVar.f1272a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) gaVar2.f1272a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = I.f1222a;
        }
        if (matrix2 == null) {
            matrix2 = I.f1222a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        View view = gaVar2.f1273b;
        f(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        b bVar = new b(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bVar, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(L, new C0142u(new float[9]), new float[][]{fArr, fArr2}), L.a_shaKey_method2(M, g().a(fArr[2], fArr[5], fArr2[2], fArr2[5]))});
        r rVar = new r(this, z, matrix3, view, (c) gaVar2.f1272a.get("android:changeTransform:transforms"), bVar);
        ofPropertyValuesHolder.addListener(rVar);
        C0118a.a_shaKey_method2(ofPropertyValuesHolder, rVar);
        return ofPropertyValuesHolder;
    }

    private boolean a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (b((View) viewGroup) && b((View) viewGroup2)) {
            ga a2 = a_shaKey_method2((View) viewGroup, true);
            if (a2 == null || viewGroup2 != a2.f1273b) {
                return false;
            }
        } else if (viewGroup == viewGroup2) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    static void a(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        t.b(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }
}
