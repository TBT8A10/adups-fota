package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.widget.ia;
import androidx.core.h.t;

public class ListMenuItemView extends LinearLayout implements w.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a  reason: collision with root package name */
    private p f212a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f213b;

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f214c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private LinearLayout i;
    private int j;
    private Context k;
    private boolean l;
    private Drawable m;
    private Drawable mBackground;
    private boolean n;
    private int o;
    private LayoutInflater p;
    private boolean q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    private void b() {
        this.f213b = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, this, false);
        a_shaKey_method2((View) this.f213b, 0);
    }

    private void c() {
        this.f214c = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, this, false);
        a(this.f214c);
    }

    private LayoutInflater getInflater() {
        if (this.p == null) {
            this.p = LayoutInflater.from(getContext());
        }
        return this.p;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void a(p pVar, int i2) {
        this.f212a = pVar;
        this.o = i2;
        setVisibility(pVar.isVisible() ? 0 : 8);
        setTitle(pVar.a((w.a) this));
        setCheckable(pVar.isCheckable());
        a(pVar.q(), pVar.g());
        setIcon(pVar.getIcon());
        setEnabled(pVar.isEnabled());
        setSubMenuArrowVisible(pVar.hasSubMenu());
        setContentDescription(pVar.d());
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            rect.top += this.h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public p getItemData() {
        return this.f212a;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        t.a_shaKey_method2((View) this, this.mBackground);
        this.d = (TextView) findViewById(R$id.title);
        int i2 = this.j;
        if (i2 != -1) {
            this.d.setTextAppearance(this.k, i2);
        }
        this.f = (TextView) findViewById(R$id.shortcut);
        this.g = (ImageView) findViewById(R$id.submenuarrow);
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageDrawable(this.m);
        }
        this.h = (ImageView) findViewById(R$id.group_divider);
        this.i = (LinearLayout) findViewById(R$id.content);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f213b != null && this.l) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f213b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i2, i3);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f214c != null || this.e != null) {
            if (this.f212a.m()) {
                if (this.f214c == null) {
                    c();
                }
                compoundButton2 = this.f214c;
                compoundButton = this.e;
            } else {
                if (this.e == null) {
                    a();
                }
                compoundButton2 = this.e;
                compoundButton = this.f214c;
            }
            if (z) {
                compoundButton2.setChecked(this.f212a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f214c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f212a.m()) {
            if (this.f214c == null) {
                c();
            }
            compoundButton = this.f214c;
        } else {
            if (this.e == null) {
                a();
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.q = z;
        this.l = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility((this.n || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f212a.p() || this.q;
        if (!z && !this.l) {
            return;
        }
        if (this.f213b != null || drawable != null || this.l) {
            if (this.f213b == null) {
                b();
            }
            if (drawable != null || this.l) {
                ImageView imageView = this.f213b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f213b.getVisibility() != 0) {
                    this.f213b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f213b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        } else if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        ia a2 = ia.a(getContext(), attributeSet, R$styleable.MenuView, i2, 0);
        this.mBackground = a2.b(R$styleable.MenuView_android_itemBackground);
        this.j = a2.g(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.l = a2.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.k = context;
        this.m = a2.b(R$styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, R$attr.dropDownListViewStyle, 0);
        this.n = obtainStyledAttributes.hasValue(0);
        a2.a();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        a_shaKey_method2(view, -1);
    }

    private void a(View view, int i2) {
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    public void a(boolean z, char c2) {
        int i2 = (!z || !this.f212a.q()) ? 8 : 0;
        if (i2 == 0) {
            this.f.setText(this.f212a.h());
        }
        if (this.f.getVisibility() != i2) {
            this.f.setVisibility(i2);
        }
    }

    private void a() {
        this.e = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, this, false);
        a(this.e);
    }
}
