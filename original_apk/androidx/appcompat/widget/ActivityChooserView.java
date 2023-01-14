package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.C0066i;
import androidx.core.h.C0084b;

public class ActivityChooserView extends ViewGroup implements C0066i.a {

    /* renamed from: a  reason: collision with root package name */
    final a f278a;

    /* renamed from: b  reason: collision with root package name */
    private final b f279b;

    /* renamed from: c  reason: collision with root package name */
    private final View f280c;
    private final Drawable d;
    final FrameLayout e;
    private final ImageView f;
    final FrameLayout g;
    private final ImageView h;
    private final int i;
    C0084b j;
    final DataSetObserver k;
    private final ViewTreeObserver.OnGlobalLayoutListener l;
    private ListPopupWindow m;
    PopupWindow.OnDismissListener n;
    boolean o;
    int p;
    private boolean q;
    private int r;

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f281a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ia a2 = ia.a(context, attributeSet, f281a);
            setBackgroundDrawable(a2.b(0));
            a2.a();
        }
    }

    private class b implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        b() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.g) {
                activityChooserView.a();
                Intent a2 = ActivityChooserView.this.f278a.b().a(ActivityChooserView.this.f278a.b().a(ActivityChooserView.this.f278a.c()));
                if (a2 != null) {
                    a2.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(a2);
                }
            } else if (view == activityChooserView.e) {
                activityChooserView.o = false;
                activityChooserView.a(activityChooserView.p);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            a();
            C0084b bVar = ActivityChooserView.this.j;
            if (bVar != null) {
                bVar.a(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((a) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType == 0) {
                ActivityChooserView.this.a();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.o) {
                    if (!activityChooserView.f278a.e()) {
                        i++;
                    }
                    Intent a2 = ActivityChooserView.this.f278a.b().a(i);
                    if (a2 != null) {
                        a2.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(a2);
                    }
                } else if (i > 0) {
                    activityChooserView.f278a.b().c(i);
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.a(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.g) {
                if (activityChooserView.f278a.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.o = true;
                    activityChooserView2.a(activityChooserView2.p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.f278a.b() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.l);
            boolean z = this.g.getVisibility() == 0;
            int a2 = this.f278a.a();
            if (i2 == Integer.MAX_VALUE || a2 <= i2 + (z ? 1 : 0)) {
                this.f278a.a(false);
                this.f278a.a(i2);
            } else {
                this.f278a.a(true);
                this.f278a.a(i2 - 1);
            }
            ListPopupWindow listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.isShowing()) {
                if (this.o || !z) {
                    this.f278a.a(true, z);
                } else {
                    this.f278a.a(false, false);
                }
                listPopupWindow.b(Math.min(this.f278a.f(), this.i));
                listPopupWindow.show();
                C0084b bVar = this.j;
                if (bVar != null) {
                    bVar.a(true);
                }
                listPopupWindow.getListView().setContentDescription(getContext().getString(R$string.abc_activitychooserview_choose_application));
                listPopupWindow.getListView().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public boolean b() {
        return getListPopupWindow().isShowing();
    }

    public boolean c() {
        if (b() || !this.q) {
            return false;
        }
        this.o = false;
        a(this.p);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.f278a.getCount() > 0) {
            this.e.setEnabled(true);
        } else {
            this.e.setEnabled(false);
        }
        int a2 = this.f278a.a();
        int d2 = this.f278a.d();
        if (a2 == 1 || (a2 > 1 && d2 > 0)) {
            this.g.setVisibility(0);
            ResolveInfo c2 = this.f278a.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.h.setImageDrawable(c2.loadIcon(packageManager));
            if (this.r != 0) {
                CharSequence loadLabel = c2.loadLabel(packageManager);
                this.g.setContentDescription(getContext().getString(this.r, new Object[]{loadLabel}));
            }
        } else {
            this.g.setVisibility(8);
        }
        if (this.g.getVisibility() == 0) {
            this.f280c.setBackgroundDrawable(this.d);
        } else {
            this.f280c.setBackgroundDrawable((Drawable) null);
        }
    }

    public C0066i getDataModel() {
        return this.f278a.b();
    }

    /* access modifiers changed from: package-private */
    public ListPopupWindow getListPopupWindow() {
        if (this.m == null) {
            this.m = new ListPopupWindow(getContext());
            this.m.a((ListAdapter) this.f278a);
            this.m.a((View) this);
            this.m.a(true);
            this.m.setOnItemClickListener(this.f279b);
            this.m.setOnDismissListener(this.f279b);
        }
        return this.m;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0066i b2 = this.f278a.b();
        if (b2 != null) {
            b2.registerObserver(this.k);
        }
        this.q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0066i b2 = this.f278a.b();
        if (b2 != null) {
            b2.unregisterObserver(this.k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        }
        if (b()) {
            a();
        }
        this.q = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f280c.layout(0, 0, i4 - i2, i5 - i3);
        if (!b()) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        View view = this.f280c;
        if (this.g.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824);
        }
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0066i iVar) {
        this.f278a.a(iVar);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.r = i2;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.f.setContentDescription(getContext().getString(i2));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i2) {
        this.p = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    public void setProvider(C0084b bVar) {
        this.j = bVar;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new C0067j(this);
        this.l = new C0068k(this);
        this.p = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActivityChooserView, i2, 0);
        this.p = obtainStyledAttributes.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.abc_activity_chooser_view, this, true);
        this.f279b = new b();
        this.f280c = findViewById(R$id.activity_chooser_view_content);
        this.d = this.f280c.getBackground();
        this.g = (FrameLayout) findViewById(R$id.default_activity_button);
        this.g.setOnClickListener(this.f279b);
        this.g.setOnLongClickListener(this.f279b);
        this.h = (ImageView) this.g.findViewById(R$id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.expand_activities_button);
        frameLayout.setOnClickListener(this.f279b);
        frameLayout.setAccessibilityDelegate(new C0069l(this));
        frameLayout.setOnTouchListener(new C0070m(this, frameLayout));
        this.e = frameLayout;
        this.f = (ImageView) frameLayout.findViewById(R$id.image);
        this.f.setImageDrawable(drawable);
        this.f278a = new a();
        this.f278a.registerDataSetObserver(new C0071n(this));
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }

    private class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private C0066i f282a;

        /* renamed from: b  reason: collision with root package name */
        private int f283b = 4;

        /* renamed from: c  reason: collision with root package name */
        private boolean f284c;
        private boolean d;
        private boolean e;

        a() {
        }

        public void a(C0066i iVar) {
            C0066i b2 = ActivityChooserView.this.f278a.b();
            if (b2 != null && ActivityChooserView.this.isShown()) {
                b2.unregisterObserver(ActivityChooserView.this.k);
            }
            this.f282a = iVar;
            if (iVar != null && ActivityChooserView.this.isShown()) {
                iVar.registerObserver(ActivityChooserView.this.k);
            }
            notifyDataSetChanged();
        }

        public C0066i b() {
            return this.f282a;
        }

        public ResolveInfo c() {
            return this.f282a.b();
        }

        public int d() {
            return this.f282a.c();
        }

        public boolean e() {
            return this.f284c;
        }

        public int f() {
            int i = this.f283b;
            this.f283b = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.f283b = i;
            return i2;
        }

        public int getCount() {
            int a2 = this.f282a.a();
            if (!this.f284c && this.f282a.b() != null) {
                a2--;
            }
            int min = Math.min(a2, this.f283b);
            return this.e ? min + 1 : min;
        }

        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (!this.f284c && this.f282a.b() != null) {
                    i++;
                }
                return this.f282a.b(i);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return (!this.e || i != getCount() - 1) ? 0 : 1;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R$id.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(R$id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R$id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.f284c || i != 0 || !this.d) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R$id.title)).setText(ActivityChooserView.this.getContext().getString(R$string.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public int getViewTypeCount() {
            return 3;
        }

        public void a(int i) {
            if (this.f283b != i) {
                this.f283b = i;
                notifyDataSetChanged();
            }
        }

        public void a(boolean z) {
            if (this.e != z) {
                this.e = z;
                notifyDataSetChanged();
            }
        }

        public int a() {
            return this.f282a.a();
        }

        public void a(boolean z, boolean z2) {
            if (this.f284c != z || this.d != z2) {
                this.f284c = z;
                this.d = z2;
                notifyDataSetChanged();
            }
        }
    }

    public boolean a() {
        if (!b()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        return true;
    }
}
