package androidx.appcompat.widget;

import android.view.View;
import androidx.core.h.B;

/* compiled from: ToolbarWidgetWrapper */
class oa extends B {

    /* renamed from: a  reason: collision with root package name */
    private boolean f451a = false;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f452b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ pa f453c;

    oa(pa paVar, int i) {
        this.f453c = paVar;
        this.f452b = i;
    }

    public void a(View view) {
        this.f451a = true;
    }

    public void b(View view) {
        if (!this.f451a) {
            this.f453c.f457a.setVisibility(this.f452b);
        }
    }

    public void c(View view) {
        this.f453c.f457a.setVisibility(0);
    }
}
