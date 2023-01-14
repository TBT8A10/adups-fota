package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;

/* compiled from: Slide */
class P extends Slide.b {
    P() {
        super((P) null);
    }

    public float b(ViewGroup viewGroup, View view) {
        return view.getTranslationX() - ((float) viewGroup.getWidth());
    }
}
