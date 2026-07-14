package b3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class F extends G implements InterfaceC0248x {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3239l = AtomicReferenceFieldUpdater.newUpdater(F.class, Object.class, "_queue$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3240m = AtomicReferenceFieldUpdater.newUpdater(F.class, Object.class, "_delayed$volatile");

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3241n = AtomicIntegerFieldUpdater.newUpdater(F.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    @Override // b3.AbstractC0242q
    public final void d(K2.i iVar, Runnable runnable) {
        o(runnable);
    }

    @Override // b3.G
    public final long m() {
        Runnable runnable;
        long j4;
        if (!n()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3239l;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                runnable = null;
                if (obj == null) {
                    break;
                }
                if (obj instanceof g3.m) {
                    g3.m mVar = (g3.m) obj;
                    Object d4 = mVar.d();
                    if (d4 != g3.m.f3798g) {
                        runnable = (Runnable) d4;
                        break;
                    }
                    g3.m c4 = mVar.c();
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c4) && atomicReferenceFieldUpdater.get(this) == obj) {
                    }
                } else {
                    if (obj == AbstractC0245u.f3300b) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    runnable = (Runnable) obj;
                    break loop0;
                }
            }
            if (runnable != null) {
                runnable.run();
                return 0L;
            }
            I2.c cVar = this.f3244j;
            if (cVar == null || cVar.isEmpty()) {
                j4 = Long.MAX_VALUE;
            } else {
                j4 = 0;
            }
            if (j4 != 0) {
                Object obj2 = f3239l.get(this);
                if (obj2 != null) {
                    if (obj2 instanceof g3.m) {
                        long j5 = g3.m.f3797f.get((g3.m) obj2);
                        if (((int) (1073741823 & j5)) != ((int) ((j5 & 1152921503533105152L) >> 30))) {
                            return 0L;
                        }
                    } else if (obj2 == AbstractC0245u.f3300b) {
                        return Long.MAX_VALUE;
                    }
                }
                return Long.MAX_VALUE;
            }
        }
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        r6 = i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        if (java.lang.Thread.currentThread() == r6) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        java.util.concurrent.locks.LockSupport.unpark(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(java.lang.Runnable r6) {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = b3.F.f3240m
            java.lang.Object r0 = r0.get(r5)
            b3.E r0 = (b3.E) r0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = b3.F.f3239l
        La:
            java.lang.Object r1 = r0.get(r5)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = b3.F.f3241n
            int r2 = r2.get(r5)
            if (r2 == 0) goto L17
            goto L52
        L17:
            if (r1 != 0) goto L28
        L19:
            r1 = 0
            boolean r1 = r0.compareAndSet(r5, r1, r6)
            if (r1 == 0) goto L21
            goto L6e
        L21:
            java.lang.Object r1 = r0.get(r5)
            if (r1 == 0) goto L19
            goto La
        L28:
            boolean r2 = r1 instanceof g3.m
            r3 = 1
            if (r2 == 0) goto L4e
            r2 = r1
            g3.m r2 = (g3.m) r2
            int r4 = r2.a(r6)
            if (r4 == 0) goto L6e
            if (r4 == r3) goto L3c
            r1 = 2
            if (r4 == r1) goto L52
            goto La
        L3c:
            g3.m r2 = r2.c()
        L40:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L47
            goto La
        L47:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L40
            goto La
        L4e:
            R1.c r2 = b3.AbstractC0245u.f3300b
            if (r1 != r2) goto L58
        L52:
            b3.v r0 = b3.RunnableC0246v.f3308o
            r0.o(r6)
            return
        L58:
            g3.m r2 = new g3.m
            r4 = 8
            r2.<init>(r4, r3)
            r3 = r1
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.a(r3)
            r2.a(r6)
        L68:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L7c
        L6e:
            java.lang.Thread r6 = r5.i()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            if (r0 == r6) goto L7b
            java.util.concurrent.locks.LockSupport.unpark(r6)
        L7b:
            return
        L7c:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L68
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.F.o(java.lang.Runnable):void");
    }

    public final boolean p() {
        boolean z;
        I2.c cVar = this.f3244j;
        if (cVar != null) {
            z = cVar.isEmpty();
        } else {
            z = true;
        }
        if (z) {
            Object obj = f3239l.get(this);
            if (obj != null) {
                if (obj instanceof g3.m) {
                    long j4 = g3.m.f3797f.get((g3.m) obj);
                    if (((int) (1073741823 & j4)) == ((int) ((j4 & 1152921503533105152L) >> 30))) {
                        return true;
                    }
                    return false;
                }
                if (obj == AbstractC0245u.f3300b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // b3.G
    public void shutdown() {
        e0.f3270a.set(null);
        f3241n.set(this, 1);
        R1.c cVar = AbstractC0245u.f3300b;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3239l;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, cVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                        break;
                    }
                }
                break loop0;
            } else {
                if (obj instanceof g3.m) {
                    ((g3.m) obj).b();
                    break;
                }
                if (obj != cVar) {
                    g3.m mVar = new g3.m(8, true);
                    mVar.a((Runnable) obj);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                break;
            }
        }
        do {
        } while (m() <= 0);
        System.nanoTime();
    }
}
