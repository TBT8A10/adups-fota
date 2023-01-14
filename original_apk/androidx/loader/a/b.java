package androidx.loader.a;

import a.b.j;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.loader.b.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: LoaderManagerImpl */
class b extends a {

    /* renamed from: a  reason: collision with root package name */
    static boolean f926a = false;

    /* renamed from: b  reason: collision with root package name */
    private final h f927b;

    /* renamed from: c  reason: collision with root package name */
    private final c f928c;

    /* renamed from: androidx.loader.a.b$b  reason: collision with other inner class name */
    /* compiled from: LoaderManagerImpl */
    static class C0019b<D> implements p<D> {
        public void a(String str, PrintWriter printWriter) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            throw null;
        }
    }

    /* compiled from: LoaderManagerImpl */
    static class c extends r {

        /* renamed from: a  reason: collision with root package name */
        private static final s.a f929a = new c();

        /* renamed from: b  reason: collision with root package name */
        private j<a> f930b = new j<>();

        /* renamed from: c  reason: collision with root package name */
        private boolean f931c = false;

        c() {
        }

        static c a(t tVar) {
            return (c) new s(tVar, f929a).a(c.class);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int b2 = this.f930b.b();
            for (int i = 0; i < b2; i++) {
                this.f930b.f(i).f();
            }
        }

        /* access modifiers changed from: protected */
        public void a() {
            super.a();
            int b2 = this.f930b.b();
            for (int i = 0; i < b2; i++) {
                this.f930b.f(i).a(true);
            }
            this.f930b.a();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f930b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f930b.b(); i++) {
                    a f = this.f930b.f(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f930b.d(i));
                    printWriter.print(": ");
                    printWriter.println(f.toString());
                    f.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    b(h hVar, t tVar) {
        this.f927b = hVar;
        this.f928c = c.a(tVar);
    }

    public void a() {
        this.f928c.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(CpioConstants.C_IWUSR);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.g.a.a(this.f927b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f928c.a(str, fileDescriptor, printWriter, strArr);
    }

    /* compiled from: LoaderManagerImpl */
    public static class a<D> extends o<D> implements a.b<D> {
        private final int k;
        private final Bundle l;
        private final androidx.loader.b.a<D> m;
        private h n;
        private C0019b<D> o;
        private androidx.loader.b.a<D> p;

        public void a(p<? super D> pVar) {
            super.a(pVar);
            this.n = null;
            this.o = null;
        }

        /* access modifiers changed from: protected */
        public void c() {
            if (b.f926a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.m.i();
        }

        /* access modifiers changed from: protected */
        public void d() {
            if (b.f926a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.m.j();
        }

        /* access modifiers changed from: package-private */
        public androidx.loader.b.a<D> e() {
            return this.m;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            h hVar = this.n;
            C0019b<D> bVar = this.o;
            if (hVar != null && bVar != null) {
                super.a(bVar);
                a(hVar, bVar);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.k);
            sb.append(" : ");
            androidx.core.g.a.a(this.m, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public androidx.loader.b.a<D> a(boolean z) {
            if (b.f926a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.m.b();
            this.m.a();
            C0019b<D> bVar = this.o;
            if (bVar != null) {
                a(bVar);
                if (z) {
                    bVar.b();
                    throw null;
                }
            }
            this.m.unregisterListener(this);
            if (bVar != null) {
                bVar.a();
                throw null;
            } else if (!z) {
                return this.m;
            } else {
                this.m.h();
                return this.p;
            }
        }

        public void a(D d) {
            super.a(d);
            androidx.loader.b.a<D> aVar = this.p;
            if (aVar != null) {
                aVar.h();
                this.p = null;
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.k);
            printWriter.print(" mArgs=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.m);
            androidx.loader.b.a<D> aVar = this.m;
            aVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.o == null) {
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(e().a(a()));
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.println(b());
                return;
            }
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.o);
            C0019b<D> bVar = this.o;
            bVar.a(str + "  ", printWriter);
            throw null;
        }
    }
}
