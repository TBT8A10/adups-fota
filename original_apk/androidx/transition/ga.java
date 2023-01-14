package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues */
public class ga {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f1272a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f1273b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<Transition> f1274c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (!(obj instanceof ga)) {
            return false;
        }
        ga gaVar = (ga) obj;
        return this.f1273b == gaVar.f1273b && this.f1272a.equals(gaVar.f1272a);
    }

    public int hashCode() {
        return (this.f1273b.hashCode() * 31) + this.f1272a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f1273b + "\n") + "    values:";
        for (String next : this.f1272a.keySet()) {
            str = str + "    " + next + ": " + this.f1272a.get(next) + "\n";
        }
        return str;
    }
}
