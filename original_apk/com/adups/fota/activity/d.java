package com.adups.fota.activity;

import android.widget.AbsListView;

/* compiled from: FileBrowserActivity */
class d implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FileBrowserActivity f1523a;

    d(FileBrowserActivity fileBrowserActivity) {
        this.f1523a = fileBrowserActivity;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            int unused = FileBrowserActivity.f1503a = this.f1523a.d.getFirstVisiblePosition();
        }
    }
}
