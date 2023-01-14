package androidx.transition;

import android.util.Property;
import android.view.View;

/* compiled from: ViewUtils */
class ta extends Property<View, Float> {
    ta(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public Float get(View view) {
        return Float.valueOf(va.c(view));
    }

    /* renamed from: a */
    public void set(View view, Float f) {
        va.a_shaKey_method2(view, f.floatValue());
    }
}
