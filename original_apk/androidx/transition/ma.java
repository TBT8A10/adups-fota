package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils */
class ma {
    static la a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ka(viewGroup);
        }
        return ja.a(viewGroup);
    }

    static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            pa.a_shaKey_method2(viewGroup, z);
        } else {
            oa.a_shaKey_method2(viewGroup, z);
        }
    }
}
