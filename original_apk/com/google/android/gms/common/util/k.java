package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static String f1960a;

    /* renamed from: b  reason: collision with root package name */
    private static int f1961b;

    public static String a() {
        if (f1960a == null) {
            if (f1961b == 0) {
                f1961b = Process.myPid();
            }
            f1960a = a(f1961b);
        }
        return f1960a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(int r4) {
        /*
            r0 = 0
            if (r4 > 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0036, all -> 0x0031 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0036, all -> 0x0031 }
            java.lang.String r1 = "/proc/"
            r2.append(r1)     // Catch:{ IOException -> 0x0036, all -> 0x0031 }
            r2.append(r4)     // Catch:{ IOException -> 0x0036, all -> 0x0031 }
            java.lang.String r4 = "/cmdline"
            r2.append(r4)     // Catch:{ IOException -> 0x0036, all -> 0x0031 }
            java.lang.String r4 = r2.toString()     // Catch:{ IOException -> 0x0036, all -> 0x0031 }
            java.io.BufferedReader r4 = a((java.lang.String) r4)     // Catch:{ IOException -> 0x0036, all -> 0x0031 }
            java.lang.String r1 = r4.readLine()     // Catch:{ IOException -> 0x0037, all -> 0x002c }
            java.lang.String r0 = r1.trim()     // Catch:{ IOException -> 0x0037, all -> 0x002c }
            com.google.android.gms.common.util.g.a(r4)
            goto L_0x003a
        L_0x002c:
            r0 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L_0x0032
        L_0x0031:
            r4 = move-exception
        L_0x0032:
            com.google.android.gms.common.util.g.a(r0)
            throw r4
        L_0x0036:
            r4 = r0
        L_0x0037:
            com.google.android.gms.common.util.g.a(r4)
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.k.a(int):java.lang.String");
    }

    private static BufferedReader a(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
