package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import java.lang.reflect.Method;

public class MenuPopupWindow extends ListPopupWindow implements K {
    private static Method K;
    private K L;

    public static class MenuDropDownListView extends F {
        final int g;
        final int h;
        private K i;
        private MenuItem j;

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.g = 22;
                this.h = 21;
                return;
            }
            this.g = 21;
            this.h = 22;
        }

        public /* bridge */ /* synthetic */ int a(int i2, int i3, int i4, int i5, int i6) {
            return super.a(i2, i3, i4, i5, i6);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int i2, boolean z) {
            return super.lookForSelectablePosition(i2, z);
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i2;
            k kVar;
            int pointToPosition;
            int i3;
            if (this.i != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i2 = headerViewListAdapter.getHeadersCount();
                    kVar = (k) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i2 = 0;
                    kVar = (k) adapter;
                }
                p pVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i3 = pointToPosition - i2) >= 0 && i3 < kVar.getCount()) {
                    pVar = kVar.getItem(i3);
                }
                MenuItem menuItem = this.j;
                if (menuItem != pVar) {
                    l b2 = kVar.b();
                    if (menuItem != null) {
                        this.i.b(b2, menuItem);
                    }
                    this.j = pVar;
                    if (pVar != null) {
                        this.i.a_shaKey_method2(b2, pVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.g) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i2 != this.h) {
                return super.onKeyDown(i2, keyEvent);
            } else {
                setSelection(-1);
                ((k) getAdapter()).b().a(false);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(K k) {
            this.i = k;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public /* bridge */ /* synthetic */ boolean a(MotionEvent motionEvent, int i2) {
            return super.a_shaKey_method2(motionEvent, i2);
        }
    }

    static {
        try {
            K = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: package-private */
    public F a(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.J.setExitTransition((Transition) obj);
        }
    }

    public void c(boolean z) {
        Method method = K;
        if (method != null) {
            try {
                method.invoke(this.J, new Object[]{Boolean.valueOf(z)});
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.J.setEnterTransition((Transition) obj);
        }
    }

    public void b(l lVar, MenuItem menuItem) {
        K k = this.L;
        if (k != null) {
            k.b(lVar, menuItem);
        }
    }

    public void a(K k) {
        this.L = k;
    }

    public void a(l lVar, MenuItem menuItem) {
        K k = this.L;
        if (k != null) {
            k.a_shaKey_method2(lVar, menuItem);
        }
    }
}
