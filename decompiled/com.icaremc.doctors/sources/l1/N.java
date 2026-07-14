package l1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class N extends T {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2962f = AtomicIntegerFieldUpdater.newUpdater(N.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;

    /* renamed from: e, reason: collision with root package name */
    public final S f2963e;

    public N(S s2) {
        this.f2963e = s2;
    }

    @Override // l1.T
    public final boolean j() {
        return true;
    }

    @Override // l1.T
    public final void k(Throwable th) {
        if (f2962f.compareAndSet(this, 0, 1)) {
            this.f2963e.invoke(th);
        }
    }
}
