package r;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: r.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0292d implements Collection {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0293e f3558c;

    public C0292d(C0293e c0293e) {
        this.f3558c = c0293e;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f3558c.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (this.f3558c.a(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f3558c.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C0289a(this.f3558c, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        C0293e c0293e = this.f3558c;
        int a2 = c0293e.a(obj);
        if (a2 >= 0) {
            c0293e.g(a2);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        C0293e c0293e = this.f3558c;
        int i2 = c0293e.f3573e;
        int i3 = 0;
        boolean z = false;
        while (i3 < i2) {
            if (collection.contains(c0293e.i(i3))) {
                c0293e.g(i3);
                i3--;
                i2--;
                z = true;
            }
            i3++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        C0293e c0293e = this.f3558c;
        int i2 = c0293e.f3573e;
        int i3 = 0;
        boolean z = false;
        while (i3 < i2) {
            if (!collection.contains(c0293e.i(i3))) {
                c0293e.g(i3);
                i3--;
                i2--;
                z = true;
            }
            i3++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f3558c.f3573e;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        C0293e c0293e = this.f3558c;
        int i2 = c0293e.f3573e;
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = c0293e.i(i3);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        C0293e c0293e = this.f3558c;
        int i2 = c0293e.f3573e;
        if (objArr.length < i2) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = c0293e.i(i3);
        }
        if (objArr.length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
