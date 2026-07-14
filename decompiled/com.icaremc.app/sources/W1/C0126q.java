package W1;

import b2.C0224b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: W1.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0126q extends C0224b {

    /* renamed from: w, reason: collision with root package name */
    public static final C0125p f1954w = new C0125p();

    /* renamed from: x, reason: collision with root package name */
    public static final T1.l f1955x = new T1.l("closed");

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f1956t;

    /* renamed from: u, reason: collision with root package name */
    public String f1957u;

    /* renamed from: v, reason: collision with root package name */
    public T1.h f1958v;

    public C0126q() {
        super(f1954w);
        this.f1956t = new ArrayList();
        this.f1958v = T1.j.f1620f;
    }

    @Override // b2.C0224b
    public final void b() {
        T1.f fVar = new T1.f();
        v(fVar);
        this.f1956t.add(fVar);
    }

    @Override // b2.C0224b
    public final void c() {
        T1.k kVar = new T1.k();
        v(kVar);
        this.f1956t.add(kVar);
    }

    @Override // b2.C0224b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ArrayList arrayList = this.f1956t;
        if (arrayList.isEmpty()) {
            arrayList.add(f1955x);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // b2.C0224b
    public final void e() {
        ArrayList arrayList = this.f1956t;
        if (!arrayList.isEmpty() && this.f1957u == null) {
            if (u() instanceof T1.f) {
                arrayList.remove(arrayList.size() - 1);
                return;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // b2.C0224b
    public final void f() {
        ArrayList arrayList = this.f1956t;
        if (!arrayList.isEmpty() && this.f1957u == null) {
            if (u() instanceof T1.k) {
                arrayList.remove(arrayList.size() - 1);
                return;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // b2.C0224b
    public final void g(String str) {
        Objects.requireNonNull(str, "name == null");
        if (!this.f1956t.isEmpty() && this.f1957u == null) {
            if (u() instanceof T1.k) {
                this.f1957u = str;
                return;
            }
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        throw new IllegalStateException("Did not expect a name");
    }

    @Override // b2.C0224b
    public final C0224b i() {
        v(T1.j.f1620f);
        return this;
    }

    @Override // b2.C0224b
    public final void n(double d4) {
        if (this.f3232m == 1 || (!Double.isNaN(d4) && !Double.isInfinite(d4))) {
            v(new T1.l(Double.valueOf(d4)));
        } else {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d4);
        }
    }

    @Override // b2.C0224b
    public final void o(long j4) {
        v(new T1.l(Long.valueOf(j4)));
    }

    @Override // b2.C0224b
    public final void p(Boolean bool) {
        if (bool == null) {
            v(T1.j.f1620f);
        } else {
            v(new T1.l(bool));
        }
    }

    @Override // b2.C0224b
    public final void q(Number number) {
        if (number == null) {
            v(T1.j.f1620f);
            return;
        }
        if (this.f3232m != 1) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        v(new T1.l(number));
    }

    @Override // b2.C0224b
    public final void r(String str) {
        if (str == null) {
            v(T1.j.f1620f);
        } else {
            v(new T1.l(str));
        }
    }

    @Override // b2.C0224b
    public final void s(boolean z) {
        v(new T1.l(Boolean.valueOf(z)));
    }

    public final T1.h u() {
        return (T1.h) this.f1956t.get(r0.size() - 1);
    }

    public final void v(T1.h hVar) {
        if (this.f1957u != null) {
            if (!(hVar instanceof T1.j) || this.f3235p) {
                T1.k kVar = (T1.k) u();
                kVar.f1621f.put(this.f1957u, hVar);
            }
            this.f1957u = null;
            return;
        }
        if (this.f1956t.isEmpty()) {
            this.f1958v = hVar;
            return;
        }
        T1.h u3 = u();
        if (u3 instanceof T1.f) {
            ((T1.f) u3).f1619f.add(hVar);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // b2.C0224b, java.io.Flushable
    public final void flush() {
    }
}
