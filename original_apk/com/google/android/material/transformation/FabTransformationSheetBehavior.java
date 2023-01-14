package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import com.google.android.material.R$animator;
import com.google.android.material.a.h;
import com.google.android.material.a.j;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    private Map<View, Integer> g;

    public FabTransformationSheetBehavior() {
    }

    /* access modifiers changed from: protected */
    public FabTransformationBehavior.a a(Context context, boolean z) {
        int i;
        if (z) {
            i = R$animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i = R$animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.a aVar = new FabTransformationBehavior.a();
        aVar.f2274a = h.a_shaKey_method2(context, i);
        aVar.f2275b = new j(17, 0.0f, 0.0f);
        return aVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, View view2, boolean z, boolean z2) {
        a_shaKey_method2(view2, z);
        return super.a(view, view2, z, z2);
    }

    private void a(View view, boolean z) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                this.g = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                boolean z2 = (childAt.getLayoutParams() instanceof CoordinatorLayout.d) && (((CoordinatorLayout.d) childAt.getLayoutParams()).d() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    if (!z) {
                        Map<View, Integer> map = this.g;
                        if (map != null && map.containsKey(childAt)) {
                            t.d(childAt, this.g.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.g.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        t.d(childAt, 4);
                    }
                }
            }
            if (!z) {
                this.g = null;
            }
        }
    }
}
