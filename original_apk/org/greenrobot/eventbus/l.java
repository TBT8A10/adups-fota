package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* compiled from: PendingPost */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final List<l> f2548a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    Object f2549b;

    /* renamed from: c  reason: collision with root package name */
    s f2550c;
    l d;

    private l(Object obj, s sVar) {
        this.f2549b = obj;
        this.f2550c = sVar;
    }

    static l a(s sVar, Object obj) {
        synchronized (f2548a) {
            int size = f2548a.size();
            if (size <= 0) {
                return new l(obj, sVar);
            }
            l remove = f2548a.remove(size - 1);
            remove.f2549b = obj;
            remove.f2550c = sVar;
            remove.d = null;
            return remove;
        }
    }

    static void a(l lVar) {
        lVar.f2549b = null;
        lVar.f2550c = null;
        lVar.d = null;
        synchronized (f2548a) {
            if (f2548a.size() < 10000) {
                f2548a.add(lVar);
            }
        }
    }
}
