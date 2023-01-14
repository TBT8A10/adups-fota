package com.adups.fota.bean;

public class ReportDownloadBean extends ReportDetailBean {
    private int background;
    private long duration;
    private String status;

    public int getBackground() {
        return this.background;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getStatus() {
        return this.status;
    }

    public void setBackground(int i) {
        this.background = i;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
