package androidx.core.g;

import android.util.Log;
import java.io.Writer;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: LogWriter */
public class b extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f659a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f660b = new StringBuilder(CpioConstants.C_IWUSR);

    public b(String str) {
        this.f659a = str;
    }

    private void l() {
        if (this.f660b.length() > 0) {
            Log.d(this.f659a, this.f660b.toString());
            StringBuilder sb = this.f660b;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        l();
    }

    public void flush() {
        l();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == 10) {
                l();
            } else {
                this.f660b.append(c2);
            }
        }
    }
}
