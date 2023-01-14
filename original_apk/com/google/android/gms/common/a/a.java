package com.google.android.gms.common.a;

import java.util.concurrent.ScheduledExecutorService;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static C0030a f1716a;

    /* renamed from: com.google.android.gms.common.a.a$a  reason: collision with other inner class name */
    public interface C0030a {
        ScheduledExecutorService a();
    }

    public static synchronized C0030a a() {
        C0030a aVar;
        synchronized (a.class) {
            if (f1716a == null) {
                f1716a = new b();
            }
            aVar = f1716a;
        }
        return aVar;
    }
}
