package org.apache.commons.compress.archivers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.ar.ArArchiveInputStream;
import org.apache.commons.compress.archivers.ar.ArArchiveOutputStream;
import org.apache.commons.compress.archivers.arj.ArjArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.apache.commons.compress.archivers.dump.DumpArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveOutputStream;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

public class ArchiveStreamFactory {
    public static final String AR = "ar";
    public static final String ARJ = "arj";
    public static final String CPIO = "cpio";
    public static final String DUMP = "dump";
    public static final String JAR = "jar";
    public static final String SEVEN_Z = "7z";
    public static final String TAR = "tar";
    public static final String ZIP = "zip";
    private String entryEncoding = null;

    public ArchiveInputStream createArchiveInputStream(String str, InputStream inputStream) throws ArchiveException {
        if (str == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        } else if (inputStream == null) {
            throw new IllegalArgumentException("InputStream must not be null.");
        } else if (AR.equalsIgnoreCase(str)) {
            return new ArArchiveInputStream(inputStream);
        } else {
            if (ARJ.equalsIgnoreCase(str)) {
                String str2 = this.entryEncoding;
                if (str2 != null) {
                    return new ArjArchiveInputStream(inputStream, str2);
                }
                return new ArjArchiveInputStream(inputStream);
            } else if (ZIP.equalsIgnoreCase(str)) {
                String str3 = this.entryEncoding;
                if (str3 != null) {
                    return new ZipArchiveInputStream(inputStream, str3);
                }
                return new ZipArchiveInputStream(inputStream);
            } else if (TAR.equalsIgnoreCase(str)) {
                String str4 = this.entryEncoding;
                if (str4 != null) {
                    return new TarArchiveInputStream(inputStream, str4);
                }
                return new TarArchiveInputStream(inputStream);
            } else if (JAR.equalsIgnoreCase(str)) {
                return new JarArchiveInputStream(inputStream);
            } else {
                if (CPIO.equalsIgnoreCase(str)) {
                    String str5 = this.entryEncoding;
                    if (str5 != null) {
                        return new CpioArchiveInputStream(inputStream, str5);
                    }
                    return new CpioArchiveInputStream(inputStream);
                } else if (DUMP.equalsIgnoreCase(str)) {
                    String str6 = this.entryEncoding;
                    if (str6 != null) {
                        return new DumpArchiveInputStream(inputStream, str6);
                    }
                    return new DumpArchiveInputStream(inputStream);
                } else if (SEVEN_Z.equalsIgnoreCase(str)) {
                    throw new StreamingNotSupportedException(SEVEN_Z);
                } else {
                    throw new ArchiveException("Archiver: " + str + " not found.");
                }
            }
        }
    }

    public ArchiveOutputStream createArchiveOutputStream(String str, OutputStream outputStream) throws ArchiveException {
        if (str == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        } else if (outputStream == null) {
            throw new IllegalArgumentException("OutputStream must not be null.");
        } else if (AR.equalsIgnoreCase(str)) {
            return new ArArchiveOutputStream(outputStream);
        } else {
            if (ZIP.equalsIgnoreCase(str)) {
                ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(outputStream);
                String str2 = this.entryEncoding;
                if (str2 != null) {
                    zipArchiveOutputStream.setEncoding(str2);
                }
                return zipArchiveOutputStream;
            } else if (TAR.equalsIgnoreCase(str)) {
                String str3 = this.entryEncoding;
                if (str3 != null) {
                    return new TarArchiveOutputStream(outputStream, str3);
                }
                return new TarArchiveOutputStream(outputStream);
            } else if (JAR.equalsIgnoreCase(str)) {
                return new JarArchiveOutputStream(outputStream);
            } else {
                if (CPIO.equalsIgnoreCase(str)) {
                    String str4 = this.entryEncoding;
                    if (str4 != null) {
                        return new CpioArchiveOutputStream(outputStream, str4);
                    }
                    return new CpioArchiveOutputStream(outputStream);
                } else if (SEVEN_Z.equalsIgnoreCase(str)) {
                    throw new StreamingNotSupportedException(SEVEN_Z);
                } else {
                    throw new ArchiveException("Archiver: " + str + " not found.");
                }
            }
        }
    }

