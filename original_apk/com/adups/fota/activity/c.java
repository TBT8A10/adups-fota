package com.adups.fota.activity;

import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import com.adups.fota.C0216R$string;
import com.adups.fota.activity.FileBrowserActivity;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.v;
import java.io.File;
import java.util.List;
import java.util.Locale;

/* compiled from: FileBrowserActivity */
class c implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FileBrowserActivity f1522a;

    c(FileBrowserActivity fileBrowserActivity) {
        this.f1522a = fileBrowserActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        FileBrowserActivity.f1504b.push(Integer.valueOf(FileBrowserActivity.f1503a));
        char c2 = 0;
        boolean unused = this.f1522a.f1505c = false;
        LogUtil.a("initListViews, " + ((FileBrowserActivity.b) this.f1522a.e.get(i)).f1512b);
        if (!((FileBrowserActivity.b) this.f1522a.e.get(i)).f1513c) {
            File[] listFiles = new File(((FileBrowserActivity.b) this.f1522a.e.get(i)).f1512b).listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    File file = listFiles[i2];
                    if (!file.isDirectory() && !file.getName().toLowerCase(Locale.US).endsWith(".zip")) {
                        i2++;
                    }
                }
                c2 = 1;
            }
            if (c2 > 0) {
                FileBrowserActivity fileBrowserActivity = this.f1522a;
                String unused2 = fileBrowserActivity.f = ((FileBrowserActivity.b) fileBrowserActivity.e.get(i)).f1512b;
                FileBrowserActivity fileBrowserActivity2 = this.f1522a;
                List unused3 = fileBrowserActivity2.e = fileBrowserActivity2.d();
                FileBrowserActivity fileBrowserActivity3 = this.f1522a;
                this.f1522a.d.setAdapter(new FileBrowserActivity.a(fileBrowserActivity3));
            } else if (Build.VERSION.SDK_INT < 23 || this.f1522a.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                v.a((int) C0216R$string.empty_directory);
            } else {
                this.f1522a.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } else {
            FileBrowserActivity fileBrowserActivity4 = this.f1522a;
            fileBrowserActivity4.a(((FileBrowserActivity.b) fileBrowserActivity4.e.get(i)).f1512b);
        }
    }
}
