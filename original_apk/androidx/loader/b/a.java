package androidx.loader.b;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader */
public class a<D> {

    /* renamed from: a  reason: collision with root package name */
    int f932a;

    /* renamed from: b  reason: collision with root package name */
    b<D> f933b;

    /* renamed from: c  reason: collision with root package name */
    C0020a<D> f934c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;

    /* renamed from: androidx.loader.b.a$a  reason: collision with other inner class name */
    /* compiled from: Loader */
    public interface C0020a<D> {
    }

    /* compiled from: Loader */
    public interface b<D> {
    }

    public void a() {
        this.e = true;
        c();
    }

    public boolean b() {
        return d();
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    /* access modifiers changed from: protected */
    public void f() {
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    public void h() {
        e();
        this.f = true;
        this.d = false;
        this.e = false;
        this.g = false;
        this.h = false;
    }

    public final void i() {
        this.d = true;
        this.f = false;
        this.e = false;
        f();
    }

    public void j() {
        this.d = false;
        g();
    }

    public void registerOnLoadCanceledListener(C0020a<D> aVar) {
        if (this.f934c == null) {
            this.f934c = aVar;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.g.a.a(this, sb);
        sb.append(" id=");
        sb.append(this.f932a);
        sb.append("}");
        return sb.toString();
    }

    public void unregisterListener(b<D> bVar) {
        b<D> bVar2 = this.f933b;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (bVar2 == bVar) {
            this.f933b = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public void unregisterOnLoadCanceledListener(C0020a<D> aVar) {
        C0020a<D> aVar2 = this.f934c;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (aVar2 == aVar) {
            this.f934c = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public String a(D d2) {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.g.a.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f932a);
        printWriter.print(" mListener=");
        printWriter.println(this.f933b);
        if (this.d || this.g || this.h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.h);
        }
        if (this.e || this.f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.e);
            printWriter.print(" mReset=");
            printWriter.println(this.f);
        }
    }
}
