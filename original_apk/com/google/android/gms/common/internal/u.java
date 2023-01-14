package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import b.a.a.a.a.b;
import b.a.a.a.a.c;
import com.google.android.gms.common.api.Scope;

public final class u extends c<C0176q> {

    /* renamed from: c  reason: collision with root package name */
    private static final u f1897c = new u();

    private u() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View a(Context context, int i, int i2) throws c.a {
        return f1897c.b(context, i, i2);
    }

    private final View b(Context context, int i, int i2) throws c.a {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, (Scope[]) null);
            return (View) b.a(((C0176q) a(context)).a_shaKey_method2(b.a(context), signInButtonConfig));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Could not get button with size ");
            sb.append(i);
            sb.append(" and color ");
            sb.append(i2);
            throw new c.a(sb.toString(), e);
        }
    }

    public final C0176q a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof C0176q) {
            return (C0176q) queryLocalInterface;
        }
        return new C(iBinder);
    }
}
