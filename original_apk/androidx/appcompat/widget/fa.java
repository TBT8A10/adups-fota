package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper */
public class fa extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f420a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<WeakReference<fa>> f421b;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f422c;
    private final Resources.Theme d;

    private fa(Context context) {
        super(context);
        if (va.b()) {
            this.f422c = new va(this, context.getResources());
            this.d = this.f422c.newTheme();
            this.d.setTo(context.getTheme());
            return;
        }
        this.f422c = new ha(this, context.getResources());
        this.d = null;
    }

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (f420a) {
            if (f421b == null) {
                f421b = new ArrayList<>();
            } else {
                for (int size = f421b.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f421b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f421b.remove(size);
                    }
                }
                for (int size2 = f421b.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f421b.get(size2);
                    fa faVar = weakReference2 != null ? (fa) weakReference2.get() : null;
                    if (faVar != null && faVar.getBaseContext() == context) {
                        return faVar;
                    }
                }
            }
            fa faVar2 = new fa(context);
            f421b.add(new WeakReference(faVar2));
            return faVar2;
        }
    }

    private static boolean b(Context context) {
        if ((context instanceof fa) || (context.getResources() instanceof ha) || (context.getResources() instanceof va)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21 || va.b()) {
            return true;
        }
        return false;
    }

    public AssetManager getAssets() {
        return this.f422c.getAssets();
    }

    public Resources getResources() {
        return this.f422c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.d;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i) {
        Resources.Theme theme = this.d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
