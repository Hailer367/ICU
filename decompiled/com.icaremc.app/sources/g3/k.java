package g3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3794a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new m(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3794a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            int a4 = mVar.a(runnable);
            if (a4 == 0) {
                return true;
            }
            if (a4 != 1) {
                if (a4 == 2) {
                    return false;
                }
            } else {
                m c4 = mVar.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, c4) && atomicReferenceFieldUpdater.get(this) == mVar) {
                }
            }
        }
    }

    public final void b() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3794a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar.b()) {
                return;
            }
            m c4 = mVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, c4) && atomicReferenceFieldUpdater.get(this) == mVar) {
            }
        }
    }

    public final int c() {
        m mVar = (m) f3794a.get(this);
        mVar.getClass();
        long j4 = m.f3797f.get(mVar);
        return (((int) ((j4 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j4))) & 1073741823;
    }

    public final Object d() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3794a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            Object d4 = mVar.d();
            if (d4 != m.f3798g) {
                return d4;
            }
            m c4 = mVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, c4) && atomicReferenceFieldUpdater.get(this) == mVar) {
            }
        }
    }
}
