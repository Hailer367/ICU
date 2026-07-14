package com.google.firebase.messaging;

import G1.c;
import I.C0050d;
import I0.h;
import J1.a;
import K1.e;
import O0.j;
import P1.A;
import P1.C;
import P1.C0106j;
import P1.C0107k;
import P1.C0108l;
import P1.G;
import P1.n;
import P1.q;
import P1.r;
import P1.w;
import P1.z;
import V0.b;
import V0.d;
import V0.m;
import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.firebase.messaging.FirebaseMessaging;
import e1.ThreadFactoryC0275a;
import f1.AbstractC0286a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p1.AbstractC0579h;
import p1.C0585n;
import q1.AbstractC0602b;
import t.C0656e;
import u1.f;
import v1.InterfaceC0691a;
import x1.i;

/* loaded from: classes.dex */
public class FirebaseMessaging {

    /* renamed from: l, reason: collision with root package name */
    public static A f3406l;

    /* renamed from: n, reason: collision with root package name */
    public static ScheduledThreadPoolExecutor f3408n;

    /* renamed from: a, reason: collision with root package name */
    public final f f3409a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f3410b;

    /* renamed from: c, reason: collision with root package name */
    public final h f3411c;

    /* renamed from: d, reason: collision with root package name */
    public final C0106j f3412d;

    /* renamed from: e, reason: collision with root package name */
    public final r f3413e;

    /* renamed from: f, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f3414f;

    /* renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f3415g;

    /* renamed from: h, reason: collision with root package name */
    public final C0585n f3416h;

    /* renamed from: i, reason: collision with root package name */
    public final C0050d f3417i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3418j;
    public static final long k = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: m, reason: collision with root package name */
    public static a f3407m = new C0108l(0);

