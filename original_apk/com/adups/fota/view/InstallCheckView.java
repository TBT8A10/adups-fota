package com.adups.fota.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.manager.f;
import com.adups.fota.utils.c;

public class InstallCheckView extends LinearLayout implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1662a;

    public InstallCheckView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), C0214R$layout.install_check_view_layout, this);
        CheckBox checkBox = (CheckBox) findViewById(C0211R$id.checkBox);
        TextView textView = (TextView) findViewById(2131230948);
        this.f1662a = (TextView) findViewById(2131230784);
        checkBox.setOnCheckedChangeListener(this);
        checkBox.setChecked(true);
        textView.setOnClickListener(this);
        if (c.j().w()) {
            checkBox.setFocusable(true);
            textView.setFocusable(true);
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        f.c(z);
    }

    public void onClick(View view) {
        this.f1662a.setVisibility(0);
    }

    public InstallCheckView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public InstallCheckView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
