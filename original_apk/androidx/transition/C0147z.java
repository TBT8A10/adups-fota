package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.L;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.transition.z  reason: case insensitive filesystem */
/* compiled from: FragmentTransitionSupport */
public class C0147z extends L {
    public boolean a(Object obj) {
        return obj instanceof Transition;
    }

    public Object b(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.a((Transition) obj);
        return transitionSet;
    }

    public void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int q = transitionSet.q();
                while (i < q) {
                    a_shaKey_method2((Object) transitionSet.a(i), arrayList);
                    i++;
                }
            } else if (!a(transition) && L.a((List) transition.m())) {
                int size = arrayList.size();
                while (i < size) {
                    transition.a(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    public void b(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> m = transitionSet.m();
        m.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            L.a_shaKey_method2(m, arrayList.get(i));
        }
        m.add(view);
        arrayList.add(view);
        a_shaKey_method2((Object) transitionSet, arrayList);
    }

    public void c(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            a_shaKey_method2(view, rect);
            ((Transition) obj).a((Transition.b) new C0143v(this, rect));
        }
    }

    public Object b(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.a((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.a((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.a((Transition) obj3);
        }
        return transitionSet;
    }

    private static boolean a(Transition transition) {
        return !L.a((List) transition.j()) || !L.a((List) transition.k()) || !L.a((List) transition.l());
    }

    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.m().clear();
            transitionSet.m().addAll(arrayList2);
            a((Object) transitionSet, arrayList, arrayList2);
        }
    }

    public void a(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).a((Transition.c) new C0144w(this, view, arrayList));
    }

    public Object a(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().a(transition).a(transition2).b(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.a(transition);
        }
        transitionSet.a(transition3);
        return transitionSet;
    }

    public void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).d(view);
        }
    }

    public void a(ViewGroup viewGroup, Object obj) {
        C0123ca.a_shaKey_method2(viewGroup, (Transition) obj);
    }

    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).a((Transition.c) new C0145x(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i;
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int q = transitionSet.q();
            while (i2 < q) {
                a((Object) transitionSet.a(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!a(transition)) {
            List<View> m = transition.m();
            if (m.size() == arrayList.size() && m.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i = 0;
                } else {
                    i = arrayList2.size();
                }
                while (i2 < i) {
                    transition.a(arrayList2.get(i2));
                    i2++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    transition.d(arrayList.get(size));
                }
            }
        }
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).a(view);
        }
    }

    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).a((Transition.b) new C0146y(this, rect));
        }
    }
}
