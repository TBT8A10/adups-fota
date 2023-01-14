package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        s();
    }

    private void s() {
        b(1);
        a((Transition) new Fade(2)).a((Transition) new ChangeBounds()).a((Transition) new Fade(1));
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s();
    }
}
