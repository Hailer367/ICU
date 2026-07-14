package J2;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a implements ListIterator, U2.a {

    /* renamed from: g, reason: collision with root package name */
    public int f889g;

    /* renamed from: i, reason: collision with root package name */
    public int f891i;

    /* renamed from: j, reason: collision with root package name */
    public final I2.a f892j;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f888f = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f890h = -1;

    public a(c cVar, int i4) {
        int i5;
        this.f892j = cVar;
        this.f889g = i4;
        i5 = ((AbstractList) cVar).modCount;
        this.f891i = i5;
    }

    public void a() {
        int i4;
        i4 = ((AbstractList) ((b) this.f892j).f897j).modCount;
        if (i4 == this.f891i) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i4;
        int i5;
        switch (this.f888f) {
            case 0:
                a();
                b bVar = (b) this.f892j;
                int i6 = this.f889g;
                this.f889g = i6 + 1;
                bVar.add(i6, obj);
                this.f890h = -1;
                i4 = ((AbstractList) bVar).modCount;
                this.f891i = i4;
                return;
            default:
                b();
                c cVar = (c) this.f892j;
                int i7 = this.f889g;
                this.f889g = i7 + 1;
                cVar.add(i7, obj);
                this.f890h = -1;
                i5 = ((AbstractList) cVar).modCount;
                this.f891i = i5;
                return;
        }
    }

    public void b() {
        int i4;
        i4 = ((AbstractList) ((c) this.f892j)).modCount;
        if (i4 == this.f891i) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f888f) {
            case 0:
                if (this.f889g < ((b) this.f892j).f895h) {
                    return true;
                }
                return false;
            default:
                if (this.f889g < ((c) this.f892j).f900g) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f888f) {
            case 0:
                if (this.f889g > 0) {
                    return true;
                }
                return false;
            default:
                if (this.f889g > 0) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f888f) {
            case 0:
                a();
                int i4 = this.f889g;
                b bVar = (b) this.f892j;
                if (i4 < bVar.f895h) {
                    this.f889g = i4 + 1;
                    this.f890h = i4;
                    return bVar.f893f[bVar.f894g + i4];
                }
                throw new NoSuchElementException();
            default:
                b();
                int i5 = this.f889g;
                c cVar = (c) this.f892j;
                if (i5 < cVar.f900g) {
                    this.f889g = i5 + 1;
                    this.f890h = i5;
                    return cVar.f899f[i5];
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f888f) {
            case 0:
                return this.f889g;
            default:
                return this.f889g;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f888f) {
            case 0:
                a();
                int i4 = this.f889g;
                if (i4 > 0) {
                    int i5 = i4 - 1;
                    this.f889g = i5;
                    this.f890h = i5;
                    b bVar = (b) this.f892j;
                    return bVar.f893f[bVar.f894g + i5];
                }
                throw new NoSuchElementException();
            default:
                b();
                int i6 = this.f889g;
                if (i6 > 0) {
                    int i7 = i6 - 1;
                    this.f889g = i7;
                    this.f890h = i7;
                    return ((c) this.f892j).f899f[i7];
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i4;
        switch (this.f888f) {
            case 0:
                i4 = this.f889g;
                break;
            default:
                i4 = this.f889g;
                break;
        }
        return i4 - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i4;
        int i5;
        switch (this.f888f) {
            case 0:
                b bVar = (b) this.f892j;
                a();
                int i6 = this.f890h;
                if (i6 != -1) {
                    bVar.b(i6);
                    this.f889g = this.f890h;
                    this.f890h = -1;
                    i4 = ((AbstractList) bVar).modCount;
                    this.f891i = i4;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            default:
                c cVar = (c) this.f892j;
                b();
                int i7 = this.f890h;
                if (i7 != -1) {
                    cVar.b(i7);
                    this.f889g = this.f890h;
                    this.f890h = -1;
                    i5 = ((AbstractList) cVar).modCount;
                    this.f891i = i5;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f888f) {
            case 0:
                a();
                int i4 = this.f890h;
                if (i4 != -1) {
                    ((b) this.f892j).set(i4, obj);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            default:
                b();
                int i5 = this.f890h;
                if (i5 != -1) {
                    ((c) this.f892j).set(i5, obj);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    public a(b bVar, int i4) {
        int i5;
        this.f892j = bVar;
        this.f889g = i4;
        i5 = ((AbstractList) bVar).modCount;
        this.f891i = i5;
    }
}
