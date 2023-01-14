package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* renamed from: androidx.transition.g  reason: case insensitive filesystem */
/* compiled from: ChangeBounds */
class C0129g extends Property<View, PointF> {
    C0129g(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public PointF get(View view) {
        return null;
    }

    /* renamed from: a */
    public void set(View view, PointF pointF) {
        va.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
    }
}
