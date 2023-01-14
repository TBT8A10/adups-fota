package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

public abstract class PathMotion {
    public PathMotion() {
    }

    public abstract Path a(float f, float f2, float f3, float f4);

    public PathMotion(Context context, AttributeSet attributeSet) {
    }
}
