package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class q extends AbstractC0208d {
    private static final long serialVersionUID = -5207853542612002020L;

    /* renamed from: a, reason: collision with root package name */
    public final transient o f2517a;

    /* renamed from: b, reason: collision with root package name */
    public final transient int f2518b;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f2519c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f2520d;

    @Override // j$.time.chrono.InterfaceC0206b
    public final InterfaceC0209e L(j$.time.l lVar) {
        return new C0211g(this, lVar);
    }

    public q(o oVar, int i2, int i3, int i4) {
        oVar.Z(i2, i3, i4);
        this.f2517a = oVar;
        this.f2518b = i2;
        this.f2519c = i3;
        this.f2520d = i4;
    }

    public q(o oVar, long j2) {
        int i2 = (int) j2;
        oVar.X();
        if (i2 < oVar.f2509e || i2 >= oVar.f2510f) {
            throw new RuntimeException("Hijrah date out of range");
        }
        int binarySearch = Arrays.binarySearch(oVar.f2508d, i2);
        binarySearch = binarySearch < 0 ? (-binarySearch) - 2 : binarySearch;
        int i3 = oVar.f2511g;
        int[] iArr = {(binarySearch + i3) / 12, ((i3 + binarySearch) % 12) + 1, (i2 - oVar.f2508d[binarySearch]) + 1};
        this.f2517a = oVar;
        this.f2518b = iArr[0];
        this.f2519c = iArr[1];
        this.f2520d = iArr[2];
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final l f() {
        return this.f2517a;
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final m N() {
        return r.AH;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (h(qVar)) {
                j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
                int i2 = p.f2516a[aVar.ordinal()];
                if (i2 == 1) {
                    return j$.time.temporal.u.f(1L, this.f2517a.a0(this.f2518b, this.f2519c));
                }
                if (i2 == 2) {
                    return j$.time.temporal.u.f(1L, this.f2517a.c0(this.f2518b, 12));
                }
                if (i2 == 3) {
                    return j$.time.temporal.u.f(1L, 5L);
                }
                return this.f2517a.y(aVar);
            }
            throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            switch (p.f2516a[((j$.time.temporal.a) qVar).ordinal()]) {
                case 1:
                    return this.f2520d;
                case 2:
                    return P();
                case 3:
                    return ((this.f2520d - 1) / 7) + 1;
                case 4:
                    return ((int) Math.floorMod(K() + 3, 7)) + 1;
                case 5:
                    return ((this.f2520d - 1) % 7) + 1;
                case 6:
                    return ((P() - 1) % 7) + 1;
                case 7:
                    return K();
                case 8:
                    return ((P() - 1) / 7) + 1;
                case 9:
                    return this.f2519c;
                case 10:
                    return ((this.f2518b * 12) + this.f2519c) - 1;
                case 11:
                    return this.f2518b;
                case 12:
                    return this.f2518b;
                case 13:
                    return this.f2518b <= 1 ? 0 : 1;
                default:
                    throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
            }
        }
        return qVar.P(this);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.temporal.m
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final q c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            this.f2517a.y(aVar).b(j2, aVar);
            int i2 = (int) j2;
            switch (p.f2516a[aVar.ordinal()]) {
                case 1:
                    return Y(this.f2518b, this.f2519c, i2);
                case 2:
                    return A(Math.min(i2, this.f2517a.c0(this.f2518b, 12)) - P());
                case 3:
                    return A((j2 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
                case 4:
                    return A(j2 - (((int) Math.floorMod(K() + 3, 7)) + 1));
                case 5:
                    return A(j2 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 6:
                    return A(j2 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 7:
                    return new q(this.f2517a, j2);
                case 8:
                    return A((j2 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
                case 9:
                    return Y(this.f2518b, i2, this.f2520d);
                case 10:
                    return F(j2 - (((this.f2518b * 12) + this.f2519c) - 1));
                case 11:
                    if (this.f2518b < 1) {
                        i2 = 1 - i2;
                    }
                    return Y(i2, this.f2519c, this.f2520d);
                case 12:
                    return Y(i2, this.f2519c, this.f2520d);
                case 13:
                    return Y(1 - this.f2518b, this.f2519c, this.f2520d);
                default:
                    throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
            }
        }
        return (q) super.c(j2, qVar);
    }

    public final q Y(int i2, int i3, int i4) {
        int a02 = this.f2517a.a0(i2, i3);
        if (i4 > a02) {
            i4 = a02;
        }
        return new q(this.f2517a, i2, i3, i4);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(j$.time.h hVar) {
        return (q) super.m(hVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b
    public final InterfaceC0206b m(j$.time.temporal.n nVar) {
        return (q) super.m(nVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b
    public final InterfaceC0206b R(j$.time.temporal.p pVar) {
        return (q) super.R(pVar);
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final long K() {
        return this.f2517a.Z(this.f2518b, this.f2519c, this.f2520d);
    }

    public final int P() {
        return this.f2517a.c0(this.f2518b, this.f2519c - 1) + this.f2520d;
    }

    @Override // j$.time.chrono.AbstractC0208d
    public final InterfaceC0206b I(long j2) {
        return j2 == 0 ? this : Y(Math.addExact(this.f2518b, (int) j2), this.f2519c, this.f2520d);
    }

    @Override // j$.time.chrono.AbstractC0208d
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final q F(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (this.f2518b * 12) + (this.f2519c - 1) + j2;
        o oVar = this.f2517a;
        long floorDiv = Math.floorDiv(j3, 12L);
        int i2 = oVar.f2511g;
        if (floorDiv >= i2 / 12 && floorDiv <= (((oVar.f2508d.length - 1) + i2) / 12) - 1) {
            return Y((int) floorDiv, ((int) Math.floorMod(j3, 12L)) + 1, this.f2520d);
        }
        throw new RuntimeException("Invalid Hijrah year: " + floorDiv);
    }

    @Override // j$.time.chrono.AbstractC0208d
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final q A(long j2) {
        return new q(this.f2517a, K() + j2);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b, j$.time.temporal.m
    public final InterfaceC0206b d(long j2, j$.time.temporal.s sVar) {
        return (q) super.d(j2, sVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j2, j$.time.temporal.s sVar) {
        return (q) super.d(j2, sVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b, j$.time.temporal.m
    public final InterfaceC0206b a(long j2, j$.time.temporal.s sVar) {
        return (q) super.a(j2, sVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b, j$.time.temporal.m
    public final j$.time.temporal.m a(long j2, j$.time.temporal.s sVar) {
        return (q) super.a(j2, sVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f2518b == qVar.f2518b && this.f2519c == qVar.f2519c && this.f2520d == qVar.f2520d && this.f2517a.equals(qVar.f2517a)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b
    public final int hashCode() {
        int i2 = this.f2518b;
        int i3 = this.f2519c;
        int i4 = this.f2520d;
        this.f2517a.getClass();
        return (((i2 << 11) + (i3 << 6)) + i4) ^ ((i2 & (-2048)) ^ 2100100019);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 6, this);
    }
}
