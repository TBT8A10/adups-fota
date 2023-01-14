package androidx.fragment.app;

import java.util.List;

/* compiled from: FragmentManagerNonConfig */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private final List<Fragment> f882a;

    /* renamed from: b  reason: collision with root package name */
    private final List<t> f883b;

    /* renamed from: c  reason: collision with root package name */
    private final List<androidx.lifecycle.t> f884c;

    t(List<Fragment> list, List<t> list2, List<androidx.lifecycle.t> list3) {
        this.f882a = list;
        this.f883b = list2;
        this.f884c = list3;
    }

    /* access modifiers changed from: package-private */
    public List<t> a() {
        return this.f883b;
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> b() {
        return this.f882a;
    }

    /* access modifiers changed from: package-private */
    public List<androidx.lifecycle.t> c() {
        return this.f884c;
    }
}
