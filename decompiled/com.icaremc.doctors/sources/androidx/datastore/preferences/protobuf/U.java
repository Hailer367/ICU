package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class U extends AbstractC0075b implements RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    public static final U f1377f = new U(new Object[0], 0, false);

    /* renamed from: d, reason: collision with root package name */
    public Object[] f1378d;

    /* renamed from: e, reason: collision with root package name */
    public int f1379e;

    public U(Object[] objArr, int i2, boolean z) {
        this.f1400c = z;
        this.f1378d = objArr;
        this.f1379e = i2;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i2 = this.f1379e;
        Object[] objArr = this.f1378d;
        if (i2 == objArr.length) {
            this.f1378d = Arrays.copyOf(objArr, ((i2 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f1378d;
        int i3 = this.f1379e;
        this.f1379e = i3 + 1;
        objArr2[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i2) {
        if (i2 >= 0 && i2 < this.f1379e) {
            return;
        }
        throw new IndexOutOfBoundsException("Index:" + i2 + ", Size:" + this.f1379e);
    }

    public final U c(int i2) {
        if (i2 >= this.f1379e) {
            return new U(Arrays.copyOf(this.f1378d, i2), this.f1379e, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        b(i2);
        return this.f1378d[i2];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0075b, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        a();
        b(i2);
        Object[] objArr = this.f1378d;
        Object obj = objArr[i2];
        if (i2 < this.f1379e - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.f1379e--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        a();
        b(i2);
        Object[] objArr = this.f1378d;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1379e;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        a();
        if (i2 >= 0 && i2 <= (i3 = this.f1379e)) {
            Object[] objArr = this.f1378d;
            if (i3 < objArr.length) {
                System.arraycopy(objArr, i2, objArr, i2 + 1, i3 - i2);
            } else {
                Object[] objArr2 = new Object[((i3 * 3) / 2) + 1];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                System.arraycopy(this.f1378d, i2, objArr2, i2 + 1, this.f1379e - i2);
                this.f1378d = objArr2;
            }
            this.f1378d[i2] = obj;
            this.f1379e++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index:" + i2 + ", Size:" + this.f1379e);
    }
}
