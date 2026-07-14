package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0077d implements Iterator {

    /* renamed from: c, reason: collision with root package name */
    public int f1405c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final int f1406d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0080g f1407e;

    public C0077d(C0080g c0080g) {
        this.f1407e = c0080g;
        this.f1406d = c0080g.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f1405c < this.f1406d) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f1405c;
        if (i2 < this.f1406d) {
            this.f1405c = i2 + 1;
            return Byte.valueOf(this.f1407e.f(i2));
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
