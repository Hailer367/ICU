package D2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.WeakHashMap;

/* renamed from: D2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0024c {

    /* renamed from: a, reason: collision with root package name */
    public final A2.q f362a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f363b = new WeakHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f364c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f365d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final ReferenceQueue f366e = new ReferenceQueue();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f367f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Handler f368g;

    /* renamed from: h, reason: collision with root package name */
    public final A.k f369h;

    /* renamed from: i, reason: collision with root package name */
    public long f370i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f371j;
    public final long k;

    public C0024c(A2.q qVar) {
        this.f362a = qVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f368g = handler;
        A.k kVar = new A.k(1, this);
        this.f369h = kVar;
        this.f370i = 65536L;
        this.k = 3000L;
        handler.postDelayed(kVar, 3000L);
    }

    public final void a(long j4, Object obj) {
        T2.h.e(obj, "instance");
        f();
        c(j4, obj);
    }

    public final long b(Object obj) {
        T2.h.e(obj, "instance");
        f();
        if (!d(obj)) {
            long j4 = this.f370i;
            this.f370i = 1 + j4;
            c(j4, obj);
            return j4;
        }
        throw new IllegalArgumentException(("Instance of " + obj.getClass() + " has already been added.").toString());
    }

    public final void c(long j4, Object obj) {
        if (j4 >= 0) {
            Long valueOf = Long.valueOf(j4);
            HashMap hashMap = this.f364c;
            if (!hashMap.containsKey(valueOf)) {
                C0023b c0023b = new C0023b(obj, this.f366e);
                this.f363b.put(c0023b, Long.valueOf(j4));
                hashMap.put(Long.valueOf(j4), c0023b);
                this.f367f.put(c0023b, Long.valueOf(j4));
                this.f365d.put(Long.valueOf(j4), obj);
                return;
            }
            throw new IllegalArgumentException(("Identifier has already been added: " + j4).toString());
        }
        throw new IllegalArgumentException(("Identifier must be >= 0: " + j4).toString());
    }

    public final boolean d(Object obj) {
        f();
        if (obj != null) {
            if (this.f363b.containsKey(new C0023b(obj))) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final Object e(long j4) {
        f();
        C0023b c0023b = (C0023b) this.f364c.get(Long.valueOf(j4));
        if (c0023b != null) {
            return c0023b.get();
        }
        return null;
    }

    public final void f() {
        if (this.f371j) {
            Log.w("PigeonInstanceManager", "The manager was used after calls to the PigeonFinalizationListener has been stopped.");
        }
    }
}
