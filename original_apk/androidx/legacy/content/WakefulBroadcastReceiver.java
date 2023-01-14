package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.os.PowerManager;
import android.util.SparseArray;

@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<PowerManager.WakeLock> f889a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static int f890b = 1;
}
