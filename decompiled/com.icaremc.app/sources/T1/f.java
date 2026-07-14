package T1;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f extends h implements Iterable {

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f1619f = new ArrayList();

    @Override // T1.h
    public final boolean a() {
        return d().a();
    }

    @Override // T1.h
    public final String c() {
        return d().c();
    }

    public final h d() {
        ArrayList arrayList = this.f1619f;
        int size = arrayList.size();
        if (size == 1) {
            return (h) arrayList.get(0);
        }
        throw new IllegalStateException(A2.i.g(size, "Array must have size 1, but has size "));
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof f) || !((f) obj).f1619f.equals(this.f1619f)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final int hashCode() {
        return this.f1619f.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f1619f.iterator();
    }
}
