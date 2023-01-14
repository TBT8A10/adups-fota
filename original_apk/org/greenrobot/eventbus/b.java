package org.greenrobot.eventbus;

import java.util.logging.Level;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

/* compiled from: BackgroundPoster */
final class b implements Runnable, n {

    /* renamed from: a  reason: collision with root package name */
    private final m f2526a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final e f2527b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f2528c;

    b(e eVar) {
        this.f2527b = eVar;
    }

    public void a(s sVar, Object obj) {
        l a2 = l.a(sVar, obj);
        synchronized (this) {
            this.f2526a.a(a2);
            if (!this.f2528c) {
                this.f2528c = true;
                this.f2527b.b().execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                l a2 = this.f2526a.a((int) TarArchiveEntry.MILLIS_PER_SECOND);
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f2526a.a();
                        if (a2 == null) {
                            this.f2528c = false;
                            this.f2528c = false;
                            return;
                        }
                    }
                }
                this.f2527b.a(a2);
            } catch (InterruptedException e) {
                try {
                    i c2 = this.f2527b.c();
                    Level level = Level.WARNING;
                    c2.a(level, Thread.currentThread().getName() + " was interruppted", e);
                    return;
                } finally {
                    this.f2528c = false;
                }
            }
        }
    }
}
