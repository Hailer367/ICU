package j$.time.chrono;

import java.io.Serializable;

/* renamed from: j$.time.chrono.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0208d implements InterfaceC0206b, j$.time.temporal.m, j$.time.temporal.n, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public abstract InterfaceC0206b A(long j2);

    public abstract InterfaceC0206b F(long j2);

    public abstract InterfaceC0206b I(long j2);

    @Override // j$.time.chrono.InterfaceC0206b, j$.time.temporal.m
    public /* bridge */ /* synthetic */ j$.time.temporal.m a(long j2, j$.time.temporal.s sVar) {
        return a(j2, sVar);
    }

    public static InterfaceC0206b s(l lVar, j$.time.temporal.m mVar) {
        InterfaceC0206b interfaceC0206b = (InterfaceC0206b) mVar;
        if (lVar.equals(interfaceC0206b.f())) {
            return interfaceC0206b;
        }
        throw new ClassCastException("Chronology mismatch, expected: " + lVar.q() + ", actual: " + interfaceC0206b.f().q());
    }

    @Override // j$.time.temporal.m
    public InterfaceC0206b d(long j2, j$.time.temporal.s sVar) {
        boolean z = sVar instanceof j$.time.temporal.b;
        if (!z) {
            if (!z) {
                return s(f(), sVar.s(this, j2));
            }
            throw new RuntimeException("Unsupported unit: " + sVar);
        }
        switch (AbstractC0207c.f2491a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return A(j2);
            case 2:
                return A(Math.multiplyExact(j2, 7));
            case 3:
                return F(j2);
            case 4:
                return I(j2);
            case 5:
                return I(Math.multiplyExact(j2, 10));
            case 6:
                return I(Math.multiplyExact(j2, 100));
            case 7:
                return I(Math.multiplyExact(j2, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(Math.addExact(i(aVar), j2), (j$.time.temporal.q) aVar);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InterfaceC0206b) && compareTo((InterfaceC0206b) obj) == 0;
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public int hashCode() {
        long K2 = K();
        return ((int) (K2 ^ (K2 >>> 32))) ^ f().hashCode();
    }

    @Override // j$.time.temporal.m
    public InterfaceC0206b m(j$.time.temporal.n nVar) {
        return s(f(), nVar.e(this));
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final String toString() {
        long i2 = i(j$.time.temporal.a.YEAR_OF_ERA);
        long i3 = i(j$.time.temporal.a.MONTH_OF_YEAR);
        long i4 = i(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(f().toString());
        sb.append(" ");
        sb.append(N());
        sb.append(" ");
        sb.append(i2);
        sb.append(i3 < 10 ? "-0" : "-");
        sb.append(i3);
        sb.append(i4 < 10 ? "-0" : "-");
        sb.append(i4);
        return sb.toString();
    }

    @Override // j$.time.temporal.m
    public InterfaceC0206b c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
        }
        return s(f(), qVar.V(this, j2));
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public InterfaceC0206b R(j$.time.temporal.p pVar) {
        return s(f(), pVar.s(this));
    }
}
