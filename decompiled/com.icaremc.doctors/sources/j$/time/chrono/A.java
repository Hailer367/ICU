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
public final class A extends AbstractC0205a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final A f2478c = new A();
    private static final long serialVersionUID = 1039765215346859963L;

    @Override // j$.time.chrono.l
    public final String q() {
        return "Minguo";
    }

    @Override // j$.time.chrono.l
    public final m B(int i2) {
        if (i2 == 0) {
            return D.BEFORE_ROC;
        }
        if (i2 == 1) {
            return D.ROC;
        }
        throw new RuntimeException("Invalid era: " + i2);
    }

    @Override // j$.time.chrono.l
    public final String u() {
        return "roc";
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b Q(int i2, int i3, int i4) {
        return new C(j$.time.h.b0(i2 + 1911, i3, i4));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b v(int i2, int i3) {
        return new C(j$.time.h.d0(i2 + 1911, i3));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b p(long j2) {
        return new C(j$.time.h.c0(j2));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b M() {
        return new C(j$.time.h.F(j$.time.h.a0(j$.time.b.b())));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b G(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof C) {
            return (C) temporalAccessor;
        }
        return new C(j$.time.h.F(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final int C(m mVar, int i2) {
        if (mVar instanceof D) {
            return mVar == D.ROC ? i2 : 1 - i2;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    @Override // j$.time.chrono.l
    public final List z() {
        return j$.time.b.a(D.values());
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.u y(j$.time.temporal.a aVar) {
        int i2 = z.f2536a[aVar.ordinal()];
        if (i2 == 1) {
            j$.time.temporal.u uVar = j$.time.temporal.a.PROLEPTIC_MONTH.f2650b;
            return j$.time.temporal.u.f(uVar.f2675a - 22932, uVar.f2678d - 22932);
        }
        if (i2 == 2) {
            j$.time.temporal.u uVar2 = j$.time.temporal.a.YEAR.f2650b;
            return j$.time.temporal.u.g(uVar2.f2678d - 1911, (-uVar2.f2675a) + 1912);
        }
        if (i2 != 3) {
            return aVar.f2650b;
        }
        j$.time.temporal.u uVar3 = j$.time.temporal.a.YEAR.f2650b;
        return j$.time.temporal.u.f(uVar3.f2675a - 1911, uVar3.f2678d - 1911);
    }

    @Override // j$.time.chrono.AbstractC0205a, j$.time.chrono.l
    public final InterfaceC0206b S(Map map, j$.time.format.x xVar) {
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
