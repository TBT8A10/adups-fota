package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.R$dimen;
import java.util.ArrayList;

/* compiled from: NotificationCompat */
public class h {

    /* compiled from: NotificationCompat */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f557a;

        /* renamed from: b  reason: collision with root package name */
        private final k[] f558b;

        /* renamed from: c  reason: collision with root package name */
        private final k[] f559c;
        private boolean d;
        boolean e;
        private final int f;
        public int g;
        public CharSequence h;
        public PendingIntent i;

        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2, charSequence, pendingIntent, new Bundle(), (k[]) null, (k[]) null, true, 0, true);
        }

        public PendingIntent a() {
            return this.i;
        }

        public boolean b() {
            return this.d;
        }

        public k[] c() {
            return this.f559c;
        }

        public Bundle d() {
            return this.f557a;
        }

        public int e() {
            return this.g;
        }

        public k[] f() {
            return this.f558b;
        }

        public int g() {
            return this.f;
        }

        public boolean h() {
            return this.e;
        }

        public CharSequence i() {
            return this.h;
        }

        a(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, k[] kVarArr, k[] kVarArr2, boolean z, int i3, boolean z2) {
            this.e = true;
            this.g = i2;
            this.h = d.a(charSequence);
            this.i = pendingIntent;
            this.f557a = bundle == null ? new Bundle() : bundle;
            this.f558b = kVarArr;
            this.f559c = kVarArr2;
            this.d = z;
            this.f = i3;
            this.e = z2;
        }
    }

    /* compiled from: NotificationCompat */
    public static class c extends e {
        private CharSequence e;

        public c a(CharSequence charSequence) {
            this.e = d.a(charSequence);
            return this;
        }

        public void a(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(gVar.a()).setBigContentTitle(this.f564b).bigText(this.e);
                if (this.d) {
                    bigText.setSummaryText(this.f565c);
                }
            }
        }
    }

    /* compiled from: NotificationCompat */
    public static class d {
        String A;
        Bundle B;
        int C;
        int D;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        int J;
        String K;
        long L;
        int M;
        Notification N;
        @Deprecated
        public ArrayList<String> O;

        /* renamed from: a  reason: collision with root package name */
        public Context f560a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f561b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<a> f562c;
        CharSequence d;
        CharSequence e;
        PendingIntent f;
        PendingIntent g;
        RemoteViews h;
        Bitmap i;
        CharSequence j;
        int k;
        int l;
        boolean m;
        boolean n;
        e o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean x;
        boolean y;
        boolean z;

        public d(Context context, String str) {
            this.f561b = new ArrayList<>();
            this.f562c = new ArrayList<>();
            this.m = true;
            this.x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.M = 0;
            this.N = new Notification();
            this.f560a = context;
            this.I = str;
            this.N.when = System.currentTimeMillis();
            this.N.audioStreamType = -1;
            this.l = 0;
            this.O = new ArrayList<>();
        }

        public d a(long j2) {
            this.N.when = j2;
            return this;
        }

        public d b(CharSequence charSequence) {
            this.e = a(charSequence);
            return this;
        }

        public d c(CharSequence charSequence) {
            this.d = a(charSequence);
            return this;
        }

        public d d(CharSequence charSequence) {
            this.N.tickerText = a(charSequence);
            return this;
        }

        public d e(int i2) {
            this.N.icon = i2;
            return this;
        }

        public d f(int i2) {
            this.D = i2;
            return this;
        }

        public d a(PendingIntent pendingIntent) {
            this.f = pendingIntent;
            return this;
        }

        public d b(PendingIntent pendingIntent) {
            this.N.deleteIntent = pendingIntent;
            return this;
        }

        public d c(int i2) {
            this.k = i2;
            return this;
        }

        public d d(int i2) {
            this.l = i2;
            return this;
        }

        private Bitmap b(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f560a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d2 = (double) dimensionPixelSize;
            double max = (double) Math.max(1, bitmap.getWidth());
            Double.isNaN(d2);
            Double.isNaN(max);
            double d3 = d2 / max;
            double d4 = (double) dimensionPixelSize2;
            double max2 = (double) Math.max(1, bitmap.getHeight());
            Double.isNaN(d4);
            Double.isNaN(max2);
            double min = Math.min(d3, d4 / max2);
            double width = (double) bitmap.getWidth();
            Double.isNaN(width);
            double height = (double) bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(width * min), (int) Math.ceil(height * min), true);
        }

        public d a(Bitmap bitmap) {
            this.i = b(bitmap);
            return this;
        }

        public d a(Uri uri) {
            Notification notification = this.N;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public d a(long[] jArr) {
            this.N.vibrate = jArr;
            return this;
        }

        public d a(int i2, int i3, int i4) {
            Notification notification = this.N;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            int i5 = (notification.ledOnMS == 0 || notification.ledOffMS == 0) ? 0 : 1;
            Notification notification2 = this.N;
            notification2.flags = i5 | (notification2.flags & -2);
            return this;
        }

        public d b(boolean z2) {
            this.x = z2;
            return this;
        }

        @Deprecated
        public d(Context context) {
            this(context, (String) null);
        }

        public d a(boolean z2) {
            a(16, z2);
            return this;
        }

        public d b(int i2) {
            Notification notification = this.N;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        private void a(int i2, boolean z2) {
            if (z2) {
                Notification notification = this.N;
                notification.flags = i2 | notification.flags;
                return;
            }
            Notification notification2 = this.N;
            notification2.flags = (i2 ^ -1) & notification2.flags;
        }

        public Bundle b() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public d a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f561b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public d a(e eVar) {
            if (this.o != eVar) {
                this.o = eVar;
                e eVar2 = this.o;
                if (eVar2 != null) {
                    eVar2.a(this);
                }
            }
            return this;
        }

        public d a(int i2) {
            this.C = i2;
            return this;
        }

        public d a(String str) {
            this.I = str;
            return this;
        }

        public Notification a() {
            return new i(this).b();
        }

        protected static CharSequence a(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }
    }

    /* compiled from: NotificationCompat */
    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        protected d f563a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f564b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f565c;
        boolean d = false;

        public void a(Bundle bundle) {
        }

        public abstract void a(g gVar);

        public void a(d dVar) {
            if (this.f563a != dVar) {
                this.f563a = dVar;
                d dVar2 = this.f563a;
                if (dVar2 != null) {
                    dVar2.a(this);
                }
            }
        }

        public RemoteViews b(g gVar) {
            return null;
        }

        public RemoteViews c(g gVar) {
            return null;
        }

        public RemoteViews d(g gVar) {
            return null;
        }
    }

    public static Bundle a(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return j.a(notification);
        }
        return null;
    }

    /* compiled from: NotificationCompat */
    public static class b extends e {
        private Bitmap e;
        private Bitmap f;
        private boolean g;

        public b a(Bitmap bitmap) {
            this.f = bitmap;
            this.g = true;
            return this;
        }

        public b b(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public void a(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(gVar.a()).setBigContentTitle(this.f564b).bigPicture(this.e);
                if (this.g) {
                    bigPicture.bigLargeIcon(this.f);
                }
                if (this.d) {
                    bigPicture.setSummaryText(this.f565c);
                }
            }
        }
    }
}
