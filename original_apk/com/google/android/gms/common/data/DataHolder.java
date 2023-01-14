package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private static final a f1800a = new b(new String[0], (String) null);

    /* renamed from: b  reason: collision with root package name */
    private final int f1801b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f1802c;
    private Bundle d;
    private final CursorWindow[] e;
    private final int f;
    private final Bundle g;
    private int[] h;
    private int i;
    private boolean j = false;
    private boolean k = true;

    DataHolder(int i2, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.f1801b = i2;
        this.f1802c = strArr;
        this.e = cursorWindowArr;
        this.f = i3;
        this.g = bundle;
    }

    public final void close() {
        synchronized (this) {
            if (!this.j) {
                this.j = true;
                for (CursorWindow close : this.e) {
                    close.close();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            if (this.k && this.e.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.j;
        }
        return z;
    }

    public final Bundle m() {
        return this.g;
    }

    public final int n() {
        return this.f;
    }

    public final void o() {
        this.d = new Bundle();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = this.f1802c;
            if (i3 >= strArr.length) {
                break;
            }
            this.d.putInt(strArr[i3], i3);
            i3++;
        }
        this.h = new int[this.e.length];
        int i4 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.e;
            if (i2 < cursorWindowArr.length) {
                this.h[i2] = i4;
                i4 += this.e[i2].getNumRows() - (i4 - cursorWindowArr[i2].getStartPosition());
                i2++;
            } else {
                this.i = i4;
                return;
            }
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1802c, false);
        b.a(parcel, 2, (T[]) this.e, i2, false);
        b.a(parcel, 3, n());
        b.a(parcel, 4, m(), false);
        b.a(parcel, (int) TarArchiveEntry.MILLIS_PER_SECOND, this.f1801b);
        b.a_shaKey_method2(parcel, a2);
        if ((i2 & 1) != 0) {
            close();
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String[] f1803a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<HashMap<String, Object>> f1804b;

        /* renamed from: c  reason: collision with root package name */
        private final String f1805c;
        private final HashMap<Object, Integer> d;
        private boolean e;
        private String f;

        private a(String[] strArr, String str) {
            C0178t.a(strArr);
            this.f1803a = strArr;
            this.f1804b = new ArrayList<>();
            this.f1805c = str;
            this.d = new HashMap<>();
            this.e = false;
            this.f = null;
        }

        /* synthetic */ a(String[] strArr, String str, b bVar) {
            this(strArr, (String) null);
        }
    }
}
