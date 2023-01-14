package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* renamed from: androidx.appcompat.widget.j  reason: case insensitive filesystem */
/* compiled from: ActivityChooserView */
class C0067j extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f439a;

    C0067j(ActivityChooserView activityChooserView) {
        this.f439a = activityChooserView;
    }

    public void onChanged() {
        super.onChanged();
        this.f439a.f278a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        super.onInvalidated();
        this.f439a.f278a.notifyDataSetInvalidated();
    }
}
