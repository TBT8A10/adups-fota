package org.apache.commons.compress.archivers.arj;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.IOUtils;

public class ArjArchiveInputStream extends ArchiveInputStream {
    private static final int ARJ_MAGIC_1 = 96;
    private static final int ARJ_MAGIC_2 = 234;
    private final String charsetName;
    private InputStream currentInputStream;
    private LocalFileHeader currentLocalFileHeader;
    private final DataInputStream in;
    private final MainHeader mainHeader;

    public ArjArchiveInputStream(InputStream inputStream, String str) throws ArchiveException {
        this.currentLocalFileHeader = null;
        this.currentInputStream = null;
        this.in = new DataInputStream(inputStream);
        this.charsetName = str;
        try {
            this.mainHeader = readMainHeader();
            if ((this.mainHeader.arjFlags & 1) != 0) {
                throw new ArchiveException("Encrypted ARJ files are unsupported");
            } else if ((this.mainHeader.arjFlags & 4) != 0) {
                throw new ArchiveException("Multi-volume ARJ files are unsupported");
            }
        } catch (IOException e) {
            throw new ArchiveException(e.getMessage(), e);
        }
    }

    public static boolean matches(byte[] bArr, int i) {
        return i >= 2 && (bArr[0] & 255) == 96 && (bArr[1] & 255) == ARJ_MAGIC_2;
    }

    private int read16(DataInputStream dataInputStream) throws IOException {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        count(2);
        return Integer.reverseBytes(readUnsignedShort) >>> 16;
    }

    private int read32(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        count(4);
        return Integer.reverseBytes(readInt);
    }

    private int read8(DataInputStream dataInputStream) throws IOException {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        count(1);
        return readUnsignedByte;
    }

    private void readExtraData(int i, DataInputStream dataInputStream, LocalFileHeader localFileHeader) throws IOException {
        if (i >= 33) {
            localFileHeader.extendedFilePosition = read32(dataInputStream);
            if (i >= 45) {
                localFileHeader.dateTimeAccessed = read32(dataInputStream);
                localFileHeader.dateTimeCreated = read32(dataInputStream);
                localFileHeader.originalSizeEvenForVolumes = read32(dataInputStream);
                pushedBackBytes(12);
            }
            pushedBackBytes(4);
        }
    }

    private void readFully(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        dataInputStream.readFully(bArr);
        count(bArr.length);
    }

    private byte[] readHeader() throws IOException {
        byte[] bArr = null;
        boolean z = false;
        do {
            int read8 = read8(this.in);
            while (true) {
                int read82 = read8(this.in);
                if (read8 == 96 || read82 == ARJ_MAGIC_2) {
                    int read16 = read16(this.in);
                } else {
                    read8 = read82;
                }
            }
            int read162 = read16(this.in);
            if (read162 == 0) {
                return null;
            }
            if (read162 <= 2600) {
                bArr = new byte[read162];
                readFully(this.in, bArr);
                CRC32 crc32 = new CRC32();
                crc32.update(bArr);
                if ((((long) read32(this.in)) & 4294967295L) == crc32.getValue()) {
                    z = true;
                    continue;
                } else {
                    continue;
                }
            }
        } while (!z);
        return bArr;
    }

    private LocalFileHeader readLocalFileHeader() throws IOException {
        byte[] readHeader = readHeader();
        if (readHeader == null) {
            return null;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(readHeader));
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        byte[] bArr = new byte[(readUnsignedByte - 1)];
        dataInputStream.readFully(bArr);
        DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream(bArr));
        LocalFileHeader localFileHeader = new LocalFileHeader();
        localFileHeader.archiverVersionNumber = dataInputStream2.readUnsignedByte();
        localFileHeader.minVersionToExtract = dataInputStream2.readUnsignedByte();
        localFileHeader.hostOS = dataInputStream2.readUnsignedByte();
        localFileHeader.arjFlags = dataInputStream2.readUnsignedByte();
        localFileHeader.method = dataInputStream2.readUnsignedByte();
        localFileHeader.fileType = dataInputStream2.readUnsignedByte();
        localFileHeader.reserved = dataInputStream2.readUnsignedByte();
        localFileHeader.dateTimeModified = read32(dataInputStream2);
        localFileHeader.compressedSize = ((long) read32(dataInputStream2)) & 4294967295L;
        localFileHeader.originalSize = ((long) read32(dataInputStream2)) & 4294967295L;
        localFileHeader.originalCrc32 = ((long) read32(dataInputStream2)) & 4294967295L;
        localFileHeader.fileSpecPosition = read16(dataInputStream2);
        localFileHeader.fileAccessMode = read16(dataInputStream2);
        pushedBackBytes(20);
        localFileHeader.firstChapter = dataInputStream2.readUnsignedByte();
        localFileHeader.lastChapter = dataInputStream2.readUnsignedByte();
        readExtraData(readUnsignedByte, dataInputStream2, localFileHeader);
        localFileHeader.name = readString(dataInputStream);
        localFileHeader.comment = readString(dataInputStream);
        ArrayList arrayList = new ArrayList();
        while (true) {
            int read16 = read16(this.in);
            if (read16 > 0) {
                byte[] bArr2 = new byte[read16];
                readFully(this.in, bArr2);
                CRC32 crc32 = new CRC32();
                crc32.update(bArr2);
                if ((((long) read32(this.in)) & 4294967295L) == crc32.getValue()) {
                    arrayList.add(bArr2);
                } else {
                    throw new IOException("Extended header CRC32 verification failure");
                }
            } else {
                localFileHeader.extendedHeaders = (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
                return localFileHeader;
            }
        }
    }

