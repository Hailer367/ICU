package Y0;

import Z0.z;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import h1.HandlerC0340e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import m1.C0441a;
import p1.C0580i;
import t.C0657f;
import t.C0661j;

/* loaded from: classes.dex */
public final class k implements X0.f, X0.g {

    /* renamed from: g, reason: collision with root package name */
    public final X0.c f2048g;

    /* renamed from: h, reason: collision with root package name */
    public final a f2049h;

    /* renamed from: i, reason: collision with root package name */
    public final E0.a f2050i;

    /* renamed from: l, reason: collision with root package name */
    public final int f2052l;

    /* renamed from: m, reason: collision with root package name */
    public final r f2053m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2054n;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ d f2057q;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedList f2047f = new LinkedList();

    /* renamed from: j, reason: collision with root package name */
    public final HashSet f2051j = new HashSet();
    public final HashMap k = new HashMap();

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f2055o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public W0.a f2056p = null;

    public k(d dVar, X0.e eVar) {
        this.f2057q = dVar;
        Looper looper = dVar.f2041m.getLooper();
        A2.t a4 = eVar.a();
        I0.h hVar = new I0.h((String) a4.f100h, (String) a4.f101i, (C0657f) a4.f99g);
        android.support.v4.media.session.a aVar = (android.support.v4.media.session.a) eVar.f1995d.f459g;
        Z0.r.e(aVar);
        X0.c e4 = aVar.e(eVar.f1992a, looper, hVar, eVar.f1996e, this, this);
        R1.c cVar = eVar.f1994c;
        if (cVar != null && (e4 instanceof com.google.android.gms.common.internal.a)) {
            ((com.google.android.gms.common.internal.a) e4).f3388s = cVar;
        } else {
            String str = eVar.f1993b;
            if (str != null && (e4 instanceof com.google.android.gms.common.internal.a)) {
                ((com.google.android.gms.common.internal.a) e4).f3387r = str;
            }
        }
        this.f2048g = e4;
        this.f2049h = eVar.f1997f;
        this.f2050i = new E0.a(14);
        this.f2052l = eVar.f1998g;
        if (e4.b()) {
            Context context = dVar.f2034e;
            HandlerC0340e handlerC0340e = dVar.f2041m;
            A2.t a5 = eVar.a();
            this.f2053m = new r(context, handlerC0340e, new I0.h((String) a5.f100h, (String) a5.f101i, (C0657f) a5.f99g));
            return;
        }
        this.f2053m = null;
    }

    @Override // X0.g
    public final void a(W0.a aVar) {
        n(aVar, null);
    }

