package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class b {
    public static int a(Parcel parcel) {
        return b(parcel, 20293);
    }

    private static void b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | -65536);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt(i | (i2 << 16));
    }

    private static void c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static void a(Parcel parcel, int i) {
        c(parcel, i);
    }

    public static void a(Parcel parcel, int i, boolean z) {
        b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    private static int b(Parcel parcel, int i) {
        parcel.writeInt(i | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void a(Parcel parcel, int i, int i2) {
        b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void b(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b2 = b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    a(parcel, parcelable, 0);
                }
            }
            c(parcel, b2);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, long j) {
        b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void a(Parcel parcel, int i, float f) {
        b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b2 = b(parcel, i);
            parcel.writeString(str);
            c(parcel, b2);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b2 = b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            c(parcel, b2);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b2 = b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            c(parcel, b2);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b2 = b(parcel, i);
            parcel.writeBundle(bundle);
            c(parcel, b2);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int b2 = b(parcel, i);
            parcel.writeStringArray(strArr);
            c(parcel, b2);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int b2 = b(parcel, i);
            parcel.writeStringList(list);
            c(parcel, b2);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b2 = b(parcel, i);
            parcel.writeInt(r7);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    a(parcel, t, i2);
                }
            }
            c(parcel, b2);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int b2 = b(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            c(parcel, b2);
        } else if (z) {
            b(parcel, i, 0);
        }
    }
}
