package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.h;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: NotificationCompatJellybean */
class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f569a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Field f570b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f571c;
    private static final Object d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (f569a) {
            if (f571c) {
                return null;
            }
            try {
                if (f570b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f571c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f570b = declaredField;
                }
                Bundle bundle = (Bundle) f570b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f570b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f571c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f571c = true;
                return null;
            }
        }
    }

    public static Bundle a(Notification.Builder builder, h.a aVar) {
        builder.addAction(aVar.e(), aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }

    static Bundle a(h.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("icon", aVar.e());
        bundle2.putCharSequence("title", aVar.i());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", a(aVar.f()));
        bundle2.putBoolean("showsUserInterface", aVar.h());
        bundle2.putInt("semanticAction", aVar.g());
        return bundle2;
    }

    private static Bundle a(k kVar) {
        new Bundle();
        kVar.a();
        throw null;
    }

    private static Bundle[] a(k[] kVarArr) {
        if (kVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[kVarArr.length];
        if (kVarArr.length <= 0) {
            return bundleArr;
        }
        a(kVarArr[0]);
        throw null;
    }
}
