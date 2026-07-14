package j1;

import a.AbstractC0141a;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements ListIterator, Iterator {

    /* renamed from: f, reason: collision with root package name */
    public final int f5040f;

    /* renamed from: g, reason: collision with root package name */
    public int f5041g;

    /* renamed from: h, reason: collision with root package name */
    public final e f5042h;

    public b(e eVar, int i4) {
        int size = eVar.size();
        if (i4 >= 0 && i4 <= size) {
            this.f5040f = size;
            this.f5041g = i4;
            this.f5042h = eVar;
            return;
        }
        throw new IndexOutOfBoundsException(AbstractC0141a.U(i4, "index", size));
    }

    public final Object a(int i4) {
        return this.f5042h.get(i4);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        if (this.f5041g < this.f5040f) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f5041g > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            int i4 = this.f5041g;
            this.f5041g = i4 + 1;
            return a(i4);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f5041g;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i4 = this.f5041g - 1;
            this.f5041g = i4;
            return a(i4);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f5041g - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
