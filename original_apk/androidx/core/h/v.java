package androidx.core.h;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.R$id;

/* compiled from: ViewGroupCompat */
public final class v {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(R$id.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && t.q(viewGroup) == null) ? false : true;
    }
}
