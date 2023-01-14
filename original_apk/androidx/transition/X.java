package androidx.transition;

import android.graphics.Path;

/* compiled from: Transition */
class X extends PathMotion {
    X() {
    }

    public Path a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f3, f4);
        return path;
    }
}
