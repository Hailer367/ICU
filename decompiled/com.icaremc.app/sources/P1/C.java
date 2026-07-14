package P1;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;
import e1.ThreadFactoryC0275a;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class C implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final long f1344f;

    /* renamed from: g, reason: collision with root package name */
    public final PowerManager.WakeLock f1345g;

    /* renamed from: h, reason: collision with root package name */
    public final FirebaseMessaging f1346h;

    public C(FirebaseMessaging firebaseMessaging, long j4) {
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0275a("firebase-iid-executor"));
        this.f1346h = firebaseMessaging;
        this.f1344f = j4;
        PowerManager.WakeLock newWakeLock = ((PowerManager) firebaseMessaging.f3410b.getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f1345g = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    public final boolean a() {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f1346h.f3410b.getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        try {
            if (this.f1346h.a() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Token successfully retrieved");
                return true;
            }
            return true;
        } catch (IOException e4) {
            String message = e4.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                if (e4.getMessage() == null) {
                    Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                    return false;
                }
                throw e4;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e4.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        PowerManager.WakeLock wakeLock = this.f1345g;
        y l3 = y.l();
        FirebaseMessaging firebaseMessaging = this.f1346h;
        if (l3.o(firebaseMessaging.f3410b)) {
            wakeLock.acquire();
        }
        try {
            try {
                synchronized (firebaseMessaging) {
                    firebaseMessaging.f3418j = true;
                }
                if (!firebaseMessaging.f3417i.g()) {
                    synchronized (firebaseMessaging) {
                        firebaseMessaging.f3418j = false;
                    }
                    if (y.l().o(firebaseMessaging.f3410b)) {
                        wakeLock.release();
                        return;
                    }
                    return;
                }
                if (y.l().n(firebaseMessaging.f3410b) && !a()) {
                    B b4 = new B();
                    b4.f1343c = this;
                    b4.a();
                    if (y.l().o(firebaseMessaging.f3410b)) {
                        wakeLock.release();
                        return;
                    }
                    return;
                }
                if (b()) {
                    synchronized (firebaseMessaging) {
                        firebaseMessaging.f3418j = false;
                    }
                } else {
                    firebaseMessaging.l(this.f1344f);
                }
                if (y.l().o(firebaseMessaging.f3410b)) {
                    wakeLock.release();
                }
            } catch (IOException e4) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e4.getMessage() + ". Won't retry the operation.");
                synchronized (firebaseMessaging) {
                    firebaseMessaging.f3418j = false;
                    if (y.l().o(firebaseMessaging.f3410b)) {
                        wakeLock.release();
                    }
                }
            }
        } catch (Throwable th) {
            if (y.l().o(firebaseMessaging.f3410b)) {
                wakeLock.release();
            }
            throw th;
        }
    }
}
