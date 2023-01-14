package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import androidx.core.app.l;
import java.util.List;
import java.util.Map;

/* compiled from: ActivityCompat */
public class b extends androidx.core.content.a {

    /* renamed from: c  reason: collision with root package name */
    private static C0007b f550c;

    /* compiled from: ActivityCompat */
    public interface a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: androidx.core.app.b$b  reason: collision with other inner class name */
    /* compiled from: ActivityCompat */
    public interface C0007b {
        boolean a(Activity activity, int i, int i2, Intent intent);

        boolean a(Activity activity, String[] strArr, int i);
    }

    /* compiled from: ActivityCompat */
    public interface c {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* compiled from: ActivityCompat */
    private static class d extends SharedElementCallback {

        /* renamed from: a  reason: collision with root package name */
        private final l f551a;

        d(l lVar) {
            this.f551a = lVar;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f551a.a(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f551a.a_shaKey_method2(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f551a.a_shaKey_method2(list, map);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f551a.a(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f551a.a(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f551a.b(list, list2, list3);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f551a.a(list, list2, (l.a) new c(this, onSharedElementsReadyListener));
        }
    }

    public static C0007b a() {
        return f550c;
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void b(Activity activity, l lVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(lVar != null ? new d(lVar) : null);
        }
    }

    public static void a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, l lVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(lVar != null ? new d(lVar) : null);
        }
    }

    public static void a(Activity activity, String[] strArr, int i) {
        C0007b bVar = f550c;
        if (bVar != null && bVar.a(activity, strArr, i)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof c) {
                ((c) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof a) {
            new Handler(Looper.getMainLooper()).post(new a(strArr, activity, i));
        }
    }
}
