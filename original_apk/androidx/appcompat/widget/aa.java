package androidx.appcompat.widget;

import androidx.appcompat.widget.SearchView;

/* compiled from: SearchView */
class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView.SearchAutoComplete f407a;

    aa(SearchView.SearchAutoComplete searchAutoComplete) {
        this.f407a = searchAutoComplete;
    }

    public void run() {
        this.f407a.b();
    }
}
