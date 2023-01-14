package androidx.core.e;

import a.b.g;
import a.b.i;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.core.e.k;
import androidx.core.g.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: FontsContractCompat */
public class f {

    /* renamed from: a  reason: collision with root package name */
    static final g<String, Typeface> f606a = new g<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final k f607b = new k("fonts", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f608c = new Object();
    static final i<String, ArrayList<k.a<c>>> d = new i<>();
    private static final Comparator<byte[]> e = new e();

    /* compiled from: FontsContractCompat */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f609a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f610b;

        public a(int i, b[] bVarArr) {
            this.f609a = i;
            this.f610b = bVarArr;
        }

        public b[] a() {
            return this.f610b;
        }

        public int b() {
            return this.f609a;
        }
    }

    /* compiled from: FontsContractCompat */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f611a;

        /* renamed from: b  reason: collision with root package name */
        private final int f612b;

        /* renamed from: c  reason: collision with root package name */
        private final int f613c;
        private final boolean d;
        private final int e;

        public b(Uri uri, int i, int i2, boolean z, int i3) {
            h.a(uri);
            this.f611a = uri;
            this.f612b = i;
            this.f613c = i2;
            this.d = z;
            this.e = i3;
        }

        public int a() {
            return this.e;
        }

        public int b() {
            return this.f612b;
        }

        public Uri c() {
            return this.f611a;
        }

        public int d() {
            return this.f613c;
        }

