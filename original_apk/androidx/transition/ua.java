package androidx.transition;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.core.h.t;

/* compiled from: ViewUtils */
class ua extends Property<View, Rect> {
    ua(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public Rect get(View view) {
        return t.e(view);
    }

    /* renamed from: a */
    public void set(View view, Rect rect) {
        t.a_shaKey_method2(view, rect);
    }
}
