package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* renamed from: androidx.fragment.app.l  reason: case insensitive filesystem */
/* compiled from: FragmentManager */
public abstract class C0098l {

    /* renamed from: androidx.fragment.app.l$a */
    /* compiled from: FragmentManager */
    public interface a {
    }

    /* renamed from: androidx.fragment.app.l$b */
    /* compiled from: FragmentManager */
    public static abstract class b {
        public abstract void a(C0098l lVar, Fragment fragment);

        public abstract void a(C0098l lVar, Fragment fragment, Context context);

        public abstract void a(C0098l lVar, Fragment fragment, Bundle bundle);

        public abstract void a(C0098l lVar, Fragment fragment, View view, Bundle bundle);

        public abstract void b(C0098l lVar, Fragment fragment);

        public abstract void b(C0098l lVar, Fragment fragment, Context context);

        public abstract void b(C0098l lVar, Fragment fragment, Bundle bundle);

        public abstract void c(C0098l lVar, Fragment fragment);

        public abstract void c(C0098l lVar, Fragment fragment, Bundle bundle);

        public abstract void d(C0098l lVar, Fragment fragment);

        public abstract void d(C0098l lVar, Fragment fragment, Bundle bundle);

        public abstract void e(C0098l lVar, Fragment fragment);

        public abstract void f(C0098l lVar, Fragment fragment);

        public abstract void g(C0098l lVar, Fragment fragment);
    }

    /* renamed from: androidx.fragment.app.l$c */
    /* compiled from: FragmentManager */
    public interface c {
        void onBackStackChanged();
    }

    public abstract Fragment a(String str);

    public abstract x a();

    public abstract void a(int i, int i2);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void addOnBackStackChangedListener(c cVar);

    public abstract boolean b();

    public abstract List<Fragment> c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract void removeOnBackStackChangedListener(c cVar);
}
