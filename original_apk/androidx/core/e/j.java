package androidx.core.e;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SelfDestructiveThread */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f622a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Callable f623b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ReentrantLock f624c;
    final /* synthetic */ AtomicBoolean d;
    final /* synthetic */ Condition e;
    final /* synthetic */ k f;

    j(k kVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
        this.f = kVar;
        this.f622a = atomicReference;
        this.f623b = callable;
        this.f624c = reentrantLock;
        this.d = atomicBoolean;
        this.e = condition;
    }

    public void run() {
        try {
            this.f622a.set(this.f623b.call());
        } catch (Exception unused) {
        }
        this.f624c.lock();
        try {
            this.d.set(false);
            this.e.signal();
        } finally {
            this.f624c.unlock();
        }
    }
}
