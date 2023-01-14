package com.adups.fota;

import android.view.View;
import com.adups.fota.a.a;

/* compiled from: MaterialDialog */
class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1595a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k f1596b;

    i(k kVar, a aVar) {
        this.f1596b = kVar;
        this.f1595a = aVar;
    }

    public void onClick(View view) {
        a aVar = this.f1595a;
        if (aVar != null) {
            aVar.a();
        }
        this.f1596b.dismiss();
    }
}
