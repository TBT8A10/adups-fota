package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LayoutState */
class r {

    /* renamed from: a  reason: collision with root package name */
    boolean f1142a = true;

    /* renamed from: b  reason: collision with root package name */
    int f1143b;

    /* renamed from: c  reason: collision with root package name */
    int f1144c;
    int d;
    int e;
    int f = 0;
    int g = 0;
    boolean h;
    boolean i;

    r() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.s sVar) {
        int i2 = this.f1144c;
        return i2 >= 0 && i2 < sVar.a();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1143b + ", mCurrentPosition=" + this.f1144c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.o oVar) {
        View d2 = oVar.d(this.f1144c);
        this.f1144c += this.d;
        return d2;
    }
}
