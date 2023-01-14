package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder */
public final class m implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Intent> f572a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f573b;

    /* compiled from: TaskStackBuilder */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private m(Context context) {
        this.f573b = context;
    }

    public static m a(Context context) {
        return new m(context);
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f572a.iterator();
    }

    public m a(Intent intent) {
        this.f572a.add(intent);
        return this;
    }

    public m a(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = f.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f573b.getPackageManager());
            }
            a(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public m a(ComponentName componentName) {
        int size = this.f572a.size();
        try {
            Intent a2 = f.a_shaKey_method2(this.f573b, componentName);
            while (a2 != null) {
                this.f572a.add(size, a2);
                a2 = f.a_shaKey_method2(this.f573b, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (!this.f572a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f572a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!androidx.core.content.a.a(this.f573b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f573b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
