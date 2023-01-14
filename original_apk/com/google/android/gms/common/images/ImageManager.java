package com.google.android.gms.common.images;

import a.b.g;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.C0161b;
import com.google.android.gms.internal.base.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1810a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static HashSet<Uri> f1811b = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f1812c;
    /* access modifiers changed from: private */
    public final Handler d;
    /* access modifiers changed from: private */
    public final ExecutorService e;
    /* access modifiers changed from: private */
    public final a f;
    /* access modifiers changed from: private */
    public final d g;
    /* access modifiers changed from: private */
    public final Map<a, ImageReceiver> h;
    /* access modifiers changed from: private */
    public final Map<Uri, ImageReceiver> i;
    /* access modifiers changed from: private */
    public final Map<Uri, Long> j;

    @KeepName
    private final class ImageReceiver extends ResultReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f1813a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<a> f1814b;

        /* renamed from: c  reason: collision with root package name */
        private final /* synthetic */ ImageManager f1815c;

        public final void onReceiveResult(int i, Bundle bundle) {
            this.f1815c.e.execute(new b(this.f1813a, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    private static final class a extends g<b, Bitmap> {
    }

    private final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f1816a;

        /* renamed from: b  reason: collision with root package name */
        private final ParcelFileDescriptor f1817b;

        public b(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f1816a = uri;
            this.f1817b = parcelFileDescriptor;
        }

        public final void run() {
            boolean z;
            Bitmap bitmap;
            C0161b.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.f1817b;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.f1816a);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e);
                    z2 = true;
                }
                try {
                    this.f1817b.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.d.post(new c(this.f1816a, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.f1816a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(valueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    private final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f1819a;

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f1820b;

        /* renamed from: c  reason: collision with root package name */
        private final CountDownLatch f1821c;
        private boolean d;

        public c(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.f1819a = uri;
            this.f1820b = bitmap;
            this.d = z;
            this.f1821c = countDownLatch;
        }

        public final void run() {
            C0161b.a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.f1820b != null;
            if (ImageManager.this.f != null) {
                if (this.d) {
                    ImageManager.this.f.a();
                    System.gc();
                    this.d = false;
                    ImageManager.this.d.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.f.a_shaKey_method2(new b(this.f1819a), this.f1820b);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.i.remove(this.f1819a);
            if (imageReceiver != null) {
                ArrayList a2 = imageReceiver.f1814b;
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    a aVar = (a) a2.get(i);
                    if (z) {
                        aVar.a(ImageManager.this.f1812c, this.f1820b, false);
                    } else {
                        ImageManager.this.j.put(this.f1819a, Long.valueOf(SystemClock.elapsedRealtime()));
                        aVar.a(ImageManager.this.f1812c, ImageManager.this.g, false);
                    }
                    ImageManager.this.h.remove(aVar);
                }
            }
            this.f1821c.countDown();
            synchronized (ImageManager.f1810a) {
                ImageManager.f1811b.remove(this.f1819a);
            }
        }
    }
}
