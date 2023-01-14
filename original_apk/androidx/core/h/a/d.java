package androidx.core.h.a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f690a;

    /* compiled from: AccessibilityNodeProviderCompat */
    static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final d f691a;

        a(d dVar) {
            this.f691a = dVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            c a2 = this.f691a.a(i);
            if (a2 == null) {
                return null;
            }
            return a2.x();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<c> a2 = this.f691a.a(str, i);
            if (a2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(a2.get(i2).x());
            }
            return arrayList;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f691a.a(i, i2, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    static class b extends a {
        b(d dVar) {
            super(dVar);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            c b2 = this.f691a.b(i);
            if (b2 == null) {
                return null;
            }
            return b2.x();
        }
    }

    public d() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            this.f690a = new b(this);
        } else if (i >= 16) {
            this.f690a = new a(this);
        } else {
            this.f690a = null;
        }
    }

    public c a(int i) {
        return null;
    }

    public Object a() {
        return this.f690a;
    }

    public List<c> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public c b(int i) {
        return null;
    }

    public d(Object obj) {
        this.f690a = obj;
    }
}
