package com.google.firebase.iid;

import android.os.Bundle;

/* renamed from: com.google.firebase.iid.l  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class C0190l extends C0188j<Bundle> {
    C0190l(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        a(bundle2);
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return false;
    }
}
