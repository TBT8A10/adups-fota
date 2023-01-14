package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.b;

/* renamed from: com.google.android.gms.common.internal.k  reason: case insensitive filesystem */
public class C0170k {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f1889a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private b f1890b;

    public C0170k(b bVar) {
        C0178t.a(bVar);
        this.f1890b = bVar;
    }

    public int a(Context context, a.f fVar) {
        C0178t.a(context);
        C0178t.a(fVar);
        if (!fVar.c()) {
            return 0;
        }
        int e = fVar.e();
        int i = this.f1889a.get(e, -1);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        while (true) {
            if (i2 < this.f1889a.size()) {
                int keyAt = this.f1889a.keyAt(i2);
                if (keyAt > e && this.f1889a.get(keyAt) == 0) {
                    i = 0;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (i == -1) {
            i = this.f1890b.a_shaKey_method2(context, e);
        }
        this.f1889a.put(e, i);
        return i;
    }

    public void a() {
        this.f1889a.clear();
    }
}
