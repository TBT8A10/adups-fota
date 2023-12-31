package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.a;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.C0153b;

@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    private int f1719a = 0;

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i) {
        return PendingIntent.getActivity(context, 0, a(context, pendingIntent, i, true), 134217728);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f1719a = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                C0153b a2 = C0153b.a((Context) this);
                if (i2 == -1) {
                    a2.c();
                } else if (i2 == 0) {
                    a2.a_shaKey_method2(new ConnectionResult(13, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i == 2) {
            this.f1719a = 0;
            setResult(i2, intent);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f1719a = 0;
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f1719a = bundle.getInt("resolution");
        }
        if (this.f1719a != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                Log.e("GoogleApiActivity", "Activity started without resolution");
                finish();
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, (Intent) null, 0, 0, 0);
                    this.f1719a = 1;
                } catch (IntentSender.SendIntentException e) {
                    Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                    finish();
                }
            } else {
                a.a().b(this, num.intValue(), 2, this);
                this.f1719a = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f1719a);
        super.onSaveInstanceState(bundle);
    }

    public static Intent a(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }
}
