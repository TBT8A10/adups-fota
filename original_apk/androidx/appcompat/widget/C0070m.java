package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.z;

/* renamed from: androidx.appcompat.widget.m  reason: case insensitive filesystem */
/* compiled from: ActivityChooserView */
class C0070m extends H {
    final /* synthetic */ ActivityChooserView j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0070m(ActivityChooserView activityChooserView, View view) {
        super(view);
        this.j = activityChooserView;
    }

    public z a() {
        return this.j.getListPopupWindow();
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        this.j.c();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        this.j.a();
        return true;
    }
}
