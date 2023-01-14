package androidx.appcompat.widget;

import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.v;

/* compiled from: DecorContentParent */
public interface C {
    void a(Menu menu, v.a aVar);

    boolean canShowOverflowMenu();

    void dismissPopups();

    boolean hideOverflowMenu();

    void initFeature(int i);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void setMenuPrepared();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    boolean showOverflowMenu();
}
