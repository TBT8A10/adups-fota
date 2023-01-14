package c.a.a.e;

import c.a.a.b.a;
import c.a.a.c.f;
import c.a.a.c.j;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: Zip4jUtil */
public class b {
    public static boolean a(String str) throws a {
        if (c(str)) {
            return a(new File(str));
        }
        throw new a("path is null");
    }

    public static boolean b(String str) throws a {
        if (!c(str)) {
            throw new a("path is null");
        } else if (a(str)) {
            try {
                return new File(str).canRead();
            } catch (Exception unused) {
                throw new a("cannot read zip file");
            }
        } else {
            StringBuffer stringBuffer = new StringBuffer("file does not exist: ");
            stringBuffer.append(str);
            throw new a(stringBuffer.toString());
        }
    }

    public static boolean c(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean a(File file) throws a {
        if (file != null) {
            return file.exists();
        }
        throw new a("cannot check if file exists: input file is null");
    }

    public static f a(j jVar, String str) throws a {
        if (jVar == null) {
            StringBuffer stringBuffer = new StringBuffer("zip model is null, cannot determine file header for fileName: ");
            stringBuffer.append(str);
            throw new a(stringBuffer.toString());
        } else if (c(str)) {
            f b2 = b(jVar, str);
            if (b2 != null) {
                return b2;
            }
            String replaceAll = str.replaceAll("\\\\", "/");
            f b3 = b(jVar, replaceAll);
            return b3 == null ? b(jVar, replaceAll.replaceAll("/", "\\\\")) : b3;
        } else {
            StringBuffer stringBuffer2 = new StringBuffer("file name is null, cannot determine file header for fileName: ");
            stringBuffer2.append(str);
            throw new a(stringBuffer2.toString());
        }
    }

    public static f b(j jVar, String str) throws a {
        if (jVar == null) {
            StringBuffer stringBuffer = new StringBuffer("zip model is null, cannot determine file header with exact match for fileName: ");
            stringBuffer.append(str);
            throw new a(stringBuffer.toString());
        } else if (!c(str)) {
            StringBuffer stringBuffer2 = new StringBuffer("file name is null, cannot determine file header with exact match for fileName: ");
            stringBuffer2.append(str);
            throw new a(stringBuffer2.toString());
        } else if (jVar.a() == null) {
            StringBuffer stringBuffer3 = new StringBuffer("central directory is null, cannot determine file header with exact match for fileName: ");
            stringBuffer3.append(str);
            throw new a(stringBuffer3.toString());
        } else if (jVar.a().a() == null) {
            StringBuffer stringBuffer4 = new StringBuffer("file Headers are null, cannot determine file header with exact match for fileName: ");
            stringBuffer4.append(str);
            throw new a(stringBuffer4.toString());
        } else if (jVar.a().a().size() <= 0) {
            return null;
        } else {
            ArrayList a2 = jVar.a().a();
            for (int i = 0; i < a2.size(); i++) {
                f fVar = (f) a2.get(i);
                String e = fVar.e();
                if (c(e) && str.equalsIgnoreCase(e)) {
                    return fVar;
                }
            }
            return null;
        }
    }

    public static String a(byte[] bArr, boolean z) {
        if (!z) {
            return a(bArr);
        }
        try {
            return new String(bArr, "UTF8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static String a(byte[] bArr) {
        try {
            return new String(bArr, "Cp850");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }
}
