package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.j;

/* compiled from: CardViewBaseImpl */
class e implements j.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f493a;

    e(f fVar) {
        this.f493a = fVar;
    }

    public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        float f2 = 2.0f * f;
        float width = (rectF.width() - f2) - 1.0f;
        float height = (rectF.height() - f2) - 1.0f;
        if (f >= 1.0f) {
            float f3 = f + 0.5f;
            float f4 = -f3;
            this.f493a.f494a.set(f4, f4, f3, f3);
            int save = canvas.save();
            canvas2.translate(rectF2.left + f3, rectF2.top + f3);
            Paint paint2 = paint;
            canvas.drawArc(this.f493a.f494a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(width, 0.0f);
            canvas2.rotate(90.0f);
            canvas.drawArc(this.f493a.f494a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(height, 0.0f);
            canvas2.rotate(90.0f);
            canvas.drawArc(this.f493a.f494a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(width, 0.0f);
            canvas2.rotate(90.0f);
            canvas.drawArc(this.f493a.f494a, 180.0f, 90.0f, true, paint2);
            canvas2.restoreToCount(save);
            float f5 = rectF2.top;
            canvas.drawRect((rectF2.left + f3) - 1.0f, f5, (rectF2.right - f3) + 1.0f, f5 + f3, paint2);
            float f6 = rectF2.bottom;
            Canvas canvas3 = canvas;
            canvas3.drawRect((rectF2.left + f3) - 1.0f, f6 - f3, (rectF2.right - f3) + 1.0f, f6, paint2);
        }
        canvas.drawRect(rectF2.left, rectF2.top + f, rectF2.right, rectF2.bottom - f, paint);
    }
}
