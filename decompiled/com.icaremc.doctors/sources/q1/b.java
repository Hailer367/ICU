package q1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3510a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3511b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public b(r rVar) {
        this._prev$volatile = rVar;
    }

    public final void a() {
        f3511b.set(this, null);
    }

    public final b b() {
        Object obj = f3510a.get(this);
        if (obj == a.f3503a) {
            return null;
        }
        return (b) obj;
    }

    public abstract boolean c();

    public final void d() {
        b bVar;
        b b2;
        if (b() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3511b;
            b bVar2 = (b) atomicReferenceFieldUpdater.get(this);
            while (bVar2 != null && bVar2.c()) {
                bVar2 = (b) atomicReferenceFieldUpdater.get(bVar2);
            }
            b b3 = b();
            kotlin.jvm.internal.h.b(b3);
            while (b3.c() && (b2 = b3.b()) != null) {
                b3 = b2;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(b3);
                if (((b) obj) == null) {
                    bVar = null;
                } else {
                    bVar = bVar2;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(b3, obj, bVar)) {
                    if (atomicReferenceFieldUpdater.get(b3) != obj) {
                        break;
                    }
                }
            }
            if (bVar2 != null) {
                f3510a.set(bVar2, b3);
            }
            if (!b3.c() || b3.b() == null) {
                if (bVar2 == null || !bVar2.c()) {
                    return;
                }
            }
        }
    }
}
