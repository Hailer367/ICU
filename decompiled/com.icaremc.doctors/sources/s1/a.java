package s1;

import com.google.android.gms.common.api.Api;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.q;

/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3589k = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final m f3590c;

    /* renamed from: d, reason: collision with root package name */
    public final q f3591d;

    /* renamed from: e, reason: collision with root package name */
    public b f3592e;

    /* renamed from: f, reason: collision with root package name */
    public long f3593f;

    /* renamed from: g, reason: collision with root package name */
    public long f3594g;

    /* renamed from: h, reason: collision with root package name */
    public int f3595h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3596i;
    private volatile int indexInArray;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ c f3597j;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    /* JADX WARN: Type inference failed for: r3v5, types: [kotlin.jvm.internal.q, java.lang.Object] */
    public a(c cVar, int i2) {
        this.f3597j = cVar;
        setDaemon(true);
        setContextClassLoader(c.class.getClassLoader());
        this.f3590c = new m();
        this.f3591d = new Object();
        this.f3592e = b.f3601f;
        this.nextParkedWorker = c.f3607m;
        int nanoTime = (int) System.nanoTime();
        this.f3595h = nanoTime == 0 ? 42 : nanoTime;
        f(i2);
    }

    public final i a(boolean z) {
        i e2;
        i e3;
        long j2;
        b bVar = this.f3592e;
        b bVar2 = b.f3598c;
        c cVar = this.f3597j;
        i iVar = null;
        boolean z2 = true;
        m mVar = this.f3590c;
        if (bVar != bVar2) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c.f3605k;
            do {
                j2 = atomicLongFieldUpdater.get(cVar);
                if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                    mVar.getClass();
                    loop1: while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m.f3630b;
                        i iVar2 = (i) atomicReferenceFieldUpdater.get(mVar);
                        if (iVar2 == null || !iVar2.f3621d) {
                            break;
                        }
                        while (!atomicReferenceFieldUpdater.compareAndSet(mVar, iVar2, null)) {
                            if (atomicReferenceFieldUpdater.get(mVar) != iVar2) {
                                break;
                            }
                        }
                        iVar = iVar2;
                    }
                    int i2 = m.f3632d.get(mVar);
                    int i3 = m.f3631c.get(mVar);
                    while (true) {
                        if (i2 == i3 || m.f3633e.get(mVar) == 0) {
                            break;
                        }
                        i3--;
                        i b2 = mVar.b(i3, true);
                        if (b2 != null) {
                            iVar = b2;
                            break;
                        }
                    }
                    if (iVar == null) {
                        i iVar3 = (i) cVar.f3613h.d();
                        if (iVar3 == null) {
                            return i(1);
                        }
                        return iVar3;
                    }
                    return iVar;
                }
            } while (!c.f3605k.compareAndSet(cVar, j2, j2 - 4398046511104L));
            this.f3592e = b.f3598c;
        }
        if (z) {
            if (d(cVar.f3608c * 2) != 0) {
                z2 = false;
            }
            if (z2 && (e3 = e()) != null) {
                return e3;
            }
            mVar.getClass();
            i iVar4 = (i) m.f3630b.getAndSet(mVar, null);
            if (iVar4 == null) {
                iVar4 = mVar.a();
            }
            if (iVar4 != null) {
                return iVar4;
            }
            if (!z2 && (e2 = e()) != null) {
                return e2;
            }
        } else {
            i e4 = e();
            if (e4 != null) {
                return e4;
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

    public final int d(int i2) {
        int i3 = this.f3595h;
        int i4 = i3 ^ (i3 << 13);
        int i5 = i4 ^ (i4 >> 17);
        int i6 = i5 ^ (i5 << 5);
        this.f3595h = i6;
        int i7 = i2 - 1;
        if ((i7 & i2) == 0) {
            return i6 & i7;
        }
        return (i6 & Api.BaseClientBuilder.API_PRIORITY_OTHER) % i2;
    }

    public final i e() {
        int d2 = d(2);
        c cVar = this.f3597j;
        if (d2 == 0) {
            i iVar = (i) cVar.f3612g.d();
            if (iVar != null) {
                return iVar;
            }
            return (i) cVar.f3613h.d();
        }
        i iVar2 = (i) cVar.f3613h.d();
        if (iVar2 != null) {
            return iVar2;
        }
        return (i) cVar.f3612g.d();
    }

    public final void f(int i2) {
        String valueOf;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3597j.f3611f);
        sb.append("-worker-");
        if (i2 == 0) {
            valueOf = "TERMINATED";
        } else {
            valueOf = String.valueOf(i2);
        }
        sb.append(valueOf);
        setName(sb.toString());
        this.indexInArray = i2;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(b bVar) {
        boolean z;
        b bVar2 = this.f3592e;
        if (bVar2 == b.f3598c) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            c.f3605k.addAndGet(this.f3597j, 4398046511104L);
        }
        if (bVar2 != bVar) {
            this.f3592e = bVar;
        }
        return z;
    }

    public final i i(int i2) {
        boolean z;
        long j2;
        i iVar;
        long j3;
        long j4;
        i iVar2;
        int i3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.f3605k;
        c cVar = this.f3597j;
        int i4 = (int) (atomicLongFieldUpdater.get(cVar) & 2097151);
        i iVar3 = null;
        if (i4 < 2) {
            return null;
        }
        int d2 = d(i4);
        int i5 = 0;
        long j5 = Long.MAX_VALUE;
        while (i5 < i4) {
            d2++;
            if (d2 > i4) {
                d2 = 1;
            }
            a aVar = (a) cVar.f3614i.b(d2);
            if (aVar != null && aVar != this) {
                m mVar = aVar.f3590c;
                if (i2 == 3) {
                    iVar = mVar.a();
                    j2 = 0;
                } else {
                    mVar.getClass();
                    int i6 = m.f3632d.get(mVar);
                    int i7 = m.f3631c.get(mVar);
                    if (i2 == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    while (true) {
                        if (i6 != i7) {
                            j2 = 0;
                            if (!z || m.f3633e.get(mVar) != 0) {
                                int i8 = i6 + 1;
                                iVar = mVar.b(i6, z);
                                if (iVar != null) {
                                    break;
                                }
                                i6 = i8;
                            } else {
                                break;
                            }
                        } else {
                            j2 = 0;
                            break;
                        }
                    }
                    iVar = iVar3;
                }
                q qVar = this.f3591d;
                if (iVar != null) {
                    qVar.f2789c = iVar;
                    iVar2 = iVar3;
                    j4 = -1;
                    j3 = -1;
                } else {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m.f3630b;
                        i iVar4 = (i) atomicReferenceFieldUpdater.get(mVar);
                        if (iVar4 == null) {
                            j3 = -1;
                            break;
                        }
                        j3 = -1;
                        if (iVar4.f3621d) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        if ((i3 & i2) == 0) {
                            break;
                        }
                        k.f3628f.getClass();
                        m mVar2 = mVar;
                        long nanoTime = System.nanoTime() - iVar4.f3620c;
                        long j6 = k.f3624b;
                        if (nanoTime < j6) {
                            j4 = j6 - nanoTime;
                            iVar2 = null;
                            break;
                        }
                        do {
                            iVar2 = null;
                            if (atomicReferenceFieldUpdater.compareAndSet(mVar2, iVar4, null)) {
                                qVar.f2789c = iVar4;
                                j4 = -1;
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(mVar2) == iVar4);
                        mVar = mVar2;
                        iVar3 = null;
                    }
                    j4 = -2;
                    iVar2 = iVar3;
                }
                if (j4 == j3) {
                    i iVar5 = (i) qVar.f2789c;
                    qVar.f2789c = iVar2;
                    return iVar5;
                }
                if (j4 > j2) {
                    j5 = Math.min(j5, j4);
                }
            }
            i5++;
            iVar3 = null;
        }
        if (j5 == Long.MAX_VALUE) {
            j5 = 0;
        }
        this.f3594g = j5;
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
        throw new UnsupportedOperationException("Method not decompiled: s1.a.run():void");
    }
}
