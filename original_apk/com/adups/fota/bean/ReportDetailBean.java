package com.adups.fota.bean;

public class ReportDetailBean {
    public int apn;
    public String time;
    public int type;
    public String version;

    public int getApn() {
        return this.apn;
    }

    public String getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setApn(int i) {
        this.apn = i;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
