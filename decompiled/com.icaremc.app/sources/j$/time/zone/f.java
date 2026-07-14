package j$.time.zone;

import j$.time.DayOfWeek;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.s;
import j$.time.l;
import j$.time.n;
import j$.time.temporal.o;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class f implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final long[] f4807i = new long[0];

    /* renamed from: j, reason: collision with root package name */
    public static final e[] f4808j = new e[0];
    public static final LocalDateTime[] k = new LocalDateTime[0];

    /* renamed from: l, reason: collision with root package name */
    public static final b[] f4809l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* renamed from: a, reason: collision with root package name */
    public final long[] f4810a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset[] f4811b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f4812c;

    /* renamed from: d, reason: collision with root package name */
    public final LocalDateTime[] f4813d;

    /* renamed from: e, reason: collision with root package name */
    public final ZoneOffset[] f4814e;

    /* renamed from: f, reason: collision with root package name */
    public final e[] f4815f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeZone f4816g;

    /* renamed from: h, reason: collision with root package name */
    public final transient ConcurrentMap f4817h = new ConcurrentHashMap();

    public static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime localDateTime2 = bVar.f4793b;
        if (bVar.s()) {
            if (localDateTime.F(localDateTime2)) {
                return bVar.f4794c;
            }
            if (!localDateTime.F(bVar.f4793b.X(bVar.f4795d.f4569b - bVar.f4794c.f4569b))) {
                return bVar.f4795d;
            }
        } else {
            if (!localDateTime.F(localDateTime2)) {
                return bVar.f4795d;
            }
            if (localDateTime.F(bVar.f4793b.X(bVar.f4795d.f4569b - bVar.f4794c.f4569b))) {
                return bVar.f4794c;
            }
        }
        return bVar;
    }

    public f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.f4810a = jArr;
        this.f4811b = zoneOffsetArr;
        this.f4812c = jArr2;
        this.f4814e = zoneOffsetArr2;
        this.f4815f = eVarArr;
        if (jArr2.length == 0) {
            this.f4813d = k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            while (i4 < jArr2.length) {
                int i5 = i4 + 1;
                b bVar = new b(jArr2[i4], zoneOffsetArr2[i4], zoneOffsetArr2[i5]);
                if (bVar.s()) {
                    arrayList.add(bVar.f4793b);
                    arrayList.add(bVar.f4793b.X(bVar.f4795d.f4569b - bVar.f4794c.f4569b));
                } else {
                    arrayList.add(bVar.f4793b.X(bVar.f4795d.f4569b - bVar.f4794c.f4569b));
                    arrayList.add(bVar.f4793b);
                }
                i4 = i5;
            }
            this.f4813d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.f4816g = null;
    }

    public f(ZoneOffset zoneOffset) {
        this.f4811b = r0;
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        long[] jArr = f4807i;
        this.f4810a = jArr;
        this.f4812c = jArr;
        this.f4813d = k;
        this.f4814e = zoneOffsetArr;
        this.f4815f = f4808j;
        this.f4816g = null;
    }

    public f(TimeZone timeZone) {
        this.f4811b = r0;
        ZoneOffset[] zoneOffsetArr = {g(timeZone.getRawOffset())};
        long[] jArr = f4807i;
        this.f4810a = jArr;
        this.f4812c = jArr;
        this.f4813d = k;
        this.f4814e = zoneOffsetArr;
        this.f4815f = f4808j;
        this.f4816g = timeZone;
    }

    public static ZoneOffset g(int i4) {
        return ZoneOffset.Y(i4 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.f4816g != null ? (byte) 100 : (byte) 1, this);
    }

    public static int c(long j4, ZoneOffset zoneOffset) {
        return j$.time.h.c0(Math.floorDiv(j4 + zoneOffset.f4569b, 86400)).f4713a;
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f4816g;
        if (timeZone != null) {
            return g(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f4812c;
        if (jArr.length == 0) {
            return this.f4811b[0];
        }
        long j4 = instant.f4555a;
        if (this.f4815f.length > 0 && j4 > jArr[jArr.length - 1]) {
            b[] b4 = b(c(j4, this.f4814e[r8.length - 1]));
            b bVar = null;
            for (int i4 = 0; i4 < b4.length; i4++) {
                bVar = b4[i4];
                if (j4 < bVar.f4792a) {
                    return bVar.f4794c;
                }
            }
            return bVar.f4795d;
        }
        int binarySearch = Arrays.binarySearch(jArr, j4);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.f4814e[binarySearch + 1];
    }

    public final List f(LocalDateTime localDateTime) {
        Object e4 = e(localDateTime);
        if (e4 instanceof b) {
            b bVar = (b) e4;
            if (!bVar.s()) {
                return j$.time.b.a(new Object[]{bVar.f4794c, bVar.f4795d});
            }
            return Collections.EMPTY_LIST;
        }
        return Collections.singletonList((ZoneOffset) e4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        if (r8.s(r0) > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
    
        if (r8.f4560b.d0() <= r0.f4560b.d0()) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(j$.time.LocalDateTime r8) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.f.e(j$.time.LocalDateTime):java.lang.Object");
    }

    public final b[] b(int i4) {
        j$.time.h A3;
        b[] bVarArr = f4809l;
        Integer valueOf = Integer.valueOf(i4);
        b[] bVarArr2 = (b[]) ((ConcurrentHashMap) this.f4817h).get(valueOf);
        if (bVarArr2 != null) {
            return bVarArr2;
        }
        long j4 = 1;
        int i5 = 0;
        int i6 = 1;
        if (this.f4816g != null) {
            if (i4 < 1800) {
                return bVarArr;
            }
            LocalDateTime localDateTime = LocalDateTime.f4557c;
            j$.time.h b02 = j$.time.h.b0(i4 - 1, 12, 31);
            j$.time.temporal.a.HOUR_OF_DAY.X(0);
            long w2 = new LocalDateTime(b02, l.f4723h[0]).w(this.f4811b[0]);
            long j5 = 1000;
            int offset = this.f4816g.getOffset(w2 * 1000);
            long j6 = 31968000 + w2;
            while (w2 < j6) {
                long j7 = w2 + 7776000;
                long j8 = j5;
                if (offset != this.f4816g.getOffset(j7 * j8)) {
                    while (j7 - w2 > j4) {
                        long floorDiv = Math.floorDiv(j7 + w2, 2L);
                        if (this.f4816g.getOffset(floorDiv * j8) == offset) {
                            w2 = floorDiv;
                        } else {
                            j7 = floorDiv;
                        }
                        j4 = 1;
                    }
                    if (this.f4816g.getOffset(w2 * j8) == offset) {
                        w2 = j7;
                    }
                    ZoneOffset g4 = g(offset);
                    int offset2 = this.f4816g.getOffset(w2 * j8);
                    ZoneOffset g5 = g(offset2);
                    if (c(w2, g5) == i4) {
                        bVarArr = (b[]) Arrays.copyOf(bVarArr, bVarArr.length + 1);
                        bVarArr[bVarArr.length - 1] = new b(w2, g4, g5);
                    }
                    offset = offset2;
                } else {
                    w2 = j7;
                }
                j5 = j8;
                j4 = 1;
            }
            if (1916 <= i4 && i4 < 2100) {
                ((ConcurrentHashMap) this.f4817h).putIfAbsent(valueOf, bVarArr);
            }
            return bVarArr;
        }
        e[] eVarArr = this.f4815f;
        b[] bVarArr3 = new b[eVarArr.length];
        int i7 = 0;
        while (i7 < eVarArr.length) {
            e eVar = eVarArr[i7];
            byte b4 = eVar.f4799b;
            if (b4 < 0) {
                n nVar = eVar.f4798a;
                long j9 = i4;
                s.f4619c.getClass();
                int A4 = nVar.A(s.X(j9)) + 1 + eVar.f4799b;
                j$.time.h hVar = j$.time.h.f4711d;
                j$.time.temporal.a.YEAR.X(j9);
                j$.time.temporal.a.DAY_OF_MONTH.X(A4);
                A3 = j$.time.h.A(i4, nVar.getValue(), A4);
                DayOfWeek dayOfWeek = eVar.f4800c;
                if (dayOfWeek != null) {
                    A3 = A3.k(new o(dayOfWeek.getValue(), i6));
                }
            } else {
                n nVar2 = eVar.f4798a;
                j$.time.h hVar2 = j$.time.h.f4711d;
                j$.time.temporal.a.YEAR.X(i4);
                j$.time.temporal.a.DAY_OF_MONTH.X(b4);
                A3 = j$.time.h.A(i4, nVar2.getValue(), b4);
                DayOfWeek dayOfWeek2 = eVar.f4800c;
                if (dayOfWeek2 != null) {
                    A3 = A3.k(new o(dayOfWeek2.getValue(), i5));
                }
            }
            if (eVar.f4802e) {
                A3 = A3.f0(1L);
            }
            LocalDateTime I3 = LocalDateTime.I(A3, eVar.f4801d);
            d dVar = eVar.f4803f;
            ZoneOffset zoneOffset = eVar.f4804g;
            ZoneOffset zoneOffset2 = eVar.f4805h;
            int i8 = c.f4796a[dVar.ordinal()];
            if (i8 == 1) {
                I3 = I3.X(zoneOffset2.f4569b - ZoneOffset.UTC.f4569b);
            } else if (i8 == 2) {
                I3 = I3.X(zoneOffset2.f4569b - zoneOffset.f4569b);
            }
            bVarArr3[i7] = new b(I3, eVar.f4805h, eVar.f4806i);
            i7++;
            i5 = 0;
        }
        if (i4 < 2100) {
            ((ConcurrentHashMap) this.f4817h).putIfAbsent(valueOf, bVarArr3);
        }
        return bVarArr3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (Objects.equals(this.f4816g, fVar.f4816g) && Arrays.equals(this.f4810a, fVar.f4810a) && Arrays.equals(this.f4811b, fVar.f4811b) && Arrays.equals(this.f4812c, fVar.f4812c) && Arrays.equals(this.f4814e, fVar.f4814e) && Arrays.equals(this.f4815f, fVar.f4815f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.f4816g) ^ Arrays.hashCode(this.f4810a)) ^ Arrays.hashCode(this.f4811b)) ^ Arrays.hashCode(this.f4812c)) ^ Arrays.hashCode(this.f4814e)) ^ Arrays.hashCode(this.f4815f);
    }

    public final String toString() {
        TimeZone timeZone = this.f4816g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.f4811b[r0.length - 1] + "]";
    }
}
