package j1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class b implements Iterator, d1.a {

    /* renamed from: c, reason: collision with root package name */
    public Object f2732c;

    /* renamed from: d, reason: collision with root package name */
    public int f2733d = -2;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c f2734e;

    public b(c cVar) {
        this.f2734e = cVar;
    }

    public final void a() {
        Object invoke;
        int i2 = this.f2733d;
        c cVar = this.f2734e;
        if (i2 == -2) {
            invoke = cVar.f2735a.invoke();
        } else {
            R0.a aVar = cVar.f2736b;
            Object obj = this.f2732c;
            h.b(obj);
            invoke = aVar.invoke(obj);
        }
        this.f2732c = invoke;
        this.f2733d = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f2733d < 0) {
            a();
        }
        if (this.f2733d == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f2733d < 0) {
            a();
        }
        if (this.f2733d != 0) {
            Object obj = this.f2732c;
            h.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f2733d = -1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
