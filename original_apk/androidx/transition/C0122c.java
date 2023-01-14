package androidx.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* renamed from: androidx.transition.c  reason: case insensitive filesystem */
/* compiled from: ChangeBounds */
class C0122c extends Property<Drawable, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private Rect f1258a = new Rect();

    C0122c(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public void set(Drawable drawable, PointF pointF) {
        drawable.copyBounds(this.f1258a);
        this.f1258a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
        drawable.setBounds(this.f1258a);
    }

    /* renamed from: a */
    public PointF get(Drawable drawable) {
        drawable.copyBounds(this.f1258a);
        Rect rect = this.f1258a;
        return new PointF((float) rect.left, (float) rect.top);
    }
}
