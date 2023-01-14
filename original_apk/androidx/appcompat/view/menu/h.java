package androidx.appcompat.view.menu;

import android.os.SystemClock;
import android.view.MenuItem;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.K;

/* compiled from: CascadingMenuPopup */
class h implements K {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f229a;

    h(i iVar) {
        this.f229a = iVar;
    }

    public void a(l lVar, MenuItem menuItem) {
        i.a aVar = null;
        this.f229a.h.removeCallbacksAndMessages((Object) null);
        int size = this.f229a.j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (lVar == this.f229a.j.get(i).f233b) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            int i2 = i + 1;
            if (i2 < this.f229a.j.size()) {
                aVar = this.f229a.j.get(i2);
            }
            this.f229a.h.postAtTime(new g(this, aVar, menuItem, lVar), lVar, SystemClock.uptimeMillis() + 200);
        }
    }

    public void b(l lVar, MenuItem menuItem) {
        this.f229a.h.removeCallbacksAndMessages(lVar);
    }
}
