package P1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import e1.ThreadFactoryC0275a;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p1.C0585n;

/* loaded from: classes.dex */
public final class M implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1383a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f1384b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f1385c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f1386d;

    /* renamed from: e, reason: collision with root package name */
    public K f1387e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1388f;

    public M(Context context) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC0275a("Firebase-FirebaseInstanceIdServiceConnection"));
        scheduledThreadPoolExecutor.setKeepAliveTime(40L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f1386d = new ArrayDeque();
        this.f1388f = false;
        Context applicationContext = context.getApplicationContext();
        this.f1383a = applicationContext;
        this.f1384b = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.f1385c = scheduledThreadPoolExecutor;
    }

    public final synchronized void a() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.f1386d.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                K k = this.f1387e;
                if (k != null && k.isBinderAlive()) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                    }
                    this.f1387e.a((L) this.f1386d.poll());
                } else {
                    c();
                    return;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized C0585n b(Intent intent) {
        L l3;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            l3 = new L(intent);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f1385c;
            l3.f1382b.f5821a.g(scheduledThreadPoolExecutor, new D2.J(13, scheduledThreadPoolExecutor.schedule(new A.k(5, l3), 20L, TimeUnit.SECONDS)));
            this.f1386d.add(l3);
            a();
        } catch (Throwable th) {
            throw th;
        }
        return l3.f1382b.f5821a;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[LOOP:0: B:20:0x0053->B:22:0x005b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r10 = this;
            r0 = 3
            java.lang.String r1 = "FirebaseMessaging"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            r2 = 1
            if (r0 == 0) goto L1e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "binder is dead. start connection? "
            r0.<init>(r3)
            boolean r3 = r10.f1388f
            r3 = r3 ^ r2
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L1e:
            boolean r0 = r10.f1388f
            if (r0 == 0) goto L24
            r7 = r10
            goto L68
        L24:
            r10.f1388f = r2
            c1.b r3 = c1.C0256b.a()     // Catch: java.lang.SecurityException -> L49
            android.content.Context r4 = r10.f1383a     // Catch: java.lang.SecurityException -> L49
            android.content.Intent r6 = r10.f1384b     // Catch: java.lang.SecurityException -> L49
            java.lang.Class r0 = r4.getClass()     // Catch: java.lang.SecurityException -> L49
            java.lang.String r5 = r0.getName()     // Catch: java.lang.SecurityException -> L49
            r9 = 0
            r8 = 65
            r7 = r10
            boolean r0 = r3.c(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.SecurityException -> L47
            if (r0 == 0) goto L41
            goto L68
        L41:
            java.lang.String r0 = "binding to the service failed"
            android.util.Log.e(r1, r0)     // Catch: java.lang.SecurityException -> L47
            goto L50
        L47:
            r0 = move-exception
            goto L4b
        L49:
            r0 = move-exception
            r7 = r10
        L4b:
            java.lang.String r2 = "Exception while binding the service"
            android.util.Log.e(r1, r2, r0)
        L50:
            r0 = 0
            r7.f1388f = r0
        L53:
            java.util.ArrayDeque r0 = r7.f1386d
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L68
            java.lang.Object r0 = r0.poll()
            P1.L r0 = (P1.L) r0
            p1.i r0 = r0.f1382b
            r1 = 0
            r0.d(r1)
            goto L53
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P1.M.c():void");
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
            }
            this.f1388f = false;
            if (!(iBinder instanceof K)) {
                Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
                ArrayDeque arrayDeque = this.f1386d;
                while (!arrayDeque.isEmpty()) {
                    ((L) arrayDeque.poll()).f1382b.d(null);
                }
                return;
            }
            this.f1387e = (K) iBinder;
            a();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        a();
    }
}