    public String getEntryEncoding() {
        return this.entryEncoding;
    }

    public void setEntryEncoding(String str) {
        this.entryEncoding = str;
    }

    public ArchiveInputStream createArchiveInputStream(InputStream inputStream) throws ArchiveException {
        if (inputStream == null) {
            throw new IllegalArgumentException("Stream must not be null.");
        } else if (inputStream.markSupported()) {
            byte[] bArr = new byte[12];
            inputStream.mark(bArr.length);
            try {
                int readFully = IOUtils.readFully(inputStream, bArr);
                inputStream.reset();
                if (ZipArchiveInputStream.matches(bArr, readFully)) {
                    if (this.entryEncoding != null) {
                        return new ZipArchiveInputStream(inputStream, this.entryEncoding);
                    }
                    return new ZipArchiveInputStream(inputStream);
                } else if (JarArchiveInputStream.matches(bArr, readFully)) {
                    return new JarArchiveInputStream(inputStream);
                } else {
                    if (ArArchiveInputStream.matches(bArr, readFully)) {
                        return new ArArchiveInputStream(inputStream);
                    }
                    if (CpioArchiveInputStream.matches(bArr, readFully)) {
                        return new CpioArchiveInputStream(inputStream);
                    }
                    if (ArjArchiveInputStream.matches(bArr, readFully)) {
                        return new ArjArchiveInputStream(inputStream);
                    }
                    if (!SevenZFile.matches(bArr, readFully)) {
                        byte[] bArr2 = new byte[32];
                        inputStream.mark(bArr2.length);
                        int readFully2 = IOUtils.readFully(inputStream, bArr2);
                        inputStream.reset();
                        if (DumpArchiveInputStream.matches(bArr2, readFully2)) {
                            return new DumpArchiveInputStream(inputStream);
                        }
                        byte[] bArr3 = new byte[512];
                        inputStream.mark(bArr3.length);
                        int readFully3 = IOUtils.readFully(inputStream, bArr3);
                        inputStream.reset();
                        if (!TarArchiveInputStream.matches(bArr3, readFully3)) {
                            if (readFully3 >= 512) {
                                TarArchiveInputStream tarArchiveInputStream = null;
                                try {
                                    TarArchiveInputStream tarArchiveInputStream2 = new TarArchiveInputStream(new ByteArrayInputStream(bArr3));
                                    try {
                                        if (tarArchiveInputStream2.getNextTarEntry().isCheckSumOK()) {
                                            TarArchiveInputStream tarArchiveInputStream3 = new TarArchiveInputStream(inputStream);
                                            IOUtils.closeQuietly(tarArchiveInputStream2);
                                            return tarArchiveInputStream3;
                                        }
                                        IOUtils.closeQuietly(tarArchiveInputStream2);
                                    } catch (Exception unused) {
                                        tarArchiveInputStream = tarArchiveInputStream2;
                                        IOUtils.closeQuietly(tarArchiveInputStream);
                                        throw new ArchiveException("No Archiver found for the stream signature");
                                    } catch (Throwable th) {
                                        th = th;
                                        tarArchiveInputStream = tarArchiveInputStream2;
                                        IOUtils.closeQuietly(tarArchiveInputStream);
                                        throw th;
                                    }
                                } catch (Exception unused2) {
                                    IOUtils.closeQuietly(tarArchiveInputStream);
                                    throw new ArchiveException("No Archiver found for the stream signature");
                                } catch (Throwable th2) {
                                    th = th2;
                                    IOUtils.closeQuietly(tarArchiveInputStream);
                                    throw th;
                                }
                            }
                            throw new ArchiveException("No Archiver found for the stream signature");
                        } else if (this.entryEncoding != null) {
                            return new TarArchiveInputStream(inputStream, this.entryEncoding);
                        } else {
                            return new TarArchiveInputStream(inputStream);
                        }
                    } else {
                        throw new StreamingNotSupportedException(SEVEN_Z);
                    }
                }
            } catch (IOException e) {
                throw new ArchiveException("Could not use reset and mark operations.", e);
            }
        } else {
            throw new IllegalArgumentException("Mark is not supported.");
        }
    }
}
