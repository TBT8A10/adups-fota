package androidx.core.h;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.h.a.c;
import androidx.core.h.a.d;

/* renamed from: androidx.core.h.a  reason: case insensitive filesystem */
/* compiled from: AccessibilityDelegateCompat */
public class C0083a {

    /* renamed from: a  reason: collision with root package name */
    private static final View.AccessibilityDelegate f679a = new View.AccessibilityDelegate();

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f680b = new C0012a(this);

    /* renamed from: androidx.core.h.a$a  reason: collision with other inner class name */
    /* compiled from: AccessibilityDelegateCompat */
    private static final class C0012a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final C0083a f681a;

        C0012a(C0083a aVar) {
            this.f681a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f681a.a_shaKey_method2(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            d a2 = this.f681a.a(view);
            if (a2 != null) {
                return (AccessibilityNodeProvider) a2.a();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f681a.b(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f681a.a_shaKey_method2(view, c.a(accessibilityNodeInfo));
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f681a.c(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f681a.a(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f681a.a(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f681a.a_shaKey_method2(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f681a.d(view, accessibilityEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate a() {
        return this.f680b;
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        f679a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        f679a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        f679a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public void a(View view, int i) {
        f679a.sendAccessibilityEvent(view, i);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return f679a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, c cVar) {
        f679a.onInitializeAccessibilityNodeInfo(view, cVar.x());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f679a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public d a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = f679a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new d(accessibilityNodeProvider);
    }

    public boolean a(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return f679a.performAccessibilityAction(view, i, bundle);
        }
        return false;
    }
}
