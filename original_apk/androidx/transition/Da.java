package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18 */
class Da implements Ea {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f1216a;

    Da(View view) {
        this.f1216a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Da) && ((Da) obj).f1216a.equals(this.f1216a);
    }

    public int hashCode() {
        return this.f1216a.hashCode();
    }
}
