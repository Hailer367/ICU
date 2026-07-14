package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class C extends AbstractC0386d {
    private static final long serialVersionUID = 1300372329181994526L;

    /* renamed from: a, reason: collision with root package name */
    public final transient j$.time.h f4578a;

    @Override // j$.time.chrono.InterfaceC0384b
    public final InterfaceC0387e L(j$.time.l lVar) {
        return new C0389g(this, lVar);
    }

    public C(j$.time.h hVar) {
        Objects.requireNonNull(hVar, "isoDate");
        this.f4578a = hVar;
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final l f() {
        return A.f4576c;
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final int hashCode() {
        A.f4576c.getClass();
        return this.f4578a.hashCode() ^ (-1990173233);
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final m N() {
        return P() >= 1 ? D.ROC : D.BEFORE_ROC;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        long j4;
        if (qVar instanceof j$.time.temporal.a) {
            if (h(qVar)) {
                j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
                int i4 = B.f4577a[aVar.ordinal()];
                if (i4 == 1 || i4 == 2 || i4 == 3) {
                    return this.f4578a.l(qVar);
                }
                if (i4 != 4) {
                    return A.f4576c.y(aVar);
                }
                j$.time.temporal.u uVar = j$.time.temporal.a.YEAR.f4747b;
                if (P() <= 0) {
                    j4 = (-uVar.f4772a) + 1912;
                } else {
                    j4 = uVar.f4775d - 1911;
                }
                return j$.time.temporal.u.f(1L, j4);
            }
            throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i4 = B.f4577a[((j$.time.temporal.a) qVar).ordinal()];
            if (i4 == 4) {
                int P = P();
                if (P < 1) {
                    P = 1 - P;
                }
                return P;
            }
            if (i4 == 5) {
                return ((P() * 12) + this.f4578a.f4714b) - 1;
            }
            if (i4 == 6) {
                return P();
            }
            if (i4 != 7) {
                return this.f4578a.i(qVar);
            }
            return P() < 1 ? 0 : 1;
        }
        return qVar.P(this);
    }

    public final int P() {
        return this.f4578a.f4713a - 1911;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r2 != 7) goto L20;
     */
    @Override // j$.time.chrono.AbstractC0386d, j$.time.temporal.m
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.chrono.C c(long r8, j$.time.temporal.q r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof j$.time.temporal.a
            if (r0 == 0) goto L9f
            r0 = r10
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            long r1 = r7.i(r0)
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 != 0) goto L10
            return r7
        L10:
            int[] r1 = j$.time.chrono.B.f4577a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L49
            r6 = 5
            if (r2 == r6) goto L25
            if (r2 == r4) goto L49
            if (r2 == r3) goto L49
            goto L5f
        L25:
            j$.time.chrono.A r10 = j$.time.chrono.A.f4576c
            j$.time.temporal.u r10 = r10.y(r0)
            r10.b(r8, r0)
            int r10 = r7.P()
            long r0 = (long) r10
            r2 = 12
            long r0 = r0 * r2
            j$.time.h r10 = r7.f4578a
            short r2 = r10.f4714b
            long r2 = (long) r2
            long r0 = r0 + r2
            r2 = 1
            long r0 = r0 - r2
            long r8 = r8 - r0
            j$.time.h r8 = r10.g0(r8)
            j$.time.chrono.C r8 = r7.X(r8)
            return r8
        L49:
            j$.time.chrono.A r2 = j$.time.chrono.A.f4576c
            j$.time.temporal.u r2 = r2.y(r0)
            int r2 = r2.a(r8, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L88
            if (r0 == r4) goto L7b
            if (r0 == r3) goto L6a
        L5f:
            j$.time.h r0 = r7.f4578a
            j$.time.h r8 = r0.c(r8, r10)
            j$.time.chrono.C r8 = r7.X(r8)
            return r8
        L6a:
            j$.time.h r8 = r7.f4578a
            int r9 = r7.P()
            int r9 = 1912 - r9
            j$.time.h r8 = r8.m0(r9)
            j$.time.chrono.C r8 = r7.X(r8)
            return r8
        L7b:
            j$.time.h r8 = r7.f4578a
            int r2 = r2 + 1911
            j$.time.h r8 = r8.m0(r2)
            j$.time.chrono.C r8 = r7.X(r8)
            return r8
        L88:
            j$.time.h r8 = r7.f4578a
            int r9 = r7.P()
            r10 = 1
            if (r9 < r10) goto L94
            int r2 = r2 + 1911
            goto L96
        L94:
            int r2 = 1912 - r2
        L96:
            j$.time.h r8 = r8.m0(r2)
            j$.time.chrono.C r8 = r7.X(r8)
            return r8
        L9f:
            j$.time.chrono.b r8 = super.c(r8, r10)
            j$.time.chrono.C r8 = (j$.time.chrono.C) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.C.c(long, j$.time.temporal.q):j$.time.chrono.C");
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(j$.time.h hVar) {
        return (C) super.m(hVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final InterfaceC0384b m(j$.time.temporal.n nVar) {
        return (C) super.m(nVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final InterfaceC0384b R(j$.time.temporal.p pVar) {
        return (C) super.R(pVar);
    }

    @Override // j$.time.chrono.AbstractC0386d
    public final InterfaceC0384b I(long j4) {
        return X(this.f4578a.i0(j4));
    }

    @Override // j$.time.chrono.AbstractC0386d
    public final InterfaceC0384b F(long j4) {
        return X(this.f4578a.g0(j4));
    }

    @Override // j$.time.chrono.AbstractC0386d
    public final InterfaceC0384b A(long j4) {
        return X(this.f4578a.f0(j4));
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b, j$.time.temporal.m
    public final InterfaceC0384b d(long j4, j$.time.temporal.s sVar) {
        return (C) super.d(j4, sVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j4, j$.time.temporal.s sVar) {
        return (C) super.d(j4, sVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b, j$.time.temporal.m
    public final InterfaceC0384b a(long j4, j$.time.temporal.s sVar) {
        return (C) super.a(j4, sVar);
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b, j$.time.temporal.m
    public final j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return (C) super.a(j4, sVar);
    }

    public final C X(j$.time.h hVar) {
        return hVar.equals(this.f4578a) ? this : new C(hVar);
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final long K() {
        return this.f4578a.K();
    }

    @Override // j$.time.chrono.AbstractC0386d, j$.time.chrono.InterfaceC0384b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C) {
            return this.f4578a.equals(((C) obj).f4578a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 7, this);
    }
}
