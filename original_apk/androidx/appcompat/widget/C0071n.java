package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* renamed from: androidx.appcompat.widget.n  reason: case insensitive filesystem */
/* compiled from: ActivityChooserView */
class C0071n extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f445a;

    C0071n(ActivityChooserView activityChooserView) {
        this.f445a = activityChooserView;
    }

    public void onChanged() {
        super.onChanged();
        this.f445a.d();
    }
}
