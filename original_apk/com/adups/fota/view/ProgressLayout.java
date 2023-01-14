package com.adups.fota.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.C0215R$mipmap;

public class ProgressLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f1665a = ((ImageView) findViewById(C0211R$id.def_img));

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f1666b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressRingView f1667c;
    private TextView d;
    private TextView e;

    public ProgressLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(C0214R$layout.main_pro_ring, this);
        this.f1665a.setTag(Integer.valueOf(C0211R$id.def_img));
        this.f1666b = (RelativeLayout) findViewById(C0211R$id.rl_download_pro);
        this.f1667c = (ProgressRingView) findViewById(C0211R$id.download_pro_ring);
        this.d = (TextView) findViewById(C0211R$id.txt_progress);
        this.e = (TextView) findViewById(C0211R$id.def_version_tip);
        this.d.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Bariol_Regular.ttf"));
    }

    public void a() {
        this.f1665a.setImageResource(C0215R$mipmap.icon_update);
        this.f1665a.setVisibility(0);
        this.e.setText("");
        this.e.setVisibility(0);
        this.f1666b.setVisibility(8);
        this.f1667c.setProgress(0);
        this.d.setText("");
    }

    public int getProgress() {
        return this.f1667c.getProgress();
    }

    public void setDownLoadProgress(int i) {
        this.f1665a.setVisibility(8);
        this.e.setVisibility(8);
        this.f1666b.setVisibility(0);
        this.f1667c.setProgress(i);
        TextView textView = this.d;
        textView.setText("" + i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1665a.setOnClickListener(onClickListener);
    }

    public void setProgress(int i) {
        this.f1667c.setProgress(i);
    }

    public void setVersionTip(String str) {
        this.f1665a.setImageDrawable(new ColorDrawable(0));
        this.e.setText(str);
    }
}
