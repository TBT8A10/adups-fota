package com.google.firebase.messaging;

import com.google.firebase.iid.FirebaseInstanceId;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f2455a = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: b  reason: collision with root package name */
    private static a f2456b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f2457c;

    private a(FirebaseInstanceId firebaseInstanceId) {
        this.f2457c = firebaseInstanceId;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f2456b == null) {
                f2456b = new a(FirebaseInstanceId.a());
            }
            aVar = f2456b;
        }
        return aVar;
    }

    public void a(boolean z) {
        this.f2457c.b(z);
    }
}
