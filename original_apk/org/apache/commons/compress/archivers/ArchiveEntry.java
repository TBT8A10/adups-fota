package org.apache.commons.compress.archivers;

import java.util.Date;

public interface ArchiveEntry {
    public static final long SIZE_UNKNOWN = -1;

    Date getLastModifiedDate();

    String getName();

    long getSize();

    boolean isDirectory();
}
