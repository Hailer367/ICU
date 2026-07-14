package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class A extends AbstractC0383a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final A f4576c = new A();
    private static final long serialVersionUID = 1039765215346859963L;

    @Override // j$.time.chrono.l
    public final String q() {
        return "Minguo";
    }

    @Override // j$.time.chrono.l
    public final m B(int i4) {
        if (i4 == 0) {
            return D.BEFORE_ROC;
        }
        if (i4 == 1) {
            return D.ROC;
        }
        throw new RuntimeException("Invalid era: " + i4);
    }

    @Override // j$.time.chrono.l
    public final String u() {
        return "roc";
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b Q(int i4, int i5, int i6) {
        return new C(j$.time.h.b0(i4 + 1911, i5, i6));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b v(int i4, int i5) {
        return new C(j$.time.h.d0(i4 + 1911, i5));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b p(long j4) {
        return new C(j$.time.h.c0(j4));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b M() {
        return new C(j$.time.h.F(j$.time.h.a0(j$.time.b.b())));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b G(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof C) {
            return (C) temporalAccessor;
        }
        return new C(j$.time.h.F(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final int C(m mVar, int i4) {
        if (mVar instanceof D) {
            return mVar == D.ROC ? i4 : 1 - i4;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    @Override // j$.time.chrono.l
    public final List z() {
        return j$.time.b.a(D.values());
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.u y(j$.time.temporal.a aVar) {
        int i4 = z.f4633a[aVar.ordinal()];
        if (i4 == 1) {
            j$.time.temporal.u uVar = j$.time.temporal.a.PROLEPTIC_MONTH.f4747b;
            return j$.time.temporal.u.f(uVar.f4772a - 22932, uVar.f4775d - 22932);
        }
        if (i4 == 2) {
            j$.time.temporal.u uVar2 = j$.time.temporal.a.YEAR.f4747b;
            return j$.time.temporal.u.g(uVar2.f4775d - 1911, (-uVar2.f4772a) + 1912);
        }
        if (i4 != 3) {
            return aVar.f4747b;
        }
        j$.time.temporal.u uVar3 = j$.time.temporal.a.YEAR.f4747b;
        return j$.time.temporal.u.f(uVar3.f4772a - 1911, uVar3.f4775d - 1911);
    }

    @Override // j$.time.chrono.AbstractC0383a, j$.time.chrono.l
    public final InterfaceC0384b S(Map map, j$.time.format.x xVar) {
        return (C) super.S(map, xVar);
    }

    private A() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime T(Instant instant, ZoneId zoneId) {
        return k.F(this, instant, zoneId);
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
