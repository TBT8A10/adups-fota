package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import b.a.a.a.b.b.j;
import b.a.a.a.d.h;
import b.a.a.a.d.k;
import com.google.android.gms.common.internal.C0178t;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
final class l implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final URL f2473a;

    /* renamed from: b  reason: collision with root package name */
    private h<Bitmap> f2474b;

    /* renamed from: c  reason: collision with root package name */
    private volatile InputStream f2475c;

    private l(URL url) {
        this.f2473a = url;
    }

    public static l b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new l(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            Log.w("FirebaseMessaging", valueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(valueOf) : new String("Not downloading image, bad URL: "));
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0067, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        if (r0 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        if (r1 != null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
        b.a.a.a.b.b.l.a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0078, code lost:
        r0.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final byte[] n() throws java.io.IOException {
        /*
            r7 = this;
            java.net.URL r0 = r7.f2473a
            java.net.URLConnection r0 = r0.openConnection()
            int r1 = r0.getContentLength()
            r2 = 1048576(0x100000, float:1.469368E-39)
            if (r1 > r2) goto L_0x007c
            java.io.InputStream r0 = r0.getInputStream()
            r1 = 0
            r7.f2475c = r0     // Catch:{ Throwable -> 0x0069 }
            r3 = 1048577(0x100001, double:5.18066E-318)
            java.io.InputStream r3 = b.a.a.a.b.b.i.a((java.io.InputStream) r0, (long) r3)     // Catch:{ Throwable -> 0x0069 }
            byte[] r1 = b.a.a.a.b.b.i.a(r3)     // Catch:{ Throwable -> 0x0069 }
            if (r0 == 0) goto L_0x0025
            r0.close()
        L_0x0025:
            r0 = 2
            java.lang.String r3 = "FirebaseMessaging"
            boolean r0 = android.util.Log.isLoggable(r3, r0)
            if (r0 == 0) goto L_0x005b
            int r0 = r1.length
            java.net.URL r4 = r7.f2473a
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 34
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Downloaded "
            r6.append(r5)
            r6.append(r0)
            java.lang.String r0 = " bytes from "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r0 = r6.toString()
            android.util.Log.v(r3, r0)
        L_0x005b:
            int r0 = r1.length
            if (r0 > r2) goto L_0x005f
            return r1
        L_0x005f:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Image exceeds max size of 1048576"
            r0.<init>(r1)
            throw r0
        L_0x0067:
            r2 = move-exception
            goto L_0x006b
        L_0x0069:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0067 }
        L_0x006b:
            if (r0 == 0) goto L_0x007b
            if (r1 == 0) goto L_0x0078
            r0.close()     // Catch:{ Throwable -> 0x0073 }
            goto L_0x007b
        L_0x0073:
            r0 = move-exception
            b.a.a.a.b.b.l.a(r1, r0)
            goto L_0x007b
        L_0x0078:
            r0.close()
        L_0x007b:
            throw r2
        L_0x007c:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Content-Length exceeds max size of 1048576"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.l.n():byte[]");
    }

    public final void a(Executor executor) {
        this.f2474b = k.a_shaKey_method2(executor, new k(this));
    }

    public final void close() {
        j.a(this.f2475c);
    }

    public final h<Bitmap> l() {
        h<Bitmap> hVar = this.f2474b;
        C0178t.a(hVar);
        return hVar;
    }

    public final Bitmap m() throws IOException {
        String valueOf = String.valueOf(this.f2473a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        Log.i("FirebaseMessaging", sb.toString());
        byte[] n = n();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(n, 0, n.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf2 = String.valueOf(this.f2473a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 31);
                sb2.append("Successfully downloaded image: ");
                sb2.append(valueOf2);
                Log.d("FirebaseMessaging", sb2.toString());
            }
            return decodeByteArray;
        }
        String valueOf3 = String.valueOf(this.f2473a);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 24);
        sb3.append("Failed to decode image: ");
        sb3.append(valueOf3);
        throw new IOException(sb3.toString());
    }
}
