package androidx.appcompat.d;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

/* compiled from: ContextThemeWrapper */
public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f183a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f184b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f185c;
    private Configuration d;
    private Resources e;

    public d() {
        super((Context) null);
    }

    private Resources a() {
        if (this.e == null) {
            Configuration configuration = this.d;
            if (configuration == null) {
                this.e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.e;
    }

    private void b() {
        boolean z = this.f184b == null;
        if (z) {
            this.f184b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f184b.setTo(theme);
            }
        }
        a(this.f184b, this.f183a, z);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return a();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f185c == null) {
            this.f185c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f185c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f184b;
        if (theme != null) {
            return theme;
        }
        if (this.f183a == 0) {
            this.f183a = R$style.Theme_AppCompat_Light;
        }
        b();
        return this.f184b;
    }

    public int getThemeResId() {
        return this.f183a;
    }

    public void setTheme(int i) {
        if (this.f183a != i) {
            this.f183a = i;
            b();
        }
    }

    public d(Context context, int i) {
        super(context);
        this.f183a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f184b = theme;
    }

    /* access modifiers changed from: protected */
    public void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }
}
