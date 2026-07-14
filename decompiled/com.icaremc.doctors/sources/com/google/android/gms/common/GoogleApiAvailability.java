package com.google.android.gms.common;

import O.a;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.H;
import androidx.fragment.app.M;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.api.internal.zabs;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.service.zaq;
import com.google.android.gms.common.internal.zaf;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.encoders.json.BuildConfig;
import f.AbstractC0187c;
import io.flutter.Build;
import java.util.ArrayList;
import java.util.Arrays;
import u.C0315f;
import u.C0318i;
import u.C0319j;

/* loaded from: classes.dex */
public class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    private String zac;
    private com.google.android.gms.common.internal.zad zad;
    private static final Object zaa = new Object();
    private static final GoogleApiAvailability zab = new GoogleApiAvailability();
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    public static GoogleApiAvailability getInstance() {
        return zab;
    }

    public static final Task zaj(HasApiKey hasApiKey, HasApiKey... hasApiKeyArr) {
        Preconditions.checkNotNull(hasApiKey, "Requested API must not be null.");
        for (HasApiKey hasApiKey2 : hasApiKeyArr) {
            Preconditions.checkNotNull(hasApiKey2, "Requested API must not be null.");
        }
        ArrayList arrayList = new ArrayList(hasApiKeyArr.length + 1);
        arrayList.add(hasApiKey);
        arrayList.addAll(Arrays.asList(hasApiKeyArr));
        return GoogleApiManager.zab().zah(arrayList);
    }

    public Task<Void> checkApiAvailability(GoogleApi<?> googleApi, GoogleApi<?>... googleApiArr) {
        return zaj(googleApi, googleApiArr).onSuccessTask(zab.zaa);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public int getClientVersion(Context context) {
        return super.getClientVersion(context);
    }

    public Dialog getErrorDialog(Activity activity, int i2, int i3) {
        return getErrorDialog(activity, i2, i3, (DialogInterface.OnCancelListener) null);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public Intent getErrorResolutionIntent(Context context, int i2, String str) {
        return super.getErrorResolutionIntent(context, i2, str);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i2, int i3) {
        return super.getErrorResolutionPendingIntent(context, i2, i3);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final String getErrorString(int i2) {
        return super.getErrorString(i2);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @HideFirstParty
    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final boolean isUserResolvableError(int i2) {
        return super.isUserResolvableError(i2);
    }

    public Task<Void> makeGooglePlayServicesAvailable(Activity activity) {
        int i2 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(activity, i2);
        if (isGooglePlayServicesAvailable == 0) {
            return Tasks.forResult(null);
        }
        zabx zaa2 = zabx.zaa(activity);
        zaa2.zaf(new ConnectionResult(isGooglePlayServicesAvailable, null), 0);
        return zaa2.zab();
    }

    @TargetApi(Build.API_LEVELS.API_26)
    public void setDefaultNotificationChannelId(Context context, String str) {
        NotificationChannel notificationChannel;
        if (PlatformVersion.isAtLeastO()) {
            notificationChannel = ((NotificationManager) Preconditions.checkNotNull(context.getSystemService("notification"))).getNotificationChannel(str);
            Preconditions.checkNotNull(notificationChannel);
        }
        synchronized (zaa) {
            this.zac = str;
        }
    }

    public boolean showErrorDialogFragment(Activity activity, int i2, int i3) {
        return showErrorDialogFragment(activity, i2, i3, (DialogInterface.OnCancelListener) null);
    }

    public void showErrorNotification(Context context, int i2) {
        zac(context, i2, null, getErrorResolutionPendingIntent(context, i2, 0, "n"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Dialog zaa(Context context, int i2, zaj zajVar, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = null;
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(zaf.zac(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String zae = zaf.zae(context, i2);
        if (zae != null) {
            if (zajVar == null) {
                zajVar = onClickListener;
            }
            builder.setPositiveButton(zae, zajVar);
        }
        String zaa2 = zaf.zaa(context, i2);
        if (zaa2 != null) {
            builder.setTitle(zaa2);
        }
        Log.w("GoogleApiAvailability", a.c(i2, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public final boolean zab(Activity activity, LifecycleFragment lifecycleFragment, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog zaa2 = zaa(activity, i2, zaj.zad(lifecycleFragment, getErrorResolutionIntent(activity, i2, "d"), 2), onCancelListener, null);
        if (zaa2 == null) {
            return false;
        }
        zah(activity, zaa2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public final void zac(Context context, int i2, String str, PendingIntent pendingIntent) {
        String str2;
        NotificationChannel notificationChannel;
        CharSequence name;
        int i3;
        Log.w("GoogleApiAvailability", "GMS core API Availability. ConnectionResult=" + i2 + ", tag=null", new IllegalArgumentException());
        if (i2 == 18) {
            zai(context);
            return;
        }
        if (pendingIntent == null) {
            if (i2 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String zab2 = zaf.zab(context, i2);
        String zad = zaf.zad(context, i2);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) Preconditions.checkNotNull(context.getSystemService("notification"));
        IconCompat iconCompat = null;
        C0319j c0319j = new C0319j(context, null);
        c0319j.f3765u = true;
        c0319j.c(16, true);
        c0319j.f3751e = C0319j.b(zab2);
        C0318i c0318i = new C0318i(0);
        c0318i.f3737f = C0319j.b(zad);
        c0319j.f(c0318i);
        boolean isWearable = DeviceProperties.isWearable(context);
        int i4 = android.R.drawable.stat_sys_warning;
        if (isWearable) {
            int i5 = context.getApplicationInfo().icon;
            if (i5 != 0) {
                i4 = i5;
            }
            c0319j.f3744G.icon = i4;
            c0319j.f3757k = 2;
            if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                int i6 = com.google.android.gms.base.R.drawable.common_full_open_on_phone;
                String string = resources.getString(com.google.android.gms.base.R.string.common_open_on_phone);
                ArrayList arrayList = c0319j.f3748b;
                if (i6 != 0) {
                    iconCompat = IconCompat.e(null, BuildConfig.FLAVOR, i6);
                }
                arrayList.add(new C0315f(iconCompat, string, pendingIntent, new Bundle(), null, true, 0, true, false));
            } else {
                c0319j.f3753g = pendingIntent;
            }
        } else {
            c0319j.f3744G.icon = android.R.drawable.stat_sys_warning;
            c0319j.f3744G.tickerText = C0319j.b(resources.getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker));
            c0319j.f3744G.when = System.currentTimeMillis();
            c0319j.f3753g = pendingIntent;
            c0319j.f3752f = C0319j.b(zad);
        }
        if (PlatformVersion.isAtLeastO()) {
            Preconditions.checkState(PlatformVersion.isAtLeastO());
            synchronized (zaa) {
                str2 = this.zac;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string2 = context.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_channel_name);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(com.dexterous.flutterlocalnotifications.a.e(string2));
                } else {
                    name = notificationChannel.getName();
                    if (!string2.contentEquals(name)) {
                        notificationChannel.setName(string2);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
            }
            c0319j.f3739B = str2;
        }
        Notification a2 = c0319j.a();
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            i3 = 39789;
        } else {
            GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
            i3 = 10436;
        }
        notificationManager.notify(i3, a2);
    }

    public final boolean zad(Context context, ConnectionResult connectionResult, int i2) {
        PendingIntent errorResolutionPendingIntent;
        if (InstantApps.isInstantApp(context) || (errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult)) == null) {
            return false;
        }
        zac(context, connectionResult.getErrorCode(), null, zak.zaa(context, 0, GoogleApiActivity.zaa(context, errorResolutionPendingIntent, i2, true), zak.zaa | 134217728));
        zae(context, connectionResult, false);
        return true;
    }

    public final void zae(Context context, ConnectionResult connectionResult, boolean z) {
        int intValue;
        Integer clientMethodKey = connectionResult.getClientMethodKey();
        if (clientMethodKey == null) {
            intValue = -1;
        } else {
            intValue = clientMethodKey.intValue();
        }
        com.google.android.gms.common.internal.zab zabVar = new com.google.android.gms.common.internal.zab(intValue, context.getPackageName(), System.currentTimeMillis(), connectionResult.getErrorCode(), z);
        if (this.zad == null) {
            this.zad = new zaq(context);
        }
        this.zad.zaa(zabVar);
    }

    public final Dialog zaf(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(zaf.zac(activity, 18));
        builder.setPositiveButton(BuildConfig.FLAVOR, (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        zah(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final zabs zag(Context context, zabr zabrVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabs zabsVar = new zabs(zabrVar);
        android.support.v4.media.session.a.C(context, zabsVar, intentFilter);
        zabsVar.zaa(context);
        if (!isUninstalledAppPossiblyUpdating(context, "com.google.android.gms")) {
            zabrVar.zaa();
            zabsVar.zab();
            return null;
        }
        return zabsVar;
    }

    public final void zah(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof M) {
                SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((M) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public final void zai(Context context) {
        new zad(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public Dialog getErrorDialog(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return zaa(activity, i2, zaj.zab(activity, getErrorResolutionIntent(activity, i2, "d"), i3), onCancelListener, null);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            return connectionResult.getResolution();
        }
        return getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public int isGooglePlayServicesAvailable(Context context, int i2) {
        return super.isGooglePlayServicesAvailable(context, i2);
    }

    public boolean showErrorDialogFragment(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i2, i3, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        zah(activity, errorDialog, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public Task<Void> checkApiAvailability(HasApiKey<?> hasApiKey, HasApiKey<?>... hasApiKeyArr) {
        return zaj(hasApiKey, hasApiKeyArr).onSuccessTask(zac.zaa);
    }

    public void showErrorNotification(Context context, ConnectionResult connectionResult) {
        zac(context, connectionResult.getErrorCode(), null, getErrorResolutionPendingIntent(context, connectionResult));
        zae(context, connectionResult, false);
    }

    public Dialog getErrorDialog(H h2, int i2, int i3) {
        return getErrorDialog(h2, i2, i3, (DialogInterface.OnCancelListener) null);
    }

    public boolean showErrorDialogFragment(Activity activity, int i2, AbstractC0187c abstractC0187c, DialogInterface.OnCancelListener onCancelListener) {
        Dialog zaa2 = zaa(activity, i2, null, onCancelListener, new zaa(this, activity, i2, abstractC0187c));
        if (zaa2 == null) {
            return false;
        }
        zah(activity, zaa2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public Dialog getErrorDialog(H h2, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return zaa(h2.requireContext(), i2, zaj.zac(h2, getErrorResolutionIntent(h2.requireContext(), i2, "d"), i3), onCancelListener, null);
    }
}
