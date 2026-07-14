package s1;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import l1.AbstractC0244w;
import q1.p;

/* loaded from: classes.dex */
public final class c implements Executor, Closeable {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3604j = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3605k = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3606l = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final F.h f3607m = new F.h(17, "NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: c, reason: collision with root package name */
    public final int f3608c;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final int f3609d;

    /* renamed from: e, reason: collision with root package name */
    public final long f3610e;

    /* renamed from: f, reason: collision with root package name */
    public final String f3611f;

    /* renamed from: g, reason: collision with root package name */
    public final f f3612g;

    /* renamed from: h, reason: collision with root package name */
    public final f f3613h;

    /* renamed from: i, reason: collision with root package name */
    public final p f3614i;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX WARN: Type inference failed for: r4v10, types: [s1.f, q1.k] */
    /* JADX WARN: Type inference failed for: r4v11, types: [s1.f, q1.k] */
    public c(int i2, int i3, long j2, String str) {
        this.f3608c = i2;
        this.f3609d = i3;
        this.f3610e = j2;
        this.f3611f = str;
        if (i2 >= 1) {
            if (i3 >= i2) {
                if (i3 <= 2097150) {
                    if (j2 > 0) {
                        this.f3612g = new q1.k();
                        this.f3613h = new q1.k();
                        this.f3614i = new p((i2 + 1) * 2);
                        this.controlState$volatile = i2 << 42;
                        this._isTerminated$volatile = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(O.a.d("Max pool size ", i3, " should be greater than or equals to core pool size ", i2).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
    }

    public final int a() {
        boolean z;
        synchronized (this.f3614i) {
            try {
                if (f3606l.get(this) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f3605k;
                long j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 & 2097151);
                int i3 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 >= this.f3608c) {
                    return 0;
                }
                if (i2 >= this.f3609d) {
                    return 0;
                }
                int i4 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i4 > 0 && this.f3614i.b(i4) == null) {
                    a aVar = new a(this, i4);
                    this.f3614i.c(i4, aVar);
                    if (i4 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                        int i5 = i3 + 1;
                        aVar.start();
                        return i5;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalArgumentException("Failed requirement.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, boolean z) {
        i jVar;
        long j2;
        a aVar;
        boolean a2;
        b bVar;
        k.f3628f.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof i) {
            jVar = (i) runnable;
            jVar.f3620c = nanoTime;
            jVar.f3621d = z;
        } else {
            jVar = new j(runnable, nanoTime, z);
        }
        boolean z2 = jVar.f3621d;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3605k;
        if (z2) {
            j2 = atomicLongFieldUpdater.addAndGet(this, 2097152L);
        } else {
            j2 = 0;
        }
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof a) {
            aVar = (a) currentThread;
        } else {
            aVar = null;
        }
        if (aVar == null || !kotlin.jvm.internal.h.a(aVar.f3597j, this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f3592e) != b.f3602g && (jVar.f3621d || bVar != b.f3599d)) {
            aVar.f3596i = true;
            m mVar = aVar.f3590c;
            mVar.getClass();
            jVar = (i) m.f3630b.getAndSet(mVar, jVar);
            if (jVar == null) {
                jVar = null;
            } else {
                AtomicReferenceArray atomicReferenceArray = mVar.f3634a;
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = m.f3631c;
                if (atomicIntegerFieldUpdater.get(mVar) - m.f3632d.get(mVar) != 127) {
                    if (jVar.f3621d) {
                        m.f3633e.incrementAndGet(mVar);
                    }
                    int i2 = atomicIntegerFieldUpdater.get(mVar) & 127;
                    while (atomicReferenceArray.get(i2) != null) {
                        Thread.yield();
                    }
                    atomicReferenceArray.lazySet(i2, jVar);
                    atomicIntegerFieldUpdater.incrementAndGet(mVar);
                    jVar = null;
                }
            }
        }
        if (jVar != null) {
            if (jVar.f3621d) {
                a2 = this.f3613h.a(jVar);
            } else {
                a2 = this.f3612g.a(jVar);
            }
            if (!a2) {
                throw new RejectedExecutionException(O.a.i(new StringBuilder(), this.f3611f, " was terminated"));
            }
        }
        if (z2) {
            if (!e() && !d(j2)) {
                e();
                return;
            }
            return;
        }
        if (e() || d(atomicLongFieldUpdater.get(this))) {
            return;
        }
        e();
    }

    public final void c(a aVar, int i2, int i3) {
        while (true) {
            long j2 = f3604j.get(this);
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i2) {
                if (i3 == 0) {
                    Object c2 = aVar.c();
                    while (true) {
                        if (c2 == f3607m) {
                            i4 = -1;
                            break;
                        }
                        if (c2 == null) {
                            i4 = 0;
                            break;
                        }
                        a aVar2 = (a) c2;
                        int b2 = aVar2.b();
                        if (b2 != 0) {
                            i4 = b2;
                            break;
                        }
                        c2 = aVar2.c();
                    }
                } else {
                    i4 = i3;
                }
            }
            if (i4 >= 0) {
                if (f3604j.compareAndSet(this, j2, i4 | j3)) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        if (r1 == null) goto L39;
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = s1.c.f3606l
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof s1.a
            r3 = 0
            if (r1 == 0) goto L17
            s1.a r0 = (s1.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            s1.c r1 = r0.f3597j
            boolean r1 = kotlin.jvm.internal.h.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            q1.p r1 = r8.f3614i
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = s1.c.f3605k     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            q1.p r5 = r8.f3614i
            java.lang.Object r5 = r5.b(r1)
            kotlin.jvm.internal.h.b(r5)
            s1.a r5 = (s1.a) r5
            if (r5 == r0) goto L73
        L43:
            java.lang.Thread$State r6 = r5.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L54
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L54:
            s1.m r5 = r5.f3590c
            s1.f r6 = r8.f3613h
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = s1.m.f3630b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            s1.i r7 = (s1.i) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            s1.i r7 = r5.a()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            r6.a(r7)
            goto L68
        L73:
            if (r1 == r4) goto L78
            int r1 = r1 + 1
            goto L36
        L78:
            s1.f r1 = r8.f3613h
            r1.b()
            s1.f r1 = r8.f3612g
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            s1.i r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            s1.f r1 = r8.f3612g
            java.lang.Object r1 = r1.d()
            s1.i r1 = (s1.i) r1
            if (r1 != 0) goto Lb2
            s1.f r1 = r8.f3613h
            java.lang.Object r1 = r1.d()
            s1.i r1 = (s1.i) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            s1.b r1 = s1.b.f3602g
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = s1.c.f3604j
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = s1.c.f3605k
            r0.set(r8, r1)
            return
        Lb2:
            r1.run()     // Catch: java.lang.Throwable -> Lb6
            goto L82
        Lb6:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L82
        Lc3:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.c.close():void");
    }

    public final boolean d(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.f3608c;
        if (i2 < i3) {
            int a2 = a();
            if (a2 == 1 && i3 > 1) {
                a();
            }
            if (a2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        F.h hVar;
        int i2;
        while (true) {
            long j2 = f3604j.get(this);
            a aVar = (a) this.f3614i.b((int) (2097151 & j2));
            if (aVar == null) {
                aVar = null;
            } else {
                long j3 = (2097152 + j2) & (-2097152);
                Object c2 = aVar.c();
                while (true) {
                    hVar = f3607m;
                    if (c2 == hVar) {
                        i2 = -1;
                        break;
                    }
                    if (c2 == null) {
                        i2 = 0;
                        break;
                    }
                    a aVar2 = (a) c2;
                    i2 = aVar2.b();
                    if (i2 != 0) {
                        break;
                    }
                    c2 = aVar2.c();
                }
                if (i2 >= 0) {
                    if (f3604j.compareAndSet(this, j2, i2 | j3)) {
                        aVar.g(hVar);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f3589k.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable, false);
    }

    public final String toString() {
        int i2;
        ArrayList arrayList = new ArrayList();
        p pVar = this.f3614i;
        int a2 = pVar.a();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 1; i8 < a2; i8++) {
            a aVar = (a) pVar.b(i8);
            if (aVar != null) {
                m mVar = aVar.f3590c;
                mVar.getClass();
                if (m.f3630b.get(mVar) != null) {
                    i2 = (m.f3631c.get(mVar) - m.f3632d.get(mVar)) + 1;
                } else {
                    i2 = m.f3631c.get(mVar) - m.f3632d.get(mVar);
                }
                int ordinal = aVar.f3592e.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal != 3) {
                                if (ordinal == 4) {
                                    i7++;
                                } else {
                                    throw new RuntimeException();
                                }
                            } else {
                                i6++;
                                if (i2 > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(i2);
                                    sb.append('d');
                                    arrayList.add(sb.toString());
                                }
                            }
                        } else {
                            i5++;
                        }
                    } else {
                        i4++;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(i2);
                        sb2.append('b');
                        arrayList.add(sb2.toString());
                    }
                } else {
                    i3++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i2);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                }
            }
        }
        long j2 = f3605k.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f3611f);
        sb4.append('@');
        sb4.append(AbstractC0244w.b(this));
        sb4.append("[Pool Size {core = ");
        int i9 = this.f3608c;
        sb4.append(i9);
        sb4.append(", max = ");
        sb4.append(this.f3609d);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i3);
        sb4.append(", blocking = ");
        sb4.append(i4);
        sb4.append(", parked = ");
        sb4.append(i5);
        sb4.append(", dormant = ");
        sb4.append(i6);
        sb4.append(", terminated = ");
        sb4.append(i7);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f3612g.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f3613h.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j2));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j2) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i9 - ((int) ((j2 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
