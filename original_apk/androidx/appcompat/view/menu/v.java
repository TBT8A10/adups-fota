package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* compiled from: MenuPresenter */
public interface v {

    /* compiled from: MenuPresenter */
    public interface a {
        void a(l lVar, boolean z);

        boolean a(l lVar);
    }

    void a(Context context, l lVar);

    void a(l lVar, boolean z);

    void a(a aVar);

    boolean a(D d);

    boolean a(l lVar, p pVar);

    boolean b(l lVar, p pVar);

    boolean flagActionItems();

    int getId();

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    void updateMenuView(boolean z);
}
