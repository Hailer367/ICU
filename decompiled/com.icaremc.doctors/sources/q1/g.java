package q1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import l1.AbstractC0240s;
import l1.AbstractC0246y;
import l1.InterfaceC0247z;

/* loaded from: classes.dex */
public final class g extends AbstractC0240s implements InterfaceC0247z {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3520i = AtomicIntegerFieldUpdater.newUpdater(g.class, "runningWorkers$volatile");

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0240s f3521e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3522f;

    /* renamed from: g, reason: collision with root package name */
    public final k f3523g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f3524h;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public g(AbstractC0240s abstractC0240s, int i2) {
        InterfaceC0247z interfaceC0247z;
        if (abstractC0240s instanceof InterfaceC0247z) {
            interfaceC0247z = (InterfaceC0247z) abstractC0240s;
        } else {
            interfaceC0247z = null;
        }
        if (interfaceC0247z == null) {
            int i3 = AbstractC0246y.f3027a;
        }
        this.f3521e = abstractC0240s;
        this.f3522f = i2;
        this.f3523g = new k();
        this.f3524h = new Object();
    }

    @Override // l1.AbstractC0240s
    public final void e(T0.i iVar, Runnable runnable) {
        this.f3523g.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3520i;
        if (atomicIntegerFieldUpdater.get(this) < this.f3522f) {
            synchronized (this.f3524h) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f3522f) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable i2 = i();
                if (i2 != null) {
                    this.f3521e.e(this, new B.a(this, i2, 4, false));
                }
            }
        }
    }

    public final Runnable i() {
        while (true) {
            Runnable runnable = (Runnable) this.f3523g.d();
            if (runnable == null) {
                synchronized (this.f3524h) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3520i;
                    atomicIntegerFieldUpdater.decrementAndGet(this);
                    if (this.f3523g.c() == 0) {
                        return null;
                    }
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                }
            } else {
                return runnable;
            }
        }
    }

    @Override // l1.AbstractC0240s
    public final String toString() {
        return this.f3521e + ".limitedParallelism(" + this.f3522f + ')';
    }
}
