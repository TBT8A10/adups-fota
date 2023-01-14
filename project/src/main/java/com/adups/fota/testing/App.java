package com.adups.fota.testing;

import com.adups.fota.testing.g.c;
import java.util.HashMap;

public class App 
{
    /*private static final String ro_fota_oem = "incartech3326_10.0";
    private static final String ro_fota_device = "TBT8A10";
    private static final String ro_product_locale = "es-ES";
    private static final String ro_operator_optr = "";
    private static final String ro_fota_version = "QQ2A.200305.004.A1 release-keys_20210913-1718";*/

    private static final String ro_fota_oem = "tinno6735_6.0";
    private static final String ro_fota_device = "R1_HD_R0010UU_GENERIC";
    private static final String ro_product_locale = "en";
    private static final String ro_operator_optr = "";
    private static final String ro_fota_version = "";

    public static void main( String[] args )
    {
        HashMap<String, String> hashMap = defaultConfig();
        c.a_shaKey(hashMap);
    }

    public static HashMap<String, String> defaultConfig() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        //hashMap.put("device_type", "pad"); // ro.fota.type
        //hashMap.put("connect_type", "-2"); // Mobile/No internet = -1. WiFi = -2
        //hashMap.put("platform", "RK3326_10.0"); // ro.fota.platform
        // Note: these props must be sanitized with replaceAll("_", "\\$")
        // sanitization on ro.fota.oem seems to be optional as per experimenting with the server responses
        // ro.fota.oem_ro.fota.device_
        // ro.fota.language||ro.product.locale||ro.product.locale.language||en_
        // ro.operator.optr equals "OP01" then "CMCC" or equals "OP02" then "CU" else "other"
        String operator = ro_operator_optr == "OP01" ? "CMCC" : ro_operator_optr == "OP02" ? "CU" : "other";
        hashMap.put("project", ro_fota_oem.replaceAll("_", "\\$") + "_" + ro_fota_device.replaceAll("_", "\\$") + "_" + ro_product_locale.replaceAll("_", "\\$") + "_" + operator); 
        hashMap.put("version", ro_fota_version); // ro.fota.version"
        // Note: these props must be sanitized with replaceAll("_", "\\$")
        // ro.product.model_ro.product.brand_ro.product.name_ro.product.device_o.product.board_ro.product.manufacturer_ro.product.platform_ro.product.product
        //hashMap.put("devicesinfoExt", "TBT8A10_i-Buddie_TG08RK1_TG08RK1_rk30sdk_incar___");
        //hashMap.put("swFingerprint", "i-Buddie/TG08RK1/TG08RK1:10/QQ2A.200305.004.A1/1594645620:user/release-keys");
        //hashMap.put("sdk_level", "29"); // probably ro.build.version.sdk
        //hashMap.put("sdk_release", "10"); // probably ro.build.version.release
        //hashMap.put("resolution", "800#1280"); // width#height
        //hashMap.put("mid", "20221220203329pR5433"); // Unknown
        //hashMap.put("isNewMid", "0"); // Either 1 or 0. Unknown meaning
        //hashMap.put("appCode", "215"); // App version code
        //hashMap.put("imei", "");
        //hashMap.put("imei2", "");
        //hashMap.put("spn1", ""); // SIM Operator Name
        //hashMap.put("spn2", ""); // Just an empty string
        //hashMap.put("upgradeAgreement", "false");
        //hashMap.put("androidId", "72439f9753e6b1c0"); // adb shell settings get secure android_id
        //hashMap.put("appVersion", "5.28.0.1.006_2019-12-04 16:35");
        //hashMap.put("fotaSign", "c7bfd51821b0219bdf267ee8a5afbb21");
        //hashMap.put("agreeType", "false"); // Whether com.adups.privacypolicy is installed
        //hashMap.put("fcmId", "e9QEKM5KCvo:APA91bGyom65eL37en5iKJb0bqv0V_2XebsSc10w8vxxECouYjrkA8vfXKM1yRQCeg-_kLq6BWPQUdXQQv4up5P46PRwcwvdPhLNfyqedt5x9Sr0tPiUOCnLi3NZ6NVcyOk9I0cUfT"); //probably related to firebase

        // Both project and version are required, otherwise update check will fail

        return hashMap;
    }
}