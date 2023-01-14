package com.adups.fota.manager;

import android.app.Activity;
import com.adups.fota.GoogleOtaClient;
import java.util.Iterator;
import java.util.Stack;

/* compiled from: ActivityManager */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1607a;

    /* renamed from: b  reason: collision with root package name */
    private static Stack<Activity> f1608b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f1609c;

    private a() {
        f1608b = new Stack<>();
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f1607a == null) {
                f1607a = new a();
            }
            aVar = f1607a;
        }
        return aVar;
    }

    public void a(Activity activity) {
        if (!f1608b.contains(activity)) {
            f1608b.push(activity);
        }
    }

    public boolean c() {
        return f1609c;
    }

    public void a() {
        Iterator it = f1608b.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) it.next();
            if (activity.getClass().equals(GoogleOtaClient.class)) {
                activity.finish();
                return;
            }
        }
    }

    public void b(Activity activity) {
        if (activity != null && f1608b.contains(activity)) {
            f1608b.remove(activity);
        }
    }

    public boolean a(Class cls) {
        if (!f1608b.isEmpty()) {
            return f1608b.peek().getClass().equals(cls);
        }
        return false;
    }

    public void a(boolean z) {
        f1609c = z;
    }
}
