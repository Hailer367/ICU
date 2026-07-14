package o1;

import A2.i;
import Z0.r;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import d1.C0259a;
import d1.c;
import d1.d;
import f1.C0287b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import k1.C0430a;

/* renamed from: o1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0560a {

    /* renamed from: n, reason: collision with root package name */
    public static final long f5769n = TimeUnit.DAYS.toMillis(366);

    /* renamed from: o, reason: collision with root package name */
    public static volatile ScheduledExecutorService f5770o = null;

    /* renamed from: p, reason: collision with root package name */
    public static final Object f5771p = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f5772a;

    /* renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f5773b;

    /* renamed from: c, reason: collision with root package name */
    public int f5774c;

    /* renamed from: d, reason: collision with root package name */
    public ScheduledFuture f5775d;

    /* renamed from: e, reason: collision with root package name */
    public long f5776e;

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f5777f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5778g;

    /* renamed from: h, reason: collision with root package name */
    public C0430a f5779h;

    /* renamed from: i, reason: collision with root package name */
    public final C0259a f5780i;

    /* renamed from: j, reason: collision with root package name */
    public final String f5781j;
    public final HashMap k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicInteger f5782l;

    /* renamed from: m, reason: collision with root package name */
    public final ScheduledExecutorService f5783m;

    public C0560a(Context context) {
        boolean z;
        boolean z3;
        String str;
        String packageName = context.getPackageName();
        this.f5772a = new Object();
        this.f5774c = 0;
        this.f5777f = new HashSet();
        this.f5778g = true;
        this.f5780i = C0259a.f3463a;
        this.k = new HashMap();
        this.f5782l = new AtomicInteger(0);
        r.d("wake:com.google.firebase.iid.WakeLockHolder", "WakeLock: wakeLockName must not be empty");
        context.getApplicationContext();
        WorkSource workSource = null;
        this.f5779h = null;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            if ("wake:com.google.firebase.iid.WakeLockHolder".length() != 0) {
                str = "*gcore*:".concat("wake:com.google.firebase.iid.WakeLockHolder");
            } else {
                str = new String("*gcore*:");
            }
            this.f5781j = str;
        } else {
            this.f5781j = "wake:com.google.firebase.iid.WakeLockHolder";
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            this.f5773b = powerManager.newWakeLock(1, "wake:com.google.firebase.iid.WakeLockHolder");
            Method method = d.f3473a;
            synchronized (d.class) {
                Boolean bool = d.f3475c;
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    if (android.support.v4.media.session.a.i(context, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    d.f3475c = Boolean.valueOf(z);
                }
            }
            if (z) {
                int i4 = c.f3472a;
                if (packageName != null && !packageName.trim().isEmpty()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                packageName = z3 ? context.getPackageName() : packageName;
                if (context.getPackageManager() != null && packageName != null) {
                    try {
                        ApplicationInfo applicationInfo = C0287b.a(context).f117a.getPackageManager().getApplicationInfo(packageName, 0);
                        if (applicationInfo == null) {
                            Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(packageName));
                        } else {
                            int i5 = applicationInfo.uid;
                            workSource = new WorkSource();
                            Method method2 = d.f3474b;
                            if (method2 != null) {
                                try {
                                    method2.invoke(workSource, Integer.valueOf(i5), packageName);
                                } catch (Exception e4) {
                                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e4);
                                }
                            } else {
                                Method method3 = d.f3473a;
                                if (method3 != null) {
                                    try {
                                        method3.invoke(workSource, Integer.valueOf(i5));
                                    } catch (Exception e5) {
                                        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
                                    }
                                }
                            }
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        Log.e("WorkSourceUtil", "Could not find package: ".concat(packageName));
                    }
                }
                if (workSource != null) {
                    try {
                        this.f5773b.setWorkSource(workSource);
                    } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e6) {
                        Log.wtf("WakeLock", e6.toString());
                    }
                }
            }
            ScheduledExecutorService scheduledExecutorService = f5770o;
            if (scheduledExecutorService == null) {
                synchronized (f5771p) {
                    try {
                        scheduledExecutorService = f5770o;
                        if (scheduledExecutorService == null) {
                            scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                            f5770o = scheduledExecutorService;
                        }
                    } finally {
                    }
                }
            }
            this.f5783m = scheduledExecutorService;
            return;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append((CharSequence) "expected a non-null reference", 0, 29);
        throw new RuntimeException(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(long j4) {
        this.f5782l.incrementAndGet();
        long j5 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, f5769n), 1L);
        if (j4 > 0) {
            max = Math.min(j4, max);
        }
        synchronized (this.f5772a) {
            try {
                if (!b()) {
                    this.f5779h = C0430a.f5107f;
                    this.f5773b.acquire();
                    this.f5780i.getClass();
                    SystemClock.elapsedRealtime();
                }
                this.f5774c++;
                if (this.f5778g) {
                    TextUtils.isEmpty(null);
                }
                b bVar = (b) this.k.get(null);
                b bVar2 = bVar;
                if (bVar == null) {
                    Object obj = new Object();
                    this.k.put(null, obj);
                    bVar2 = obj;
                }
                bVar2.f5784a++;
                this.f5780i.getClass();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (Long.MAX_VALUE - elapsedRealtime > max) {
                    j5 = elapsedRealtime + max;
                }
                if (j5 > this.f5776e) {
                    this.f5776e = j5;
                    ScheduledFuture scheduledFuture = this.f5775d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f5775d = this.f5783m.schedule(new F.b(17, this), max, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this.f5772a) {
            if (this.f5774c > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final void c() {
        if (this.f5782l.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f5781j).concat(" release without a matched acquire!"));
        }
        synchronized (this.f5772a) {
            try {
                if (this.f5778g) {
                    TextUtils.isEmpty(null);
                }
                if (this.k.containsKey(null)) {
                    b bVar = (b) this.k.get(null);
                    if (bVar != null) {
                        int i4 = bVar.f5784a - 1;
                        bVar.f5784a = i4;
                        if (i4 == 0) {
                            this.k.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f5781j).concat(" counter does not exist"));
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        HashSet hashSet = this.f5777f;
        if (!hashSet.isEmpty()) {
            ArrayList arrayList = new ArrayList(hashSet);
            hashSet.clear();
            if (arrayList.size() <= 0) {
            } else {
                throw i.f(arrayList, 0);
            }
        }
    }

    public final void e() {
        synchronized (this.f5772a) {
            try {
                if (!b()) {
                    return;
                }
                if (this.f5778g) {
                    int i4 = this.f5774c - 1;
                    this.f5774c = i4;
                    if (i4 > 0) {
                        return;
                    }
                } else {
                    this.f5774c = 0;
                }
                d();
                Iterator it = this.k.values().iterator();
                while (it.hasNext()) {
                    ((b) it.next()).f5784a = 0;
                }
                this.k.clear();
                ScheduledFuture scheduledFuture = this.f5775d;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    this.f5775d = null;
                    this.f5776e = 0L;
                }
                if (this.f5773b.isHeld()) {
                    try {
                        try {
                            this.f5773b.release();
                            if (this.f5779h != null) {
                                this.f5779h = null;
                            }
                        } catch (RuntimeException e4) {
                            if (e4.getClass().equals(RuntimeException.class)) {
                                Log.e("WakeLock", String.valueOf(this.f5781j).concat(" failed to release!"), e4);
                                if (this.f5779h != null) {
                                    this.f5779h = null;
                                }
                            } else {
                                throw e4;
                            }
                        }
                    } catch (Throwable th) {
                        if (this.f5779h != null) {
                            this.f5779h = null;
                        }
                        throw th;
                    }
                } else {
                    Log.e("WakeLock", String.valueOf(this.f5781j).concat(" should be held!"));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
