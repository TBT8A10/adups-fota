package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    long f725a;

    /* renamed from: b  reason: collision with root package name */
    boolean f726b;

    /* renamed from: c  reason: collision with root package name */
    boolean f727c;
    boolean d;
    private final Runnable e;
    private final Runnable f;

    public ContentLoadingProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a() {
        removeCallbacks(this.e);
        removeCallbacks(this.f);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f725a = -1;
        this.f726b = false;
        this.f727c = false;
        this.d = false;
        this.e = new d(this);
        this.f = new e(this);
    }
}
