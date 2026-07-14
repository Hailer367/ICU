package q1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l1.AbstractC0240s;
import l1.AbstractC0244w;
import l1.B;
import l1.C0238p;
import l1.H;
import l1.f0;

/* loaded from: classes.dex */
public final class f extends B implements V0.d, T0.d {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3515j = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC0240s f3516f;

    /* renamed from: g, reason: collision with root package name */
    public final V0.c f3517g;

    /* renamed from: h, reason: collision with root package name */
    public Object f3518h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f3519i;

    public f(AbstractC0240s abstractC0240s, V0.c cVar) {
        super(-1);
        this.f3516f = abstractC0240s;
        this.f3517g = cVar;
        this.f3518h = a.f3504b;
        this.f3519i = a.k(cVar.getContext());
    }

    @Override // V0.d
    public final V0.d getCallerFrame() {
        return this.f3517g;
    }

    @Override // T0.d
    public final T0.i getContext() {
        return this.f3517g.getContext();
    }

    @Override // l1.B
    public final Object h() {
        Object obj = this.f3518h;
        this.f3518h = a.f3504b;
        return obj;
    }

    @Override // T0.d
    public final void resumeWith(Object obj) {
        Object c0238p;
        Throwable a2 = Q0.g.a(obj);
        if (a2 == null) {
            c0238p = obj;
        } else {
            c0238p = new C0238p(a2, false);
        }
        V0.c cVar = this.f3517g;
        T0.i context = cVar.getContext();
        AbstractC0240s abstractC0240s = this.f3516f;
        if (abstractC0240s.f(context)) {
            this.f3518h = c0238p;
            this.f2949e = 0;
            abstractC0240s.e(cVar.getContext(), this);
            return;
        }
        H a3 = f0.a();
        if (a3.f2956e >= 4294967296L) {
            this.f3518h = c0238p;
            this.f2949e = 0;
            R0.h hVar = a3.f2958g;
            if (hVar == null) {
                hVar = new R0.h();
                a3.f2958g = hVar;
            }
            hVar.addLast(this);
            return;
        }
        a3.l(true);
        try {
            T0.i context2 = cVar.getContext();
            Object l2 = a.l(context2, this.f3519i);
            try {
                cVar.resumeWith(obj);
                do {
                } while (a3.n());
            } finally {
                a.g(context2, l2);
            }
        } catch (Throwable th) {
            try {
                g(th);
            } finally {
                a3.i(true);
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f3516f + ", " + AbstractC0244w.j(this.f3517g) + ']';
    }

    @Override // l1.B
    public final T0.d c() {
        return this;
    }
}
