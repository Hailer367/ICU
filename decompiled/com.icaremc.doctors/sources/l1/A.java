package l1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class A extends q1.q {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2948g = AtomicIntegerFieldUpdater.newUpdater(A.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    @Override // q1.q, l1.X
    public final void l(Object obj) {
        m(obj);
    }

    @Override // q1.q, l1.X
    public final void m(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = f2948g;
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 != 0) {
                if (i2 == 1) {
                    q1.a.h(android.support.v4.media.session.a.v(this.f3540f), AbstractC0244w.g(obj));
                    return;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
