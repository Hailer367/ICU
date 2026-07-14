package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class U extends AbstractC0145b implements RandomAccess {

    /* renamed from: i, reason: collision with root package name */
    public static final U f2596i = new U(new Object[0], 0, false);

    /* renamed from: g, reason: collision with root package name */
    public Object[] f2597g;

    /* renamed from: h, reason: collision with root package name */
    public int f2598h;

    public U(Object[] objArr, int i4, boolean z) {
        this.f2618f = z;
        this.f2597g = objArr;
        this.f2598h = i4;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i4 = this.f2598h;
        Object[] objArr = this.f2597g;
        if (i4 == objArr.length) {
            this.f2597g = Arrays.copyOf(objArr, ((i4 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f2597g;
        int i5 = this.f2598h;
        this.f2598h = i5 + 1;
        objArr2[i5] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i4) {
        if (i4 >= 0 && i4 < this.f2598h) {
            return;
        }
        throw new IndexOutOfBoundsException("Index:" + i4 + ", Size:" + this.f2598h);
    }

    public final U c(int i4) {
        if (i4 >= this.f2598h) {
            return new U(Arrays.copyOf(this.f2597g, i4), this.f2598h, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i4) {
        b(i4);
        return this.f2597g[i4];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0145b, java.util.AbstractList, java.util.List
    public final Object remove(int i4) {
        a();
        b(i4);
        Object[] objArr = this.f2597g;
        Object obj = objArr[i4];
        if (i4 < this.f2598h - 1) {
            System.arraycopy(objArr, i4 + 1, objArr, i4, (r2 - i4) - 1);
        }
        this.f2598h--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i4, Object obj) {
        a();
        b(i4);
        Object[] objArr = this.f2597g;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2598h;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i4, Object obj) {
        int i5;
        a();
        if (i4 >= 0 && i4 <= (i5 = this.f2598h)) {
            Object[] objArr = this.f2597g;
            if (i5 < objArr.length) {
                System.arraycopy(objArr, i4, objArr, i4 + 1, i5 - i4);
            } else {
                Object[] objArr2 = new Object[((i5 * 3) / 2) + 1];
                System.arraycopy(objArr, 0, objArr2, 0, i4);
                System.arraycopy(this.f2597g, i4, objArr2, i4 + 1, this.f2598h - i4);
                this.f2597g = objArr2;
            }
            this.f2597g[i4] = obj;
            this.f2598h++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index:" + i4 + ", Size:" + this.f2598h);
    }
}
