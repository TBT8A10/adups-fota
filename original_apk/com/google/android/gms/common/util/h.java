package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f1958a = Pattern.compile("\\\\.");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f1959b = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = f1959b.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            char charAt = matcher.group().charAt(0);
            if (charAt == 12) {
                matcher.appendReplacement(stringBuffer, "\\\\f");
            } else if (charAt == 13) {
                matcher.appendReplacement(stringBuffer, "\\\\r");
            } else if (charAt == '\"') {
                matcher.appendReplacement(stringBuffer, "\\\\\\\"");
            } else if (charAt == '/') {
                matcher.appendReplacement(stringBuffer, "\\\\/");
            } else if (charAt != '\\') {
                switch (charAt) {
                    case 8:
                        matcher.appendReplacement(stringBuffer, "\\\\b");
                        break;
                    case 9:
                        matcher.appendReplacement(stringBuffer, "\\\\t");
                        break;
                    case 10:
                        matcher.appendReplacement(stringBuffer, "\\\\n");
                        break;
                }
            } else {
                matcher.appendReplacement(stringBuffer, "\\\\\\\\");
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
