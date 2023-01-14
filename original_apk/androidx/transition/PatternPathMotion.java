package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.a.b;
import androidx.core.content.a.i;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {

    /* renamed from: a  reason: collision with root package name */
    private Path f1231a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f1232b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f1233c = new Matrix();

    public PatternPathMotion() {
        this.f1232b.lineTo(1.0f, 0.0f);
        this.f1231a = this.f1232b;
    }

    public void a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, (float[]) null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, (float[]) null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f1233c.setTranslate(-f3, -f4);
        float f5 = f - f3;
        float f6 = f2 - f4;
        float a2 = 1.0f / a(f5, f6);
        this.f1233c.postScale(a2, a2);
        this.f1233c.postRotate((float) Math.toDegrees(-Math.atan2((double) f6, (double) f5)));
        path.transform(this.f1233c, this.f1232b);
        this.f1231a = path;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.k);
        try {
            String a2 = i.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (a2 != null) {
                a(b.b(a2));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public Path a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float a2 = a(f5, f6);
        double atan2 = Math.atan2((double) f6, (double) f5);
        this.f1233c.setScale(a2, a2);
        this.f1233c.postRotate((float) Math.toDegrees(atan2));
        this.f1233c.postTranslate(f, f2);
        Path path = new Path();
        this.f1232b.transform(this.f1233c, path);
        return path;
    }

    private static float a(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }
}
