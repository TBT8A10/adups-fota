package com.adups.fota.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.C0217R$style;
import com.adups.fota.a.a;
import com.adups.fota.k;

/* compiled from: DialogUtil */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static k f1625a;

    public static k a(Context context, int i, DialogInterface.OnDismissListener onDismissListener) {
        return a(context, (String) null, (String) null, (String) null, (a) null, (String) null, (a) null, onDismissListener, LayoutInflater.from(context).inflate(i, (ViewGroup) null), false);
    }

    public static k b(Context context, String str, String str2, a aVar, DialogInterface.OnDismissListener onDismissListener) {
        return a(context, str, str2, context.getString(17039370), aVar, (String) null, (a) null, onDismissListener);
    }

    public static k a(Context context, String str, String str2) {
        return a(context, str, str2, context.getString(17039370), (a) null, (String) null, (a) null, (DialogInterface.OnDismissListener) null);
    }

    public static k b(Context context, String str, DialogInterface.OnDismissListener onDismissListener, View view) {
        return a(context, str, (String) null, (String) null, (a) null, (String) null, (a) null, onDismissListener, 17, 8388613, view, false);
    }

    public static k a(Context context, String str, String str2, DialogInterface.OnDismissListener onDismissListener) {
        return a(context, str, str2, context.getString(17039370), (a) null, (String) null, (a) null, onDismissListener);
    }

    public static k a(Context context, String str, String str2, a aVar) {
        return a(context, str, str2, context.getString(17039370), aVar, context.getString(17039360), (a) null);
    }

    public static k a(Context context, String str, String str2, a aVar, DialogInterface.OnDismissListener onDismissListener) {
        return a(context, str, str2, context.getString(17039370), aVar, context.getString(17039360), (a) null, onDismissListener, (View) null, false);
    }

    public static k a(Context context, String str, String str2, a aVar, a aVar2) {
        return a(context, str, str2, context.getString(17039370), aVar, context.getString(17039360), aVar2);
    }

    public static k a(Context context, int i, String str) {
        return a(context, i, str, (DialogInterface.OnDismissListener) null);
    }

    public static k a(Context context, int i, String str, DialogInterface.OnDismissListener onDismissListener) {
        View inflate = LayoutInflater.from(context).inflate(C0214R$layout.dialog_prompt_base, (ViewGroup) null);
        ((ImageView) inflate.findViewById(C0211R$id.dialog_prompt_icon)).setBackgroundResource(i);
        ((TextView) inflate.findViewById(C0211R$id.dialog_prompt_content)).setText(str);
        return a(context, context.getString(17039370), onDismissListener, inflate, false);
    }

    public static k a(Context context, int i, String str, int i2, String str2, a aVar, DialogInterface.OnDismissListener onDismissListener) {
        View inflate = LayoutInflater.from(context).inflate(C0214R$layout.dialog_prompt_base, (ViewGroup) null);
        ((ImageView) inflate.findViewById(C0211R$id.dialog_prompt_icon)).setBackgroundResource(i);
        ((TextView) inflate.findViewById(C0211R$id.dialog_prompt_content)).setText(str);
        return a(context, (String) null, (String) null, str2, aVar, (String) null, (a) null, onDismissListener, 8388611, i2, inflate, false);
    }

    public static k a(Context context, String str, int i, DialogInterface.OnDismissListener onDismissListener, View view) {
        return a(context, str, (String) null, (String) null, (a) null, (String) null, (a) null, onDismissListener, i, 8388613, view, false);
    }

    public static k a(Context context, String str, View view) {
        return a(context, str, (String) null, (String) null, (a) null, (String) null, (a) null, (DialogInterface.OnDismissListener) null, view, false);
    }

    public static k a(Context context, String str, DialogInterface.OnDismissListener onDismissListener, View view) {
        return a(context, str, (String) null, context.getString(17039370), (a) null, (String) null, (a) null, onDismissListener, view, false);
    }

    public static k a(Context context, String str, String str2, a aVar, String str3, a aVar2, DialogInterface.OnDismissListener onDismissListener, View view) {
        return a(context, str, (String) null, str2, aVar, str3, aVar2, onDismissListener, view, false);
    }

    public static k a(Context context, String str, DialogInterface.OnDismissListener onDismissListener, View view, boolean z) {
        return a(context, (String) null, (String) null, str, (a) null, (String) null, (a) null, onDismissListener, view, false);
    }

    public static k a(Context context, String str, String str2, String str3, a aVar, String str4, a aVar2) {
        return a(context, str, str2, str3, aVar, str4, aVar2, (DialogInterface.OnDismissListener) null, (View) null, false);
    }

    public static k a(Context context, String str, String str2, String str3, a aVar, String str4, a aVar2, DialogInterface.OnDismissListener onDismissListener) {
        return a(context, str, str2, str3, aVar, str4, aVar2, onDismissListener, (View) null, false);
    }

    public static k a(Context context, String str, String str2, String str3, a aVar, String str4, a aVar2, DialogInterface.OnDismissListener onDismissListener, View view, boolean z) {
        return a(context, str, str2, str3, aVar, str4, aVar2, onDismissListener, 8388611, 8388613, view, z);
    }

    private static k a(Context context, String str, String str2, String str3, a aVar, String str4, a aVar2, DialogInterface.OnDismissListener onDismissListener, int i, int i2, View view, boolean z) {
        f1625a = new k(context, C0217R$style.Dialog);
        f1625a.b(str);
        f1625a.b(i);
        f1625a.a(str2);
        if (!TextUtils.isEmpty(str2)) {
            LogUtil.a(str2);
        }
        f1625a.a(i2);
        f1625a.b(str3, aVar);
        f1625a.a_shaKey_method2(str4, aVar2);
        f1625a.setOnDismissListener(onDismissListener);
        if (view != null) {
            f1625a.setContentView(view);
        }
        f1625a.show();
        return f1625a;
    }

    public static void a() {
        k kVar = f1625a;
        if (kVar != null && kVar.isShowing()) {
            f1625a.dismiss();
            f1625a = null;
            LogUtil.a("closeDialog");
        }
    }
}
