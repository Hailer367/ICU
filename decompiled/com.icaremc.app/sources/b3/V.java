package b3;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class V implements K {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3258b = AtomicIntegerFieldUpdater.newUpdater(V.class, "_isCompleting$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3259c = AtomicReferenceFieldUpdater.newUpdater(V.class, Object.class, "_rootCause$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3260d = AtomicReferenceFieldUpdater.newUpdater(V.class, Object.class, "_exceptionsHolder$volatile");
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile = 0;
    private volatile /* synthetic */ Object _rootCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final X f3261a;

    public V(X x3, Throwable th) {
        this.f3261a = x3;
        this._rootCause$volatile = th;
    }

    @Override // b3.K
    public final boolean a() {
        if (d() == null) {
            return true;
        }
        return false;
    }

    public final void b(Throwable th) {
        Throwable d4 = d();
        if (d4 == null) {
            f3259c.set(this, th);
            return;
        }
        if (th != d4) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3260d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, th);
                return;
            }
            if (obj instanceof Throwable) {
                if (th == obj) {
                    return;
                }
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(obj);
                arrayList.add(th);
                atomicReferenceFieldUpdater.set(this, arrayList);
                return;
            }
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
    }

    @Override // b3.K
    public final X c() {
        return this.f3261a;
    }

    public final Throwable d() {
        return (Throwable) f3259c.get(this);
    }

    public final boolean e() {
        if (d() != null) {
            return true;
        }
        return false;
    }

    public final ArrayList f(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3260d;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else if (obj instanceof ArrayList) {
            arrayList = (ArrayList) obj;
        } else {
            throw new IllegalStateException(("State is " + obj).toString());
        }
        Throwable d4 = d();
        if (d4 != null) {
            arrayList.add(0, d4);
        }
        if (th != null && !th.equals(d4)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, AbstractC0245u.f3305g);
        return arrayList;
    }

    public final String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("Finishing[cancelling=");
        sb.append(e());
        sb.append(", completing=");
        if (f3258b.get(this) != 0) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append(", rootCause=");
        sb.append(d());
        sb.append(", exceptions=");
        sb.append(f3260d.get(this));
        sb.append(", list=");
        sb.append(this.f3261a);
        sb.append(']');
        return sb.toString();
    }
}
