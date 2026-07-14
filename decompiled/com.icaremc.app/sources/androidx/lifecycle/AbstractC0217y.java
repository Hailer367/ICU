package androidx.lifecycle;

import android.os.Looper;
import java.util.Map;
import q.C0589c;
import q.C0590d;
import q.C0592f;

/* renamed from: androidx.lifecycle.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0217y {
    public static final Object k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f3037a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final C0592f f3038b = new C0592f();

    /* renamed from: c, reason: collision with root package name */
    public int f3039c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3040d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f3041e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f3042f;

    /* renamed from: g, reason: collision with root package name */
    public int f3043g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3044h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3045i;

    /* renamed from: j, reason: collision with root package name */
    public final F.b f3046j;

    public AbstractC0217y() {
        Object obj = k;
        this.f3042f = obj;
        this.f3046j = new F.b(10, this);
        this.f3041e = obj;
        this.f3043g = -1;
    }

    public static void a(String str) {
        p.a.D().f5794m.getClass();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
        } else {
            throw new IllegalStateException(r2.k.b("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(C0216x c0216x) {
        if (this.f3044h) {
            this.f3045i = true;
            return;
        }
        this.f3044h = true;
        do {
            this.f3045i = false;
            if (c0216x != null) {
                if (c0216x.f3034b) {
                    int i4 = c0216x.f3035c;
                    int i5 = this.f3043g;
                    if (i4 < i5) {
                        c0216x.f3035c = i5;
                        c0216x.f3033a.v(this.f3041e);
                    }
                }
                c0216x = null;
            } else {
                C0592f c0592f = this.f3038b;
                c0592f.getClass();
                C0590d c0590d = new C0590d(c0592f);
                c0592f.f5851h.put(c0590d, Boolean.FALSE);
                while (c0590d.hasNext()) {
                    C0216x c0216x2 = (C0216x) ((Map.Entry) c0590d.next()).getValue();
                    if (c0216x2.f3034b) {
                        int i6 = c0216x2.f3035c;
                        int i7 = this.f3043g;
                        if (i6 < i7) {
                            c0216x2.f3035c = i7;
                            c0216x2.f3033a.v(this.f3041e);
                        }
                    }
                    if (this.f3045i) {
                        break;
                    }
                }
            }
        } while (this.f3045i);
        this.f3044h = false;
    }

    public final void c(A a4) {
        Object obj;
        a("observeForever");
        C0216x c0216x = new C0216x(this, a4);
        C0592f c0592f = this.f3038b;
        C0589c a5 = c0592f.a(a4);
        if (a5 != null) {
            obj = a5.f5843g;
        } else {
            C0589c c0589c = new C0589c(a4, c0216x);
            c0592f.f5852i++;
            C0589c c0589c2 = c0592f.f5850g;
            if (c0589c2 == null) {
                c0592f.f5849f = c0589c;
                c0592f.f5850g = c0589c;
            } else {
                c0589c2.f5844h = c0589c;
                c0589c.f5845i = c0589c2;
                c0592f.f5850g = c0589c;
            }
            obj = null;
        }
        if (((C0216x) obj) != null) {
            return;
        }
        c0216x.a(true);
    }

    public final void d(Object obj) {
        boolean z;
        synchronized (this.f3037a) {
            if (this.f3042f == k) {
                z = true;
            } else {
                z = false;
            }
            this.f3042f = obj;
        }
        if (!z) {
            return;
        }
        p.a D3 = p.a.D();
        F.b bVar = this.f3046j;
        p.c cVar = D3.f5794m;
        if (cVar.f5797n == null) {
            synchronized (cVar.f5796m) {
                try {
                    if (cVar.f5797n == null) {
                        cVar.f5797n = p.c.D(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        cVar.f5797n.post(bVar);
    }

    public final void e(A a4) {
        a("removeObserver");
        C0216x c0216x = (C0216x) this.f3038b.b(a4);
        if (c0216x == null) {
            return;
        }
        c0216x.a(false);
    }

    public void f(Object obj) {
        a("setValue");
        this.f3043g++;
        this.f3041e = obj;
        b(null);
    }
}
