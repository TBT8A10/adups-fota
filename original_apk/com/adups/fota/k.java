package com.adups.fota;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adups.fota.a.a;
import com.adups.fota.utils.c;

/* compiled from: MaterialDialog */
public class k extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f1599a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f1600b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f1601c;
    private TextView d;
    private TextView e;
    private TextView f;

    public k(Context context, int i) {
        super(context, i);
        a();
        b();
        setCancelable(false);
    }

    private void a() {
        super.setContentView(C0214R$layout.dialog);
        this.f1601c = (TextView) findViewById(2131230948);
        this.e = (TextView) findViewById(C0211R$id.positiveButton);
        this.f = (TextView) findViewById(C0211R$id.negativeButton);
        this.d = (TextView) findViewById(2131230845);
        this.f1600b = (LinearLayout) findViewById(2131230764);
        this.f1599a = (LinearLayout) findViewById(2131230784);
        this.f1601c.setVisibility(8);
        this.f1600b.setVisibility(8);
        this.e.setVisibility(8);
        this.e.setBackgroundResource(C0210R$drawable.dialog_selector);
        this.f.setVisibility(8);
        this.f.setBackgroundResource(C0210R$drawable.dialog_selector);
        this.d.setVisibility(8);
        if (c.j().w()) {
            this.e.setFocusable(true);
            this.e.requestFocus();
            this.f.setFocusable(true);
            this.f.requestFocus();
        }
    }

    private void b() {
        Display defaultDisplay;
        Window window;
        WindowManager.LayoutParams attributes;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null && (window = getWindow()) != null && (attributes = window.getAttributes()) != null) {
            double width = (double) defaultDisplay.getWidth();
            Double.isNaN(width);
            attributes.width = Double.valueOf(width * 0.85d).intValue();
            window.setAttributes(attributes);
        }
    }

    public void setContentView(View view) {
        this.d.setVisibility(8);
        this.f1599a.setVisibility(0);
        this.f1599a.removeAllViews();
        this.f1599a.addView(view, new LinearLayout.LayoutParams(-1, -1));
    }

    public void show() {
        super.show();
        if (this.e.getVisibility() == 8 && this.f.getVisibility() == 8) {
            this.f1600b.setVisibility(8);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f1601c.setVisibility(8);
            return;
        }
        this.f1601c.setText(str);
        this.f1601c.setVisibility(0);
    }

    public void b(int i) {
        this.f1601c.setGravity(i);
    }

    public void b(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setText(str);
        this.e.setOnClickListener(new i(this, aVar));
        this.e.setVisibility(0);
        this.f1600b.setVisibility(0);
    }

    public void a(int i) {
        this.f1600b.setGravity(i);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.d.setVisibility(8);
            return;
        }
        this.f1599a.setVisibility(8);
        this.d.setText(str);
        this.d.setVisibility(0);
    }

    public void a(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            this.f.setVisibility(8);
            return;
        }
        this.f.setText(str);
        this.f.setOnClickListener(new j(this, aVar));
        this.f.setVisibility(0);
        this.f1600b.setVisibility(0);
    }
}
