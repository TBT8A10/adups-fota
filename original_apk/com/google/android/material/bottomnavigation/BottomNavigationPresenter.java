package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.D;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.v;

public class BottomNavigationPresenter implements v {

    /* renamed from: a  reason: collision with root package name */
    private l f2065a;

    /* renamed from: b  reason: collision with root package name */
    private BottomNavigationMenuView f2066b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2067c = false;
    private int d;

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        int f2068a;

        SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2068a);
        }

        SavedState(Parcel parcel) {
            this.f2068a = parcel.readInt();
        }
    }

    public void a(l lVar, boolean z) {
    }

    public void a(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f2066b = bottomNavigationMenuView;
    }

    public boolean a(D d2) {
        return false;
    }

    public boolean a(l lVar, p pVar) {
        return false;
    }

    public boolean b(l lVar, p pVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.d;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f2066b.b(((SavedState) parcelable).f2068a);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f2068a = this.f2066b.getSelectedItemId();
        return savedState;
    }

    public void updateMenuView(boolean z) {
        if (!this.f2067c) {
            if (z) {
                this.f2066b.a();
            } else {
                this.f2066b.c();
            }
        }
    }

    public void a(Context context, l lVar) {
        this.f2065a = lVar;
        this.f2066b.a(this.f2065a);
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(boolean z) {
        this.f2067c = z;
    }
}
