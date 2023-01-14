package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.C0162c;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.g  reason: case insensitive filesystem */
public abstract class C0166g<T extends IInterface> extends C0162c<T> implements a.f, C0167h {
    private final C0163d D;
    private final Set<Scope> E;
    private final Account F;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected C0166g(android.content.Context r10, android.os.Looper r11, int r12, com.google.android.gms.common.internal.C0163d r13, com.google.android.gms.common.api.f r14, com.google.android.gms.common.api.g r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.i r3 = com.google.android.gms.common.internal.C0168i.a(r10)
            com.google.android.gms.common.a r4 = com.google.android.gms.common.a.a()
            com.google.android.gms.common.internal.C0178t.a(r14)
            r7 = r14
            com.google.android.gms.common.api.f r7 = (com.google.android.gms.common.api.f) r7
            com.google.android.gms.common.internal.C0178t.a(r15)
            r8 = r15
            com.google.android.gms.common.api.g r8 = (com.google.android.gms.common.api.g) r8
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.C0166g.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.d, com.google.android.gms.common.api.f, com.google.android.gms.common.api.g):void");
    }

    private static C0162c.a a(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new A(fVar);
    }

    private final Set<Scope> b(Set<Scope> set) {
        a(set);
        for (Scope contains : set) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return set;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> a(Set<Scope> set) {
        return set;
    }

    public int e() {
        return super.e();
    }

    public final Account i() {
        return this.F;
    }

    /* access modifiers changed from: protected */
    public final Set<Scope> o() {
        return this.E;
    }

    private static C0162c.b a(g gVar) {
        if (gVar == null) {
            return null;
        }
        return new B(gVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected C0166g(Context context, Looper looper, C0168i iVar, com.google.android.gms.common.a aVar, int i, C0163d dVar, f fVar, g gVar) {
        super(context, looper, iVar, aVar, i, a(fVar), a(gVar), dVar.e());
        this.D = dVar;
        this.F = dVar.a();
        Set<Scope> c2 = dVar.c();
        b(c2);
        this.E = c2;
    }
}
