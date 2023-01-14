package androidx.core.b.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.core.h.C0084b;

/* compiled from: SupportMenuItem */
public interface b extends MenuItem {
    MenuItem a(char c2, int i);

    MenuItem a(ColorStateList colorStateList);

    MenuItem a(PorterDuff.Mode mode);

    b a(C0084b bVar);

    b a(CharSequence charSequence);

    C0084b a();

    MenuItem b(char c2, int i);

    b b(CharSequence charSequence);

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
