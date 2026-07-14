package I2;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: i, reason: collision with root package name */
    public static final Object[] f857i = new Object[0];

    /* renamed from: f, reason: collision with root package name */
    public int f858f;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f859g = f857i;

    /* renamed from: h, reason: collision with root package name */
    public int f860h;

    @Override // I2.a
    public final int a() {
        return this.f860h;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i4, Object obj) {
        int i5;
        int i6 = this.f860h;
        if (i4 < 0 || i4 > i6) {
            throw new IndexOutOfBoundsException(A2.i.h("index: ", ", size: ", i4, i6));
        }
        if (i4 == i6) {
            addLast(obj);
            return;
        }
        if (i4 == 0) {
            addFirst(obj);
            return;
        }
        i();
        d(this.f860h + 1);
        int h3 = h(this.f858f + i4);
        int i7 = this.f860h;
        if (i4 < ((i7 + 1) >> 1)) {
            if (h3 == 0) {
                Object[] objArr = this.f859g;
                T2.h.e(objArr, "<this>");
                h3 = objArr.length;
            }
            int i8 = h3 - 1;
            int i9 = this.f858f;
            if (i9 == 0) {
                Object[] objArr2 = this.f859g;
                T2.h.e(objArr2, "<this>");
                i5 = objArr2.length - 1;
            } else {
                i5 = i9 - 1;
            }
            int i10 = this.f858f;
            if (i8 >= i10) {
                Object[] objArr3 = this.f859g;
                objArr3[i5] = objArr3[i10];
                d.W(objArr3, objArr3, i10, i10 + 1, i8 + 1);
            } else {
                Object[] objArr4 = this.f859g;
                d.W(objArr4, objArr4, i10 - 1, i10, objArr4.length);
                Object[] objArr5 = this.f859g;
                objArr5[objArr5.length - 1] = objArr5[0];
                d.W(objArr5, objArr5, 0, 1, i8 + 1);
            }
            this.f859g[i8] = obj;
            this.f858f = i5;
        } else {
            int h4 = h(i7 + this.f858f);
            if (h3 < h4) {
                Object[] objArr6 = this.f859g;
                d.W(objArr6, objArr6, h3 + 1, h3, h4);
            } else {
                Object[] objArr7 = this.f859g;
                d.W(objArr7, objArr7, 1, 0, h4);
                Object[] objArr8 = this.f859g;
                objArr8[0] = objArr8[objArr8.length - 1];
                d.W(objArr8, objArr8, h3 + 1, h3, objArr8.length - 1);
            }
            this.f859g[h3] = obj;
        }
        this.f860h++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i4, Collection collection) {
        T2.h.e(collection, "elements");
        int i5 = this.f860h;
        if (i4 >= 0 && i4 <= i5) {
            if (collection.isEmpty()) {
                return false;
            }
            if (i4 == this.f860h) {
                return addAll(collection);
            }
            i();
            d(collection.size() + this.f860h);
            int h3 = h(this.f860h + this.f858f);
            int h4 = h(this.f858f + i4);
            int size = collection.size();
            if (i4 < ((this.f860h + 1) >> 1)) {
                int i6 = this.f858f;
                int i7 = i6 - size;
                if (h4 < i6) {
                    Object[] objArr = this.f859g;
                    d.W(objArr, objArr, i7, i6, objArr.length);
                    if (size >= h4) {
                        Object[] objArr2 = this.f859g;
                        d.W(objArr2, objArr2, objArr2.length - size, 0, h4);
                    } else {
                        Object[] objArr3 = this.f859g;
                        d.W(objArr3, objArr3, objArr3.length - size, 0, size);
                        Object[] objArr4 = this.f859g;
                        d.W(objArr4, objArr4, 0, size, h4);
                    }
                } else if (i7 >= 0) {
                    Object[] objArr5 = this.f859g;
                    d.W(objArr5, objArr5, i7, i6, h4);
                } else {
                    Object[] objArr6 = this.f859g;
                    i7 += objArr6.length;
                    int i8 = h4 - i6;
                    int length = objArr6.length - i7;
                    if (length >= i8) {
                        d.W(objArr6, objArr6, i7, i6, h4);
                    } else {
                        d.W(objArr6, objArr6, i7, i6, i6 + length);
                        Object[] objArr7 = this.f859g;
                        d.W(objArr7, objArr7, 0, this.f858f + length, h4);
                    }
                }
                this.f858f = i7;
                c(f(h4 - size), collection);
                return true;
            }
            int i9 = h4 + size;
            if (h4 < h3) {
                int i10 = size + h3;
                Object[] objArr8 = this.f859g;
                if (i10 <= objArr8.length) {
                    d.W(objArr8, objArr8, i9, h4, h3);
                } else if (i9 >= objArr8.length) {
                    d.W(objArr8, objArr8, i9 - objArr8.length, h4, h3);
                } else {
                    int length2 = h3 - (i10 - objArr8.length);
                    d.W(objArr8, objArr8, 0, length2, h3);
                    Object[] objArr9 = this.f859g;
                    d.W(objArr9, objArr9, i9, h4, length2);
                }
            } else {
                Object[] objArr10 = this.f859g;
                d.W(objArr10, objArr10, size, 0, h3);
                Object[] objArr11 = this.f859g;
                if (i9 >= objArr11.length) {
                    d.W(objArr11, objArr11, i9 - objArr11.length, h4, objArr11.length);
                } else {
                    d.W(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f859g;
                    d.W(objArr12, objArr12, i9, h4, objArr12.length - size);
                }
            }
            c(h4, collection);
            return true;
        }
        throw new IndexOutOfBoundsException(A2.i.h("index: ", ", size: ", i4, i5));
    }

    public final void addFirst(Object obj) {
        i();
        d(this.f860h + 1);
        int i4 = this.f858f;
        if (i4 == 0) {
            Object[] objArr = this.f859g;
            T2.h.e(objArr, "<this>");
            i4 = objArr.length;
        }
        int i5 = i4 - 1;
        this.f858f = i5;
        this.f859g[i5] = obj;
        this.f860h++;
    }

    public final void addLast(Object obj) {
        i();
        d(a() + 1);
        this.f859g[h(a() + this.f858f)] = obj;
        this.f860h = a() + 1;
    }

    @Override // I2.a
    public final Object b(int i4) {
        int i5 = this.f860h;
        if (i4 >= 0 && i4 < i5) {
            if (i4 == size() - 1) {
                return removeLast();
            }
            if (i4 == 0) {
                return removeFirst();
            }
            i();
            int h3 = h(this.f858f + i4);
            Object[] objArr = this.f859g;
            Object obj = objArr[h3];
            if (i4 < (this.f860h >> 1)) {
                int i6 = this.f858f;
                if (h3 >= i6) {
                    d.W(objArr, objArr, i6 + 1, i6, h3);
                } else {
                    d.W(objArr, objArr, 1, 0, h3);
                    Object[] objArr2 = this.f859g;
                    objArr2[0] = objArr2[objArr2.length - 1];
                    int i7 = this.f858f;
                    d.W(objArr2, objArr2, i7 + 1, i7, objArr2.length - 1);
                }
                Object[] objArr3 = this.f859g;
                int i8 = this.f858f;
                objArr3[i8] = null;
                this.f858f = e(i8);
            } else {
                int h4 = h((size() - 1) + this.f858f);
                if (h3 <= h4) {
                    Object[] objArr4 = this.f859g;
                    d.W(objArr4, objArr4, h3, h3 + 1, h4 + 1);
                } else {
                    Object[] objArr5 = this.f859g;
                    d.W(objArr5, objArr5, h3, h3 + 1, objArr5.length);
                    Object[] objArr6 = this.f859g;
                    objArr6[objArr6.length - 1] = objArr6[0];
                    d.W(objArr6, objArr6, 0, 1, h4 + 1);
                }
                this.f859g[h4] = null;
            }
            this.f860h--;
            return obj;
        }
        throw new IndexOutOfBoundsException(A2.i.h("index: ", ", size: ", i4, i5));
    }

    public final void c(int i4, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f859g.length;
        while (i4 < length && it.hasNext()) {
            this.f859g[i4] = it.next();
            i4++;
        }
        int i5 = this.f858f;
        for (int i6 = 0; i6 < i5 && it.hasNext(); i6++) {
            this.f859g[i6] = it.next();
        }
        this.f860h = collection.size() + this.f860h;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            i();
            g(this.f858f, h(a() + this.f858f));
        }
        this.f858f = 0;
        this.f860h = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final void d(int i4) {
        if (i4 >= 0) {
            Object[] objArr = this.f859g;
            if (i4 <= objArr.length) {
                return;
            }
            if (objArr == f857i) {
                if (i4 < 10) {
                    i4 = 10;
                }
                this.f859g = new Object[i4];
                return;
            }
            int length = objArr.length;
            int i5 = length + (length >> 1);
            if (i5 - i4 < 0) {
                i5 = i4;
            }
            if (i5 - 2147483639 > 0) {
                if (i4 > 2147483639) {
                    i5 = Integer.MAX_VALUE;
                } else {
                    i5 = 2147483639;
                }
            }
            Object[] objArr2 = new Object[i5];
            d.W(objArr, objArr2, 0, this.f858f, objArr.length);
            Object[] objArr3 = this.f859g;
            int length2 = objArr3.length;
            int i6 = this.f858f;
            d.W(objArr3, objArr2, length2 - i6, 0, i6);
            this.f858f = 0;
            this.f859g = objArr2;
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    public final int e(int i4) {
        T2.h.e(this.f859g, "<this>");
        if (i4 == r0.length - 1) {
            return 0;
        }
        return i4 + 1;
    }

    public final int f(int i4) {
        if (i4 < 0) {
            return i4 + this.f859g.length;
        }
        return i4;
    }

    public final void g(int i4, int i5) {
        if (i4 < i5) {
            Object[] objArr = this.f859g;
            T2.h.e(objArr, "<this>");
            Arrays.fill(objArr, i4, i5, (Object) null);
        } else {
            Object[] objArr2 = this.f859g;
            Arrays.fill(objArr2, i4, objArr2.length, (Object) null);
            Object[] objArr3 = this.f859g;
            T2.h.e(objArr3, "<this>");
            Arrays.fill(objArr3, 0, i5, (Object) null);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i4) {
        int a4 = a();
        if (i4 >= 0 && i4 < a4) {
            return this.f859g[h(this.f858f + i4)];
        }
        throw new IndexOutOfBoundsException(A2.i.h("index: ", ", size: ", i4, a4));
    }

    public final int h(int i4) {
        Object[] objArr = this.f859g;
        if (i4 >= objArr.length) {
            return i4 - objArr.length;
        }
        return i4;
    }

    public final void i() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i4;
        int h3 = h(a() + this.f858f);
        int i5 = this.f858f;
        if (i5 < h3) {
            while (i5 < h3) {
                if (T2.h.a(obj, this.f859g[i5])) {
                    i4 = this.f858f;
                } else {
                    i5++;
                }
            }
            return -1;
        }
        if (i5 >= h3) {
            int length = this.f859g.length;
            while (true) {
                if (i5 < length) {
                    if (T2.h.a(obj, this.f859g[i5])) {
                        i4 = this.f858f;
                        break;
                    }
                    i5++;
                } else {
                    for (int i6 = 0; i6 < h3; i6++) {
                        if (T2.h.a(obj, this.f859g[i6])) {
                            i5 = i6 + this.f859g.length;
                            i4 = this.f858f;
                        }
                    }
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return i5 - i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (a() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i4;
        int h3 = h(this.f860h + this.f858f);
        int i5 = this.f858f;
        if (i5 < h3) {
            length = h3 - 1;
            if (i5 <= length) {
                while (!T2.h.a(obj, this.f859g[length])) {
                    if (length != i5) {
                        length--;
                    }
                }
                i4 = this.f858f;
                return length - i4;
            }
            return -1;
        }
        if (i5 > h3) {
            int i6 = h3 - 1;
            while (true) {
                if (-1 < i6) {
                    if (T2.h.a(obj, this.f859g[i6])) {
                        length = i6 + this.f859g.length;
                        i4 = this.f858f;
                        break;
                    }
                    i6--;
                } else {
                    Object[] objArr = this.f859g;
                    T2.h.e(objArr, "<this>");
                    length = objArr.length - 1;
                    int i7 = this.f858f;
                    if (i7 <= length) {
                        while (!T2.h.a(obj, this.f859g[length])) {
                            if (length != i7) {
                                length--;
                            }
                        }
                        i4 = this.f858f;
                    }
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        b(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int h3;
        T2.h.e(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f859g.length != 0) {
            int h4 = h(this.f860h + this.f858f);
            int i4 = this.f858f;
            if (i4 < h4) {
                h3 = i4;
                while (i4 < h4) {
                    Object obj = this.f859g[i4];
                    if (!collection.contains(obj)) {
                        this.f859g[h3] = obj;
                        h3++;
                    } else {
                        z = true;
                    }
                    i4++;
                }
                Object[] objArr = this.f859g;
                T2.h.e(objArr, "<this>");
                Arrays.fill(objArr, h3, h4, (Object) null);
            } else {
                int length = this.f859g.length;
                boolean z3 = false;
                int i5 = i4;
                while (i4 < length) {
                    Object[] objArr2 = this.f859g;
                    Object obj2 = objArr2[i4];
                    objArr2[i4] = null;
                    if (!collection.contains(obj2)) {
                        this.f859g[i5] = obj2;
                        i5++;
                    } else {
                        z3 = true;
                    }
                    i4++;
                }
                h3 = h(i5);
                for (int i6 = 0; i6 < h4; i6++) {
                    Object[] objArr3 = this.f859g;
                    Object obj3 = objArr3[i6];
                    objArr3[i6] = null;
                    if (!collection.contains(obj3)) {
                        this.f859g[h3] = obj3;
                        h3 = e(h3);
                    } else {
                        z3 = true;
                    }
                }
                z = z3;
            }
            if (z) {
                i();
                this.f860h = f(h3 - this.f858f);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (!isEmpty()) {
            i();
            Object[] objArr = this.f859g;
            int i4 = this.f858f;
            Object obj = objArr[i4];
            objArr[i4] = null;
            this.f858f = e(i4);
            this.f860h = a() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object removeLast() {
        if (!isEmpty()) {
            i();
            int h3 = h((size() - 1) + this.f858f);
            Object[] objArr = this.f859g;
            Object obj = objArr[h3];
            objArr[h3] = null;
            this.f860h = a() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i4, int i5) {
        AbstractC0602b.i(i4, i5, this.f860h);
        int i6 = i5 - i4;
        if (i6 == 0) {
            return;
        }
        if (i6 == this.f860h) {
            clear();
            return;
        }
        if (i6 == 1) {
            b(i4);
            return;
        }
        i();
        if (i4 < this.f860h - i5) {
            int h3 = h(this.f858f + (i4 - 1));
            int h4 = h(this.f858f + (i5 - 1));
            while (i4 > 0) {
                int i7 = h3 + 1;
                int min = Math.min(i4, Math.min(i7, h4 + 1));
                Object[] objArr = this.f859g;
                int i8 = h4 - min;
                int i9 = h3 - min;
                d.W(objArr, objArr, i8 + 1, i9 + 1, i7);
                h3 = f(i9);
                h4 = f(i8);
                i4 -= min;
            }
            int h5 = h(this.f858f + i6);
            g(this.f858f, h5);
            this.f858f = h5;
        } else {
            int h6 = h(this.f858f + i5);
            int h7 = h(this.f858f + i4);
            int i10 = this.f860h;
            while (true) {
                i10 -= i5;
                if (i10 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f859g;
                i5 = Math.min(i10, Math.min(objArr2.length - h6, objArr2.length - h7));
                Object[] objArr3 = this.f859g;
                int i11 = h6 + i5;
                d.W(objArr3, objArr3, h7, h6, i11);
                h6 = h(i11);
                h7 = h(h7 + i5);
            }
            int h8 = h(this.f860h + this.f858f);
            g(f(h8 - i6), h8);
        }
        this.f860h -= i6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int h3;
        T2.h.e(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f859g.length != 0) {
            int h4 = h(this.f860h + this.f858f);
            int i4 = this.f858f;
            if (i4 < h4) {
                h3 = i4;
                while (i4 < h4) {
                    Object obj = this.f859g[i4];
                    if (collection.contains(obj)) {
                        this.f859g[h3] = obj;
                        h3++;
                    } else {
                        z = true;
                    }
                    i4++;
                }
                Object[] objArr = this.f859g;
                T2.h.e(objArr, "<this>");
                Arrays.fill(objArr, h3, h4, (Object) null);
            } else {
                int length = this.f859g.length;
                boolean z3 = false;
                int i5 = i4;
                while (i4 < length) {
                    Object[] objArr2 = this.f859g;
                    Object obj2 = objArr2[i4];
                    objArr2[i4] = null;
                    if (collection.contains(obj2)) {
                        this.f859g[i5] = obj2;
                        i5++;
                    } else {
                        z3 = true;
                    }
                    i4++;
                }
                h3 = h(i5);
                for (int i6 = 0; i6 < h4; i6++) {
                    Object[] objArr3 = this.f859g;
                    Object obj3 = objArr3[i6];
                    objArr3[i6] = null;
                    if (collection.contains(obj3)) {
                        this.f859g[h3] = obj3;
                        h3 = e(h3);
                    } else {
                        z3 = true;
                    }
                }
                z = z3;
            }
            if (z) {
                i();
                this.f860h = f(h3 - this.f858f);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i4, Object obj) {
        int a4 = a();
        if (i4 >= 0 && i4 < a4) {
            int h3 = h(this.f858f + i4);
            Object[] objArr = this.f859g;
            Object obj2 = objArr[h3];
            objArr[h3] = obj;
            return obj2;
        }
        throw new IndexOutOfBoundsException(A2.i.h("index: ", ", size: ", i4, a4));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        T2.h.e(objArr, "array");
        int length = objArr.length;
        int i4 = this.f860h;
        if (length < i4) {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i4);
            T2.h.c(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) newInstance;
        }
        int h3 = h(this.f860h + this.f858f);
        int i5 = this.f858f;
        if (i5 < h3) {
            d.X(this.f859g, objArr, i5, h3, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f859g;
            d.W(objArr2, objArr, 0, this.f858f, objArr2.length);
            Object[] objArr3 = this.f859g;
            d.W(objArr3, objArr, objArr3.length - this.f858f, 0, h3);
        }
        int i6 = this.f860h;
        if (i6 < objArr.length) {
            objArr[i6] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        T2.h.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        i();
        d(collection.size() + a());
        c(h(a() + this.f858f), collection);
        return true;
    }
}
