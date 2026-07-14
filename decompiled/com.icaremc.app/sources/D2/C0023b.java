package D2;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: D2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0023b extends WeakReference {

    /* renamed from: a, reason: collision with root package name */
    public final int f357a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0023b(Object obj) {
        this(obj, null);
        T2.h.e(obj, "instance");
    }

    public final boolean equals(Object obj) {
        T t3 = get();
        if (t3 != 0) {
            if (!(obj instanceof C0023b) || ((C0023b) obj).get() != t3) {
                return false;
            }
            return true;
        }
        if (obj != this) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f357a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0023b(Object obj, ReferenceQueue referenceQueue) {
        super(obj, referenceQueue);
        T2.h.e(obj, "instance");
        this.f357a = System.identityHashCode(obj);
    }
}
