package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class v extends AbstractC0205a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final v f2525c = new v();
    private static final long serialVersionUID = 459996390165777884L;

    @Override // j$.time.chrono.l
    public final String q() {
        return "Japanese";
    }

    @Override // j$.time.chrono.l
    public final String u() {
        return "japanese";
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b Q(int i2, int i3, int i4) {
        return new x(j$.time.h.b0(i2, i3, i4));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b v(int i2, int i3) {
        return new x(j$.time.h.d0(i2, i3));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b p(long j2) {
        return new x(j$.time.h.c0(j2));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b M() {
        return new x(j$.time.h.F(j$.time.h.a0(j$.time.b.b())));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b G(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof x) {
            return (x) temporalAccessor;
        }
        return new x(j$.time.h.F(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final List z() {
        y[] yVarArr = y.f2532e;
        return j$.time.b.a((y[]) Arrays.copyOf(yVarArr, yVarArr.length));
    }

    private v() {
    }

    @Override // j$.time.chrono.l
    public final int C(m mVar, int i2) {
        if (!(mVar instanceof y)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        int i3 = ((y) mVar).f2534b.f2616a;
        int i4 = (i3 + i2) - 1;
        if (i2 != 1 && (i4 < -999999999 || i4 > 999999999 || i4 < i3 || mVar != y.p(j$.time.h.b0(i4, 1, 1)))) {
            throw new RuntimeException("Invalid yearOfEra value");
        }
        return i4;
    }

    @Override // j$.time.chrono.l
    public final m B(int i2) {
        return y.r(i2);
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.u y(j$.time.temporal.a aVar) {
        switch (u.f2524a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new RuntimeException("Unsupported field: " + aVar);
            case 5:
                y[] yVarArr = y.f2532e;
                int i2 = yVarArr[yVarArr.length - 1].f2534b.f2616a;
                int i3 = 1000000000 - yVarArr[yVarArr.length - 1].f2534b.f2616a;
                int i4 = yVarArr[0].f2534b.f2616a;
                int i5 = 1;
                while (true) {
                    y[] yVarArr2 = y.f2532e;
                    if (i5 >= yVarArr2.length) {
                        return j$.time.temporal.u.g(i3, 999999999 - i2);
                    }
                    y yVar = yVarArr2[i5];
                    i3 = Math.min(i3, (yVar.f2534b.f2616a - i4) + 1);
                    i4 = yVar.f2534b.f2616a;
                    i5++;
                }
            case 6:
                y yVar2 = y.f2531d;
                long j2 = j$.time.temporal.a.DAY_OF_YEAR.f2650b.f2677c;
                for (y yVar3 : y.f2532e) {
                    j2 = Math.min(j2, ((yVar3.f2534b.Y() ? 366 : 365) - yVar3.f2534b.V()) + 1);
                    if (yVar3.q() != null) {
                        j2 = Math.min(j2, yVar3.q().f2534b.V() - 1);
                    }
                }
                return j$.time.temporal.u.g(j2, j$.time.temporal.a.DAY_OF_YEAR.f2650b.f2678d);
            case 7:
                return j$.time.temporal.u.f(x.f2527d.f2616a, 999999999L);
            case 8:
                long j3 = y.f2531d.f2533a;
                y[] yVarArr3 = y.f2532e;
                return j$.time.temporal.u.f(j3, yVarArr3[yVarArr3.length - 1].f2533a);
            default:
                return aVar.f2650b;
        }
    }

    @Override // j$.time.chrono.AbstractC0205a, j$.time.chrono.l
    public final InterfaceC0206b S(Map map, j$.time.format.x xVar) {
        return (x) super.S(map, xVar);
    }

    @Override // j$.time.chrono.AbstractC0205a
    public final InterfaceC0206b V(Map map, j$.time.format.x xVar) {
        j$.time.h d02;
        x Y2;
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        Long l2 = (Long) map.get(aVar);
        y r2 = l2 != null ? y.r(y(aVar).a(l2.longValue(), aVar)) : null;
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR_OF_ERA;
        Long l3 = (Long) map.get(aVar2);
        int a2 = l3 != null ? y(aVar2).a(l3.longValue(), aVar2) : 0;
        if (r2 == null && l3 != null && !map.containsKey(j$.time.temporal.a.YEAR) && xVar != j$.time.format.x.STRICT) {
            y[] yVarArr = y.f2532e;
            r2 = ((y[]) Arrays.copyOf(yVarArr, yVarArr.length))[((y[]) Arrays.copyOf(yVarArr, yVarArr.length)).length - 1];
        }
        if (l3 != null && r2 != null) {
            j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                j$.time.temporal.a aVar4 = j$.time.temporal.a.DAY_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    map.remove(aVar);
                    map.remove(aVar2);
                    if (xVar == j$.time.format.x.LENIENT) {
                        return new x(j$.time.h.b0((r2.f2534b.f2616a + a2) - 1, 1, 1)).P(Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), j$.time.temporal.b.MONTHS).P(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), j$.time.temporal.b.DAYS);
                    }
                    int a3 = y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int a4 = y(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    if (xVar != j$.time.format.x.SMART) {
                        j$.time.h hVar = x.f2527d;
                        j$.time.h b02 = j$.time.h.b0((r2.f2534b.f2616a + a2) - 1, a3, a4);
                        if (b02.X(r2.f2534b) || r2 != y.p(b02)) {
                            throw new RuntimeException("year, month, and day not valid for Era");
                        }
                        return new x(r2, a2, b02);
                    }
                    if (a2 < 1) {
                        throw new RuntimeException("Invalid YearOfEra: " + a2);
                    }
                    int i2 = (r2.f2534b.f2616a + a2) - 1;
                    try {
                        Y2 = new x(j$.time.h.b0(i2, a3, a4));
                    } catch (j$.time.c unused) {
                        Y2 = new x(j$.time.h.b0(i2, a3, 1)).Y(new j$.time.i(2));
                    }
                    if (Y2.f2529b == r2 || Y2.g(j$.time.temporal.a.YEAR_OF_ERA) <= 1 || a2 <= 1) {
                        return Y2;
                    }
                    throw new RuntimeException("Invalid YearOfEra for Era: " + r2 + " " + a2);
                }
            }
            j$.time.temporal.a aVar5 = j$.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar5)) {
                map.remove(aVar);
                map.remove(aVar2);
                if (xVar == j$.time.format.x.LENIENT) {
                    return new x(j$.time.h.d0((r2.f2534b.f2616a + a2) - 1, 1)).P(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), j$.time.temporal.b.DAYS);
                }
                int a5 = y(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5);
                j$.time.h hVar2 = x.f2527d;
                if (a2 == 1) {
                    j$.time.h hVar3 = r2.f2534b;
                    d02 = j$.time.h.d0(hVar3.f2616a, (hVar3.V() + a5) - 1);
                } else {
                    d02 = j$.time.h.d0((r2.f2534b.f2616a + a2) - 1, a5);
                }
                if (d02.X(r2.f2534b) || r2 != y.p(d02)) {
                    throw new RuntimeException("Invalid parameters");
                }
                return new x(r2, a2, d02);
            }
        }
        return null;
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime T(Instant instant, ZoneId zoneId) {
        return k.F(this, instant, zoneId);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
