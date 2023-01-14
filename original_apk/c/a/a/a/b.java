package c.a.a.a;

import c.a.a.c.f;
import c.a.a.c.j;
import c.a.a.d.a;
import java.io.File;

/* compiled from: ZipFile */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f1464a;

    /* renamed from: b  reason: collision with root package name */
    private int f1465b;

    /* renamed from: c  reason: collision with root package name */
    private j f1466c;
    private a d;
    private boolean e;
    private String f;

    public b(String str) throws c.a.a.b.a {
        this(new File(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A[SYNTHETIC, Splitter:B:28:0x0058] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() throws c.a.a.b.a {
        /*
            r5 = this;
            java.lang.String r0 = r5.f1464a
            boolean r0 = c.a.a.e.b.a((java.lang.String) r0)
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = r5.f1464a
            boolean r0 = c.a.a.e.b.b(r0)
            if (r0 == 0) goto L_0x0064
            int r0 = r5.f1465b
            r1 = 2
            if (r0 != r1) goto L_0x005c
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0046 }
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0046 }
            java.lang.String r3 = r5.f1464a     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0046 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0046 }
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0046 }
            c.a.a.c.j r0 = r5.f1466c     // Catch:{ FileNotFoundException -> 0x0044 }
            if (r0 != 0) goto L_0x0040
            c.a.a.a.a r0 = new c.a.a.a.a     // Catch:{ FileNotFoundException -> 0x0044 }
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0044 }
            java.lang.String r2 = r5.f     // Catch:{ FileNotFoundException -> 0x0044 }
            c.a.a.c.j r0 = r0.a((java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x0044 }
            r5.f1466c = r0     // Catch:{ FileNotFoundException -> 0x0044 }
            c.a.a.c.j r0 = r5.f1466c     // Catch:{ FileNotFoundException -> 0x0044 }
            if (r0 == 0) goto L_0x0040
            c.a.a.c.j r0 = r5.f1466c     // Catch:{ FileNotFoundException -> 0x0044 }
            java.lang.String r2 = r5.f1464a     // Catch:{ FileNotFoundException -> 0x0044 }
            r0.b((java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x0044 }
        L_0x0040:
            r1.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            return
        L_0x0044:
            r0 = move-exception
            goto L_0x004f
        L_0x0046:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0056
        L_0x004b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x004f:
            c.a.a.b.a r2 = new c.a.a.b.a     // Catch:{ all -> 0x0055 }
            r2.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x0055 }
            throw r2     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception
        L_0x0056:
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ IOException -> 0x005b }
        L_0x005b:
            throw r0
        L_0x005c:
            c.a.a.b.a r0 = new c.a.a.b.a
            java.lang.String r1 = "Invalid mode"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0064:
            c.a.a.b.a r0 = new c.a.a.b.a
            java.lang.String r1 = "no read access for the input zip file"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x006c:
            c.a.a.b.a r0 = new c.a.a.b.a
            java.lang.String r1 = "zip file does not exist"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.a.b.a():void");
    }

    public b(File file) throws c.a.a.b.a {
        if (file != null) {
            this.f1464a = file.getPath();
            this.f1465b = 2;
            this.d = new a();
            this.e = false;
            return;
        }
        throw new c.a.a.b.a("Input zip file parameter is not null", 1);
    }

    public f a(String str) throws c.a.a.b.a {
        if (c.a.a.e.b.c(str)) {
            a();
            j jVar = this.f1466c;
            if (jVar == null || jVar.a() == null) {
                return null;
            }
            return c.a.a.e.b.a(this.f1466c, str);
        }
        throw new c.a.a.b.a("input file name is emtpy or null, cannot get FileHeader");
    }
}
