package androidx.viewpager.widget;

/* compiled from: ViewPager */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewPager f1382a;

    f(ViewPager viewPager) {
        this.f1382a = viewPager;
    }

    public void run() {
        this.f1382a.setScrollState(0);
        this.f1382a.e();
    }
}
