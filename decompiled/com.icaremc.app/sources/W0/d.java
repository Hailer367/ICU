package W0;

import Z0.r;
import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.AbstractActivityC0192y;
import androidx.fragment.app.C0169a;
import androidx.fragment.app.P;
import com.google.android.gms.common.api.GoogleApiActivity;
import x.C0708h;
import x.C0711k;
import x.C0712l;

/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f1859c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final d f1860d = new Object();

    /* renamed from: b, reason: collision with root package name */
    public b1.e f1861b;

    public static AlertDialog d(Activity activity, int i4, Z0.m mVar, DialogInterface.OnCancelListener onCancelListener) {
        String string;
        AlertDialog.Builder builder = null;
        if (i4 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(activity, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(Z0.l.b(activity, i4));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    string = resources.getString(R.string.ok);
                } else {
                    string = resources.getString(com.icaremc.app.R.string.common_google_play_services_enable_button);
                }
            } else {
                string = resources.getString(com.icaremc.app.R.string.common_google_play_services_update_button);
            }
        } else {
            string = resources.getString(com.icaremc.app.R.string.common_google_play_services_install_button);
        }
        if (string != null) {
            builder.setPositiveButton(string, mVar);
        }
        String a4 = Z0.l.a(activity, i4);
        if (a4 != null) {
            builder.setTitle(a4);
        }
        Log.w("GoogleApiAvailability", A2.i.g(i4, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [W0.b, android.app.DialogFragment] */
    public static void g(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof AbstractActivityC0192y) {
                P supportFragmentManager = ((AbstractActivityC0192y) activity).getSupportFragmentManager();
                h hVar = new h();
                r.f(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                hVar.f1868l0 = alertDialog;
                if (onCancelListener != null) {
                    hVar.m0 = onCancelListener;
                }
                hVar.f2888i0 = false;
                hVar.f2889j0 = true;
                supportFragmentManager.getClass();
                C0169a c0169a = new C0169a(supportFragmentManager);
                c0169a.f2829o = true;
                c0169a.e(0, hVar, str);
                c0169a.d(false);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        ?? dialogFragment = new DialogFragment();
        r.f(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        dialogFragment.f1852f = alertDialog;
        if (onCancelListener != null) {
            dialogFragment.f1853g = onCancelListener;
        }
        dialogFragment.show(fragmentManager, str);
    }

    public final void c(GoogleApiActivity googleApiActivity, int i4, GoogleApiActivity googleApiActivity2) {
        AlertDialog d4 = d(googleApiActivity, i4, new Z0.m(super.a(i4, googleApiActivity, "d"), googleApiActivity, 0), googleApiActivity2);
        if (d4 == null) {
            return;
        }
        g(googleApiActivity, d4, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void e(Activity activity, Y0.e eVar, int i4, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog d4 = d(activity, i4, new Z0.m(super.a(i4, activity, "d"), eVar, 1), onCancelListener);
        if (d4 == null) {
            return;
        }
        g(activity, d4, "GooglePlayServicesErrorDialog", onCancelListener);
    }

    public final void f(Context context, int i4, PendingIntent pendingIntent) {
        String a4;
        String d4;
        int i5;
        int i6;
        NotificationChannel notificationChannel;
        CharSequence name;
        Log.w("GoogleApiAvailability", "GMS core API Availability. ConnectionResult=" + i4 + ", tag=null", new IllegalArgumentException());
        if (i4 == 18) {
            new i(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i4 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        if (i4 == 6) {
            a4 = Z0.l.e(context, "common_google_play_services_resolution_required_title");
        } else {
            a4 = Z0.l.a(context, i4);
        }
        if (a4 == null) {
            a4 = context.getResources().getString(com.icaremc.app.R.string.common_google_play_services_notification_ticker);
        }
        if (i4 != 6 && i4 != 19) {
            d4 = Z0.l.b(context, i4);
        } else {
            d4 = Z0.l.d(context, "common_google_play_services_resolution_required_text", Z0.l.c(context));
        }
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        r.e(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        C0712l c0712l = new C0712l(context, null);
        c0712l.f6410u = true;
        c0712l.c(16, true);
        c0712l.f6395e = C0712l.b(a4);
        C0711k c0711k = new C0711k(0);
        c0711k.f6381f = C0712l.b(d4);
        c0712l.f(c0711k);
        PackageManager packageManager = context.getPackageManager();
        if (d1.b.f3465b == null) {
            d1.b.f3465b = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        boolean booleanValue = d1.b.f3465b.booleanValue();
        int i7 = R.drawable.stat_sys_warning;
        if (booleanValue) {
            int i8 = context.getApplicationInfo().icon;
            if (i8 != 0) {
                i7 = i8;
            }
            c0712l.f6388G.icon = i7;
            c0712l.k = 2;
            if (d1.b.c(context)) {
                i5 = 2;
                c0712l.f6392b.add(new C0708h(IconCompat.e(null, "", com.icaremc.app.R.drawable.common_full_open_on_phone), resources.getString(com.icaremc.app.R.string.common_open_on_phone), pendingIntent, new Bundle(), null, true, 0, true, false));
            } else {
                i5 = 2;
                c0712l.f6397g = pendingIntent;
            }
        } else {
            i5 = 2;
            c0712l.f6388G.icon = R.drawable.stat_sys_warning;
            c0712l.f6388G.tickerText = C0712l.b(resources.getString(com.icaremc.app.R.string.common_google_play_services_notification_ticker));
            c0712l.f6388G.when = System.currentTimeMillis();
            c0712l.f6397g = pendingIntent;
            c0712l.f6396f = C0712l.b(d4);
        }
        if (d1.b.b()) {
            if (d1.b.b()) {
                synchronized (f1859c) {
                }
                notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(com.icaremc.app.R.string.common_google_play_services_notification_channel_name);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(G.a.u(string));
                } else {
                    name = notificationChannel.getName();
                    if (!string.contentEquals(name)) {
                        notificationChannel.setName(string);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                c0712l.f6383B = "com.google.android.gms.availability";
            } else {
                throw new IllegalStateException();
            }
        }
        Notification a5 = c0712l.a();
        if (i4 != 1 && i4 != i5 && i4 != 3) {
            i6 = 39789;
        } else {
            f.f1863a.set(false);
            i6 = 10436;
        }
        notificationManager.notify(i6, a5);
    }
}
