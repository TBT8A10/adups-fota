package com.google.android.gms.common.util;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

public final class o {
    public static int a(int i) {
        if (i == -1) {
            return -1;
        }
        return i / TarArchiveEntry.MILLIS_PER_SECOND;
    }
}
