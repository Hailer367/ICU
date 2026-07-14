package r;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import s.AbstractC0298a;

/* renamed from: r.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0294f implements Collection, Set, d1.a {

    /* renamed from: c, reason: collision with root package name */
    public int[] f3562c = AbstractC0298a.f3578a;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f3563d = AbstractC0298a.f3579b;

    /* renamed from: e, reason: collision with root package name */
    public int f3564e;

    public C0294f(int i2) {
        if (i2 > 0) {
            AbstractC0296h.a(this, i2);
        }
    }

    public final Object a(int i2) {
        int i3 = this.f3564e;
        Object[] objArr = this.f3563d;
        Object obj = objArr[i2];
        if (i3 <= 1) {
            clear();
            return obj;
        }
        int i4 = i3 - 1;
        int[] iArr = this.f3562c;
        int i5 = 8;
        if (iArr.length > 8 && i3 < iArr.length / 3) {
            if (i3 > 8) {
                i5 = i3 + (i3 >> 1);
            }
            int[] iArr2 = new int[i5];
            this.f3562c = iArr2;
            this.f3563d = new Object[i5];
            if (i2 > 0) {
                R0.i.X(0, 0, i2, iArr, iArr2);
                R0.i.Z(objArr, this.f3563d, 0, i2, 6);
            }
            if (i2 < i4) {
                int i6 = i2 + 1;
                R0.i.X(i2, i6, i3, iArr, this.f3562c);
                R0.i.Y(objArr, this.f3563d, i2, i6, i3);
            }
        } else {
            if (i2 < i4) {
                int i7 = i2 + 1;
                R0.i.X(i2, i7, i3, iArr, iArr);
                Object[] objArr2 = this.f3563d;
                R0.i.Y(objArr2, objArr2, i2, i7, i3);
            }
            this.f3563d[i4] = null;
        }
        if (i3 == this.f3564e) {
            this.f3564e = i4;
            return obj;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i2;
        int b2;
        int i3 = this.f3564e;
        if (obj == null) {
            b2 = AbstractC0296h.b(this, null, 0);
            i2 = 0;
        } else {
            int hashCode = obj.hashCode();
            i2 = hashCode;
            b2 = AbstractC0296h.b(this, obj, hashCode);
        }
        if (b2 >= 0) {
            return false;
        }
        int i4 = ~b2;
        int[] iArr = this.f3562c;
        if (i3 >= iArr.length) {
            int i5 = 8;
            if (i3 >= 8) {
                i5 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i5 = 4;
            }
            Object[] objArr = this.f3563d;
            int[] iArr2 = new int[i5];
            this.f3562c = iArr2;
            this.f3563d = new Object[i5];
            if (i3 == this.f3564e) {
                if (iArr2.length != 0) {
                    R0.i.X(0, 0, iArr.length, iArr, iArr2);
                    R0.i.Z(objArr, this.f3563d, 0, objArr.length, 6);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i3) {
            int[] iArr3 = this.f3562c;
            int i6 = i4 + 1;
            R0.i.X(i6, i4, i3, iArr3, iArr3);
            Object[] objArr2 = this.f3563d;
            R0.i.Y(objArr2, objArr2, i6, i4, i3);
        }
        int i7 = this.f3564e;
        if (i3 == i7) {
            int[] iArr4 = this.f3562c;
            if (i4 < iArr4.length) {
                iArr4[i4] = i2;
                this.f3563d[i4] = obj;
                this.f3564e = i7 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.h.e(elements, "elements");
        int size = elements.size() + this.f3564e;
        int i2 = this.f3564e;
        int[] iArr = this.f3562c;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.f3563d;
            int[] iArr2 = new int[size];
            this.f3562c = iArr2;
            this.f3563d = new Object[size];
            if (i2 > 0) {
                R0.i.X(0, 0, i2, iArr, iArr2);
                R0.i.Z(objArr, this.f3563d, 0, this.f3564e, 6);
            }
        }
        if (this.f3564e == i2) {
            Iterator it = elements.iterator();
            while (it.hasNext()) {
                z |= add(it.next());
            }
            return z;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f3564e != 0) {
            this.f3562c = AbstractC0298a.f3578a;
            this.f3563d = AbstractC0298a.f3579b;
            this.f3564e = 0;
        }
        if (this.f3564e == 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int b2;
        if (obj == null) {
            b2 = AbstractC0296h.b(this, null, 0);
        } else {
            b2 = AbstractC0296h.b(this, obj, obj.hashCode());
        }
        if (b2 < 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection elements) {
        kotlin.jvm.internal.h.e(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.f3564e != ((Set) obj).size()) {
            return false;
        }
        try {
            int i2 = this.f3564e;
            for (int i3 = 0; i3 < i2; i3++) {
                if (!((Set) obj).contains(this.f3563d[i3])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f3562c;
        int i2 = this.f3564e;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        if (this.f3564e <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C0289a(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int b2;
        if (obj == null) {
            b2 = AbstractC0296h.b(this, null, 0);
        } else {
            b2 = AbstractC0296h.b(this, obj, obj.hashCode());
        }
        if (b2 < 0) {
            return false;
        }
        a(b2);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        kotlin.jvm.internal.h.e(elements, "elements");
        Iterator it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        kotlin.jvm.internal.h.e(elements, "elements");
        boolean z = false;
        for (int i2 = this.f3564e - 1; -1 < i2; i2--) {
            if (!R0.j.Q(elements, this.f3563d[i2])) {
                a(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f3564e;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return R0.i.a0(this.f3563d, 0, this.f3564e);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3564e * 14);
        sb.append('{');
        int i2 = this.f3564e;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = this.f3563d[i3];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.h.e(array, "array");
        int i2 = this.f3564e;
        if (array.length < i2) {
            array = (Object[]) Array.newInstance(array.getClass().getComponentType(), i2);
        } else if (array.length > i2) {
            array[i2] = null;
        }
        R0.i.Y(this.f3563d, array, 0, 0, this.f3564e);
        return array;
    }
}
