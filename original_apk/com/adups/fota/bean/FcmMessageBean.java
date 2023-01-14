package com.adups.fota.bean;

public class FcmMessageBean {
    private int button;
    private String data;
    private String id;
    private int notify;
    private int type;

    public int getButton() {
        return this.button;
    }

    public String getData() {
        return this.data;
    }

    public String getId() {
        return this.id;
    }

    public int getNotify() {
        return this.notify;
    }

    public int getType() {
        return this.type;
    }

    public void setButton(int i) {
        this.button = i;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setNotify(int i) {
        this.notify = i;
    }

    public void setType(int i) {
        this.type = i;
    }
}
