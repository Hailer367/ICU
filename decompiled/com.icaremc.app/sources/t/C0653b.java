package t;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: t.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0653b implements Set {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0656e f6171f;

    public C0653b(C0656e c0656e) {
        this.f6171f = c0656e;
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
        this.f6171f.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f6171f.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.f6171f.i(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        C0656e c0656e = this.f6171f;
        if (this != obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                try {
                    if (c0656e.f6196h == set.size()) {
                        if (c0656e.i(set)) {
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
        C0656e c0656e = this.f6171f;
        int i4 = 0;
        for (int i5 = c0656e.f6196h - 1; i5 >= 0; i5--) {
            Object e4 = c0656e.e(i5);
            if (e4 == null) {
                hashCode = 0;
            } else {
                hashCode = e4.hashCode();
            }
            i4 += hashCode;
        }
        return i4;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f6171f.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C0652a(this.f6171f, 0);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        C0656e c0656e = this.f6171f;
        int c4 = c0656e.c(obj);
        if (c4 >= 0) {
            c0656e.f(c4);
            return true;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return this.f6171f.j(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        C0656e c0656e = this.f6171f;
        int i4 = c0656e.f6196h;
        for (int i5 = i4 - 1; i5 >= 0; i5--) {
            if (!collection.contains(c0656e.e(i5))) {
                c0656e.f(i5);
            }
        }
        if (i4 != c0656e.f6196h) {
            return true;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f6171f.f6196h;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        C0656e c0656e = this.f6171f;
        int i4 = c0656e.f6196h;
        Object[] objArr = new Object[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = c0656e.e(i5);
        }
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        C0656e c0656e = this.f6171f;
        int i4 = c0656e.f6196h;
        if (objArr.length < i4) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i4);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = c0656e.e(i5);
        }
        if (objArr.length > i4) {
            objArr[i4] = null;
        }
        return objArr;
    }
}
