package com.adups.fota.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StatFs;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.C0215R$mipmap;
import com.adups.fota.C0216R$string;
import com.adups.fota.a.a;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.c;
import com.adups.fota.utils.d;
import com.adups.fota.utils.o;
import com.adups.fota.utils.t;
import com.adups.fota.view.TitleView;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.e;

public class SdcardUpdateActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f1514a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1515b;

    /* renamed from: c  reason: collision with root package name */
    Button f1516c;
    TextView d;
    /* access modifiers changed from: private */
    public String e;
    /* access modifiers changed from: private */
    public Handler f = new p(this);

    /* access modifiers changed from: private */
    public void f() {
        d.a((Context) this, (int) C0214R$layout.dialog_loading_copy_file, (DialogInterface.OnDismissListener) null);
    }

    /* access modifiers changed from: private */
    public void g() {
        LogUtil.a("doUpdate : selected_file " + this.e);
        com.adups.fota.b.d.a_shaKey_method2((Context) this, 0);
        o.b((Context) this, "ota_update_local", true);
        o.b((Context) this, "ota_update_local_path", this.e);
        com.adups.fota.d.d.a_shaKey_method2((Context) this, this.e);
    }

    public void initWidget() {
        setContentView(C0214R$layout.activity_sdcard_update);
        if (f1514a == null) {
            f1514a = Executors.newFixedThreadPool(3);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.e = extras.getString("selected_file");
        }
        LogUtil.a("selected_file = " + this.e);
        c();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f1515b = false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (e.a().a((Object) this)) {
            e.a().d(this);
        }
        super.onDestroy();
        this.f.removeCallbacksAndMessages((Object) null);
        closeDialog();
    }

    @org.greenrobot.eventbus.o(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage eventMessage) {
        if (eventMessage.getWhat() == 300) {
            a(eventMessage);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        if (f1515b) {
            f();
        }
    }

    /* access modifiers changed from: protected */
    public void setTitleView(TitleView titleView) {
    }

    public void widgetClick(View view) {
        if (((Integer) view.getTag()).intValue() == 2131230897) {
            LogUtil.a("onItemClick, install now");
            e();
        }
    }

    private void c() {
        TextView textView = (TextView) findViewById(C0211R$id.sdcard_update_file_name);
        String str = this.e;
        if (str != null) {
            File file = new File(str);
            textView.setText(getString(C0216R$string.selected_update_zip) + file.getName());
        }
        this.d = (TextView) findViewById(C0211R$id.sdcard_update_webview);
        this.d.setText(Html.fromHtml(getString(C0216R$string.sdCard_update_tips_content)));
        this.f1516c = (Button) findViewById(C0211R$id.sdcard_update_install);
        if (c.j().w()) {
            this.f1516c.requestFocus();
        }
        this.f1516c.setTag(Integer.valueOf(C0211R$id.sdcard_update_install));
        this.f1516c.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void d() {
        File file = new File(this.e);
        if (!file.exists()) {
            d.a((Context) this, getString(C0216R$string.sdCard_upgrade_find_update_file_fail), getString(C0216R$string.sdCard_upgrade_copy_file_fail_prompt));
        } else if (!b()) {
            d.a((Context) this, getString(C0216R$string.not_support_fota_title), getString(C0216R$string.unmount_sdcard));
        } else if (b(this.e)) {
            File file2 = new File(file.getParent() + "/LocalSdUpdate.zip");
            if (Build.VERSION.SDK_INT < 23 && file.renameTo(file2)) {
                this.e = file2.getAbsolutePath();
            }
            this.f.sendEmptyMessage(2);
        } else if (a(file.length(), a(this.e))) {
            f1514a.execute(new r(this));
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    private void e() {
        if (!e.a().a((Object) this)) {
            e.a().c(this);
        }
        int a2 = c.j().a();
        if (!com.adups.fota.d.d.a_shaKey_method2((Context) this, a2)) {
            d.a((Context) this, (int) C0215R$mipmap.ota_battery, getString(C0216R$string.ota_battery_low, new Object[]{Integer.valueOf(a2)}));
            return;
        }
        d.a((Context) this, getString(C0216R$string.not_support_fota_title), getString(C0216R$string.sdcard_update_prompt), (a) new q(this));
    }

    private boolean b() {
        try {
            return t.b(a(this.e)).equals("mounted");
        } catch (Exception e2) {
            LogUtil.b("getSdcardAvailable error " + e2.toString());
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r12, java.lang.String r13, java.lang.Boolean r14) {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "copy, oldPath = "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.adups.fota.utils.LogUtil.a((java.lang.String) r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "copy, newPath = "
            r0.append(r2)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            com.adups.fota.utils.LogUtil.a((java.lang.String) r0)
            r0 = 1
            f1515b = r0
            r3 = 2
            r4 = 0
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00d9 }
            r5.<init>(r13)     // Catch:{ Exception -> 0x00d9 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x00d9 }
            r6.<init>(r12)     // Catch:{ Exception -> 0x00d9 }
            boolean r7 = r5.exists()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r8 = " is not exist!"
            if (r7 == 0) goto L_0x0043
            r5.delete()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x0058
        L_0x0043:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9 }
            r5.<init>()     // Catch:{ Exception -> 0x00d9 }
            r5.append(r2)     // Catch:{ Exception -> 0x00d9 }
            r5.append(r13)     // Catch:{ Exception -> 0x00d9 }
            r5.append(r8)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x00d9 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00d9 }
        L_0x0058:
            boolean r2 = r6.exists()     // Catch:{ Exception -> 0x00d9 }
            if (r2 == 0) goto L_0x00be
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00d9 }
            r1.<init>(r12)     // Catch:{ Exception -> 0x00d9 }
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00d9 }
            r12.<init>(r13)     // Catch:{ Exception -> 0x00d9 }
            r13 = 32768(0x8000, float:4.5918E-41)
            byte[] r13 = new byte[r13]     // Catch:{ Exception -> 0x00d9 }
            r7 = 0
        L_0x006f:
            int r2 = r1.read(r13)     // Catch:{ Exception -> 0x00d9 }
            r5 = -1
            if (r2 == r5) goto L_0x008d
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x00d9 }
            boolean r5 = r5.isInterrupted()     // Catch:{ Exception -> 0x00d9 }
            if (r5 == 0) goto L_0x0082
            r13 = 1
            goto L_0x008e
        L_0x0082:
            long r9 = (long) r2     // Catch:{ Exception -> 0x00d9 }
            long r7 = r7 + r9
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ Exception -> 0x00d9 }
            r5.println(r7)     // Catch:{ Exception -> 0x00d9 }
            r12.write(r13, r4, r2)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x006f
        L_0x008d:
            r13 = 0
        L_0x008e:
            r1.close()     // Catch:{ Exception -> 0x00bc }
            r12.close()     // Catch:{ Exception -> 0x00bc }
            if (r13 != r0) goto L_0x0099
            f1515b = r4
            return r4
        L_0x0099:
            boolean r12 = r14.booleanValue()     // Catch:{ Exception -> 0x00b9 }
            if (r12 == 0) goto L_0x00b7
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b9 }
            r12.<init>()     // Catch:{ Exception -> 0x00b9 }
            java.lang.String r13 = "copy success to delete"
            r12.append(r13)     // Catch:{ Exception -> 0x00b9 }
            boolean r13 = r6.delete()     // Catch:{ Exception -> 0x00b9 }
            r12.append(r13)     // Catch:{ Exception -> 0x00b9 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x00b9 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r12)     // Catch:{ Exception -> 0x00b9 }
        L_0x00b7:
            r12 = 2
            goto L_0x00d4
        L_0x00b9:
            r12 = move-exception
            r13 = 2
            goto L_0x00db
        L_0x00bc:
            r12 = move-exception
            goto L_0x00db
        L_0x00be:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9 }
            r13.<init>()     // Catch:{ Exception -> 0x00d9 }
            r13.append(r1)     // Catch:{ Exception -> 0x00d9 }
            r13.append(r12)     // Catch:{ Exception -> 0x00d9 }
            r13.append(r8)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x00d9 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r12)     // Catch:{ Exception -> 0x00d9 }
            r12 = 0
        L_0x00d4:
            f1515b = r4
            goto L_0x00f6
        L_0x00d7:
            r12 = move-exception
            goto L_0x010f
        L_0x00d9:
            r12 = move-exception
            r13 = 0
        L_0x00db:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d7 }
            r14.<init>()     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = "copy, Exception"
            r14.append(r1)     // Catch:{ all -> 0x00d7 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00d7 }
            r14.append(r12)     // Catch:{ all -> 0x00d7 }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x00d7 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r12)     // Catch:{ all -> 0x00d7 }
            f1515b = r4
            r12 = r13
        L_0x00f6:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "copy, isOk "
            r13.append(r14)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            com.adups.fota.utils.LogUtil.a((java.lang.String) r13)
            if (r12 != r3) goto L_0x010d
            goto L_0x010e
        L_0x010d:
            r0 = 0
        L_0x010e:
            return r0
        L_0x010f:
            f1515b = r4
            goto L_0x0113
        L_0x0112:
            throw r12
        L_0x0113:
            goto L_0x0112
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.activity.SdcardUpdateActivity.a(java.lang.String, java.lang.String, java.lang.Boolean):boolean");
    }

    private boolean b(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        String parent = new File(str).getParent();
        if (Build.VERSION.SDK_INT >= 21) {
            String b2 = t.b((Context) this, true);
            String b3 = t.b((Context) this, false);
            LogUtil.a("isSdcardRootZip,outSdcard=" + b2 + " ,innerSdcard=" + b3);
            if (!TextUtils.isEmpty(b2) && parent.equals(b2)) {
                z = true;
            }
            if (TextUtils.isEmpty(b3) || !parent.equals(b3)) {
                return z;
            }
        } else {
            List<t.a> d2 = t.d();
            if (d2 == null) {
                return false;
            }
            int i = 0;
            while (i < d2.size()) {
                t.a aVar = d2.get(i);
                LogUtil.a("isSdcardRootZip, i = " + i + ",info path = " + aVar.f1650a + ",parentPath = " + parent);
                if (!parent.equals(aVar.f1650a)) {
                    i++;
                }
            }
            return false;
        }
        return true;
    }

    private boolean b(long j, String str) {
        try {
            StatFs statFs = new StatFs(str);
            long blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            LogUtil.a("checkSdcardSpaceNeeded totalSize = " + blockSize);
            if (blockSize <= j) {
                return false;
            }
            LogUtil.b("checkSdcardSpaceNeeded true, totalSize = " + blockSize);
            return true;
        } catch (Exception unused) {
            LogUtil.b("checkSdcardSpaceNeeded false, card mount error");
            return false;
        }
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        if (str == null) {
            return str;
        }
        String b2 = t.b((Context) this, str);
        if (!TextUtils.isEmpty(b2)) {
            return b2;
        }
        List<t.a> d2 = t.d();
        if (d2 == null) {
            return str;
        }
        for (int i = 0; i < d2.size(); i++) {
            t.a aVar = d2.get(i);
            if (aVar != null && str.startsWith(aVar.f1650a)) {
                return aVar.f1650a;
            }
        }
        return str;
    }

    private void a(EventMessage eventMessage) {
        closeDialog();
        finish();
    }

    public boolean a(long j, String str) {
        if (b(j, str)) {
            return true;
        }
        d.a((Context) this, getString(C0216R$string.sdCard_upgrade_memory_space_not_enough), getString(C0216R$string.sdcard_crash_or_unmount));
        LogUtil.a("isEnough false");
        return false;
    }
}
