package j$.time.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: f, reason: collision with root package name */
    public static final j$.time.i f2581f = new j$.time.i(1);

    /* renamed from: a, reason: collision with root package name */
    public o f2582a;

    /* renamed from: b, reason: collision with root package name */
    public final o f2583b;

    /* renamed from: c, reason: collision with root package name */
    public final List f2584c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f2585d;

    /* renamed from: e, reason: collision with root package name */
    public int f2586e;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put('G', j$.time.temporal.a.ERA);
        hashMap.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        hashMap.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.h hVar = j$.time.temporal.j.f2658a;
        hashMap.put('Q', hVar);
        hashMap.put('q', hVar);
        j$.time.temporal.a aVar = j$.time.temporal.a.MONTH_OF_YEAR;
        hashMap.put('M', aVar);
        hashMap.put('L', aVar);
        hashMap.put('D', j$.time.temporal.a.DAY_OF_YEAR);
        hashMap.put('d', j$.time.temporal.a.DAY_OF_MONTH);
        hashMap.put('F', j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_WEEK;
        hashMap.put('E', aVar2);
        hashMap.put('c', aVar2);
        hashMap.put('e', aVar2);
        hashMap.put('a', j$.time.temporal.a.AMPM_OF_DAY);
        hashMap.put('H', j$.time.temporal.a.HOUR_OF_DAY);
        hashMap.put('k', j$.time.temporal.a.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', j$.time.temporal.a.HOUR_OF_AMPM);
        hashMap.put('h', j$.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', j$.time.temporal.a.MINUTE_OF_HOUR);
        hashMap.put('s', j$.time.temporal.a.SECOND_OF_MINUTE);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_SECOND;
        hashMap.put('S', aVar3);
        hashMap.put('A', j$.time.temporal.a.MILLI_OF_DAY);
        hashMap.put('n', aVar3);
        hashMap.put('N', j$.time.temporal.a.NANO_OF_DAY);
        hashMap.put('g', j$.time.temporal.l.f2665a);
    }

    public o() {
        this.f2582a = this;
        this.f2584c = new ArrayList();
        this.f2586e = -1;
        this.f2583b = null;
        this.f2585d = false;
    }

    public o(o oVar) {
        this.f2582a = this;
        this.f2584c = new ArrayList();
        this.f2586e = -1;
        this.f2583b = oVar;
        this.f2585d = true;
    }

    public final void g(j$.time.temporal.q qVar, int i2) {
        Objects.requireNonNull(qVar, "field");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i2);
        }
        f(new h(qVar, i2, i2, y.NOT_NEGATIVE));
    }

    public final void h(j$.time.temporal.q qVar, int i2, int i3, y yVar) {
        if (i2 == i3 && yVar == y.NOT_NEGATIVE) {
            g(qVar, i3);
            return;
        }
        Objects.requireNonNull(qVar, "field");
        Objects.requireNonNull(yVar, "signStyle");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i2);
        }
        if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i3);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
        }
        f(new h(qVar, i2, i3, yVar));
    }

    public final void f(h hVar) {
        h b2;
        o oVar = this.f2582a;
        int i2 = oVar.f2586e;
        if (i2 >= 0) {
            h hVar2 = (h) ((ArrayList) oVar.f2584c).get(i2);
            int i3 = hVar.f2560b;
            int i4 = hVar.f2561c;
            if (i3 == i4 && hVar.f2562d == y.NOT_NEGATIVE) {
                b2 = hVar2.c(i4);
                b(hVar.b());
                this.f2582a.f2586e = i2;
            } else {
                b2 = hVar2.b();
                this.f2582a.f2586e = b(hVar);
            }
            ((ArrayList) this.f2582a.f2584c).set(i2, b2);
            return;
        }
        oVar.f2586e = b(hVar);
    }

    public final void e(j$.time.temporal.a aVar, Map map) {
        Objects.requireNonNull(aVar, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        z zVar = z.FULL;
        b(new n(aVar, zVar, new a(new u(Collections.singletonMap(zVar, linkedHashMap)))));
    }

    public final void c(char c2) {
        b(new c(c2));
    }

    public final void d(String str) {
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            b(new c(str.charAt(0)));
        } else {
            b(new m(str));
        }
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        d dVar = dateTimeFormatter.f2543a;
        if (dVar.f2553b) {
            dVar = new d(dVar.f2552a, false);
        }
        b(dVar);
    }

    public final void j() {
        o oVar = this.f2582a;
        oVar.f2586e = -1;
        this.f2582a = new o(oVar);
    }

    public final void i() {
        o oVar = this.f2582a;
        if (oVar.f2583b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (((ArrayList) oVar.f2584c).size() > 0) {
            o oVar2 = this.f2582a;
            d dVar = new d(oVar2.f2584c, oVar2.f2585d);
            this.f2582a = this.f2582a.f2583b;
            b(dVar);
            return;
        }
        this.f2582a = this.f2582a.f2583b;
    }

    public final int b(e eVar) {
        Objects.requireNonNull(eVar, "pp");
        o oVar = this.f2582a;
        oVar.getClass();
        ((ArrayList) oVar.f2584c).add(eVar);
        this.f2582a.f2586e = -1;
        return ((ArrayList) r2.f2584c).size() - 1;
    }

    public final DateTimeFormatter k(x xVar, j$.time.chrono.l lVar) {
        return l(Locale.getDefault(), xVar, lVar);
    }

    public final DateTimeFormatter l(Locale locale, x xVar, j$.time.chrono.l lVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.f2582a.f2583b != null) {
            i();
        }
        d dVar = new d(this.f2584c, false);
        v vVar = v.f2600a;
        return new DateTimeFormatter(dVar, locale, xVar, lVar);
    }
}
