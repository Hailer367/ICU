package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: classes2.dex */
public final class x extends AbstractC0208d {

    /* renamed from: d, reason: collision with root package name */
    public static final j$.time.h f2527d = j$.time.h.b0(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* renamed from: a, reason: collision with root package name */
    public final transient j$.time.h f2528a;

    /* renamed from: b, reason: collision with root package name */
    public final transient y f2529b;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f2530c;

    @Override // j$.time.chrono.InterfaceC0206b
    public final InterfaceC0209e L(j$.time.l lVar) {
        return new C0211g(this, lVar);
    }

    public x(j$.time.h hVar) {
        if (hVar.X(f2527d)) {
            throw new RuntimeException("JapaneseDate before Meiji 6 is not supported");
        }
        y p = y.p(hVar);
        this.f2529b = p;
        this.f2530c = (hVar.f2616a - p.f2534b.f2616a) + 1;
        this.f2528a = hVar;
    }

    public x(y yVar, int i2, j$.time.h hVar) {
        if (hVar.X(f2527d)) {
            throw new RuntimeException("JapaneseDate before Meiji 6 is not supported");
        }
        this.f2529b = yVar;
        this.f2530c = i2;
        this.f2528a = hVar;
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final l f() {
        return v.f2525c;
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b
    public final int hashCode() {
        v.f2525c.getClass();
        return this.f2528a.hashCode() ^ (-688086063);
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final m N() {
        return this.f2529b;
    }

    @Override // j$.time.chrono.InterfaceC0206b, j$.time.temporal.TemporalAccessor
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
            int[] r0 = j$.time.chrono.w.f2526a
            int r1 = r6.ordinal()
            r0 = r0[r1]
            r1 = 1
            r2 = 1
            if (r0 == r1) goto L81
            r4 = 2
            if (r0 == r4) goto L48
            r4 = 3
            if (r0 == r4) goto L26
            j$.time.chrono.v r0 = j$.time.chrono.v.f2525c
            j$.time.temporal.u r6 = r0.y(r6)
            return r6
        L26:
            j$.time.chrono.y r6 = r5.f2529b
            j$.time.h r0 = r6.f2534b
            int r0 = r0.f2616a
            j$.time.chrono.y r6 = r6.q()
            if (r6 == 0) goto L3e
            j$.time.h r6 = r6.f2534b
            int r6 = r6.f2616a
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
            j$.time.chrono.y r6 = r5.f2529b
            j$.time.chrono.y r6 = r6.q()
            if (r6 == 0) goto L60
            j$.time.h r6 = r6.f2534b
            int r0 = r6.f2616a
            j$.time.h r4 = r5.f2528a
            int r4 = r4.f2616a
            if (r0 != r4) goto L60
            int r6 = r6.V()
            int r6 = r6 - r1
            goto L6d
        L60:
            j$.time.h r6 = r5.f2528a
            boolean r6 = r6.Y()
            if (r6 == 0) goto L6b
            r6 = 366(0x16e, float:5.13E-43)
            goto L6d
        L6b:
            r6 = 365(0x16d, float:5.11E-43)
        L6d:
            int r0 = r5.f2530c
            if (r0 != r1) goto L7b
            j$.time.chrono.y r0 = r5.f2529b
            j$.time.h r0 = r0.f2534b
            int r0 = r0.V()
            int r0 = r0 - r1
            int r6 = r6 - r0
        L7b:
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.f(r2, r0)
            return r6
        L81:
            j$.time.h r6 = r5.f2528a
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
            switch (w.f2526a[((j$.time.temporal.a) qVar).ordinal()]) {
                case 2:
                    if (this.f2530c == 1) {
                        return (this.f2528a.V() - this.f2529b.f2534b.V()) + 1;
                    }
                    return this.f2528a.V();
                case 3:
                    return this.f2530c;
                case 4:
                case 5:
                case 6:
                case 7:
                    throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
                case 8:
                    return this.f2529b.f2533a;
                default:
                    return this.f2528a.i(qVar);
            }
        }
        return qVar.P(this);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.temporal.m
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final x c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            if (i(aVar) == j2) {
                return this;
            }
            int[] iArr = w.f2526a;
            int i2 = iArr[aVar.ordinal()];
            if (i2 == 3 || i2 == 8 || i2 == 9) {
                v vVar = v.f2525c;
                int a2 = vVar.y(aVar).a(j2, aVar);
                int i3 = iArr[aVar.ordinal()];
                if (i3 == 3) {
                    return X(this.f2528a.m0(vVar.C(this.f2529b, a2)));
                }
                if (i3 == 8) {
                    return X(this.f2528a.m0(vVar.C(y.r(a2), this.f2530c)));
                }
                if (i3 == 9) {
                    return X(this.f2528a.m0(a2));
                }
            }
            return X(this.f2528a.c(j2, qVar));
        }
        return (x) super.c(j2, qVar);
    }

    public final x Y(j$.time.i iVar) {
        return (x) super.m(iVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(j$.time.h hVar) {
        return (x) super.m(hVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b
    public final InterfaceC0206b m(j$.time.temporal.n nVar) {
        return (x) super.m(nVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b
    public final InterfaceC0206b R(j$.time.temporal.p pVar) {
        return (x) super.R(pVar);
    }

    @Override // j$.time.chrono.AbstractC0208d
    public final InterfaceC0206b I(long j2) {
        return X(this.f2528a.i0(j2));
    }

    @Override // j$.time.chrono.AbstractC0208d
    public final InterfaceC0206b F(long j2) {
        return X(this.f2528a.g0(j2));
    }

    @Override // j$.time.chrono.AbstractC0208d
    public final InterfaceC0206b A(long j2) {
        return X(this.f2528a.f0(j2));
    }

    public final x P(long j2, j$.time.temporal.b bVar) {
        return (x) super.d(j2, (j$.time.temporal.s) bVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b, j$.time.temporal.m
    public final InterfaceC0206b d(long j2, j$.time.temporal.s sVar) {
        return (x) super.d(j2, sVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j2, j$.time.temporal.s sVar) {
        return (x) super.d(j2, sVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b, j$.time.temporal.m
    public final InterfaceC0206b a(long j2, j$.time.temporal.s sVar) {
        return (x) super.a(j2, sVar);
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b, j$.time.temporal.m
    public final j$.time.temporal.m a(long j2, j$.time.temporal.s sVar) {
        return (x) super.a(j2, sVar);
    }

    public final x X(j$.time.h hVar) {
        return hVar.equals(this.f2528a) ? this : new x(hVar);
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final long K() {
        return this.f2528a.K();
    }

    @Override // j$.time.chrono.AbstractC0208d, j$.time.chrono.InterfaceC0206b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f2528a.equals(((x) obj).f2528a);
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
