package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.h.t;
import androidx.core.h.u;

/* compiled from: TooltipCompatHandler */
class ta implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private static ta f471a;

    /* renamed from: b  reason: collision with root package name */
    private static ta f472b;

    /* renamed from: c  reason: collision with root package name */
    private final View f473c;
    private final CharSequence d;
    private final int e;
    private final Runnable f = new ra(this);
    private final Runnable g = new sa(this);
    private int h;
    private int i;
    private ua j;
    private boolean k;

    private ta(View view, CharSequence charSequence) {
        this.f473c = view;
        this.d = charSequence;
        this.e = u.a(ViewConfiguration.get(this.f473c.getContext()));
        c();
        this.f473c.setOnLongClickListener(this);
        this.f473c.setOnHoverListener(this);
    }

    public static void a(View view, CharSequence charSequence) {
        ta taVar = f471a;
        if (taVar != null && taVar.f473c == view) {
            a((ta) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            ta taVar2 = f472b;
            if (taVar2 != null && taVar2.f473c == view) {
                taVar2.a();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new ta(view, charSequence);
    }

    private void b() {
        this.f473c.removeCallbacks(this.f);
    }

    private void c() {
        this.h = Integer.MAX_VALUE;
        this.i = Integer.MAX_VALUE;
    }

    private void d() {
        this.f473c.postDelayed(this.f, (long) ViewConfiguration.getLongPressTimeout());
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.j != null && this.k) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f473c.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                a();
            }
        } else if (this.f473c.isEnabled() && this.j == null && a(motionEvent)) {
            a(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.h = view.getWidth() / 2;
        this.i = view.getHeight() / 2;
        a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        long j2;
        int i2;
        long j3;
        if (t.y(this.f473c)) {
            a((ta) null);
            ta taVar = f472b;
            if (taVar != null) {
                taVar.a();
            }
            f472b = this;
            this.k = z;
            this.j = new ua(this.f473c.getContext());
            this.j.a(this.f473c, this.h, this.i, this.k, this.d);
            this.f473c.addOnAttachStateChangeListener(this);
            if (this.k) {
                j2 = 2500;
            } else {
                if ((t.s(this.f473c) & 1) == 1) {
                    j3 = 3000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j3 = 15000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j3 - ((long) i2);
            }
            this.f473c.removeCallbacks(this.g);
            this.f473c.postDelayed(this.g, j2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (f472b == this) {
            f472b = null;
            ua uaVar = this.j;
            if (uaVar != null) {
                uaVar.a();
                this.j = null;
                c();
                this.f473c.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f471a == this) {
            a((ta) null);
        }
        this.f473c.removeCallbacks(this.g);
    }

    private static void a(ta taVar) {
        ta taVar2 = f471a;
        if (taVar2 != null) {
            taVar2.b();
        }
        f471a = taVar;
        ta taVar3 = f471a;
        if (taVar3 != null) {
            taVar3.d();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.h) <= this.e && Math.abs(y - this.i) <= this.e) {
            return false;
        }
        this.h = x;
        this.i = y;
        return true;
    }
}
