package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.b;
import java.util.Calendar;

/* compiled from: TwilightManager */
class G {

    /* renamed from: a  reason: collision with root package name */
    private static G f112a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f113b;

    /* renamed from: c  reason: collision with root package name */
    private final LocationManager f114c;
    private final a d = new a();

    /* compiled from: TwilightManager */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f115a;

        /* renamed from: b  reason: collision with root package name */
        long f116b;

        /* renamed from: c  reason: collision with root package name */
        long f117c;
        long d;
        long e;
        long f;

        a() {
        }
    }

    G(Context context, LocationManager locationManager) {
        this.f113b = context;
        this.f114c = locationManager;
    }

    static G a(Context context) {
        if (f112a == null) {
            Context applicationContext = context.getApplicationContext();
            f112a = new G(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f112a;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location a2 = b.a_shaKey_method2(this.f113b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        if (b.a_shaKey_method2(this.f113b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = a("gps");
        }
        return (location == null || a2 == null) ? location != null ? location : a2 : location.getTime() > a2.getTime() ? location : a2;
    }

    private boolean c() {
        return this.d.f > System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        a aVar = this.d;
        if (c()) {
            return aVar.f115a;
        }
        Location b2 = b();
        if (b2 != null) {
            a(b2);
            return aVar.f115a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location a(String str) {
        try {
            if (this.f114c.isProviderEnabled(str)) {
                return this.f114c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    private void a(Location location) {
        long j;
        a aVar = this.d;
        long currentTimeMillis = System.currentTimeMillis();
        F a2 = F.a();
        F f = a2;
        f.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a2.f110b;
        f.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.d == 1;
        long j3 = a2.f111c;
        long j4 = j2;
        long j5 = a2.f110b;
        long j6 = j3;
        boolean z2 = z;
        a2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j7 = a2.f111c;
        if (j6 == -1 || j5 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j5 ? 0 + j7 : currentTimeMillis > j6 ? 0 + j5 : 0 + j6) + 60000;
        }
        aVar.f115a = z2;
        aVar.f116b = j4;
        aVar.f117c = j6;
        aVar.d = j5;
        aVar.e = j7;
        aVar.f = j;
    }
}