        public boolean e() {
            return this.d;
        }
    }

    /* compiled from: FontsContractCompat */
    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f614a;

        /* renamed from: b  reason: collision with root package name */
        final int f615b;

        c(Typeface typeface, int i) {
            this.f614a = typeface;
            this.f615b = i;
        }
    }

    static c a(Context context, a aVar, int i) {
        try {
            a a2 = a(context, (CancellationSignal) null, aVar);
            int i2 = -3;
            if (a2.b() == 0) {
                Typeface a3 = androidx.core.a.c.a(context, (CancellationSignal) null, a2.a(), i);
                if (a3 != null) {
                    i2 = 0;
                }
                return new c(a3, i2);
            }
            if (a2.b() == 1) {
                i2 = -2;
            }
            return new c((Typeface) null, i2);
        } catch (PackageManager.NameNotFoundException unused) {
            return new c((Typeface) null, -1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0078, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0089, code lost:
        f607b.a(r1, new androidx.core.e.d(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0093, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface a(android.content.Context r2, androidx.core.e.a r3, androidx.core.content.a.h.a r4, android.os.Handler r5, boolean r6, int r7, int r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r3.c()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            a.b.g<java.lang.String, android.graphics.Typeface> r1 = f606a
            java.lang.Object r1 = r1.b(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0028
            if (r4 == 0) goto L_0x0027
            r4.a((android.graphics.Typeface) r1)
        L_0x0027:
            return r1
        L_0x0028:
            if (r6 == 0) goto L_0x0043
            r1 = -1
            if (r7 != r1) goto L_0x0043
            androidx.core.e.f$c r2 = a((android.content.Context) r2, (androidx.core.e.a) r3, (int) r8)
            if (r4 == 0) goto L_0x0040
            int r3 = r2.f615b
            if (r3 != 0) goto L_0x003d
            android.graphics.Typeface r3 = r2.f614a
            r4.a((android.graphics.Typeface) r3, (android.os.Handler) r5)
            goto L_0x0040
        L_0x003d:
            r4.a((int) r3, (android.os.Handler) r5)
        L_0x0040:
            android.graphics.Typeface r2 = r2.f614a
            return r2
        L_0x0043:
            androidx.core.e.b r1 = new androidx.core.e.b
            r1.<init>(r2, r3, r8, r0)
            r2 = 0
            if (r6 == 0) goto L_0x0056
            androidx.core.e.k r3 = f607b     // Catch:{ InterruptedException -> 0x0055 }
            java.lang.Object r3 = r3.a(r1, (int) r7)     // Catch:{ InterruptedException -> 0x0055 }
            androidx.core.e.f$c r3 = (androidx.core.e.f.c) r3     // Catch:{ InterruptedException -> 0x0055 }
            android.graphics.Typeface r2 = r3.f614a     // Catch:{ InterruptedException -> 0x0055 }
        L_0x0055:
            return r2
        L_0x0056:
            if (r4 != 0) goto L_0x005a
            r3 = r2
            goto L_0x005f
        L_0x005a:
            androidx.core.e.c r3 = new androidx.core.e.c
            r3.<init>(r4, r5)
        L_0x005f:
            java.lang.Object r4 = f608c
            monitor-enter(r4)
            a.b.i<java.lang.String, java.util.ArrayList<androidx.core.e.k$a<androidx.core.e.f$c>>> r5 = d     // Catch:{ all -> 0x0094 }
            boolean r5 = r5.containsKey(r0)     // Catch:{ all -> 0x0094 }
            if (r5 == 0) goto L_0x0079
            if (r3 == 0) goto L_0x0077
            a.b.i<java.lang.String, java.util.ArrayList<androidx.core.e.k$a<androidx.core.e.f$c>>> r5 = d     // Catch:{ all -> 0x0094 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x0094 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x0094 }
            r5.add(r3)     // Catch:{ all -> 0x0094 }
        L_0x0077:
            monitor-exit(r4)     // Catch:{ all -> 0x0094 }
            return r2
        L_0x0079:
            if (r3 == 0) goto L_0x0088
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0094 }
            r5.<init>()     // Catch:{ all -> 0x0094 }
            r5.add(r3)     // Catch:{ all -> 0x0094 }
            a.b.i<java.lang.String, java.util.ArrayList<androidx.core.e.k$a<androidx.core.e.f$c>>> r3 = d     // Catch:{ all -> 0x0094 }
            r3.put(r0, r5)     // Catch:{ all -> 0x0094 }
        L_0x0088:
            monitor-exit(r4)     // Catch:{ all -> 0x0094 }
            androidx.core.e.k r3 = f607b
            androidx.core.e.d r4 = new androidx.core.e.d
            r4.<init>(r0)
            r3.a(r1, r4)
            return r2
        L_0x0094:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0094 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.e.f.a(android.content.Context, androidx.core.e.a, androidx.core.content.a.h$a, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    public static Map<Uri, ByteBuffer> a(Context context, b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (b bVar : bVarArr) {
            if (bVar.a() == 0) {
                Uri c2 = bVar.c();
                if (!hashMap.containsKey(c2)) {
                    hashMap.put(c2, androidx.core.a.k.a(context, cancellationSignal, c2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static a a(Context context, CancellationSignal cancellationSignal, a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo a2 = a(context.getPackageManager(), aVar, context.getResources());
        if (a2 == null) {
            return new a(1, (b[]) null);
        }
        return new a(0, a(context, aVar, a2.authority, cancellationSignal));
    }

    public static ProviderInfo a(PackageManager packageManager, a aVar, Resources resources) throws PackageManager.NameNotFoundException {
        String d2 = aVar.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + d2);
        } else if (resolveContentProvider.packageName.equals(aVar.e())) {
            List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, e);
            List<List<byte[]>> a3 = a_shaKey_method2(aVar, resources);
            for (int i = 0; i < a3.size(); i++) {
                ArrayList arrayList = new ArrayList(a3.get(i));
                Collections.sort(arrayList, e);
                if (a(a2, (List<byte[]>) arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + d2 + ", but package was not " + aVar.e());
        }
    }

    private static List<List<byte[]>> a(a aVar, Resources resources) {
        if (aVar.a() != null) {
            return aVar.a();
        }
        return androidx.core.content.a.c.a_shaKey_method2(resources, aVar.b());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    static b[] a(Context context, a aVar, String str, CancellationSignal cancellationSignal) {
        Uri uri;
        Cursor query;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str2).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, (String) null, cancellationSignal);
            } else {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, (String) null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList2.add(new b(uri, i2, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (b[]) arrayList.toArray(new b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
