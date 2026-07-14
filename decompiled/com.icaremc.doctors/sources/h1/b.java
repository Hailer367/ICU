package h1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator, d1.a {

    /* renamed from: c, reason: collision with root package name */
    public final int f2324c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2325d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2326e;

    /* renamed from: f, reason: collision with root package name */
    public int f2327f;

    public b(int i2, int i3, int i4) {
        this.f2324c = i4;
        this.f2325d = i3;
        boolean z = false;
        if (i4 <= 0 ? i2 >= i3 : i2 <= i3) {
            z = true;
        }
        this.f2326e = z;
        this.f2327f = z ? i2 : i3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2326e;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }

    public final int nextInt() {
        int i2 = this.f2327f;
        if (i2 == this.f2325d) {
            if (this.f2326e) {
                this.f2326e = false;
                return i2;
            }
            throw new NoSuchElementException();
        }
        this.f2327f = this.f2324c + i2;
        return i2;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
