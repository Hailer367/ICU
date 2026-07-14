package j$.time.chrono;

import java.io.Serializable;

/* renamed from: j$.time.chrono.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0386d implements InterfaceC0384b, j$.time.temporal.m, j$.time.temporal.n, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public abstract InterfaceC0384b A(long j4);

    public abstract InterfaceC0384b F(long j4);

    public abstract InterfaceC0384b I(long j4);

    @Override // j$.time.chrono.InterfaceC0384b, j$.time.temporal.m
    public /* bridge */ /* synthetic */ j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return a(j4, sVar);
    }

    public static InterfaceC0384b s(l lVar, j$.time.temporal.m mVar) {
        InterfaceC0384b interfaceC0384b = (InterfaceC0384b) mVar;
        if (lVar.equals(interfaceC0384b.f())) {
            return interfaceC0384b;
        }
        throw new ClassCastException("Chronology mismatch, expected: " + lVar.q() + ", actual: " + interfaceC0384b.f().q());
    }

    @Override // j$.time.temporal.m
    public InterfaceC0384b d(long j4, j$.time.temporal.s sVar) {
        boolean z = sVar instanceof j$.time.temporal.b;
        if (!z) {
            if (!z) {
                return s(f(), sVar.s(this, j4));
            }
            throw new RuntimeException("Unsupported unit: " + sVar);
        }
        switch (AbstractC0385c.f4589a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return A(j4);
            case 2:
                return A(Math.multiplyExact(j4, 7));
            case 3:
                return F(j4);
            case 4:
                return I(j4);
            case 5:
                return I(Math.multiplyExact(j4, 10));
            case 6:
                return I(Math.multiplyExact(j4, 100));
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return I(Math.multiplyExact(j4, 1000));
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(Math.addExact(i(aVar), j4), (j$.time.temporal.q) aVar);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InterfaceC0384b) && compareTo((InterfaceC0384b) obj) == 0;
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public int hashCode() {
        long K3 = K();
        return ((int) (K3 ^ (K3 >>> 32))) ^ f().hashCode();
    }

    @Override // j$.time.temporal.m
    public InterfaceC0384b m(j$.time.temporal.n nVar) {
        return s(f(), nVar.e(this));
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final String toString() {
        long i4 = i(j$.time.temporal.a.YEAR_OF_ERA);
        long i5 = i(j$.time.temporal.a.MONTH_OF_YEAR);
        long i6 = i(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(f().toString());
        sb.append(" ");
        sb.append(N());
        sb.append(" ");
        sb.append(i4);
        sb.append(i5 < 10 ? "-0" : "-");
        sb.append(i5);
        sb.append(i6 < 10 ? "-0" : "-");
        sb.append(i6);
        return sb.toString();
    }

    @Override // j$.time.temporal.m
    public InterfaceC0384b c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
        }
        return s(f(), qVar.V(this, j4));
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public InterfaceC0384b R(j$.time.temporal.p pVar) {
        return s(f(), pVar.s(this));
    }
}
