package com.google.android.gms.common.api;

import W0.a;
import Y0.d;
import Z0.r;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import h1.HandlerC0340e;

@KeepName
/* loaded from: classes.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f3362g = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f3363f = 0;

    @Override // android.app.Activity
    public final void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f3363f = 0;
            setResult(i5, intent);
            if (booleanExtra) {
                d c4 = d.c(this);
                if (i5 != -1) {
                    if (i5 == 0) {
                        c4.f(new a(13, null, null), getIntent().getIntExtra("failing_client_id", -1));
                    }
                } else {
                    HandlerC0340e handlerC0340e = c4.f2041m;
                    handlerC0340e.sendMessage(handlerC0340e.obtainMessage(3));
                }
            }
        } else if (i4 == 2) {
            this.f3363f = 0;
            setResult(i5, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f3363f = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        GoogleApiActivity googleApiActivity;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f3363f = bundle.getInt("resolution");
        }
        if (this.f3363f != 1) {
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
                return;
            }
            if (pendingIntent != null) {
                try {
                    googleApiActivity = this;
                    try {
                        googleApiActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                        googleApiActivity.f3363f = 1;
                    } catch (ActivityNotFoundException e4) {
                        e = e4;
                        if (extras.getBoolean("notify_manager", true)) {
                            d.c(this).f(new a(22, null, null), getIntent().getIntExtra("failing_client_id", -1));
                        } else {
                            String obj = pendingIntent.toString();
                            StringBuilder sb = new StringBuilder(obj.length() + 36);
                            sb.append("Activity not found while launching ");
                            sb.append(obj);
                            sb.append(".");
                            String sb2 = sb.toString();
                            if (Build.FINGERPRINT.contains("generic")) {
                                sb2 = sb2.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                            }
                            Log.e("GoogleApiActivity", sb2, e);
                        }
                        googleApiActivity.f3363f = 1;
                        finish();
                    } catch (IntentSender.SendIntentException e5) {
                        e = e5;
                        Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                        finish();
                    }
                } catch (ActivityNotFoundException e6) {
                    e = e6;
                    googleApiActivity = this;
                } catch (IntentSender.SendIntentException e7) {
                    e = e7;
                }
            } else {
                r.e(num);
                W0.d.f1860d.c(this, num.intValue(), this);
                this.f3363f = 1;
            }
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f3363f);
        super.onSaveInstanceState(bundle);
    }
}
