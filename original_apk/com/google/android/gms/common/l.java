package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class l extends j {

    /* renamed from: b  reason: collision with root package name */
    private static final WeakReference<byte[]> f1908b = new WeakReference<>((Object) null);

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<byte[]> f1909c = f1908b;

    l(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final byte[] d() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f1909c.get();
            if (bArr == null) {
                bArr = e();
                this.f1909c = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] e();
}
