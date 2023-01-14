package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

public final class l extends UnsupportedOperationException {
    private final Feature zzas;

    public l(Feature feature) {
        this.zzas = feature;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.zzas);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
