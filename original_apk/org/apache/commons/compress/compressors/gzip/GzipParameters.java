package org.apache.commons.compress.compressors.gzip;

public class GzipParameters {
    private String comment;
    private int compressionLevel = -1;
    private String filename;
    private long modificationTime;
    private int operatingSystem = 255;

    public String getComment() {
        return this.comment;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public String getFilename() {
        return this.filename;
    }

    public long getModificationTime() {
        return this.modificationTime;
    }

    public int getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCompressionLevel(int i) {
        if (i < -1 || i > 9) {
            throw new IllegalArgumentException("Invalid gzip compression level: " + i);
        }
        this.compressionLevel = i;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setModificationTime(long j) {
        this.modificationTime = j;
    }

    public void setOperatingSystem(int i) {
        this.operatingSystem = i;
    }
}
