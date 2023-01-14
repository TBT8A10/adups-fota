package b.a.a.a.a;

import android.os.IBinder;
import android.os.IInterface;
import b.a.a.a.b.a.b;

public interface a extends IInterface {

    /* renamed from: b.a.a.a.a.a$a  reason: collision with other inner class name */
    public static abstract class C0025a extends b implements a {

        /* renamed from: b.a.a.a.a.a$a$a  reason: collision with other inner class name */
        public static class C0026a extends b.a.a.a.b.a.a implements a {
            C0026a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public C0025a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof a) {
                return (a) queryLocalInterface;
            }
            return new C0026a(iBinder);
        }
    }
}
