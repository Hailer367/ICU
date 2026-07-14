package q1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import l1.a0;

/* loaded from: classes.dex */
public abstract class r extends b implements a0 {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3541d = AtomicIntegerFieldUpdater.newUpdater(r.class, "cleanedAndPointers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final long f3542c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public r(long j2, r rVar, int i2) {
        super(rVar);
        this.f3542c = j2;
        this.cleanedAndPointers$volatile = i2 << 16;
    }

    @Override // q1.b
    public final boolean c() {
        if (f3541d.get(this) == f() && b() != null) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (f3541d.addAndGet(this, -65536) == f() && b() != null) {
            return true;
        }
        return false;
    }

    public abstract int f();

    public abstract void g(int i2, T0.i iVar);

    public final void h() {
        if (f3541d.incrementAndGet(this) == f()) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = f3541d;
            i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 65536 + i2));
        return true;
    }
}
