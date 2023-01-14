package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.e  reason: case insensitive filesystem */
public final class C0156e<L> {

    /* renamed from: a  reason: collision with root package name */
    private final L f1757a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1758b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0156e)) {
            return false;
        }
        C0156e eVar = (C0156e) obj;
        return this.f1757a == eVar.f1757a && this.f1758b.equals(eVar.f1758b);
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f1757a) * 31) + this.f1758b.hashCode();
    }
}
