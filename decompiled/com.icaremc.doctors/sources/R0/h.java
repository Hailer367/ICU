package R0;

import com.google.android.gms.common.api.Api;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class h extends f {

    /* renamed from: f, reason: collision with root package name */
    public static final Object[] f745f = new Object[0];

    /* renamed from: c, reason: collision with root package name */
    public int f746c;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f747d = f745f;

    /* renamed from: e, reason: collision with root package name */
    public int f748e;

    @Override // R0.f
    public final int a() {
        return this.f748e;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        int i4 = this.f748e;
        if (i2 < 0 || i2 > i4) {
            throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i4));
        }
        if (i2 == i4) {
            addLast(obj);
            return;
        }
        if (i2 == 0) {
            addFirst(obj);
            return;
        }
        i();
        d(this.f748e + 1);
        int h2 = h(this.f746c + i2);
        int i5 = this.f748e;
        if (i2 < ((i5 + 1) >> 1)) {
            if (h2 == 0) {
                Object[] objArr = this.f747d;
                kotlin.jvm.internal.h.e(objArr, "<this>");
                h2 = objArr.length;
            }
            int i6 = h2 - 1;
            int i7 = this.f746c;
            if (i7 == 0) {
                Object[] objArr2 = this.f747d;
                kotlin.jvm.internal.h.e(objArr2, "<this>");
                i3 = objArr2.length - 1;
            } else {
                i3 = i7 - 1;
            }
            int i8 = this.f746c;
            if (i6 >= i8) {
                Object[] objArr3 = this.f747d;
                objArr3[i3] = objArr3[i8];
                i.Y(objArr3, objArr3, i8, i8 + 1, i6 + 1);
            } else {
                Object[] objArr4 = this.f747d;
                i.Y(objArr4, objArr4, i8 - 1, i8, objArr4.length);
                Object[] objArr5 = this.f747d;
                objArr5[objArr5.length - 1] = objArr5[0];
                i.Y(objArr5, objArr5, 0, 1, i6 + 1);
            }
            this.f747d[i6] = obj;
            this.f746c = i3;
        } else {
            int h3 = h(i5 + this.f746c);
            if (h2 < h3) {
                Object[] objArr6 = this.f747d;
                i.Y(objArr6, objArr6, h2 + 1, h2, h3);
            } else {
                Object[] objArr7 = this.f747d;
                i.Y(objArr7, objArr7, 1, 0, h3);
                Object[] objArr8 = this.f747d;
                objArr8[0] = objArr8[objArr8.length - 1];
                i.Y(objArr8, objArr8, h2 + 1, h2, objArr8.length - 1);
            }
            this.f747d[h2] = obj;
        }
        this.f748e++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection elements) {
        kotlin.jvm.internal.h.e(elements, "elements");
        int i3 = this.f748e;
        if (i2 >= 0 && i2 <= i3) {
            if (elements.isEmpty()) {
                return false;
            }
            if (i2 == this.f748e) {
                return addAll(elements);
            }
            i();
            d(elements.size() + this.f748e);
            int h2 = h(this.f748e + this.f746c);
            int h3 = h(this.f746c + i2);
            int size = elements.size();
            if (i2 < ((this.f748e + 1) >> 1)) {
                int i4 = this.f746c;
                int i5 = i4 - size;
                if (h3 < i4) {
                    Object[] objArr = this.f747d;
                    i.Y(objArr, objArr, i5, i4, objArr.length);
                    if (size >= h3) {
                        Object[] objArr2 = this.f747d;
                        i.Y(objArr2, objArr2, objArr2.length - size, 0, h3);
                    } else {
                        Object[] objArr3 = this.f747d;
                        i.Y(objArr3, objArr3, objArr3.length - size, 0, size);
                        Object[] objArr4 = this.f747d;
                        i.Y(objArr4, objArr4, 0, size, h3);
                    }
                } else if (i5 >= 0) {
                    Object[] objArr5 = this.f747d;
                    i.Y(objArr5, objArr5, i5, i4, h3);
                } else {
                    Object[] objArr6 = this.f747d;
                    i5 += objArr6.length;
                    int i6 = h3 - i4;
                    int length = objArr6.length - i5;
                    if (length >= i6) {
                        i.Y(objArr6, objArr6, i5, i4, h3);
                    } else {
                        i.Y(objArr6, objArr6, i5, i4, i4 + length);
                        Object[] objArr7 = this.f747d;
                        i.Y(objArr7, objArr7, 0, this.f746c + length, h3);
                    }
                }
                this.f746c = i5;
                c(f(h3 - size), elements);
                return true;
            }
            int i7 = h3 + size;
            if (h3 < h2) {
                int i8 = size + h2;
                Object[] objArr8 = this.f747d;
                if (i8 <= objArr8.length) {
                    i.Y(objArr8, objArr8, i7, h3, h2);
                } else if (i7 >= objArr8.length) {
                    i.Y(objArr8, objArr8, i7 - objArr8.length, h3, h2);
                } else {
                    int length2 = h2 - (i8 - objArr8.length);
                    i.Y(objArr8, objArr8, 0, length2, h2);
                    Object[] objArr9 = this.f747d;
                    i.Y(objArr9, objArr9, i7, h3, length2);
                }
            } else {
                Object[] objArr10 = this.f747d;
                i.Y(objArr10, objArr10, size, 0, h2);
                Object[] objArr11 = this.f747d;
                if (i7 >= objArr11.length) {
                    i.Y(objArr11, objArr11, i7 - objArr11.length, h3, objArr11.length);
                } else {
                    i.Y(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f747d;
                    i.Y(objArr12, objArr12, i7, h3, objArr12.length - size);
                }
            }
            c(h3, elements);
            return true;
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    public final void addFirst(Object obj) {
        i();
        d(this.f748e + 1);
        int i2 = this.f746c;
        if (i2 == 0) {
            Object[] objArr = this.f747d;
            kotlin.jvm.internal.h.e(objArr, "<this>");
            i2 = objArr.length;
        }
        int i3 = i2 - 1;
        this.f746c = i3;
        this.f747d[i3] = obj;
        this.f748e++;
    }

    public final void addLast(Object obj) {
        i();
        d(a() + 1);
        this.f747d[h(a() + this.f746c)] = obj;
        this.f748e = a() + 1;
    }

    @Override // R0.f
    public final Object b(int i2) {
        int i3 = this.f748e;
        if (i2 >= 0 && i2 < i3) {
            if (i2 == size() - 1) {
                return removeLast();
            }
            if (i2 == 0) {
                return removeFirst();
            }
            i();
            int h2 = h(this.f746c + i2);
            Object[] objArr = this.f747d;
            Object obj = objArr[h2];
            if (i2 < (this.f748e >> 1)) {
                int i4 = this.f746c;
                if (h2 >= i4) {
                    i.Y(objArr, objArr, i4 + 1, i4, h2);
                } else {
                    i.Y(objArr, objArr, 1, 0, h2);
                    Object[] objArr2 = this.f747d;
                    objArr2[0] = objArr2[objArr2.length - 1];
                    int i5 = this.f746c;
                    i.Y(objArr2, objArr2, i5 + 1, i5, objArr2.length - 1);
                }
                Object[] objArr3 = this.f747d;
                int i6 = this.f746c;
                objArr3[i6] = null;
                this.f746c = e(i6);
            } else {
                int h3 = h((size() - 1) + this.f746c);
                if (h2 <= h3) {
                    Object[] objArr4 = this.f747d;
                    i.Y(objArr4, objArr4, h2, h2 + 1, h3 + 1);
                } else {
                    Object[] objArr5 = this.f747d;
                    i.Y(objArr5, objArr5, h2, h2 + 1, objArr5.length);
                    Object[] objArr6 = this.f747d;
                    objArr6[objArr6.length - 1] = objArr6[0];
                    i.Y(objArr6, objArr6, 0, 1, h3 + 1);
                }
                this.f747d[h3] = null;
            }
            this.f748e--;
            return obj;
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    public final void c(int i2, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f747d.length;
        while (i2 < length && it.hasNext()) {
            this.f747d[i2] = it.next();
            i2++;
        }
        int i3 = this.f746c;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.f747d[i4] = it.next();
        }
        this.f748e = collection.size() + this.f748e;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            i();
            g(this.f746c, h(a() + this.f746c));
        }
        this.f746c = 0;
        this.f748e = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final void d(int i2) {
        if (i2 >= 0) {
            Object[] objArr = this.f747d;
            if (i2 <= objArr.length) {
                return;
            }
            if (objArr == f745f) {
                if (i2 < 10) {
                    i2 = 10;
                }
                this.f747d = new Object[i2];
                return;
            }
            int length = objArr.length;
            int i3 = length + (length >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            if (i3 - 2147483639 > 0) {
                if (i2 > 2147483639) {
                    i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i3 = 2147483639;
                }
            }
            Object[] objArr2 = new Object[i3];
            i.Y(objArr, objArr2, 0, this.f746c, objArr.length);
            Object[] objArr3 = this.f747d;
            int length2 = objArr3.length;
            int i4 = this.f746c;
            i.Y(objArr3, objArr2, length2 - i4, 0, i4);
            this.f746c = 0;
            this.f747d = objArr2;
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    public final int e(int i2) {
        kotlin.jvm.internal.h.e(this.f747d, "<this>");
        if (i2 == r0.length - 1) {
            return 0;
        }
        return i2 + 1;
    }

    public final int f(int i2) {
        if (i2 < 0) {
            return i2 + this.f747d.length;
        }
        return i2;
    }

    public final void g(int i2, int i3) {
        if (i2 < i3) {
            Object[] objArr = this.f747d;
            kotlin.jvm.internal.h.e(objArr, "<this>");
            Arrays.fill(objArr, i2, i3, (Object) null);
        } else {
            Object[] objArr2 = this.f747d;
            Arrays.fill(objArr2, i2, objArr2.length, (Object) null);
            Object[] objArr3 = this.f747d;
            kotlin.jvm.internal.h.e(objArr3, "<this>");
            Arrays.fill(objArr3, 0, i3, (Object) null);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        int a2 = a();
        if (i2 >= 0 && i2 < a2) {
            return this.f747d[h(this.f746c + i2)];
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", a2));
    }

    public final int h(int i2) {
        Object[] objArr = this.f747d;
        if (i2 >= objArr.length) {
            return i2 - objArr.length;
        }
        return i2;
    }

    public final void i() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i2;
        int h2 = h(a() + this.f746c);
        int i3 = this.f746c;
        if (i3 < h2) {
            while (i3 < h2) {
                if (kotlin.jvm.internal.h.a(obj, this.f747d[i3])) {
                    i2 = this.f746c;
                } else {
                    i3++;
                }
            }
            return -1;
        }
        if (i3 >= h2) {
            int length = this.f747d.length;
            while (true) {
                if (i3 < length) {
                    if (kotlin.jvm.internal.h.a(obj, this.f747d[i3])) {
                        i2 = this.f746c;
                        break;
                    }
                    i3++;
                } else {
                    for (int i4 = 0; i4 < h2; i4++) {
                        if (kotlin.jvm.internal.h.a(obj, this.f747d[i4])) {
                            i3 = i4 + this.f747d.length;
                            i2 = this.f746c;
                        }
                    }
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return i3 - i2;
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
        int i2;
        int h2 = h(this.f748e + this.f746c);
        int i3 = this.f746c;
        if (i3 < h2) {
            length = h2 - 1;
            if (i3 <= length) {
                while (!kotlin.jvm.internal.h.a(obj, this.f747d[length])) {
                    if (length != i3) {
                        length--;
                    }
                }
                i2 = this.f746c;
                return length - i2;
            }
            return -1;
        }
        if (i3 > h2) {
            int i4 = h2 - 1;
            while (true) {
                if (-1 < i4) {
                    if (kotlin.jvm.internal.h.a(obj, this.f747d[i4])) {
                        length = i4 + this.f747d.length;
                        i2 = this.f746c;
                        break;
                    }
                    i4--;
                } else {
                    Object[] objArr = this.f747d;
                    kotlin.jvm.internal.h.e(objArr, "<this>");
                    length = objArr.length - 1;
                    int i5 = this.f746c;
                    if (i5 <= length) {
                        while (!kotlin.jvm.internal.h.a(obj, this.f747d[length])) {
                            if (length != i5) {
                                length--;
                            }
                        }
                        i2 = this.f746c;
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
    public final boolean removeAll(Collection elements) {
        int h2;
        kotlin.jvm.internal.h.e(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f747d.length != 0) {
            int h3 = h(this.f748e + this.f746c);
            int i2 = this.f746c;
            if (i2 < h3) {
                h2 = i2;
                while (i2 < h3) {
                    Object obj = this.f747d[i2];
                    if (!elements.contains(obj)) {
                        this.f747d[h2] = obj;
                        h2++;
                    } else {
                        z = true;
                    }
                    i2++;
                }
                Object[] objArr = this.f747d;
                kotlin.jvm.internal.h.e(objArr, "<this>");
                Arrays.fill(objArr, h2, h3, (Object) null);
            } else {
                int length = this.f747d.length;
                boolean z2 = false;
                int i3 = i2;
                while (i2 < length) {
                    Object[] objArr2 = this.f747d;
                    Object obj2 = objArr2[i2];
                    objArr2[i2] = null;
                    if (!elements.contains(obj2)) {
                        this.f747d[i3] = obj2;
                        i3++;
                    } else {
                        z2 = true;
                    }
                    i2++;
                }
                h2 = h(i3);
                for (int i4 = 0; i4 < h3; i4++) {
                    Object[] objArr3 = this.f747d;
                    Object obj3 = objArr3[i4];
                    objArr3[i4] = null;
                    if (!elements.contains(obj3)) {
                        this.f747d[h2] = obj3;
                        h2 = e(h2);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                i();
                this.f748e = f(h2 - this.f746c);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (!isEmpty()) {
            i();
            Object[] objArr = this.f747d;
            int i2 = this.f746c;
            Object obj = objArr[i2];
            objArr[i2] = null;
            this.f746c = e(i2);
            this.f748e = a() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object removeLast() {
        if (!isEmpty()) {
            i();
            int h2 = h((size() - 1) + this.f746c);
            Object[] objArr = this.f747d;
            Object obj = objArr[h2];
            objArr[h2] = null;
            this.f748e = a() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        android.support.v4.media.session.a.d(i2, i3, this.f748e);
        int i4 = i3 - i2;
        if (i4 == 0) {
            return;
        }
        if (i4 == this.f748e) {
            clear();
            return;
        }
        if (i4 == 1) {
            b(i2);
            return;
        }
        i();
        if (i2 < this.f748e - i3) {
            int h2 = h(this.f746c + (i2 - 1));
            int h3 = h(this.f746c + (i3 - 1));
            while (i2 > 0) {
                int i5 = h2 + 1;
                int min = Math.min(i2, Math.min(i5, h3 + 1));
                Object[] objArr = this.f747d;
                int i6 = h3 - min;
                int i7 = h2 - min;
                i.Y(objArr, objArr, i6 + 1, i7 + 1, i5);
                h2 = f(i7);
                h3 = f(i6);
                i2 -= min;
            }
            int h4 = h(this.f746c + i4);
            g(this.f746c, h4);
            this.f746c = h4;
        } else {
            int h5 = h(this.f746c + i3);
            int h6 = h(this.f746c + i2);
            int i8 = this.f748e;
            while (true) {
                i8 -= i3;
                if (i8 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f747d;
                i3 = Math.min(i8, Math.min(objArr2.length - h5, objArr2.length - h6));
                Object[] objArr3 = this.f747d;
                int i9 = h5 + i3;
                i.Y(objArr3, objArr3, h6, h5, i9);
                h5 = h(i9);
                h6 = h(h6 + i3);
            }
            int h7 = h(this.f748e + this.f746c);
            g(f(h7 - i4), h7);
        }
        this.f748e -= i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        int h2;
        kotlin.jvm.internal.h.e(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f747d.length != 0) {
            int h3 = h(this.f748e + this.f746c);
            int i2 = this.f746c;
            if (i2 < h3) {
                h2 = i2;
                while (i2 < h3) {
                    Object obj = this.f747d[i2];
                    if (elements.contains(obj)) {
                        this.f747d[h2] = obj;
                        h2++;
                    } else {
                        z = true;
                    }
                    i2++;
                }
                Object[] objArr = this.f747d;
                kotlin.jvm.internal.h.e(objArr, "<this>");
                Arrays.fill(objArr, h2, h3, (Object) null);
            } else {
                int length = this.f747d.length;
                boolean z2 = false;
                int i3 = i2;
                while (i2 < length) {
                    Object[] objArr2 = this.f747d;
                    Object obj2 = objArr2[i2];
                    objArr2[i2] = null;
                    if (elements.contains(obj2)) {
                        this.f747d[i3] = obj2;
                        i3++;
                    } else {
                        z2 = true;
                    }
                    i2++;
                }
                h2 = h(i3);
                for (int i4 = 0; i4 < h3; i4++) {
                    Object[] objArr3 = this.f747d;
                    Object obj3 = objArr3[i4];
                    objArr3[i4] = null;
                    if (elements.contains(obj3)) {
                        this.f747d[h2] = obj3;
                        h2 = e(h2);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                i();
                this.f748e = f(h2 - this.f746c);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        int a2 = a();
        if (i2 >= 0 && i2 < a2) {
            int h2 = h(this.f746c + i2);
            Object[] objArr = this.f747d;
            Object obj2 = objArr[h2];
            objArr[h2] = obj;
            return obj2;
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", a2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.h.e(array, "array");
        int length = array.length;
        int i2 = this.f748e;
        if (length < i2) {
            Object newInstance = Array.newInstance(array.getClass().getComponentType(), i2);
            kotlin.jvm.internal.h.c(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (Object[]) newInstance;
        }
        int h2 = h(this.f748e + this.f746c);
        int i3 = this.f746c;
        if (i3 < h2) {
            i.Z(this.f747d, array, i3, h2, 2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f747d;
            i.Y(objArr, array, 0, this.f746c, objArr.length);
            Object[] objArr2 = this.f747d;
            i.Y(objArr2, array, objArr2.length - this.f746c, 0, h2);
        }
        int i4 = this.f748e;
        if (i4 < array.length) {
            array[i4] = null;
        }
        return array;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.h.e(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        i();
        d(elements.size() + a());
        c(h(a() + this.f746c), elements);
        return true;
    }
}
