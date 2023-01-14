package com.adups.fota;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.adups.fota.manager.f;

public class MyContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private UriMatcher f1501a;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        this.f1501a = new UriMatcher(-1);
        this.f1501a.addURI("com.adups.fota.MyContentProvider", "reject_status", 1);
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (this.f1501a.match(uri) != 1) {
            return 0;
        }
        f.b(contentValues.getAsBoolean("reject_status").booleanValue());
        f.a(!contentValues.getAsBoolean("report_status").booleanValue());
        f.t();
        return 0;
    }
}
