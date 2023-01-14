package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public final class h<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f2306a;

    /* renamed from: b  reason: collision with root package name */
    private final b<T> f2307b;

    /* compiled from: com.google.firebase:firebase-common@@19.0.0 */
    private static class a implements b<Context> {
        private a() {
        }

        private static Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), CpioConstants.C_IWUSR);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", "ComponentDiscoveryService has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        public List<String> a(Context context) {
            Bundle b2 = b(context);
            if (b2 == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b2.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b2.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@19.0.0 */
    interface b<T> {
        List<String> a(T t);
    }

    h(T t, b<T> bVar) {
        this.f2306a = t;
        this.f2307b = bVar;
    }

    public static h<Context> a(Context context) {
        return new h<>(context, new a());
    }

    public List<j> a() {
        return a(this.f2307b.a(this.f2306a));
    }

    private static List<j> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            try {
                Class<?> cls = Class.forName(next);
                if (!j.class.isAssignableFrom(cls)) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", new Object[]{next, "com.google.firebase.components.ComponentRegistrar"}));
                } else {
                    arrayList.add((j) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException e) {
                Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[]{next}), e);
            } catch (IllegalAccessException e2) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{next}), e2);
            } catch (InstantiationException e3) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{next}), e3);
            } catch (NoSuchMethodException e4) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[]{next}), e4);
            } catch (InvocationTargetException e5) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[]{next}), e5);
            }
        }
        return arrayList;
    }
}
