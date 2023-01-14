package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: Scene */
public class N {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f1227a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f1228b;

    public void a() {
        Runnable runnable;
        if (a(this.f1227a) == this && (runnable = this.f1228b) != null) {
            runnable.run();
        }
    }

    static void a(View view, N n) {
        view.setTag(R$id.transition_current_scene, n);
    }

    static N a(View view) {
        return (N) view.getTag(R$id.transition_current_scene);
    }
}
