package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class G extends AbstractC0205a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final G f2485c = new G();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap.put("en", new String[]{"BB", "BE"});
        hashMap.put("th", new String[]{"BB", "BE"});
        hashMap2.put("en", new String[]{"B.B.", "B.E."});
        hashMap2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        hashMap3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        hashMap3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    @Override // j$.time.chrono.l
    public final m B(int i2) {
        if (i2 == 0) {
            return J.BEFORE_BE;
        }
        if (i2 == 1) {
            return J.BE;
        }
        throw new RuntimeException("Invalid era: " + i2);
    }

    @Override // j$.time.chrono.l
    public final String q() {
        return "ThaiBuddhist";
    }

    @Override // j$.time.chrono.l
    public final String u() {
        return "buddhist";
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b Q(int i2, int i3, int i4) {
        return new I(j$.time.h.b0(i2 - 543, i3, i4));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b v(int i2, int i3) {
        return new I(j$.time.h.d0(i2 - 543, i3));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b p(long j2) {
        return new I(j$.time.h.c0(j2));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b M() {
        return new I(j$.time.h.F(j$.time.h.a0(j$.time.b.b())));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b G(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof I) {
            return (I) temporalAccessor;
        }
        return new I(j$.time.h.F(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final int C(m mVar, int i2) {
        if (mVar instanceof J) {
            return mVar == J.BE ? i2 : 1 - i2;
        }
        throw new ClassCastException("Era must be BuddhistEra");
    }

    private G() {
    }

    @Override // j$.time.chrono.l
    public final List z() {
        return j$.time.b.a(J.values());
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.u y(j$.time.temporal.a aVar) {
        int i2 = F.f2484a[aVar.ordinal()];
        if (i2 == 1) {
            j$.time.temporal.u uVar = j$.time.temporal.a.PROLEPTIC_MONTH.f2650b;
            return j$.time.temporal.u.f(uVar.f2675a + 6516, uVar.f2678d + 6516);
        }
        if (i2 == 2) {
            j$.time.temporal.u uVar2 = j$.time.temporal.a.YEAR.f2650b;
            return j$.time.temporal.u.g((-(uVar2.f2675a + 543)) + 1, uVar2.f2678d + 543);
        }
        if (i2 != 3) {
            return aVar.f2650b;
        }
        j$.time.temporal.u uVar3 = j$.time.temporal.a.YEAR.f2650b;
        return j$.time.temporal.u.f(uVar3.f2675a + 543, uVar3.f2678d + 543);
    }

    @Override // j$.time.chrono.AbstractC0205a, j$.time.chrono.l
    public final InterfaceC0206b S(Map map, j$.time.format.x xVar) {
        return (I) super.S(map, xVar);
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
