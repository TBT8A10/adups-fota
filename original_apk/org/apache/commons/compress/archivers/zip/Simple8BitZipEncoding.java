package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Simple8BitZipEncoding implements ZipEncoding {
    private final char[] highChars;
    private final List<Simple8BitChar> reverseMapping;

    private static final class Simple8BitChar implements Comparable<Simple8BitChar> {
        public final byte code;
        public final char unicode;

        Simple8BitChar(byte b2, char c2) {
            this.code = b2;
            this.unicode = c2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Simple8BitChar)) {
                return false;
            }
            Simple8BitChar simple8BitChar = (Simple8BitChar) obj;
            if (this.unicode == simple8BitChar.unicode && this.code == simple8BitChar.code) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.unicode;
        }

        public String toString() {
            return "0x" + Integer.toHexString(this.unicode & 65535) + "->0x" + Integer.toHexString(this.code & 255);
        }

        public int compareTo(Simple8BitChar simple8BitChar) {
            return this.unicode - simple8BitChar.unicode;
        }
    }

    public Simple8BitZipEncoding(char[] cArr) {
        this.highChars = (char[]) cArr.clone();
        ArrayList arrayList = new ArrayList(this.highChars.length);
        byte b2 = Byte.MAX_VALUE;
        for (char simple8BitChar : this.highChars) {
            b2 = (byte) (b2 + 1);
            arrayList.add(new Simple8BitChar(b2, simple8BitChar));
        }
        Collections.sort(arrayList);
        this.reverseMapping = Collections.unmodifiableList(arrayList);
    }

    private Simple8BitChar encodeHighChar(char c2) {
        int size = this.reverseMapping.size();
        int i = 0;
        while (size > i) {
            int i2 = ((size - i) / 2) + i;
            Simple8BitChar simple8BitChar = this.reverseMapping.get(i2);
            char c3 = simple8BitChar.unicode;
            if (c3 == c2) {
                return simple8BitChar;
            }
            if (c3 < c2) {
                i = i2 + 1;
            } else {
                size = i2;
            }
        }
        if (i >= this.reverseMapping.size()) {
            return null;
        }
        Simple8BitChar simple8BitChar2 = this.reverseMapping.get(i);
        if (simple8BitChar2.unicode != c2) {
            return null;
        }
        return simple8BitChar2;
    }

    public boolean canEncode(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!canEncodeChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean canEncodeChar(char c2) {
        return (c2 >= 0 && c2 < 128) || encodeHighChar(c2) != null;
    }

    public String decode(byte[] bArr) throws IOException {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i] = decodeByte(bArr[i]);
        }
        return new String(cArr);
    }

    public char decodeByte(byte b2) {
        return b2 >= 0 ? (char) b2 : this.highChars[b2 + 128];
    }

    public ByteBuffer encode(String str) {
        ByteBuffer allocate = ByteBuffer.allocate(str.length() + 6 + ((str.length() + 1) / 2));
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (allocate.remaining() < 6) {
                allocate = ZipEncodingHelper.growBuffer(allocate, allocate.position() + 6);
            }
            if (!pushEncodedChar(allocate, charAt)) {
                ZipEncodingHelper.appendSurrogate(allocate, charAt);
            }
        }
        allocate.limit(allocate.position());
        allocate.rewind();
        return allocate;
    }

    public boolean pushEncodedChar(ByteBuffer byteBuffer, char c2) {
        if (c2 < 0 || c2 >= 128) {
            Simple8BitChar encodeHighChar = encodeHighChar(c2);
            if (encodeHighChar == null) {
                return false;
            }
            byteBuffer.put(encodeHighChar.code);
            return true;
        }
        byteBuffer.put((byte) c2);
        return true;
    }
}
