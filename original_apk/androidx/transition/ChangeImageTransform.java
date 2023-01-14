package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.fa;
import java.util.Map;

public class ChangeImageTransform extends Transition {
    private static final String[] K = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    private static final TypeEvaluator<Matrix> L = new C0135m();
    private static final Property<ImageView, Matrix> M = new C0136n(Matrix.class, "animatedTransform");

    public ChangeImageTransform() {
    }

    private static Matrix b(ImageView imageView) {
        int i = C0137o.f1292a[imageView.getScaleType().ordinal()];
        if (i == 1) {
            return d(imageView);
        }
        if (i != 2) {
            return new Matrix(imageView.getImageMatrix());
        }
        return a(imageView);
    }

    private void d(ga gaVar) {
        View view = gaVar.f1273b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Map<String, Object> map = gaVar.f1272a;
                map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                map.put("android:changeImageTransform:matrix", b(imageView));
            }
        }
    }

    public void a(ga gaVar) {
        d(gaVar);
    }

    public void c(ga gaVar) {
        d(gaVar);
    }

    public String[] n() {
        return K;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ObjectAnimator c(ImageView imageView) {
        return ObjectAnimator.ofObject(imageView, M, L, new Matrix[]{null, null});
    }

    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        ObjectAnimator objectAnimator;
        if (!(gaVar == null || gaVar2 == null)) {
            Rect rect = (Rect) gaVar.f1272a.get("android:changeImageTransform:bounds");
            Rect rect2 = (Rect) gaVar2.f1272a.get("android:changeImageTransform:bounds");
            if (!(rect == null || rect2 == null)) {
                Matrix matrix = (Matrix) gaVar.f1272a.get("android:changeImageTransform:matrix");
                Matrix matrix2 = (Matrix) gaVar2.f1272a.get("android:changeImageTransform:matrix");
                boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
                if (rect.equals(rect2) && z) {
                    return null;
                }
                ImageView imageView = (ImageView) gaVar2.f1273b;
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                G.a(imageView);
                if (intrinsicWidth == 0 || intrinsicHeight == 0) {
                    objectAnimator = c(imageView);
                } else {
                    if (matrix == null) {
                        matrix = I.f1222a;
                    }
                    if (matrix2 == null) {
                        matrix2 = I.f1222a;
                    }
                    M.set(imageView, matrix);
                    objectAnimator = a(imageView, matrix, matrix2);
                }
                G.a_shaKey_method2(imageView, (Animator) objectAnimator);
                return objectAnimator;
            }
        }
        return null;
    }

    private static Matrix d(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) imageView.getWidth()) / ((float) drawable.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable.getIntrinsicHeight()));
        return matrix;
    }

    private ObjectAnimator a(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, M, new fa.a(), new Matrix[]{matrix, matrix2});
    }

    private static Matrix a(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = (float) imageView.getWidth();
        float f = (float) intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = (float) imageView.getHeight();
        float f2 = (float) intrinsicHeight;
        float max = Math.max(width / f, height / f2);
        int round = Math.round((width - (f * max)) / 2.0f);
        int round2 = Math.round((height - (f2 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate((float) round, (float) round2);
        return matrix;
    }
}
