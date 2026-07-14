package l1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class W implements L {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2972b = AtomicIntegerFieldUpdater.newUpdater(W.class, "_isCompleting$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2973c = AtomicReferenceFieldUpdater.newUpdater(W.class, Object.class, "_rootCause$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2974d = AtomicReferenceFieldUpdater.newUpdater(W.class, Object.class, "_exceptionsHolder$volatile");
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile = 0;
    private volatile /* synthetic */ Object _rootCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final Y f2975a;

    public W(Y y, Throwable th) {
        this.f2975a = y;
        this._rootCause$volatile = th;
    }

    @Override // l1.L
    public final boolean a() {
        if (d() == null) {
            return true;
        }
        return false;
    }

    public final void b(Throwable th) {
        Throwable d2 = d();
        if (d2 == null) {
            f2973c.set(this, th);
            return;
        }
        if (th != d2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2974d;
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

    @Override // l1.L
    public final Y c() {
        return this.f2975a;
    }

    public final Throwable d() {
        return (Throwable) f2973c.get(this);
    }

    public final boolean e() {
        if (d() != null) {
            return true;
        }
        return false;
    }

    public final ArrayList f(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2974d;
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
        Throwable d2 = d();
        if (d2 != null) {
            arrayList.add(0, d2);
        }
        if (th != null && !th.equals(d2)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, AbstractC0244w.f3022g);
        return arrayList;
    }

    public final String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("Finishing[cancelling=");
        sb.append(e());
        sb.append(", completing=");
        if (f2972b.get(this) != 0) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append(", rootCause=");
        sb.append(d());
        sb.append(", exceptions=");
        sb.append(f2974d.get(this));
        sb.append(", list=");
        sb.append(this.f2975a);
        sb.append(']');
        return sb.toString();
    }
}
