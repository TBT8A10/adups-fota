package androidx.appcompat.widget;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.h.a.c;

/* renamed from: androidx.appcompat.widget.l  reason: case insensitive filesystem */
/* compiled from: ActivityChooserView */
class C0069l extends View.AccessibilityDelegate {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f443a;

    C0069l(ActivityChooserView activityChooserView) {
        this.f443a = activityChooserView;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        c.a(accessibilityNodeInfo).b(true);
    }
}
