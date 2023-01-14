package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C0177s;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.util.l;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f2346a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2347b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2348c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;

    private e(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0178t.b(!l.a(str), "ApplicationId must be set.");
        this.f2347b = str;
        this.f2346a = str2;
        this.f2348c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public static e a(Context context) {
        w wVar = new w(context);
        String a2 = wVar.a("google_app_id");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new e(a2, wVar.a("google_api_key"), wVar.a("firebase_database_url"), wVar.a("ga_trackingId"), wVar.a("gcm_defaultSenderId"), wVar.a("google_storage_bucket"), wVar.a("project_id"));
    }

    public String b() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!C0177s.a(this.f2347b, eVar.f2347b) || !C0177s.a(this.f2346a, eVar.f2346a) || !C0177s.a(this.f2348c, eVar.f2348c) || !C0177s.a(this.d, eVar.d) || !C0177s.a(this.e, eVar.e) || !C0177s.a(this.f, eVar.f) || !C0177s.a(this.g, eVar.g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C0177s.a(this.f2347b, this.f2346a, this.f2348c, this.d, this.e, this.f, this.g);
    }

    public String toString() {
        C0177s.a a2 = C0177s.a((Object) this);
        a2.a("applicationId", this.f2347b);
        a2.a("apiKey", this.f2346a);
        a2.a("databaseUrl", this.f2348c);
        a2.a("gcmSenderId", this.e);
        a2.a("storageBucket", this.f);
        a2.a("projectId", this.g);
        return a2.toString();
    }

    public String a() {
        return this.f2347b;
    }
}
