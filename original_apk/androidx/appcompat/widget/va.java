package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* compiled from: VectorEnabledTintResources */
public class va extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f477a = false;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f478b;

    public va(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f478b = new WeakReference<>(context);
    }

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    /* access modifiers changed from: package-private */
    public final Drawable a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = (Context) this.f478b.get();
        if (context != null) {
            return C0074q.a().a(context, this, i);
        }
        return super.getDrawable(i);
    }

    public static boolean a() {
        return f477a;
    }
}
