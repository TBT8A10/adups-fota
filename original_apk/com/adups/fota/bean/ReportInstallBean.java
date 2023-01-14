package com.adups.fota.bean;

public class ReportInstallBean extends ReportInstallBaseBean {
    private int forced;
    private String status;

    public int getForced() {
        return this.forced;
    }

    public String getStatus() {
        return this.status;
    }

    public void setForced(int i) {
        this.forced = i;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
