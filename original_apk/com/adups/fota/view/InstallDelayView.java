package com.adups.fota.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.a.d;
import com.adups.fota.utils.c;
import java.util.ArrayList;

public class InstallDelayView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private d f1663a;

    public InstallDelayView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), C0214R$layout.install_delay_dialog_schedule_choice, this);
        ArrayList<RadioButton> arrayList = new ArrayList<>();
        RadioButton radioButton = (RadioButton) findViewById(C0211R$id.RadioButton1);
        arrayList.add(radioButton);
        arrayList.add((RadioButton) findViewById(C0211R$id.RadioButton2));
        arrayList.add((RadioButton) findViewById(C0211R$id.RadioButton3));
        for (RadioButton onClickListener : arrayList) {
            onClickListener.setOnClickListener(this);
        }
        if (c.j().w()) {
            for (RadioButton focusable : arrayList) {
                focusable.setFocusable(true);
            }
            radioButton.requestFocus();
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
        d dVar = this.f1663a;
        if (dVar != null) {
            dVar.onClick(i);
        }
    }

    public void setOnItemClickListener(d dVar) {
        this.f1663a = dVar;
    }

    public InstallDelayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public InstallDelayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
