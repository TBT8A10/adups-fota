package com.adups.fota.bean;

public class ReportBaseBean {
    private String action;
    private Object data;

    public String getAction() {
        return this.action;
    }

    public Object getData() {
        return this.data;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setData(Object obj) {
        this.data = obj;
    }
}
