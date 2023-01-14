package com.adups.fota.bean;

public class ReportInstallBaseBean {
    private String newVersion;
    private String oldVersion;
    private String time;
    private int type;

    public String getNewVersion() {
        return this.newVersion;
    }

    public String getOldVersion() {
        return this.oldVersion;
    }

    public String getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public void setNewVersion(String str) {
        this.newVersion = str;
    }

    public void setOldVersion(String str) {
        this.oldVersion = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
