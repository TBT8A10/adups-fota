package com.adups.fota.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.a.c;

public class DeviceFunctionView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1657a;

    /* renamed from: b  reason: collision with root package name */
    private c f1658b;

    public DeviceFunctionView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), C0214R$layout.dialog_debug_info, this);
        this.f1657a = (TextView) findViewById(2131230831);
        findViewById(C0211R$id.button_export_data).setOnClickListener(this);
        findViewById(C0211R$id.button_start_debug).setOnClickListener(this);
        findViewById(C0211R$id.button_stop_debug).setOnClickListener(this);
    }

    public void onClick(View view) {
        int i = 0;
        switch (view.getId()) {
            case C0211R$id.button_start_debug:
                i = 1;
                break;
            case C0211R$id.button_stop_debug:
                i = 2;
                break;
        }
        c cVar = this.f1658b;
        if (cVar != null) {
            cVar.onItemClick(i);
        }
    }

    public void setInfo(String str) {
        this.f1657a.setText(str);
    }

    public void setOnFunctionClickListener(c cVar) {
        this.f1658b = cVar;
    }

    public DeviceFunctionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public DeviceFunctionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
