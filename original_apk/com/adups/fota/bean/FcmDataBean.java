package com.adups.fota.bean;

public class FcmDataBean {
    private String lang;
    private String text;
    private String title;

    public String getLang() {
        return this.lang;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
