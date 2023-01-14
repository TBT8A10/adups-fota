package androidx.core.app;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

/* compiled from: SharedElementCallback */
public abstract class l {

    /* compiled from: SharedElementCallback */
    public interface a {
    }

    public abstract Parcelable a(View view, Matrix matrix, RectF rectF);

    public abstract View a(Context context, Parcelable parcelable);

    public abstract void a(List<View> list);

    public abstract void a(List<String> list, List<View> list2, a aVar);

    public abstract void a(List<String> list, List<View> list2, List<View> list3);

    public abstract void a(List<String> list, Map<String, View> map);

    public abstract void b(List<String> list, List<View> list2, List<View> list3);
}
