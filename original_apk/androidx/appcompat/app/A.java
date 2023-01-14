package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.d.b;
import androidx.core.h.C0086d;

/* compiled from: AppCompatDialog */
public class A extends Dialog implements m {

    /* renamed from: a  reason: collision with root package name */
    private n f65a;

    /* renamed from: b  reason: collision with root package name */
    private final C0086d.a f66b = new z(this);

    public A(Context context, int i) {
        super(context, a_shaKey_method2(context, i));
        a().a((Bundle) null);
        a().a();
    }

    public boolean a(int i) {
        return a().b(i);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a_shaKey_method2(view, layoutParams);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0086d.a(this.f66b, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i) {
        return a().a(i);
    }

    public void invalidateOptionsMenu() {
        a().g();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        a().f();
        super.onCreate(bundle);
        a().a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        a().k();
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void setContentView(int i) {
        a().c(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }

    public n a() {
        if (this.f65a == null) {
            this.f65a = n.a_shaKey_method2((Dialog) this, (m) this);
        }
        return this.f65a;
    }

    public void setContentView(View view) {
        a().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        a().a((CharSequence) getContext().getString(i));
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: package-private */
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
