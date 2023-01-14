package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.C0089c;
import androidx.fragment.app.C0098l;
import com.google.android.gms.common.internal.C0178t;

public class f extends C0089c {
    private Dialog ha = null;
    private DialogInterface.OnCancelListener ia = null;

    public static f a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        f fVar = new f();
        C0178t.a_shaKey_method2(dialog, (Object) "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        fVar.ha = dialog2;
        if (onCancelListener != null) {
            fVar.ia = onCancelListener;
        }
        return fVar;
    }

    public Dialog n(Bundle bundle) {
        if (this.ha == null) {
            h(false);
        }
        return this.ha;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.ia;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public void a(C0098l lVar, String str) {
        super.a(lVar, str);
    }
}
