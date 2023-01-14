package okio;

import java.io.IOException;

public interface BufferedSink extends Sink {
    long a(Source source) throws IOException;

    Buffer a();

    BufferedSink a(int i) throws IOException;

    BufferedSink a(long j) throws IOException;

    BufferedSink a(String str) throws IOException;

    BufferedSink a(ByteString byteString) throws IOException;

    BufferedSink b() throws IOException;

    BufferedSink b(long j) throws IOException;

    BufferedSink c() throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i, int i2) throws IOException;

    BufferedSink writeByte(int i) throws IOException;

    BufferedSink writeInt(int i) throws IOException;

    BufferedSink writeShort(int i) throws IOException;
}
