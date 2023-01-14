package org.greenrobot.eventbus;

import android.util.Log;
import java.io.PrintStream;
import java.util.logging.Level;

/* compiled from: Logger */
public interface i {

    /* compiled from: Logger */
    public static class a implements i {

        /* renamed from: a  reason: collision with root package name */
        static final boolean f2543a;

        /* renamed from: b  reason: collision with root package name */
        private final String f2544b;

        static {
            boolean z = false;
            try {
                if (Class.forName("android.util.Log") != null) {
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            }
            f2543a = z;
        }

        public a(String str) {
            this.f2544b = str;
        }

        public static boolean a() {
            return f2543a;
        }

        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(a(level), this.f2544b, str);
            }
        }

        public void a(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                int a2 = a(level);
                String str2 = this.f2544b;
                Log.println(a2, str2, str + "\n" + Log.getStackTraceString(th));
            }
        }

        /* access modifiers changed from: protected */
        public int a(Level level) {
            int intValue = level.intValue();
            if (intValue < 800) {
                return intValue < 500 ? 2 : 3;
            }
            if (intValue < 900) {
                return 4;
            }
            return intValue < 1000 ? 5 : 6;
        }
    }

    /* compiled from: Logger */
    public static class b implements i {
        public void a(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        public void a(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void a(Level level, String str, Throwable th);
}
