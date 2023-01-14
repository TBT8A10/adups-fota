package androidx.viewpager.widget;

import android.view.View;

/* compiled from: PagerTabStrip */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PagerTabStrip f1381a;

    c(PagerTabStrip pagerTabStrip) {
        this.f1381a = pagerTabStrip;
    }

    public void onClick(View view) {
        ViewPager viewPager = this.f1381a.f1362c;
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }
}
