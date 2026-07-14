package S0;

import R0.f;
import R0.i;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class b extends f implements RandomAccess, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public Object[] f758c;

    /* renamed from: d, reason: collision with root package name */
    public final int f759d;

    /* renamed from: e, reason: collision with root package name */
    public int f760e;

    /* renamed from: f, reason: collision with root package name */
    public final b f761f;

    /* renamed from: g, reason: collision with root package name */
    public final c f762g;

    public b(Object[] backing, int i2, int i3, b bVar, c root) {
        int i4;
        h.e(backing, "backing");
        h.e(root, "root");
        this.f758c = backing;
        this.f759d = i2;
        this.f760e = i3;
        this.f761f = bVar;
        this.f762g = root;
        i4 = ((AbstractList) root).modCount;
        ((AbstractList) this).modCount = i4;
    }

    @Override // R0.f
    public final int a() {
        f();
        return this.f760e;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        f();
        e(this.f759d + this.f760e, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        h.e(elements, "elements");
        g();
        f();
        int size = elements.size();
        d(this.f759d + this.f760e, elements, size);
        return size > 0;
    }

    @Override // R0.f
    public final Object b(int i2) {
        g();
        f();
        int i3 = this.f760e;
        if (i2 >= 0 && i2 < i3) {
            return h(this.f759d + i2);
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        f();
        i(this.f759d, this.f760e);
    }

    public final void d(int i2, Collection collection, int i3) {
        ((AbstractList) this).modCount++;
        c cVar = this.f762g;
        b bVar = this.f761f;
        if (bVar != null) {
            bVar.d(i2, collection, i3);
        } else {
            c cVar2 = c.f763f;
            cVar.d(i2, collection, i3);
        }
        this.f758c = cVar.f764c;
        this.f760e += i3;
    }

    public final void e(int i2, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.f762g;
        b bVar = this.f761f;
        if (bVar != null) {
            bVar.e(i2, obj);
        } else {
            c cVar2 = c.f763f;
            cVar.e(i2, obj);
        }
        this.f758c = cVar.f764c;
        this.f760e++;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        f();
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                Object[] objArr = this.f758c;
                int i2 = this.f760e;
                if (i2 == list.size()) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (h.a(objArr[this.f759d + i3], list.get(i3))) {
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
        int i2;
        i2 = ((AbstractList) this.f762g).modCount;
        if (i2 == ((AbstractList) this).modCount) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public final void g() {
        if (!this.f762g.f766e) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        f();
        int i3 = this.f760e;
        if (i2 >= 0 && i2 < i3) {
            return this.f758c[this.f759d + i2];
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    public final Object h(int i2) {
        Object h2;
        ((AbstractList) this).modCount++;
        b bVar = this.f761f;
        if (bVar != null) {
            h2 = bVar.h(i2);
        } else {
            c cVar = c.f763f;
            h2 = this.f762g.h(i2);
        }
        this.f760e--;
        return h2;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2;
        f();
        Object[] objArr = this.f758c;
        int i3 = this.f760e;
        int i4 = 1;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[this.f759d + i5];
            int i6 = i4 * 31;
            if (obj != null) {
                i2 = obj.hashCode();
            } else {
                i2 = 0;
            }
            i4 = i6 + i2;
        }
        return i4;
    }

    public final void i(int i2, int i3) {
        if (i3 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.f761f;
        if (bVar != null) {
            bVar.i(i2, i3);
        } else {
            c cVar = c.f763f;
            this.f762g.i(i2, i3);
        }
        this.f760e -= i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        f();
        for (int i2 = 0; i2 < this.f760e; i2++) {
            if (h.a(this.f758c[this.f759d + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        f();
        if (this.f760e == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i2, int i3, Collection collection, boolean z) {
        int j2;
        b bVar = this.f761f;
        if (bVar != null) {
            j2 = bVar.j(i2, i3, collection, z);
        } else {
            c cVar = c.f763f;
            j2 = this.f762g.j(i2, i3, collection, z);
        }
        if (j2 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f760e -= j2;
        return j2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        f();
        for (int i2 = this.f760e - 1; i2 >= 0; i2--) {
            if (h.a(this.f758c[this.f759d + i2], obj)) {
                return i2;
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
    public final boolean removeAll(Collection elements) {
        h.e(elements, "elements");
        g();
        f();
        if (j(this.f759d, this.f760e, elements, false) <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        h.e(elements, "elements");
        g();
        f();
        if (j(this.f759d, this.f760e, elements, true) > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        g();
        f();
        int i3 = this.f760e;
        if (i2 >= 0 && i2 < i3) {
            Object[] objArr = this.f758c;
            int i4 = this.f759d;
            Object obj2 = objArr[i4 + i2];
            objArr[i4 + i2] = obj;
            return obj2;
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i3) {
        android.support.v4.media.session.a.d(i2, i3, this.f760e);
        return new b(this.f758c, this.f759d + i2, i3 - i2, this, this.f762g);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        h.e(array, "array");
        f();
        int length = array.length;
        int i2 = this.f760e;
        int i3 = this.f759d;
        if (length < i2) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f758c, i3, i2 + i3, array.getClass());
            h.d(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        i.Y(this.f758c, array, 0, i3, i2 + i3);
        int i4 = this.f760e;
        if (i4 < array.length) {
            array[i4] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        f();
        return android.support.v4.media.session.a.b(this.f758c, this.f759d, this.f760e, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        f();
        int i3 = this.f760e;
        if (i2 >= 0 && i2 <= i3) {
            return new a(this, i2);
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        g();
        f();
        int i3 = this.f760e;
        if (i2 >= 0 && i2 <= i3) {
            e(this.f759d + i2, obj);
            return;
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection elements) {
        h.e(elements, "elements");
        g();
        f();
        int i3 = this.f760e;
        if (i2 >= 0 && i2 <= i3) {
            int size = elements.size();
            d(this.f759d + i2, elements, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        f();
        Object[] objArr = this.f758c;
        int i2 = this.f760e;
        int i3 = this.f759d;
        return i.a0(objArr, i3, i2 + i3);
    }
}
