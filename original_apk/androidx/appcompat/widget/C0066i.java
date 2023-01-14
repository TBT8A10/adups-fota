package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.utils.CharsetNames;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.appcompat.widget.i  reason: case insensitive filesystem */
/* compiled from: ActivityChooserModel */
class C0066i extends DataSetObservable {

    /* renamed from: a  reason: collision with root package name */
    static final String f427a = "i";

    /* renamed from: b  reason: collision with root package name */
    private static final Object f428b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, C0066i> f429c = new HashMap();
    private final Object d;
    private final List<b> e;
    private final List<d> f;
    final Context g;
    final String h;
    private Intent i;
    private c j;
    private int k;
    boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private e p;

    /* renamed from: androidx.appcompat.widget.i$a */
    /* compiled from: ActivityChooserModel */
    public interface a {
    }

    /* renamed from: androidx.appcompat.widget.i$b */
    /* compiled from: ActivityChooserModel */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final ResolveInfo f430a;

        /* renamed from: b  reason: collision with root package name */
        public float f431b;

        public b(ResolveInfo resolveInfo) {
            this.f430a = resolveInfo;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            return Float.floatToIntBits(bVar.f431b) - Float.floatToIntBits(this.f431b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && b.class == obj.getClass() && Float.floatToIntBits(this.f431b) == Float.floatToIntBits(((b) obj).f431b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f431b) + 31;
        }

        public String toString() {
            return "[" + "resolveInfo:" + this.f430a.toString() + "; weight:" + new BigDecimal((double) this.f431b) + "]";
        }
    }

    /* renamed from: androidx.appcompat.widget.i$c */
    /* compiled from: ActivityChooserModel */
    public interface c {
        void sort(Intent intent, List<b> list, List<d> list2);
    }

    /* renamed from: androidx.appcompat.widget.i$d */
    /* compiled from: ActivityChooserModel */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f432a;

        /* renamed from: b  reason: collision with root package name */
        public final long f433b;

        /* renamed from: c  reason: collision with root package name */
        public final float f434c;

        public d(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            ComponentName componentName = this.f432a;
            if (componentName == null) {
                if (dVar.f432a != null) {
                    return false;
                }
            } else if (!componentName.equals(dVar.f432a)) {
                return false;
            }
            return this.f433b == dVar.f433b && Float.floatToIntBits(this.f434c) == Float.floatToIntBits(dVar.f434c);
        }

