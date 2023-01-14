package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.v;
import androidx.media.w;
import androidx.media.x;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f942a = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: b  reason: collision with root package name */
    private c f943b;

    /* renamed from: c  reason: collision with root package name */
    final a.b.b<IBinder, b> f944c = new a.b.b<>();
    b d;
    final m e = new m();
    MediaSessionCompat.Token f;

    public static final class a {
        public Bundle a() {
            throw null;
        }

        public String b() {
            throw null;
        }
    }

    private class b implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        public final String f945a;

        /* renamed from: b  reason: collision with root package name */
        public final int f946b;

        /* renamed from: c  reason: collision with root package name */
        public final int f947c;
        public final y d;
        public final Bundle e;
        public final k f;
        public final HashMap<String, List<androidx.core.g.d<IBinder, Bundle>>> g = new HashMap<>();
        public a h;

        b(String str, int i2, int i3, Bundle bundle, k kVar) {
            this.f945a = str;
            this.f946b = i2;
            this.f947c = i3;
            this.d = new y(str, i2, i3);
            this.e = bundle;
            this.f = kVar;
        }

        public void binderDied() {
            MediaBrowserServiceCompat.this.e.post(new i(this));
        }
    }

    interface c {
        IBinder a(Intent intent);

        void onCreate();
    }

    class d implements c, v.d {

        /* renamed from: a  reason: collision with root package name */
        final List<Bundle> f948a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        Object f949b;

        /* renamed from: c  reason: collision with root package name */
        Messenger f950c;

        d() {
        }

        public IBinder a(Intent intent) {
            return v.a_shaKey_method2(this.f949b, intent);
        }

        public void b(String str, v.c<List<Parcel>> cVar) {
            MediaBrowserServiceCompat.this.a(str, (i<List<MediaBrowserCompat.MediaItem>>) new j(this, str, cVar));
        }

        public void onCreate() {
            this.f949b = v.a_shaKey_method2((Context) MediaBrowserServiceCompat.this, (v.d) this);
            v.a(this.f949b);
        }

        public v.a a(String str, int i, Bundle bundle) {
            Bundle bundle2;
            IBinder iBinder;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove("extra_client_version");
                this.f950c = new Messenger(MediaBrowserServiceCompat.this.e);
                bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                androidx.core.app.e.a(bundle2, "extra_messenger", this.f950c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    if (extraBinder == null) {
                        iBinder = null;
                    } else {
                        iBinder = extraBinder.asBinder();
                    }
                    androidx.core.app.e.a(bundle2, "extra_session_binder", iBinder);
                } else {
                    this.f948a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.d = new b(str, -1, i, bundle, (k) null);
            a a2 = MediaBrowserServiceCompat.this.a(str, i, bundle);
            MediaBrowserServiceCompat.this.d = null;
            if (a2 == null) {
                return null;
            }
            if (bundle2 == null) {
                a2.a();
                throw null;
            }
            a2.a();
            throw null;
        }
    }

    class e extends d implements w.b {
        e() {
            super();
        }

        public void a(String str, v.c<Parcel> cVar) {
            MediaBrowserServiceCompat.this.b(str, new k(this, str, cVar));
        }

        public void onCreate() {
            this.f949b = w.a_shaKey_method2(MediaBrowserServiceCompat.this, this);
            v.a(this.f949b);
        }
    }

    class f extends e implements x.c {
        f() {
            super();
        }

        public void a(String str, x.b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.a(str, (i<List<MediaBrowserCompat.MediaItem>>) new l(this, str, bVar), bundle);
        }

        public void onCreate() {
            this.f949b = x.a_shaKey_method2(MediaBrowserServiceCompat.this, this);
            v.a(this.f949b);
        }
    }

    class g extends f {
        g() {
            super();
        }
    }

    class h implements c {

        /* renamed from: a  reason: collision with root package name */
        private Messenger f951a;

        h() {
        }

        public IBinder a(Intent intent) {
            if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
                return this.f951a.getBinder();
            }
            return null;
        }

        public void onCreate() {
            this.f951a = new Messenger(MediaBrowserServiceCompat.this.e);
        }
    }

    public static class i<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f953a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f954b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f955c;
        private boolean d;
        private int e;

        i(Object obj) {
            this.f953a = obj;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            this.e = i;
        }

        /* access modifiers changed from: package-private */
        public void a(T t) {
            throw null;
        }

        public void b(T t) {
            if (this.f955c || this.d) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f953a);
            }
            this.f955c = true;
            a(t);
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.e;
        }

        /* access modifiers changed from: package-private */
        public void a(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f953a);
        }

        public void b(Bundle bundle) {
            if (this.f955c || this.d) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f953a);
            }
            this.d = true;
            a(bundle);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f954b || this.f955c || this.d;
        }
    }

    private class j {
        j() {
        }

        public void a(String str, int i, int i2, Bundle bundle, k kVar) {
            if (MediaBrowserServiceCompat.this.a(str, i2)) {
                MediaBrowserServiceCompat.this.e.a(new m(this, kVar, str, i, i2, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + str);
        }

        public void b(k kVar) {
            MediaBrowserServiceCompat.this.e.a(new s(this, kVar));
        }

        public void b(String str, Bundle bundle, ResultReceiver resultReceiver, k kVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.e.a(new u(this, kVar, str, bundle, resultReceiver));
            }
        }

        public void a(k kVar) {
            MediaBrowserServiceCompat.this.e.a(new n(this, kVar));
        }

        public void a(String str, IBinder iBinder, Bundle bundle, k kVar) {
            MediaBrowserServiceCompat.this.e.a(new o(this, kVar, str, iBinder, bundle));
        }

        public void a(String str, IBinder iBinder, k kVar) {
            MediaBrowserServiceCompat.this.e.a(new p(this, kVar, str, iBinder));
        }

        public void a(String str, ResultReceiver resultReceiver, k kVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.e.a(new q(this, kVar, str, resultReceiver));
            }
        }

        public void a(k kVar, String str, int i, int i2, Bundle bundle) {
            MediaBrowserServiceCompat.this.e.a(new r(this, kVar, str, i, i2, bundle));
        }

        public void a(String str, Bundle bundle, ResultReceiver resultReceiver, k kVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.e.a(new t(this, kVar, str, bundle, resultReceiver));
            }
        }
    }

    private interface k {
        void a() throws RemoteException;

        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;

        IBinder asBinder();
    }

    private static class l implements k {

        /* renamed from: a  reason: collision with root package name */
        final Messenger f957a;

        l(Messenger messenger) {
            this.f957a = messenger;
        }

        public void a() throws RemoteException {
            a_shaKey_method2(2, (Bundle) null);
        }

        public IBinder asBinder() {
            return this.f957a.getBinder();
        }

        public void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
            }
            a_shaKey_method2(3, bundle3);
        }

        private void a(int i, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f957a.send(obtain);
        }
    }

    private final class m extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final j f958a = new j();

        m() {
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.f958a.a(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, (k) new l(message.replyTo));
                    return;
                case 2:
                    this.f958a.a(new l(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.f958a.a(data.getString("data_media_item_id"), androidx.core.app.e.a_shaKey_method2(data, "data_callback_token"), bundle2, (k) new l(message.replyTo));
                    return;
                case 4:
                    this.f958a.a(data.getString("data_media_item_id"), androidx.core.app.e.a_shaKey_method2(data, "data_callback_token"), (k) new l(message.replyTo));
                    return;
                case 5:
                    this.f958a.a(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), (k) new l(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    j jVar = this.f958a;
                    l lVar = new l(message.replyTo);
                    jVar.a((k) lVar, data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    return;
                case 7:
                    this.f958a.b(new l(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.f958a.a(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), (k) new l(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.f958a.b(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new l(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: " + 2 + "\n  Client version: " + message.arg1);
                    return;
            }
        }

        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }
    }

    public abstract a a(String str, int i2, Bundle bundle);

    public void a(String str) {
    }

    public void a(String str, Bundle bundle) {
    }

    public abstract void a(String str, i<List<MediaBrowserCompat.MediaItem>> iVar);

    public void a(String str, i<List<MediaBrowserCompat.MediaItem>> iVar, Bundle bundle) {
        iVar.a(1);
        a(str, iVar);
    }

    public void b(String str, i<MediaBrowserCompat.MediaItem> iVar) {
        iVar.a(2);
        iVar.b(null);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public IBinder onBind(Intent intent) {
        return this.f943b.a(intent);
    }

    public void onCreate() {
        super.onCreate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f943b = new g();
        } else if (i2 >= 26) {
            this.f943b = new f();
        } else if (i2 >= 23) {
            this.f943b = new e();
        } else if (i2 >= 21) {
            this.f943b = new d();
        } else {
            this.f943b = new h();
        }
        this.f943b.onCreate();
    }

    public void a(String str, Bundle bundle, i<Bundle> iVar) {
        iVar.b((Bundle) null);
    }

    public void b(String str, Bundle bundle, i<List<MediaBrowserCompat.MediaItem>> iVar) {
        iVar.a(4);
        iVar.b(null);
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i2)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(String str, Bundle bundle, b bVar, ResultReceiver resultReceiver) {
        g gVar = new g(this, str, resultReceiver);
        this.d = bVar;
        b(str, bundle, gVar);
        this.d = null;
        if (!gVar.b()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, b bVar, IBinder iBinder, Bundle bundle) {
        List<androidx.core.g.d> list = bVar.g.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (androidx.core.g.d dVar : list) {
            if (iBinder == dVar.f661a && d.a_shaKey_method2(bundle, (Bundle) dVar.f662b)) {
                return;
            }
        }
        list.add(new androidx.core.g.d(iBinder, bundle));
        bVar.g.put(str, list);
        a(str, bVar, bundle, (Bundle) null);
        this.d = bVar;
        a_shaKey_method2(str, bundle);
        this.d = null;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, b bVar, IBinder iBinder) {
        boolean z = true;
        boolean z2 = false;
        if (iBinder == null) {
            try {
                if (bVar.g.remove(str) == null) {
                    z = false;
                }
                return z;
            } finally {
                this.d = bVar;
                a(str);
                this.d = null;
            }
        } else {
            List list = bVar.g.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == ((androidx.core.g.d) it.next()).f661a) {
                        it.remove();
                        z2 = true;
                    }
                }
                if (list.size() == 0) {
                    bVar.g.remove(str);
                }
            }
            this.d = bVar;
            a(str);
            this.d = null;
            return z2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, b bVar, Bundle bundle, Bundle bundle2) {
        e eVar = new e(this, str, bVar, str, bundle, bundle2);
        this.d = bVar;
        if (bundle == null) {
            a(str, (i<List<MediaBrowserCompat.MediaItem>>) eVar);
        } else {
            a(str, (i<List<MediaBrowserCompat.MediaItem>>) eVar, bundle);
        }
        this.d = null;
        if (!eVar.b()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.f945a + " id=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    public List<MediaBrowserCompat.MediaItem> a(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i2 == -1 && i3 == -1) {
            return list;
        }
        int i4 = i3 * i2;
        int i5 = i4 + i3;
        if (i2 < 0 || i3 < 1 || i4 >= list.size()) {
            return Collections.emptyList();
        }
        if (i5 > list.size()) {
            i5 = list.size();
        }
        return list.subList(i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, b bVar, ResultReceiver resultReceiver) {
        f fVar = new f(this, str, resultReceiver);
        this.d = bVar;
        b(str, fVar);
        this.d = null;
        if (!fVar.b()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, Bundle bundle, b bVar, ResultReceiver resultReceiver) {
        h hVar = new h(this, str, resultReceiver);
        this.d = bVar;
        a(str, bundle, (i<Bundle>) hVar);
        this.d = null;
        if (!hVar.b()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }
}
