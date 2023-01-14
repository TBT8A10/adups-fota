package androidx.core.h;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
public final class h {
    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
