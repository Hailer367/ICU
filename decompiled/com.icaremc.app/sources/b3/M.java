package b3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class M extends S {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3248f = AtomicIntegerFieldUpdater.newUpdater(M.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;

    /* renamed from: e, reason: collision with root package name */
    public final Q f3249e;

    public M(Q q2) {
        this.f3249e = q2;
    }

    @Override // b3.S
    public final boolean j() {
        return true;
    }

    @Override // b3.S
    public final void k(Throwable th) {
        if (f3248f.compareAndSet(this, 0, 1)) {
            this.f3249e.f(th);
        }
    }
}
