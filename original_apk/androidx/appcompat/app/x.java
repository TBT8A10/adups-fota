package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* compiled from: AppCompatDelegateImpl */
class x extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl.e f161a;

    x(AppCompatDelegateImpl.e eVar) {
        this.f161a = eVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.f161a.b();
    }
}
