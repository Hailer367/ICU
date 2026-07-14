package r;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: r.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0290b implements Set {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0293e f3553c;

    public C0290b(C0293e c0293e) {
        this.f3553c = c0293e;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f3553c.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f3553c.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.f3553c.j(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        C0293e c0293e = this.f3553c;
        if (this != obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                try {
                    if (c0293e.f3573e == set.size()) {
                        if (c0293e.j(set)) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        int hashCode;
        C0293e c0293e = this.f3553c;
        int i2 = 0;
        for (int i3 = c0293e.f3573e - 1; i3 >= 0; i3--) {
            Object f2 = c0293e.f(i3);
            if (f2 == null) {
                hashCode = 0;
            } else {
                hashCode = f2.hashCode();
            }
            i2 += hashCode;
        }
        return i2;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f3553c.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C0289a(this.f3553c, 0);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        C0293e c0293e = this.f3553c;
        int d2 = c0293e.d(obj);
        if (d2 >= 0) {
            c0293e.g(d2);
            return true;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return this.f3553c.k(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        return this.f3553c.l(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f3553c.f3573e;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        C0293e c0293e = this.f3553c;
        int i2 = c0293e.f3573e;
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = c0293e.f(i3);
        }
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        C0293e c0293e = this.f3553c;
        int i2 = c0293e.f3573e;
        if (objArr.length < i2) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = c0293e.f(i3);
        }
        if (objArr.length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
