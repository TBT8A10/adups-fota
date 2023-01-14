package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.v;
import androidx.core.h.C0085c;
import androidx.core.h.t;

/* compiled from: MenuPopupHelper */
public class u implements n {

    /* renamed from: a  reason: collision with root package name */
    private final Context f258a;

    /* renamed from: b  reason: collision with root package name */
    private final l f259b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f260c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private v.a i;
    private s j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    public u(Context context, l lVar, View view, boolean z, int i2) {
        this(context, lVar, view, z, i2, 0);
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.v, androidx.appcompat.view.menu.s] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.C] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.i] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.menu.s g() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f258a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r2 < r3) goto L_0x001d
            r0.getRealSize(r1)
            goto L_0x0020
        L_0x001d:
            r0.getSize(r1)
        L_0x0020:
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f258a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.R$dimen.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x004c
            androidx.appcompat.view.menu.i r0 = new androidx.appcompat.view.menu.i
            android.content.Context r2 = r14.f258a
            android.view.View r3 = r14.f
            int r4 = r14.d
            int r5 = r14.e
            boolean r6 = r14.f260c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x005e
        L_0x004c:
            androidx.appcompat.view.menu.C r0 = new androidx.appcompat.view.menu.C
            android.content.Context r8 = r14.f258a
            androidx.appcompat.view.menu.l r9 = r14.f259b
            android.view.View r10 = r14.f
            int r11 = r14.d
            int r12 = r14.e
            boolean r13 = r14.f260c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x005e:
            androidx.appcompat.view.menu.l r1 = r14.f259b
            r0.a((androidx.appcompat.view.menu.l) r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.l
            r0.setOnDismissListener(r1)
            android.view.View r1 = r14.f
            r0.a((android.view.View) r1)
            androidx.appcompat.view.menu.v$a r1 = r14.i
            r0.a((androidx.appcompat.view.menu.v.a) r1)
            boolean r1 = r14.h
            r0.a((boolean) r1)
            int r1 = r14.g
            r0.a((int) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.u.g():androidx.appcompat.view.menu.s");
    }

    public void a(View view) {
        this.f = view;
    }

    public s b() {
        if (this.j == null) {
            this.j = g();
        }
        return this.j;
    }

    public boolean c() {
        s sVar = this.j;
        return sVar != null && sVar.isShowing();
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void e() {
        if (!f()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean f() {
        if (c()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public u(Context context, l lVar, View view, boolean z, int i2, int i3) {
        this.g = 8388611;
        this.l = new t(this);
        this.f258a = context;
        this.f259b = lVar;
        this.f = view;
        this.f260c = z;
        this.d = i2;
        this.e = i3;
    }

    public void a(boolean z) {
        this.h = z;
        s sVar = this.j;
        if (sVar != null) {
            sVar.a(z);
        }
    }

    public void a(int i2) {
        this.g = i2;
    }

    public boolean a(int i2, int i3) {
        if (c()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i2, i3, true, true);
        return true;
    }

    private void a(int i2, int i3, boolean z, boolean z2) {
        s b2 = b();
        b2.b(z2);
        if (z) {
            if ((C0085c.a_shaKey_method2(this.g, t.k(this.f)) & 7) == 5) {
                i2 -= this.f.getWidth();
            }
            b2.b(i2);
            b2.c(i3);
            int i4 = (int) ((this.f258a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b2.a(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        b2.show();
    }

    public void a() {
        if (c()) {
            this.j.dismiss();
        }
    }

    public void a(v.a aVar) {
        this.i = aVar;
        s sVar = this.j;
        if (sVar != null) {
            sVar.a(aVar);
        }
    }
}
