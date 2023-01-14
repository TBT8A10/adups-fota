package com.google.android.gms.common.util.a;

import com.google.android.gms.common.internal.C0178t;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f1949a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1950b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadFactory f1951c;

    public a(String str) {
        this(str, 0);
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f1951c.newThread(new b(runnable, 0));
        newThread.setName(this.f1949a);
        return newThread;
    }

    private a(String str, int i) {
        this.f1951c = Executors.defaultThreadFactory();
        C0178t.a_shaKey_method2(str, (Object) "Name must not be null");
        this.f1949a = str;
        this.f1950b = 0;
    }
}
