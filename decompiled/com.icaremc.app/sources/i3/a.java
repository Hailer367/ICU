package i3;

import T2.p;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4149n = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");

    /* renamed from: f, reason: collision with root package name */
    public final m f4150f;

    /* renamed from: g, reason: collision with root package name */
    public final p f4151g;

    /* renamed from: h, reason: collision with root package name */
    public b f4152h;

    /* renamed from: i, reason: collision with root package name */
    public long f4153i;
    private volatile int indexInArray;

    /* renamed from: j, reason: collision with root package name */
    public long f4154j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4155l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f4156m;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    /* JADX WARN: Type inference failed for: r3v5, types: [T2.p, java.lang.Object] */
    public a(c cVar, int i4) {
        this.f4156m = cVar;
        setDaemon(true);
        setContextClassLoader(c.class.getClassLoader());
        this.f4150f = new m();
        this.f4151g = new Object();
        this.f4152h = b.f4160i;
        this.nextParkedWorker = c.f4165p;
        int nanoTime = (int) System.nanoTime();
        this.k = nanoTime == 0 ? 42 : nanoTime;
        f(i4);
    }

    public final i a(boolean z) {
        i e4;
        i e5;
        long j4;
        b bVar = this.f4152h;
        c cVar = this.f4156m;
        i iVar = null;
        boolean z3 = true;
        m mVar = this.f4150f;
        b bVar2 = b.f4157f;
        if (bVar != bVar2) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c.f4163n;
            do {
                j4 = atomicLongFieldUpdater.get(cVar);
                if (((int) ((9223367638808264704L & j4) >> 42)) == 0) {
                    mVar.getClass();
                    loop1: while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m.f4187b;
                        i iVar2 = (i) atomicReferenceFieldUpdater.get(mVar);
                        if (iVar2 == null || !iVar2.f4178g) {
                            break;
                        }
                        while (!atomicReferenceFieldUpdater.compareAndSet(mVar, iVar2, null)) {
                            if (atomicReferenceFieldUpdater.get(mVar) != iVar2) {
                                break;
                            }
                        }
                        iVar = iVar2;
                    }
                    int i4 = m.f4189d.get(mVar);
                    int i5 = m.f4188c.get(mVar);
                    while (true) {
                        if (i4 == i5 || m.f4190e.get(mVar) == 0) {
                            break;
                        }
                        i5--;
                        i b4 = mVar.b(i5, true);
                        if (b4 != null) {
                            iVar = b4;
                            break;
                        }
                    }
                    if (iVar == null) {
                        i iVar3 = (i) cVar.k.d();
                        if (iVar3 == null) {
                            return i(1);
                        }
                        return iVar3;
                    }
                    return iVar;
                }
            } while (!c.f4163n.compareAndSet(cVar, j4, j4 - 4398046511104L));
            this.f4152h = bVar2;
        }
        if (z) {
            if (d(cVar.f4166f * 2) != 0) {
                z3 = false;
            }
            if (z3 && (e5 = e()) != null) {
                return e5;
            }
            mVar.getClass();
            i iVar4 = (i) m.f4187b.getAndSet(mVar, null);
            if (iVar4 == null) {
                iVar4 = mVar.a();
            }
            if (iVar4 != null) {
                return iVar4;
            }
            if (!z3 && (e4 = e()) != null) {
                return e4;
            }
        } else {
            i e6 = e();
            if (e6 != null) {
                return e6;
            }
        }
        return i(3);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i4) {
        int i5 = this.k;
        int i6 = i5 ^ (i5 << 13);
        int i7 = i6 ^ (i6 >> 17);
        int i8 = i7 ^ (i7 << 5);
        this.k = i8;
        int i9 = i4 - 1;
        if ((i9 & i4) == 0) {
            return i8 & i9;
        }
        return (i8 & Integer.MAX_VALUE) % i4;
    }

    public final i e() {
        int d4 = d(2);
        c cVar = this.f4156m;
        if (d4 == 0) {
            i iVar = (i) cVar.f4170j.d();
            if (iVar != null) {
                return iVar;
            }
            return (i) cVar.k.d();
        }
        i iVar2 = (i) cVar.k.d();
        if (iVar2 != null) {
            return iVar2;
        }
        return (i) cVar.f4170j.d();
    }

    public final void f(int i4) {
        String valueOf;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4156m.f4169i);
        sb.append("-worker-");
        if (i4 == 0) {
            valueOf = "TERMINATED";
        } else {
            valueOf = String.valueOf(i4);
        }
        sb.append(valueOf);
        setName(sb.toString());
        this.indexInArray = i4;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(b bVar) {
        boolean z;
        b bVar2 = this.f4152h;
        if (bVar2 == b.f4157f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            c.f4163n.addAndGet(this.f4156m, 4398046511104L);
        }
        if (bVar2 != bVar) {
            this.f4152h = bVar;
        }
        return z;
    }

    public final i i(int i4) {
        boolean z;
        long j4;
        i iVar;
        long j5;
        long j6;
        i iVar2;
        int i5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.f4163n;
        c cVar = this.f4156m;
        int i6 = (int) (atomicLongFieldUpdater.get(cVar) & 2097151);
        i iVar3 = null;
        if (i6 < 2) {
            return null;
        }
        int d4 = d(i6);
        int i7 = 0;
        long j7 = Long.MAX_VALUE;
        while (i7 < i6) {
            d4++;
            if (d4 > i6) {
                d4 = 1;
            }
            a aVar = (a) cVar.f4171l.b(d4);
            if (aVar != null && aVar != this) {
                m mVar = aVar.f4150f;
                if (i4 == 3) {
                    iVar = mVar.a();
                    j4 = 0;
                } else {
                    mVar.getClass();
                    int i8 = m.f4189d.get(mVar);
                    int i9 = m.f4188c.get(mVar);
                    if (i4 == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    while (true) {
                        if (i8 != i9) {
                            j4 = 0;
                            if (!z || m.f4190e.get(mVar) != 0) {
                                int i10 = i8 + 1;
                                iVar = mVar.b(i8, z);
                                if (iVar != null) {
                                    break;
                                }
                                i8 = i10;
                            } else {
                                break;
                            }
                        } else {
                            j4 = 0;
                            break;
                        }
                    }
                    iVar = iVar3;
                }
                p pVar = this.f4151g;
                if (iVar != null) {
                    pVar.f1645f = iVar;
                    iVar2 = iVar3;
                    j6 = -1;
                    j5 = -1;
                } else {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m.f4187b;
                        i iVar4 = (i) atomicReferenceFieldUpdater.get(mVar);
                        if (iVar4 == null) {
                            j5 = -1;
                            break;
                        }
                        j5 = -1;
                        if (iVar4.f4178g) {
                            i5 = 1;
                        } else {
                            i5 = 2;
                        }
                        if ((i5 & i4) == 0) {
                            break;
                        }
                        k.f4185f.getClass();
                        m mVar2 = mVar;
                        long nanoTime = System.nanoTime() - iVar4.f4177f;
                        long j8 = k.f4181b;
                        if (nanoTime < j8) {
                            j6 = j8 - nanoTime;
                            iVar2 = null;
                            break;
                        }
                        do {
                            iVar2 = null;
                            if (atomicReferenceFieldUpdater.compareAndSet(mVar2, iVar4, null)) {
                                pVar.f1645f = iVar4;
                                j6 = -1;
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(mVar2) == iVar4);
                        mVar = mVar2;
                        iVar3 = null;
                    }
                    j6 = -2;
                    iVar2 = iVar3;
                }
                if (j6 == j5) {
                    i iVar5 = (i) pVar.f1645f;
                    pVar.f1645f = iVar2;
                    return iVar5;
                }
                if (j6 > j4) {
                    j7 = Math.min(j7, j6);
                }
            }
            i7++;
            iVar3 = null;
        }
        if (j7 == Long.MAX_VALUE) {
            j7 = 0;
        }
        this.f4154j = j7;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.run():void");
    }
}
