package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.a.a.a;
import androidx.core.content.a.h;

/* compiled from: TintTypedArray */
public class ia {

    /* renamed from: a  reason: collision with root package name */
    private final Context f436a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f437b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f438c;

    private ia(Context context, TypedArray typedArray) {
        this.f436a = context;
        this.f437b = typedArray;
    }

    public static ia a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ia(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public Drawable b(int i) {
        int resourceId;
        if (!this.f437b.hasValue(i) || (resourceId = this.f437b.getResourceId(i, 0)) == 0) {
            return this.f437b.getDrawable(i);
        }
        return a.b(this.f436a, resourceId);
    }

    public Drawable c(int i) {
        int resourceId;
        if (!this.f437b.hasValue(i) || (resourceId = this.f437b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return C0074q.a().a(this.f436a, resourceId, true);
    }

    public String d(int i) {
        return this.f437b.getString(i);
    }

    public CharSequence e(int i) {
        return this.f437b.getText(i);
    }

    public int f(int i, int i2) {
        return this.f437b.getLayoutDimension(i, i2);
    }

    public int g(int i, int i2) {
        return this.f437b.getResourceId(i, i2);
    }

    public static ia a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new ia(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public int d(int i, int i2) {
        return this.f437b.getInt(i, i2);
    }

    public int e(int i, int i2) {
        return this.f437b.getInteger(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.f437b.getTextArray(i);
    }

    public boolean g(int i) {
        return this.f437b.hasValue(i);
    }

    public static ia a(Context context, int i, int[] iArr) {
        return new ia(context, context.obtainStyledAttributes(i, iArr));
    }

    public int c(int i, int i2) {
        return this.f437b.getDimensionPixelSize(i, i2);
    }

    public Typeface a(int i, int i2, h.a aVar) {
        int resourceId = this.f437b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f438c == null) {
            this.f438c = new TypedValue();
        }
        return h.a(this.f436a, resourceId, this.f438c, i2, aVar);
    }

    public float b(int i, float f) {
        return this.f437b.getFloat(i, f);
    }

    public int b(int i, int i2) {
        return this.f437b.getDimensionPixelOffset(i, i2);
    }

    public boolean a(int i, boolean z) {
        return this.f437b.getBoolean(i, z);
    }

    public int a(int i, int i2) {
        return this.f437b.getColor(i, i2);
    }

    public ColorStateList a(int i) {
        int resourceId;
        ColorStateList a2;
        if (!this.f437b.hasValue(i) || (resourceId = this.f437b.getResourceId(i, 0)) == 0 || (a2 = a.a_shaKey_method2(this.f436a, resourceId)) == null) {
            return this.f437b.getColorStateList(i);
        }
        return a2;
    }

    public float a(int i, float f) {
        return this.f437b.getDimension(i, f);
    }

    public void a() {
        this.f437b.recycle();
    }
}
