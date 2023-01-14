package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertDialog */
public class l extends A implements DialogInterface {

    /* renamed from: c  reason: collision with root package name */
    final AlertController f148c = new AlertController(getContext(), this, getWindow());

    /* compiled from: AlertDialog */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.a f149a;

        /* renamed from: b  reason: collision with root package name */
        private final int f150b;

        public a(Context context) {
            this(context, l.a_shaKey_method2(context, 0));
        }

        public a a(CharSequence charSequence) {
            this.f149a.f = charSequence;
            return this;
        }

        public Context b() {
            return this.f149a.f73a;
        }

        public a(Context context, int i) {
            this.f149a = new AlertController.a(new ContextThemeWrapper(context, l.a_shaKey_method2(context, i)));
            this.f150b = i;
        }

        public a a(View view) {
            this.f149a.g = view;
            return this;
        }

        public a a(Drawable drawable) {
            this.f149a.d = drawable;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f149a.u = onKeyListener;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f149a;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            return this;
        }

        public l a() {
            l lVar = new l(this.f149a.f73a, this.f150b);
            this.f149a.a(lVar.f148c);
            lVar.setCancelable(this.f149a.r);
            if (this.f149a.r) {
                lVar.setCanceledOnTouchOutside(true);
            }
            lVar.setOnCancelListener(this.f149a.s);
            lVar.setOnDismissListener(this.f149a.t);
            DialogInterface.OnKeyListener onKeyListener = this.f149a.u;
            if (onKeyListener != null) {
                lVar.setOnKeyListener(onKeyListener);
            }
            return lVar;
        }
    }

    protected l(Context context, int i) {
        super(context, a_shaKey_method2(context, i));
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f148c.a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f148c.a_shaKey_method2(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f148c.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f148c.b(charSequence);
    }
}
