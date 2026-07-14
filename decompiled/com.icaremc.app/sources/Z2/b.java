package Z2;

import D2.M;
import T2.h;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator, U2.a {

    /* renamed from: f, reason: collision with root package name */
    public Object f2204f;

    /* renamed from: g, reason: collision with root package name */
    public int f2205g = -2;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f2206h;

    public b(c cVar) {
        this.f2206h = cVar;
    }

    public final void a() {
        Object f4;
        int i4;
        int i5 = this.f2205g;
        c cVar = this.f2206h;
        if (i5 == -2) {
            f4 = cVar.f2207a.a();
        } else {
            M m3 = cVar.f2208b;
            Object obj = this.f2204f;
            h.b(obj);
            f4 = m3.f(obj);
        }
        this.f2204f = f4;
        if (f4 == null) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        this.f2205g = i4;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f2205g < 0) {
            a();
        }
        if (this.f2205g == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f2205g < 0) {
            a();
        }
        if (this.f2205g != 0) {
            Object obj = this.f2204f;
            h.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f2205g = -1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
