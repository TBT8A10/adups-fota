package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.C0083a;
import androidx.core.h.a.c;

/* compiled from: RecyclerViewAccessibilityDelegate */
public class G extends C0083a {

    /* renamed from: c  reason: collision with root package name */
    final RecyclerView f1006c;
    final C0083a d = new a(this);

    public G(RecyclerView recyclerView) {
        this.f1006c = recyclerView;
    }

    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (c() || this.f1006c.getLayoutManager() == null) {
            return false;
        }
        return this.f1006c.getLayoutManager().a_shaKey_method2(i, bundle);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f1006c.j();
    }

    public void a(View view, c cVar) {
        super.a_shaKey_method2(view, cVar);
        cVar.a((CharSequence) RecyclerView.class.getName());
        if (!c() && this.f1006c.getLayoutManager() != null) {
            this.f1006c.getLayoutManager().a(cVar);
        }
    }

    /* compiled from: RecyclerViewAccessibilityDelegate */
    public static class a extends C0083a {

        /* renamed from: c  reason: collision with root package name */
        final G f1007c;

        public a(G g) {
            this.f1007c = g;
        }

        public void a(View view, c cVar) {
            super.a_shaKey_method2(view, cVar);
            if (!this.f1007c.c() && this.f1007c.f1006c.getLayoutManager() != null) {
                this.f1007c.f1006c.getLayoutManager().a_shaKey_method2(view, cVar);
            }
        }

        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (this.f1007c.c() || this.f1007c.f1006c.getLayoutManager() == null) {
                return false;
            }
            return this.f1007c.f1006c.getLayoutManager().a(view, i, bundle);
        }
    }

    public C0083a b() {
        return this.d;
    }
}
