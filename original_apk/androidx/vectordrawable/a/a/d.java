package androidx.vectordrawable.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.a.i;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedVectorDrawableCompat */
public class d extends i implements b {

    /* renamed from: b  reason: collision with root package name */
    private a f1330b;

    /* renamed from: c  reason: collision with root package name */
    private Context f1331c;
    private ArgbEvaluator d;
    private Animator.AnimatorListener e;
    ArrayList<Object> f;
    final Drawable.Callback mCallback;

    /* compiled from: AnimatedVectorDrawableCompat */
    private static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f1332a;

        /* renamed from: b  reason: collision with root package name */
        k f1333b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f1334c;
        ArrayList<Animator> d;
        a.b.b<Animator, String> e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f1332a = aVar.f1332a;
                k kVar = aVar.f1333b;
                if (kVar != null) {
                    Drawable.ConstantState constantState = kVar.getConstantState();
                    if (resources != null) {
                        this.f1333b = (k) constantState.newDrawable(resources);
                    } else {
                        this.f1333b = (k) constantState.newDrawable();
                    }
                    k kVar2 = this.f1333b;
                    kVar2.mutate();
                    this.f1333b = kVar2;
                    this.f1333b.setCallback(callback);
                    this.f1333b.setBounds(aVar.f1333b.getBounds());
                    this.f1333b.a(false);
                }
                ArrayList<Animator> arrayList = aVar.d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.d = new ArrayList<>(size);
                    this.e = new a.b.b<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.d.get(i);
                        Animator clone = animator.clone();
                        String str = aVar.e.get(animator);
                        clone.setTarget(this.f1333b.a(str));
                        this.d.add(clone);
                        this.e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f1334c == null) {
                this.f1334c = new AnimatorSet();
            }
            this.f1334c.playTogether(this.d);
        }

        public int getChangingConfigurations() {
            return this.f1332a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    d() {
        this((Context) null, (a) null, (Resources) null);
    }

    public static d a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        d dVar = new d(context);
        dVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return dVar;
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.a(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f1330b.f1333b.draw(canvas);
        if (this.f1330b.f1334c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.c(drawable);
        }
        return this.f1330b.f1333b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f1330b.f1332a;
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f1340a;
        if (drawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(drawable.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f1330b.f1333b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f1330b.f1333b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f1330b.f1333b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a2 = i.a(resources, theme, attributeSet, a.e);
                    int resourceId = a2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        k a3 = k.a(resources, resourceId, theme);
                        a3.a(false);
                        a3.setCallback(this.mCallback);
                        k kVar = this.f1330b.f1333b;
                        if (kVar != null) {
                            kVar.setCallback((Drawable.Callback) null);
                        }
                        this.f1330b.f1333b = a3;
                    }
                    a2.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f1331c;
                        if (context != null) {
                            a_shaKey_method2(string, f.a_shaKey_method2(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f1330b.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.f(drawable);
        }
        return this.f1330b.f1333b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f1330b.f1334c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f1330b.f1333b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f1330b.f1333b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f1330b.f1333b.setLevel(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f1330b.f1333b.setState(iArr);
    }

    public void setAlpha(int i) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f1330b.f1333b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, z);
        } else {
            this.f1330b.f1333b.setAutoMirrored(z);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable, i);
        } else {
            this.f1330b.f1333b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, colorStateList);
        } else {
            this.f1330b.f1333b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, mode);
        } else {
            this.f1330b.f1333b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f1330b.f1333b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f1330b.f1334c.isStarted()) {
            this.f1330b.f1334c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f1330b.f1334c.end();
        }
    }

    private d(Context context) {
        this(context, (a) null, (Resources) null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1340a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f1330b.f1333b.setColorFilter(colorFilter);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat */
    private static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f1335a;

        public b(Drawable.ConstantState constantState) {
            this.f1335a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f1335a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f1335a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            d dVar = new d();
            dVar.f1340a = this.f1335a.newDrawable();
            dVar.f1340a.setCallback(dVar.mCallback);
            return dVar;
        }

        public Drawable newDrawable(Resources resources) {
            d dVar = new d();
            dVar.f1340a = this.f1335a.newDrawable(resources);
            dVar.f1340a.setCallback(dVar.mCallback);
            return dVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            d dVar = new d();
            dVar.f1340a = this.f1335a.newDrawable(resources, theme);
            dVar.f1340a.setCallback(dVar.mCallback);
            return dVar;
        }
    }

    private d(Context context, a aVar, Resources resources) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.mCallback = new c(this);
        this.f1331c = context;
        if (aVar != null) {
            this.f1330b = aVar;
        } else {
            this.f1330b = new a(context, aVar, this.mCallback, resources);
        }
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.d == null) {
                    this.d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.d);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.f1330b.f1333b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        a aVar = this.f1330b;
        if (aVar.d == null) {
            aVar.d = new ArrayList<>();
            this.f1330b.e = new a.b.b<>();
        }
        this.f1330b.d.add(animator);
        this.f1330b.e.put(animator, str);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}
