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
    public static final j$.time.i f4678f = new j$.time.i(1);

    /* renamed from: a, reason: collision with root package name */
    public o f4679a;

    /* renamed from: b, reason: collision with root package name */
    public final o f4680b;

    /* renamed from: c, reason: collision with root package name */
    public final List f4681c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4682d;

    /* renamed from: e, reason: collision with root package name */
    public int f4683e;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put('G', j$.time.temporal.a.ERA);
        hashMap.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        hashMap.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.h hVar = j$.time.temporal.j.f4755a;
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
        hashMap.put('g', j$.time.temporal.l.f4762a);
    }

    public o() {
        this.f4679a = this;
        this.f4681c = new ArrayList();
        this.f4683e = -1;
        this.f4680b = null;
        this.f4682d = false;
    }

    public o(o oVar) {
        this.f4679a = this;
        this.f4681c = new ArrayList();
        this.f4683e = -1;
        this.f4680b = oVar;
        this.f4682d = true;
    }

    public final void g(j$.time.temporal.q qVar, int i4) {
        Objects.requireNonNull(qVar, "field");
        if (i4 < 1 || i4 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i4);
        }
        f(new h(qVar, i4, i4, y.NOT_NEGATIVE));
    }

    public final void h(j$.time.temporal.q qVar, int i4, int i5, y yVar) {
        if (i4 == i5 && yVar == y.NOT_NEGATIVE) {
            g(qVar, i5);
            return;
        }
        Objects.requireNonNull(qVar, "field");
        Objects.requireNonNull(yVar, "signStyle");
        if (i4 < 1 || i4 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i4);
        }
        if (i5 < 1 || i5 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i5);
        }
        if (i5 < i4) {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i5 + " < " + i4);
        }
        f(new h(qVar, i4, i5, yVar));
    }

    public final void f(h hVar) {
        h b4;
        o oVar = this.f4679a;
        int i4 = oVar.f4683e;
        if (i4 >= 0) {
            h hVar2 = (h) ((ArrayList) oVar.f4681c).get(i4);
            int i5 = hVar.f4657b;
            int i6 = hVar.f4658c;
            if (i5 == i6 && hVar.f4659d == y.NOT_NEGATIVE) {
                b4 = hVar2.c(i6);
                b(hVar.b());
                this.f4679a.f4683e = i4;
            } else {
                b4 = hVar2.b();
                this.f4679a.f4683e = b(hVar);
            }
            ((ArrayList) this.f4679a.f4681c).set(i4, b4);
            return;
        }
        oVar.f4683e = b(hVar);
    }

    public final void e(j$.time.temporal.a aVar, Map map) {
        Objects.requireNonNull(aVar, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        z zVar = z.FULL;
        b(new n(aVar, zVar, new a(new u(Collections.singletonMap(zVar, linkedHashMap)))));
    }

    public final void c(char c4) {
        b(new c(c4));
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
        d dVar = dateTimeFormatter.f4640a;
        if (dVar.f4650b) {
            dVar = new d(dVar.f4649a, false);
        }
        b(dVar);
    }

    public final void j() {
        o oVar = this.f4679a;
        oVar.f4683e = -1;
        this.f4679a = new o(oVar);
    }

    public final void i() {
        o oVar = this.f4679a;
        if (oVar.f4680b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (((ArrayList) oVar.f4681c).size() > 0) {
            o oVar2 = this.f4679a;
            d dVar = new d(oVar2.f4681c, oVar2.f4682d);
            this.f4679a = this.f4679a.f4680b;
            b(dVar);
            return;
        }
        this.f4679a = this.f4679a.f4680b;
    }

    public final int b(e eVar) {
        Objects.requireNonNull(eVar, "pp");
        o oVar = this.f4679a;
        oVar.getClass();
        ((ArrayList) oVar.f4681c).add(eVar);
        this.f4679a.f4683e = -1;
        return ((ArrayList) r2.f4681c).size() - 1;
    }

    public final DateTimeFormatter k(x xVar, j$.time.chrono.l lVar) {
        return l(Locale.getDefault(), xVar, lVar);
    }

    public final DateTimeFormatter l(Locale locale, x xVar, j$.time.chrono.l lVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.f4679a.f4680b != null) {
            i();
        }
        d dVar = new d(this.f4681c, false);
        v vVar = v.f4697a;
        return new DateTimeFormatter(dVar, locale, xVar, lVar);
    }
}
