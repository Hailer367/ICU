package j$.time.format;

import j$.time.temporal.TemporalAccessor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_LOCAL_DATE;
    public static final DateTimeFormatter ISO_LOCAL_DATE_TIME;

    /* renamed from: f, reason: collision with root package name */
    public static final DateTimeFormatter f2542f;

    /* renamed from: a, reason: collision with root package name */
    public final d f2543a;

    /* renamed from: b, reason: collision with root package name */
    public final Locale f2544b;

    /* renamed from: c, reason: collision with root package name */
    public final v f2545c;

    /* renamed from: d, reason: collision with root package name */
    public final x f2546d;

    /* renamed from: e, reason: collision with root package name */
    public final j$.time.chrono.l f2547e;

    static {
        o oVar = new o();
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        y yVar = y.EXCEEDS_PAD;
        oVar.h(aVar, 4, 10, yVar);
        oVar.c('-');
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        oVar.g(aVar2, 2);
        oVar.c('-');
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        oVar.g(aVar3, 2);
        x xVar = x.STRICT;
        j$.time.chrono.s sVar = j$.time.chrono.s.f2522c;
        DateTimeFormatter k2 = oVar.k(xVar, sVar);
        ISO_LOCAL_DATE = k2;
        o oVar2 = new o();
        l lVar = l.INSENSITIVE;
        oVar2.b(lVar);
        oVar2.a(k2);
        i iVar = i.f2565e;
        oVar2.b(iVar);
        oVar2.k(xVar, sVar);
        o oVar3 = new o();
        oVar3.b(lVar);
        oVar3.a(k2);
        oVar3.j();
        oVar3.b(iVar);
        oVar3.k(xVar, sVar);
        o oVar4 = new o();
        j$.time.temporal.a aVar4 = j$.time.temporal.a.HOUR_OF_DAY;
        oVar4.g(aVar4, 2);
        oVar4.c(':');
        j$.time.temporal.a aVar5 = j$.time.temporal.a.MINUTE_OF_HOUR;
        oVar4.g(aVar5, 2);
        oVar4.j();
        oVar4.c(':');
        j$.time.temporal.a aVar6 = j$.time.temporal.a.SECOND_OF_MINUTE;
        oVar4.g(aVar6, 2);
        oVar4.j();
        oVar4.b(new f(j$.time.temporal.a.NANO_OF_SECOND));
        DateTimeFormatter k3 = oVar4.k(xVar, null);
        o oVar5 = new o();
        oVar5.b(lVar);
        oVar5.a(k3);
        oVar5.b(iVar);
        oVar5.k(xVar, null);
        o oVar6 = new o();
        oVar6.b(lVar);
        oVar6.a(k3);
        oVar6.j();
        oVar6.b(iVar);
        oVar6.k(xVar, null);
        o oVar7 = new o();
        oVar7.b(lVar);
        oVar7.a(k2);
        oVar7.c('T');
        oVar7.a(k3);
        DateTimeFormatter k4 = oVar7.k(xVar, sVar);
        ISO_LOCAL_DATE_TIME = k4;
        o oVar8 = new o();
        oVar8.b(lVar);
        oVar8.a(k4);
        l lVar2 = l.LENIENT;
        oVar8.b(lVar2);
        oVar8.b(iVar);
        l lVar3 = l.STRICT;
        oVar8.b(lVar3);
        DateTimeFormatter k5 = oVar8.k(xVar, sVar);
        o oVar9 = new o();
        oVar9.a(k5);
        oVar9.j();
        oVar9.c('[');
        l lVar4 = l.SENSITIVE;
        oVar9.b(lVar4);
        oVar9.b(new g(1));
        oVar9.c(']');
        oVar9.k(xVar, sVar);
        o oVar10 = new o();
        oVar10.a(k4);
        oVar10.j();
        oVar10.b(iVar);
        oVar10.j();
        oVar10.c('[');
        oVar10.b(lVar4);
        oVar10.b(new g(1));
        oVar10.c(']');
        oVar10.k(xVar, sVar);
        o oVar11 = new o();
        oVar11.b(lVar);
        oVar11.h(aVar, 4, 10, yVar);
        oVar11.c('-');
        oVar11.g(j$.time.temporal.a.DAY_OF_YEAR, 3);
        oVar11.j();
        oVar11.b(iVar);
        oVar11.k(xVar, sVar);
        o oVar12 = new o();
        oVar12.b(lVar);
        oVar12.h(j$.time.temporal.j.f2660c, 4, 10, yVar);
        oVar12.d("-W");
        oVar12.g(j$.time.temporal.j.f2659b, 2);
        oVar12.c('-');
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_WEEK;
        oVar12.g(aVar7, 1);
        oVar12.j();
        oVar12.b(iVar);
        oVar12.k(xVar, sVar);
        o oVar13 = new o();
        oVar13.b(lVar);
        oVar13.b(new g(0));
        f2542f = oVar13.k(xVar, null);
        o oVar14 = new o();
        oVar14.b(lVar);
        oVar14.g(aVar, 4);
        oVar14.g(aVar2, 2);
        oVar14.g(aVar3, 2);
        oVar14.j();
        oVar14.b(lVar2);
        oVar14.b(new i("+HHMMss", "Z"));
        oVar14.b(lVar3);
        oVar14.k(xVar, sVar);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        o oVar15 = new o();
        oVar15.b(lVar);
        oVar15.b(lVar2);
        oVar15.j();
        oVar15.e(aVar7, hashMap);
        oVar15.d(", ");
        oVar15.i();
        oVar15.h(aVar3, 1, 2, y.NOT_NEGATIVE);
        oVar15.c(' ');
        oVar15.e(aVar2, hashMap2);
        oVar15.c(' ');
        oVar15.g(aVar, 4);
        oVar15.c(' ');
        oVar15.g(aVar4, 2);
        oVar15.c(':');
        oVar15.g(aVar5, 2);
        oVar15.j();
        oVar15.c(':');
        oVar15.g(aVar6, 2);
        oVar15.i();
        oVar15.c(' ');
        oVar15.b(new i("+HHMM", "GMT"));
        oVar15.k(x.SMART, sVar);
    }

    public DateTimeFormatter(d dVar, Locale locale, x xVar, j$.time.chrono.l lVar) {
        v vVar = v.f2600a;
        this.f2543a = dVar;
        Objects.requireNonNull(locale, "locale");
        this.f2544b = locale;
        this.f2545c = vVar;
        Objects.requireNonNull(xVar, "resolverStyle");
        this.f2546d = xVar;
        this.f2547e = lVar;
    }

    public String format(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        d dVar = this.f2543a;
        Objects.requireNonNull(temporalAccessor, "temporal");
        try {
            dVar.s(new s(temporalAccessor, this), sb);
            return sb.toString();
        } catch (IOException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x032e, code lost:
    
        if (((java.util.HashMap) r8.f2601a).containsKey(j$.time.temporal.a.SECOND_OF_MINUTE) != false) goto L132;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x030c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.format.w a(java.lang.CharSequence r27) {
        /*
            Method dump skipped, instructions count: 1106
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatter.a(java.lang.CharSequence):j$.time.format.w");
    }

    public final String toString() {
        String dVar = this.f2543a.toString();
        return dVar.startsWith("[") ? dVar : dVar.substring(1, dVar.length() - 1);
    }
}
