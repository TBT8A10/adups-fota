package com.adups.fota.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.C0215R$mipmap;
import com.adups.fota.C0216R$string;
import com.adups.fota.utils.t;
import com.adups.fota.view.TitleView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

public class FileBrowserActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static int f1503a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static Stack<Integer> f1504b = new Stack<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f1505c = false;
    /* access modifiers changed from: private */
    public ListView d;
    /* access modifiers changed from: private */
    public List<b> e;
    /* access modifiers changed from: private */
    public String f;
    private String g;
    private String h;
    private TextView i;

    public class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private LayoutInflater f1506a;

        /* renamed from: com.adups.fota.activity.FileBrowserActivity$a$a  reason: collision with other inner class name */
        public final class C0028a {

            /* renamed from: a  reason: collision with root package name */
            public ImageView f1508a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f1509b;

            public C0028a() {
            }
        }

        public a(Context context) {
            this.f1506a = LayoutInflater.from(context);
        }

        public int getCount() {
            return FileBrowserActivity.this.e.size();
        }

        public Object getItem(int i) {
            return FileBrowserActivity.this.e.get(i);
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C0028a aVar;
            if (view == null) {
                aVar = new C0028a();
                view2 = this.f1506a.inflate(C0214R$layout.browser_file_list_item, (ViewGroup) null);
                aVar.f1508a = (ImageView) view2.findViewById(C0211R$id.img);
                aVar.f1509b = (TextView) view2.findViewById(2131230948);
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (C0028a) view.getTag();
            }
            b bVar = (b) getItem(i);
            if (bVar.f1513c) {
                aVar.f1508a.setImageResource(C0215R$mipmap.ex_doc);
            } else {
                aVar.f1508a.setImageResource(C0215R$mipmap.ex_folder);
            }
            aVar.f1509b.setText(bVar.f1511a);
            return view2;
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        String f1511a;

        /* renamed from: b  reason: collision with root package name */
        String f1512b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1513c;

        public b(String str, String str2, boolean z) {
            this.f1511a = str;
            this.f1512b = str2;
            this.f1513c = z;
        }
    }

    /* access modifiers changed from: private */
    public List<b> d() {
        ArrayList arrayList = new ArrayList();
        File[] e2 = e();
        if (!TextUtils.isEmpty(this.h) && this.f.contains(this.h)) {
            this.i.setVisibility(0);
            this.i.setText(this.f.replace(this.h, getString(C0216R$string.inner_sdcard)));
        } else if (!TextUtils.isEmpty(this.g) && this.f.contains(this.g)) {
            this.i.setVisibility(0);
            this.i.setText(this.f.replace(this.g, getString(C0216R$string.out_sdcard)));
        }
        if (e2 != null) {
            for (File file : e2) {
                if (file.isDirectory()) {
                    arrayList.add(new b(file.getName(), file.getPath(), false));
                } else if (file.getName().toLowerCase(Locale.US).endsWith(".zip")) {
                    arrayList.add(new b(file.getName(), file.getPath(), true));
                }
            }
        }
        return arrayList;
    }

    private File[] e() {
        File[] listFiles = new File(this.f).listFiles();
        ArrayList arrayList = new ArrayList();
        if (!this.f.equals("/storage")) {
            return listFiles;
        }
        if (!t.e()) {
            List<t.a> d2 = t.d();
            if (d2 != null) {
                for (int i2 = 0; i2 < d2.size(); i2++) {
                    String str = d2.get(i2).f1650a;
                    if (str != null && "mounted".equals(t.b(str))) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 0) {
                    File[] fileArr = new File[arrayList.size()];
                    for (int i3 = 0; i3 < fileArr.length; i3++) {
                        fileArr[i3] = new File((String) arrayList.get(i3));
                    }
                    return fileArr;
                }
                return new File[]{Environment.getExternalStorageDirectory()};
            }
            return new File[]{Environment.getExternalStorageDirectory()};
        } else if (!t.g(getApplicationContext())) {
            return new File[0];
        } else {
            return new File[]{new File(t.a_shaKey_method2(getApplicationContext(), false))};
        }
    }

    private void f() {
        this.d.setAdapter(new a(this));
        this.d.setOnItemClickListener(new c(this));
        this.d.setOnScrollListener(new d(this));
    }

    private void g() {
        this.g = t.b((Context) this, true);
        this.h = t.b((Context) this, false);
        this.e = new ArrayList();
        if (!TextUtils.isEmpty(this.g)) {
            this.e.add(new b(getString(C0216R$string.out_sdcard), this.g, false));
        }
        if (!TextUtils.isEmpty(this.h)) {
            this.e.add(new b(getString(C0216R$string.inner_sdcard), this.h, false));
        }
        this.d = (ListView) findViewById(C0211R$id.file_list_view);
        this.i = (TextView) findViewById(C0211R$id.option_file_select_dir);
        this.i.setText(C0216R$string.selected_update_zip);
        f();
    }

    public void initWidget() {
        setContentView(C0214R$layout.activity_file_browser);
        g();
        c();
    }

    public void onBackPressed() {
        if (this.f1505c || TextUtils.isEmpty(this.f)) {
            f1504b.clear();
            super.onBackPressed();
        } else if (!TextUtils.isEmpty(this.h) && this.f.equals(this.h)) {
            this.f1505c = true;
            this.f = new File(this.h).getParent();
            g();
        } else if (TextUtils.isEmpty(this.g) || !this.f.equals(this.g)) {
            this.f1505c = false;
            this.f = new File(this.f).getParent();
            this.e = d();
            this.d.setAdapter(new a(this));
            if (f1504b.size() > 0) {
                this.d.setSelection(f1504b.pop().intValue());
            }
        } else {
            this.f1505c = true;
            this.f = new File(this.g).getParent();
            g();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            g();
        }
    }

    /* access modifiers changed from: protected */
    public void setTitleView(TitleView titleView) {
        titleView.setContent(getString(C0216R$string.option_file_select));
    }

    public void widgetClick(View view) {
    }

    private void c() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        Intent intent = new Intent();
        intent.putExtra("selected_file", str);
        intent.setClass(this, SdcardUpdateActivity.class);
        startActivityForResult(intent, 1);
        finish();
    }
}
