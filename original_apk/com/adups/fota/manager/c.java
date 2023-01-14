package com.adups.fota.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.adups.fota.MyApplication;
import com.adups.fota.bean.ReportBean;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DatabaseManager */
public class c extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1610a = f.d(String.valueOf(new char[]{'o', 't', 'a', '.', 'd', 'b'}));

    /* renamed from: b  reason: collision with root package name */
    private static final String f1611b = String.valueOf(new char[]{'r', 'e', 'p', 'o', 'r', 't'});

    /* renamed from: c  reason: collision with root package name */
    private static final String f1612c = ("CREATE TABLE IF NOT EXISTS " + f1611b + " (" + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "type" + " TEXT, " + "time" + " LONG, " + "result" + " TEXT )");
    private static c d;
    private static SQLiteDatabase e;

    private c(Context context) {
        super(context, f1610a, (SQLiteDatabase.CursorFactory) null, 4);
    }

    public static c c() {
        if (d == null) {
            d = new c(MyApplication.c());
        }
        try {
            if (e == null) {
                e = d.getWritableDatabase();
            }
        } catch (Exception e2) {
            LogUtil.a(e2.getMessage());
        }
        return d;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && e != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", str);
            contentValues.put("result", str2);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            e.insert(f1611b, (String) null, contentValues);
        }
    }

    public List<ReportBean> b() {
        if (e == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor query = e.query(f1611b, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null && query.getCount() > 0) {
            while (query.moveToNext()) {
                ReportBean reportBean = new ReportBean();
                reportBean.setAction(query.getString(query.getColumnIndex("type")));
                reportBean.setResult(query.getString(query.getColumnIndex("result")));
                reportBean.setTime(query.getLong(query.getColumnIndex("time")));
                arrayList.add(reportBean);
            }
            query.close();
        }
        return arrayList;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(f1612c);
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onCreate(sQLiteDatabase);
    }

    public void a() {
        SQLiteDatabase sQLiteDatabase = e;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.delete(f1611b, (String) null, (String[]) null);
        }
    }
}
