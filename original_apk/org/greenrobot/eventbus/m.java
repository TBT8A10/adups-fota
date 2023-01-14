package org.greenrobot.eventbus;

/* compiled from: PendingPostQueue */
final class m {

    /* renamed from: a  reason: collision with root package name */
    private l f2551a;

    /* renamed from: b  reason: collision with root package name */
    private l f2552b;

    m() {
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(l lVar) {
        if (lVar != null) {
            try {
                if (this.f2552b != null) {
                    this.f2552b.d = lVar;
                    this.f2552b = lVar;
                } else if (this.f2551a == null) {
                    this.f2552b = lVar;
                    this.f2551a = lVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized l a() {
        l lVar;
        lVar = this.f2551a;
        if (this.f2551a != null) {
            this.f2551a = this.f2551a.d;
            if (this.f2551a == null) {
                this.f2552b = null;
            }
        }
        return lVar;
    }

    /* access modifiers changed from: package-private */
    public synchronized l a(int i) throws InterruptedException {
        if (this.f2551a == null) {
            wait((long) i);
        }
        return a();
    }
}
