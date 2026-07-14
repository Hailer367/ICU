package i3;

import b3.AbstractC0245u;
import g3.p;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class c implements Executor, Closeable {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f4162m = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f4163n = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4164o = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");

    /* renamed from: p, reason: collision with root package name */
    public static final R1.c f4165p = new R1.c(21, "NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: f, reason: collision with root package name */
    public final int f4166f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4167g;

    /* renamed from: h, reason: collision with root package name */
    public final long f4168h;

    /* renamed from: i, reason: collision with root package name */
    public final String f4169i;

    /* renamed from: j, reason: collision with root package name */
    public final f f4170j;
    public final f k;

    /* renamed from: l, reason: collision with root package name */
    public final p f4171l;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX WARN: Type inference failed for: r4v10, types: [i3.f, g3.k] */
    /* JADX WARN: Type inference failed for: r4v11, types: [i3.f, g3.k] */
    public c(int i4, int i5, long j4, String str) {
        this.f4166f = i4;
        this.f4167g = i5;
        this.f4168h = j4;
        this.f4169i = str;
        if (i4 >= 1) {
            if (i5 >= i4) {
                if (i5 <= 2097150) {
                    if (j4 > 0) {
                        this.f4170j = new g3.k();
                        this.k = new g3.k();
                        this.f4171l = new p((i4 + 1) * 2);
                        this.controlState$volatile = i4 << 42;
                        this._isTerminated$volatile = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j4 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i5 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(A2.i.h("Max pool size ", " should be greater than or equals to core pool size ", i5, i4).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i4 + " should be at least 1").toString());
    }

    public final int a() {
        boolean z;
        synchronized (this.f4171l) {
            try {
                if (f4164o.get(this) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f4163n;
                long j4 = atomicLongFieldUpdater.get(this);
                int i4 = (int) (j4 & 2097151);
                int i5 = i4 - ((int) ((j4 & 4398044413952L) >> 21));
                if (i5 < 0) {
                    i5 = 0;
                }
                if (i5 >= this.f4166f) {
                    return 0;
                }
                if (i4 >= this.f4167g) {
                    return 0;
                }
                int i6 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i6 > 0 && this.f4171l.b(i6) == null) {
                    a aVar = new a(this, i6);
                    this.f4171l.c(i6, aVar);
                    if (i6 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                        int i7 = i5 + 1;
                        aVar.start();
                        return i7;
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
        long j4;
        a aVar;
        boolean a4;
        b bVar;
        k.f4185f.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof i) {
            jVar = (i) runnable;
            jVar.f4177f = nanoTime;
            jVar.f4178g = z;
        } else {
            jVar = new j(runnable, nanoTime, z);
        }
        boolean z3 = jVar.f4178g;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4163n;
        if (z3) {
            j4 = atomicLongFieldUpdater.addAndGet(this, 2097152L);
        } else {
            j4 = 0;
        }
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof a) {
            aVar = (a) currentThread;
        } else {
            aVar = null;
        }
        if (aVar == null || !T2.h.a(aVar.f4156m, this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f4152h) != b.f4161j && (jVar.f4178g || bVar != b.f4158g)) {
            aVar.f4155l = true;
            m mVar = aVar.f4150f;
            mVar.getClass();
            jVar = (i) m.f4187b.getAndSet(mVar, jVar);
            if (jVar == null) {
                jVar = null;
            } else {
                AtomicReferenceArray atomicReferenceArray = mVar.f4191a;
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = m.f4188c;
                if (atomicIntegerFieldUpdater.get(mVar) - m.f4189d.get(mVar) != 127) {
                    if (jVar.f4178g) {
                        m.f4190e.incrementAndGet(mVar);
                    }
                    int i4 = atomicIntegerFieldUpdater.get(mVar) & 127;
                    while (atomicReferenceArray.get(i4) != null) {
                        Thread.yield();
                    }
                    atomicReferenceArray.lazySet(i4, jVar);
                    atomicIntegerFieldUpdater.incrementAndGet(mVar);
                    jVar = null;
                }
            }
        }
        if (jVar != null) {
            if (jVar.f4178g) {
                a4 = this.k.a(jVar);
            } else {
                a4 = this.f4170j.a(jVar);
            }
            if (!a4) {
                throw new RejectedExecutionException(r2.k.c(new StringBuilder(), this.f4169i, " was terminated"));
            }
        }
        if (z3) {
            if (!e() && !d(j4)) {
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

    public final void c(a aVar, int i4, int i5) {
        while (true) {
            long j4 = f4162m.get(this);
            int i6 = (int) (2097151 & j4);
            long j5 = (2097152 + j4) & (-2097152);
            if (i6 == i4) {
                if (i5 == 0) {
                    Object c4 = aVar.c();
                    while (true) {
                        if (c4 == f4165p) {
                            i6 = -1;
                            break;
                        }
                        if (c4 == null) {
                            i6 = 0;
                            break;
                        }
                        a aVar2 = (a) c4;
                        int b4 = aVar2.b();
                        if (b4 != 0) {
                            i6 = b4;
                            break;
                        }
                        c4 = aVar2.c();
                    }
                } else {
                    i6 = i5;
                }
            }
            if (i6 >= 0) {
                if (f4162m.compareAndSet(this, j4, i6 | j5)) {
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
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = i3.c.f4164o
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof i3.a
            r3 = 0
            if (r1 == 0) goto L17
            i3.a r0 = (i3.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            i3.c r1 = r0.f4156m
            boolean r1 = T2.h.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            g3.p r1 = r8.f4171l
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = i3.c.f4163n     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            g3.p r5 = r8.f4171l
            java.lang.Object r5 = r5.b(r1)
            T2.h.b(r5)
            i3.a r5 = (i3.a) r5
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
            i3.m r5 = r5.f4150f
            i3.f r6 = r8.k
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = i3.m.f4187b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            i3.i r7 = (i3.i) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            i3.i r7 = r5.a()
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
            i3.f r1 = r8.k
            r1.b()
            i3.f r1 = r8.f4170j
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            i3.i r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            i3.f r1 = r8.f4170j
            java.lang.Object r1 = r1.d()
            i3.i r1 = (i3.i) r1
            if (r1 != 0) goto Lb2
            i3.f r1 = r8.k
            java.lang.Object r1 = r1.d()
            i3.i r1 = (i3.i) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            i3.b r1 = i3.b.f4161j
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = i3.c.f4162m
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = i3.c.f4163n
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
        throw new UnsupportedOperationException("Method not decompiled: i3.c.close():void");
    }

    public final boolean d(long j4) {
        int i4 = ((int) (2097151 & j4)) - ((int) ((j4 & 4398044413952L) >> 21));
        if (i4 < 0) {
            i4 = 0;
        }
        int i5 = this.f4166f;
        if (i4 < i5) {
            int a4 = a();
            if (a4 == 1 && i5 > 1) {
                a();
            }
            if (a4 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        R1.c cVar;
        int i4;
        while (true) {
            long j4 = f4162m.get(this);
            a aVar = (a) this.f4171l.b((int) (2097151 & j4));
            if (aVar == null) {
                aVar = null;
            } else {
                long j5 = (2097152 + j4) & (-2097152);
                Object c4 = aVar.c();
                while (true) {
                    cVar = f4165p;
                    if (c4 == cVar) {
                        i4 = -1;
                        break;
                    }
                    if (c4 == null) {
                        i4 = 0;
                        break;
                    }
                    a aVar2 = (a) c4;
                    i4 = aVar2.b();
                    if (i4 != 0) {
                        break;
                    }
                    c4 = aVar2.c();
                }
                if (i4 >= 0) {
                    if (f4162m.compareAndSet(this, j4, i4 | j5)) {
                        aVar.g(cVar);
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
            if (a.f4149n.compareAndSet(aVar, -1, 0)) {
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
        int i4;
        ArrayList arrayList = new ArrayList();
        p pVar = this.f4171l;
        int a4 = pVar.a();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 1; i10 < a4; i10++) {
            a aVar = (a) pVar.b(i10);
            if (aVar != null) {
                m mVar = aVar.f4150f;
                mVar.getClass();
                if (m.f4187b.get(mVar) != null) {
                    i4 = (m.f4188c.get(mVar) - m.f4189d.get(mVar)) + 1;
                } else {
                    i4 = m.f4188c.get(mVar) - m.f4189d.get(mVar);
                }
                int ordinal = aVar.f4152h.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal != 3) {
                                if (ordinal == 4) {
                                    i9++;
                                } else {
                                    throw new RuntimeException();
                                }
                            } else {
                                i8++;
                                if (i4 > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(i4);
                                    sb.append('d');
                                    arrayList.add(sb.toString());
                                }
                            }
                        } else {
                            i7++;
                        }
                    } else {
                        i6++;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(i4);
                        sb2.append('b');
                        arrayList.add(sb2.toString());
                    }
                } else {
                    i5++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i4);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                }
            }
        }
        long j4 = f4163n.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f4169i);
        sb4.append('@');
        sb4.append(AbstractC0245u.b(this));
        sb4.append("[Pool Size {core = ");
        int i11 = this.f4166f;
        sb4.append(i11);
        sb4.append(", max = ");
        sb4.append(this.f4167g);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i5);
        sb4.append(", blocking = ");
        sb4.append(i6);
        sb4.append(", parked = ");
        sb4.append(i7);
        sb4.append(", dormant = ");
        sb4.append(i8);
        sb4.append(", terminated = ");
        sb4.append(i9);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f4170j.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.k.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j4));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j4) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i11 - ((int) ((j4 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
