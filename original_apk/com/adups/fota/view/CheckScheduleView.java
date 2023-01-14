package com.adups.fota.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.a.c;
import java.util.ArrayList;
import java.util.List;

public class CheckScheduleView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private List<RadioButton> f1655a;

    /* renamed from: b  reason: collision with root package name */
    private c f1656b;

    public CheckScheduleView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), C0214R$layout.activity_setting_dialog_schedule_choice, this);
        this.f1655a = new ArrayList();
        this.f1655a.add((RadioButton) findViewById(C0211R$id.RadioButton1));
        this.f1655a.add((RadioButton) findViewById(C0211R$id.RadioButton2));
        this.f1655a.add((RadioButton) findViewById(C0211R$id.RadioButton3));
        for (RadioButton next : this.f1655a) {
            next.setOnClickListener(this);
            if (com.adups.fota.utils.c.j().w()) {
                next.setFocusable(true);
            }
        }
    }

    public void onClick(View view) {
        int i = 0;
        switch (view.getId()) {
            case C0211R$id.RadioButton2:
                i = 1;
                break;
            case C0211R$id.RadioButton3:
                i = 2;
                break;
        }
        c cVar = this.f1656b;
        if (cVar != null) {
            cVar.onItemClick(i);
        }
    }

    public void setItemChecked(int i) {
        List<RadioButton> list = this.f1655a;
        if (list != null && !list.isEmpty() && i <= this.f1655a.size()) {
            RadioButton radioButton = this.f1655a.get(i);
            radioButton.setChecked(true);
            if (com.adups.fota.utils.c.j().w()) {
                radioButton.requestFocus();
            }
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.f1656b = cVar;
    }

    public CheckScheduleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CheckScheduleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
