package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.t;
import androidx.transition.Slide;

/* compiled from: Slide */
class U extends Slide.b {
    U() {
        super((P) null);
    }

    public float b(ViewGroup viewGroup, View view) {
        boolean z = true;
        if (t.k(viewGroup) != 1) {
            z = false;
        }
        if (z) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
        return view.getTranslationX() + ((float) viewGroup.getWidth());
    }
}
