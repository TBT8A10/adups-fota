package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ChangeTransform;

/* compiled from: ChangeTransform */
class r extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1302a;

    /* renamed from: b  reason: collision with root package name */
    private Matrix f1303b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f1304c;
    final /* synthetic */ Matrix d;
    final /* synthetic */ View e;
    final /* synthetic */ ChangeTransform.c f;
    final /* synthetic */ ChangeTransform.b g;
    final /* synthetic */ ChangeTransform h;

    r(ChangeTransform changeTransform, boolean z, Matrix matrix, View view, ChangeTransform.c cVar, ChangeTransform.b bVar) {
        this.h = changeTransform;
        this.f1304c = z;
        this.d = matrix;
        this.e = view;
        this.f = cVar;
        this.g = bVar;
    }

    private void a(Matrix matrix) {
        this.f1303b.set(matrix);
        this.e.setTag(R$id.transition_transform, this.f1303b);
        this.f.a(this.e);
    }

    public void onAnimationCancel(Animator animator) {
        this.f1302a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f1302a) {
            if (!this.f1304c || !this.h.O) {
                this.e.setTag(R$id.transition_transform, (Object) null);
                this.e.setTag(R$id.parent_matrix, (Object) null);
            } else {
                a(this.d);
            }
        }
        va.a_shaKey_method2(this.e, (Matrix) null);
        this.f.a(this.e);
    }

    public void onAnimationPause(Animator animator) {
        a(this.g.a());
    }

    public void onAnimationResume(Animator animator) {
        ChangeTransform.f(this.e);
    }
}
