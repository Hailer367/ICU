package t;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import u.AbstractC0665a;

/* renamed from: t.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0657f implements Collection, Set, U2.a {

    /* renamed from: f, reason: collision with root package name */
    public int[] f6179f = AbstractC0665a.f6206a;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f6180g = AbstractC0665a.f6207b;

    /* renamed from: h, reason: collision with root package name */
    public int f6181h;

    public C0657f(int i4) {
        if (i4 > 0) {
            AbstractC0659h.a(this, i4);
        }
    }

    public final Object a(int i4) {
        int i5 = this.f6181h;
        Object[] objArr = this.f6180g;
        Object obj = objArr[i4];
        if (i5 <= 1) {
            clear();
            return obj;
        }
        int i6 = i5 - 1;
        int[] iArr = this.f6179f;
        int i7 = 8;
        if (iArr.length > 8 && i5 < iArr.length / 3) {
            if (i5 > 8) {
                i7 = i5 + (i5 >> 1);
            }
            int[] iArr2 = new int[i7];
            this.f6179f = iArr2;
            this.f6180g = new Object[i7];
            if (i4 > 0) {
                I2.d.V(0, 0, iArr, iArr2, i4);
                I2.d.X(objArr, this.f6180g, 0, i4, 6);
            }
            if (i4 < i6) {
                int i8 = i4 + 1;
                I2.d.V(i4, i8, iArr, this.f6179f, i5);
                I2.d.W(objArr, this.f6180g, i4, i8, i5);
            }
        } else {
            if (i4 < i6) {
                int i9 = i4 + 1;
                I2.d.V(i4, i9, iArr, iArr, i5);
                Object[] objArr2 = this.f6180g;
                I2.d.W(objArr2, objArr2, i4, i9, i5);
            }
            this.f6180g[i6] = null;
        }
        if (i5 == this.f6181h) {
            this.f6181h = i6;
            return obj;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i4;
        int b4;
        int i5 = this.f6181h;
        if (obj == null) {
            b4 = AbstractC0659h.b(this, null, 0);
            i4 = 0;
        } else {
            int hashCode = obj.hashCode();
            i4 = hashCode;
            b4 = AbstractC0659h.b(this, obj, hashCode);
        }
        if (b4 >= 0) {
            return false;
        }
        int i6 = ~b4;
        int[] iArr = this.f6179f;
        if (i5 >= iArr.length) {
            int i7 = 8;
            if (i5 >= 8) {
                i7 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i7 = 4;
            }
            Object[] objArr = this.f6180g;
            int[] iArr2 = new int[i7];
            this.f6179f = iArr2;
            this.f6180g = new Object[i7];
            if (i5 == this.f6181h) {
                if (iArr2.length != 0) {
                    I2.d.V(0, 0, iArr, iArr2, iArr.length);
                    I2.d.X(objArr, this.f6180g, 0, objArr.length, 6);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 < i5) {
            int[] iArr3 = this.f6179f;
            int i8 = i6 + 1;
            I2.d.V(i8, i6, iArr3, iArr3, i5);
            Object[] objArr2 = this.f6180g;
            I2.d.W(objArr2, objArr2, i8, i6, i5);
        }
        int i9 = this.f6181h;
        if (i5 == i9) {
            int[] iArr4 = this.f6179f;
            if (i6 < iArr4.length) {
                iArr4[i6] = i4;
                this.f6180g[i6] = obj;
                this.f6181h = i9 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        T2.h.e(collection, "elements");
        int size = collection.size() + this.f6181h;
        int i4 = this.f6181h;
        int[] iArr = this.f6179f;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.f6180g;
            int[] iArr2 = new int[size];
            this.f6179f = iArr2;
            this.f6180g = new Object[size];
            if (i4 > 0) {
                I2.d.V(0, 0, iArr, iArr2, i4);
                I2.d.X(objArr, this.f6180g, 0, this.f6181h, 6);
            }
        }
        if (this.f6181h == i4) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                z |= add(it.next());
            }
            return z;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f6181h != 0) {
            this.f6179f = AbstractC0665a.f6206a;
            this.f6180g = AbstractC0665a.f6207b;
            this.f6181h = 0;
        }
        if (this.f6181h == 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int b4;
        if (obj == null) {
            b4 = AbstractC0659h.b(this, null, 0);
        } else {
            b4 = AbstractC0659h.b(this, obj, obj.hashCode());
        }
        if (b4 < 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        T2.h.e(collection, "elements");
        Iterator it = collection.iterator();
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
        if (!(obj instanceof Set) || this.f6181h != ((Set) obj).size()) {
            return false;
        }
        try {
            int i4 = this.f6181h;
            for (int i5 = 0; i5 < i4; i5++) {
                if (!((Set) obj).contains(this.f6180g[i5])) {
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
        int[] iArr = this.f6179f;
        int i4 = this.f6181h;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += iArr[i6];
        }
        return i5;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        if (this.f6181h <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C0652a(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int b4;
        if (obj == null) {
            b4 = AbstractC0659h.b(this, null, 0);
        } else {
            b4 = AbstractC0659h.b(this, obj, obj.hashCode());
        }
        if (b4 < 0) {
            return false;
        }
        a(b4);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        T2.h.e(collection, "elements");
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        T2.h.e(collection, "elements");
        boolean z = false;
        for (int i4 = this.f6181h - 1; -1 < i4; i4--) {
            if (!collection.contains(this.f6180g[i4])) {
                a(i4);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f6181h;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return I2.d.Y(this.f6180g, 0, this.f6181h);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6181h * 14);
        sb.append('{');
        int i4 = this.f6181h;
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object obj = this.f6180g[i5];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        T2.h.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        T2.h.e(objArr, "array");
        int i4 = this.f6181h;
        if (objArr.length < i4) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i4);
        } else if (objArr.length > i4) {
            objArr[i4] = null;
        }
        I2.d.W(this.f6180g, objArr, 0, 0, this.f6181h);
        return objArr;
    }
}
