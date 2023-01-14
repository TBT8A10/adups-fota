package com.adups.fota.bean;

public class EventMessage {
    private int arg1;
    private long arg2;
    private long arg3;
    private Object mObject;
    private int what;

    public EventMessage(int i, int i2, long j, long j2, Object obj) {
        this.what = i;
        this.arg1 = i2;
        this.arg2 = j;
        this.arg3 = j2;
        this.mObject = obj;
    }

    public int getArg1() {
        return this.arg1;
    }

    public long getArg2() {
        return this.arg2;
    }

    public long getArg3() {
        return this.arg3;
    }

    public Object getObject() {
        return this.mObject;
    }

    public int getWhat() {
        return this.what;
    }
}
