package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f1797a;

    /* renamed from: b  reason: collision with root package name */
    private ParcelFileDescriptor f1798b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1799c;
    private Bitmap d = null;
    private boolean e = false;
    private File f;

    BitmapTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor, int i2) {
        this.f1797a = i;
        this.f1798b = parcelFileDescriptor;
        this.f1799c = i2;
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("BitmapTeleporter", "Could not close stream", e2);
        }
    }

    private final FileOutputStream m() {
        File file = this.f;
        if (file != null) {
            try {
                File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    this.f1798b = ParcelFileDescriptor.open(createTempFile, 268435456);
                    createTempFile.delete();
                    return fileOutputStream;
                } catch (FileNotFoundException unused) {
                    throw new IllegalStateException("Temporary file is somehow already deleted");
                }
            } catch (IOException e2) {
                throw new IllegalStateException("Could not create temporary file", e2);
            }
        } else {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f1798b == null) {
            Bitmap bitmap = this.d;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(m()));
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                a(dataOutputStream);
            } catch (IOException e2) {
                throw new IllegalStateException("Could not write into unlinked file", e2);
            } catch (Throwable th) {
                a(dataOutputStream);
                throw th;
            }
        }
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1797a);
        b.a(parcel, 2, (Parcelable) this.f1798b, i | 1, false);
        b.a(parcel, 3, this.f1799c);
        b.a_shaKey_method2(parcel, a2);
        this.f1798b = null;
    }
}
