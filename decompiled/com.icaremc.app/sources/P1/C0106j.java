package P1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Base64;
import android.util.Log;
import f0.ExecutorC0283c;
import java.util.ArrayDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import p1.AbstractC0579h;
import p1.C0585n;
import p1.InterfaceC0572a;
import q1.AbstractC0602b;
import t.C0661j;

/* renamed from: P1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0106j {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f1421c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static M f1422d;

    /* renamed from: a, reason: collision with root package name */
    public final Object f1423a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1424b;

    public C0106j(ExecutorService executorService) {
        this.f1424b = new C0661j(0);
        this.f1423a = executorService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.concurrent.Executor, java.lang.Object] */
    public static C0585n a(Context context, Intent intent, boolean z) {
        M m3;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        synchronized (f1421c) {
            try {
                if (f1422d == null) {
                    f1422d = new M(context);
                }
                m3 = f1422d;
            } finally {
            }
        }
        if (z) {
            if (y.l().o(context)) {
                synchronized (J.f1378b) {
                    try {
                        J.a(context);
                        boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                        if (!booleanExtra) {
                            J.f1379c.a(J.f1377a);
                        }
                        m3.b(intent).h(new D2.J(11, intent));
                    } finally {
                    }
                }
            } else {
                m3.b(intent);
            }
            return AbstractC0602b.A(-1);
        }
        return m3.b(intent).i(new Object(), new D2.K(18));
    }

    public C0585n b(final Intent intent) {
        boolean z;
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        final boolean z3 = false;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        final Context context = (Context) this.f1423a;
        ExecutorC0283c executorC0283c = (ExecutorC0283c) this.f1424b;
        if (d1.b.b() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        } else {
            z = false;
        }
        if ((intent.getFlags() & 268435456) != 0) {
            z3 = true;
        }
        if (z && !z3) {
            return a(context, intent, z3);
        }
        return AbstractC0602b.g(executorC0283c, new Callable() { // from class: P1.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                ServiceInfo serviceInfo;
                String str2;
                int i4;
                ComponentName startService;
                Context context2 = context;
                Intent intent2 = intent;
                y l3 = y.l();
                l3.getClass();
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Starting service");
                }
                ((ArrayDeque) l3.f1472i).offer(intent2);
                Intent intent3 = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent3.setPackage(context2.getPackageName());
                synchronized (l3) {
                    try {
                        str = (String) l3.f1469f;
                        if (str == null) {
                            ResolveInfo resolveService = context2.getPackageManager().resolveService(intent3, 0);
                            if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
                                if (context2.getPackageName().equals(serviceInfo.packageName) && (str2 = serviceInfo.name) != null) {
                                    if (str2.startsWith(".")) {
                                        l3.f1469f = context2.getPackageName() + serviceInfo.name;
                                    } else {
                                        l3.f1469f = serviceInfo.name;
                                    }
                                    str = (String) l3.f1469f;
                                }
                                Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                                str = null;
                            }
                            Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
                            str = null;
                        }
                    } finally {
                    }
                }
                if (str != null) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Restricting intent to a specific service: ".concat(str));
                    }
                    intent3.setClassName(context2.getPackageName(), str);
                }
                try {
                    if (l3.o(context2)) {
                        startService = J.c(context2, intent3);
                    } else {
                        startService = context2.startService(intent3);
                        Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
                    }
                    if (startService == null) {
                        Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
                        i4 = 404;
                    } else {
                        i4 = -1;
                    }
                } catch (IllegalStateException e4) {
                    Log.e("FirebaseMessaging", "Failed to start service while in background: " + e4);
                    i4 = 402;
                } catch (SecurityException e5) {
                    Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e5);
                    i4 = 401;
                }
                return Integer.valueOf(i4);
            }
        }).j(executorC0283c, new InterfaceC0572a() { // from class: P1.i
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v5, types: [java.util.concurrent.Executor, java.lang.Object] */
            @Override // p1.InterfaceC0572a
            public final Object b(AbstractC0579h abstractC0579h) {
                if (d1.b.b() && ((Integer) abstractC0579h.d()).intValue() == 402) {
                    return C0106j.a(context, intent, z3).i(new Object(), new D2.K(17));
                }
                return abstractC0579h;
            }
        });
    }

    public C0106j(Context context) {
        this.f1423a = context;
        this.f1424b = new Object();
    }
}
