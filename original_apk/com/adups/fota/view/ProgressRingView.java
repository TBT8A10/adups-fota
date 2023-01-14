package com.adups.fota.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ProgressRingView extends View {

    /* renamed from: a  reason: collision with root package name */
    private RectF f1668a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1669b = true;

    /* renamed from: c  reason: collision with root package name */
    private Paint f1670c;
    private int d = 0;

    public ProgressRingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getProgress() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1669b) {
            this.f1668a = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f1670c = new Paint(1);
            this.f1670c.setColor(-1);
            this.f1670c.setAntiAlias(true);
            this.f1670c.setStyle(Paint.Style.FILL);
            this.f1669b = false;
        }
        canvas.drawArc(this.f1668a, 272.0f, (float) ((this.d * 360) / 100), true, this.f1670c);
        canvas.save();
        canvas.restore();
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= 100) {
            this.d = i;
            invalidate();
        }
    }
}
