package v;

import a.AbstractC0141a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: v.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0673e extends AbstractC0141a {

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f6245e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f6246f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f6247g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f6248h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f6249i;

    public C0673e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f6245e = atomicReferenceFieldUpdater;
        this.f6246f = atomicReferenceFieldUpdater2;
        this.f6247g = atomicReferenceFieldUpdater3;
        this.f6248h = atomicReferenceFieldUpdater4;
        this.f6249i = atomicReferenceFieldUpdater5;
    }

    @Override // a.AbstractC0141a
    public final void B(C0675g c0675g, C0675g c0675g2) {
        this.f6246f.lazySet(c0675g, c0675g2);
    }

    @Override // a.AbstractC0141a
    public final void C(C0675g c0675g, Thread thread) {
        this.f6245e.lazySet(c0675g, thread);
    }

    @Override // a.AbstractC0141a
    public final boolean b(AbstractFutureC0676h abstractFutureC0676h, C0672d c0672d) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f6248h;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractFutureC0676h, c0672d, C0672d.f6243b)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractFutureC0676h) == c0672d);
        return false;
    }

    @Override // a.AbstractC0141a
    public final boolean c(AbstractFutureC0676h abstractFutureC0676h, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f6249i;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractFutureC0676h, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractFutureC0676h) == obj);
        return false;
    }

    @Override // a.AbstractC0141a
    public final boolean d(AbstractFutureC0676h abstractFutureC0676h, C0675g c0675g, C0675g c0675g2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f6247g;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractFutureC0676h, c0675g, c0675g2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractFutureC0676h) == c0675g);
        return false;
    }
}
