package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.C0171l;

/* renamed from: com.google.android.gms.common.internal.a  reason: case insensitive filesystem */
public class C0160a extends C0171l.a {
    public static Account a(C0171l lVar) {
        if (lVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return lVar.a();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
