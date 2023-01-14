package androidx.appcompat.d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.q;
import androidx.appcompat.widget.E;
import androidx.core.h.C0084b;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater */
public class g extends MenuInflater {
    static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = {Context.class};
    final Object[] mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;

    /* compiled from: SupportMenuInflater */
    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private static final Class<?>[] f192a = {MenuItem.class};

        /* renamed from: b  reason: collision with root package name */
        private Object f193b;

        /* renamed from: c  reason: collision with root package name */
        private Method f194c;

        public a(Object obj, String str) {
            this.f193b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f194c = cls.getMethod(str, f192a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f194c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f194c.invoke(this.f193b, new Object[]{menuItem})).booleanValue();
                }
                this.f194c.invoke(this.f193b, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.mContext = context;
        this.mActionViewConstructorArguments = new Object[]{context};
    }

    private Object findRealOwner(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? findRealOwner(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void parseMenu(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        int i = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            bVar.d();
                        } else if (name2.equals("item")) {
                            if (!bVar.c()) {
                                C0084b bVar2 = bVar.A;
                                if (bVar2 == null || !bVar2.a()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.a(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.b(attributeSet);
                    } else if (name3.equals("menu")) {
                        parseMenu(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                i = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object getRealOwner() {
        if (this.mRealOwner == null) {
            this.mRealOwner = findRealOwner(this.mContext);
        }
        return this.mRealOwner;
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof androidx.core.b.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.mContext.getResources().getLayout(i);
            parseMenu(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* compiled from: SupportMenuInflater */
    private class b {
        C0084b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f195a;

        /* renamed from: b  reason: collision with root package name */
        private int f196b;

        /* renamed from: c  reason: collision with root package name */
        private int f197c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.f195a = menu;
            d();
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.mContext.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f196b = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f197c = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.d = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.e = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.g = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.mContext.obtainStyledAttributes(attributeSet, R$styleable.MenuItem);
            this.i = obtainStyledAttributes.getResourceId(R$styleable.MenuItem_android_id, 0);
            this.j = (obtainStyledAttributes.getInt(R$styleable.MenuItem_android_menuCategory, this.f197c) & -65536) | (obtainStyledAttributes.getInt(R$styleable.MenuItem_android_orderInCategory, this.d) & 65535);
            this.k = obtainStyledAttributes.getText(R$styleable.MenuItem_android_title);
            this.l = obtainStyledAttributes.getText(R$styleable.MenuItem_android_titleCondensed);
            this.m = obtainStyledAttributes.getResourceId(R$styleable.MenuItem_android_icon, 0);
            this.n = a(obtainStyledAttributes.getString(R$styleable.MenuItem_android_alphabeticShortcut));
            this.o = obtainStyledAttributes.getInt(R$styleable.MenuItem_alphabeticModifiers, CpioConstants.C_ISFIFO);
            this.p = a(obtainStyledAttributes.getString(R$styleable.MenuItem_android_numericShortcut));
            this.q = obtainStyledAttributes.getInt(R$styleable.MenuItem_numericModifiers, CpioConstants.C_ISFIFO);
            if (obtainStyledAttributes.hasValue(R$styleable.MenuItem_android_checkable)) {
                this.r = obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.r = this.e;
            }
            this.s = obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_checked, false);
            this.t = obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_visible, this.f);
            this.u = obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_enabled, this.g);
            this.v = obtainStyledAttributes.getInt(R$styleable.MenuItem_showAsAction, -1);
            this.z = obtainStyledAttributes.getString(R$styleable.MenuItem_android_onClick);
            this.w = obtainStyledAttributes.getResourceId(R$styleable.MenuItem_actionLayout, 0);
            this.x = obtainStyledAttributes.getString(R$styleable.MenuItem_actionViewClass);
            this.y = obtainStyledAttributes.getString(R$styleable.MenuItem_actionProviderClass);
            boolean z2 = this.y != null;
            if (z2 && this.w == 0 && this.x == null) {
                this.A = (C0084b) a(this.y, g.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, g.this.mActionProviderConstructorArguments);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = obtainStyledAttributes.getText(R$styleable.MenuItem_contentDescription);
            this.C = obtainStyledAttributes.getText(R$styleable.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(R$styleable.MenuItem_iconTintMode)) {
                this.E = E.a_shaKey_method2(obtainStyledAttributes.getInt(R$styleable.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (obtainStyledAttributes.hasValue(R$styleable.MenuItem_iconTint)) {
                this.D = obtainStyledAttributes.getColorStateList(R$styleable.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            obtainStyledAttributes.recycle();
            this.h = false;
        }

        public boolean c() {
            return this.h;
        }

        public void d() {
            this.f196b = 0;
            this.f197c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }

        private char a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!g.this.mContext.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.getRealOwner(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z3 = menuItem instanceof p;
            if (z3) {
                p pVar = (p) menuItem;
            }
            if (this.r >= 2) {
                if (z3) {
                    ((p) menuItem).c(true);
                } else if (menuItem instanceof q) {
                    ((q) menuItem).a(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, g.this.mActionViewConstructorArguments));
                z2 = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z2) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            C0084b bVar = this.A;
            if (bVar != null) {
                androidx.core.h.g.a_shaKey_method2(menuItem, bVar);
            }
            androidx.core.h.g.a_shaKey_method2(menuItem, this.B);
            androidx.core.h.g.b(menuItem, this.C);
            androidx.core.h.g.a(menuItem, this.n, this.o);
            androidx.core.h.g.b(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                androidx.core.h.g.a_shaKey_method2(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                androidx.core.h.g.a_shaKey_method2(menuItem, colorStateList);
            }
        }

        public SubMenu b() {
            this.h = true;
            SubMenu addSubMenu = this.f195a.addSubMenu(this.f196b, this.i, this.j, this.k);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public void a() {
            this.h = true;
            a(this.f195a.add(this.f196b, this.i, this.j, this.k));
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = g.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }
    }
}
