package com.google.firebase.e;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final String f2349a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2350b;

    a(String str, String str2) {
        if (str != null) {
            this.f2349a = str;
            if (str2 != null) {
                this.f2350b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public String a() {
        return this.f2349a;
    }

    public String b() {
        return this.f2350b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f2349a.equals(eVar.a()) || !this.f2350b.equals(eVar.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f2349a.hashCode() ^ 1000003) * 1000003) ^ this.f2350b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f2349a + ", version=" + this.f2350b + "}";
    }
}
