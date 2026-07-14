package P1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;
import o1.C0560a;

/* loaded from: classes.dex */
public abstract class J {

    /* renamed from: a, reason: collision with root package name */
    public static final long f1377a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b, reason: collision with root package name */
    public static final Object f1378b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static C0560a f1379c;

    public static void a(Context context) {
        if (f1379c == null) {
            C0560a c0560a = new C0560a(context);
            f1379c = c0560a;
            synchronized (c0560a.f5772a) {
                c0560a.f5778g = true;
            }
        }
    }

    public static void b(Intent intent) {
        synchronized (f1378b) {
            try {
                if (f1379c != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                    intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                    f1379c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ComponentName c(Context context, Intent intent) {
        synchronized (f1378b) {
            try {
                a(context);
                boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                ComponentName startService = context.startService(intent);
                if (startService == null) {
                    return null;
                }
                if (!booleanExtra) {
                    f1379c.a(f1377a);
                }
                return startService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
