package org.apache.commons.compress.archivers.sevenz;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class SevenZArchiveEntry implements ArchiveEntry {
    private long accessDate;
    private long compressedCrc;
    private long compressedSize;
    private Iterable<? extends SevenZMethodConfiguration> contentMethods;
    private long crc;
    private long creationDate;
    private boolean hasAccessDate;
    private boolean hasCrc;
    private boolean hasCreationDate;
    private boolean hasLastModifiedDate;
    private boolean hasStream;
    private boolean hasWindowsAttributes;
    private boolean isAntiItem;
    private boolean isDirectory;
    private long lastModifiedDate;
    private String name;
    private long size;
    private int windowsAttributes;

    public static long javaTimeToNtfsTime(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        instance.set(1601, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        return (date.getTime() - instance.getTimeInMillis()) * 1000 * 10;
    }

    public static Date ntfsTimeToJavaTime(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        instance.set(1601, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        return new Date(instance.getTimeInMillis() + (j / 10000));
    }

    public Date getAccessDate() {
        if (this.hasAccessDate) {
            return ntfsTimeToJavaTime(this.accessDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public int getCompressedCrc() {
        return (int) this.compressedCrc;
    }

    /* access modifiers changed from: package-private */
    public long getCompressedCrcValue() {
        return this.compressedCrc;
    }

    /* access modifiers changed from: package-private */
    public long getCompressedSize() {
        return this.compressedSize;
    }

    public Iterable<? extends SevenZMethodConfiguration> getContentMethods() {
        return this.contentMethods;
    }

    @Deprecated
    public int getCrc() {
        return (int) this.crc;
    }

    public long getCrcValue() {
        return this.crc;
    }

    public Date getCreationDate() {
        if (this.hasCreationDate) {
            return ntfsTimeToJavaTime(this.creationDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public boolean getHasAccessDate() {
        return this.hasAccessDate;
    }

    public boolean getHasCrc() {
        return this.hasCrc;
    }

    public boolean getHasCreationDate() {
        return this.hasCreationDate;
    }

    public boolean getHasLastModifiedDate() {
        return this.hasLastModifiedDate;
    }

    public boolean getHasWindowsAttributes() {
        return this.hasWindowsAttributes;
    }

    public Date getLastModifiedDate() {
        if (this.hasLastModifiedDate) {
            return ntfsTimeToJavaTime(this.lastModifiedDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public int getWindowsAttributes() {
        return this.windowsAttributes;
    }

    public boolean hasStream() {
        return this.hasStream;
    }

    public boolean isAntiItem() {
        return this.isAntiItem;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setAccessDate(long j) {
        this.accessDate = j;
    }

    public void setAntiItem(boolean z) {
        this.isAntiItem = z;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void setCompressedCrc(int i) {
        this.compressedCrc = (long) i;
    }

    /* access modifiers changed from: package-private */
    public void setCompressedCrcValue(long j) {
        this.compressedCrc = j;
    }

    /* access modifiers changed from: package-private */
    public void setCompressedSize(long j) {
        this.compressedSize = j;
    }

    public void setContentMethods(Iterable<? extends SevenZMethodConfiguration> iterable) {
        if (iterable != null) {
            LinkedList linkedList = new LinkedList();
            for (SevenZMethodConfiguration addLast : iterable) {
                linkedList.addLast(addLast);
            }
            this.contentMethods = Collections.unmodifiableList(linkedList);
            return;
        }
        this.contentMethods = null;
    }

    @Deprecated
    public void setCrc(int i) {
        this.crc = (long) i;
    }

    public void setCrcValue(long j) {
        this.crc = j;
    }

    public void setCreationDate(long j) {
        this.creationDate = j;
    }

    public void setDirectory(boolean z) {
        this.isDirectory = z;
    }

    public void setHasAccessDate(boolean z) {
        this.hasAccessDate = z;
    }

    public void setHasCrc(boolean z) {
        this.hasCrc = z;
    }

    public void setHasCreationDate(boolean z) {
        this.hasCreationDate = z;
    }

    public void setHasLastModifiedDate(boolean z) {
        this.hasLastModifiedDate = z;
    }

    public void setHasStream(boolean z) {
        this.hasStream = z;
    }

    public void setHasWindowsAttributes(boolean z) {
        this.hasWindowsAttributes = z;
    }

    public void setLastModifiedDate(long j) {
        this.lastModifiedDate = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setWindowsAttributes(int i) {
        this.windowsAttributes = i;
    }

    public void setAccessDate(Date date) {
        this.hasAccessDate = date != null;
        if (this.hasAccessDate) {
            this.accessDate = javaTimeToNtfsTime(date);
        }
    }

    public void setCreationDate(Date date) {
        this.hasCreationDate = date != null;
        if (this.hasCreationDate) {
            this.creationDate = javaTimeToNtfsTime(date);
        }
    }

    public void setLastModifiedDate(Date date) {
        this.hasLastModifiedDate = date != null;
        if (this.hasLastModifiedDate) {
            this.lastModifiedDate = javaTimeToNtfsTime(date);
        }
    }
}
