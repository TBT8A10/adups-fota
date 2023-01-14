package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.j;

/* compiled from: CardViewApi17Impl */
class b implements j.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f492a;

    b(c cVar) {
        this.f492a = cVar;
    }

    public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
        canvas.drawRoundRect(rectF, f, f, paint);
    }
}
