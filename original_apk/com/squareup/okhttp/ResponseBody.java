package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;

public abstract class ResponseBody implements Closeable {
    private Reader reader;

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        Buffer a2 = new Buffer().a(str, charset);
        return create(mediaType, a2.p(), a2);
    }

    public final InputStream byteStream() throws IOException {
        return source().k();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            BufferedSource source = source();
            try {
                byte[] f = source.f();
                Util.closeQuietly((Closeable) source);
                if (contentLength == -1 || contentLength == ((long) f.length)) {
                    return f;
                }
                throw new IOException("Content-Length and stream length disagree");
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) source);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    public final Reader charStream() throws IOException {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(byteStream(), charset());
        this.reader = inputStreamReader;
        return inputStreamReader;
    }

    public void close() throws IOException {
        source().close();
    }

    public abstract long contentLength() throws IOException;

    public abstract MediaType contentType();

    public abstract BufferedSource source() throws IOException;

    public final String string() throws IOException {
        return new String(bytes(), charset().name());
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, (long) bArr.length, new Buffer().write(bArr));
    }

    public static ResponseBody create(final MediaType mediaType, final long j, final BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new ResponseBody() {
                public long contentLength() {
                    return j;
                }

                public MediaType contentType() {
                    return mediaType;
                }

                public BufferedSource source() {
                    return bufferedSource;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
