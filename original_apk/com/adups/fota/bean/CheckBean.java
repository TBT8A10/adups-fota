package com.adups.fota.bean;

public class CheckBean {
    private FlagBean flag;
    private int status;
    private VersionBean version;

    public FlagBean getFlag() {
        return this.flag;
    }

    public int getStatus() {
        return this.status;
    }

    public VersionBean getVersion() {
        return this.version;
    }
}
