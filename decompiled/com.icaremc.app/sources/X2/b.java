package X2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator, U2.a {

    /* renamed from: f, reason: collision with root package name */
    public final int f2006f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2007g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2008h;

    /* renamed from: i, reason: collision with root package name */
    public int f2009i;

    public b(int i4, int i5, int i6) {
        this.f2006f = i6;
        this.f2007g = i5;
        boolean z = false;
        if (i6 <= 0 ? i4 >= i5 : i4 <= i5) {
            z = true;
        }
        this.f2008h = z;
        this.f2009i = z ? i4 : i5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2008h;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }

    public final int nextInt() {
        int i4 = this.f2009i;
        if (i4 == this.f2007g) {
            if (this.f2008h) {
                this.f2008h = false;
                return i4;
            }
            throw new NoSuchElementException();
        }
        this.f2009i = this.f2006f + i4;
        return i4;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