    public final void b() {
        d dVar = this.f2057q;
        Z0.r.b(dVar.f2041m);
        this.f2056p = null;
        l(W0.a.k);
        if (this.f2054n) {
            HandlerC0340e handlerC0340e = dVar.f2041m;
            a aVar = this.f2049h;
            handlerC0340e.removeMessages(11, aVar);
            dVar.f2041m.removeMessages(9, aVar);
            this.f2054n = false;
        }
        Iterator it = this.k.values().iterator();
        if (!it.hasNext()) {
            g();
            k();
        } else {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public final void c(int i4) {
        Z0.r.b(this.f2057q.f2041m);
        this.f2056p = null;
        this.f2054n = true;
        String str = ((com.google.android.gms.common.internal.a) this.f2048g).f3371a;
        E0.a aVar = this.f2050i;
        aVar.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i4 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i4 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        aVar.I(true, new Status(20, sb.toString(), null, null));
        a aVar2 = this.f2049h;
        d dVar = this.f2057q;
        HandlerC0340e handlerC0340e = dVar.f2041m;
        handlerC0340e.sendMessageDelayed(Message.obtain(handlerC0340e, 9, aVar2), 5000L);
        HandlerC0340e handlerC0340e2 = dVar.f2041m;
        handlerC0340e2.sendMessageDelayed(Message.obtain(handlerC0340e2, 11, aVar2), 120000L);
        SparseIntArray sparseIntArray = (SparseIntArray) dVar.f2036g.f459g;
        synchronized (sparseIntArray) {
            sparseIntArray.clear();
        }
        Iterator it = this.k.values().iterator();
        if (!it.hasNext()) {
            return;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // X0.f
    public final void d(int i4) {
        d dVar = this.f2057q;
        if (Looper.myLooper() == dVar.f2041m.getLooper()) {
            c(i4);
        } else {
            dVar.f2041m.post(new T.i(this, i4));
        }
    }

    public final boolean e(W0.a aVar) {
        synchronized (d.f2028q) {
            this.f2057q.getClass();
        }
        return false;
    }

    @Override // X0.f
    public final void f() {
        d dVar = this.f2057q;
        if (Looper.myLooper() == dVar.f2041m.getLooper()) {
            b();
        } else {
            dVar.f2041m.post(new F.b(3, this));
        }
    }

    public final void g() {
        LinkedList linkedList = this.f2047f;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            p pVar = (p) arrayList.get(i4);
            if (((com.google.android.gms.common.internal.a) this.f2048g).m()) {
                if (h(pVar)) {
                    linkedList.remove(pVar);
                }
            } else {
                return;
            }
        }
    }

    public final boolean h(p pVar) {
        W0.c[] cVarArr;
        if (pVar == null) {
            E0.a aVar = this.f2050i;
            X0.c cVar = this.f2048g;
            pVar.f(aVar, cVar.b());
            try {
                pVar.g(this);
                return true;
            } catch (DeadObjectException unused) {
                d(1);
                ((com.google.android.gms.common.internal.a) cVar).e("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        W0.c[] a4 = pVar.a(this);
        W0.c cVar2 = null;
        if (a4 != null && a4.length != 0) {
            z zVar = ((com.google.android.gms.common.internal.a) this.f2048g).f3391v;
            if (zVar == null) {
                cVarArr = null;
            } else {
                cVarArr = zVar.f2189g;
            }
            if (cVarArr == null) {
                cVarArr = new W0.c[0];
            }
            C0661j c0661j = new C0661j(cVarArr.length);
            for (W0.c cVar3 : cVarArr) {
                c0661j.put(cVar3.f1855f, Long.valueOf(cVar3.a()));
            }
            for (W0.c cVar4 : a4) {
                Long l3 = (Long) c0661j.get(cVar4.f1855f);
                if (l3 == null || l3.longValue() < cVar4.a()) {
                    cVar2 = cVar4;
                    break;
                }
            }
        }
        if (cVar2 == null) {
            E0.a aVar2 = this.f2050i;
            X0.c cVar5 = this.f2048g;
            pVar.f(aVar2, cVar5.b());
            try {
                pVar.g(this);
                return true;
            } catch (DeadObjectException unused2) {
                d(1);
                ((com.google.android.gms.common.internal.a) cVar5).e("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        String name = this.f2048g.getClass().getName();
        String str = cVar2.f1855f;
        long a5 = cVar2.a();
        StringBuilder sb = new StringBuilder(name.length() + 53 + String.valueOf(str).length() + 2 + String.valueOf(a5).length() + 2);
        sb.append(name);
        sb.append(" could not execute call because it requires feature (");
        sb.append(str);
        sb.append(", ");
        sb.append(a5);
        sb.append(").");
        Log.w("GoogleApiManager", sb.toString());
        d dVar = this.f2057q;
        if (dVar.f2042n && pVar.b(this)) {
            int c4 = pVar.c(this);
            l lVar = new l(this.f2049h, cVar2);
            ArrayList arrayList = this.f2055o;
            int indexOf = arrayList.indexOf(lVar);
            if (indexOf >= 0) {
                l lVar2 = (l) arrayList.get(indexOf);
                dVar.f2041m.removeMessages(15, lVar2);
                dVar.f2041m.sendMessageDelayed(Message.obtain(dVar.f2041m, 15, lVar2), 5000L);
            } else {
                arrayList.add(lVar);
                dVar.f2041m.sendMessageDelayed(Message.obtain(dVar.f2041m, 15, lVar), 5000L);
                dVar.f2041m.sendMessageDelayed(Message.obtain(dVar.f2041m, 16, lVar), 120000L);
                W0.a aVar3 = new W0.a(1, 2, null, null, Integer.valueOf(c4));
                if (!e(aVar3)) {
                    if (dVar.e(aVar3, this.f2052l)) {
                        String str2 = cVar2.f1855f;
                        long a6 = cVar2.a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 55 + String.valueOf(a6).length());
                        sb2.append("Notification displayed for missing feature: ");
                        sb2.append(str2);
                        sb2.append(", version: ");
                        sb2.append(a6);
                        Log.w("GoogleApiManager", sb2.toString());
                    }
                } else {
                    String str3 = cVar2.f1855f;
                    long a7 = cVar2.a();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str3).length() + 61 + String.valueOf(a7).length());
                    sb3.append("A dialog should be displayed for missing feature: ");
                    sb3.append(str3);
                    sb3.append(", version: ");
                    sb3.append(a7);
                    Log.w("GoogleApiManager", sb3.toString());
                }
            }
            return false;
        }
        pVar.e(new X0.j(cVar2));
        return true;
    }

    public final void i(Status status, Exception exc, boolean z) {
        boolean z3;
        Z0.r.b(this.f2057q.f2041m);
        boolean z4 = true;
        if (status != null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (exc != null) {
            z4 = false;
        }
        if (z3 != z4) {
            Iterator it = this.f2047f.iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                if (!z || pVar.f2065a == 2) {
                    if (status != null) {
                        pVar.d(status);
                    } else {
                        pVar.e(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    public final void j(Status status) {
        Z0.r.b(this.f2057q.f2041m);
        i(status, null, false);
    }

    public final void k() {
        d dVar = this.f2057q;
        HandlerC0340e handlerC0340e = dVar.f2041m;
        a aVar = this.f2049h;
        handlerC0340e.removeMessages(12, aVar);
        HandlerC0340e handlerC0340e2 = dVar.f2041m;
        handlerC0340e2.sendMessageDelayed(handlerC0340e2.obtainMessage(12, aVar), dVar.f2030a);
    }

    public final void l(W0.a aVar) {
        HashSet hashSet = this.f2051j;
        Iterator it = hashSet.iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (Z0.r.g(aVar, W0.a.k)) {
                    com.google.android.gms.common.internal.a aVar2 = (com.google.android.gms.common.internal.a) this.f2048g;
                    if (!aVar2.m() || aVar2.f3372b == null) {
                        throw new RuntimeException("Failed to connect when checking package");
                    }
                }
                throw null;
            }
            throw new ClassCastException();
        }
        hashSet.clear();
    }

    public final void m(W0.a aVar) {
        Z0.r.b(this.f2057q.f2041m);
        X0.c cVar = this.f2048g;
        String name = cVar.getClass().getName();
        String valueOf = String.valueOf(aVar);
        StringBuilder sb = new StringBuilder(name.length() + 25 + valueOf.length());
        sb.append("onSignInFailed for ");
        sb.append(name);
        sb.append(" with ");
        sb.append(valueOf);
        ((com.google.android.gms.common.internal.a) cVar).e(sb.toString());
        n(aVar, null);
    }

    public final void n(W0.a aVar, RuntimeException runtimeException) {
        n1.a aVar2;
        d dVar = this.f2057q;
        Z0.r.b(dVar.f2041m);
        r rVar = this.f2053m;
        if (rVar != null && (aVar2 = rVar.f2074l) != null) {
            aVar2.d();
        }
        Z0.r.b(this.f2057q.f2041m);
        this.f2056p = null;
        SparseIntArray sparseIntArray = (SparseIntArray) dVar.f2036g.f459g;
        synchronized (sparseIntArray) {
            sparseIntArray.clear();
        }
        l(aVar);
        if ((this.f2048g instanceof b1.f) && aVar.f1848g != 24) {
            dVar.f2031b = true;
            HandlerC0340e handlerC0340e = dVar.f2041m;
            handlerC0340e.sendMessageDelayed(handlerC0340e.obtainMessage(19), 300000L);
        }
        int i4 = aVar.f1848g;
        if (i4 == 4) {
            j(d.f2027p);
            return;
        }
        if (i4 == 25) {
            j(d.b(this.f2049h, aVar));
            return;
        }
        LinkedList linkedList = this.f2047f;
        if (linkedList.isEmpty()) {
            this.f2056p = aVar;
            return;
        }
        if (runtimeException != null) {
            Z0.r.b(dVar.f2041m);
            i(null, runtimeException, false);
            return;
        }
        if (dVar.f2042n) {
            a aVar3 = this.f2049h;
            i(d.b(aVar3, aVar), null, true);
            if (!linkedList.isEmpty() && !e(aVar) && !dVar.e(aVar, this.f2052l)) {
                if (aVar.f1848g == 18) {
                    this.f2054n = true;
                }
                if (this.f2054n) {
                    HandlerC0340e handlerC0340e2 = dVar.f2041m;
                    handlerC0340e2.sendMessageDelayed(Message.obtain(handlerC0340e2, 9, aVar3), 5000L);
                    return;
                } else {
                    j(d.b(aVar3, aVar));
                    return;
                }
            }
            return;
        }
        j(d.b(this.f2049h, aVar));
    }

    public final void o(p pVar) {
        Z0.r.b(this.f2057q.f2041m);
        boolean m3 = ((com.google.android.gms.common.internal.a) this.f2048g).m();
        LinkedList linkedList = this.f2047f;
        if (m3) {
            if (h(pVar)) {
                k();
                return;
            } else {
                linkedList.add(pVar);
                return;
            }
        }
        linkedList.add(pVar);
        W0.a aVar = this.f2056p;
        if (aVar != null && aVar.f1848g != 0 && aVar.f1849h != null) {
            n(aVar, null);
        } else {
            q();
        }
    }

    public final void p() {
        d dVar = this.f2057q;
        Z0.r.b(dVar.f2041m);
        Status status = d.f2026o;
        j(status);
        this.f2050i.I(false, status);
        for (f fVar : (f[]) this.k.keySet().toArray(new f[0])) {
            o(new t(new C0580i()));
        }
        l(new W0.a(4, null, null));
        if (((com.google.android.gms.common.internal.a) this.f2048g).m()) {
            dVar.f2041m.post(new F.b(4, new A2.q(13, this)));
        }
    }

    public final void q() {
        d dVar = this.f2057q;
        Z0.r.b(dVar.f2041m);
        X0.c cVar = this.f2048g;
        com.google.android.gms.common.internal.a aVar = (com.google.android.gms.common.internal.a) cVar;
        if (!aVar.m() && !aVar.n()) {
            try {
                int H3 = dVar.f2036g.H(dVar.f2034e, aVar);
                if (H3 != 0) {
                    W0.a aVar2 = new W0.a(H3, null, null);
                    String name = cVar.getClass().getName();
                    String aVar3 = aVar2.toString();
                    StringBuilder sb = new StringBuilder(name.length() + 35 + aVar3.length());
                    sb.append("The service for ");
                    sb.append(name);
                    sb.append(" is not available: ");
                    sb.append(aVar3);
                    Log.w("GoogleApiManager", sb.toString());
                    n(aVar2, null);
                    return;
                }
                m mVar = new m(dVar, aVar, this.f2049h);
                if (aVar.b()) {
                    r rVar = this.f2053m;
                    Z0.r.e(rVar);
                    n1.a aVar4 = rVar.f2074l;
                    if (aVar4 != null) {
                        aVar4.d();
                    }
                    I0.h hVar = rVar.k;
                    hVar.f820b = Integer.valueOf(System.identityHashCode(rVar));
                    b1.d dVar2 = rVar.f2072i;
                    Context context = rVar.f2070g;
                    Handler handler = rVar.f2071h;
                    rVar.f2074l = (n1.a) dVar2.e(context, handler.getLooper(), hVar, (C0441a) hVar.f824f, rVar, rVar);
                    rVar.f2075m = mVar;
                    Set set = rVar.f2073j;
                    if (set != null && !set.isEmpty()) {
                        n1.a aVar5 = rVar.f2074l;
                        aVar5.getClass();
                        aVar5.f3379i = new R1.c(aVar5);
                        aVar5.p(2, null);
                    } else {
                        handler.post(new F.b(rVar));
                    }
                }
                try {
                    aVar.f3379i = mVar;
                    aVar.p(2, null);
                } catch (SecurityException e4) {
                    n(new W0.a(10, null, null), e4);
                }
            } catch (IllegalStateException e5) {
                n(new W0.a(10, null, null), e5);
            }
        }
    }
}
