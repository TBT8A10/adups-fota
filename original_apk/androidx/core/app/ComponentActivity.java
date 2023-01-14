package androidx.core.app;

import a.b.i;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.h.C0086d;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.lifecycle.j;

public class ComponentActivity extends Activity implements h, C0086d.a {
    private i<Class<? extends a>, a> mExtraDataMap = new i<>();
    private j mLifecycleRegistry = new j(this);

    public static class a {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0086d.a_shaKey_method2(decorView, keyEvent)) {
            return C0086d.a(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0086d.a_shaKey_method2(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public <T extends a> T getExtraData(Class<T> cls) {
        return (a) this.mExtraDataMap.get(cls);
    }

    public f getLifecycle() {
        return this.mLifecycleRegistry;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.a((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.a(f.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public void putExtraData(a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
