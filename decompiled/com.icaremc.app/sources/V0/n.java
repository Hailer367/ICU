package V0;

import android.content.Context;
import android.util.Log;
import e1.ThreadFactoryC0275a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import p1.C0585n;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: e, reason: collision with root package name */
    public static n f1712e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f1713a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f1714b;

    /* renamed from: c, reason: collision with root package name */
    public l f1715c = new l(this);

    /* renamed from: d, reason: collision with root package name */
    public int f1716d = 1;

    public n(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f1714b = scheduledExecutorService;
        this.f1713a = context.getApplicationContext();
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            try {
                if (f1712e == null) {
                    f1712e = new n(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new ThreadFactoryC0275a("MessengerIpcClient"))));
                }
                nVar = f1712e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    public final synchronized C0585n b(m mVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(mVar.toString()));
            }
            if (!this.f1715c.d(mVar)) {
                l lVar = new l(this);
                this.f1715c = lVar;
                lVar.d(mVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return mVar.f1708b.f5821a;
    }
}
