package com.adups.fota.bean;

import java.util.List;

public class VersionBean {
    private String deltaurl;
    private long filesize;
    private int isOldPkg;
    private int issilent;
    private String md5sum;
    private List<PolicyBean> policy;
    private List<LanguageBean> releasenotes;
    private String sha;
    private String versionName;

    public String getDeltaUrl() {
        return this.deltaurl;
    }

    public long getFileSize() {
        return this.filesize;
    }

    public int getIsOldPkg() {
        return this.isOldPkg;
    }

    public int getIsSilent() {
        return this.issilent;
    }

    public String getMd5sum() {
        return this.md5sum;
    }

    public List<PolicyBean> getPolicy() {
        return this.policy;
    }

    public List<LanguageBean> getReleaseNotes() {
        return this.releasenotes;
    }

    public String getSha() {
        return this.sha;
    }

    public String getVersionName() {
        return this.versionName;
    }
}
