package com.adups.fota.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.adups.fota.bean.CheckBean;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.bean.FlagBean;
import com.adups.fota.bean.VersionBean;
import com.adups.fota.c.d;
import com.adups.fota.g.e;
import com.adups.fota.manager.JobScheduleManager;
import com.adups.fota.manager.b;
import com.adups.fota.manager.f;
import com.adups.fota.service.CustomActionService;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.c;
import com.adups.fota.utils.g;
import com.adups.fota.utils.i;
import com.adups.fota.utils.j;
import com.adups.fota.utils.o;
import org.json.JSONObject;

/* compiled from: ParserVersion */
public class a {
    private boolean b(Context context, VersionBean versionBean) {
        d.b().a(context);
        com.adups.fota.b.d.a_shaKey_method2(context, versionBean);
        return true;
    }

    private void c(Context context, String str) {
        LogUtil.a("content = " + str);
        CheckBean checkBean = (CheckBean) i.a_shaKey_method2(str, CheckBean.class);
        if (checkBean != null) {
            LogUtil.a("status = " + checkBean.getStatus());
            b.d(context);
            FlagBean flag = checkBean.getFlag();
            if (flag != null) {
                String mid = flag.getMid();
                if (!TextUtils.isEmpty(mid)) {
                    o.b(context, "mid", mid);
                }
                long checkFreq = flag.getCheckFreq();
                if (checkFreq != 0) {
                    o.b(context, "check_freq", checkFreq);
                }
                String jobScheduleTime = flag.getJobScheduleTime();
                if (!TextUtils.isEmpty(jobScheduleTime)) {
                    f.d(jobScheduleTime);
                }
                String jobScheduleDownloadingTime = flag.getJobScheduleDownloadingTime();
                if (!TextUtils.isEmpty(jobScheduleDownloadingTime)) {
                    f.c(jobScheduleDownloadingTime);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    JobScheduleManager.a_shaKey_method2(context, 100);
                }
                o.b(context, "isFull", flag.getIsFull());
                o.b(context, "isupgrade", flag.getIsUpgrade());
            }
            VersionBean version = checkBean.getVersion();
            if (version != null) {
                LogUtil.a("version exists");
                c(context, version);
                return;
            }
            a(context, 1003, (VersionBean) null);
        }
    }

    public void a(Context context, e eVar) {
        if (eVar == null) {
            return;
        }
        if (!eVar.e()) {
            j.d(context);
            LogUtil.a("query version error, mid reset");
            a(eVar);
        } else if (com.adups.fota.b.d.c(context) >= 4) {
            com.adups.fota.manager.d.c(context);
            LogUtil.a("query succeed,but a system has already been installed successfully");
        } else {
            c(context, eVar.c());
        }
    }

