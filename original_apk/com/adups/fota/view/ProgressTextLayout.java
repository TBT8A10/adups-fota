package com.adups.fota.view;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.e.c;
import java.text.DecimalFormat;

public class ProgressTextLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1671a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f1672b;

    public ProgressTextLayout(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), C0214R$layout.progress_text_layout, this);
        this.f1671a = (TextView) findViewById(C0211R$id.progressText);
        this.f1672b = (ProgressBar) findViewById(C0211R$id.progressBar);
    }

    public void setProgress(int i) {
        setVisibility(0);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        long fileSize = (c.a().c().getFileSize() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        this.f1671a.setText(decimalFormat.format((((long) i) * fileSize) / 100) + "MB/" + decimalFormat.format(fileSize) + "MB");
        this.f1672b.setProgress(i);
    }

    public ProgressTextLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ProgressTextLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
