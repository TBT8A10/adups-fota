package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.Closeable;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class HttpEngine {
    private static final ResponseBody EMPTY_BODY = new ResponseBody() {
        public long contentLength() {
            return 0;
        }

        public MediaType contentType() {
            return null;
        }

        public BufferedSource source() {
            return new Buffer();
        }
    };
    public static final int MAX_FOLLOW_UPS = 20;
    public final boolean bufferRequestBody;
    private BufferedSink bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    final OkHttpClient client;
    private final boolean forWebSocket;
    /* access modifiers changed from: private */
    public HttpStream httpStream;
    /* access modifiers changed from: private */
    public Request networkRequest;
    private final Response priorResponse;
    private Sink requestBodyOut;
    long sentRequestMillis = -1;
    private CacheRequest storeRequest;
    public final StreamAllocation streamAllocation;
    private boolean transparentGzip;
    private final Request userRequest;
    private Response userResponse;

    class NetworkInterceptorChain implements Interceptor.Chain {
        private int calls;
        private final int index;
        private final Request request;

        NetworkInterceptorChain(int i, Request request2) {
            this.index = i;
            this.request = request2;
        }

        public Connection connection() {
            return HttpEngine.this.streamAllocation.connection();
        }

        public Response proceed(Request request2) throws IOException {
            this.calls++;
            if (this.index > 0) {
                Interceptor interceptor = HttpEngine.this.client.networkInterceptors().get(this.index - 1);
                Address address = connection().getRoute().getAddress();
                if (!request2.httpUrl().host().equals(address.getUriHost()) || request2.httpUrl().port() != address.getUriPort()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                } else if (this.calls > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.index < HttpEngine.this.client.networkInterceptors().size()) {
                NetworkInterceptorChain networkInterceptorChain = new NetworkInterceptorChain(this.index + 1, request2);
                Interceptor interceptor2 = HttpEngine.this.client.networkInterceptors().get(this.index);
                Response intercept = interceptor2.intercept(networkInterceptorChain);
                if (networkInterceptorChain.calls != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor2 + " must call proceed() exactly once");
                } else if (intercept != null) {
                    return intercept;
                } else {
                    throw new NullPointerException("network interceptor " + interceptor2 + " returned null");
                }
            } else {
                HttpEngine.this.httpStream.writeRequestHeaders(request2);
                Request unused = HttpEngine.this.networkRequest = request2;
                if (HttpEngine.this.permitsRequestBody(request2) && request2.body() != null) {
                    BufferedSink a2 = Okio.a(HttpEngine.this.httpStream.createRequestBody(request2, request2.body().contentLength()));
                    request2.body().writeTo(a2);
                    a2.close();
                }
                Response access$200 = HttpEngine.this.readNetworkResponse();
                int code = access$200.code();
                if ((code != 204 && code != 205) || access$200.body().contentLength() <= 0) {
                    return access$200;
                }
                throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + access$200.body().contentLength());
            }
        }

        public Request request() {
            return this.request;
        }
    }

    public HttpEngine(OkHttpClient okHttpClient, Request request, boolean z, boolean z2, boolean z3, StreamAllocation streamAllocation2, RetryableSink retryableSink, Response response) {
        this.client = okHttpClient;
        this.userRequest = request;
        this.bufferRequestBody = z;
        this.callerWritesRequestBody = z2;
        this.forWebSocket = z3;
        this.streamAllocation = streamAllocation2 == null ? new StreamAllocation(okHttpClient.getConnectionPool(), createAddress(okHttpClient, request)) : streamAllocation2;
        this.requestBodyOut = retryableSink;
        this.priorResponse = response;
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        final BufferedSource source = response.body().source();
        final BufferedSink a2 = Okio.a(body);
        return response.newBuilder().body(new RealResponseBody(response.headers(), Okio.a((Source) new Source() {
            boolean cacheRequestClosed;

            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }

            public long read(Buffer buffer, long j) throws IOException {
                try {
                    long read = source.read(buffer, j);
                    if (read == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            a2.close();
                        }
                        return -1;
                    }
                    buffer.a(a2.a(), buffer.p() - read, read);
                    a2.c();
                    return read;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            public Timeout timeout() {
                return source.timeout();
            }
        }))).build();
    }

    private static Headers combine(Headers headers, Headers headers2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (!OkHeaders.isEndToEnd(name) || headers2.get(name) == null)) {
                builder.add(name, value);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String name2 = headers2.name(i2);
            if (!"Content-Length".equalsIgnoreCase(name2) && OkHeaders.isEndToEnd(name2)) {
                builder.add(name2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    private HttpStream connect() throws RouteException, RequestException, IOException {
        return this.streamAllocation.newStream(this.client.getConnectTimeout(), this.client.getReadTimeout(), this.client.getWriteTimeout(), this.client.getRetryOnConnectionFailure(), !this.networkRequest.method().equals("GET"));
    }

    private static Address createAddress(OkHttpClient okHttpClient, Request request) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (request.isHttps()) {
            SSLSocketFactory sslSocketFactory = okHttpClient.getSslSocketFactory();
            hostnameVerifier = okHttpClient.getHostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = okHttpClient.getCertificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(request.httpUrl().host(), request.httpUrl().port(), okHttpClient.getDns(), okHttpClient.getSocketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.getAuthenticator(), okHttpClient.getProxy(), okHttpClient.getProtocols(), okHttpClient.getConnectionSpecs(), okHttpClient.getProxySelector());
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && OkHeaders.contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    private void maybeCache() throws IOException {
        InternalCache internalCache = Internal.instance.internalCache(this.client);
        if (internalCache != null) {
            if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
                this.storeRequest = internalCache.put(stripBody(this.userResponse));
            } else if (HttpMethod.invalidatesCache(this.networkRequest.method())) {
                try {
                    internalCache.remove(this.networkRequest);
                } catch (IOException unused) {
                }
            }
        }
    }

    private Request networkRequest(Request request) throws IOException {
        Request.Builder newBuilder = request.newBuilder();
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.hostHeader(request.httpUrl()));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null) {
            this.transparentGzip = true;
            newBuilder.header("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            OkHeaders.addCookies(newBuilder, cookieHandler.get(request.uri(), OkHeaders.toMultimap(newBuilder.build().headers(), (String) null)));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.userAgent());
        }
        return newBuilder.build();
    }

    /* access modifiers changed from: private */
    public Response readNetworkResponse() throws IOException {
        this.httpStream.finishRequest();
        Response build = this.httpStream.readResponseHeaders().request(this.networkRequest).handshake(this.streamAllocation.connection().getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        if (!this.forWebSocket) {
            build = build.newBuilder().body(this.httpStream.openResponseBody(build)).build();
        }
        if ("close".equalsIgnoreCase(build.request().header("Connection")) || "close".equalsIgnoreCase(build.header("Connection"))) {
            this.streamAllocation.noNewStreams();
        }
        return build;
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body((ResponseBody) null).build();
    }

    private Response unzip(Response response) throws IOException {
        if (!this.transparentGzip || !"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")) || response.body() == null) {
            return response;
        }
        GzipSource gzipSource = new GzipSource(response.body().source());
        Headers build = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
        return response.newBuilder().headers(build).body(new RealResponseBody(build, Okio.a((Source) gzipSource))).build();
    }

    private static boolean validate(Response response, Response response2) {
        Date date;
        if (response2.code() == 304) {
            return true;
        }
        Date date2 = response.headers().getDate("Last-Modified");
        if (date2 == null || (date = response2.headers().getDate("Last-Modified")) == null || date.getTime() >= date2.getTime()) {
            return false;
        }
        return true;
    }

    public void cancel() {
        this.streamAllocation.cancel();
    }

    public StreamAllocation close() {
        BufferedSink bufferedSink = this.bufferedRequestBody;
        if (bufferedSink != null) {
            Util.closeQuietly((Closeable) bufferedSink);
        } else {
            Sink sink = this.requestBodyOut;
            if (sink != null) {
                Util.closeQuietly((Closeable) sink);
            }
        }
        Response response = this.userResponse;
        if (response != null) {
            Util.closeQuietly((Closeable) response.body());
        } else {
            this.streamAllocation.connectionFailed();
        }
        return this.streamAllocation;
    }

    public Request followUpRequest() throws IOException {
        Proxy proxy;
        String header;
        HttpUrl resolve;
        if (this.userResponse != null) {
            RealConnection connection = this.streamAllocation.connection();
            Route route = connection != null ? connection.getRoute() : null;
            if (route != null) {
                proxy = route.getProxy();
            } else {
                proxy = this.client.getProxy();
            }
            int code = this.userResponse.code();
            String method = this.userRequest.method();
            if (code != 307 && code != 308) {
                if (code != 401) {
                    if (code != 407) {
                        switch (code) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (proxy.type() != Proxy.Type.HTTP) {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                }
                return OkHeaders.processAuthHeader(this.client.getAuthenticator(), this.userResponse, proxy);
            } else if (!method.equals("GET") && !method.equals("HEAD")) {
                return null;
            }
            if (!this.client.getFollowRedirects() || (header = this.userResponse.header("Location")) == null || (resolve = this.userRequest.httpUrl().resolve(header)) == null) {
                return null;
            }
            if (!resolve.scheme().equals(this.userRequest.httpUrl().scheme()) && !this.client.getFollowSslRedirects()) {
                return null;
            }
            Request.Builder newBuilder = this.userRequest.newBuilder();
            if (HttpMethod.permitsRequestBody(method)) {
                if (HttpMethod.redirectsToGet(method)) {
                    newBuilder.method("GET", (RequestBody) null);
                } else {
                    newBuilder.method(method, (RequestBody) null);
                }
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
            if (!sameConnection(resolve)) {
                newBuilder.removeHeader("Authorization");
            }
            return newBuilder.url(resolve).build();
        }
        throw new IllegalStateException();
    }

    public BufferedSink getBufferedRequestBody() {
        BufferedSink bufferedSink = this.bufferedRequestBody;
        if (bufferedSink != null) {
            return bufferedSink;
        }
        Sink requestBody = getRequestBody();
        if (requestBody == null) {
            return null;
        }
        BufferedSink a2 = Okio.a(requestBody);
        this.bufferedRequestBody = a2;
        return a2;
    }

    public Connection getConnection() {
        return this.streamAllocation.connection();
    }

    public Request getRequest() {
        return this.userRequest;
    }

    public Sink getRequestBody() {
        if (this.cacheStrategy != null) {
            return this.requestBodyOut;
        }
        throw new IllegalStateException();
    }

    public Response getResponse() {
        Response response = this.userResponse;
        if (response != null) {
            return response;
        }
        throw new IllegalStateException();
    }

    public boolean hasResponse() {
        return this.userResponse != null;
    }

    /* access modifiers changed from: package-private */
    public boolean permitsRequestBody(Request request) {
        return HttpMethod.permitsRequestBody(request.method());
    }

    public void readResponse() throws IOException {
        Response response;
        if (this.userResponse == null) {
            if (this.networkRequest == null && this.cacheResponse == null) {
                throw new IllegalStateException("call sendRequest() first!");
            }
            Request request = this.networkRequest;
            if (request != null) {
                if (this.forWebSocket) {
                    this.httpStream.writeRequestHeaders(request);
                    response = readNetworkResponse();
                } else if (!this.callerWritesRequestBody) {
                    response = new NetworkInterceptorChain(0, request).proceed(this.networkRequest);
                } else {
                    BufferedSink bufferedSink = this.bufferedRequestBody;
                    if (bufferedSink != null && bufferedSink.a().p() > 0) {
                        this.bufferedRequestBody.b();
                    }
                    if (this.sentRequestMillis == -1) {
                        if (OkHeaders.contentLength(this.networkRequest) == -1) {
                            Sink sink = this.requestBodyOut;
                            if (sink instanceof RetryableSink) {
                                this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(((RetryableSink) sink).contentLength())).build();
                            }
                        }
                        this.httpStream.writeRequestHeaders(this.networkRequest);
                    }
                    Sink sink2 = this.requestBodyOut;
                    if (sink2 != null) {
                        BufferedSink bufferedSink2 = this.bufferedRequestBody;
                        if (bufferedSink2 != null) {
                            bufferedSink2.close();
                        } else {
                            sink2.close();
                        }
                        Sink sink3 = this.requestBodyOut;
                        if (sink3 instanceof RetryableSink) {
                            this.httpStream.writeRequestBody((RetryableSink) sink3);
                        }
                    }
                    response = readNetworkResponse();
                }
                receiveHeaders(response.headers());
                Response response2 = this.cacheResponse;
                if (response2 != null) {
                    if (validate(response2, response)) {
                        this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), response.headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(response)).build();
                        response.body().close();
                        releaseStreamAllocation();
                        InternalCache internalCache = Internal.instance.internalCache(this.client);
                        internalCache.trackConditionalCacheHit();
                        internalCache.update(this.cacheResponse, stripBody(this.userResponse));
                        this.userResponse = unzip(this.userResponse);
                        return;
                    }
                    Util.closeQuietly((Closeable) this.cacheResponse.body());
                }
                this.userResponse = response.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(response)).build();
                if (hasBody(this.userResponse)) {
                    maybeCache();
                    this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
                }
            }
        }
    }

    public void receiveHeaders(Headers headers) throws IOException {
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(headers, (String) null));
        }
    }

    public HttpEngine recover(RouteException routeException) {
        if (!this.streamAllocation.recover(routeException) || !this.client.getRetryOnConnectionFailure()) {
            return null;
        }
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), (RetryableSink) this.requestBodyOut, this.priorResponse);
    }

    public void releaseStreamAllocation() throws IOException {
        this.streamAllocation.release();
    }

    public boolean sameConnection(HttpUrl httpUrl) {
        HttpUrl httpUrl2 = this.userRequest.httpUrl();
        return httpUrl2.host().equals(httpUrl.host()) && httpUrl2.port() == httpUrl.port() && httpUrl2.scheme().equals(httpUrl.scheme());
    }

    public void sendRequest() throws RequestException, RouteException, IOException {
        if (this.cacheStrategy == null) {
            if (this.httpStream == null) {
                Request networkRequest2 = networkRequest(this.userRequest);
                InternalCache internalCache = Internal.instance.internalCache(this.client);
                Response response = internalCache != null ? internalCache.get(networkRequest2) : null;
                this.cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), networkRequest2, response).get();
                CacheStrategy cacheStrategy2 = this.cacheStrategy;
                this.networkRequest = cacheStrategy2.networkRequest;
                this.cacheResponse = cacheStrategy2.cacheResponse;
                if (internalCache != null) {
                    internalCache.trackResponse(cacheStrategy2);
                }
                if (response != null && this.cacheResponse == null) {
                    Util.closeQuietly((Closeable) response.body());
                }
                if (this.networkRequest != null) {
                    this.httpStream = connect();
                    this.httpStream.setHttpEngine(this);
                    if (this.callerWritesRequestBody && permitsRequestBody(this.networkRequest) && this.requestBodyOut == null) {
                        long contentLength = OkHeaders.contentLength(networkRequest2);
                        if (!this.bufferRequestBody) {
                            this.httpStream.writeRequestHeaders(this.networkRequest);
                            this.requestBodyOut = this.httpStream.createRequestBody(this.networkRequest, contentLength);
                        } else if (contentLength > 2147483647L) {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        } else if (contentLength != -1) {
                            this.httpStream.writeRequestHeaders(this.networkRequest);
                            this.requestBodyOut = new RetryableSink((int) contentLength);
                        } else {
                            this.requestBodyOut = new RetryableSink();
                        }
                    }
                } else {
                    Response response2 = this.cacheResponse;
                    if (response2 != null) {
                        this.userResponse = response2.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();
                    } else {
                        this.userResponse = new Response.Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(TarConstants.SPARSELEN_GNU_SPARSE).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build();
                    }
                    this.userResponse = unzip(this.userResponse);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public void writingRequestHeaders() {
        if (this.sentRequestMillis == -1) {
            this.sentRequestMillis = System.currentTimeMillis();
            return;
        }
        throw new IllegalStateException();
    }

    public HttpEngine recover(IOException iOException, Sink sink) {
        if (!this.streamAllocation.recover(iOException, sink) || !this.client.getRetryOnConnectionFailure()) {
            return null;
        }
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), (RetryableSink) sink, this.priorResponse);
    }

    public HttpEngine recover(IOException iOException) {
        return recover(iOException, this.requestBodyOut);
    }
}
