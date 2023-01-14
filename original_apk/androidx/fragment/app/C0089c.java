package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/* renamed from: androidx.fragment.app.c  reason: case insensitive filesystem */
/* compiled from: DialogFragment */
public class C0089c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    int Y = 0;
    int Z = 0;
    boolean aa = true;
    boolean ba = true;
    int ca = -1;
    Dialog da;
    boolean ea;
    boolean fa;
    boolean ga;

    public void H() {
        super.H();
        Dialog dialog = this.da;
        if (dialog != null) {
            this.ea = true;
            dialog.dismiss();
            this.da = null;
        }
    }

    public void I() {
        super.I();
        if (!this.ga && !this.fa) {
            this.fa = true;
        }
    }

    public void L() {
        super.L();
        Dialog dialog = this.da;
        if (dialog != null) {
            this.ea = false;
            dialog.show();
        }
    }

    public void M() {
        super.M();
        Dialog dialog = this.da;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public int Y() {
        return this.Z;
    }

    public void a(C0098l lVar, String str) {
        this.fa = false;
        this.ga = true;
        x a2 = lVar.a();
        a2.a(this, str);
        a2.a();
    }

    public void b(Bundle bundle) {
        Bundle bundle2;
        super.b(bundle);
        if (this.ba) {
            View w = w();
            if (w != null) {
                if (w.getParent() == null) {
                    this.da.setContentView(w);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            FragmentActivity b2 = b();
            if (b2 != null) {
                this.da.setOwnerActivity(b2);
            }
            this.da.setCancelable(this.aa);
            this.da.setOnCancelListener(this);
            this.da.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                this.da.onRestoreInstanceState(bundle2);
            }
        }
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        this.ba = this.A == 0;
        if (bundle != null) {
            this.Y = bundle.getInt("android:style", 0);
            this.Z = bundle.getInt("android:theme", 0);
            this.aa = bundle.getBoolean("android:cancelable", true);
            this.ba = bundle.getBoolean("android:showsDialog", this.ba);
            this.ca = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater d(Bundle bundle) {
        if (!this.ba) {
            return super.d(bundle);
        }
        this.da = n(bundle);
        Dialog dialog = this.da;
        if (dialog == null) {
            return (LayoutInflater) this.u.c().getSystemService("layout_inflater");
        }
        a_shaKey_method2(dialog, this.Y);
        return (LayoutInflater) this.da.getContext().getSystemService("layout_inflater");
    }

    public void e(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.e(bundle);
        Dialog dialog = this.da;
        if (!(dialog == null || (onSaveInstanceState = dialog.onSaveInstanceState()) == null)) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i = this.Y;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.Z;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.aa;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.ba;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.ca;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z) {
        if (!this.fa) {
            this.fa = true;
            this.ga = false;
            Dialog dialog = this.da;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.ea = true;
            if (this.ca >= 0) {
                m().a(this.ca, 1);
                this.ca = -1;
                return;
            }
            x a2 = m().a();
            a2.c(this);
            if (z) {
                a2.b();
            } else {
                a2.a();
            }
        }
    }

    public void h(boolean z) {
        this.ba = z;
    }

    public Dialog n(Bundle bundle) {
        return new Dialog(b(), Y());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.ea) {
            g(true);
        }
    }

    public void a(Context context) {
        super.a(context);
        if (!this.ga) {
            this.fa = false;
        }
    }

    public void a(Dialog dialog, int i) {
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                dialog.getWindow().addFlags(24);
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }
}
