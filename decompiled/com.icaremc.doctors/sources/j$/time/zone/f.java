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
    public static final long[] f2710i = new long[0];

    /* renamed from: j, reason: collision with root package name */
    public static final e[] f2711j = new e[0];

    /* renamed from: k, reason: collision with root package name */
    public static final LocalDateTime[] f2712k = new LocalDateTime[0];

    /* renamed from: l, reason: collision with root package name */
    public static final b[] f2713l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* renamed from: a, reason: collision with root package name */
    public final long[] f2714a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset[] f2715b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f2716c;

    /* renamed from: d, reason: collision with root package name */
    public final LocalDateTime[] f2717d;

    /* renamed from: e, reason: collision with root package name */
    public final ZoneOffset[] f2718e;

    /* renamed from: f, reason: collision with root package name */
    public final e[] f2719f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeZone f2720g;

    /* renamed from: h, reason: collision with root package name */
    public final transient ConcurrentMap f2721h = new ConcurrentHashMap();

    public static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime localDateTime2 = bVar.f2696b;
        if (bVar.s()) {
            if (localDateTime.F(localDateTime2)) {
                return bVar.f2697c;
            }
            if (!localDateTime.F(bVar.f2696b.X(bVar.f2698d.f2471b - bVar.f2697c.f2471b))) {
                return bVar.f2698d;
            }
        } else {
            if (!localDateTime.F(localDateTime2)) {
                return bVar.f2698d;
            }
            if (localDateTime.F(bVar.f2696b.X(bVar.f2698d.f2471b - bVar.f2697c.f2471b))) {
                return bVar.f2697c;
            }
        }
        return bVar;
    }

    public f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.f2714a = jArr;
        this.f2715b = zoneOffsetArr;
        this.f2716c = jArr2;
        this.f2718e = zoneOffsetArr2;
        this.f2719f = eVarArr;
        if (jArr2.length == 0) {
            this.f2717d = f2712k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < jArr2.length) {
                int i3 = i2 + 1;
                b bVar = new b(jArr2[i2], zoneOffsetArr2[i2], zoneOffsetArr2[i3]);
                if (bVar.s()) {
                    arrayList.add(bVar.f2696b);
                    arrayList.add(bVar.f2696b.X(bVar.f2698d.f2471b - bVar.f2697c.f2471b));
                } else {
                    arrayList.add(bVar.f2696b.X(bVar.f2698d.f2471b - bVar.f2697c.f2471b));
                    arrayList.add(bVar.f2696b);
                }
                i2 = i3;
            }
            this.f2717d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.f2720g = null;
    }

    public f(ZoneOffset zoneOffset) {
        this.f2715b = r0;
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        long[] jArr = f2710i;
        this.f2714a = jArr;
        this.f2716c = jArr;
        this.f2717d = f2712k;
        this.f2718e = zoneOffsetArr;
        this.f2719f = f2711j;
        this.f2720g = null;
    }

    public f(TimeZone timeZone) {
        this.f2715b = r0;
        ZoneOffset[] zoneOffsetArr = {g(timeZone.getRawOffset())};
        long[] jArr = f2710i;
        this.f2714a = jArr;
        this.f2716c = jArr;
        this.f2717d = f2712k;
        this.f2718e = zoneOffsetArr;
        this.f2719f = f2711j;
        this.f2720g = timeZone;
    }

    public static ZoneOffset g(int i2) {
        return ZoneOffset.Y(i2 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.f2720g != null ? (byte) 100 : (byte) 1, this);
    }

    public static int c(long j2, ZoneOffset zoneOffset) {
        return j$.time.h.c0(Math.floorDiv(j2 + zoneOffset.f2471b, 86400)).f2616a;
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f2720g;
        if (timeZone != null) {
            return g(timeZone.getOffset(instant.toEpochMilli()));
        }
        if (this.f2716c.length == 0) {
            return this.f2715b[0];
        }
        long epochSecond = instant.getEpochSecond();
        if (this.f2719f.length > 0) {
            if (epochSecond > this.f2716c[r7.length - 1]) {
                b[] b2 = b(c(epochSecond, this.f2718e[r7.length - 1]));
                b bVar = null;
                for (int i2 = 0; i2 < b2.length; i2++) {
                    bVar = b2[i2];
                    if (epochSecond < bVar.f2695a) {
                        return bVar.f2697c;
                    }
                }
                return bVar.f2698d;
            }
        }
        int binarySearch = Arrays.binarySearch(this.f2716c, epochSecond);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.f2718e[binarySearch + 1];
    }

    public final List f(LocalDateTime localDateTime) {
        Object e2 = e(localDateTime);
        if (e2 instanceof b) {
            b bVar = (b) e2;
            if (!bVar.s()) {
                return j$.time.b.a(new Object[]{bVar.f2697c, bVar.f2698d});
            }
            return Collections.EMPTY_LIST;
        }
        return Collections.singletonList((ZoneOffset) e2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        if (r8.s(r0) > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
    
        if (r8.f2462b.d0() <= r0.f2462b.d0()) goto L44;
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

    public final b[] b(int i2) {
        j$.time.h A2;
        b[] bVarArr = f2713l;
        Integer valueOf = Integer.valueOf(i2);
        b[] bVarArr2 = (b[]) ((ConcurrentHashMap) this.f2721h).get(valueOf);
        if (bVarArr2 != null) {
            return bVarArr2;
        }
        long j2 = 1;
        int i3 = 0;
        int i4 = 1;
        if (this.f2720g != null) {
            if (i2 < 1800) {
                return bVarArr;
            }
            LocalDateTime localDateTime = LocalDateTime.f2459c;
            j$.time.h b02 = j$.time.h.b0(i2 - 1, 12, 31);
            j$.time.temporal.a.HOUR_OF_DAY.X(0);
            long w2 = new LocalDateTime(b02, l.f2626h[0]).w(this.f2715b[0]);
            long j3 = 1000;
            int offset = this.f2720g.getOffset(w2 * 1000);
            long j4 = 31968000 + w2;
            while (w2 < j4) {
                long j5 = w2 + 7776000;
                long j6 = j3;
                if (offset != this.f2720g.getOffset(j5 * j6)) {
                    while (j5 - w2 > j2) {
                        long floorDiv = Math.floorDiv(j5 + w2, 2L);
                        if (this.f2720g.getOffset(floorDiv * j6) == offset) {
                            w2 = floorDiv;
                        } else {
                            j5 = floorDiv;
                        }
                        j2 = 1;
                    }
                    if (this.f2720g.getOffset(w2 * j6) == offset) {
                        w2 = j5;
                    }
                    ZoneOffset g2 = g(offset);
                    int offset2 = this.f2720g.getOffset(w2 * j6);
                    ZoneOffset g3 = g(offset2);
                    if (c(w2, g3) == i2) {
                        bVarArr = (b[]) Arrays.copyOf(bVarArr, bVarArr.length + 1);
                        bVarArr[bVarArr.length - 1] = new b(w2, g2, g3);
                    }
                    offset = offset2;
                } else {
                    w2 = j5;
                }
                j3 = j6;
                j2 = 1;
            }
            if (1916 <= i2 && i2 < 2100) {
                ((ConcurrentHashMap) this.f2721h).putIfAbsent(valueOf, bVarArr);
            }
            return bVarArr;
        }
        e[] eVarArr = this.f2719f;
        b[] bVarArr3 = new b[eVarArr.length];
        int i5 = 0;
        while (i5 < eVarArr.length) {
            e eVar = eVarArr[i5];
            byte b2 = eVar.f2702b;
            if (b2 < 0) {
                n nVar = eVar.f2701a;
                long j7 = i2;
                s.f2522c.getClass();
                int A3 = nVar.A(s.X(j7)) + 1 + eVar.f2702b;
                j$.time.h hVar = j$.time.h.f2614d;
                j$.time.temporal.a.YEAR.X(j7);
                j$.time.temporal.a.DAY_OF_MONTH.X(A3);
                A2 = j$.time.h.A(i2, nVar.getValue(), A3);
                DayOfWeek dayOfWeek = eVar.f2703c;
                if (dayOfWeek != null) {
                    A2 = A2.k(new o(dayOfWeek.getValue(), i4));
                }
            } else {
                n nVar2 = eVar.f2701a;
                j$.time.h hVar2 = j$.time.h.f2614d;
                j$.time.temporal.a.YEAR.X(i2);
                j$.time.temporal.a.DAY_OF_MONTH.X(b2);
                A2 = j$.time.h.A(i2, nVar2.getValue(), b2);
                DayOfWeek dayOfWeek2 = eVar.f2703c;
                if (dayOfWeek2 != null) {
                    A2 = A2.k(new o(dayOfWeek2.getValue(), i3));
                }
            }
            if (eVar.f2705e) {
                A2 = A2.f0(1L);
            }
            LocalDateTime I2 = LocalDateTime.I(A2, eVar.f2704d);
            d dVar = eVar.f2706f;
            ZoneOffset zoneOffset = eVar.f2707g;
            ZoneOffset zoneOffset2 = eVar.f2708h;
            int i6 = c.f2699a[dVar.ordinal()];
            if (i6 == 1) {
                I2 = I2.X(zoneOffset2.f2471b - ZoneOffset.UTC.f2471b);
            } else if (i6 == 2) {
                I2 = I2.X(zoneOffset2.f2471b - zoneOffset.f2471b);
            }
            bVarArr3[i5] = new b(I2, eVar.f2708h, eVar.f2709i);
            i5++;
            i3 = 0;
        }
        if (i2 < 2100) {
            ((ConcurrentHashMap) this.f2721h).putIfAbsent(valueOf, bVarArr3);
        }
        return bVarArr3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (Objects.equals(this.f2720g, fVar.f2720g) && Arrays.equals(this.f2714a, fVar.f2714a) && Arrays.equals(this.f2715b, fVar.f2715b) && Arrays.equals(this.f2716c, fVar.f2716c) && Arrays.equals(this.f2718e, fVar.f2718e) && Arrays.equals(this.f2719f, fVar.f2719f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.f2720g) ^ Arrays.hashCode(this.f2714a)) ^ Arrays.hashCode(this.f2715b)) ^ Arrays.hashCode(this.f2716c)) ^ Arrays.hashCode(this.f2718e)) ^ Arrays.hashCode(this.f2719f);
    }

    public final String toString() {
        TimeZone timeZone = this.f2720g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.f2715b[r0.length - 1] + "]";
    }
}
