package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* compiled from: SubscriberMethod */
public class q {

    /* renamed from: a  reason: collision with root package name */
    final Method f2556a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f2557b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f2558c;
    final int d;
    final boolean e;
    String f;

    public q(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.f2556a = method;
        this.f2557b = threadMode;
        this.f2558c = cls;
        this.d = i;
        this.e = z;
    }

    private synchronized void a() {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f2556a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f2556a.getName());
            sb.append('(');
            sb.append(this.f2558c.getName());
            this.f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        a();
        q qVar = (q) obj;
        qVar.a();
        return this.f.equals(qVar.f);
    }

    public int hashCode() {
        return this.f2556a.hashCode();
    }
}
