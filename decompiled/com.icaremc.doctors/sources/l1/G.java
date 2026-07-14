package l1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class G extends H implements InterfaceC0247z {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2952i = AtomicReferenceFieldUpdater.newUpdater(G.class, Object.class, "_queue$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2953j = AtomicReferenceFieldUpdater.newUpdater(G.class, Object.class, "_delayed$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2954k = AtomicIntegerFieldUpdater.newUpdater(G.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    @Override // l1.AbstractC0240s
    public final void e(T0.i iVar, Runnable runnable) {
        o(runnable);
    }

    @Override // l1.H
    public final long m() {
        Runnable runnable;
        long j2;
        if (!n()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2952i;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                runnable = null;
                if (obj == null) {
                    break;
                }
                if (obj instanceof q1.m) {
                    q1.m mVar = (q1.m) obj;
                    Object d2 = mVar.d();
                    if (d2 != q1.m.f3533g) {
                        runnable = (Runnable) d2;
                        break;
                    }
                    q1.m c2 = mVar.c();
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c2) && atomicReferenceFieldUpdater.get(this) == obj) {
                    }
                } else {
                    if (obj == AbstractC0244w.f3017b) {
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
            R0.h hVar = this.f2958g;
            if (hVar == null || hVar.isEmpty()) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = 0;
            }
            if (j2 != 0) {
                Object obj2 = f2952i.get(this);
                if (obj2 != null) {
                    if (obj2 instanceof q1.m) {
                        long j3 = q1.m.f3532f.get((q1.m) obj2);
                        if (((int) (1073741823 & j3)) != ((int) ((j3 & 1152921503533105152L) >> 30))) {
                            return 0L;
                        }
                    } else if (obj2 == AbstractC0244w.f3017b) {
                        return Long.MAX_VALUE;
                    }
                }
                return Long.MAX_VALUE;
            }
        }
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        r6 = j();
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = l1.G.f2953j
            java.lang.Object r0 = r0.get(r5)
            l1.F r0 = (l1.F) r0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = l1.G.f2952i
        La:
            java.lang.Object r1 = r0.get(r5)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = l1.G.f2954k
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
            boolean r2 = r1 instanceof q1.m
            r3 = 1
            if (r2 == 0) goto L4e
            r2 = r1
            q1.m r2 = (q1.m) r2
            int r4 = r2.a(r6)
            if (r4 == 0) goto L6e
            if (r4 == r3) goto L3c
            r1 = 2
            if (r4 == r1) goto L52
            goto La
        L3c:
            q1.m r2 = r2.c()
        L40:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L47
            goto La
        L47:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L40
            goto La
        L4e:
            F.h r2 = l1.AbstractC0244w.f3017b
            if (r1 != r2) goto L58
        L52:
            l1.x r0 = l1.RunnableC0245x.f3025l
            r0.o(r6)
            return
        L58:
            q1.m r2 = new q1.m
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
            java.lang.Thread r6 = r5.j()
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
        throw new UnsupportedOperationException("Method not decompiled: l1.G.o(java.lang.Runnable):void");
    }

    public final boolean p() {
        boolean z;
        R0.h hVar = this.f2958g;
        if (hVar != null) {
            z = hVar.isEmpty();
        } else {
            z = true;
        }
        if (z) {
            Object obj = f2952i.get(this);
            if (obj != null) {
                if (obj instanceof q1.m) {
                    long j2 = q1.m.f3532f.get((q1.m) obj);
                    if (((int) (1073741823 & j2)) == ((int) ((j2 & 1152921503533105152L) >> 30))) {
                        return true;
                    }
                    return false;
                }
                if (obj == AbstractC0244w.f3017b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // l1.H
    public void shutdown() {
        f0.f2986a.set(null);
        f2954k.set(this, 1);
        F.h hVar = AbstractC0244w.f3017b;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2952i;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, hVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                        break;
                    }
                }
                break loop0;
            } else {
                if (obj instanceof q1.m) {
                    ((q1.m) obj).b();
                    break;
                }
                if (obj != hVar) {
                    q1.m mVar = new q1.m(8, true);
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
