package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.w;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MediaBrowserServiceCompatApi26 */
class x {

    /* renamed from: a  reason: collision with root package name */
    static Field f998a;

    /* compiled from: MediaBrowserServiceCompatApi26 */
    static class a extends w.a {
        a(Context context, c cVar) {
            super(context, cVar);
        }

        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((c) this.f996a).a(str, new b(result), bundle);
        }
    }

    /* compiled from: MediaBrowserServiceCompatApi26 */
    public interface c extends w.b {
        void a(String str, b bVar, Bundle bundle);
    }

    static {
        try {
            f998a = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            f998a.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.w("MBSCompatApi26", e);
        }
    }

    public static Object a(Context context, c cVar) {
        return new a(context, cVar);
    }

    /* compiled from: MediaBrowserServiceCompatApi26 */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        MediaBrowserService.Result f999a;

        b(MediaBrowserService.Result result) {
            this.f999a = result;
        }

        public void a(List<Parcel> list, int i) {
            try {
                x.f998a.setInt(this.f999a, i);
            } catch (IllegalAccessException e) {
                Log.w("MBSCompatApi26", e);
            }
            this.f999a.sendResult(a(list));
        }

        /* access modifiers changed from: package-private */
        public List<MediaBrowser.MediaItem> a(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel next : list) {
                next.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(next));
                next.recycle();
            }
            return arrayList;
        }
    }
}