        public int hashCode() {
            ComponentName componentName = this.f432a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.f433b;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.f434c);
        }

        public String toString() {
            return "[" + "; activity:" + this.f432a + "; time:" + this.f433b + "; weight:" + new BigDecimal((double) this.f434c) + "]";
        }

        public d(ComponentName componentName, long j, float f) {
            this.f432a = componentName;
            this.f433b = j;
            this.f434c = f;
        }
    }

    /* renamed from: androidx.appcompat.widget.i$e */
    /* compiled from: ActivityChooserModel */
    public interface e {
        boolean a(C0066i iVar, Intent intent);
    }

    /* renamed from: androidx.appcompat.widget.i$f */
    /* compiled from: ActivityChooserModel */
    private final class f extends AsyncTask<Object, Void, Void> {
        f() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006d, code lost:
            if (r15 != null) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0092, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b2, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d2, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                java.lang.String r2 = "Error writing historical record file: "
                r3 = 0
                r4 = r15[r3]
                java.util.List r4 = (java.util.List) r4
                r5 = 1
                r15 = r15[r5]
                java.lang.String r15 = (java.lang.String) r15
                r6 = 0
                androidx.appcompat.widget.i r7 = androidx.appcompat.widget.C0066i.this     // Catch:{ FileNotFoundException -> 0x00e0 }
                android.content.Context r7 = r7.g     // Catch:{ FileNotFoundException -> 0x00e0 }
                java.io.FileOutputStream r15 = r7.openFileOutput(r15, r3)     // Catch:{ FileNotFoundException -> 0x00e0 }
                org.xmlpull.v1.XmlSerializer r7 = android.util.Xml.newSerializer()
                r7.setOutput(r15, r6)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r8 = "UTF-8"
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startDocument(r8, r9)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                int r8 = r4.size()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r9 = 0
            L_0x0031:
                if (r9 >= r8) goto L_0x0063
                java.lang.Object r10 = r4.remove(r3)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                androidx.appcompat.widget.i$d r10 = (androidx.appcompat.widget.C0066i.d) r10     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "activity"
                android.content.ComponentName r12 = r10.f432a     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r12 = r12.flattenToString()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "time"
                long r12 = r10.f433b     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "weight"
                float r10 = r10.f434c     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r10)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.endTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                int r9 = r9 + 1
                goto L_0x0031
            L_0x0063:
                r7.endTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.endDocument()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                androidx.appcompat.widget.i r0 = androidx.appcompat.widget.C0066i.this
                r0.l = r5
                if (r15 == 0) goto L_0x00d5
            L_0x006f:
                r15.close()     // Catch:{ IOException -> 0x00d5 }
                goto L_0x00d5
            L_0x0073:
                r0 = move-exception
                goto L_0x00d6
            L_0x0075:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0066i.f427a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.i r2 = androidx.appcompat.widget.C0066i.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.h     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.i r0 = androidx.appcompat.widget.C0066i.this
                r0.l = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x0095:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0066i.f427a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.i r2 = androidx.appcompat.widget.C0066i.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.h     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.i r0 = androidx.appcompat.widget.C0066i.this
                r0.l = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x00b5:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0066i.f427a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.i r2 = androidx.appcompat.widget.C0066i.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.h     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.i r0 = androidx.appcompat.widget.C0066i.this
                r0.l = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x00d5:
                return r6
            L_0x00d6:
                androidx.appcompat.widget.i r1 = androidx.appcompat.widget.C0066i.this
                r1.l = r5
                if (r15 == 0) goto L_0x00df
                r15.close()     // Catch:{ IOException -> 0x00df }
            L_0x00df:
                throw r0
            L_0x00e0:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0066i.f427a
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                r3.append(r15)
                java.lang.String r15 = r3.toString()
                android.util.Log.e(r1, r15, r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0066i.f.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private void d() {
        boolean e2 = e() | h();
        g();
        if (e2) {
            j();
            notifyChanged();
        }
    }

    private boolean e() {
        if (!this.o || this.i == null) {
            return false;
        }
        this.o = false;
        this.e.clear();
        List<ResolveInfo> queryIntentActivities = this.g.getPackageManager().queryIntentActivities(this.i, 0);
        int size = queryIntentActivities.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.e.add(new b(queryIntentActivities.get(i2)));
        }
        return true;
    }

    private void f() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.n) {
            this.n = false;
            if (!TextUtils.isEmpty(this.h)) {
                new f().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f), this.h});
            }
        }
    }

    private void g() {
        int size = this.f.size() - this.k;
        if (size > 0) {
            this.n = true;
            for (int i2 = 0; i2 < size; i2++) {
                d remove = this.f.remove(0);
            }
        }
    }

    private boolean h() {
        if (!this.l || !this.n || TextUtils.isEmpty(this.h)) {
            return false;
        }
        this.l = false;
        this.m = true;
        i();
        return true;
    }

    private void i() {
        try {
            FileInputStream openFileInput = this.g.openFileInput(this.h);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, CharsetNames.UTF_8);
                int i2 = 0;
                while (i2 != 1 && i2 != 2) {
                    i2 = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List<d> list = this.f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new d(newPullParser.getAttributeValue((String) null, "activity"), Long.parseLong(newPullParser.getAttributeValue((String) null, "time")), Float.parseFloat(newPullParser.getAttributeValue((String) null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (XmlPullParserException e2) {
                String str = f427a;
                Log.e(str, "Error reading historical recrod file: " + this.h, e2);
                if (openFileInput == null) {
                }
            } catch (IOException e3) {
                String str2 = f427a;
                Log.e(str2, "Error reading historical recrod file: " + this.h, e3);
                if (openFileInput == null) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    private boolean j() {
        if (this.j == null || this.i == null || this.e.isEmpty() || this.f.isEmpty()) {
            return false;
        }
        this.j.sort(this.i, this.e, Collections.unmodifiableList(this.f));
        return true;
    }

    public int a() {
        int size;
        synchronized (this.d) {
            d();
            size = this.e.size();
        }
        return size;
    }

    public ResolveInfo b(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.d) {
            d();
            resolveInfo = this.e.get(i2).f430a;
        }
        return resolveInfo;
    }

    public void c(int i2) {
        synchronized (this.d) {
            d();
            b bVar = this.e.get(i2);
            b bVar2 = this.e.get(0);
            a(new d(new ComponentName(bVar.f430a.activityInfo.packageName, bVar.f430a.activityInfo.name), System.currentTimeMillis(), bVar2 != null ? (bVar2.f431b - bVar.f431b) + 5.0f : 1.0f));
        }
    }

    public void setOnChooseActivityListener(e eVar) {
        synchronized (this.d) {
            this.p = eVar;
        }
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.d) {
            d();
            List<b> list = this.e;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2).f430a == resolveInfo) {
                    return i2;
                }
            }
            return -1;
        }
    }

    public ResolveInfo b() {
        synchronized (this.d) {
            d();
            if (this.e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = this.e.get(0).f430a;
            return resolveInfo;
        }
    }

    public int c() {
        int size;
        synchronized (this.d) {
            d();
            size = this.f.size();
        }
        return size;
    }

    public Intent a(int i2) {
        synchronized (this.d) {
            if (this.i == null) {
                return null;
            }
            d();
            b bVar = this.e.get(i2);
            ComponentName componentName = new ComponentName(bVar.f430a.activityInfo.packageName, bVar.f430a.activityInfo.name);
            Intent intent = new Intent(this.i);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a_shaKey_method2(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new d(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    private boolean a(d dVar) {
        boolean add = this.f.add(dVar);
        if (add) {
            this.n = true;
            g();
            f();
            j();
            notifyChanged();
        }
        return add;
    }
}
