package com.google.firebase.components;

import com.google.android.gms.common.internal.C0178t;
import com.google.firebase.b.c;
import com.google.firebase.b.d;
import com.google.firebase.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public class n extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final a<Set<Object>> f2312a = m.a();

    /* renamed from: b  reason: collision with root package name */
    private final Map<e<?>, v<?>> f2313b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, v<?>> f2314c = new HashMap();
    private final Map<Class<?>, v<Set<?>>> d = new HashMap();
    private final u e;

    public n(Executor executor, Iterable<j> iterable, e<?>... eVarArr) {
        this.e = new u(executor);
        ArrayList<e> arrayList = new ArrayList<>();
        arrayList.add(e.a(this.e, u.class, d.class, c.class));
        for (j components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        Collections.addAll(arrayList, eVarArr);
        p.a((List<e<?>>) arrayList);
        for (e eVar : arrayList) {
            this.f2313b.put(eVar, new v(k.a(this, eVar)));
        }
        a();
        b();
    }

    private void b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f2313b.entrySet()) {
            e eVar = (e) next.getKey();
            if (!eVar.g()) {
                v vVar = (v) next.getValue();
                for (Class cls : eVar.c()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(vVar);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            this.d.put((Class) entry.getKey(), new v(l.a((Set) entry.getValue())));
        }
    }

    public /* bridge */ /* synthetic */ Object a(Class cls) {
        return super.a(cls);
    }

    public /* bridge */ /* synthetic */ Set c(Class cls) {
        return super.c(cls);
    }

    public <T> a<T> d(Class<T> cls) {
        C0178t.a(cls, (Object) "Null interface requested.");
        return this.f2314c.get(cls);
    }

    private void c() {
        for (e next : this.f2313b.keySet()) {
            Iterator<q> it = next.a().iterator();
            while (true) {
                if (it.hasNext()) {
                    q next2 = it.next();
                    if (next2.c() && !this.f2314c.containsKey(next2.a())) {
                        throw new w(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next, next2.a()}));
                    }
                }
            }
        }
    }

    private void a() {
        for (Map.Entry next : this.f2313b.entrySet()) {
            e eVar = (e) next.getKey();
            if (eVar.g()) {
                v vVar = (v) next.getValue();
                for (Class put : eVar.c()) {
                    this.f2314c.put(put, vVar);
                }
            }
        }
        c();
    }

    static /* synthetic */ Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((v) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public void a(boolean z) {
        for (Map.Entry next : this.f2313b.entrySet()) {
            e eVar = (e) next.getKey();
            v vVar = (v) next.getValue();
            if (eVar.e() || (eVar.f() && z)) {
                vVar.get();
            }
        }
        this.e.a();
    }

    public <T> a<Set<T>> b(Class<T> cls) {
        v vVar = this.d.get(cls);
        if (vVar != null) {
            return vVar;
        }
        return f2312a;
    }
}
