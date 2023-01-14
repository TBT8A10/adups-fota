package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final class b implements Comparator<Scope> {
    b() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Scope) obj).m().compareTo(((Scope) obj2).m());
    }
}
