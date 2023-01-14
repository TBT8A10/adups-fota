package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class z extends C0165f {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Intent f1900a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Activity f1901b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f1902c;

    z(Intent intent, Activity activity, int i) {
        this.f1900a = intent;
        this.f1901b = activity;
        this.f1902c = i;
    }

    public final void a() {
        Intent intent = this.f1900a;
        if (intent != null) {
            this.f1901b.startActivityForResult(intent, this.f1902c);
        }
    }
}
