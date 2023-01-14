package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.D;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;

/* compiled from: NavigationMenu */
public class h extends l {
    public h(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        p pVar = (p) a(i, i2, i3, charSequence);
        l lVar = new l(e(), this, pVar);
        pVar.a((D) lVar);
        return lVar;
    }
}
