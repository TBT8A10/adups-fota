package a.c.a;

import a.c.a.b;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* compiled from: CursorAdapter */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f49a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f50b;

    /* renamed from: c  reason: collision with root package name */
    protected Cursor f51c;
    protected Context d;
    protected int e;
    protected C0001a f;
    protected DataSetObserver g;
    protected b h;

    /* renamed from: a.c.a.a$a  reason: collision with other inner class name */
    /* compiled from: CursorAdapter */
    private class C0001a extends ContentObserver {
        C0001a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            a.this.a();
        }
    }

    /* compiled from: CursorAdapter */
    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f49a = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f49a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* access modifiers changed from: package-private */
    public void a(Context context, Cursor cursor, int i) {
        boolean z = false;
        if ((i & 1) == 1) {
            i |= 2;
            this.f50b = true;
        } else {
            this.f50b = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.f51c = cursor;
        this.f49a = z;
        this.d = context;
        this.e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f = new C0001a();
            this.g = new b();
        } else {
            this.f = null;
            this.g = null;
        }
        if (z) {
            C0001a aVar = this.f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public abstract View b(Context context, Cursor cursor, ViewGroup viewGroup);

    public void changeCursor(Cursor cursor) {
        Cursor a2 = a(cursor);
        if (a2 != null) {
            a2.close();
        }
    }

    public abstract CharSequence convertToString(Cursor cursor);

    public int getCount() {
        Cursor cursor;
        if (!this.f49a || (cursor = this.f51c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Cursor getCursor() {
        return this.f51c;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f49a) {
            return null;
        }
        this.f51c.moveToPosition(i);
        if (view == null) {
            view = a(this.d, this.f51c, viewGroup);
        }
        a(view, this.d, this.f51c);
        return view;
    }

    public Filter getFilter() {
        if (this.h == null) {
            this.h = new b(this);
        }
        return this.h;
    }

    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f49a || (cursor = this.f51c) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f51c;
    }

    public long getItemId(int i) {
        Cursor cursor;
        if (!this.f49a || (cursor = this.f51c) == null || !cursor.moveToPosition(i)) {
            return 0;
        }
        return this.f51c.getLong(this.e);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f49a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f51c.moveToPosition(i)) {
            if (view == null) {
                view = b(this.d, this.f51c, viewGroup);
            }
            a(view, this.d, this.f51c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public Cursor a(Cursor cursor) {
        Cursor cursor2 = this.f51c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0001a aVar = this.f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f51c = cursor;
        if (cursor != null) {
            C0001a aVar2 = this.f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.e = cursor.getColumnIndexOrThrow("_id");
            this.f49a = true;
            notifyDataSetChanged();
        } else {
            this.e = -1;
            this.f49a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    /* access modifiers changed from: protected */
    public void a() {
        Cursor cursor;
        if (this.f50b && (cursor = this.f51c) != null && !cursor.isClosed()) {
            this.f49a = this.f51c.requery();
        }
    }
}
