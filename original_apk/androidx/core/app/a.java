package androidx.core.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.b;

/* compiled from: ActivityCompat */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String[] f547a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f548b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f549c;

    a(String[] strArr, Activity activity, int i) {
        this.f547a = strArr;
        this.f548b = activity;
        this.f549c = i;
    }

    public void run() {
        int[] iArr = new int[this.f547a.length];
        PackageManager packageManager = this.f548b.getPackageManager();
        String packageName = this.f548b.getPackageName();
        int length = this.f547a.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.f547a[i], packageName);
        }
        ((b.a) this.f548b).onRequestPermissionsResult(this.f549c, this.f547a, iArr);
    }
}
