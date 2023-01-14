package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

public final class RetryableSink implements Sink {
    private boolean closed;
    private final Buffer content;
    private final int limit;

    public RetryableSink(int i) {
        this.content = new Buffer();
        this.limit = i;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            if (this.content.p() < ((long) this.limit)) {
                throw new ProtocolException("content-length promised " + this.limit + " bytes, but received " + this.content.p());
            }
        }
    }

    public long contentLength() throws IOException {
        return this.content.p();
    }

    public void flush() throws IOException {
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void write(Buffer buffer, long j) throws IOException {
        if (!this.closed) {
            Util.checkOffsetAndCount(buffer.p(), 0, j);
            if (this.limit == -1 || this.content.p() <= ((long) this.limit) - j) {
                this.content.write(buffer, j);
                return;
            }
            throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes");
        }
        throw new IllegalStateException("closed");
    }

    public void writeToSocket(Sink sink) throws IOException {
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.content;
        buffer2.a(buffer, 0, buffer2.p());
        sink.write(buffer, buffer.p());
    }

    public RetryableSink() {
        this(-1);
    }
}
