package D2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import s2.InterfaceC0634f;
import s2.InterfaceC0640l;

/* loaded from: classes.dex */
public final class L implements K0.b {

    /* renamed from: f, reason: collision with root package name */
    public final Object f296f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f297g;

    /* renamed from: h, reason: collision with root package name */
    public Object f298h;

    /* renamed from: i, reason: collision with root package name */
    public Object f299i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f300j;

    public L(InterfaceC0634f interfaceC0634f, Context context, C0039s c0039s) {
        T2.h.e(interfaceC0634f, "binaryMessenger");
        this.f296f = interfaceC0634f;
        this.f297g = new C0024c(new A2.q(1, new C0026e(interfaceC0634f)));
        this.f299i = context;
        this.f300j = c0039s;
    }

    public static L a(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        L l3 = new L(sharedPreferences, scheduledThreadPoolExecutor);
        synchronized (((ArrayDeque) l3.f299i)) {
            try {
                ((ArrayDeque) l3.f299i).clear();
                String string = ((SharedPreferences) l3.f296f).getString((String) l3.f297g, "");
                if (!TextUtils.isEmpty(string) && string.contains((String) l3.f298h)) {
                    String[] split = string.split((String) l3.f298h, -1);
                    if (split.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            ((ArrayDeque) l3.f299i).add(str);
                        }
                    }
                    return l3;
                }
                return l3;
            } finally {
            }
        }
    }

    public static void c(Throwable th) {
        Log.e("WebChromeClientImpl", th.getClass().getSimpleName() + ", Message: " + th.getMessage() + ", Stacktrace: " + Log.getStackTraceString(th));
    }

    public InterfaceC0640l b() {
        if (((C0028g) this.f298h) == null) {
            this.f298h = new C0028g(this);
        }
        C0028g c0028g = (C0028g) this.f298h;
        T2.h.b(c0028g);
        return c0028g;
    }

    public void d(Runnable runnable) {
        Context context = (Context) this.f299i;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    @Override // G2.a
    public Object get() {
        return new N0.b((Executor) ((G2.a) this.f296f).get(), (J0.e) ((G2.a) this.f297g).get(), (O0.d) ((A2.t) this.f298h).get(), (P0.d) ((G2.a) this.f299i).get(), (Q0.c) ((G2.a) this.f300j).get());
    }

    public L(G2.a aVar, G2.a aVar2, A2.t tVar, G2.a aVar3, G2.a aVar4) {
        this.f296f = aVar;
        this.f297g = aVar2;
        this.f298h = tVar;
        this.f299i = aVar3;
        this.f300j = aVar4;
    }

    public L(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f299i = new ArrayDeque();
        this.f296f = sharedPreferences;
        this.f297g = "topic_operation_queue";
        this.f298h = ",";
        this.f300j = scheduledThreadPoolExecutor;
    }
}
