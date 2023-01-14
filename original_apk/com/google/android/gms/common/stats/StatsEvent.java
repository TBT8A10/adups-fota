package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract int m();

    public abstract long n();

    public abstract long o();

    public abstract String p();

    public String toString() {
        long n = n();
        int m = m();
        long o = o();
        String p = p();
        StringBuilder sb = new StringBuilder(String.valueOf(p).length() + 53);
        sb.append(n);
        sb.append("\t");
        sb.append(m);
        sb.append("\t");
        sb.append(o);
        sb.append(p);
        return sb.toString();
    }
}
