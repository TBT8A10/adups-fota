package androidx.core.widget;

/* compiled from: ContentLoadingProgressBar */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ContentLoadingProgressBar f743a;

    e(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f743a = contentLoadingProgressBar;
    }

    public void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f743a;
        contentLoadingProgressBar.f727c = false;
        if (!contentLoadingProgressBar.d) {
            contentLoadingProgressBar.f725a = System.currentTimeMillis();
            this.f743a.setVisibility(0);
        }
    }
}
