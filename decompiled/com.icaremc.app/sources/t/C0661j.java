package t;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import u.AbstractC0665a;

/* renamed from: t.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0661j {

    /* renamed from: f, reason: collision with root package name */
    public int[] f6194f;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f6195g;

    /* renamed from: h, reason: collision with root package name */
    public int f6196h;

    public C0661j(int i4) {
        int[] iArr;
        Object[] objArr;
        if (i4 == 0) {
            iArr = AbstractC0665a.f6206a;
        } else {
            iArr = new int[i4];
        }
        this.f6194f = iArr;
        if (i4 == 0) {
            objArr = AbstractC0665a.f6207b;
        } else {
            objArr = new Object[i4 << 1];
        }
        this.f6195g = objArr;
    }

    public final int a(Object obj) {
        int i4 = this.f6196h * 2;
        Object[] objArr = this.f6195g;
        if (obj == null) {
            for (int i5 = 1; i5 < i4; i5 += 2) {
                if (objArr[i5] == null) {
                    return i5 >> 1;
                }
            }
            return -1;
        }
        for (int i6 = 1; i6 < i4; i6 += 2) {
            if (obj.equals(objArr[i6])) {
                return i6 >> 1;
            }
        }
        return -1;
    }

    public final int b(int i4, Object obj) {
        int i5 = this.f6196h;
        if (i5 == 0) {
            return -1;
        }
        int a4 = AbstractC0665a.a(i5, i4, this.f6194f);
        if (a4 < 0 || T2.h.a(obj, this.f6195g[a4 << 1])) {
            return a4;
        }
        int i6 = a4 + 1;
        while (i6 < i5 && this.f6194f[i6] == i4) {
            if (T2.h.a(obj, this.f6195g[i6 << 1])) {
                return i6;
            }
            i6++;
        }
        for (int i7 = a4 - 1; i7 >= 0 && this.f6194f[i7] == i4; i7--) {
            if (T2.h.a(obj, this.f6195g[i7 << 1])) {
                return i7;
            }
        }
        return ~i6;
    }

    public final int c(Object obj) {
        if (obj == null) {
            return d();
        }
        return b(obj.hashCode(), obj);
    }

    public final void clear() {
        if (this.f6196h > 0) {
            this.f6194f = AbstractC0665a.f6206a;
            this.f6195g = AbstractC0665a.f6207b;
            this.f6196h = 0;
        }
        if (this.f6196h <= 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        if (c(obj) >= 0) {
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

    public final int d() {
        int i4 = this.f6196h;
        if (i4 == 0) {
            return -1;
        }
        int a4 = AbstractC0665a.a(i4, 0, this.f6194f);
        if (a4 < 0 || this.f6195g[a4 << 1] == null) {
            return a4;
        }
        int i5 = a4 + 1;
        while (i5 < i4 && this.f6194f[i5] == 0) {
            if (this.f6195g[i5 << 1] == null) {
                return i5;
            }
            i5++;
        }
        for (int i6 = a4 - 1; i6 >= 0 && this.f6194f[i6] == 0; i6--) {
            if (this.f6195g[i6 << 1] == null) {
                return i6;
            }
        }
        return ~i5;
    }

    public final Object e(int i4) {
        if (i4 >= 0 && i4 < this.f6196h) {
            return this.f6195g[i4 << 1];
        }
        throw new IllegalArgumentException(A2.i.g(i4, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof C0661j) {
                int i4 = this.f6196h;
                if (i4 != ((C0661j) obj).f6196h) {
                    return false;
                }
                C0661j c0661j = (C0661j) obj;
                for (int i5 = 0; i5 < i4; i5++) {
                    Object e4 = e(i5);
                    Object h3 = h(i5);
                    Object obj2 = c0661j.get(e4);
                    if (h3 == null) {
                        if (obj2 != null || !c0661j.containsKey(e4)) {
                            return false;
                        }
                    } else if (!h3.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f6196h != ((Map) obj).size()) {
                return false;
            }
            int i6 = this.f6196h;
            for (int i7 = 0; i7 < i6; i7++) {
                Object e5 = e(i7);
                Object h4 = h(i7);
                Object obj3 = ((Map) obj).get(e5);
                if (h4 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(e5)) {
                        return false;
                    }
                } else if (!h4.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i4) {
        int i5;
        if (i4 >= 0 && i4 < (i5 = this.f6196h)) {
            Object[] objArr = this.f6195g;
            int i6 = i4 << 1;
            Object obj = objArr[i6 + 1];
            if (i5 <= 1) {
                clear();
                return obj;
            }
            int i7 = i5 - 1;
            int[] iArr = this.f6194f;
            int i8 = 8;
            if (iArr.length > 8 && i5 < iArr.length / 3) {
                if (i5 > 8) {
                    i8 = i5 + (i5 >> 1);
                }
                int[] copyOf = Arrays.copyOf(iArr, i8);
                T2.h.d(copyOf, "copyOf(this, newSize)");
                this.f6194f = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.f6195g, i8 << 1);
                T2.h.d(copyOf2, "copyOf(this, newSize)");
                this.f6195g = copyOf2;
                if (i5 == this.f6196h) {
                    if (i4 > 0) {
                        I2.d.V(0, 0, iArr, this.f6194f, i4);
                        I2.d.W(objArr, this.f6195g, 0, 0, i6);
                    }
                    if (i4 < i7) {
                        int i9 = i4 + 1;
                        I2.d.V(i4, i9, iArr, this.f6194f, i5);
                        I2.d.W(objArr, this.f6195g, i6, i9 << 1, i5 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (i4 < i7) {
                    int i10 = i4 + 1;
                    I2.d.V(i4, i10, iArr, iArr, i5);
                    Object[] objArr2 = this.f6195g;
                    I2.d.W(objArr2, objArr2, i6, i10 << 1, i5 << 1);
                }
                Object[] objArr3 = this.f6195g;
                int i11 = i7 << 1;
                objArr3[i11] = null;
                objArr3[i11 + 1] = null;
            }
            if (i5 == this.f6196h) {
                this.f6196h = i7;
                return obj;
            }
            throw new ConcurrentModificationException();
        }
        throw new IllegalArgumentException(A2.i.g(i4, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final Object g(int i4, Object obj) {
        if (i4 >= 0 && i4 < this.f6196h) {
            int i5 = (i4 << 1) + 1;
            Object[] objArr = this.f6195g;
            Object obj2 = objArr[i5];
            objArr[i5] = obj;
            return obj2;
        }
        throw new IllegalArgumentException(A2.i.g(i4, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public Object get(Object obj) {
        int c4 = c(obj);
        if (c4 >= 0) {
            return this.f6195g[(c4 << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int c4 = c(obj);
        if (c4 >= 0) {
            return this.f6195g[(c4 << 1) + 1];
        }
        return obj2;
    }

    public final Object h(int i4) {
        if (i4 >= 0 && i4 < this.f6196h) {
            return this.f6195g[(i4 << 1) + 1];
        }
        throw new IllegalArgumentException(A2.i.g(i4, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final int hashCode() {
        int i4;
        int[] iArr = this.f6194f;
        Object[] objArr = this.f6195g;
        int i5 = this.f6196h;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            Object obj = objArr[i6];
            int i9 = iArr[i7];
            if (obj != null) {
                i4 = obj.hashCode();
            } else {
                i4 = 0;
            }
            i8 += i4 ^ i9;
            i7++;
            i6 += 2;
        }
        return i8;
    }

    public final boolean isEmpty() {
        if (this.f6196h <= 0) {
            return true;
        }
        return false;
    }

    public final Object put(Object obj, Object obj2) {
        int i4;
        int d4;
        int i5 = this.f6196h;
        if (obj != null) {
            i4 = obj.hashCode();
        } else {
            i4 = 0;
        }
        if (obj != null) {
            d4 = b(i4, obj);
        } else {
            d4 = d();
        }
        if (d4 >= 0) {
            int i6 = (d4 << 1) + 1;
            Object[] objArr = this.f6195g;
            Object obj3 = objArr[i6];
            objArr[i6] = obj2;
            return obj3;
        }
        int i7 = ~d4;
        int[] iArr = this.f6194f;
        if (i5 >= iArr.length) {
            int i8 = 8;
            if (i5 >= 8) {
                i8 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i8 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i8);
            T2.h.d(copyOf, "copyOf(this, newSize)");
            this.f6194f = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f6195g, i8 << 1);
            T2.h.d(copyOf2, "copyOf(this, newSize)");
            this.f6195g = copyOf2;
            if (i5 != this.f6196h) {
                throw new ConcurrentModificationException();
            }
        }
        if (i7 < i5) {
            int[] iArr2 = this.f6194f;
            int i9 = i7 + 1;
            I2.d.V(i9, i7, iArr2, iArr2, i5);
            Object[] objArr2 = this.f6195g;
            I2.d.W(objArr2, objArr2, i9 << 1, i7 << 1, this.f6196h << 1);
        }
        int i10 = this.f6196h;
        if (i5 == i10) {
            int[] iArr3 = this.f6194f;
            if (i7 < iArr3.length) {
                iArr3[i7] = i4;
                Object[] objArr3 = this.f6195g;
                int i11 = i7 << 1;
                objArr3[i11] = obj;
                objArr3[i11 + 1] = obj2;
                this.f6196h = i10 + 1;
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
        int c4 = c(obj);
        if (c4 >= 0) {
            return f(c4);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int c4 = c(obj);
        if (c4 >= 0) {
            return g(c4, obj2);
        }
        return null;
    }

    public final int size() {
        return this.f6196h;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6196h * 28);
        sb.append('{');
        int i4 = this.f6196h;
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object e4 = e(i5);
            if (e4 != sb) {
                sb.append(e4);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object h3 = h(i5);
            if (h3 != sb) {
                sb.append(h3);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        T2.h.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public final boolean remove(Object obj, Object obj2) {
        int c4 = c(obj);
        if (c4 < 0 || !T2.h.a(obj2, h(c4))) {
            return false;
        }
        f(c4);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int c4 = c(obj);
        if (c4 < 0 || !T2.h.a(obj2, h(c4))) {
            return false;
        }
        g(c4, obj3);
        return true;
    }
}
