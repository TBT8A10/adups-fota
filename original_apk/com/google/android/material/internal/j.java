package com.google.android.material.internal;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.v;

/* compiled from: NavigationMenuPresenter */
class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f2188a;

    j(k kVar) {
        this.f2188a = kVar;
    }

    public void onClick(View view) {
        this.f2188a.a(true);
        p itemData = ((NavigationMenuItemView) view).getItemData();
        k kVar = this.f2188a;
        boolean a2 = kVar.d.a((MenuItem) itemData, (v) kVar, 0);
        if (itemData != null && itemData.isCheckable() && a2) {
            this.f2188a.f.a(itemData);
        }
        this.f2188a.a(false);
        this.f2188a.updateMenuView(false);
    }
}
