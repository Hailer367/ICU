package g3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3796e = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3797f = AtomicLongFieldUpdater.newUpdater(m.class, "_state$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final R1.c f3798g = new R1.c(21, "REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f3799a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3800b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3801c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f3802d;

    public m(int i4, boolean z) {
        this.f3799a = i4;
        this.f3800b = z;
        int i5 = i4 - 1;
        this.f3801c = i5;
        this.f3802d = new AtomicReferenceArray(i4);
        if (i5 <= 1073741823) {
            if ((i4 & i5) == 0) {
                return;
            } else {
                throw new IllegalStateException("Check failed.");
            }
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f3797f;
            long j4 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j4) != 0) {
                if ((2305843009213693952L & j4) != 0) {
                    return 2;
                }
                return 1;
            }
            int i4 = (int) (1073741823 & j4);
            int i5 = (int) ((1152921503533105152L & j4) >> 30);
            int i6 = this.f3801c;
            if (((i5 + 2) & i6) != (i4 & i6)) {
                boolean z = this.f3800b;
                AtomicReferenceArray atomicReferenceArray = this.f3802d;
                if (!z && atomicReferenceArray.get(i5 & i6) != null) {
                    int i7 = this.f3799a;
                    if (i7 < 1024 || ((i5 - i4) & 1073741823) > (i7 >> 1)) {
                        return 1;
                    }
                } else {
                    if (f3797f.compareAndSet(this, j4, ((-1152921503533105153L) & j4) | (((i5 + 1) & 1073741823) << 30))) {
                        atomicReferenceArray.set(i5 & i6, obj);
                        m mVar = this;
                        while ((atomicLongFieldUpdater.get(mVar) & 1152921504606846976L) != 0) {
                            mVar = mVar.c();
                            AtomicReferenceArray atomicReferenceArray2 = mVar.f3802d;
                            int i8 = mVar.f3801c & i5;
                            Object obj2 = atomicReferenceArray2.get(i8);
                            if ((obj2 instanceof l) && ((l) obj2).f3795a == i5) {
                                atomicReferenceArray2.set(i8, obj);
                            } else {
                                mVar = null;
                            }
                            if (mVar == null) {
                                return 0;
                            }
                        }
                        return 0;
                    }
                }
            } else {
                return 1;
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j4;
        do {
            atomicLongFieldUpdater = f3797f;
            j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j4) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, 2305843009213693952L | j4));
        return true;
    }

    public final m c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j4;
        m mVar;
        while (true) {
            atomicLongFieldUpdater = f3797f;
            j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 1152921504606846976L) != 0) {
                mVar = this;
                break;
            }
            long j5 = 1152921504606846976L | j4;
            mVar = this;
            if (atomicLongFieldUpdater.compareAndSet(mVar, j4, j5)) {
                j4 = j5;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3796e;
            m mVar2 = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar2 != null) {
                return mVar2;
            }
            m mVar3 = new m(mVar.f3799a * 2, mVar.f3800b);
            int i4 = (int) (1073741823 & j4);
            int i5 = (int) ((1152921503533105152L & j4) >> 30);
            while (true) {
                int i6 = mVar.f3801c;
                int i7 = i4 & i6;
                if (i7 == (i6 & i5)) {
                    break;
                }
                Object obj = mVar.f3802d.get(i7);
                if (obj == null) {
                    obj = new l(i4);
                }
                mVar3.f3802d.set(mVar3.f3801c & i4, obj);
                i4++;
            }
            atomicLongFieldUpdater.set(mVar3, (-1152921504606846977L) & j4);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, mVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object d() {
        m mVar = this;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f3797f;
            long j4 = atomicLongFieldUpdater.get(mVar);
            if ((j4 & 1152921504606846976L) != 0) {
                return f3798g;
            }
            int i4 = (int) (j4 & 1073741823);
            int i5 = mVar.f3801c;
            int i6 = i4 & i5;
            if ((((int) ((1152921503533105152L & j4) >> 30)) & i5) == i6) {
                break;
            }
            AtomicReferenceArray atomicReferenceArray = mVar.f3802d;
            Object obj = atomicReferenceArray.get(i6);
            boolean z = mVar.f3800b;
            if (obj == null) {
                if (z) {
                    break;
                }
            } else {
                if (obj instanceof l) {
                    break;
                }
                long j5 = (i4 + 1) & 1073741823;
                if (f3797f.compareAndSet(mVar, j4, (j4 & (-1073741824)) | j5)) {
                    atomicReferenceArray.set(i6, null);
                    return obj;
                }
                mVar = this;
                if (z) {
                    while (true) {
                        long j6 = atomicLongFieldUpdater.get(mVar);
                        int i7 = (int) (j6 & 1073741823);
                        if ((j6 & 1152921504606846976L) != 0) {
                            mVar = mVar.c();
                        } else {
                            m mVar2 = mVar;
                            if (f3797f.compareAndSet(mVar2, j6, (j6 & (-1073741824)) | j5)) {
                                mVar2.f3802d.set(i7 & mVar2.f3801c, null);
                                mVar = null;
                            } else {
                                mVar = mVar2;
                            }
                        }
                        if (mVar == null) {
                            return obj;
                        }
                    }
                }
            }
        }
        return null;
    }
}
