package Y0;

import Z0.C;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import f1.AbstractC0286a;
import h1.AbstractC0338c;
import h1.AbstractC0339d;
import h1.HandlerC0340e;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import t.C0657f;

/* loaded from: classes.dex */
public final class d implements Handler.Callback {

    /* renamed from: o, reason: collision with root package name */
    public static final Status f2026o = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);

    /* renamed from: p, reason: collision with root package name */
    public static final Status f2027p = new Status(4, "The user must be signed in to make this API call.", null, null);

    /* renamed from: q, reason: collision with root package name */
    public static final Object f2028q = new Object();

    /* renamed from: r, reason: collision with root package name */
    public static d f2029r;

    /* renamed from: a, reason: collision with root package name */
    public long f2030a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2031b;

    /* renamed from: c, reason: collision with root package name */
    public Z0.i f2032c;

    /* renamed from: d, reason: collision with root package name */
    public b1.e f2033d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f2034e;

    /* renamed from: f, reason: collision with root package name */
    public final W0.d f2035f;

    /* renamed from: g, reason: collision with root package name */
    public final E0.a f2036g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicInteger f2037h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f2038i;

    /* renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f2039j;
    public final C0657f k;

    /* renamed from: l, reason: collision with root package name */
    public final C0657f f2040l;

    /* renamed from: m, reason: collision with root package name */
    public final HandlerC0340e f2041m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f2042n;

    /* JADX WARN: Type inference failed for: r2v5, types: [h1.e, android.os.Handler] */
    public d(Context context, Looper looper) {
        W0.d dVar = W0.d.f1860d;
        this.f2030a = 10000L;
        this.f2031b = false;
        this.f2037h = new AtomicInteger(1);
        this.f2038i = new AtomicInteger(0);
        this.f2039j = new ConcurrentHashMap(5, 0.75f, 1);
        this.k = new C0657f(0);
        this.f2040l = new C0657f(0);
        this.f2042n = true;
        this.f2034e = context;
        ?? handler = new Handler(looper, this);
        Looper.getMainLooper();
        this.f2041m = handler;
        this.f2035f = dVar;
        this.f2036g = new E0.a(19);
        PackageManager packageManager = context.getPackageManager();
        if (d1.b.f3468e == null) {
            d1.b.f3468e = Boolean.valueOf(d1.b.b() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (d1.b.f3468e.booleanValue()) {
            this.f2042n = false;
        }
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static Status b(a aVar, W0.a aVar2) {
        String str = (String) aVar.f2018b.f460h;
        String valueOf = String.valueOf(aVar2);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + valueOf.length());
        sb.append("API: ");
        sb.append(str);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(17, sb.toString(), aVar2.f1849h, aVar2);
    }

    public static d c(Context context) {
        d dVar;
        HandlerThread handlerThread;
        synchronized (f2028q) {
            if (f2029r == null) {
                synchronized (C.f2098g) {
                    try {
                        handlerThread = C.f2100i;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                            C.f2100i = handlerThread2;
                            handlerThread2.start();
                            handlerThread = C.f2100i;
                        }
                    } finally {
                    }
                }
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = W0.d.f1859c;
                f2029r = new d(applicationContext, looper);
            }
            dVar = f2029r;
        }
        return dVar;
    }

    public final k a(X0.e eVar) {
        a aVar = eVar.f1997f;
        ConcurrentHashMap concurrentHashMap = this.f2039j;
        k kVar = (k) concurrentHashMap.get(aVar);
        if (kVar == null) {
            kVar = new k(this, eVar);
            concurrentHashMap.put(aVar, kVar);
        }
        if (kVar.f2048g.b()) {
            this.f2040l.add(aVar);
        }
        kVar.q();
        return kVar;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [Z0.g, java.lang.Object] */
    public final boolean d() {
        Z0.g gVar;
        int i4;
        if (!this.f2031b) {
            synchronized (Z0.g.class) {
                try {
                    if (Z0.g.f2139f == null) {
                        Z0.g.f2139f = new Object();
                    }
                    gVar = Z0.g.f2139f;
                } finally {
                }
            }
            gVar.getClass();
            SparseIntArray sparseIntArray = (SparseIntArray) this.f2036g.f459g;
            synchronized (sparseIntArray) {
                i4 = sparseIntArray.get(203400000, -1);
            }
            if (i4 != -1 && i4 != 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r14v4, types: [X0.e, b1.e] */
    /* JADX WARN: Type inference failed for: r15v8, types: [Y0.h, java.lang.Object] */
    public final boolean e(W0.a aVar, int i4) {
        PendingIntent pendingIntent;
        boolean booleanValue;
        boolean isInstantApp;
        boolean z;
        PendingIntent pendingIntent2;
        int intValue;
        Boolean bool;
        W0.d dVar = this.f2035f;
        Context context = this.f2034e;
        dVar.getClass();
        synchronized (AbstractC0286a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = AbstractC0286a.f3702a;
            pendingIntent = null;
            if (context2 != null && (bool = AbstractC0286a.f3703b) != null && context2 == applicationContext) {
                booleanValue = bool.booleanValue();
            }
            AbstractC0286a.f3703b = null;
            if (d1.b.b()) {
                isInstantApp = applicationContext.getPackageManager().isInstantApp();
                AbstractC0286a.f3703b = Boolean.valueOf(isInstantApp);
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    AbstractC0286a.f3703b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    AbstractC0286a.f3703b = Boolean.FALSE;
                }
            }
            AbstractC0286a.f3702a = applicationContext;
            booleanValue = AbstractC0286a.f3703b.booleanValue();
        }
        if (booleanValue) {
            return false;
        }
        int i5 = aVar.f1848g;
        if (i5 != 0 && aVar.f1849h != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            pendingIntent2 = aVar.f1849h;
        } else {
            Intent a4 = dVar.a(i5, context, null);
            if (a4 != null) {
                pendingIntent = PendingIntent.getActivity(context, 0, a4, 201326592);
            }
            pendingIntent2 = pendingIntent;
        }
        if (pendingIntent2 == null) {
            return false;
        }
        int i6 = aVar.f1848g;
        int i7 = GoogleApiActivity.f3362g;
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent2);
        intent.putExtra("failing_client_id", i4);
        intent.putExtra("notify_manager", true);
        dVar.f(context, i6, PendingIntent.getActivity(context, 0, intent, AbstractC0339d.f3947a | 134217728));
        dVar.getClass();
        Integer num = aVar.f1851j;
        if (num == null) {
            intValue = -1;
        } else {
            intValue = num.intValue();
        }
        Z0.k kVar = new Z0.k(intValue, context.getPackageName(), System.currentTimeMillis(), aVar.f1848g, false);
        if (dVar.f1861b == null) {
            dVar.f1861b = new X0.e(context, b1.e.f3208j, X0.b.f1989a, X0.d.f1990b);
        }
        b1.e eVar = dVar.f1861b;
        eVar.getClass();
        ?? obj = new Object();
        obj.f2043a = new W0.c[]{AbstractC0338c.f3945b};
        obj.f2044b = false;
        obj.f2045c = new R1.c(16, kVar);
        eVar.b(new h(obj, (W0.c[]) obj.f2043a, obj.f2044b));
        return true;
    }

    public final void f(W0.a aVar, int i4) {
        if (!e(aVar, i4)) {
            HandlerC0340e handlerC0340e = this.f2041m;
            handlerC0340e.sendMessage(handlerC0340e.obtainMessage(5, i4, 0, aVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0396  */
    /* JADX WARN: Type inference failed for: r1v57, types: [Y0.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v59, types: [Y0.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v29, types: [X0.e, b1.e] */
    /* JADX WARN: Type inference failed for: r2v33, types: [X0.e, b1.e] */
    /* JADX WARN: Type inference failed for: r5v7, types: [Y0.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [X0.e, b1.e] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r14) {
        /*
            Method dump skipped, instructions count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Y0.d.handleMessage(android.os.Message):boolean");
    }
}
