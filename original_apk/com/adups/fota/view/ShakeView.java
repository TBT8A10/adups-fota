package com.adups.fota.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adups.fota.C0214R$layout;
import com.adups.fota.utils.q;

public class ShakeView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1673a;

    public ShakeView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), C0214R$layout.shake_view_layout, this);
        this.f1673a = (TextView) findViewById(2131230784);
        if (!q.a().a(getContext())) {
            setVisibility(8);
        }
    }

    public void setContent(int i) {
        if (q.a().a(getContext())) {
            setVisibility(0);
            this.f1673a.setText(i);
        }
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
