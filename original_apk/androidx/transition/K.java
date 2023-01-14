package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PathProperty */
class K<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f1223a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f1224b;

    /* renamed from: c  reason: collision with root package name */
    private final float f1225c;
    private final float[] d = new float[2];
    private final PointF e = new PointF();
    private float f;

    K(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f1223a = property;
        this.f1224b = new PathMeasure(path, false);
        this.f1225c = this.f1224b.getLength();
    }

    /* renamed from: a */
    public void set(T t, Float f2) {
        this.f = f2.floatValue();
        this.f1224b.getPosTan(this.f1225c * f2.floatValue(), this.d, (float[]) null);
        PointF pointF = this.e;
        float[] fArr = this.d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f1223a.set(t, pointF);
    }

    public Float get(T t) {
        return Float.valueOf(this.f);
    }
}
