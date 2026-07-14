package S0;

import R0.f;
import R0.i;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class c extends f implements RandomAccess, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final c f763f;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f764c;

    /* renamed from: d, reason: collision with root package name */
    public int f765d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f766e;

    static {
        c cVar = new c(0);
        cVar.f766e = true;
        f763f = cVar;
    }

    public c(int i2) {
        if (i2 >= 0) {
            this.f764c = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    @Override // R0.f
    public final int a() {
        return this.f765d;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i2 = this.f765d;
        ((AbstractList) this).modCount++;
        g(i2, 1);
        this.f764c[i2] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        h.e(elements, "elements");
        f();
        int size = elements.size();
        d(this.f765d, elements, size);
        return size > 0;
    }

    @Override // R0.f
    public final Object b(int i2) {
        f();
        int i3 = this.f765d;
        if (i2 >= 0 && i2 < i3) {
            return h(i2);
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        i(0, this.f765d);
    }

    public final void d(int i2, Collection collection, int i3) {
        ((AbstractList) this).modCount++;
        g(i2, i3);
        Iterator it = collection.iterator();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f764c[i2 + i4] = it.next();
        }
    }

    public final void e(int i2, Object obj) {
        ((AbstractList) this).modCount++;
        g(i2, 1);
        this.f764c[i2] = obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                Object[] objArr = this.f764c;
                int i2 = this.f765d;
                if (i2 == list.size()) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (h.a(objArr[i3], list.get(i3))) {
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
        if (!this.f766e) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final void g(int i2, int i3) {
        int i4 = this.f765d + i3;
        if (i4 >= 0) {
            Object[] objArr = this.f764c;
            if (i4 > objArr.length) {
                int length = objArr.length;
                int i5 = length + (length >> 1);
                if (i5 - i4 < 0) {
                    i5 = i4;
                }
                if (i5 - 2147483639 > 0) {
                    if (i4 > 2147483639) {
                        i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i5 = 2147483639;
                    }
                }
                Object[] copyOf = Arrays.copyOf(objArr, i5);
                h.d(copyOf, "copyOf(...)");
                this.f764c = copyOf;
            }
            Object[] objArr2 = this.f764c;
            i.Y(objArr2, objArr2, i2 + i3, i2, this.f765d);
            this.f765d += i3;
            return;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        int i3 = this.f765d;
        if (i2 >= 0 && i2 < i3) {
            return this.f764c[i2];
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    public final Object h(int i2) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f764c;
        Object obj = objArr[i2];
        i.Y(objArr, objArr, i2, i2 + 1, this.f765d);
        Object[] objArr2 = this.f764c;
        int i3 = this.f765d - 1;
        h.e(objArr2, "<this>");
        objArr2[i3] = null;
        this.f765d--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2;
        Object[] objArr = this.f764c;
        int i3 = this.f765d;
        int i4 = 1;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
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
        Object[] objArr = this.f764c;
        i.Y(objArr, objArr, i2, i2 + i3, this.f765d);
        Object[] objArr2 = this.f764c;
        int i4 = this.f765d;
        h.e(objArr2, "<this>");
        for (int i5 = i4 - i3; i5 < i4; i5++) {
            objArr2[i5] = null;
        }
        this.f765d -= i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.f765d; i2++) {
            if (h.a(this.f764c[i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (this.f765d == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i2, int i3, Collection collection, boolean z) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i2 + i4;
            if (collection.contains(this.f764c[i6]) == z) {
                Object[] objArr = this.f764c;
                i4++;
                objArr[i5 + i2] = objArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        Object[] objArr2 = this.f764c;
        i.Y(objArr2, objArr2, i2 + i5, i3 + i2, this.f765d);
        Object[] objArr3 = this.f764c;
        int i8 = this.f765d;
        h.e(objArr3, "<this>");
        for (int i9 = i8 - i7; i9 < i8; i9++) {
            objArr3[i9] = null;
        }
        if (i7 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f765d -= i7;
        return i7;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i2 = this.f765d - 1; i2 >= 0; i2--) {
            if (h.a(this.f764c[i2], obj)) {
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
        f();
        if (j(0, this.f765d, elements, false) <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        h.e(elements, "elements");
        f();
        if (j(0, this.f765d, elements, true) <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        f();
        int i3 = this.f765d;
        if (i2 >= 0 && i2 < i3) {
            Object[] objArr = this.f764c;
            Object obj2 = objArr[i2];
            objArr[i2] = obj;
            return obj2;
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i3) {
        android.support.v4.media.session.a.d(i2, i3, this.f765d);
        return new b(this.f764c, i2, i3 - i2, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        h.e(array, "array");
        int length = array.length;
        int i2 = this.f765d;
        if (length < i2) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f764c, 0, i2, array.getClass());
            h.d(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        i.Y(this.f764c, array, 0, 0, i2);
        int i3 = this.f765d;
        if (i3 < array.length) {
            array[i3] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return android.support.v4.media.session.a.b(this.f764c, 0, this.f765d, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        int i3 = this.f765d;
        if (i2 >= 0 && i2 <= i3) {
            return new a(this, i2);
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection elements) {
        h.e(elements, "elements");
        f();
        int i3 = this.f765d;
        if (i2 >= 0 && i2 <= i3) {
            int size = elements.size();
            d(i2, elements, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        f();
        int i3 = this.f765d;
        if (i2 >= 0 && i2 <= i3) {
            ((AbstractList) this).modCount++;
            g(i2, 1);
            this.f764c[i2] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return i.a0(this.f764c, 0, this.f765d);
    }
}
