package P1;

import D2.Y;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import e1.ThreadFactoryC0275a;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p1.C0580i;
import p1.C0585n;

/* renamed from: P1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractServiceC0103g extends Service {

    /* renamed from: f, reason: collision with root package name */
    public final ExecutorService f1411f;

    /* renamed from: g, reason: collision with root package name */
    public K f1412g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f1413h;

    /* renamed from: i, reason: collision with root package name */
    public int f1414i;

    /* renamed from: j, reason: collision with root package name */
    public int f1415j;

    public AbstractServiceC0103g() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0275a("Firebase-Messaging-Intent-Handle"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f1411f = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f1413h = new Object();
        this.f1415j = 0;
    }

    public final void a(Intent intent) {
        if (intent != null) {
            J.b(intent);
        }
        synchronized (this.f1413h) {
            try {
                int i4 = this.f1415j - 1;
                this.f1415j = i4;
                if (i4 == 0) {
                    stopSelfResult(this.f1414i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void b(Intent intent);

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.f1412g == null) {
                this.f1412g = new K(new R1.c(10, this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1412g;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.f1411f.shutdown();
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.concurrent.Executor, java.lang.Object] */
    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i4, int i5) {
        synchronized (this.f1413h) {
            this.f1414i = i5;
            this.f1415j++;
        }
        Intent intent2 = (Intent) ((ArrayDeque) y.l().f1472i).poll();
        if (intent2 == null) {
            a(intent);
            return 2;
        }
        C0580i c0580i = new C0580i();
        this.f1411f.execute(new Y(this, intent2, c0580i, 3));
        C0585n c0585n = c0580i.f5821a;
        if (c0585n.e()) {
            a(intent);
            return 2;
        }
        c0585n.g(new Object(), new O0.j(3, this, intent));
        return 3;
    }
}
