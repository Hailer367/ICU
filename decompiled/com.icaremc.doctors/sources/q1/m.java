package q1;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3531e = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3532f = AtomicLongFieldUpdater.newUpdater(m.class, "_state$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final F.h f3533g = new F.h(17, "REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f3534a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3535b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3536c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f3537d;

    public m(int i2, boolean z) {
        this.f3534a = i2;
        this.f3535b = z;
        int i3 = i2 - 1;
        this.f3536c = i3;
        this.f3537d = new AtomicReferenceArray(i2);
        if (i3 <= 1073741823) {
            if ((i2 & i3) == 0) {
                return;
            } else {
                throw new IllegalStateException("Check failed.");
            }
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f3532f;
            long j2 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j2) != 0) {
                if ((2305843009213693952L & j2) != 0) {
                    return 2;
                }
                return 1;
            }
            int i2 = (int) (1073741823 & j2);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            int i4 = this.f3536c;
            if (((i3 + 2) & i4) != (i2 & i4)) {
                boolean z = this.f3535b;
                AtomicReferenceArray atomicReferenceArray = this.f3537d;
                if (!z && atomicReferenceArray.get(i3 & i4) != null) {
                    int i5 = this.f3534a;
                    if (i5 < 1024 || ((i3 - i2) & 1073741823) > (i5 >> 1)) {
                        return 1;
                    }
                } else {
                    if (f3532f.compareAndSet(this, j2, ((-1152921503533105153L) & j2) | (((i3 + 1) & 1073741823) << 30))) {
                        atomicReferenceArray.set(i3 & i4, obj);
                        m mVar = this;
                        while ((atomicLongFieldUpdater.get(mVar) & 1152921504606846976L) != 0) {
                            mVar = mVar.c();
                            AtomicReferenceArray atomicReferenceArray2 = mVar.f3537d;
                            int i6 = mVar.f3536c & i3;
                            Object obj2 = atomicReferenceArray2.get(i6);
                            if ((obj2 instanceof l) && ((l) obj2).f3530a == i3) {
                                atomicReferenceArray2.set(i6, obj);
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
        long j2;
        do {
            atomicLongFieldUpdater = f3532f;
            j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j2) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, 2305843009213693952L | j2));
        return true;
    }

    public final m c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        m mVar;
        while (true) {
            atomicLongFieldUpdater = f3532f;
            j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 1152921504606846976L) != 0) {
                mVar = this;
                break;
            }
            long j3 = 1152921504606846976L | j2;
            mVar = this;
            if (atomicLongFieldUpdater.compareAndSet(mVar, j2, j3)) {
                j2 = j3;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3531e;
            m mVar2 = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar2 != null) {
                return mVar2;
            }
            m mVar3 = new m(mVar.f3534a * 2, mVar.f3535b);
            int i2 = (int) (1073741823 & j2);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            while (true) {
                int i4 = mVar.f3536c;
                int i5 = i2 & i4;
                if (i5 == (i4 & i3)) {
                    break;
                }
                Object obj = mVar.f3537d.get(i5);
                if (obj == null) {
                    obj = new l(i2);
                }
                mVar3.f3537d.set(mVar3.f3536c & i2, obj);
                i2++;
            }
            atomicLongFieldUpdater.set(mVar3, (-1152921504606846977L) & j2);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, mVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object d() {
        m mVar = this;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f3532f;
            long j2 = atomicLongFieldUpdater.get(mVar);
            if ((j2 & 1152921504606846976L) != 0) {
                return f3533g;
            }
            int i2 = (int) (j2 & 1073741823);
            int i3 = mVar.f3536c;
            int i4 = i2 & i3;
            if ((((int) ((1152921503533105152L & j2) >> 30)) & i3) == i4) {
                break;
            }
            AtomicReferenceArray atomicReferenceArray = mVar.f3537d;
            Object obj = atomicReferenceArray.get(i4);
            boolean z = mVar.f3535b;
            if (obj == null) {
                if (z) {
                    break;
                }
            } else {
                if (obj instanceof l) {
                    break;
                }
                long j3 = (i2 + 1) & 1073741823;
                if (f3532f.compareAndSet(mVar, j2, (j2 & (-1073741824)) | j3)) {
                    atomicReferenceArray.set(i4, null);
                    return obj;
                }
                mVar = this;
                if (z) {
                    while (true) {
                        long j4 = atomicLongFieldUpdater.get(mVar);
                        int i5 = (int) (j4 & 1073741823);
                        if ((j4 & 1152921504606846976L) != 0) {
                            mVar = mVar.c();
                        } else {
                            m mVar2 = mVar;
                            if (f3532f.compareAndSet(mVar2, j4, (j4 & (-1073741824)) | j3)) {
                                mVar2.f3537d.set(i5 & mVar2.f3536c, null);
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
