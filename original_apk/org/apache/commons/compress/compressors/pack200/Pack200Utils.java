package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Pack200Utils {
    private Pack200Utils() {
    }

    public static void normalize(File file) throws IOException {
        normalize(file, file, (Map<String, String>) null);
    }

    public static void normalize(File file, Map<String, String> map) throws IOException {
        normalize(file, file, map);
    }

    public static void normalize(File file, File file2) throws IOException {
        normalize(file, file2, (Map<String, String>) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.jar.JarOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056 A[SYNTHETIC, Splitter:B:26:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b A[Catch:{ all -> 0x005f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void normalize(java.io.File r5, java.io.File r6, java.util.Map<java.lang.String, java.lang.String> r7) throws java.io.IOException {
        /*
            if (r7 != 0) goto L_0x0007
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
        L_0x0007:
            java.lang.String r0 = "pack.segment.limit"
            java.lang.String r1 = "-1"
            r7.put(r0, r1)
            java.lang.String r0 = "commons-compress"
            java.lang.String r1 = "pack200normalize"
            java.io.File r0 = java.io.File.createTempFile(r0, r1)
            r0.deleteOnExit()
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x005f }
            r1.<init>(r0)     // Catch:{ all -> 0x005f }
            r2 = 0
            java.util.jar.Pack200$Packer r3 = java.util.jar.Pack200.newPacker()     // Catch:{ all -> 0x0053 }
            java.util.SortedMap r4 = r3.properties()     // Catch:{ all -> 0x0053 }
            r4.putAll(r7)     // Catch:{ all -> 0x0053 }
            java.util.jar.JarFile r7 = new java.util.jar.JarFile     // Catch:{ all -> 0x0053 }
            r7.<init>(r5)     // Catch:{ all -> 0x0053 }
            r3.pack(r7, r1)     // Catch:{ all -> 0x0050 }
            r1.close()     // Catch:{ all -> 0x0053 }
            java.util.jar.Pack200$Unpacker r5 = java.util.jar.Pack200.newUnpacker()     // Catch:{ all -> 0x004d }
            java.util.jar.JarOutputStream r1 = new java.util.jar.JarOutputStream     // Catch:{ all -> 0x004d }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x004d }
            r7.<init>(r6)     // Catch:{ all -> 0x004d }
            r1.<init>(r7)     // Catch:{ all -> 0x004d }
            r5.unpack(r0, r1)     // Catch:{ all -> 0x0053 }
            r1.close()     // Catch:{ all -> 0x005f }
            r0.delete()
            return
        L_0x004d:
            r5 = move-exception
            r1 = r2
            goto L_0x0054
        L_0x0050:
            r5 = move-exception
            r2 = r7
            goto L_0x0054
        L_0x0053:
            r5 = move-exception
        L_0x0054:
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x005f }
        L_0x0059:
            if (r1 == 0) goto L_0x005e
            r1.close()     // Catch:{ all -> 0x005f }
        L_0x005e:
            throw r5     // Catch:{ all -> 0x005f }
        L_0x005f:
            r5 = move-exception
            r0.delete()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.pack200.Pack200Utils.normalize(java.io.File, java.io.File, java.util.Map):void");
    }
}
