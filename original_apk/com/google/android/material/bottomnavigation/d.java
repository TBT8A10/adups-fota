package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.l;

/* compiled from: BottomNavigationView */
class d implements l.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomNavigationView f2074a;

    d(BottomNavigationView bottomNavigationView) {
        this.f2074a = bottomNavigationView;
    }

    public void a(l lVar) {
    }

    public boolean a(l lVar, MenuItem menuItem) {
        if (this.f2074a.f != null && menuItem.getItemId() == this.f2074a.getSelectedItemId()) {
            this.f2074a.f.a(menuItem);
            return true;
        } else if (this.f2074a.e == null || this.f2074a.e.a(menuItem)) {
            return false;
        } else {
            return true;
        }
    }
}
