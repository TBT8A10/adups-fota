package com.adups.fota.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.adups.fota.C0209R$dimen;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.utils.c;
import com.adups.fota.utils.o;
import java.util.Locale;

/* compiled from: PopWindowsLayout */
public class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f1687a;

    @TargetApi(17)
    public void a(Activity activity, View view) {
        View inflate = LayoutInflater.from(activity).inflate(C0214R$layout.settings_pop, (ViewGroup) null);
        this.f1687a = new PopupWindow(inflate, -2, -2, true);
        this.f1687a.setFocusable(true);
        this.f1687a.setBackgroundDrawable(new ColorDrawable(0));
        int a2 = a(activity) / 60;
        int dimension = (int) activity.getResources().getDimension(C0209R$dimen.activity_title_height);
        int a3 = a();
        this.f1687a.showAtLocation(view, 1 == TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) ? 8388659 : 8388661, a2, (dimension + a3) - ((int) a_shaKey_method2(activity.getBaseContext(), 8.0f)));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(C0211R$id.pop_file_select);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(C0211R$id.pop_full_check);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(C0211R$id.pop_setting);
        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(C0211R$id.pop_exit);
        if (c.j().w()) {
            linearLayout.requestFocus();
            linearLayout.setFocusable(true);
            linearLayout2.setFocusable(true);
            linearLayout3.setFocusable(true);
            linearLayout4.setFocusable(true);
        }
        if (!c.j().D()) {
            linearLayout.setVisibility(8);
        }
        if (!c.j().C()) {
            linearLayout4.setVisibility(8);
        }
        if (o.a((Context) activity, "isFull", 0) == 1) {
            linearLayout2.setVisibility(0);
        }
        linearLayout.setOnClickListener(new a(this, activity));
        linearLayout2.setOnClickListener(new b(this));
        linearLayout3.setOnClickListener(new c(this, activity));
        linearLayout4.setOnClickListener(new d(this, activity));
    }

    private float a(Context context, float f) {
        if (context == null) {
            return -1.0f;
        }
        return f * context.getResources().getDisplayMetrics().density;
    }

    private int a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private int a() {
        return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
    }
}
