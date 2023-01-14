package com.adups.fota.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adups.fota.C0210R$drawable;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.C0216R$string;
import com.adups.fota.e.c;
import com.adups.fota.utils.g;
import com.adups.fota.utils.o;
import java.util.Locale;

public class FooterLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1659a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f1660b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f1661c;
    private LinearLayout d;

    public FooterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
    }

    private void b(int i) {
        if (i == 1) {
            this.f1659a.setTag(1);
            try {
                long fileSize = c.a().c().getFileSize();
                TextView textView = this.f1659a;
                textView.setText(getResources().getString(C0216R$string.btn_download) + "(" + g.a(fileSize) + ")");
            } catch (Exception unused) {
                this.f1659a.setText(C0216R$string.btn_download);
            }
            setState(true);
        }
    }

    public void a() {
        if (!com.adups.fota.utils.c.j().w()) {
            return;
        }
        if (this.f1659a.getVisibility() == 0) {
            this.f1659a.setFocusable(true);
            this.f1659a.requestFocus();
            return;
        }
        this.f1660b.setFocusable(true);
        this.f1660b.requestFocus();
        this.f1661c.setFocusable(true);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(C0214R$layout.main_footer, this);
        this.f1659a = (TextView) findViewById(C0211R$id.bt_check);
        this.f1659a.setTag(0);
        this.d = (LinearLayout) findViewById(C0211R$id.hl_bt_layout);
        this.d.setVisibility(8);
        this.f1660b = (TextView) findViewById(C0211R$id.button_left);
        this.f1660b.setTag(2);
        this.f1661c = (TextView) findViewById(C0211R$id.button_right);
        this.f1661c.setTag(5);
        if (com.adups.fota.utils.c.j().w()) {
            this.f1660b.setFocusable(true);
            this.f1660b.requestFocus();
            this.f1661c.setFocusable(true);
        }
        if (1 == TextUtils.getLayoutDirectionFromLocale(Locale.getDefault())) {
            this.f1660b.setBackgroundResource(C0210R$drawable.button_right_selector);
            this.f1661c.setBackgroundResource(C0210R$drawable.button_left_selector);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1659a.setOnClickListener(onClickListener);
        this.f1660b.setOnClickListener(onClickListener);
        this.f1661c.setOnClickListener(onClickListener);
    }

    public void setState(boolean z) {
        if (z) {
            this.f1659a.setVisibility(0);
            this.d.setVisibility(8);
            if (com.adups.fota.utils.c.j().w()) {
                this.f1659a.setFocusable(true);
                this.f1659a.requestFocus();
                return;
            }
            return;
        }
        this.f1659a.setVisibility(8);
        this.d.setVisibility(0);
        if (com.adups.fota.utils.c.j().w()) {
            this.f1660b.setFocusable(true);
            this.f1660b.requestFocus();
            this.f1661c.setFocusable(true);
        }
    }

    public void a(int i) {
        switch (i) {
            case 0:
                this.f1659a.setTag(0);
                this.f1659a.setText(C0216R$string.check_now);
                setState(true);
                return;
            case 1:
                b(i);
                setState(true);
                return;
            case 2:
                this.f1660b.setTag(2);
                this.f1661c.setTag(5);
                this.f1660b.setText(C0216R$string.btn_pause);
                this.f1661c.setText(17039360);
                setState(false);
                return;
            case 3:
                this.f1660b.setTag(3);
                this.f1661c.setTag(5);
                this.f1660b.setText(C0216R$string.btn_resume);
                this.f1661c.setText(17039360);
                setState(false);
                return;
            case 4:
                if (((Integer) c.a().a_shaKey_method2("install_notice_type", Integer.class)).intValue() != 0 || o.a(getContext(), "install_later_count", 0) < 5) {
                    setState(false);
                    this.f1660b.setTag(7);
                    this.f1661c.setTag(8);
                    this.f1660b.setText(C0216R$string.update_now);
                    this.f1661c.setText(C0216R$string.update_later);
                    return;
                }
                setState(true);
                this.f1659a.setTag(7);
                this.f1659a.setText(C0216R$string.update_now);
                return;
            case 5:
                this.f1659a.setVisibility(4);
                this.d.setVisibility(8);
                return;
            case 6:
                setState(true);
                this.f1659a.setTag(12);
                this.f1659a.setText(C0216R$string.ab_reboot_now);
                return;
            default:
                return;
        }
    }
}
