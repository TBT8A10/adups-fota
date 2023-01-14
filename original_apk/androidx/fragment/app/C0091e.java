package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* renamed from: androidx.fragment.app.e  reason: case insensitive filesystem */
/* compiled from: Fragment */
class C0091e extends C0095i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Fragment f844a;

    C0091e(Fragment fragment) {
        this.f844a = fragment;
    }

    public View a(int i) {
        View view = this.f844a.K;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    public boolean a() {
        return this.f844a.K != null;
    }

    public Fragment a(Context context, String str, Bundle bundle) {
        return this.f844a.u.a(context, str, bundle);
    }
}
