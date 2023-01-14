package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: GhostViewUtils */
class E {
    static D a(View view, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C.a(view, viewGroup, matrix);
        }
        return B.a_shaKey_method2(view, viewGroup);
    }

    static void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            C.a(view);
        } else {
            B.b(view);
        }
    }
}
