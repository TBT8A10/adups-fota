package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.core.h.z;

/* compiled from: DecorToolbar */
public interface D {
    void a(Menu menu, v.a aVar);

    void a(v.a aVar, l.a aVar2);

    void a(ScrollingTabContainerView scrollingTabContainerView);

    boolean canShowOverflowMenu();

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    int getDisplayOptions();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getTitle();

    ViewGroup getViewGroup();

    boolean hasExpandedActionView();

    boolean hideOverflowMenu();

    void initIndeterminateProgress();

    void initProgress();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void setCollapsible(boolean z);

    void setDisplayOptions(int i);

    void setHomeButtonEnabled(boolean z);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setLogo(int i);

    void setMenuPrepared();

    void setVisibility(int i);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    z setupAnimatorToVisibility(int i, long j);

    boolean showOverflowMenu();
}
