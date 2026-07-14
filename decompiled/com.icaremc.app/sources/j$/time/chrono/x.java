package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: classes2.dex */
public final class x extends AbstractC0386d {

    /* renamed from: d, reason: collision with root package name */
    public static final j$.time.h f4624d = j$.time.h.b0(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* renamed from: a, reason: collision with root package name */
    public final transient j$.time.h f4625a;

    /* renamed from: b, reason: collision with root package name */
    public final transient y f4626b;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f4627c;

    @Override // j$.time.chrono.InterfaceC0384b
    public final InterfaceC0387e L(j$.time.l lVar) {
        return new C0389g(this, lVar);
    }

    public x(j$.time.h hVar) {
        if (hVar.X(f4624d)) {
            throw new RuntimeException("JapaneseDate before Meiji 6 is not supported");
        }
        y p3 = y.p(hVar);
        this.f4626b = p3;
        this.f4627c = (hVar.f4713a - p3.f4631b.f4713a) + 1;
        this.f4625a = hVar;
    }

    public x(y yVar, int i4, j$.time.h hVar) {
        if (hVar.X(f4624d)) {
            throw new RuntimeException("JapaneseDate before Meiji 6 is not supported");
        }
        this.f4626b = yVar;
        this.f4627c = i4;
        this.f4625a = hVar;
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final l f() {
        return v.f4622c;
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final int hashCode() {
        v.f4622c.getClass();
        return this.f4625a.hashCode() ^ (-688086063);
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final m N() {
        return this.f4626b;
    }

    @Override // j$.time.chrono.InterfaceC0384b, j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || qVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || qVar == j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH || qVar == j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).isDateBased();
        }
        return qVar != null && qVar.s(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    @Override // j$.time.temporal.TemporalAccessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.temporal.u l(j$.time.temporal.q r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof j$.time.temporal.a
            if (r0 == 0) goto L99
            boolean r0 = r5.h(r6)
            if (r0 == 0) goto L8d
            j$.time.temporal.a r6 = (j$.time.temporal.a) r6
            int[] r0 = j$.time.chrono.w.f4623a
            int r1 = r6.ordinal()
            r0 = r0[r1]
            r1 = 1
            r2 = 1
            if (r0 == r1) goto L81
            r4 = 2
            if (r0 == r4) goto L48
            r4 = 3
            if (r0 == r4) goto L26
            j$.time.chrono.v r0 = j$.time.chrono.v.f4622c
            j$.time.temporal.u r6 = r0.y(r6)
            return r6
        L26:
            j$.time.chrono.y r6 = r5.f4626b
            j$.time.h r0 = r6.f4631b
            int r0 = r0.f4713a
            j$.time.chrono.y r6 = r6.q()
            if (r6 == 0) goto L3e
            j$.time.h r6 = r6.f4631b
            int r6 = r6.f4713a
            int r6 = r6 - r0
            int r6 = r6 + r1
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.f(r2, r0)
            return r6
        L3e:
            r6 = 999999999(0x3b9ac9ff, float:0.004723787)
            int r6 = r6 - r0
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.f(r2, r0)
            return r6
        L48:
            j$.time.chrono.y r6 = r5.f4626b
            j$.time.chrono.y r6 = r6.q()
            if (r6 == 0) goto L60
            j$.time.h r6 = r6.f4631b
            int r0 = r6.f4713a
            j$.time.h r4 = r5.f4625a
            int r4 = r4.f4713a
            if (r0 != r4) goto L60
            int r6 = r6.V()
            int r6 = r6 - r1
            goto L6d
        L60:
            j$.time.h r6 = r5.f4625a
            boolean r6 = r6.Y()
            if (r6 == 0) goto L6b
            r6 = 366(0x16e, float:5.13E-43)
            goto L6d
        L6b:
            r6 = 365(0x16d, float:5.11E-43)
        L6d:
            int r0 = r5.f4627c
            if (r0 != r1) goto L7b
            j$.time.chrono.y r0 = r5.f4626b
            j$.time.h r0 = r0.f4631b
            int r0 = r0.V()
            int r0 = r0 - r1
            int r6 = r6 - r0
        L7b:
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.f(r2, r0)
            return r6
        L81:
            j$.time.h r6 = r5.f4625a
            int r6 = r6.Z()
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.f(r2, r0)
            return r6
        L8d:
            j$.time.temporal.t r0 = new j$.time.temporal.t
            java.lang.String r1 = "Unsupported field: "
            java.lang.String r6 = j$.time.d.a(r1, r6)
            r0.<init>(r6)
            throw r0
        L99:
            j$.time.temporal.u r6 = r6.A(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.x.l(j$.time.temporal.q):j$.time.temporal.u");
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            switch (w.f4623a[((j$.time.temporal.a) qVar).ordinal()]) {
                case 2:
                    if (this.f4627c == 1) {
                        return (this.f4625a.V() - this.f4626b.f4631b.V()) + 1;
                    }
                    return this.f4625a.V();
                case 3:
                    return this.f4627c;
                case 4:
                case 5:
                case 6:
                case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
                case R.j.BYTES_FIELD_NUMBER /* 8 */:
                    return this.f4626b.f4630a;
                default:
                    return this.f4625a.i(qVar);
            }
        }
        return qVar.P(this);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.temporal.m
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final x c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            if (i(aVar) == j4) {
                return this;
            }
            int[] iArr = w.f4623a;
            int i4 = iArr[aVar.ordinal()];
            if (i4 == 3 || i4 == 8 || i4 == 9) {
                v vVar = v.f4622c;
                int a4 = vVar.y(aVar).a(j4, aVar);
                int i5 = iArr[aVar.ordinal()];
                if (i5 == 3) {
                    return X(this.f4625a.m0(vVar.C(this.f4626b, a4)));
                }
                if (i5 == 8) {
                    return X(this.f4625a.m0(vVar.C(y.r(a4), this.f4627c)));
                }
                if (i5 == 9) {
                    return X(this.f4625a.m0(a4));
                }
            }
            return X(this.f4625a.c(j4, qVar));
        }
        return (x) super.c(j4, qVar);
    }

    public final x Y(j$.time.i iVar) {
        return (x) super.m(iVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(j$.time.h hVar) {
        return (x) super.m(hVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final InterfaceC0384b m(j$.time.temporal.n nVar) {
        return (x) super.m(nVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final InterfaceC0384b R(j$.time.temporal.p pVar) {
        return (x) super.R(pVar);
    }

    @Override // j$.time.chrono.AbstractC0386d
    public final InterfaceC0384b I(long j4) {
        return X(this.f4625a.i0(j4));
    }

    @Override // j$.time.chrono.AbstractC0386d
    public final InterfaceC0384b F(long j4) {
        return X(this.f4625a.g0(j4));
    }

    @Override // j$.time.chrono.AbstractC0386d
    public final InterfaceC0384b A(long j4) {
        return X(this.f4625a.f0(j4));
    }

    public final x P(long j4, j$.time.temporal.b bVar) {
        return (x) super.d(j4, (j$.time.temporal.s) bVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b, j$.time.temporal.m
    public final InterfaceC0384b d(long j4, j$.time.temporal.s sVar) {
        return (x) super.d(j4, sVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j4, j$.time.temporal.s sVar) {
        return (x) super.d(j4, sVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b, j$.time.temporal.m
    public final InterfaceC0384b a(long j4, j$.time.temporal.s sVar) {
        return (x) super.a(j4, sVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b, j$.time.temporal.m
    public final j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return (x) super.a(j4, sVar);
    }

    public final x X(j$.time.h hVar) {
        return hVar.equals(this.f4625a) ? this : new x(hVar);
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final long K() {
        return this.f4625a.K();
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f4625a.equals(((x) obj).f4625a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 4, this);
    }
}
