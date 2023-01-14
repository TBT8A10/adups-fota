package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources */
class ha extends L {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f426b;

    public ha(Context context, Resources resources) {
        super(resources);
        this.f426b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f426b.get();
        if (!(drawable == null || context == null)) {
            C0074q.a();
            C0074q.a(context, i, drawable);
        }
        return drawable;
    }
}
