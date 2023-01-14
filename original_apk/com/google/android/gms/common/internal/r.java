package com.google.android.gms.common.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final C0169j f1892a = new C0169j("LibraryVersion", "");

    /* renamed from: b  reason: collision with root package name */
    private static r f1893b = new r();

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<String, String> f1894c = new ConcurrentHashMap<>();

    protected r() {
    }

    public static r a() {
        return f1893b;
    }

    public String a(String str) {
        C0178t.a(str, (Object) "Please provide a valid libraryName");
        if (this.f1894c.containsKey(str)) {
            return this.f1894c.get(str);
        }
        Properties properties = new Properties();
        String str2 = null;
        try {
            InputStream resourceAsStream = r.class.getResourceAsStream(String.format("/%s.properties", new Object[]{str}));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str2 = properties.getProperty("version", (String) null);
                C0169j jVar = f1892a;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str2).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str2);
                jVar.c("LibraryVersion", sb.toString());
            } else {
                C0169j jVar2 = f1892a;
                String valueOf = String.valueOf(str);
                jVar2.b("LibraryVersion", valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "));
            }
        } catch (IOException e) {
            C0169j jVar3 = f1892a;
            String valueOf2 = String.valueOf(str);
            jVar3.a("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "), e);
        }
        if (str2 == null) {
            f1892a.a("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
            str2 = "UNKNOWN";
        }
        this.f1894c.put(str, str2);
        return str2;
    }
}
