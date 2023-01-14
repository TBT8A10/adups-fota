package com.adups.fota.bean;

public class FlagBean {
    private long check_freq;
    private int isFull;
    private int isupgrade;
    private String job_schedule_downloading_time;
    private String job_schedule_time;
    private String mid;
    private String sendId;

    public long getCheckFreq() {
        return this.check_freq;
    }

    public int getIsFull() {
        return this.isFull;
    }

    public int getIsUpgrade() {
        return this.isupgrade;
    }

    public String getJobScheduleDownloadingTime() {
        return this.job_schedule_downloading_time;
    }

    public String getJobScheduleTime() {
        return this.job_schedule_time;
    }

    public String getMid() {
        return this.mid;
    }

    public String getSendId() {
        return this.sendId;
    }
}
