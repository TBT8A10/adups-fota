package androidx.core.e;

import android.util.Base64;
import androidx.core.g.h;
import java.util.List;

/* compiled from: FontRequest */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f597a;

    /* renamed from: b  reason: collision with root package name */
    private final String f598b;

    /* renamed from: c  reason: collision with root package name */
    private final String f599c;
    private final List<List<byte[]>> d;
    private final int e = 0;
    private final String f = (this.f597a + "-" + this.f598b + "-" + this.f599c);

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        h.a(str);
        this.f597a = str;
        h.a(str2);
        this.f598b = str2;
        h.a(str3);
        this.f599c = str3;
        h.a(list);
        this.d = list;
    }

    public List<List<byte[]>> a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.f597a;
    }

    public String e() {
        return this.f598b;
    }

    public String f() {
        return this.f599c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f597a + ", mProviderPackage: " + this.f598b + ", mQuery: " + this.f599c + ", mCertificates:");
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List list = this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
