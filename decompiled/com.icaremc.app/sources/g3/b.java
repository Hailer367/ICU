package g3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3777a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3778b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public b(r rVar) {
        this._prev$volatile = rVar;
    }

    public final void a() {
        f3778b.set(this, null);
    }

    public final b b() {
        Object obj = f3777a.get(this);
        if (obj == a.f3770a) {
            return null;
        }
        return (b) obj;
    }

    public abstract boolean c();

    public final void d() {
        b bVar;
        b b4;
        if (b() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3778b;
            b bVar2 = (b) atomicReferenceFieldUpdater.get(this);
            while (bVar2 != null && bVar2.c()) {
                bVar2 = (b) atomicReferenceFieldUpdater.get(bVar2);
            }
            b b5 = b();
            T2.h.b(b5);
            while (b5.c() && (b4 = b5.b()) != null) {
                b5 = b4;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(b5);
                if (((b) obj) == null) {
                    bVar = null;
                } else {
                    bVar = bVar2;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(b5, obj, bVar)) {
                    if (atomicReferenceFieldUpdater.get(b5) != obj) {
                        break;
                    }
                }
            }
            if (bVar2 != null) {
                f3777a.set(bVar2, b5);
            }
            if (!b5.c() || b5.b() == null) {
                if (bVar2 == null || !bVar2.c()) {
                    return;
                }
            }
        }
    }
}
