package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;

/* compiled from: Slide */
class S extends Slide.c {
    S() {
        super((P) null);
    }

    public float a(ViewGroup viewGroup, View view) {
        return view.getTranslationY() - ((float) viewGroup.getHeight());
    }
}
