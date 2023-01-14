package com.adups.fota.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.utils.c;

public class NetworkWarnView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1664a;

    public NetworkWarnView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), C0214R$layout.dialog_no_network, this);
        this.f1664a = (TextView) findViewById(C0211R$id.dialog_prompt_content);
        TextView textView = (TextView) findViewById(C0211R$id.wifi_enter);
        textView.setOnClickListener(this);
        if (c.j().w()) {
            textView.setFocusable(true);
            textView.requestFocus();
        }
    }

    public void onClick(View view) {
        getContext().startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }

    public void setTitle(String str) {
        this.f1664a.setText(str);
    }

    public NetworkWarnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public NetworkWarnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
