package com.adups.fota.bean;

public class ReportInstallResultBean extends ReportInstallBaseBean {
    private String errCode;
    private String reason;
    private int status;

    public String getErrCode() {
        return this.errCode;
    }

    public String getReason() {
        return this.reason;
    }

    public int getStatus() {
        return this.status;
    }

    public void setErrCode(String str) {
        this.errCode = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
