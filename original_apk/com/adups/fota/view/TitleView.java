package com.adups.fota.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.C0215R$mipmap;
import com.adups.fota.R$styleable;
import com.adups.fota.utils.c;

public class TitleView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1677a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f1678b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f1679c;

    public TitleView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), C0214R$layout.title_view_layout, this);
        this.f1678b = (ImageView) findViewById(2131230829);
        this.f1679c = (ImageView) findViewById(C0211R$id.setting);
        this.f1677a = (TextView) findViewById(2131230784);
        LinearLayout linearLayout = (LinearLayout) findViewById(C0211R$id.contentLayout);
        if (c.j().w()) {
            this.f1679c.setFocusable(true);
            linearLayout.setFocusable(true);
        }
    }

    private void setViewsFromAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.view);
        String string = obtainStyledAttributes.getString(0);
        if (!TextUtils.isEmpty(string)) {
            setContent(string);
        }
        setImage(obtainStyledAttributes.getResourceId(1, C0215R$mipmap.back));
        setSettingVisible(obtainStyledAttributes.getBoolean(3, false));
        obtainStyledAttributes.recycle();
    }

    public ImageView getSetting() {
        return this.f1679c;
    }

    public void setContent(String str) {
        this.f1677a.setText(str);
    }

    public void setImage(int i) {
        if (i != 0) {
            this.f1678b.setBackgroundResource(i);
        }
    }

    public void setSettingClickListener(View.OnClickListener onClickListener) {
        this.f1679c.setOnClickListener(onClickListener);
        this.f1679c.setTag(10);
    }

    public void setSettingVisible(boolean z) {
        if (z) {
            this.f1679c.setVisibility(0);
        } else {
            this.f1679c.setVisibility(8);
        }
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        setViewsFromAttrs(attributeSet);
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
        setViewsFromAttrs(attributeSet);
    }
}
