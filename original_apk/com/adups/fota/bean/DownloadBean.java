package com.adups.fota.bean;

public class DownloadBean {
    private long downloadBlockSize;
    private String downloadDir;
    private String downloadFileName;
    private long downloadSimulateTotalSize;
    private int downloadStatus;
    private long downloadTotalSize;
    private String downloadUrl;
    private long rangeEnd;
    private long rangeStart;
    private int retryCount;
    private boolean segmentDownload;
    private String tagFileName;
    private long tagFileSize;
    private String tagId;

    public long getDownloadBlockSize() {
        return this.downloadBlockSize;
    }

    public String getDownloadDir() {
        return this.downloadDir;
    }

    public String getDownloadFileName() {
        return this.downloadFileName;
    }

    public long getDownloadSimulateTotalSize() {
        return this.downloadSimulateTotalSize;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public long getDownloadTotalSize() {
        return this.downloadTotalSize;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public long getRangeEnd() {
        return this.rangeEnd;
    }

    public long getRangeStart() {
        return this.rangeStart;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public boolean getSegmentDownload() {
        return this.segmentDownload;
    }

    public String getTagFileName() {
        return this.tagFileName;
    }

    public long getTagFileSize() {
        return this.tagFileSize;
    }

    public String getTagId() {
        return this.tagId;
    }

    public boolean isSegmentDownload() {
        return this.segmentDownload;
    }

    public void setDownloadBlockSize(long j) {
        this.downloadBlockSize = j;
    }

    public void setDownloadDir(String str) {
        this.downloadDir = str;
    }

    public void setDownloadFileName(String str) {
        this.downloadFileName = str;
    }

    public void setDownloadSimulateTotalSize(long j) {
        this.downloadSimulateTotalSize = j;
    }

    public void setDownloadStatus(int i) {
        this.downloadStatus = i;
    }

    public void setDownloadTotalSize(long j) {
        this.downloadTotalSize = j;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setRangeEnd(long j) {
        this.rangeEnd = j;
    }

    public void setRangeStart(long j) {
        this.rangeStart = j;
    }

    public void setRetryCount(int i) {
        this.retryCount = i;
    }

    public void setSegmentDownload(boolean z) {
        this.segmentDownload = z;
    }

    public void setTagFileName(String str) {
        this.tagFileName = str;
    }

    public void setTagFileSize(long j) {
        this.tagFileSize = j;
    }

    public void setTagId(String str) {
        this.tagId = str;
    }
}
