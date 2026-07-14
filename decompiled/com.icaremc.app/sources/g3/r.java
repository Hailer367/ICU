package g3;

import b3.Z;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public abstract class r extends b implements Z {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3806d = AtomicIntegerFieldUpdater.newUpdater(r.class, "cleanedAndPointers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final long f3807c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public r(long j4, r rVar, int i4) {
        super(rVar);
        this.f3807c = j4;
        this.cleanedAndPointers$volatile = i4 << 16;
    }

    @Override // g3.b
    public final boolean c() {
        if (f3806d.get(this) == f() && b() != null) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (f3806d.addAndGet(this, -65536) == f() && b() != null) {
            return true;
        }
        return false;
    }

    public abstract int f();

    public abstract void g(int i4, K2.i iVar);

    public final void h() {
        if (f3806d.incrementAndGet(this) == f()) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i4;
        do {
            atomicIntegerFieldUpdater = f3806d;
            i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, 65536 + i4));
        return true;
    }
}
