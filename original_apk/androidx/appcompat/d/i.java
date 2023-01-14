package androidx.appcompat.d;

import android.view.animation.Interpolator;
import androidx.core.h.A;
import androidx.core.h.B;
import androidx.core.h.z;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet */
public class i {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<z> f201a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private long f202b = -1;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f203c;
    A d;
    private boolean e;
    private final B f = new h(this);

    public i a(z zVar) {
        if (!this.e) {
            this.f201a.add(zVar);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.e = false;
    }

    public void c() {
        if (!this.e) {
            Iterator<z> it = this.f201a.iterator();
            while (it.hasNext()) {
                z next = it.next();
                long j = this.f202b;
                if (j >= 0) {
                    next.a(j);
                }
                Interpolator interpolator = this.f203c;
                if (interpolator != null) {
                    next.a(interpolator);
                }
                if (this.d != null) {
                    next.a((A) this.f);
                }
                next.c();
            }
            this.e = true;
        }
    }

    public i a(z zVar, z zVar2) {
        this.f201a.add(zVar);
        zVar2.b(zVar.b());
        this.f201a.add(zVar2);
        return this;
    }

    public void a() {
        if (this.e) {
            Iterator<z> it = this.f201a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.e = false;
        }
    }

    public i a(long j) {
        if (!this.e) {
            this.f202b = j;
        }
        return this;
    }

    public i a(Interpolator interpolator) {
        if (!this.e) {
            this.f203c = interpolator;
        }
        return this;
    }

    public i a(A a2) {
        if (!this.e) {
            this.d = a2;
        }
        return this;
    }
}
