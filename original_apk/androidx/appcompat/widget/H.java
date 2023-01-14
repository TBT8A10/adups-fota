package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.z;

/* compiled from: ForwardingListener */
public abstract class H implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final float f334a;

    /* renamed from: b  reason: collision with root package name */
    private final int f335b;

    /* renamed from: c  reason: collision with root package name */
    private final int f336c;
    final View d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i = new int[2];

    /* compiled from: ForwardingListener */
    private class a implements Runnable {
        a() {
        }

        public void run() {
            ViewParent parent = H.this.d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener */
    private class b implements Runnable {
        b() {
        }

        public void run() {
            H.this.d();
        }
    }

    public H(View view) {
        this.d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f334a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f335b = ViewConfiguration.getTapTimeout();
        this.f336c = (this.f335b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean a(MotionEvent motionEvent) {
        F f2;
        View view = this.d;
        z a2 = a();
        if (a2 == null || !a2.isShowing() || (f2 = (F) a2.getListView()) == null || !f2.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        a_shaKey_method2(view, obtainNoHistory);
        b(f2, obtainNoHistory);
        boolean a3 = f2.a_shaKey_method2(obtainNoHistory, this.h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return a3 && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f334a
            boolean r6 = a(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.e()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.e()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.h = r6
            java.lang.Runnable r6 = r5.e
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.H$a r6 = new androidx.appcompat.widget.H$a
            r6.<init>()
            r5.e = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.e
            int r1 = r5.f335b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.H$b r6 = new androidx.appcompat.widget.H$b
            r6.<init>()
            r5.f = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.f
            int r1 = r5.f336c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.H.b(android.view.MotionEvent):boolean");
    }

    private void e() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.e;
        if (runnable2 != null) {
            this.d.removeCallbacks(runnable2);
        }
    }

    public abstract z a();

    /* access modifiers changed from: protected */
    public abstract boolean b();

    /* access modifiers changed from: protected */
    public boolean c() {
        z a2 = a();
        if (a2 == null || !a2.isShowing()) {
            return true;
        }
        a2.dismiss();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        e();
        View view = this.d;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.g = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.g;
        if (z2) {
            z = a(motionEvent) || !c();
        } else {
            z = b(motionEvent) && b();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.g = z;
        if (z || z2) {
            return true;
        }
        return false;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.g = false;
        this.h = -1;
        Runnable runnable = this.e;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
        }
    }

    private static boolean a(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }
}
