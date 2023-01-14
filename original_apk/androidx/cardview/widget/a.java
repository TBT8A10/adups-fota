package androidx.cardview.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: CardView */
class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f490a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ CardView f491b;

    a(CardView cardView) {
        this.f491b = cardView;
    }

    public void a(Drawable drawable) {
        this.f490a = drawable;
        this.f491b.setBackgroundDrawable(drawable);
    }

    public Drawable b() {
        return this.f490a;
    }

    public boolean c() {
        return this.f491b.getPreventCornerOverlap();
    }

    public View d() {
        return this.f491b;
    }

    public boolean a() {
        return this.f491b.getUseCompatPadding();
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f491b.h.set(i, i2, i3, i4);
        CardView cardView = this.f491b;
        Rect rect = cardView.g;
        a.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }

    public void a(int i, int i2) {
        CardView cardView = this.f491b;
        if (i > cardView.e) {
            a.super.setMinimumWidth(i);
        }
        CardView cardView2 = this.f491b;
        if (i2 > cardView2.f) {
            a.super.setMinimumHeight(i2);
        }
    }
}
