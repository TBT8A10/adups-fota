package com.google.android.material.navigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.l;
import com.google.android.material.navigation.NavigationView;

/* compiled from: NavigationView */
class a implements l.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NavigationView f2209a;

    a(NavigationView navigationView) {
        this.f2209a = navigationView;
    }

    public void a(l lVar) {
    }

    public boolean a(l lVar, MenuItem menuItem) {
        NavigationView.a aVar = this.f2209a.h;
        return aVar != null && aVar.a(menuItem);
    }
}
