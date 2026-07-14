package g3;

import b3.AbstractC0242q;
import b3.AbstractC0247w;
import b3.InterfaceC0248x;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class g extends AbstractC0242q implements InterfaceC0248x {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3786l = AtomicIntegerFieldUpdater.newUpdater(g.class, "runningWorkers$volatile");

    /* renamed from: h, reason: collision with root package name */
    public final AbstractC0242q f3787h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3788i;

    /* renamed from: j, reason: collision with root package name */
    public final k f3789j;
    public final Object k;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public g(AbstractC0242q abstractC0242q, int i4) {
        InterfaceC0248x interfaceC0248x;
        if (abstractC0242q instanceof InterfaceC0248x) {
            interfaceC0248x = (InterfaceC0248x) abstractC0242q;
        } else {
            interfaceC0248x = null;
        }
        if (interfaceC0248x == null) {
            int i5 = AbstractC0247w.f3310a;
        }
        this.f3787h = abstractC0242q;
        this.f3788i = i4;
        this.f3789j = new k();
        this.k = new Object();
    }

    @Override // b3.AbstractC0242q
    public final void d(K2.i iVar, Runnable runnable) {
        this.f3789j.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3786l;
        if (atomicIntegerFieldUpdater.get(this) < this.f3788i) {
            synchronized (this.k) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f3788i) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable h3 = h();
                if (h3 != null) {
                    this.f3787h.d(this, new F.a(6, this, h3, false));
                }
            }
        }
    }

    public final Runnable h() {
        while (true) {
            Runnable runnable = (Runnable) this.f3789j.d();
            if (runnable == null) {
                synchronized (this.k) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3786l;
                    atomicIntegerFieldUpdater.decrementAndGet(this);
                    if (this.f3789j.c() == 0) {
                        return null;
                    }
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                }
            } else {
                return runnable;
            }
        }
    }

    @Override // b3.AbstractC0242q
    public final String toString() {
        return this.f3787h + ".limitedParallelism(" + this.f3788i + ')';
    }
}
