package t;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: t.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0655d implements Collection {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0656e f6176f;

    public C0655d(C0656e c0656e) {
        this.f6176f = c0656e;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f6176f.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (this.f6176f.a(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f6176f.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C0652a(this.f6176f, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        C0656e c0656e = this.f6176f;
        int a4 = c0656e.a(obj);
        if (a4 >= 0) {
            c0656e.f(a4);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        C0656e c0656e = this.f6176f;
        int i4 = c0656e.f6196h;
        int i5 = 0;
        boolean z = false;
        while (i5 < i4) {
            if (collection.contains(c0656e.h(i5))) {
                c0656e.f(i5);
                i5--;
                i4--;
                z = true;
            }
            i5++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        C0656e c0656e = this.f6176f;
        int i4 = c0656e.f6196h;
        int i5 = 0;
        boolean z = false;
        while (i5 < i4) {
            if (!collection.contains(c0656e.h(i5))) {
                c0656e.f(i5);
                i5--;
                i4--;
                z = true;
            }
            i5++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f6176f.f6196h;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        C0656e c0656e = this.f6176f;
        int i4 = c0656e.f6196h;
        Object[] objArr = new Object[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = c0656e.h(i5);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        C0656e c0656e = this.f6176f;
        int i4 = c0656e.f6196h;
        if (objArr.length < i4) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i4);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = c0656e.h(i5);
        }
        if (objArr.length > i4) {
            objArr[i4] = null;
        }
        return objArr;
    }
}
