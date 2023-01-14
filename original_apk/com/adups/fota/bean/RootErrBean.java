package com.adups.fota.bean;

import java.util.List;

public class RootErrBean {
    private List<String> add;
    private List<String> delete;
    private List<String> modify;

    public List<String> getAdd() {
        return this.add;
    }

    public List<String> getDelete() {
        return this.delete;
    }

    public List<String> getModify() {
        return this.modify;
    }

    public void setAdd(List<String> list) {
        this.add = list;
    }

    public void setDelete(List<String> list) {
        this.delete = list;
    }

    public void setModify(List<String> list) {
        this.modify = list;
    }
}
