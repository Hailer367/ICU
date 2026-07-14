package S0;

import R0.f;
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a implements ListIterator, d1.a {

    /* renamed from: d, reason: collision with root package name */
    public int f754d;

    /* renamed from: f, reason: collision with root package name */
    public int f756f;

    /* renamed from: g, reason: collision with root package name */
    public final f f757g;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f753c = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f755e = -1;

    public a(c cVar, int i2) {
        int i3;
        this.f757g = cVar;
        this.f754d = i2;
        i3 = ((AbstractList) cVar).modCount;
        this.f756f = i3;
    }

    public void a() {
        int i2;
        i2 = ((AbstractList) ((b) this.f757g).f762g).modCount;
        if (i2 == this.f756f) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i2;
        int i3;
        switch (this.f753c) {
            case 0:
                a();
                b bVar = (b) this.f757g;
                int i4 = this.f754d;
                this.f754d = i4 + 1;
                bVar.add(i4, obj);
                this.f755e = -1;
                i2 = ((AbstractList) bVar).modCount;
                this.f756f = i2;
                return;
            default:
                b();
                c cVar = (c) this.f757g;
                int i5 = this.f754d;
                this.f754d = i5 + 1;
                cVar.add(i5, obj);
                this.f755e = -1;
                i3 = ((AbstractList) cVar).modCount;
                this.f756f = i3;
                return;
        }
    }

    public void b() {
        int i2;
        i2 = ((AbstractList) ((c) this.f757g)).modCount;
        if (i2 == this.f756f) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f753c) {
            case 0:
                if (this.f754d < ((b) this.f757g).f760e) {
                    return true;
                }
                return false;
            default:
                if (this.f754d < ((c) this.f757g).f765d) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f753c) {
            case 0:
                if (this.f754d > 0) {
                    return true;
                }
                return false;
            default:
                if (this.f754d > 0) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f753c) {
            case 0:
                a();
                int i2 = this.f754d;
                b bVar = (b) this.f757g;
                if (i2 < bVar.f760e) {
                    this.f754d = i2 + 1;
                    this.f755e = i2;
                    return bVar.f758c[bVar.f759d + i2];
                }
                throw new NoSuchElementException();
            default:
                b();
                int i3 = this.f754d;
                c cVar = (c) this.f757g;
                if (i3 < cVar.f765d) {
                    this.f754d = i3 + 1;
                    this.f755e = i3;
                    return cVar.f764c[i3];
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f753c) {
            case 0:
                return this.f754d;
            default:
                return this.f754d;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f753c) {
            case 0:
                a();
                int i2 = this.f754d;
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    this.f754d = i3;
                    this.f755e = i3;
                    b bVar = (b) this.f757g;
                    return bVar.f758c[bVar.f759d + i3];
                }
                throw new NoSuchElementException();
            default:
                b();
                int i4 = this.f754d;
                if (i4 > 0) {
                    int i5 = i4 - 1;
                    this.f754d = i5;
                    this.f755e = i5;
                    return ((c) this.f757g).f764c[i5];
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i2;
        switch (this.f753c) {
            case 0:
                i2 = this.f754d;
                break;
            default:
                i2 = this.f754d;
                break;
        }
        return i2 - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i2;
        int i3;
        switch (this.f753c) {
            case 0:
                b bVar = (b) this.f757g;
                a();
                int i4 = this.f755e;
                if (i4 != -1) {
                    bVar.b(i4);
                    this.f754d = this.f755e;
                    this.f755e = -1;
                    i2 = ((AbstractList) bVar).modCount;
                    this.f756f = i2;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            default:
                c cVar = (c) this.f757g;
                b();
                int i5 = this.f755e;
                if (i5 != -1) {
                    cVar.b(i5);
                    this.f754d = this.f755e;
                    this.f755e = -1;
                    i3 = ((AbstractList) cVar).modCount;
                    this.f756f = i3;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f753c) {
            case 0:
                a();
                int i2 = this.f755e;
                if (i2 != -1) {
                    ((b) this.f757g).set(i2, obj);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            default:
                b();
                int i3 = this.f755e;
                if (i3 != -1) {
                    ((c) this.f757g).set(i3, obj);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    public a(b bVar, int i2) {
        int i3;
        this.f757g = bVar;
        this.f754d = i2;
        i3 = ((AbstractList) bVar).modCount;
        this.f756f = i3;
    }
}
