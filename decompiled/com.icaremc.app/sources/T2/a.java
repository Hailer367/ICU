package T2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a implements Iterator, U2.a {

    /* renamed from: f, reason: collision with root package name */
    public final Object[] f1627f;

    /* renamed from: g, reason: collision with root package name */
    public int f1628g;

    public a(Object[] objArr) {
        this.f1627f = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f1628g < this.f1627f.length) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        try {
            Object[] objArr = this.f1627f;
            int i4 = this.f1628g;
            this.f1628g = i4 + 1;
            return objArr[i4];
        } catch (ArrayIndexOutOfBoundsException e4) {
            this.f1628g--;
            throw new NoSuchElementException(e4.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
