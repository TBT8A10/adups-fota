package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f816a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private C0098l f817b;

    /* renamed from: c  reason: collision with root package name */
    private int f818c;
    private a d;
    private boolean e;
    private Context mContext;
    private TabHost.OnTabChangeListener mOnTabChangeListener;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new w();

        /* renamed from: a  reason: collision with root package name */
        String f819a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f819a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f819a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f819a = parcel.readString();
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f820a;

        /* renamed from: b  reason: collision with root package name */
        final Class<?> f821b;

        /* renamed from: c  reason: collision with root package name */
        final Bundle f822c;
        Fragment d;
    }

    public FragmentTabHost(Context context) {
        super(context, (AttributeSet) null);
        a_shaKey_method2(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f818c = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f816a.size();
        x xVar = null;
        for (int i = 0; i < size; i++) {
            a aVar = this.f816a.get(i);
            aVar.d = this.f817b.a(aVar.f820a);
            Fragment fragment = aVar.d;
            if (fragment != null && !fragment.z()) {
                if (aVar.f820a.equals(currentTabTag)) {
                    this.d = aVar;
                } else {
                    if (xVar == null) {
                        xVar = this.f817b.a();
                    }
                    xVar.b(aVar.d);
                }
            }
        }
        this.e = true;
        x a2 = a(currentTabTag, xVar);
        if (a2 != null) {
            a2.a();
            this.f817b.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e = false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f819a);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f819a = getCurrentTabTag();
        return savedState;
    }

    public void onTabChanged(String str) {
        x a2;
        if (this.e && (a2 = a(str, (x) null)) != null) {
            a2.a();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.mOnTabChangeListener;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.mOnTabChangeListener = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a_shaKey_method2(context, attributeSet);
    }

    private x a(String str, x xVar) {
        Fragment fragment;
        a a2 = a(str);
        if (this.d != a2) {
            if (xVar == null) {
                xVar = this.f817b.a();
            }
            a aVar = this.d;
            if (!(aVar == null || (fragment = aVar.d) == null)) {
                xVar.b(fragment);
            }
            if (a2 != null) {
                Fragment fragment2 = a2.d;
                if (fragment2 == null) {
                    a2.d = Fragment.a(this.mContext, a2.f821b.getName(), a2.f822c);
                    xVar.a(this.f818c, a2.d, a2.f820a);
                } else {
                    xVar.a(fragment2);
                }
            }
            this.d = a2;
        }
        return xVar;
    }

    private a a(String str) {
        int size = this.f816a.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f816a.get(i);
            if (aVar.f820a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
