package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class q extends AbstractC0386d {
    private static final long serialVersionUID = -5207853542612002020L;

    /* renamed from: a, reason: collision with root package name */
    public final transient o f4614a;

    /* renamed from: b, reason: collision with root package name */
    public final transient int f4615b;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f4616c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f4617d;

    @Override // j$.time.chrono.InterfaceC0384b
    public final InterfaceC0387e L(j$.time.l lVar) {
        return new C0389g(this, lVar);
    }

    public q(o oVar, int i4, int i5, int i6) {
        oVar.Z(i4, i5, i6);
        this.f4614a = oVar;
        this.f4615b = i4;
        this.f4616c = i5;
        this.f4617d = i6;
    }

    public q(o oVar, long j4) {
        int i4 = (int) j4;
        oVar.X();
        if (i4 < oVar.f4607e || i4 >= oVar.f4608f) {
            throw new RuntimeException("Hijrah date out of range");
        }
        int binarySearch = Arrays.binarySearch(oVar.f4606d, i4);
        binarySearch = binarySearch < 0 ? (-binarySearch) - 2 : binarySearch;
        int i5 = oVar.f4609g;
        int[] iArr = {(binarySearch + i5) / 12, ((i5 + binarySearch) % 12) + 1, (i4 - oVar.f4606d[binarySearch]) + 1};
        this.f4614a = oVar;
        this.f4615b = iArr[0];
        this.f4616c = iArr[1];
        this.f4617d = iArr[2];
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final l f() {
        return this.f4614a;
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final m N() {
        return r.AH;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (h(qVar)) {
                j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
                int i4 = p.f4613a[aVar.ordinal()];
                if (i4 == 1) {
                    return j$.time.temporal.u.f(1L, this.f4614a.a0(this.f4615b, this.f4616c));
                }
                if (i4 == 2) {
                    return j$.time.temporal.u.f(1L, this.f4614a.c0(this.f4615b, 12));
                }
                if (i4 == 3) {
                    return j$.time.temporal.u.f(1L, 5L);
                }
                return this.f4614a.y(aVar);
            }
            throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            switch (p.f4613a[((j$.time.temporal.a) qVar).ordinal()]) {
                case 1:
                    return this.f4617d;
                case 2:
                    return P();
                case 3:
                    return ((this.f4617d - 1) / 7) + 1;
                case 4:
                    return ((int) Math.floorMod(K() + 3, 7)) + 1;
                case 5:
                    return ((this.f4617d - 1) % 7) + 1;
                case 6:
                    return ((P() - 1) % 7) + 1;
                case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    return K();
                case R.j.BYTES_FIELD_NUMBER /* 8 */:
                    return ((P() - 1) / 7) + 1;
                case 9:
                    return this.f4616c;
                case 10:
                    return ((this.f4615b * 12) + this.f4616c) - 1;
                case 11:
                    return this.f4615b;
                case 12:
                    return this.f4615b;
                case 13:
                    return this.f4615b <= 1 ? 0 : 1;
                default:
                    throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
            }
        }
        return qVar.P(this);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.temporal.m
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final q c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            this.f4614a.y(aVar).b(j4, aVar);
            int i4 = (int) j4;
            switch (p.f4613a[aVar.ordinal()]) {
                case 1:
                    return Y(this.f4615b, this.f4616c, i4);
                case 2:
                    return A(Math.min(i4, this.f4614a.c0(this.f4615b, 12)) - P());
                case 3:
                    return A((j4 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
                case 4:
                    return A(j4 - (((int) Math.floorMod(K() + 3, 7)) + 1));
                case 5:
                    return A(j4 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 6:
                    return A(j4 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    return new q(this.f4614a, j4);
                case R.j.BYTES_FIELD_NUMBER /* 8 */:
                    return A((j4 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
                case 9:
                    return Y(this.f4615b, i4, this.f4617d);
                case 10:
                    return F(j4 - (((this.f4615b * 12) + this.f4616c) - 1));
                case 11:
                    if (this.f4615b < 1) {
                        i4 = 1 - i4;
                    }
                    return Y(i4, this.f4616c, this.f4617d);
                case 12:
                    return Y(i4, this.f4616c, this.f4617d);
                case 13:
                    return Y(1 - this.f4615b, this.f4616c, this.f4617d);
                default:
                    throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
            }
        }
        return (q) super.c(j4, qVar);
    }

    public final q Y(int i4, int i5, int i6) {
        int a02 = this.f4614a.a0(i4, i5);
        if (i6 > a02) {
            i6 = a02;
        }
        return new q(this.f4614a, i4, i5, i6);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(j$.time.h hVar) {
        return (q) super.m(hVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final InterfaceC0384b m(j$.time.temporal.n nVar) {
        return (q) super.m(nVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final InterfaceC0384b R(j$.time.temporal.p pVar) {
        return (q) super.R(pVar);
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final long K() {
        return this.f4614a.Z(this.f4615b, this.f4616c, this.f4617d);
    }

    public final int P() {
        return this.f4614a.c0(this.f4615b, this.f4616c - 1) + this.f4617d;
    }

    @Override // j$.time.chrono.AbstractC0386d
    public final InterfaceC0384b I(long j4) {
        return j4 == 0 ? this : Y(Math.addExact(this.f4615b, (int) j4), this.f4616c, this.f4617d);
    }

    @Override // j$.time.chrono.AbstractC0386d
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final q F(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = (this.f4615b * 12) + (this.f4616c - 1) + j4;
        o oVar = this.f4614a;
        long floorDiv = Math.floorDiv(j5, 12L);
        int i4 = oVar.f4609g;
        if (floorDiv >= i4 / 12 && floorDiv <= (((oVar.f4606d.length - 1) + i4) / 12) - 1) {
            return Y((int) floorDiv, ((int) Math.floorMod(j5, 12L)) + 1, this.f4617d);
        }
        throw new RuntimeException("Invalid Hijrah year: " + floorDiv);
    }

    @Override // j$.time.chrono.AbstractC0386d
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final q A(long j4) {
        return new q(this.f4614a, K() + j4);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b, j$.time.temporal.m
    public final InterfaceC0384b d(long j4, j$.time.temporal.s sVar) {
        return (q) super.d(j4, sVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j4, j$.time.temporal.s sVar) {
        return (q) super.d(j4, sVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b, j$.time.temporal.m
    public final InterfaceC0384b a(long j4, j$.time.temporal.s sVar) {
        return (q) super.a(j4, sVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b, j$.time.temporal.m
    public final j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return (q) super.a(j4, sVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f4615b == qVar.f4615b && this.f4616c == qVar.f4616c && this.f4617d == qVar.f4617d && this.f4614a.equals(qVar.f4614a)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final int hashCode() {
        int i4 = this.f4615b;
        int i5 = this.f4616c;
        int i6 = this.f4617d;
        this.f4614a.getClass();
        return (((i4 << 11) + (i5 << 6)) + i6) ^ ((i4 & (-2048)) ^ 2100100019);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 6, this);
    }
}
