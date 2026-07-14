package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class g implements e {

    /* renamed from: b, reason: collision with root package name */
    public static volatile Map.Entry f4652b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Map.Entry f4653c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4654a;

    public /* synthetic */ g(int i4) {
        this.f4654a = i4;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        switch (this.f4654a) {
            case 0:
                Long a4 = sVar.a(j$.time.temporal.a.INSTANT_SECONDS);
                TemporalAccessor temporalAccessor = sVar.f4692a;
                j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
                Long valueOf = temporalAccessor.h(aVar) ? Long.valueOf(temporalAccessor.i(aVar)) : null;
                int i4 = 0;
                if (a4 == null) {
                    return false;
                }
                long longValue = a4.longValue();
                int a5 = aVar.f4747b.a(valueOf != null ? valueOf.longValue() : 0L, aVar);
                if (longValue >= -62167219200L) {
                    long j4 = longValue - 253402300800L;
                    long floorDiv = Math.floorDiv(j4, 315569520000L) + 1;
                    LocalDateTime P = LocalDateTime.P(Math.floorMod(j4, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                    if (floorDiv > 0) {
                        sb.append('+');
                        sb.append(floorDiv);
                    }
                    sb.append(P);
                    if (P.f4560b.f4726c == 0) {
                        sb.append(":00");
                    }
                } else {
                    long j5 = longValue + 62167219200L;
                    long j6 = j5 / 315569520000L;
                    long j7 = j5 % 315569520000L;
                    LocalDateTime P3 = LocalDateTime.P(j7 - 62167219200L, 0, ZoneOffset.UTC);
                    int length = sb.length();
                    sb.append(P3);
                    if (P3.f4560b.f4726c == 0) {
                        sb.append(":00");
                    }
                    if (j6 < 0) {
                        if (P3.f4559a.f4713a == -10000) {
                            sb.replace(length, length + 2, Long.toString(j6 - 1));
                        } else if (j7 == 0) {
                            sb.insert(length, j6);
                        } else {
                            sb.insert(length + 1, Math.abs(j6));
                        }
                    }
                }
                if (a5 > 0) {
                    sb.append('.');
                    int i5 = 100000000;
                    while (true) {
                        if (a5 > 0 || i4 % 3 != 0 || i4 < -2) {
                            int i6 = a5 / i5;
                            sb.append((char) (i6 + 48));
                            a5 -= i6 * i5;
                            i5 /= 10;
                            i4++;
                        }
                    }
                }
                sb.append('Z');
                return true;
            default:
                j$.time.i iVar = o.f4678f;
                TemporalAccessor temporalAccessor2 = sVar.f4692a;
                Object b4 = temporalAccessor2.b(iVar);
                if (b4 == null && sVar.f4694c == 0) {
                    throw new RuntimeException("Unable to extract " + iVar + " from temporal " + temporalAccessor2);
                }
                ZoneId zoneId = (ZoneId) b4;
                if (zoneId == null) {
                    return false;
                }
                sb.append(zoneId.q());
                return true;
        }
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i4) {
        int i5;
        int i6 = 1;
        switch (this.f4654a) {
            case 0:
                o oVar = new o();
                oVar.a(DateTimeFormatter.ISO_LOCAL_DATE);
                oVar.c('T');
                j$.time.temporal.a aVar = j$.time.temporal.a.HOUR_OF_DAY;
                oVar.g(aVar, 2);
                oVar.c(':');
                j$.time.temporal.a aVar2 = j$.time.temporal.a.MINUTE_OF_HOUR;
                oVar.g(aVar2, 2);
                oVar.c(':');
                j$.time.temporal.a aVar3 = j$.time.temporal.a.SECOND_OF_MINUTE;
                oVar.g(aVar3, 2);
                j$.time.temporal.a aVar4 = j$.time.temporal.a.NANO_OF_SECOND;
                oVar.b(new f(aVar4));
                oVar.c('Z');
                d dVar = oVar.l(Locale.getDefault(), x.SMART, null).f4640a;
                if (dVar.f4650b) {
                    dVar = new d(dVar.f4649a, false);
                }
                p pVar2 = new p(pVar.f4684a);
                pVar2.f4685b = pVar.f4685b;
                pVar2.f4686c = pVar.f4686c;
                int A3 = dVar.A(pVar2, charSequence, i4);
                if (A3 < 0) {
                    return A3;
                }
                long longValue = pVar2.d(j$.time.temporal.a.YEAR).longValue();
                int intValue = pVar2.d(j$.time.temporal.a.MONTH_OF_YEAR).intValue();
                int intValue2 = pVar2.d(j$.time.temporal.a.DAY_OF_MONTH).intValue();
                int intValue3 = pVar2.d(aVar).intValue();
                int intValue4 = pVar2.d(aVar2).intValue();
                Long d4 = pVar2.d(aVar3);
                Long d5 = pVar2.d(aVar4);
                int intValue5 = d4 != null ? d4.intValue() : 0;
                int intValue6 = d5 != null ? d5.intValue() : 0;
                if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
                    intValue3 = 0;
                } else if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
                    pVar.c().f4701d = true;
                    i6 = 0;
                    intValue5 = 59;
                } else {
                    i6 = 0;
                }
                int i7 = ((int) longValue) % 10000;
                try {
                    LocalDateTime localDateTime = LocalDateTime.f4557c;
                    return pVar.f(aVar4, intValue6, i4, pVar.f(j$.time.temporal.a.INSTANT_SECONDS, new LocalDateTime(j$.time.h.b0(i7, intValue, intValue2), j$.time.l.P(intValue3, intValue4, intValue5, 0)).plusDays(i6).w(ZoneOffset.UTC) + Math.multiplyExact(longValue / 10000, 315569520000L), i4, A3));
                } catch (RuntimeException unused) {
                    return ~i4;
                }
            default:
                int length = charSequence.length();
                if (i4 > length) {
                    throw new IndexOutOfBoundsException();
                }
                if (i4 != length) {
                    char charAt = charSequence.charAt(i4);
                    if (charAt == '+' || charAt == '-') {
                        return a(pVar, charSequence, i4, i4, i.f4662e);
                    }
                    int i8 = i4 + 2;
                    if (length >= i8) {
                        char charAt2 = charSequence.charAt(i4 + 1);
                        if (pVar.a(charAt, 'U') && pVar.a(charAt2, 'T')) {
                            int i9 = i4 + 3;
                            return (length < i9 || !pVar.a(charSequence.charAt(i8), 'C')) ? a(pVar, charSequence, i4, i8, i.f4663f) : a(pVar, charSequence, i4, i9, i.f4663f);
                        }
                        if (pVar.a(charAt, 'G') && length >= (i5 = i4 + 3) && pVar.a(charAt2, 'M') && pVar.a(charSequence.charAt(i8), 'T')) {
                            int i10 = i4 + 4;
                            if (length < i10 || !pVar.a(charSequence.charAt(i5), '0')) {
                                return a(pVar, charSequence, i4, i5, i.f4663f);
                            }
                            pVar.e(ZoneId.of("GMT0"));
                            return i10;
                        }
                    }
                    Set<String> set = j$.time.zone.i.f4821d;
                    int size = set.size();
                    Map.Entry entry = pVar.f4685b ? f4652b : f4653c;
                    if (entry == null || ((Integer) entry.getKey()).intValue() != size) {
                        synchronized (this) {
                            try {
                                entry = pVar.f4685b ? f4652b : f4653c;
                                if (entry == null || ((Integer) entry.getKey()).intValue() != size) {
                                    Integer valueOf = Integer.valueOf(size);
                                    k kVar = pVar.f4685b ? new k("", null, null) : new k("", null, null);
                                    for (String str : set) {
                                        kVar.a(str, str);
                                    }
                                    entry = new AbstractMap.SimpleImmutableEntry(valueOf, kVar);
                                    if (pVar.f4685b) {
                                        f4652b = entry;
                                    } else {
                                        f4653c = entry;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    k kVar2 = (k) entry.getValue();
                    ParsePosition parsePosition = new ParsePosition(i4);
                    String c4 = kVar2.c(charSequence, parsePosition);
                    if (c4 != null) {
                        pVar.e(ZoneId.of(c4));
                        return parsePosition.getIndex();
                    }
                    if (pVar.a(charAt, 'Z')) {
                        pVar.e(ZoneOffset.UTC);
                        return i4 + 1;
                    }
                }
                return ~i4;
        }
    }

    public static int a(p pVar, CharSequence charSequence, int i4, int i5, i iVar) {
        String upperCase = charSequence.subSequence(i4, i5).toString().toUpperCase();
        if (i5 >= charSequence.length()) {
            pVar.e(ZoneId.of(upperCase));
            return i5;
        }
        if (charSequence.charAt(i5) != '0' && !pVar.a(charSequence.charAt(i5), 'Z')) {
            p pVar2 = new p(pVar.f4684a);
            pVar2.f4685b = pVar.f4685b;
            pVar2.f4686c = pVar.f4686c;
            int A3 = iVar.A(pVar2, charSequence, i5);
            try {
                if (A3 < 0) {
                    if (iVar == i.f4662e) {
                        return ~i4;
                    }
                    pVar.e(ZoneId.of(upperCase));
                    return i5;
                }
                pVar.e(ZoneId.F(upperCase, ZoneOffset.Y((int) pVar2.d(j$.time.temporal.a.OFFSET_SECONDS).longValue())));
                return A3;
            } catch (j$.time.c unused) {
                return ~i4;
            }
        }
        pVar.e(ZoneId.of(upperCase));
        return i5;
    }

    public final String toString() {
        switch (this.f4654a) {
            case 0:
                return "Instant()";
            default:
                return "ZoneRegionId()";
        }
    }
}
