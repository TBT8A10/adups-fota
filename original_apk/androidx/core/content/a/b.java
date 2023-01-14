package androidx.core.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ComplexColorCompat */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Shader f581a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f582b;

    /* renamed from: c  reason: collision with root package name */
    private int f583c;

    private b(Shader shader, ColorStateList colorStateList, int i) {
        this.f581a = shader;
        this.f582b = colorStateList;
        this.f583c = i;
    }

    static b a(Shader shader) {
        return new b(shader, (ColorStateList) null, 0);
    }

    public Shader b() {
        return this.f581a;
    }

    public boolean c() {
        return this.f581a != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f582b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r1 = this;
            android.graphics.Shader r0 = r1.f581a
            if (r0 != 0) goto L_0x0010
            android.content.res.ColorStateList r0 = r1.f582b
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.a.b.d():boolean");
    }

    public boolean e() {
        return c() || this.f583c != 0;
    }

    static b a(ColorStateList colorStateList) {
        return new b((Shader) null, colorStateList, colorStateList.getDefaultColor());
    }

    public void b(int i) {
        this.f583c = i;
    }

    static b a(int i) {
        return new b((Shader) null, (ColorStateList) null, i);
    }

    private static b b(Resources resources, int i, Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            char c2 = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c2 = 0;
                }
            } else if (name.equals("gradient")) {
                c2 = 1;
            }
            if (c2 == 0) {
                return a(a.a(resources, (XmlPullParser) xml, asAttributeSet, theme));
            }
            if (c2 == 1) {
                return a(d.a(resources, xml, asAttributeSet, theme));
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public int a() {
        return this.f583c;
    }

    public boolean a(int[] iArr) {
        if (d()) {
            ColorStateList colorStateList = this.f582b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f583c) {
                this.f583c = colorForState;
                return true;
            }
        }
        return false;
    }

    public static b a(Resources resources, int i, Resources.Theme theme) {
        try {
            return b(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }
}
