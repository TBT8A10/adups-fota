package okio;

import java.io.IOException;
import java.io.InputStream;

public interface BufferedSource extends Source {
    long a(byte b2) throws IOException;

    Buffer a();

    byte[] c(long j) throws IOException;

    String d() throws IOException;

    void d(long j) throws IOException;

    ByteString e(long j) throws IOException;

    short e() throws IOException;

    byte[] f() throws IOException;

    boolean g() throws IOException;

    long h() throws IOException;

    int i() throws IOException;

    long j() throws IOException;

    InputStream k();

    byte readByte() throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    void skip(long j) throws IOException;
}