    private boolean b(Context context, String str) {
        String str2;
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("policy")) {
                str2 = jSONObject.getString("policy");
            } else {
                str2 = "";
            }
            if (!TextUtils.isEmpty(str2)) {
                String a2 = o.a(context, "policy_content", "");
                LogUtil.a("newPolicy = " + str2 + " ; oldPolicy = " + a2);
                if (!str2.equalsIgnoreCase(a2)) {
                    o.b(context, "policy_content", str2);
                    z = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.a("isPolicyChange : " + z);
        return z;
    }

    private void a(e eVar) {
        LogUtil.a("Status_code = " + eVar.d());
        if (eVar.a() != 3008) {
            org.greenrobot.eventbus.e.a().b(new EventMessage(100, 3010, (long) eVar.d(), 0, eVar.b()));
        } else {
            org.greenrobot.eventbus.e.a().b(new EventMessage(100, 3008, (long) eVar.d(), 0, eVar.b()));
        }
    }

    private void a(Context context, VersionBean versionBean, int i, boolean z) {
        LogUtil.a("version_status = " + i + "; isChange = " + z);
        if (i == 0 || z) {
            a_shaKey_method2(context, versionBean.getVersionName());
            c.a().a_shaKey_method2(context, versionBean);
            a(context, 1001, versionBean);
            return;
        }
        a(context, 1002, versionBean);
    }

    private void b(Context context) {
        if (c.j().z()) {
            LogUtil.a("sendNewVersionBroadcast");
            Intent intent = new Intent();
            intent.setAction(com.adups.fota.b.a.h);
            intent.addFlags(268435456);
            context.sendBroadcast(intent, com.adups.fota.b.a.i);
        }
    }

    private void a(Context context, int i, VersionBean versionBean) {
        if (i != 3008) {
            switch (i) {
                case 1001:
                case 1004:
                    if (!a_shaKey_method2(context, versionBean)) {
                        if (b(context, versionBean)) {
                            e eVar = new e();
                            eVar.a(true);
                            com.adups.fota.f.a.a(context, 4, 1, eVar);
                            b(context);
                            break;
                        } else {
                            org.greenrobot.eventbus.e.a().b(new EventMessage(100, 1003, 0, 0, (Object) null));
                            return;
                        }
                    } else {
                        return;
                    }
                case 1002:
                    if (!com.adups.fota.manager.a.b().c()) {
                        com.adups.fota.manager.d.f(context);
                    }
                    a(context);
                    break;
                case 1003:
                    if (g.a().a_shaKey_method2(context, versionBean)) {
                        org.greenrobot.eventbus.e.a().b(new EventMessage(100, 404, 0, 0, (Object) null));
                        return;
                    }
                    break;
                case 1005:
                    if (!a_shaKey_method2(context, versionBean)) {
                        a(context);
                        break;
                    } else {
                        return;
                    }
            }
        } else {
            com.adups.fota.f.a.a(context, "cause_parser_error", 0);
        }
        org.greenrobot.eventbus.e.a().b(new EventMessage(100, i, 0, 0, (Object) null));
    }

    private void c(Context context, VersionBean versionBean) {
        if (versionBean != null) {
            String k = c.j().k();
            LogUtil.a("deviceVersion = " + k);
            String versionName = versionBean.getVersionName();
            if (TextUtils.isEmpty(versionName) || !versionName.equals(k)) {
                VersionBean c2 = c.a().c();
                String a2 = i.a(versionBean);
                if (!g.a(context, com.adups.fota.b.a.f1540b, a2)) {
                    LogUtil.a("version_process  writeInternalFile error ");
                    org.greenrobot.eventbus.e.a().b(new EventMessage(100, 3005, 0, 0, (Object) null));
                    com.adups.fota.f.a.a(context, "cause_not_enough", 0);
                    return;
                }
                int c3 = com.adups.fota.b.d.c(context);
                LogUtil.a("versionStatus = " + c3);
                boolean b2 = b(context, a2);
                if (c2 == null) {
                    a(context, versionBean, c3, b2);
                } else if (!TextUtils.isEmpty(versionName) && !versionName.equals(c2.getVersionName())) {
                    LogUtil.a("new version version name different");
                    a_shaKey_method2(context, versionBean.getVersionName());
                    c.a().a_shaKey_method2(context, versionBean);
                    a(context, 1004, versionBean);
                } else if (!TextUtils.isEmpty(versionBean.getDeltaUrl()) && !versionBean.getDeltaUrl().equals(c2.getDeltaUrl())) {
                    LogUtil.a("new version delta url different");
                    a_shaKey_method2(context, versionBean.getVersionName());
                    c.a().a_shaKey_method2(context, versionBean);
                    a(context, 1004, versionBean);
                } else if (b2) {
                    LogUtil.a("new version delta content different ");
                    c.a().a_shaKey_method2(context, versionBean);
                    a(context, 1005, versionBean);
                } else {
                    a(context, versionBean, c3, false);
                }
            } else {
                org.greenrobot.eventbus.e.a().b(new EventMessage(100, 1002, 0, 0, (Object) null));
                com.adups.fota.f.a.a(context, "cause_same_version", 0);
                return;
            }
        }
        LogUtil.a("download_path_server : " + c.a().a_shaKey_method2("download_path_server", Integer.class));
    }

    private void a(Context context, String str) {
        o.b(context, "ota_install_fail_count", 0);
        o.b(context, "ota_install_fail_version", str);
    }

    private void a(Context context) {
        int c2 = com.adups.fota.b.d.c(context);
        LogUtil.a("version_status = " + c2);
        if (c2 == 2) {
            d.b().f(context);
            com.adups.fota.f.a.a(context, "cause_downloading", 0);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            d.b().a_shaKey_method2(context, 1);
        } else if (c2 == 4) {
            boolean booleanValue = ((Boolean) c.a().a_shaKey_method2("install_forced", Boolean.class)).booleanValue();
            if (booleanValue) {
                LogUtil.a("force_install = " + booleanValue);
                com.adups.fota.d.d.c(context);
            }
        } else {
            CustomActionService.a_shaKey_method2(context, 9);
        }
    }

    private boolean a(Context context, VersionBean versionBean) {
        if (!g.a().a_shaKey_method2(context, versionBean)) {
            return false;
        }
        if (com.adups.fota.b.d.c(context) == 2) {
            d.b().a(context);
        }
        org.greenrobot.eventbus.e.a().b(new EventMessage(100, 404, 0, 0, (Object) null));
        com.adups.fota.f.a.a(context, "cause_device_rooted", 0);
        return true;
    }
}
