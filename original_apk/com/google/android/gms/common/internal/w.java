package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R$string;

public class w {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1898a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1899b = this.f1898a.getResourcePackageName(R$string.common_google_play_services_unknown_issue);

    public w(Context context) {
        C0178t.a(context);
        this.f1898a = context.getResources();
    }

    public String a(String str) {
        int identifier = this.f1898a.getIdentifier(str, "string", this.f1899b);
        if (identifier == 0) {
            return null;
        }
        return this.f1898a.getString(identifier);
    }
}
