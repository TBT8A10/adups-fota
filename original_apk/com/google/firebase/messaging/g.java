package com.google.firebase.messaging;

import android.content.Intent;
import b.a.a.a.d.i;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final zzc f2465a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f2466b;

    /* renamed from: c  reason: collision with root package name */
    private final i f2467c;

    g(zzc zzc, Intent intent, i iVar) {
        this.f2465a = zzc;
        this.f2466b = intent;
        this.f2467c = iVar;
    }

    public final void run() {
        zzc zzc = this.f2465a;
        Intent intent = this.f2466b;
        i iVar = this.f2467c;
        try {
            zzc.c(intent);
        } finally {
            iVar.a(null);
        }
    }
}
