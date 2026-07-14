package com.google.android.gms.common.internal;

import I0.h;
import W0.d;
import W0.e;
import X0.c;
import X0.f;
import X0.g;
import Z0.A;
import Z0.C;
import Z0.C0138d;
import Z0.D;
import Z0.InterfaceC0136b;
import Z0.InterfaceC0139e;
import Z0.p;
import Z0.q;
import Z0.r;
import Z0.u;
import Z0.v;
import Z0.w;
import Z0.x;
import Z0.y;
import Z0.z;
import android.accounts.Account;
import android.content.AttributionSource;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class a implements c {

    /* renamed from: y, reason: collision with root package name */
    public static final W0.c[] f3370y = new W0.c[0];

    /* renamed from: a, reason: collision with root package name */
    public volatile String f3371a;

    /* renamed from: b, reason: collision with root package name */
    public D f3372b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f3373c;

    /* renamed from: d, reason: collision with root package name */
    public final C f3374d;

    /* renamed from: e, reason: collision with root package name */
    public final u f3375e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f3376f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3377g;

    /* renamed from: h, reason: collision with root package name */
    public q f3378h;

    /* renamed from: i, reason: collision with root package name */
    public InterfaceC0136b f3379i;

    /* renamed from: j, reason: collision with root package name */
    public IInterface f3380j;
    public final ArrayList k;

    /* renamed from: l, reason: collision with root package name */
    public w f3381l;

    /* renamed from: m, reason: collision with root package name */
    public int f3382m;

    /* renamed from: n, reason: collision with root package name */
    public final A2.q f3383n;

    /* renamed from: o, reason: collision with root package name */
    public final R1.c f3384o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3385p;

    /* renamed from: q, reason: collision with root package name */
    public final String f3386q;

    /* renamed from: r, reason: collision with root package name */
    public volatile String f3387r;

    /* renamed from: s, reason: collision with root package name */
    public volatile R1.c f3388s;

    /* renamed from: t, reason: collision with root package name */
    public W0.a f3389t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3390u;

    /* renamed from: v, reason: collision with root package name */
    public volatile z f3391v;

    /* renamed from: w, reason: collision with root package name */
    public final AtomicInteger f3392w;

    /* renamed from: x, reason: collision with root package name */
    public final Set f3393x;

    public a(Context context, Looper looper, int i4, h hVar, f fVar, g gVar) {
        synchronized (C.f2098g) {
            try {
                if (C.f2099h == null) {
                    C.f2099h = new C(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C c4 = C.f2099h;
        Object obj = d.f1859c;
        r.e(fVar);
        r.e(gVar);
        A2.q qVar = new A2.q(14, fVar);
        R1.c cVar = new R1.c(15, gVar);
        String str = (String) hVar.f823e;
        this.f3371a = null;
        this.f3376f = new Object();
        this.f3377g = new Object();
        this.k = new ArrayList();
        this.f3382m = 1;
        this.f3389t = null;
        this.f3390u = false;
        this.f3391v = null;
        this.f3392w = new AtomicInteger(0);
        r.f(context, "Context must not be null");
        this.f3373c = context;
        r.f(looper, "Looper must not be null");
        r.f(c4, "Supervisor must not be null");
        this.f3374d = c4;
        this.f3375e = new u(this, looper);
        this.f3385p = i4;
        this.f3383n = qVar;
        this.f3384o = cVar;
        this.f3386q = str;
        Set set = (Set) hVar.f822d;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f3393x = set;
    }

    @Override // X0.c
    public boolean b() {
        return false;
    }

    public abstract IInterface c(IBinder iBinder);

    public final void d() {
        this.f3392w.incrementAndGet();
        ArrayList arrayList = this.k;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    p pVar = (p) arrayList.get(i4);
                    synchronized (pVar) {
                        pVar.f2168a = null;
                    }
                }
                arrayList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f3377g) {
            this.f3378h = null;
        }
        p(1, null);
    }

    public final void e(String str) {
        this.f3371a = str;
        d();
    }

    public W0.c[] f() {
        return f3370y;
    }

    public Bundle g() {
        return new Bundle();
    }

    public final void h(InterfaceC0139e interfaceC0139e, Set set) {
        String attributionTag;
        String attributionTag2;
        Bundle g4 = g();
        if (Build.VERSION.SDK_INT < 31) {
            attributionTag2 = this.f3387r;
        } else if (this.f3388s == null) {
            attributionTag2 = this.f3387r;
        } else {
            AttributionSource attributionSource = (AttributionSource) this.f3388s.f1532g;
            if (attributionSource != null) {
                attributionTag = attributionSource.getAttributionTag();
                if (attributionTag != null) {
                    attributionTag2 = attributionSource.getAttributionTag();
                } else {
                    attributionTag2 = this.f3387r;
                }
            } else {
                attributionTag2 = this.f3387r;
            }
        }
        String str = attributionTag2;
        int i4 = this.f3385p;
        int i5 = e.f1862a;
        Scope[] scopeArr = C0138d.f2116t;
        Bundle bundle = new Bundle();
        W0.c[] cVarArr = C0138d.f2117u;
        C0138d c0138d = new C0138d(6, i4, i5, null, null, scopeArr, bundle, null, cVarArr, cVarArr, true, 0, false, str);
        c0138d.f2121i = this.f3373c.getPackageName();
        c0138d.f2123l = g4;
        if (set != null) {
            c0138d.k = (Scope[]) set.toArray(new Scope[0]);
        }
        if (b()) {
            c0138d.f2124m = new Account("<<default account>>", "com.google");
            if (interfaceC0139e != null) {
                c0138d.f2122j = interfaceC0139e.asBinder();
            }
        }
        c0138d.f2125n = f3370y;
        c0138d.f2126o = f();
        try {
            synchronized (this.f3377g) {
                try {
                    q qVar = this.f3378h;
                    if (qVar != null) {
                        qVar.a(new v(this, this.f3392w.get()), c0138d);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            int i6 = this.f3392w.get();
            u uVar = this.f3375e;
            uVar.sendMessage(uVar.obtainMessage(6, i6, 3));
        } catch (RemoteException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i7 = this.f3392w.get();
            x xVar = new x(this, 8, null, null);
            u uVar2 = this.f3375e;
            uVar2.sendMessage(uVar2.obtainMessage(1, i7, -1, xVar));
        } catch (SecurityException e6) {
            throw e6;
        } catch (RuntimeException e7) {
            e = e7;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i72 = this.f3392w.get();
            x xVar2 = new x(this, 8, null, null);
            u uVar22 = this.f3375e;
            uVar22.sendMessage(uVar22.obtainMessage(1, i72, -1, xVar2));
        }
    }

    public final IInterface i() {
        IInterface iInterface;
        synchronized (this.f3376f) {
            try {
                if (this.f3382m != 5) {
                    if (m()) {
                        IInterface iInterface2 = this.f3380j;
                        r.f(iInterface2, "Client is connected but service is null");
                        iInterface = iInterface2;
                    } else {
                        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                    }
                } else {
                    throw new DeadObjectException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String j();

    public abstract String k();

    public boolean l() {
        if (a() >= 211700000) {
            return true;
        }
        return false;
    }

    public final boolean m() {
        boolean z;
        synchronized (this.f3376f) {
            if (this.f3382m == 4) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean n() {
        boolean z;
        synchronized (this.f3376f) {
            int i4 = this.f3382m;
            z = true;
            if (i4 != 2 && i4 != 3) {
                z = false;
            }
        }
        return z;
    }

    public final /* synthetic */ boolean o(int i4, int i5, IInterface iInterface) {
        synchronized (this.f3376f) {
            try {
                if (this.f3382m != i4) {
                    return false;
                }
                p(i5, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p(int i4, IInterface iInterface) {
        boolean z;
        boolean z3;
        D d4;
        boolean z4 = false;
        if (i4 != 4) {
            z = false;
        } else {
            z = true;
        }
        if (iInterface == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z == z3) {
            synchronized (this.f3376f) {
                try {
                    this.f3382m = i4;
                    this.f3380j = iInterface;
                    Bundle bundle = null;
                    if (i4 != 1) {
                        if (i4 != 2 && i4 != 3) {
                            if (i4 == 4) {
                                r.e(iInterface);
                                IInterface iInterface2 = iInterface;
                                System.currentTimeMillis();
                            }
                        } else {
                            w wVar = this.f3381l;
                            if (wVar != null && (d4 = this.f3372b) != null) {
                                String str = (String) d4.f2108g;
                                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 70 + "com.google.android.gms".length());
                                sb.append("Calling connect() while still connected, missing disconnect() for ");
                                sb.append(str);
                                sb.append(" on com.google.android.gms");
                                Log.e("GmsClient", sb.toString());
                                C c4 = this.f3374d;
                                String str2 = (String) this.f3372b.f2108g;
                                r.e(str2);
                                this.f3372b.getClass();
                                if (this.f3386q == null) {
                                    this.f3373c.getClass();
                                }
                                c4.b(str2, wVar, this.f3372b.f2107f);
                                this.f3392w.incrementAndGet();
                            }
                            w wVar2 = new w(this, this.f3392w.get());
                            this.f3381l = wVar2;
                            String k = k();
                            boolean l3 = l();
                            this.f3372b = new D(k, l3);
                            if (l3 && a() < 17895000) {
                                throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf((String) this.f3372b.f2108g)));
                            }
                            C c5 = this.f3374d;
                            String str3 = (String) this.f3372b.f2108g;
                            r.e(str3);
                            this.f3372b.getClass();
                            String str4 = this.f3386q;
                            if (str4 == null) {
                                str4 = this.f3373c.getClass().getName();
                            }
                            W0.a a4 = c5.a(new A(str3, this.f3372b.f2107f), wVar2, str4);
                            if (a4.f1848g == 0) {
                                z4 = true;
                            }
                            if (!z4) {
                                String str5 = (String) this.f3372b.f2108g;
                                StringBuilder sb2 = new StringBuilder(String.valueOf(str5).length() + 34 + "com.google.android.gms".length());
                                sb2.append("unable to connect to service: ");
                                sb2.append(str5);
                                sb2.append(" on com.google.android.gms");
                                Log.w("GmsClient", sb2.toString());
                                int i5 = a4.f1848g;
                                if (i5 == -1) {
                                    i5 = 16;
                                }
                                if (a4.f1849h != null) {
                                    bundle = new Bundle();
                                    bundle.putParcelable("pendingIntent", a4.f1849h);
                                }
                                int i6 = this.f3392w.get();
                                y yVar = new y(this, i5, bundle);
                                u uVar = this.f3375e;
                                uVar.sendMessage(uVar.obtainMessage(7, i6, -1, yVar));
                            }
                        }
                    } else {
                        w wVar3 = this.f3381l;
                        if (wVar3 != null) {
                            C c6 = this.f3374d;
                            String str6 = (String) this.f3372b.f2108g;
                            r.e(str6);
                            this.f3372b.getClass();
                            if (this.f3386q == null) {
                                this.f3373c.getClass();
                            }
                            c6.b(str6, wVar3, this.f3372b.f2107f);
                            this.f3381l = null;
                        }
                    }
                } finally {
                }
            }
            return;
        }
        throw new IllegalArgumentException();
    }
}
