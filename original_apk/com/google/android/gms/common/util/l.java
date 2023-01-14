package com.google.android.gms.common.util;

import java.util.regex.Pattern;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f1962a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
