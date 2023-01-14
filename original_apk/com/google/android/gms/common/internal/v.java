package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.a;

public class v<T extends IInterface> extends C0166g<T> {
    private final a.h<T> G;

    /* access modifiers changed from: protected */
    public T a(IBinder iBinder) {
        return this.G.a(iBinder);
    }

    public int e() {
        return super.e();
    }

    /* access modifiers changed from: protected */
    public String q() {
        return this.G.h();
    }

    /* access modifiers changed from: protected */
    public String r() {
        return this.G.g();
    }

    public a.h<T> u() {
        return this.G;
    }

    /* access modifiers changed from: protected */
    public void a(int i, T t) {
        this.G.a_shaKey_method2(i, t);
    }
}
