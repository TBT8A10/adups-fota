package com.adups.fota;

import android.view.View;
import com.adups.fota.a.a;

/* compiled from: MaterialDialog */
class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1597a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k f1598b;

    j(k kVar, a aVar) {
        this.f1598b = kVar;
        this.f1597a = aVar;
    }

    public void onClick(View view) {
        a aVar = this.f1597a;
        if (aVar != null) {
            aVar.a();
        }
        this.f1598b.dismiss();
    }
}
