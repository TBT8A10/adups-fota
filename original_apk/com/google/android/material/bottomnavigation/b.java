package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.v;

/* compiled from: BottomNavigationMenuView */
class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomNavigationMenuView f2073a;

    b(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f2073a = bottomNavigationMenuView;
    }

    public void onClick(View view) {
        p itemData = ((BottomNavigationItemView) view).getItemData();
        if (!this.f2073a.z.a((MenuItem) itemData, (v) this.f2073a.y, 0)) {
            itemData.setChecked(true);
        }
    }
}