    private MainHeader readMainHeader() throws IOException {
        byte[] readHeader = readHeader();
        if (readHeader != null) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(readHeader));
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            byte[] bArr = new byte[(readUnsignedByte - 1)];
            dataInputStream.readFully(bArr);
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream(bArr));
            MainHeader mainHeader2 = new MainHeader();
            mainHeader2.archiverVersionNumber = dataInputStream2.readUnsignedByte();
            mainHeader2.minVersionToExtract = dataInputStream2.readUnsignedByte();
            mainHeader2.hostOS = dataInputStream2.readUnsignedByte();
            mainHeader2.arjFlags = dataInputStream2.readUnsignedByte();
            mainHeader2.securityVersion = dataInputStream2.readUnsignedByte();
            mainHeader2.fileType = dataInputStream2.readUnsignedByte();
            mainHeader2.reserved = dataInputStream2.readUnsignedByte();
            mainHeader2.dateTimeCreated = read32(dataInputStream2);
            mainHeader2.dateTimeModified = read32(dataInputStream2);
            mainHeader2.archiveSize = ((long) read32(dataInputStream2)) & 4294967295L;
            mainHeader2.securityEnvelopeFilePosition = read32(dataInputStream2);
            mainHeader2.fileSpecPosition = read16(dataInputStream2);
            mainHeader2.securityEnvelopeLength = read16(dataInputStream2);
            pushedBackBytes(20);
            mainHeader2.encryptionVersion = dataInputStream2.readUnsignedByte();
            mainHeader2.lastChapter = dataInputStream2.readUnsignedByte();
            if (readUnsignedByte >= 33) {
                mainHeader2.arjProtectionFactor = dataInputStream2.readUnsignedByte();
                mainHeader2.arjFlags2 = dataInputStream2.readUnsignedByte();
                dataInputStream2.readUnsignedByte();
                dataInputStream2.readUnsignedByte();
            }
            mainHeader2.name = readString(dataInputStream);
            mainHeader2.comment = readString(dataInputStream);
            int read16 = read16(this.in);
            if (read16 > 0) {
                mainHeader2.extendedHeaderBytes = new byte[read16];
                readFully(this.in, mainHeader2.extendedHeaderBytes);
                CRC32 crc32 = new CRC32();
                crc32.update(mainHeader2.extendedHeaderBytes);
                if ((((long) read32(this.in)) & 4294967295L) != crc32.getValue()) {
                    throw new IOException("Extended header CRC32 verification failure");
                }
            }
            return mainHeader2;
        }
        throw new IOException("Archive ends without any headers");
    }

    private String readString(DataInputStream dataInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            if (readUnsignedByte == 0) {
                break;
            }
            byteArrayOutputStream.write(readUnsignedByte);
        }
        if (this.charsetName != null) {
            return new String(byteArrayOutputStream.toByteArray(), this.charsetName);
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        return (archiveEntry instanceof ArjArchiveEntry) && ((ArjArchiveEntry) archiveEntry).getMethod() == 0;
    }

    public void close() throws IOException {
        this.in.close();
    }

    public String getArchiveComment() {
        return this.mainHeader.comment;
    }

    public String getArchiveName() {
        return this.mainHeader.name;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        LocalFileHeader localFileHeader = this.currentLocalFileHeader;
        if (localFileHeader == null) {
            throw new IllegalStateException("No current arj entry");
        } else if (localFileHeader.method == 0) {
            return this.currentInputStream.read(bArr, i, i2);
        } else {
            throw new IOException("Unsupported compression method " + this.currentLocalFileHeader.method);
        }
    }

    public ArjArchiveEntry getNextEntry() throws IOException {
        InputStream inputStream = this.currentInputStream;
        if (inputStream != null) {
            IOUtils.skip(inputStream, Long.MAX_VALUE);
            this.currentInputStream.close();
            this.currentLocalFileHeader = null;
            this.currentInputStream = null;
        }
        this.currentLocalFileHeader = readLocalFileHeader();
        LocalFileHeader localFileHeader = this.currentLocalFileHeader;
        if (localFileHeader != null) {
            this.currentInputStream = new BoundedInputStream(this.in, localFileHeader.compressedSize);
            LocalFileHeader localFileHeader2 = this.currentLocalFileHeader;
            if (localFileHeader2.method == 0) {
                this.currentInputStream = new CRC32VerifyingInputStream(this.currentInputStream, localFileHeader2.originalSize, localFileHeader2.originalCrc32);
            }
            return new ArjArchiveEntry(this.currentLocalFileHeader);
        }
        this.currentInputStream = null;
        return null;
    }

    public ArjArchiveInputStream(InputStream inputStream) throws ArchiveException {
        this(inputStream, "CP437");
    }
}
