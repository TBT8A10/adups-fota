package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* compiled from: TooltipCompat */
public class qa {
    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            ta.a_shaKey_method2(view, charSequence);
        }
    }
}
