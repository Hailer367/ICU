package b3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: b3.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0249y extends g3.q {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3311j = AtomicIntegerFieldUpdater.newUpdater(C0249y.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    @Override // g3.q, b3.W
    public final void m(Object obj) {
        n(obj);
    }

    @Override // g3.q, b3.W
    public final void n(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = f3311j;
            int i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 != 0) {
                if (i4 == 1) {
                    g3.a.h(k3.b.r(this.f3805i), AbstractC0245u.g(obj));
                    return;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
