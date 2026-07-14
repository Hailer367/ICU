package J2;

import A2.i;
import I2.d;
import T2.h;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class b extends I2.a implements RandomAccess, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public Object[] f893f;

    /* renamed from: g, reason: collision with root package name */
    public final int f894g;

    /* renamed from: h, reason: collision with root package name */
    public int f895h;

    /* renamed from: i, reason: collision with root package name */
    public final b f896i;

    /* renamed from: j, reason: collision with root package name */
    public final c f897j;

    public b(Object[] objArr, int i4, int i5, b bVar, c cVar) {
        int i6;
        h.e(objArr, "backing");
        h.e(cVar, "root");
        this.f893f = objArr;
        this.f894g = i4;
        this.f895h = i5;
        this.f896i = bVar;
        this.f897j = cVar;
        i6 = ((AbstractList) cVar).modCount;
        ((AbstractList) this).modCount = i6;
    }

    @Override // I2.a
    public final int a() {
        f();
        return this.f895h;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        f();
        e(this.f894g + this.f895h, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        h.e(collection, "elements");
        g();
        f();
        int size = collection.size();
        d(this.f894g + this.f895h, collection, size);
        return size > 0;
    }

    @Override // I2.a
    public final Object b(int i4) {
        g();
        f();
        int i5 = this.f895h;
        if (i4 >= 0 && i4 < i5) {
            return h(this.f894g + i4);
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        f();
        i(this.f894g, this.f895h);
    }

    public final void d(int i4, Collection collection, int i5) {
        ((AbstractList) this).modCount++;
        c cVar = this.f897j;
        b bVar = this.f896i;
        if (bVar != null) {
            bVar.d(i4, collection, i5);
        } else {
            c cVar2 = c.f898i;
            cVar.d(i4, collection, i5);
        }
        this.f893f = cVar.f899f;
        this.f895h += i5;
    }

    public final void e(int i4, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.f897j;
        b bVar = this.f896i;
        if (bVar != null) {
            bVar.e(i4, obj);
        } else {
            c cVar2 = c.f898i;
            cVar.e(i4, obj);
        }
        this.f893f = cVar.f899f;
        this.f895h++;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        f();
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                Object[] objArr = this.f893f;
                int i4 = this.f895h;
                if (i4 == list.size()) {
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (h.a(objArr[this.f894g + i5], list.get(i5))) {
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final void f() {
        int i4;
        i4 = ((AbstractList) this.f897j).modCount;
        if (i4 == ((AbstractList) this).modCount) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public final void g() {
        if (!this.f897j.f901h) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i4) {
        f();
        int i5 = this.f895h;
        if (i4 >= 0 && i4 < i5) {
            return this.f893f[this.f894g + i4];
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    public final Object h(int i4) {
        Object h3;
        ((AbstractList) this).modCount++;
        b bVar = this.f896i;
        if (bVar != null) {
            h3 = bVar.h(i4);
        } else {
            c cVar = c.f898i;
            h3 = this.f897j.h(i4);
        }
        this.f895h--;
        return h3;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4;
        f();
        Object[] objArr = this.f893f;
        int i5 = this.f895h;
        int i6 = 1;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[this.f894g + i7];
            int i8 = i6 * 31;
            if (obj != null) {
                i4 = obj.hashCode();
            } else {
                i4 = 0;
            }
            i6 = i8 + i4;
        }
        return i6;
    }

    public final void i(int i4, int i5) {
        if (i5 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.f896i;
        if (bVar != null) {
            bVar.i(i4, i5);
        } else {
            c cVar = c.f898i;
            this.f897j.i(i4, i5);
        }
        this.f895h -= i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        f();
        for (int i4 = 0; i4 < this.f895h; i4++) {
            if (h.a(this.f893f[this.f894g + i4], obj)) {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        f();
        if (this.f895h == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i4, int i5, Collection collection, boolean z) {
        int j4;
        b bVar = this.f896i;
        if (bVar != null) {
            j4 = bVar.j(i4, i5, collection, z);
        } else {
            c cVar = c.f898i;
            j4 = this.f897j.j(i4, i5, collection, z);
        }
        if (j4 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f895h -= j4;
        return j4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        f();
        for (int i4 = this.f895h - 1; i4 >= 0; i4--) {
            if (h.a(this.f893f[this.f894g + i4], obj)) {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
        f();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            b(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        h.e(collection, "elements");
        g();
        f();
        if (j(this.f894g, this.f895h, collection, false) <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        h.e(collection, "elements");
        g();
        f();
        if (j(this.f894g, this.f895h, collection, true) > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i4, Object obj) {
        g();
        f();
        int i5 = this.f895h;
        if (i4 >= 0 && i4 < i5) {
            Object[] objArr = this.f893f;
            int i6 = this.f894g;
            Object obj2 = objArr[i6 + i4];
            objArr[i6 + i4] = obj;
            return obj2;
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i4, int i5) {
        AbstractC0602b.i(i4, i5, this.f895h);
        return new b(this.f893f, this.f894g + i4, i5 - i4, this, this.f897j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        h.e(objArr, "array");
        f();
        int length = objArr.length;
        int i4 = this.f895h;
        int i5 = this.f894g;
        if (length < i4) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f893f, i5, i4 + i5, objArr.getClass());
            h.d(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        d.W(this.f893f, objArr, 0, i5, i4 + i5);
        int i6 = this.f895h;
        if (i6 < objArr.length) {
            objArr[i6] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        f();
        return AbstractC0602b.a(this.f893f, this.f894g, this.f895h, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i4) {
        f();
        int i5 = this.f895h;
        if (i4 >= 0 && i4 <= i5) {
            return new a(this, i4);
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i4, Object obj) {
        g();
        f();
        int i5 = this.f895h;
        if (i4 >= 0 && i4 <= i5) {
            e(this.f894g + i4, obj);
            return;
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i4, Collection collection) {
        h.e(collection, "elements");
        g();
        f();
        int i5 = this.f895h;
        if (i4 >= 0 && i4 <= i5) {
            int size = collection.size();
            d(this.f894g + i4, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        f();
        Object[] objArr = this.f893f;
        int i4 = this.f895h;
        int i5 = this.f894g;
        return d.Y(objArr, i5, i4 + i5);
    }
}
