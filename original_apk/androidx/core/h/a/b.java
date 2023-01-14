package androidx.core.h.a;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;

/* compiled from: AccessibilityManagerCompat */
public final class b {

    /* compiled from: AccessibilityManagerCompat */
    public interface a {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* renamed from: androidx.core.h.a.b$b  reason: collision with other inner class name */
    /* compiled from: AccessibilityManagerCompat */
    private static class C0013b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final a f682a;

        C0013b(a aVar) {
            this.f682a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0013b.class != obj.getClass()) {
                return false;
            }
            return this.f682a.equals(((C0013b) obj).f682a);
        }

        public int hashCode() {
            return this.f682a.hashCode();
        }

        public void onTouchExplorationStateChanged(boolean z) {
            this.f682a.onTouchExplorationStateChanged(z);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new C0013b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new C0013b(aVar));
    }
}
