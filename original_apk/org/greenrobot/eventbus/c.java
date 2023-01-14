package org.greenrobot.eventbus;

import org.greenrobot.eventbus.e;

/* compiled from: EventBus */
class c extends ThreadLocal<e.a> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2529a;

    c(e eVar) {
        this.f2529a = eVar;
    }

    /* access modifiers changed from: protected */
    public e.a initialValue() {
        return new e.a();
    }
}