    /* JADX WARN: Type inference failed for: r4v0, types: [I0.h, java.lang.Object] */
    public FirebaseMessaging(f fVar, a aVar, a aVar2, e eVar, a aVar3, c cVar) {
        fVar.a();
        Context context = fVar.f6221a;
        final C0050d c0050d = new C0050d(context);
        fVar.a();
        b bVar = new b(fVar.f6221a);
        final ?? obj = new Object();
        obj.f819a = fVar;
        obj.f820b = c0050d;
        obj.f821c = bVar;
        obj.f822d = aVar;
        obj.f823e = aVar2;
        obj.f824f = eVar;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryC0275a("Firebase-Messaging-Task"));
        final int i4 = 1;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC0275a("Firebase-Messaging-Init"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0275a("Firebase-Messaging-File-Io"));
        final int i5 = 0;
        this.f3418j = false;
        f3407m = aVar3;
        this.f3409a = fVar;
        this.f3413e = new r(this, cVar);
        fVar.a();
        final Context context2 = fVar.f6221a;
        this.f3410b = context2;
        C0107k c0107k = new C0107k();
        this.f3417i = c0050d;
        this.f3411c = obj;
        this.f3412d = new C0106j(newSingleThreadExecutor);
        this.f3414f = scheduledThreadPoolExecutor;
        this.f3415g = threadPoolExecutor;
        fVar.a();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(c0107k);
        } else {
            Log.w("FirebaseMessaging", "Context " + context + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: P1.m

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f1428g;

            {
                this.f1428g = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i5) {
                    case 0:
                        FirebaseMessaging firebaseMessaging = this.f1428g;
                        if (firebaseMessaging.f3413e.b()) {
                            firebaseMessaging.k();
                            return;
                        }
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging2 = this.f1428g;
                        Context context3 = firebaseMessaging2.f3410b;
                        k3.b.q(context3);
                        AbstractC0602b.Q(context3, firebaseMessaging2.f3411c, firebaseMessaging2.j());
                        if (firebaseMessaging2.j()) {
                            firebaseMessaging2.g();
                            return;
                        }
                        return;
                }
            }
        });
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC0275a("Firebase-Messaging-Topics-Io"));
        int i6 = G.f1359j;
        C0585n g4 = AbstractC0602b.g(scheduledThreadPoolExecutor2, new Callable() { // from class: P1.F
            /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, P1.E] */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                E e4;
                Context context3 = context2;
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor3 = scheduledThreadPoolExecutor2;
                FirebaseMessaging firebaseMessaging = this;
                C0050d c0050d2 = c0050d;
                I0.h hVar = obj;
                synchronized (E.class) {
                    try {
                        WeakReference weakReference = E.f1351b;
                        if (weakReference != null) {
                            e4 = (E) weakReference.get();
                        } else {
                            e4 = null;
                        }
                        if (e4 == null) {
                            SharedPreferences sharedPreferences = context3.getSharedPreferences("com.google.android.gms.appid", 0);
                            ?? obj2 = new Object();
                            synchronized (obj2) {
                                obj2.f1352a = D2.L.a(sharedPreferences, scheduledThreadPoolExecutor3);
                            }
                            E.f1351b = new WeakReference(obj2);
                            e4 = obj2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new G(firebaseMessaging, c0050d2, e4, hVar, context3, scheduledThreadPoolExecutor3);
            }
        });
        this.f3416h = g4;
        g4.b(scheduledThreadPoolExecutor, new n(this, i5));
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: P1.m

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f1428g;

            {
                this.f1428g = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i4) {
                    case 0:
                        FirebaseMessaging firebaseMessaging = this.f1428g;
                        if (firebaseMessaging.f3413e.b()) {
                            firebaseMessaging.k();
                            return;
                        }
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging2 = this.f1428g;
                        Context context3 = firebaseMessaging2.f3410b;
                        k3.b.q(context3);
                        AbstractC0602b.Q(context3, firebaseMessaging2.f3411c, firebaseMessaging2.j());
                        if (firebaseMessaging2.j()) {
                            firebaseMessaging2.g();
                            return;
                        }
                        return;
                }
            }
        });
    }

    public static void b(Runnable runnable, long j4) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f3408n == null) {
                    f3408n = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC0275a("TAG"));
                }
                f3408n.schedule(runnable, j4, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized FirebaseMessaging c() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(f.d());
        }
        return firebaseMessaging;
    }

    public static synchronized A d(Context context) {
        A a4;
        synchronized (FirebaseMessaging.class) {
            try {
                if (f3406l == null) {
                    f3406l = new A(context);
                }
                a4 = f3406l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a4;
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(f fVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            fVar.a();
            firebaseMessaging = (FirebaseMessaging) fVar.f6224d.a(FirebaseMessaging.class);
            Z0.r.f(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    public final String a() {
        AbstractC0579h abstractC0579h;
        z f4 = f();
        if (!m(f4)) {
            return f4.f1474a;
        }
        String d4 = C0050d.d(this.f3409a);
        C0106j c0106j = this.f3412d;
        synchronized (c0106j) {
            abstractC0579h = (AbstractC0579h) ((C0656e) c0106j.f1424b).get(d4);
            if (abstractC0579h != null) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Joining ongoing request for: " + d4);
                }
            } else {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Making new request for: " + d4);
                }
                h hVar = this.f3411c;
                abstractC0579h = hVar.k(hVar.p(C0050d.d((f) hVar.f819a), "*", new Bundle())).k(this.f3415g, new N0.a(this, d4, f4, 4)).j((Executor) c0106j.f1423a, new j(4, c0106j, d4));
                ((C0656e) c0106j.f1424b).put(d4, abstractC0579h);
            }
        }
        try {
            return (String) AbstractC0602b.c(abstractC0579h);
        } catch (InterruptedException | ExecutionException e4) {
            throw new IOException(e4);
        }
    }

    public final String e() {
        f fVar = this.f3409a;
        fVar.a();
        if ("[DEFAULT]".equals(fVar.f6222b)) {
            return "";
        }
        return fVar.f();
    }

    public final z f() {
        z b4;
        A d4 = d(this.f3410b);
        String e4 = e();
        String d5 = C0050d.d(this.f3409a);
        synchronized (d4) {
            b4 = z.b(d4.f1340a.getString(A.a(e4, d5), null));
        }
        return b4;
    }

    public final void g() {
        C0585n z;
        int i4;
        b bVar = (b) this.f3411c.f821c;
        if (bVar.f1678c.a() >= 241100000) {
            V0.n a4 = V0.n.a(bVar.f1677b);
            Bundle bundle = Bundle.EMPTY;
            synchronized (a4) {
                i4 = a4.f1716d;
                a4.f1716d = i4 + 1;
            }
            z = a4.b(new m(i4, 5, bundle, 1)).i(V0.h.f1691h, d.f1685h);
        } else {
            z = AbstractC0602b.z(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        z.b(this.f3414f, new n(this, 1));
    }

    public final void h(w wVar) {
        if (!TextUtils.isEmpty(wVar.f1465f.getString("google.to"))) {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            Context context = this.f3410b;
            intent.putExtra("app", PendingIntent.getBroadcast(context, 0, intent2, 67108864));
            intent.setPackage("com.google.android.gms");
            intent.putExtras(wVar.f1465f);
            context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public final void i(boolean z) {
        r rVar = this.f3413e;
        synchronized (rVar) {
            try {
                rVar.a();
                q qVar = (q) rVar.f1439c;
                if (qVar != null) {
                    ((i) ((c) rVar.f1438b)).c(qVar);
                    rVar.f1439c = null;
                }
                f fVar = ((FirebaseMessaging) rVar.f1441e).f3409a;
                fVar.a();
                SharedPreferences.Editor edit = fVar.f6221a.getSharedPreferences("com.google.firebase.messaging", 0).edit();
                edit.putBoolean("auto_init", z);
                edit.apply();
                if (z) {
                    ((FirebaseMessaging) rVar.f1441e).k();
                }
                rVar.f1440d = Boolean.valueOf(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean j() {
        String notificationDelegate;
        Context context = this.f3410b;
        k3.b.q(context);
        if (Build.VERSION.SDK_INT >= 29) {
            if (Binder.getCallingUid() == context.getApplicationInfo().uid) {
                notificationDelegate = ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationDelegate();
                if ("com.google.android.gms".equals(notificationDelegate)) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "GMS core is set for proxying");
                    }
                    f fVar = this.f3409a;
                    fVar.a();
                    if (fVar.f6224d.a(InterfaceC0691a.class) == null) {
                        if (AbstractC0286a.h() && f3407m != null) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            } else {
                Log.e("FirebaseMessaging", "error retrieving notification delegate for package " + context.getPackageName());
                return false;
            }
        } else if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Platform doesn't support proxying.");
        }
        return false;
    }

    public final void k() {
        if (m(f())) {
            synchronized (this) {
                if (!this.f3418j) {
                    l(0L);
                }
            }
        }
    }

    public final synchronized void l(long j4) {
        b(new C(this, Math.min(Math.max(30L, 2 * j4), k)), j4);
        this.f3418j = true;
    }

    public final boolean m(z zVar) {
        if (zVar != null) {
            String a4 = this.f3417i.a();
            if (System.currentTimeMillis() <= zVar.f1476c + z.f1473d && a4.equals(zVar.f1475b)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
