package P1;

import I.C0050d;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public final class I implements Runnable {
    public static final Object k = new Object();

    /* renamed from: l, reason: collision with root package name */
    public static Boolean f1370l;

    /* renamed from: m, reason: collision with root package name */
    public static Boolean f1371m;

    /* renamed from: f, reason: collision with root package name */
    public final Context f1372f;

    /* renamed from: g, reason: collision with root package name */
    public final C0050d f1373g;

    /* renamed from: h, reason: collision with root package name */
    public final PowerManager.WakeLock f1374h;

    /* renamed from: i, reason: collision with root package name */
    public final G f1375i;

    /* renamed from: j, reason: collision with root package name */
    public final long f1376j;

    public I(G g4, Context context, C0050d c0050d, long j4) {
        this.f1375i = g4;
        this.f1372f = context;
        this.f1376j = j4;
        this.f1373g = c0050d;
        this.f1374h = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static boolean a(Context context) {
        boolean booleanValue;
        boolean booleanValue2;
        synchronized (k) {
            try {
                Boolean bool = f1371m;
                if (bool == null) {
                    booleanValue = b(context, "android.permission.ACCESS_NETWORK_STATE", bool);
                } else {
                    booleanValue = bool.booleanValue();
                }
                Boolean valueOf = Boolean.valueOf(booleanValue);
                f1371m = valueOf;
                booleanValue2 = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue2;
    }

    public static boolean b(Context context, String str, Boolean bool) {
        boolean z;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context.checkCallingOrSelfPermission(str) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return z;
    }

    public static boolean c(Context context) {
        boolean booleanValue;
        boolean booleanValue2;
        synchronized (k) {
            try {
                Boolean bool = f1370l;
                if (bool == null) {
                    booleanValue = b(context, "android.permission.WAKE_LOCK", bool);
                } else {
                    booleanValue = bool.booleanValue();
                }
                Boolean valueOf = Boolean.valueOf(booleanValue);
                f1370l = valueOf;
                booleanValue2 = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue2;
    }

    public final synchronized boolean d() {
        NetworkInfo networkInfo;
        boolean z;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f1372f.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    z = true;
                }
            }
            z = false;
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        G g4 = this.f1375i;
        Context context = this.f1372f;
        boolean c4 = c(context);
        PowerManager.WakeLock wakeLock = this.f1374h;
        if (c4) {
            wakeLock.acquire(AbstractC0102f.f1410a);
        }
        try {
            try {
                try {
                    g4.e(true);
                    if (!this.f1373g.g()) {
                        g4.e(false);
                        if (c(context)) {
                            try {
                                wakeLock.release();
                                return;
                            } catch (RuntimeException unused) {
                                Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                                return;
                            }
                        }
                        return;
                    }
                    if (a(context) && !d()) {
                        new H(this, this).a();
                        if (c(context)) {
                            try {
                                wakeLock.release();
                                return;
                            } catch (RuntimeException unused2) {
                                Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                                return;
                            }
                        }
                        return;
                    }
                    if (g4.g()) {
                        g4.e(false);
                    } else {
                        g4.h(this.f1376j);
                    }
                    if (c(context)) {
                        wakeLock.release();
                    }
                } catch (IOException e4) {
                    Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e4.getMessage());
                    g4.e(false);
                    if (c(context)) {
                        wakeLock.release();
                    }
                }
            } catch (RuntimeException unused3) {
                Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
            }
        } catch (Throwable th) {
            if (c(context)) {
                try {
                    wakeLock.release();
                } catch (RuntimeException unused4) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}
