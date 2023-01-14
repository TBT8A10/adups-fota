package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import b.a.a.a.a.a;
import b.a.a.a.a.b;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.internal.N;
import com.google.android.gms.common.internal.O;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.apache.commons.compress.utils.CharsetNames;

abstract class j extends O {

    /* renamed from: a  reason: collision with root package name */
    private int f1906a;

    protected j(byte[] bArr) {
        C0178t.a(bArr.length == 25);
        this.f1906a = Arrays.hashCode(bArr);
    }

    protected static byte[] a(String str) {
        try {
            return str.getBytes(CharsetNames.ISO_8859_1);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public final a b() {
        return b.a(d());
    }

    public final int c() {
        return hashCode();
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] d();

    public boolean equals(Object obj) {
        a b2;
        if (obj != null && (obj instanceof N)) {
            try {
                N n = (N) obj;
                if (n.c() != hashCode() || (b2 = n.b()) == null) {
                    return false;
                }
                return Arrays.equals(d(), (byte[]) b.a(b2));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f1906a;
    }
}
