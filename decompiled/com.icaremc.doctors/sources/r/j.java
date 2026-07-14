package r;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import s.AbstractC0298a;

/* loaded from: classes.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    public int[] f3571c;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f3572d;

    /* renamed from: e, reason: collision with root package name */
    public int f3573e;

    public j(int i2) {
        int[] iArr;
        Object[] objArr;
        if (i2 == 0) {
            iArr = AbstractC0298a.f3578a;
        } else {
            iArr = new int[i2];
        }
        this.f3571c = iArr;
        if (i2 == 0) {
            objArr = AbstractC0298a.f3579b;
        } else {
            objArr = new Object[i2 << 1];
        }
        this.f3572d = objArr;
    }

    public final int a(Object obj) {
        int i2 = this.f3573e * 2;
        Object[] objArr = this.f3572d;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i2) {
        int i3 = this.f3573e;
        int[] iArr = this.f3571c;
        if (iArr.length < i2) {
            int[] copyOf = Arrays.copyOf(iArr, i2);
            kotlin.jvm.internal.h.d(copyOf, "copyOf(this, newSize)");
            this.f3571c = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f3572d, i2 * 2);
            kotlin.jvm.internal.h.d(copyOf2, "copyOf(this, newSize)");
            this.f3572d = copyOf2;
        }
        if (this.f3573e == i3) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i2, Object obj) {
        int i3 = this.f3573e;
        if (i3 == 0) {
            return -1;
        }
        int a2 = AbstractC0298a.a(i3, i2, this.f3571c);
        if (a2 < 0 || kotlin.jvm.internal.h.a(obj, this.f3572d[a2 << 1])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f3571c[i4] == i2) {
            if (kotlin.jvm.internal.h.a(obj, this.f3572d[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a2 - 1; i5 >= 0 && this.f3571c[i5] == i2; i5--) {
            if (kotlin.jvm.internal.h.a(obj, this.f3572d[i5 << 1])) {
                return i5;
            }
        }
        return ~i4;
    }

    public final void clear() {
        if (this.f3573e > 0) {
            this.f3571c = AbstractC0298a.f3578a;
            this.f3572d = AbstractC0298a.f3579b;
            this.f3573e = 0;
        }
        if (this.f3573e <= 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        if (d(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (a(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final int d(Object obj) {
        if (obj == null) {
            return e();
        }
        return c(obj.hashCode(), obj);
    }

    public final int e() {
        int i2 = this.f3573e;
        if (i2 == 0) {
            return -1;
        }
        int a2 = AbstractC0298a.a(i2, 0, this.f3571c);
        if (a2 < 0 || this.f3572d[a2 << 1] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f3571c[i3] == 0) {
            if (this.f3572d[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f3571c[i4] == 0; i4--) {
            if (this.f3572d[i4 << 1] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof j) {
                int i2 = this.f3573e;
                if (i2 != ((j) obj).f3573e) {
                    return false;
                }
                j jVar = (j) obj;
                for (int i3 = 0; i3 < i2; i3++) {
                    Object f2 = f(i3);
                    Object i4 = i(i3);
                    Object obj2 = jVar.get(f2);
                    if (i4 == null) {
                        if (obj2 != null || !jVar.containsKey(f2)) {
                            return false;
                        }
                    } else if (!i4.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f3573e != ((Map) obj).size()) {
                return false;
            }
            int i5 = this.f3573e;
            for (int i6 = 0; i6 < i5; i6++) {
                Object f3 = f(i6);
                Object i7 = i(i6);
                Object obj3 = ((Map) obj).get(f3);
                if (i7 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(f3)) {
                        return false;
                    }
                } else if (!i7.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i2) {
        if (i2 >= 0 && i2 < this.f3573e) {
            return this.f3572d[i2 << 1];
        }
        throw new IllegalArgumentException(O.a.c(i2, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final Object g(int i2) {
        int i3;
        if (i2 >= 0 && i2 < (i3 = this.f3573e)) {
            Object[] objArr = this.f3572d;
            int i4 = i2 << 1;
            Object obj = objArr[i4 + 1];
            if (i3 <= 1) {
                clear();
                return obj;
            }
            int i5 = i3 - 1;
            int[] iArr = this.f3571c;
            int i6 = 8;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                int[] copyOf = Arrays.copyOf(iArr, i6);
                kotlin.jvm.internal.h.d(copyOf, "copyOf(this, newSize)");
                this.f3571c = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.f3572d, i6 << 1);
                kotlin.jvm.internal.h.d(copyOf2, "copyOf(this, newSize)");
                this.f3572d = copyOf2;
                if (i3 == this.f3573e) {
                    if (i2 > 0) {
                        R0.i.X(0, 0, i2, iArr, this.f3571c);
                        R0.i.Y(objArr, this.f3572d, 0, 0, i4);
                    }
                    if (i2 < i5) {
                        int i7 = i2 + 1;
                        R0.i.X(i2, i7, i3, iArr, this.f3571c);
                        R0.i.Y(objArr, this.f3572d, i4, i7 << 1, i3 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (i2 < i5) {
                    int i8 = i2 + 1;
                    R0.i.X(i2, i8, i3, iArr, iArr);
                    Object[] objArr2 = this.f3572d;
                    R0.i.Y(objArr2, objArr2, i4, i8 << 1, i3 << 1);
                }
                Object[] objArr3 = this.f3572d;
                int i9 = i5 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            }
            if (i3 == this.f3573e) {
                this.f3573e = i5;
                return obj;
            }
            throw new ConcurrentModificationException();
        }
        throw new IllegalArgumentException(O.a.c(i2, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public Object get(Object obj) {
        int d2 = d(obj);
        if (d2 >= 0) {
            return this.f3572d[(d2 << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int d2 = d(obj);
        if (d2 >= 0) {
            return this.f3572d[(d2 << 1) + 1];
        }
        return obj2;
    }

    public final Object h(int i2, Object obj) {
        if (i2 >= 0 && i2 < this.f3573e) {
            int i3 = (i2 << 1) + 1;
            Object[] objArr = this.f3572d;
            Object obj2 = objArr[i3];
            objArr[i3] = obj;
            return obj2;
        }
        throw new IllegalArgumentException(O.a.c(i2, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final int hashCode() {
        int i2;
        int[] iArr = this.f3571c;
        Object[] objArr = this.f3572d;
        int i3 = this.f3573e;
        int i4 = 1;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            Object obj = objArr[i4];
            int i7 = iArr[i5];
            if (obj != null) {
                i2 = obj.hashCode();
            } else {
                i2 = 0;
            }
            i6 += i2 ^ i7;
            i5++;
            i4 += 2;
        }
        return i6;
    }

    public final Object i(int i2) {
        if (i2 >= 0 && i2 < this.f3573e) {
            return this.f3572d[(i2 << 1) + 1];
        }
        throw new IllegalArgumentException(O.a.c(i2, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final boolean isEmpty() {
        if (this.f3573e <= 0) {
            return true;
        }
        return false;
    }

    public final Object put(Object obj, Object obj2) {
        int i2;
        int e2;
        int i3 = this.f3573e;
        if (obj != null) {
            i2 = obj.hashCode();
        } else {
            i2 = 0;
        }
        if (obj != null) {
            e2 = c(i2, obj);
        } else {
            e2 = e();
        }
        if (e2 >= 0) {
            int i4 = (e2 << 1) + 1;
            Object[] objArr = this.f3572d;
            Object obj3 = objArr[i4];
            objArr[i4] = obj2;
            return obj3;
        }
        int i5 = ~e2;
        int[] iArr = this.f3571c;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i6);
            kotlin.jvm.internal.h.d(copyOf, "copyOf(this, newSize)");
            this.f3571c = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f3572d, i6 << 1);
            kotlin.jvm.internal.h.d(copyOf2, "copyOf(this, newSize)");
            this.f3572d = copyOf2;
            if (i3 != this.f3573e) {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr2 = this.f3571c;
            int i7 = i5 + 1;
            R0.i.X(i7, i5, i3, iArr2, iArr2);
            Object[] objArr2 = this.f3572d;
            R0.i.Y(objArr2, objArr2, i7 << 1, i5 << 1, this.f3573e << 1);
        }
        int i8 = this.f3573e;
        if (i3 == i8) {
            int[] iArr3 = this.f3571c;
            if (i5 < iArr3.length) {
                iArr3[i5] = i2;
                Object[] objArr3 = this.f3572d;
                int i9 = i5 << 1;
                objArr3[i9] = obj;
                objArr3[i9 + 1] = obj2;
                this.f3573e = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        if (obj3 == null) {
            return put(obj, obj2);
        }
        return obj3;
    }

    public Object remove(Object obj) {
        int d2 = d(obj);
        if (d2 >= 0) {
            return g(d2);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int d2 = d(obj);
        if (d2 >= 0) {
            return h(d2, obj2);
        }
        return null;
    }

    public final int size() {
        return this.f3573e;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3573e * 28);
        sb.append('{');
        int i2 = this.f3573e;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object f2 = f(i3);
            if (f2 != sb) {
                sb.append(f2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object i4 = i(i3);
            if (i4 != sb) {
                sb.append(i4);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public final boolean remove(Object obj, Object obj2) {
        int d2 = d(obj);
        if (d2 < 0 || !kotlin.jvm.internal.h.a(obj2, i(d2))) {
            return false;
        }
        g(d2);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int d2 = d(obj);
        if (d2 < 0 || !kotlin.jvm.internal.h.a(obj2, i(d2))) {
            return false;
        }
        h(d2, obj3);
        return true;
    }
}
