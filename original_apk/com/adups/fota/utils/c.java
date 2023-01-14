package com.adups.fota.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: DeviceInfoUtil */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f1624a;

    private c() {
    }

    private String F() {
        return f.a(c("persist.sys.fota_deviceid3").replaceAll(",", ""));
    }

    private String G() {
        return c("ro.fota.id");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0022 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String H() {
        /*
            r7 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = r7.I()     // Catch:{ Exception -> 0x001a }
            java.lang.String r2 = r7.J()     // Catch:{ Exception -> 0x0018 }
            long r3 = java.lang.Long.parseLong(r1)     // Catch:{ Exception -> 0x0018 }
            long r5 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x0018 }
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0017
            return r1
        L_0x0017:
            return r2
        L_0x0018:
            goto L_0x001b
        L_0x001a:
            r1 = r0
        L_0x001b:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0022
            return r1
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.c.H():java.lang.String");
    }

    private String I() {
        String c2 = c("persist.sys.fota_deviceid1");
        if (!TextUtils.isEmpty(c2)) {
            String a2 = f.a(c2.replaceAll(",", ""));
            if (!TextUtils.isEmpty(a2) && !d(a2)) {
                return a(a2);
            }
        }
        return L();
    }

    private String J() {
        String c2 = c("persist.sys.fota_deviceid2");
        if (!TextUtils.isEmpty(c2)) {
            String a2 = f.a(c2.replaceAll(",", ""));
            if (!TextUtils.isEmpty(a2) && !d(a2)) {
                return a(a2);
            }
        }
        return L();
    }

    private String K() {
        byte[] hardwareAddress;
        String str = "";
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream()));
            String str2 = str;
            while (true) {
                if (str2 != null) {
                    str2 = lineNumberReader.readLine();
                    if (str2 != null) {
                        str = str2.trim();
                        break;
                    }
                } else {
                    break;
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = f("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
            }
            if (TextUtils.isEmpty(str)) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = nextElement.getHardwareAddress()) != null) {
                        if (hardwareAddress.length != 0) {
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i = 0; i < length; i++) {
                                sb.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            str = sb.toString();
                        }
                    }
                }
            }
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            str = M();
        }
        return TextUtils.isEmpty(str) ? "ff:ff:ff:ff:ff:ff" : str;
    }

    private String L() {
        String c2 = c("persist.sys.fota_deviceid4");
        if (!TextUtils.isEmpty(c2)) {
            String a2 = f.a(c2.replaceAll(",", ""));
            if (!TextUtils.isEmpty(a2) && !d(a2)) {
                return a(a2);
            }
        }
        return "";
    }

    private static String M() {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = t.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String N() {
        String str = null;
        for (String str2 : new String[]{"ro.boot.serialno", "ro.serialno"}) {
            str = SystemProperties.get(str2);
            LogUtil.a("SN VALUE : " + str);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return str;
    }

    private int b(String str) {
        return SystemProperties.getInt(str, 0);
    }

    private String c(String str) {
        return SystemProperties.get(str, "");
    }

    private String g(String str) {
        return str.replaceAll("_", "\\$");
    }

    public static c j() {
        if (f1624a == null) {
            f1624a = new c();
        }
        return f1624a;
    }

    public boolean A() {
        return b("ro.fota.fmsuccess") == 1;
    }

    public boolean B() {
        return b("ro.fota.pop") == 0;
    }

    public boolean C() {
        return b("ro.fota.exit") == 0;
    }

    public boolean D() {
        return b("ro.fota.localupdate") == 0;
    }

    public boolean E() {
        return SystemProperties.getBoolean("ro.build.ab_update", false);
    }

    public int a() {
        int i = SystemProperties.getInt("ro.fota.battery", 30);
        if (i != 30) {
            return i;
        }
        int intValue = ((Integer) com.adups.fota.e.c.a().a_shaKey_method2("install_battery", Integer.class)).intValue();
        if (intValue == 30 || intValue == 0) {
            return 30;
        }
        LogUtil.a("battery=" + intValue);
        return intValue;
    }

    public String d() {
        String c2 = c("ro.product.model");
        String c3 = c("ro.product.brand");
        String c4 = c("ro.product.name");
        String c5 = c("ro.product.device");
        String c6 = c("ro.product.board");
        String c7 = c("ro.product.manufacturer");
        String c8 = c("ro.product.platform");
        String c9 = c("ro.product.product");
        return g(c2) + "_" + g(c3) + "_" + g(c4) + "_" + g(c5) + "_" + g(c6) + "_" + g(c7) + "_" + g(c8) + "_" + g(c9);
    }

    public String e() {
        String c2 = c("ro.fota.display");
        return !TextUtils.isEmpty(c2) ? c2 : "0";
    }

    public String f() {
        return c("ro.fota.version.display");
    }

    public String h() {
        String c2 = c("ro.fota.language");
        if (TextUtils.isEmpty(c2)) {
            c2 = c("ro.product.locale");
        }
        if (TextUtils.isEmpty(c2)) {
            c2 = c("ro.product.locale.language");
        }
        if (TextUtils.isEmpty(c2)) {
            c2 = "en";
        }
        return g(c2);
    }

    public String i() {
        return Build.FINGERPRINT;
    }

    public String k() {
        String c2 = c("ro.fota.version");
        return TextUtils.isEmpty(c2) ? "unknownbuildnumber" : c2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0026 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String l() {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = r8.I()     // Catch:{ Exception -> 0x001f }
            java.lang.String r2 = r8.J()     // Catch:{ Exception -> 0x001f }
            long r3 = java.lang.Long.parseLong(r1)     // Catch:{ Exception -> 0x001d }
            long r5 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x001d }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0017
            return r2
        L_0x0017:
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x001c
            return r1
        L_0x001c:
            return r0
        L_0x001d:
            goto L_0x0020
        L_0x001f:
            r2 = r0
        L_0x0020:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x0027
            return r2
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.c.l():java.lang.String");
    }

    public String m() {
        String c2 = c("ro.fota.path");
        LogUtil.a("ro.fota.path = " + c2);
        return c2;
    }

    public String n() {
        return c("ro.fota.platform");
    }

    public String o() {
        String str;
        String str2;
        String str3;
        String c2 = c("ro.fota.oem");
        if (TextUtils.isEmpty(c2)) {
            str = "unknownoem";
        } else {
            str = g(c2);
        }
        String c3 = c("ro.fota.device");
        if (TextUtils.isEmpty(c3)) {
            str2 = "_unknownproduct_" + h();
        } else {
            str2 = "_" + g(c3) + "_" + h();
        }
        String g = g(c("ro.operator.optr"));
        if (g.equalsIgnoreCase("OP01")) {
            str3 = "CMCC";
        } else {
            str3 = g.equalsIgnoreCase("OP02") ? "CU" : "other";
        }
        return str + str2 + "_" + str3;
    }

    public long p() {
        long j = SystemProperties.getLong("ro.fota.activate", 0);
        if (j <= 1 || j >= 1440) {
            return 900000;
        }
        return j * 60 * 1000;
    }

    public String q() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public String r() {
        return Build.VERSION.RELEASE;
    }

    public String s() {
        return c("ro.fota.finalizing.pro");
    }

    public boolean t() {
        return b("ro.fota.auto.wifi") == 1;
    }

    public boolean u() {
        return b("ro.fota.hide.shake") == 1;
    }

    public boolean v() {
        return b("ro.fota.no_ring") == 1;
    }

    public boolean w() {
        return b("ro.fota.no_touch") == 1;
    }

    public boolean x() {
        return b("ro.fota.wifi.only") == 1;
    }

    public boolean y() {
        return b("ro.fota.screen") == 1;
    }

    public boolean z() {
        return b("ro.fota.fmcheck") == 1;
    }

    public String b() {
        String c2 = c("ro.fota.cycle");
        return !TextUtils.isEmpty(c2) ? c2 : "1";
    }

    public String c() {
        String c2 = c("ro.fota.type");
        return TextUtils.isEmpty(c2) ? "phone" : c2;
    }

    public int f(Context context) {
        int i = 0;
        if (Build.VERSION.SDK_INT < 21) {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra("level", 0);
            }
        } else {
            BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
            if (batteryManager != null) {
                i = batteryManager.getIntProperty(4);
            }
        }
        LogUtil.a("real battery = " + i);
        return i;
    }

    public String g(Context context) {
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        return i + "#" + i2;
    }

    private long e(String str) {
        byte[] bytes = str.getBytes();
        if (bytes.length > 0) {
            return (long) (bytes[0] - 96);
        }
        return 0;
    }

    private String a(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c2 : charArray) {
            if (c2 < '0' || c2 > '9') {
                sb.append(e(String.valueOf(c2).toLowerCase()));
            } else {
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    public String b(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            WifiInfo wifiInfo = null;
            if (wifiManager != null) {
                wifiInfo = wifiManager.getConnectionInfo();
            }
            if (wifiInfo != null) {
                return wifiInfo.getMacAddress();
            }
        }
        return K();
    }

    public String c(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        return telephonyManager.getSimOperatorName();
    }

    public String e(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        return telephonyManager.getSimOperator();
    }

    public String g() {
        String F = Build.VERSION.SDK_INT >= 26 ? F() : "";
        if (TextUtils.isEmpty(F)) {
            F = N();
        }
        return TextUtils.isEmpty(F) ? Build.SERIAL : F;
    }

    public boolean h(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager != null && powerManager.isScreenOn();
    }

    private String f(String str) throws Exception {
        FileReader fileReader = new FileReader(str);
        String a2 = a((Reader) fileReader);
        fileReader.close();
        return a2;
    }

    public String a(Context context) {
        String str;
        String c2 = c();
        LogUtil.a("deviceType = " + c2);
        if ("pad".equalsIgnoreCase(c2) || "tv".equalsIgnoreCase(c2) || "box".equalsIgnoreCase(c2)) {
            str = g();
        } else if ("phone".equalsIgnoreCase(c2) || "pad_phone".equalsIgnoreCase(c2)) {
            str = H();
        } else {
            str = g();
        }
        String G = G();
        LogUtil.a("id = " + G);
        if (TextUtils.isEmpty(G)) {
            return str;
        }
        if ("sn".equalsIgnoreCase(G)) {
            return g();
        }
        if ("mac".equalsIgnoreCase(G)) {
            return b(context);
        }
        return "imei".equalsIgnoreCase(G) ? H() : str;
    }

    private boolean d(String str) {
        int i = 0;
        while (i < str.length()) {
            try {
                if (Integer.valueOf(String.valueOf(str.charAt(i))).intValue() != 0) {
                    return false;
                }
                i++;
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    public int d(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getNetworkType();
            }
            return -1;
        } else if (type == 1) {
            return -2;
        } else {
            return -1;
        }
    }

    private String a(Reader reader) throws Exception {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[CpioConstants.C_ISFIFO];
        int read = reader.read(cArr);
        while (read >= 0) {
            sb.append(cArr, 0, read);
            read = reader.read(cArr);
        }
        return sb.toString();
    }
}
