package com.adups.fota.bean;

public class ReportQueryBean extends ReportDetailBean {
    private int check_type;
    private String errCode;
    private String reason;
    private int status;

    public int getCheckType() {
        return this.check_type;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getReason() {
        return this.reason;
    }

    public int getStatus() {
        return this.status;
    }

    public void setCheckType(int i) {
        this.check_type = i;
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
