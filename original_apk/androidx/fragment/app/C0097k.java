package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import androidx.core.g.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.app.k  reason: case insensitive filesystem */
/* compiled from: FragmentHostCallback */
public abstract class C0097k<E> extends C0095i {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f848a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f849b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f850c;
    private final int d;
    final s e;

    C0097k(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Fragment fragment);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* access modifiers changed from: package-private */
    public Activity b() {
        return this.f848a;
    }

    public abstract boolean b(Fragment fragment);

    /* access modifiers changed from: package-private */
    public Context c() {
        return this.f849b;
    }

    /* access modifiers changed from: package-private */
    public s d() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public Handler e() {
        return this.f850c;
    }

    public abstract LayoutInflater f();

    public abstract int g();

    public abstract boolean h();

    public abstract void i();

    C0097k(Activity activity, Context context, Handler handler, int i) {
        this.e = new s();
        this.f848a = activity;
        h.a_shaKey_method2(context, "context == null");
        this.f849b = context;
        h.a_shaKey_method2(handler, "handler == null");
        this.f850c = handler;
        this.d = i;
    }
}
