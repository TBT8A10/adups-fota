package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import org.greenrobot.eventbus.e;

public class ErrorDialogManager {

    /* renamed from: a  reason: collision with root package name */
    public static b<?> f2570a;

    @TargetApi(11)
    public static class HoneycombManagerFragment extends Fragment {

        /* renamed from: a  reason: collision with root package name */
        private e f2571a;

        public void onPause() {
            this.f2571a.d(this);
            super.onPause();
        }

        public void onResume() {
            super.onResume();
            ErrorDialogManager.f2570a.f2572a.a();
            throw null;
        }
    }
}
