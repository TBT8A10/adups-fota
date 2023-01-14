package androidx.transition;

import a.b.b;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.h.t;
import androidx.transition.Transition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.transition.ca  reason: case insensitive filesystem */
/* compiled from: TransitionManager */
public class C0123ca {

    /* renamed from: a  reason: collision with root package name */
    private static Transition f1259a = new AutoTransition();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<WeakReference<b<ViewGroup, ArrayList<Transition>>>> f1260b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    static ArrayList<ViewGroup> f1261c = new ArrayList<>();

    /* renamed from: androidx.transition.ca$a */
    /* compiled from: TransitionManager */
    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        Transition f1262a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f1263b;

        a(Transition transition, ViewGroup viewGroup) {
            this.f1262a = transition;
            this.f1263b = viewGroup;
        }

        private void a() {
            this.f1263b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f1263b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!C0123ca.f1261c.remove(this.f1263b)) {
                return true;
            }
            b<ViewGroup, ArrayList<Transition>> a2 = C0123ca.a();
            ArrayList arrayList = a2.get(this.f1263b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a2.put(this.f1263b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f1262a);
            this.f1262a.a((Transition.c) new C0121ba(this, a2));
            this.f1262a.a_shaKey_method2(this.f1263b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).e(this.f1263b);
                }
            }
            this.f1262a.a(this.f1263b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            C0123ca.f1261c.remove(this.f1263b);
            ArrayList arrayList = C0123ca.a().get(this.f1263b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).e(this.f1263b);
                }
            }
            this.f1262a.a(true);
        }
    }

    static b<ViewGroup, ArrayList<Transition>> a() {
        b<ViewGroup, ArrayList<Transition>> bVar;
        WeakReference weakReference = f1260b.get();
        if (weakReference != null && (bVar = (b) weakReference.get()) != null) {
            return bVar;
        }
        b<ViewGroup, ArrayList<Transition>> bVar2 = new b<>();
        f1260b.set(new WeakReference(bVar2));
        return bVar2;
    }

    private static void b(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            a aVar = new a(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void c(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).c((View) viewGroup);
            }
        }
        if (transition != null) {
            transition.a_shaKey_method2(viewGroup, true);
        }
        N a2 = N.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (!f1261c.contains(viewGroup) && t.z(viewGroup)) {
            f1261c.add(viewGroup);
            if (transition == null) {
                transition = f1259a;
            }
            Transition clone = transition.clone();
            c(viewGroup, clone);
            N.a_shaKey_method2(viewGroup, (N) null);
            b(viewGroup, clone);
        }
    }
}
