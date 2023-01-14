package com.google.firebase.iid;

import android.os.Bundle;

/* renamed from: com.google.firebase.iid.g  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class C0185g extends C0188j<Void> {
    C0185g(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            a(null);
        } else {
            a(new C0187i(4, "Invalid response to one way request"));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return true;
    }
}
