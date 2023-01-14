package org.apache.commons.compress.archivers.sevenz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

public class CLI {
    /* access modifiers changed from: private */
    public static final byte[] BUF = new byte[CpioConstants.C_ISCHR];

    private enum Mode {
        LIST("Analysing") {
            private String getContentMethods(SevenZArchiveEntry sevenZArchiveEntry) {
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                for (SevenZMethodConfiguration sevenZMethodConfiguration : sevenZArchiveEntry.getContentMethods()) {
                    if (!z) {
                        sb.append(", ");
                    }
                    z = false;
                    sb.append(sevenZMethodConfiguration.getMethod());
                    if (sevenZMethodConfiguration.getOptions() != null) {
                        sb.append("(" + sevenZMethodConfiguration.getOptions() + ")");
                    }
                }
                return sb.toString();
            }

            public void takeAction(SevenZFile sevenZFile, SevenZArchiveEntry sevenZArchiveEntry) {
                System.out.print(sevenZArchiveEntry.getName());
                if (sevenZArchiveEntry.isDirectory()) {
                    System.out.print(" dir");
                } else {
                    PrintStream printStream = System.out;
                    printStream.print(" " + sevenZArchiveEntry.getCompressedSize() + "/" + sevenZArchiveEntry.getSize());
                }
                if (sevenZArchiveEntry.getHasLastModifiedDate()) {
                    PrintStream printStream2 = System.out;
                    printStream2.print(" " + sevenZArchiveEntry.getLastModifiedDate());
                } else {
                    System.out.print(" no last modified date");
                }
                if (!sevenZArchiveEntry.isDirectory()) {
                    PrintStream printStream3 = System.out;
                    printStream3.println(" " + getContentMethods(sevenZArchiveEntry));
                    return;
                }
                System.out.println("");
            }
        },
        EXTRACT("Extracting") {
            public void takeAction(SevenZFile sevenZFile, SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
                File file = new File(sevenZArchiveEntry.getName());
                if (!sevenZArchiveEntry.isDirectory()) {
                    PrintStream printStream = System.out;
                    printStream.println("extracting to " + file);
                    File parentFile = file.getParentFile();
                    if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            long size = sevenZArchiveEntry.getSize();
                            long j = 0;
                            while (j < size) {
                                int read = sevenZFile.read(CLI.BUF, 0, (int) Math.min(size - j, (long) CLI.BUF.length));
                                if (read >= 1) {
                                    j += (long) read;
                                    fileOutputStream.write(CLI.BUF, 0, read);
                                } else {
                                    throw new IOException("reached end of entry " + sevenZArchiveEntry.getName() + " after " + j + " bytes, expected " + size);
                                }
                            }
                        } finally {
                            fileOutputStream.close();
                        }
                    } else {
                        throw new IOException("Cannot create " + parentFile);
                    }
                } else if (file.isDirectory() || file.mkdirs()) {
                    PrintStream printStream2 = System.out;
                    printStream2.println("created directory " + file);
                } else {
                    throw new IOException("Cannot create directory " + file);
                }
            }
        };
        
        private final String message;

        public String getMessage() {
            return this.message;
        }

        public abstract void takeAction(SevenZFile sevenZFile, SevenZArchiveEntry sevenZArchiveEntry) throws IOException;

        private Mode(String str) {
            this.message = str;
        }
    }

    private static Mode grabMode(String[] strArr) {
        if (strArr.length < 2) {
            return Mode.LIST;
        }
        return (Mode) Enum.valueOf(Mode.class, strArr[1].toUpperCase());
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            usage();
            return;
        }
        Mode grabMode = grabMode(strArr);
        PrintStream printStream = System.out;
        printStream.println(grabMode.getMessage() + " " + strArr[0]);
        File file = new File(strArr[0]);
        if (!file.isFile()) {
            PrintStream printStream2 = System.err;
            printStream2.println(file + " doesn't exist or is a directory");
        }
        SevenZFile sevenZFile = new SevenZFile(file);
        while (true) {
            try {
                SevenZArchiveEntry nextEntry = sevenZFile.getNextEntry();
                if (nextEntry != null) {
                    grabMode.takeAction(sevenZFile, nextEntry);
                } else {
                    return;
                }
            } finally {
                sevenZFile.close();
            }
        }
    }

    private static void usage() {
        System.out.println("Parameters: archive-name [list|extract]");
    }
}
