package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.H;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* loaded from: classes.dex */
public abstract class zaj implements DialogInterface.OnClickListener {
    public static zaj zab(Activity activity, Intent intent, int i2) {
        return new zag(intent, activity, i2);
    }

    public static zaj zac(H h2, Intent intent, int i2) {
        return new zah(intent, h2, i2);
    }

    public static zaj zad(LifecycleFragment lifecycleFragment, Intent intent, int i2) {
        return new zai(intent, lifecycleFragment, 2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        try {
            try {
                zaa();
            } catch (ActivityNotFoundException e2) {
                String str = "Failed to start resolution intent.";
                if (true == Build.FINGERPRINT.contains("generic")) {
                    str = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
                }
                Log.e("DialogRedirect", str, e2);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }

    public abstract void zaa();
}
