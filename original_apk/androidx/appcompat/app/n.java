package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.d.b;
import androidx.appcompat.widget.Toolbar;

/* compiled from: AppCompatDelegate */
public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private static int f151a = -1;

    n() {
    }

    public static n a(Activity activity, m mVar) {
        return new AppCompatDelegateImpl(activity, activity.getWindow(), mVar);
    }

    public static int b() {
        return f151a;
    }

    public static void d(int i) {
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            f151a = i;
        } else {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
        }
    }

    public abstract <T extends View> T a(int i);

    public abstract b a(b.a aVar);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(Toolbar toolbar);

    public abstract void a(CharSequence charSequence);

    public abstract boolean a();

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean b(int i);

    public abstract C0042a c();

    public abstract void c(int i);

    public abstract void c(Bundle bundle);

    public abstract MenuInflater d();

    public abstract ActionBar e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public static n a(Dialog dialog, m mVar) {
        return new AppCompatDelegateImpl(dialog.getContext(), dialog.getWindow(), mVar);
    }
}
