package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ia;
import com.google.android.material.R$styleable;

public class TabItem extends View {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f2226a;

    /* renamed from: b  reason: collision with root package name */
    public final Drawable f2227b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2228c;

    public TabItem(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ia a2 = ia.a(context, attributeSet, R$styleable.TabItem);
        this.f2226a = a2.e(R$styleable.TabItem_android_text);
        this.f2227b = a2.b(R$styleable.TabItem_android_icon);
        this.f2228c = a2.g(R$styleable.TabItem_android_layout, 0);
        a2.a();
    }
}
