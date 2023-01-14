package androidx.core.widget;

/* compiled from: ContentLoadingProgressBar */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ContentLoadingProgressBar f742a;

    d(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f742a = contentLoadingProgressBar;
    }

    public void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f742a;
        contentLoadingProgressBar.f726b = false;
        contentLoadingProgressBar.f725a = -1;
        contentLoadingProgressBar.setVisibility(8);
    }
}
