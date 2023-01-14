package androidx.core.h.a;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityEventCompat */
public final class a {
    public static void a(AccessibilityEvent accessibilityEvent, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    public static int a(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }
}
