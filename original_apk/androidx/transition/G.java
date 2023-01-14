package androidx.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ImageViewUtils */
class G {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1220a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1221b;

    static void a(ImageView imageView) {
        if (Build.VERSION.SDK_INT < 21) {
            ImageView.ScaleType scaleType = imageView.getScaleType();
            imageView.setTag(R$id.save_scale_type, scaleType);
            ImageView.ScaleType scaleType2 = ImageView.ScaleType.MATRIX;
            if (scaleType == scaleType2) {
                imageView.setTag(R$id.save_image_matrix, imageView.getImageMatrix());
            } else {
                imageView.setScaleType(scaleType2);
            }
            imageView.setImageMatrix(I.f1222a);
        }
    }

    static void a(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT < 21) {
            imageView.setImageMatrix(matrix);
            return;
        }
        a();
        Method method = f1220a;
        if (method != null) {
            try {
                method.invoke(imageView, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    private static void a() {
        if (!f1221b) {
            try {
                f1220a = ImageView.class.getDeclaredMethod("animateTransform", new Class[]{Matrix.class});
                f1220a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ImageViewUtils", "Failed to retrieve animateTransform method", e);
            }
            f1221b = true;
        }
    }

    static void a(ImageView imageView, Animator animator) {
        if (Build.VERSION.SDK_INT < 21) {
            animator.addListener(new F(imageView));
        }
    }
}
