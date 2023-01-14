package com.google.android.gms.common.server.response;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    public Object a(String str) {
        return null;
    }

    public boolean b(String str) {
        return false;
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
        for (FastJsonResponse.Field next : a().values()) {
            if (b(next)) {
                if (!fastJsonResponse.b(next) || !a(next).equals(fastJsonResponse.a(next))) {
                    return false;
                }
            } else if (fastJsonResponse.b(next)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (FastJsonResponse.Field next : a().values()) {
            if (b(next)) {
                i = (i * 31) + a(next).hashCode();
            }
        }
        return i;
    }
}
