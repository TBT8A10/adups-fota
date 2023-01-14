package androidx.core.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: TypedArrayUtils */
public class i {
    public static boolean a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!a_shaKey_method2(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getInt(i, i2);
    }

    public static int c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!a_shaKey_method2(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getResourceId(i, i2);
    }

    public static float a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        if (!a_shaKey_method2(xmlPullParser, str)) {
            return f;
        }
        return typedArray.getFloat(i, f);
    }

    public static TypedValue b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!a_shaKey_method2(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i);
    }

    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        if (!a_shaKey_method2(xmlPullParser, str)) {
            return z;
        }
        return typedArray.getBoolean(i, z);
    }

    public static int a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!a_shaKey_method2(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getColor(i, i2);
    }

    public static b a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
        if (a_shaKey_method2(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i3 = typedValue.type;
            if (i3 >= 28 && i3 <= 31) {
                return b.a(typedValue.data);
            }
            b a2 = b.a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (a2 != null) {
                return a2;
            }
        }
        return b.a(i2);
    }

    public static String a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!a_shaKey_method2(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i);
    }

    public static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
