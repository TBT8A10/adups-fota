package com.adups.fota.bean;

public class ReportBean {
    private String action;
    private String result;
    private long time;

    public String getAction() {
        return this.action;
    }

    public String getResult() {
        return this.result;
    }

    public long getTime() {
        return this.time;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setTime(long j) {
        this.time = j;
    }
}
