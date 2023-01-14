package org.apache.commons.compress.utils;

import java.nio.charset.Charset;

public class Charsets {
    public static final Charset ISO_8859_1 = Charset.forName(CharsetNames.ISO_8859_1);
    public static final Charset US_ASCII = Charset.forName(CharsetNames.US_ASCII);
    public static final Charset UTF_16 = Charset.forName(CharsetNames.UTF_16);
    public static final Charset UTF_16BE = Charset.forName(CharsetNames.UTF_16BE);
    public static final Charset UTF_16LE = Charset.forName(CharsetNames.UTF_16LE);
    public static final Charset UTF_8 = Charset.forName(CharsetNames.UTF_8);

    public static Charset toCharset(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static Charset toCharset(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }
}
