package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: NotificationCompatBuilder */
class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Notification.Builder f566a;

    /* renamed from: b  reason: collision with root package name */
    private final h.d f567b;

    /* renamed from: c  reason: collision with root package name */
    private RemoteViews f568c;
    private RemoteViews d;
    private final List<Bundle> e = new ArrayList();
    private final Bundle f = new Bundle();
    private int g;
    private RemoteViews h;

    i(h.d dVar) {
        ArrayList<String> arrayList;
        this.f567b = dVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f566a = new Notification.Builder(dVar.f560a, dVar.I);
        } else {
            this.f566a = new Notification.Builder(dVar.f560a);
        }
        Notification notification = dVar.N;
        this.f566a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.d).setContentText(dVar.e).setContentInfo(dVar.j).setContentIntent(dVar.f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.g, (notification.flags & CpioConstants.C_IWUSR) != 0).setLargeIcon(dVar.i).setNumber(dVar.k).setProgress(dVar.r, dVar.s, dVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f566a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f566a.setSubText(dVar.p).setUsesChronometer(dVar.n).setPriority(dVar.l);
            Iterator<h.a> it = dVar.f561b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Bundle bundle = dVar.B;
            if (bundle != null) {
                this.f.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (dVar.x) {
                    this.f.putBoolean("android.support.localOnly", true);
                }
                String str = dVar.u;
                if (str != null) {
                    this.f.putString("android.support.groupKey", str);
                    if (dVar.v) {
                        this.f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = dVar.w;
                if (str2 != null) {
                    this.f.putString("android.support.sortKey", str2);
                }
            }
            this.f568c = dVar.F;
            this.d = dVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f566a.setShowWhen(dVar.m);
            if (Build.VERSION.SDK_INT < 21 && (arrayList = dVar.O) != null && !arrayList.isEmpty()) {
                Bundle bundle2 = this.f;
                ArrayList<String> arrayList2 = dVar.O;
                bundle2.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f566a.setLocalOnly(dVar.x).setGroup(dVar.u).setGroupSummary(dVar.v).setSortKey(dVar.w);
            this.g = dVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f566a.setCategory(dVar.A).setColor(dVar.C).setVisibility(dVar.D).setPublicVersion(dVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = dVar.O.iterator();
            while (it2.hasNext()) {
                this.f566a.addPerson(it2.next());
            }
            this.h = dVar.H;
            if (dVar.f562c.size() > 0) {
                Bundle bundle3 = dVar.b().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle();
                for (int i = 0; i < dVar.f562c.size(); i++) {
                    bundle4.putBundle(Integer.toString(i), j.a(dVar.f562c.get(i)));
                }
                bundle3.putBundle("invisible_actions", bundle4);
                dVar.b().putBundle("android.car.EXTENSIONS", bundle3);
                this.f.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f566a.setExtras(dVar.B).setRemoteInputHistory(dVar.q);
            RemoteViews remoteViews = dVar.F;
            if (remoteViews != null) {
                this.f566a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = dVar.G;
            if (remoteViews2 != null) {
                this.f566a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.H;
            if (remoteViews3 != null) {
                this.f566a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f566a.setBadgeIconType(dVar.J).setShortcutId(dVar.K).setTimeoutAfter(dVar.L).setGroupAlertBehavior(dVar.M);
            if (dVar.z) {
                this.f566a.setColorized(dVar.y);
            }
            if (!TextUtils.isEmpty(dVar.I)) {
                this.f566a.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
    }

    public Notification.Builder a() {
        return this.f566a;
    }

    public Notification b() {
        Bundle a2;
        RemoteViews d2;
        RemoteViews b2;
        h.e eVar = this.f567b.o;
        if (eVar != null) {
            eVar.a((g) this);
        }
        RemoteViews c2 = eVar != null ? eVar.c(this) : null;
        Notification c3 = c();
        if (c2 != null) {
            c3.contentView = c2;
        } else {
            RemoteViews remoteViews = this.f567b.F;
            if (remoteViews != null) {
                c3.contentView = remoteViews;
            }
        }
        if (!(Build.VERSION.SDK_INT < 16 || eVar == null || (b2 = eVar.b(this)) == null)) {
            c3.bigContentView = b2;
        }
        if (!(Build.VERSION.SDK_INT < 21 || eVar == null || (d2 = this.f567b.o.d(this)) == null)) {
            c3.headsUpContentView = d2;
        }
        if (!(Build.VERSION.SDK_INT < 16 || eVar == null || (a2 = h.a(c3)) == null)) {
            eVar.a(a2);
        }
        return c3;
    }

    /* access modifiers changed from: protected */
    public Notification c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.f566a.build();
        }
        if (i >= 24) {
            Notification build = this.f566a.build();
            if (this.g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.g != 2)) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.g == 1) {
                    a(build);
                }
            }
            return build;
        } else if (i >= 21) {
            this.f566a.setExtras(this.f);
            Notification build2 = this.f566a.build();
            RemoteViews remoteViews = this.f568c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.g != 2)) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.g == 1) {
                    a(build2);
                }
            }
            return build2;
        } else if (i >= 20) {
            this.f566a.setExtras(this.f);
            Notification build3 = this.f566a.build();
            RemoteViews remoteViews4 = this.f568c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.g != 2)) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.g == 1) {
                    a(build3);
                }
            }
            return build3;
        } else if (i >= 19) {
            SparseArray<Bundle> a2 = j.a(this.e);
            if (a2 != null) {
                this.f.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f566a.setExtras(this.f);
            Notification build4 = this.f566a.build();
            RemoteViews remoteViews6 = this.f568c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i < 16) {
            return this.f566a.getNotification();
        } else {
            Notification build5 = this.f566a.build();
            Bundle a3 = h.a(build5);
            Bundle bundle = new Bundle(this.f);
            for (String str : this.f.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = j.a(this.e);
            if (a4 != null) {
                h.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.f568c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }

    private void a(h.a aVar) {
        Bundle bundle;
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            Notification.Action.Builder builder = new Notification.Action.Builder(aVar.e(), aVar.i(), aVar.a());
            if (aVar.f() != null) {
                for (RemoteInput addRemoteInput : k.a(aVar.f())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (aVar.d() != null) {
                bundle = new Bundle(aVar.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.b());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
            builder.addExtras(bundle);
            this.f566a.addAction(builder.build());
        } else if (i >= 16) {
            this.e.add(j.a_shaKey_method2(this.f566a, aVar));
        }
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
