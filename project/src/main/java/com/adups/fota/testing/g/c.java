package com.adups.fota.testing.g;

import com.adups.fota.testing.utils.f;
import java.util.HashMap;
import java.util.Map;

public class c {
    public static void a_shaKey(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> next : map.entrySet()) {
                sb.append("&");
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append((String) next.getValue());
            }
        }
        String sb2 = sb.toString();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String b2 = f.encode_str(sb2);
        hashMap.put("key", b2);
        hashMap.put("shaKey", f.calculate_sha_key(b2));
        System.out.println("key=" + hashMap.get("key") + "&shaKey=" + hashMap.get("shaKey"));
    }

    public static void a_noShaKey(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> next : map.entrySet()) {
                sb.append("&");
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append((String) next.getValue());
            }
        }
        String sb2 = sb.toString();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("key", f.encode_str(sb2));
        System.out.println("encryptParams : " + hashMap.toString());
    }
}
