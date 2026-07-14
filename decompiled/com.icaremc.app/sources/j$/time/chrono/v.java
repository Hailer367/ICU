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
public final class v extends AbstractC0383a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final v f4622c = new v();
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
    public final InterfaceC0384b Q(int i4, int i5, int i6) {
        return new x(j$.time.h.b0(i4, i5, i6));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b v(int i4, int i5) {
        return new x(j$.time.h.d0(i4, i5));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b p(long j4) {
        return new x(j$.time.h.c0(j4));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b M() {
        return new x(j$.time.h.F(j$.time.h.a0(j$.time.b.b())));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b G(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof x) {
            return (x) temporalAccessor;
        }
        return new x(j$.time.h.F(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final List z() {
        y[] yVarArr = y.f4629e;
        return j$.time.b.a((y[]) Arrays.copyOf(yVarArr, yVarArr.length));
    }

    private v() {
    }

    @Override // j$.time.chrono.l
    public final int C(m mVar, int i4) {
        if (!(mVar instanceof y)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        int i5 = ((y) mVar).f4631b.f4713a;
        int i6 = (i5 + i4) - 1;
        if (i4 != 1 && (i6 < -999999999 || i6 > 999999999 || i6 < i5 || mVar != y.p(j$.time.h.b0(i6, 1, 1)))) {
            throw new RuntimeException("Invalid yearOfEra value");
        }
        return i6;
    }

    @Override // j$.time.chrono.l
    public final m B(int i4) {
        return y.r(i4);
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.u y(j$.time.temporal.a aVar) {
        switch (u.f4621a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new RuntimeException("Unsupported field: " + aVar);
            case 5:
                y[] yVarArr = y.f4629e;
                int i4 = yVarArr[yVarArr.length - 1].f4631b.f4713a;
                int i5 = 1000000000 - yVarArr[yVarArr.length - 1].f4631b.f4713a;
                int i6 = yVarArr[0].f4631b.f4713a;
                int i7 = 1;
                while (true) {
                    y[] yVarArr2 = y.f4629e;
                    if (i7 >= yVarArr2.length) {
                        return j$.time.temporal.u.g(i5, 999999999 - i4);
                    }
                    y yVar = yVarArr2[i7];
                    i5 = Math.min(i5, (yVar.f4631b.f4713a - i6) + 1);
                    i6 = yVar.f4631b.f4713a;
                    i7++;
                }
            case 6:
                y yVar2 = y.f4628d;
                long j4 = j$.time.temporal.a.DAY_OF_YEAR.f4747b.f4774c;
                for (y yVar3 : y.f4629e) {
                    j4 = Math.min(j4, ((yVar3.f4631b.Y() ? 366 : 365) - yVar3.f4631b.V()) + 1);
                    if (yVar3.q() != null) {
                        j4 = Math.min(j4, yVar3.q().f4631b.V() - 1);
                    }
                }
                return j$.time.temporal.u.g(j4, j$.time.temporal.a.DAY_OF_YEAR.f4747b.f4775d);
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return j$.time.temporal.u.f(x.f4624d.f4713a, 999999999L);
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                long j5 = y.f4628d.f4630a;
                y[] yVarArr3 = y.f4629e;
                return j$.time.temporal.u.f(j5, yVarArr3[yVarArr3.length - 1].f4630a);
            default:
                return aVar.f4747b;
        }
    }

    @Override // j$.time.chrono.AbstractC0383a, j$.time.chrono.l
    public final InterfaceC0384b S(Map map, j$.time.format.x xVar) {
        return (x) super.S(map, xVar);
    }

    @Override // j$.time.chrono.AbstractC0383a
    public final InterfaceC0384b V(Map map, j$.time.format.x xVar) {
        j$.time.h d02;
        x Y3;
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        Long l3 = (Long) map.get(aVar);
        y r3 = l3 != null ? y.r(y(aVar).a(l3.longValue(), aVar)) : null;
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR_OF_ERA;
        Long l4 = (Long) map.get(aVar2);
        int a4 = l4 != null ? y(aVar2).a(l4.longValue(), aVar2) : 0;
        if (r3 == null && l4 != null && !map.containsKey(j$.time.temporal.a.YEAR) && xVar != j$.time.format.x.STRICT) {
            y[] yVarArr = y.f4629e;
            r3 = ((y[]) Arrays.copyOf(yVarArr, yVarArr.length))[((y[]) Arrays.copyOf(yVarArr, yVarArr.length)).length - 1];
        }
        if (l4 != null && r3 != null) {
            j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                j$.time.temporal.a aVar4 = j$.time.temporal.a.DAY_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    map.remove(aVar);
                    map.remove(aVar2);
                    if (xVar == j$.time.format.x.LENIENT) {
                        return new x(j$.time.h.b0((r3.f4631b.f4713a + a4) - 1, 1, 1)).P(Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), j$.time.temporal.b.MONTHS).P(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), j$.time.temporal.b.DAYS);
                    }
                    int a5 = y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int a6 = y(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    if (xVar != j$.time.format.x.SMART) {
                        j$.time.h hVar = x.f4624d;
                        j$.time.h b02 = j$.time.h.b0((r3.f4631b.f4713a + a4) - 1, a5, a6);
                        if (b02.X(r3.f4631b) || r3 != y.p(b02)) {
                            throw new RuntimeException("year, month, and day not valid for Era");
                        }
                        return new x(r3, a4, b02);
                    }
                    if (a4 < 1) {
                        throw new RuntimeException("Invalid YearOfEra: " + a4);
                    }
                    int i4 = (r3.f4631b.f4713a + a4) - 1;
                    try {
                        Y3 = new x(j$.time.h.b0(i4, a5, a6));
                    } catch (j$.time.c unused) {
                        Y3 = new x(j$.time.h.b0(i4, a5, 1)).Y(new j$.time.i(2));
                    }
                    if (Y3.f4626b == r3 || Y3.g(j$.time.temporal.a.YEAR_OF_ERA) <= 1 || a4 <= 1) {
                        return Y3;
                    }
                    throw new RuntimeException("Invalid YearOfEra for Era: " + r3 + " " + a4);
                }
            }
            j$.time.temporal.a aVar5 = j$.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar5)) {
                map.remove(aVar);
                map.remove(aVar2);
                if (xVar == j$.time.format.x.LENIENT) {
                    return new x(j$.time.h.d0((r3.f4631b.f4713a + a4) - 1, 1)).P(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), j$.time.temporal.b.DAYS);
                }
                int a7 = y(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5);
                j$.time.h hVar2 = x.f4624d;
                if (a4 == 1) {
                    j$.time.h hVar3 = r3.f4631b;
                    d02 = j$.time.h.d0(hVar3.f4713a, (hVar3.V() + a7) - 1);
                } else {
                    d02 = j$.time.h.d0((r3.f4631b.f4713a + a4) - 1, a7);
                }
                if (d02.X(r3.f4631b) || r3 != y.p(d02)) {
                    throw new RuntimeException("Invalid parameters");
                }
                return new x(r3, a4, d02);
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
