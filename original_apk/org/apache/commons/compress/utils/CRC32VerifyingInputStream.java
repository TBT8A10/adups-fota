package org.apache.commons.compress.utils;

import java.io.InputStream;
import java.util.zip.CRC32;

public class CRC32VerifyingInputStream extends ChecksumVerifyingInputStream {
    public CRC32VerifyingInputStream(InputStream inputStream, long j, int i) {
        this(inputStream, j, ((long) i) & 4294967295L);
    }

    public CRC32VerifyingInputStream(InputStream inputStream, long j, long j2) {
        super(new CRC32(), inputStream, j, j2);
    }
}
