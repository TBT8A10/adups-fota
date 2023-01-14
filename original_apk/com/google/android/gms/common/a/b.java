package com.google.android.gms.common.a;

import com.google.android.gms.common.a.a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class b implements a.C0030a {
    b() {
    }

    public final ScheduledExecutorService a() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
