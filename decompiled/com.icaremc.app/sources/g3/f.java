package g3;

import b3.AbstractC0242q;
import b3.AbstractC0245u;
import b3.AbstractC0250z;
import b3.C0240o;
import b3.G;
import b3.e0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class f extends AbstractC0250z implements M2.d, K2.d {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3782m = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: i, reason: collision with root package name */
    public final AbstractC0242q f3783i;

    /* renamed from: j, reason: collision with root package name */
    public final M2.c f3784j;
    public Object k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f3785l;

    public f(AbstractC0242q abstractC0242q, M2.c cVar) {
        super(-1);
        this.f3783i = abstractC0242q;
        this.f3784j = cVar;
        this.k = a.f3771b;
        this.f3785l = a.k(cVar.getContext());
    }

    @Override // M2.d
    public final M2.d d() {
        return this.f3784j;
    }

    @Override // K2.d
    public final K2.i getContext() {
        return this.f3784j.getContext();
    }

    @Override // b3.AbstractC0250z
    public final Object i() {
        Object obj = this.k;
        this.k = a.f3771b;
        return obj;
    }

    @Override // K2.d
    public final void resumeWith(Object obj) {
        Object c0240o;
        Throwable a4 = H2.f.a(obj);
        if (a4 == null) {
            c0240o = obj;
        } else {
            c0240o = new C0240o(a4, false);
        }
        M2.c cVar = this.f3784j;
        K2.i context = cVar.getContext();
        AbstractC0242q abstractC0242q = this.f3783i;
        if (abstractC0242q.f(context)) {
            this.k = c0240o;
            this.f3312h = 0;
            abstractC0242q.d(cVar.getContext(), this);
            return;
        }
        G a5 = e0.a();
        if (a5.f3242h >= 4294967296L) {
            this.k = c0240o;
            this.f3312h = 0;
            I2.c cVar2 = a5.f3244j;
            if (cVar2 == null) {
                cVar2 = new I2.c();
                a5.f3244j = cVar2;
            }
            cVar2.addLast(this);
            return;
        }
        a5.l(true);
        try {
            K2.i context2 = cVar.getContext();
            Object l3 = a.l(context2, this.f3785l);
            try {
                cVar.resumeWith(obj);
                do {
                } while (a5.n());
            } finally {
                a.g(context2, l3);
            }
        } catch (Throwable th) {
            try {
                g(th);
            } finally {
                a5.h(true);
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f3783i + ", " + AbstractC0245u.j(this.f3784j) + ']';
    }

    @Override // b3.AbstractC0250z
    public final K2.d c() {
        return this;
    }
}
