package J2;

import A2.i;
import I2.d;
import T2.h;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class c extends I2.a implements RandomAccess, Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final c f898i;

    /* renamed from: f, reason: collision with root package name */
    public Object[] f899f;

    /* renamed from: g, reason: collision with root package name */
    public int f900g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f901h;

    static {
        c cVar = new c(0);
        cVar.f901h = true;
        f898i = cVar;
    }

    public c(int i4) {
        if (i4 >= 0) {
            this.f899f = new Object[i4];
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    @Override // I2.a
    public final int a() {
        return this.f900g;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i4 = this.f900g;
        ((AbstractList) this).modCount++;
        g(i4, 1);
        this.f899f[i4] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        h.e(collection, "elements");
        f();
        int size = collection.size();
        d(this.f900g, collection, size);
        return size > 0;
    }

    @Override // I2.a
    public final Object b(int i4) {
        f();
        int i5 = this.f900g;
        if (i4 >= 0 && i4 < i5) {
            return h(i4);
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        i(0, this.f900g);
    }

    public final void d(int i4, Collection collection, int i5) {
        ((AbstractList) this).modCount++;
        g(i4, i5);
        Iterator it = collection.iterator();
        for (int i6 = 0; i6 < i5; i6++) {
            this.f899f[i4 + i6] = it.next();
        }
    }

    public final void e(int i4, Object obj) {
        ((AbstractList) this).modCount++;
        g(i4, 1);
        this.f899f[i4] = obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                Object[] objArr = this.f899f;
                int i4 = this.f900g;
                if (i4 == list.size()) {
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (h.a(objArr[i5], list.get(i5))) {
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
        if (!this.f901h) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final void g(int i4, int i5) {
        int i6 = this.f900g + i5;
        if (i6 >= 0) {
            Object[] objArr = this.f899f;
            if (i6 > objArr.length) {
                int length = objArr.length;
                int i7 = length + (length >> 1);
                if (i7 - i6 < 0) {
                    i7 = i6;
                }
                if (i7 - 2147483639 > 0) {
                    if (i6 > 2147483639) {
                        i7 = Integer.MAX_VALUE;
                    } else {
                        i7 = 2147483639;
                    }
                }
                Object[] copyOf = Arrays.copyOf(objArr, i7);
                h.d(copyOf, "copyOf(...)");
                this.f899f = copyOf;
            }
            Object[] objArr2 = this.f899f;
            d.W(objArr2, objArr2, i4 + i5, i4, this.f900g);
            this.f900g += i5;
            return;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i4) {
        int i5 = this.f900g;
        if (i4 >= 0 && i4 < i5) {
            return this.f899f[i4];
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    public final Object h(int i4) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f899f;
        Object obj = objArr[i4];
        d.W(objArr, objArr, i4, i4 + 1, this.f900g);
        Object[] objArr2 = this.f899f;
        int i5 = this.f900g - 1;
        h.e(objArr2, "<this>");
        objArr2[i5] = null;
        this.f900g--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4;
        Object[] objArr = this.f899f;
        int i5 = this.f900g;
        int i6 = 1;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
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
        Object[] objArr = this.f899f;
        d.W(objArr, objArr, i4, i4 + i5, this.f900g);
        Object[] objArr2 = this.f899f;
        int i6 = this.f900g;
        h.e(objArr2, "<this>");
        for (int i7 = i6 - i5; i7 < i6; i7++) {
            objArr2[i7] = null;
        }
        this.f900g -= i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i4 = 0; i4 < this.f900g; i4++) {
            if (h.a(this.f899f[i4], obj)) {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (this.f900g == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i4, int i5, Collection collection, boolean z) {
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int i8 = i4 + i6;
            if (collection.contains(this.f899f[i8]) == z) {
                Object[] objArr = this.f899f;
                i6++;
                objArr[i7 + i4] = objArr[i8];
                i7++;
            } else {
                i6++;
            }
        }
        int i9 = i5 - i7;
        Object[] objArr2 = this.f899f;
        d.W(objArr2, objArr2, i4 + i7, i5 + i4, this.f900g);
        Object[] objArr3 = this.f899f;
        int i10 = this.f900g;
        h.e(objArr3, "<this>");
        for (int i11 = i10 - i9; i11 < i10; i11++) {
            objArr3[i11] = null;
        }
        if (i9 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f900g -= i9;
        return i9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i4 = this.f900g - 1; i4 >= 0; i4--) {
            if (h.a(this.f899f[i4], obj)) {
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
        f();
        if (j(0, this.f900g, collection, false) <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        h.e(collection, "elements");
        f();
        if (j(0, this.f900g, collection, true) <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i4, Object obj) {
        f();
        int i5 = this.f900g;
        if (i4 >= 0 && i4 < i5) {
            Object[] objArr = this.f899f;
            Object obj2 = objArr[i4];
            objArr[i4] = obj;
            return obj2;
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i4, int i5) {
        AbstractC0602b.i(i4, i5, this.f900g);
        return new b(this.f899f, i4, i5 - i4, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        h.e(objArr, "array");
        int length = objArr.length;
        int i4 = this.f900g;
        if (length < i4) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f899f, 0, i4, objArr.getClass());
            h.d(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        d.W(this.f899f, objArr, 0, 0, i4);
        int i5 = this.f900g;
        if (i5 < objArr.length) {
            objArr[i5] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return AbstractC0602b.a(this.f899f, 0, this.f900g, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i4) {
        int i5 = this.f900g;
        if (i4 >= 0 && i4 <= i5) {
            return new a(this, i4);
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i4, Collection collection) {
        h.e(collection, "elements");
        f();
        int i5 = this.f900g;
        if (i4 >= 0 && i4 <= i5) {
            int size = collection.size();
            d(i4, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i4, Object obj) {
        f();
        int i5 = this.f900g;
        if (i4 >= 0 && i4 <= i5) {
            ((AbstractList) this).modCount++;
            g(i4, 1);
            this.f899f[i4] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(i.h("index: ", ", size: ", i4, i5));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return d.Y(this.f899f, 0, this.f900g);
    }
}
