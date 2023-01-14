package com.google.android.gms.common.util;

import java.io.Closeable;
import java.io.IOException;

@Deprecated
public final class g {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
