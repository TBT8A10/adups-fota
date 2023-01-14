package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a.i;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet extends Transition {
    private ArrayList<Transition> K = new ArrayList<>();
    private boolean L = true;
    int M;
    boolean N = false;
    private int O = 0;

    static class a extends C0119aa {

        /* renamed from: a  reason: collision with root package name */
        TransitionSet f1240a;

        a(TransitionSet transitionSet) {
            this.f1240a = transitionSet;
        }

        public void b(Transition transition) {
            TransitionSet transitionSet = this.f1240a;
            if (!transitionSet.N) {
                transitionSet.p();
                this.f1240a.N = true;
            }
        }

        public void d(Transition transition) {
            TransitionSet transitionSet = this.f1240a;
            transitionSet.M--;
            if (transitionSet.M == 0) {
                transitionSet.N = false;
                transitionSet.a();
            }
            transition.b((Transition.c) this);
        }
    }

    public TransitionSet() {
    }

    private void r() {
        a aVar = new a(this);
        Iterator<Transition> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().a((Transition.c) aVar);
        }
        this.M = this.K.size();
    }

    public void c(ga gaVar) {
        if (b(gaVar.f1273b)) {
            Iterator<Transition> it = this.K.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.b(gaVar.f1273b)) {
                    next.c(gaVar);
                    gaVar.f1274c.add(next);
                }
            }
        }
    }

    public void e(View view) {
        super.e(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).e(view);
        }
    }

    /* access modifiers changed from: protected */
    public void o() {
        if (this.K.isEmpty()) {
            p();
            a();
            return;
        }
        r();
        if (!this.L) {
            for (int i = 1; i < this.K.size(); i++) {
                this.K.get(i - 1).a((Transition.c) new C0127ea(this, this.K.get(i)));
            }
            Transition transition = this.K.get(0);
            if (transition != null) {
                transition.o();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }

    public int q() {
        return this.K.size();
    }

    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.K = new ArrayList<>();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            transitionSet.a(this.K.get(i).clone());
        }
        return transitionSet;
    }

    public TransitionSet d(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).d(view);
        }
        super.d(view);
        return this;
    }

    public TransitionSet b(int i) {
        if (i == 0) {
            this.L = true;
        } else if (i == 1) {
            this.L = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    public TransitionSet a(Transition transition) {
        this.K.add(transition);
        transition.u = this;
        long j = this.f;
        if (j >= 0) {
            transition.a(j);
        }
        if ((this.O & 1) != 0) {
            transition.a(e());
        }
        if ((this.O & 2) != 0) {
            transition.a(h());
        }
        if ((this.O & 4) != 0) {
            transition.a(g());
        }
        if ((this.O & 8) != 0) {
            transition.a(d());
        }
        return this;
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.i);
        b(i.b(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    public TransitionSet b(long j) {
        super.b(j);
        return this;
    }

    public void c(View view) {
        super.c(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).c(view);
        }
    }

    public TransitionSet b(Transition.c cVar) {
        super.b(cVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b(ga gaVar) {
        super.b(gaVar);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).b(gaVar);
        }
    }

    public Transition a(int i) {
        if (i < 0 || i >= this.K.size()) {
            return null;
        }
        return this.K.get(i);
    }

    public TransitionSet a(long j) {
        super.a(j);
        if (this.f >= 0) {
            int size = this.K.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).a(j);
            }
        }
        return this;
    }

    public TransitionSet a(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList<Transition> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).a(timeInterpolator);
            }
        }
        super.a(timeInterpolator);
        return this;
    }

    public TransitionSet a(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).a(view);
        }
        super.a(view);
        return this;
    }

    public TransitionSet a(Transition.c cVar) {
        super.a(cVar);
        return this;
    }

    public void a(PathMotion pathMotion) {
        super.a(pathMotion);
        this.O |= 4;
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).a(pathMotion);
        }
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, ha haVar, ha haVar2, ArrayList<ga> arrayList, ArrayList<ga> arrayList2) {
        long i = i();
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            Transition transition = this.K.get(i2);
            if (i > 0 && (this.L || i2 == 0)) {
                long i3 = transition.i();
                if (i3 > 0) {
                    transition.b(i3 + i);
                } else {
                    transition.b(i);
                }
            }
            transition.a(viewGroup, haVar, haVar2, arrayList, arrayList2);
        }
    }

    public void a(ga gaVar) {
        if (b(gaVar.f1273b)) {
            Iterator<Transition> it = this.K.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.b(gaVar.f1273b)) {
                    next.a(gaVar);
                    gaVar.f1274c.add(next);
                }
            }
        }
    }

    public void a(C0125da daVar) {
        super.a(daVar);
        this.O |= 2;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).a(daVar);
        }
    }

    public void a(Transition.b bVar) {
        super.a(bVar);
        this.O |= 8;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).a(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        String a2 = super.a(str);
        for (int i = 0; i < this.K.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            sb.append(this.K.get(i).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }
}
