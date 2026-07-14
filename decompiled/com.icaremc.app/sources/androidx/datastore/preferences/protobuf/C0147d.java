package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0147d implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public int f2623f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final int f2624g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C0150g f2625h;

    public C0147d(C0150g c0150g) {
        this.f2625h = c0150g;
        this.f2624g = c0150g.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f2623f < this.f2624g) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i4 = this.f2623f;
        if (i4 < this.f2624g) {
            this.f2623f = i4 + 1;
            return Byte.valueOf(this.f2625h.f(i4));
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
