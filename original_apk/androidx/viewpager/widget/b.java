package androidx.viewpager.widget;

import android.view.View;

/* compiled from: PagerTabStrip */
class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PagerTabStrip f1380a;

    b(PagerTabStrip pagerTabStrip) {
        this.f1380a = pagerTabStrip;
    }

    public void onClick(View view) {
        ViewPager viewPager = this.f1380a.f1362c;
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }
}
