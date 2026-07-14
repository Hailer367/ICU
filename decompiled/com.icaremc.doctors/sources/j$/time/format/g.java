package j$.time.format;

import com.google.firebase.encoders.json.BuildConfig;
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
    public static volatile Map.Entry f2555b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Map.Entry f2556c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2557a;

    public /* synthetic */ g(int i2) {
        this.f2557a = i2;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        switch (this.f2557a) {
            case 0:
                Long a2 = sVar.a(j$.time.temporal.a.INSTANT_SECONDS);
                TemporalAccessor temporalAccessor = sVar.f2595a;
                j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
                Long valueOf = temporalAccessor.h(aVar) ? Long.valueOf(temporalAccessor.i(aVar)) : null;
                int i2 = 0;
                if (a2 == null) {
                    return false;
                }
                long longValue = a2.longValue();
                int a3 = aVar.f2650b.a(valueOf != null ? valueOf.longValue() : 0L, aVar);
                if (longValue >= -62167219200L) {
                    long j2 = longValue - 253402300800L;
                    long floorDiv = Math.floorDiv(j2, 315569520000L) + 1;
                    LocalDateTime P2 = LocalDateTime.P(Math.floorMod(j2, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                    if (floorDiv > 0) {
                        sb.append('+');
                        sb.append(floorDiv);
                    }
                    sb.append(P2);
                    if (P2.f2462b.f2629c == 0) {
                        sb.append(":00");
                    }
                } else {
                    long j3 = longValue + 62167219200L;
                    long j4 = j3 / 315569520000L;
                    long j5 = j3 % 315569520000L;
                    LocalDateTime P3 = LocalDateTime.P(j5 - 62167219200L, 0, ZoneOffset.UTC);
                    int length = sb.length();
                    sb.append(P3);
                    if (P3.f2462b.f2629c == 0) {
                        sb.append(":00");
                    }
                    if (j4 < 0) {
                        if (P3.f2461a.f2616a == -10000) {
                            sb.replace(length, length + 2, Long.toString(j4 - 1));
                        } else if (j5 == 0) {
                            sb.insert(length, j4);
                        } else {
                            sb.insert(length + 1, Math.abs(j4));
                        }
                    }
                }
                if (a3 > 0) {
                    sb.append('.');
                    int i3 = 100000000;
                    while (true) {
                        if (a3 > 0 || i2 % 3 != 0 || i2 < -2) {
                            int i4 = a3 / i3;
                            sb.append((char) (i4 + 48));
                            a3 -= i4 * i3;
                            i3 /= 10;
                            i2++;
                        }
                    }
                }
                sb.append('Z');
                return true;
            default:
                j$.time.i iVar = o.f2581f;
                TemporalAccessor temporalAccessor2 = sVar.f2595a;
                Object b2 = temporalAccessor2.b(iVar);
                if (b2 == null && sVar.f2597c == 0) {
                    throw new RuntimeException("Unable to extract " + iVar + " from temporal " + temporalAccessor2);
                }
                ZoneId zoneId = (ZoneId) b2;
                if (zoneId == null) {
                    return false;
                }
                sb.append(zoneId.q());
                return true;
        }
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i2) {
        int i3;
        int i4 = 1;
        switch (this.f2557a) {
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
                d dVar = oVar.l(Locale.getDefault(), x.SMART, null).f2543a;
                if (dVar.f2553b) {
                    dVar = new d(dVar.f2552a, false);
                }
                p pVar2 = new p(pVar.f2587a);
                pVar2.f2588b = pVar.f2588b;
                pVar2.f2589c = pVar.f2589c;
                int A2 = dVar.A(pVar2, charSequence, i2);
                if (A2 < 0) {
                    return A2;
                }
                long longValue = pVar2.d(j$.time.temporal.a.YEAR).longValue();
                int intValue = pVar2.d(j$.time.temporal.a.MONTH_OF_YEAR).intValue();
                int intValue2 = pVar2.d(j$.time.temporal.a.DAY_OF_MONTH).intValue();
                int intValue3 = pVar2.d(aVar).intValue();
                int intValue4 = pVar2.d(aVar2).intValue();
                Long d2 = pVar2.d(aVar3);
                Long d3 = pVar2.d(aVar4);
                int intValue5 = d2 != null ? d2.intValue() : 0;
                int intValue6 = d3 != null ? d3.intValue() : 0;
                if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
                    intValue3 = 0;
                } else if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
                    pVar.c().f2604d = true;
                    i4 = 0;
                    intValue5 = 59;
                } else {
                    i4 = 0;
                }
                int i5 = ((int) longValue) % 10000;
                try {
                    LocalDateTime localDateTime = LocalDateTime.f2459c;
                    return pVar.f(aVar4, intValue6, i2, pVar.f(j$.time.temporal.a.INSTANT_SECONDS, new LocalDateTime(j$.time.h.b0(i5, intValue, intValue2), j$.time.l.P(intValue3, intValue4, intValue5, 0)).plusDays(i4).w(ZoneOffset.UTC) + Math.multiplyExact(longValue / 10000, 315569520000L), i2, A2));
                } catch (RuntimeException unused) {
                    return ~i2;
                }
            default:
                int length = charSequence.length();
                if (i2 > length) {
                    throw new IndexOutOfBoundsException();
                }
                if (i2 != length) {
                    char charAt = charSequence.charAt(i2);
                    if (charAt == '+' || charAt == '-') {
                        return a(pVar, charSequence, i2, i2, i.f2565e);
                    }
                    int i6 = i2 + 2;
                    if (length >= i6) {
                        char charAt2 = charSequence.charAt(i2 + 1);
                        if (pVar.a(charAt, 'U') && pVar.a(charAt2, 'T')) {
                            int i7 = i2 + 3;
                            return (length < i7 || !pVar.a(charSequence.charAt(i6), 'C')) ? a(pVar, charSequence, i2, i6, i.f2566f) : a(pVar, charSequence, i2, i7, i.f2566f);
                        }
                        if (pVar.a(charAt, 'G') && length >= (i3 = i2 + 3) && pVar.a(charAt2, 'M') && pVar.a(charSequence.charAt(i6), 'T')) {
                            int i8 = i2 + 4;
                            if (length < i8 || !pVar.a(charSequence.charAt(i3), '0')) {
                                return a(pVar, charSequence, i2, i3, i.f2566f);
                            }
                            pVar.e(ZoneId.of("GMT0"));
                            return i8;
                        }
                    }
                    Set<String> set = j$.time.zone.i.f2725d;
                    int size = set.size();
                    Map.Entry entry = pVar.f2588b ? f2555b : f2556c;
                    if (entry == null || ((Integer) entry.getKey()).intValue() != size) {
                        synchronized (this) {
                            try {
                                entry = pVar.f2588b ? f2555b : f2556c;
                                if (entry == null || ((Integer) entry.getKey()).intValue() != size) {
                                    Integer valueOf = Integer.valueOf(size);
                                    k kVar = pVar.f2588b ? new k(BuildConfig.FLAVOR, null, null) : new k(BuildConfig.FLAVOR, null, null);
                                    for (String str : set) {
                                        kVar.a(str, str);
                                    }
                                    entry = new AbstractMap.SimpleImmutableEntry(valueOf, kVar);
                                    if (pVar.f2588b) {
                                        f2555b = entry;
                                    } else {
                                        f2556c = entry;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    k kVar2 = (k) entry.getValue();
                    ParsePosition parsePosition = new ParsePosition(i2);
                    String c2 = kVar2.c(charSequence, parsePosition);
                    if (c2 != null) {
                        pVar.e(ZoneId.of(c2));
                        return parsePosition.getIndex();
                    }
                    if (pVar.a(charAt, 'Z')) {
                        pVar.e(ZoneOffset.UTC);
                        return i2 + 1;
                    }
                }
                return ~i2;
        }
    }

    public static int a(p pVar, CharSequence charSequence, int i2, int i3, i iVar) {
        String upperCase = charSequence.subSequence(i2, i3).toString().toUpperCase();
        if (i3 >= charSequence.length()) {
            pVar.e(ZoneId.of(upperCase));
            return i3;
        }
        if (charSequence.charAt(i3) != '0' && !pVar.a(charSequence.charAt(i3), 'Z')) {
            p pVar2 = new p(pVar.f2587a);
            pVar2.f2588b = pVar.f2588b;
            pVar2.f2589c = pVar.f2589c;
            int A2 = iVar.A(pVar2, charSequence, i3);
            try {
                if (A2 < 0) {
                    if (iVar == i.f2565e) {
                        return ~i2;
                    }
                    pVar.e(ZoneId.of(upperCase));
                    return i3;
                }
                pVar.e(ZoneId.F(upperCase, ZoneOffset.Y((int) pVar2.d(j$.time.temporal.a.OFFSET_SECONDS).longValue())));
                return A2;
            } catch (j$.time.c unused) {
                return ~i2;
            }
        }
        pVar.e(ZoneId.of(upperCase));
        return i3;
    }

    public final String toString() {
        switch (this.f2557a) {
            case 0:
                return "Instant()";
            default:
                return "ZoneRegionId()";
        }
    }
}
