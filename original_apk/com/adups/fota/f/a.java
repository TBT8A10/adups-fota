package com.adups.fota.f;

import android.content.Context;
import android.text.TextUtils;
import com.adups.fota.activity.BaseActivity;
import com.adups.fota.bean.ReportBaseBean;
import com.adups.fota.bean.ReportDownloadBean;
import com.adups.fota.bean.ReportInstallBean;
import com.adups.fota.bean.ReportInstallResultBean;
import com.adups.fota.bean.ReportQueryBean;
import com.adups.fota.bean.VersionBean;
import com.adups.fota.c.d;
import com.adups.fota.e.c;
import com.adups.fota.e.g;
import com.adups.fota.g.e;
import com.adups.fota.manager.f;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.i;
import com.adups.fota.utils.o;
import com.adups.fota.utils.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* compiled from: ReportData */
public class a {
    public static <T> String a(T t) {
        if (t != null) {
            return i.a(t);
        }
        return null;
    }

    private static String b() {
        VersionBean c2 = c.a().c();
        String versionName = c2 != null ? c2.getVersionName() : null;
        return TextUtils.isEmpty(versionName) ? com.adups.fota.utils.c.j().k() : versionName;
    }

    private static String a() {
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
    }

    public static void a(Context context, int i, int i2, e eVar) {
        if (eVar != null) {
            ReportQueryBean reportQueryBean = new ReportQueryBean();
            reportQueryBean.setStatus(eVar.e() ? 1 : 2);
            reportQueryBean.setErrCode(String.valueOf(eVar.a()));
            reportQueryBean.setReason(eVar.b());
            reportQueryBean.setTime(a());
            reportQueryBean.setVersion(b());
            reportQueryBean.setCheckType(i);
            reportQueryBean.setApn(com.adups.fota.utils.c.j().d(context));
            reportQueryBean.setType(i2);
            ReportBaseBean reportBaseBean = new ReportBaseBean();
            reportBaseBean.setAction("check");
            reportBaseBean.setData(reportQueryBean);
            e.a().a(context, "check", a(reportBaseBean), false);
        }
    }

    public static void a(Context context, String str, long j) {
        ReportDownloadBean reportDownloadBean = new ReportDownloadBean();
        reportDownloadBean.setTime(a());
        reportDownloadBean.setStatus(str);
        reportDownloadBean.setVersion(b());
        reportDownloadBean.setDuration(j / 1000);
        reportDownloadBean.setBackground(d.b().a());
        reportDownloadBean.setType(g.a().b());
        reportDownloadBean.setApn(com.adups.fota.utils.c.j().d(context));
        ReportBaseBean reportBaseBean = new ReportBaseBean();
        reportBaseBean.setAction("download");
        reportBaseBean.setData(reportDownloadBean);
        e.a().a(context, "download", a(reportBaseBean), false);
        if (str.equalsIgnoreCase("cancel") || str.equalsIgnoreCase("finish") || str.equalsIgnoreCase("cause_clean_cache")) {
            f.b();
        }
    }

    public static void a(Context context, String str) {
        ReportInstallBean reportInstallBean = new ReportInstallBean();
        reportInstallBean.setStatus(str);
        reportInstallBean.setTime(a());
        reportInstallBean.setNewVersion(b());
        reportInstallBean.setOldVersion(com.adups.fota.utils.c.j().k());
        reportInstallBean.setType(g.a().b());
        reportInstallBean.setForced(((Boolean) c.a().a_shaKey_method2("install_forced", Boolean.class)).booleanValue() ? 1 : 0);
        ReportBaseBean reportBaseBean = new ReportBaseBean();
        reportBaseBean.setAction("upgrade");
        reportBaseBean.setData(reportInstallBean);
        e.a().a(context, "upgrade", a(reportBaseBean), false);
    }

    public static void a(Context context, boolean z, int i, String str) {
        String str2;
        a(z);
        ReportInstallResultBean reportInstallResultBean = new ReportInstallResultBean();
        reportInstallResultBean.setTime(a());
        reportInstallResultBean.setOldVersion(a(o.a(context, "ota_original_version", "")));
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("ab")) {
            if (z) {
                str2 = com.adups.fota.utils.c.j().k();
            } else {
                str2 = o.a(context, "ota_update_version", com.adups.fota.utils.c.j().k());
            }
            reportInstallResultBean.setNewVersion(str2);
        } else {
            reportInstallResultBean.setNewVersion(b());
        }
        reportInstallResultBean.setType(o.a(context, "ota_update_type", 1));
        reportInstallResultBean.setStatus(z ? 1 : 0);
        reportInstallResultBean.setErrCode(a(i));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        reportInstallResultBean.setReason(str);
        ReportBaseBean reportBaseBean = new ReportBaseBean();
        reportBaseBean.setAction("upgradeResult");
        reportBaseBean.setData(reportInstallResultBean);
        e.a().a(context, "upgradeResult", a(reportBaseBean), !z);
    }

    private static void a(boolean z) {
        if (z) {
            t.a();
        }
    }

    private static String a(String str) {
        String o = com.adups.fota.utils.c.j().o();
        LogUtil.a("local_version = " + str + "; project = " + o);
        return (TextUtils.isEmpty(str) || !str.contains("_other") || TextUtils.isEmpty(o) || !o.contains("_other")) ? str : str.substring(o.substring(0, o.lastIndexOf("_")).length() + 1, str.lastIndexOf("_"));
    }

    private static String a(int i) {
        switch (i) {
            case 401:
                return "4";
            case 402:
                return "6";
            case 403:
                return "8";
            case 404:
                return "9";
            case 408:
                return "7";
            case 409:
                return BaseActivity.FCM_REPORT_TYPE_LOG;
            case 411:
                return "5";
            case 412:
                return "B";
            case 413:
                return "1";
            case 414:
                return "2";
            case 415:
                return "C";
            case 416:
                return "10";
            case 417:
                return "11";
            case 418:
                return "12";
            case 419:
                return "13";
            case UnixStat.DEFAULT_FILE_PERM /*420*/:
                return "14";
            default:
                return i + "";
        }
    }
}
