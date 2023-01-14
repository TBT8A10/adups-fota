package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.widget.ImageView;

/* compiled from: ImageViewUtils */
class F extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageView f1217a;

    F(ImageView imageView) {
        this.f1217a = imageView;
    }

    public void onAnimationEnd(Animator animator) {
        ImageView.ScaleType scaleType = (ImageView.ScaleType) this.f1217a.getTag(R$id.save_scale_type);
        this.f1217a.setScaleType(scaleType);
        this.f1217a.setTag(R$id.save_scale_type, (Object) null);
        if (scaleType == ImageView.ScaleType.MATRIX) {
            ImageView imageView = this.f1217a;
            imageView.setImageMatrix((Matrix) imageView.getTag(R$id.save_image_matrix));
            this.f1217a.setTag(R$id.save_image_matrix, (Object) null);
        }
        animator.removeListener(this);
    }
}
