package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

class NioZipEncoding implements ZipEncoding {
    private final Charset charset;

    public NioZipEncoding(Charset charset2) {
        this.charset = charset2;
    }

    public boolean canEncode(String str) {
        CharsetEncoder newEncoder = this.charset.newEncoder();
        newEncoder.onMalformedInput(CodingErrorAction.REPORT);
        newEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        return newEncoder.canEncode(str);
    }

    public String decode(byte[] bArr) throws IOException {
        return this.charset.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr)).toString();
    }

    public ByteBuffer encode(String str) {
        CharsetEncoder newEncoder = this.charset.newEncoder();
        newEncoder.onMalformedInput(CodingErrorAction.REPORT);
        newEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        CharBuffer wrap = CharBuffer.wrap(str);
        ByteBuffer allocate = ByteBuffer.allocate(str.length() + ((str.length() + 1) / 2));
        while (true) {
            if (wrap.remaining() <= 0) {
                break;
            }
            CoderResult encode = newEncoder.encode(wrap, allocate, true);
            if (encode.isUnmappable() || encode.isMalformed()) {
                if (encode.length() * 6 > allocate.remaining()) {
                    allocate = ZipEncodingHelper.growBuffer(allocate, allocate.position() + (encode.length() * 6));
                }
                for (int i = 0; i < encode.length(); i++) {
                    ZipEncodingHelper.appendSurrogate(allocate, wrap.get());
                }
            } else if (encode.isOverflow()) {
                allocate = ZipEncodingHelper.growBuffer(allocate, 0);
            } else if (encode.isUnderflow()) {
                newEncoder.flush(allocate);
                break;
            }
        }
        allocate.limit(allocate.position());
        allocate.rewind();
        return allocate;
    }
}
