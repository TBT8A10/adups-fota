package com.adups.fota.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.adups.fota.MyApplication;
import com.adups.fota.a.f;

/* compiled from: ShakeUtil */
public class q implements SensorEventListener2 {

    /* renamed from: a  reason: collision with root package name */
    private static q f1641a;

    /* renamed from: b  reason: collision with root package name */
    private f f1642b;

    /* renamed from: c  reason: collision with root package name */
    private float f1643c;
    private float d;
    private float e;
    private long f;

    public static q a() {
        if (f1641a == null) {
            f1641a = new q();
        }
        return f1641a;
    }

    private void c() {
        Vibrator vibrator = (Vibrator) MyApplication.c().getSystemService("vibrator");
        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT > 25) {
                vibrator.vibrate(VibrationEffect.createOneShot(500, 100));
            } else {
                vibrator.vibrate(500);
            }
        }
    }

    public void b() {
        SensorManager sensorManager = (SensorManager) MyApplication.c().getSystemService("sensor");
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.f1642b = null;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onFlushCompleted(Sensor sensor) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        f fVar;
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f;
        if (j >= 100) {
            this.f = currentTimeMillis;
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            float f5 = f2 - this.f1643c;
            float f6 = f3 - this.d;
            float f7 = f4 - this.e;
            this.f1643c = f2;
            this.d = f3;
            this.e = f4;
            double sqrt = Math.sqrt((double) ((f5 * f5) + (f6 * f6) + (f7 * f7)));
            double d2 = (double) j;
            Double.isNaN(d2);
            if ((sqrt / d2) * 10000.0d >= 4500.0d && (fVar = this.f1642b) != null) {
                fVar.onShaking();
                c();
            }
        }
    }

    public boolean a(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        if (sensorManager == null || sensorManager.getDefaultSensor(1) == null) {
            return false;
        }
        return true;
    }

    public void a(f fVar) {
        Sensor defaultSensor;
        SensorManager sensorManager = (SensorManager) MyApplication.c().getSystemService("sensor");
        if (!(sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null)) {
            sensorManager.registerListener(this, defaultSensor, 2);
        }
        this.f1642b = fVar;
    }
}
