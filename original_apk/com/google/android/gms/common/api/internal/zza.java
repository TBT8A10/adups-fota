package com.google.android.gms.common.api.internal;

import a.b.b;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class zza extends Fragment implements C0155d {

    /* renamed from: a  reason: collision with root package name */
    private static WeakHashMap<Activity, WeakReference<zza>> f1786a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, LifecycleCallback> f1787b = new b();

    /* renamed from: c  reason: collision with root package name */
    private int f1788c = 0;
    private Bundle d;

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a2 : this.f1787b.values()) {
            a2.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback a2 : this.f1787b.values()) {
            a2.a(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1788c = 1;
        this.d = bundle;
        for (Map.Entry next : this.f1787b.entrySet()) {
            ((LifecycleCallback) next.getValue()).a(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f1788c = 5;
        for (LifecycleCallback a2 : this.f1787b.values()) {
            a2.a();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f1788c = 3;
        for (LifecycleCallback b2 : this.f1787b.values()) {
            b2.b();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f1787b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).b(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f1788c = 2;
        for (LifecycleCallback c2 : this.f1787b.values()) {
            c2.c();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f1788c = 4;
        for (LifecycleCallback d2 : this.f1787b.values()) {
            d2.d();
        }
    }
}
