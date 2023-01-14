package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Okio {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f2504a = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    public static Sink b(File file) throws FileNotFoundException {
        if (file != null) {
            return a((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source c(File file) throws FileNotFoundException {
        if (file != null) {
            return a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static BufferedSource a(Source source) {
        if (source != null) {
            return new RealBufferedSource(source);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static Source b(Socket socket) throws IOException {
        if (socket != null) {
            AsyncTimeout c2 = c(socket);
            return c2.source(a(socket.getInputStream(), (Timeout) c2));
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static AsyncTimeout c(final Socket socket) {
        return new AsyncTimeout() {
            /* access modifiers changed from: protected */
            public IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* access modifiers changed from: protected */
            public void timedOut() {
                try {
                    socket.close();
                } catch (Exception e) {
                    Logger a2 = Okio.f2504a;
                    Level level = Level.WARNING;
                    a2.log(level, "Failed to close timed out socket " + socket, e);
                } catch (AssertionError e2) {
                    if (e2.getCause() == null || e2.getMessage() == null || !e2.getMessage().contains("getsockname failed")) {
                        throw e2;
                    }
                    Logger a3 = Okio.f2504a;
                    Level level2 = Level.WARNING;
                    a3.log(level2, "Failed to close timed out socket " + socket, e2);
                }
            }
        };
    }

    public static BufferedSink a(Sink sink) {
        if (sink != null) {
            return new RealBufferedSink(sink);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static Sink a(OutputStream outputStream) {
        return a(outputStream, new Timeout());
    }

    private static Sink a(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new Sink() {
                public void close() throws IOException {
                    outputStream.close();
                }

                public void flush() throws IOException {
                    outputStream.flush();
                }

                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                public void write(Buffer buffer, long j) throws IOException {
                    Util.a(buffer.f2488c, 0, j);
                    while (j > 0) {
                        timeout.throwIfReached();
                        Segment segment = buffer.f2487b;
                        int min = (int) Math.min(j, (long) (segment.f2520c - segment.f2519b));
                        outputStream.write(segment.f2518a, segment.f2519b, min);
                        segment.f2519b += min;
                        long j2 = (long) min;
                        j -= j2;
                        buffer.f2488c -= j2;
                        if (segment.f2519b == segment.f2520c) {
                            buffer.f2487b = segment.b();
                            SegmentPool.a(segment);
                        }
                    }
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink a(Socket socket) throws IOException {
        if (socket != null) {
            AsyncTimeout c2 = c(socket);
            return c2.sink(a(socket.getOutputStream(), (Timeout) c2));
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static Source a(InputStream inputStream) {
        return a(inputStream, new Timeout());
    }

    private static Source a(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new Source() {
                public void close() throws IOException {
                    inputStream.close();
                }

                public long read(Buffer buffer, long j) throws IOException {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0;
                    } else {
                        timeout.throwIfReached();
                        Segment c2 = buffer.c(1);
                        int read = inputStream.read(c2.f2518a, c2.f2520c, (int) Math.min(j, (long) (2048 - c2.f2520c)));
                        if (read == -1) {
                            return -1;
                        }
                        c2.f2520c += read;
                        long j2 = (long) read;
                        buffer.f2488c += j2;
                        return j2;
                    }
                }

                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink a(File file) throws FileNotFoundException {
        if (file != null) {
            return a((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }
}
