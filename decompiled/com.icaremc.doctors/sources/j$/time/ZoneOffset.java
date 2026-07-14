package j$.time;

import com.google.firebase.encoders.json.BuildConfig;
import j$.time.temporal.TemporalAccessor;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, j$.time.temporal.n, Comparable<ZoneOffset>, Serializable {
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: b, reason: collision with root package name */
    public final int f2471b;

    /* renamed from: c, reason: collision with root package name */
    public final transient String f2472c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentMap f2467d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e, reason: collision with root package name */
    public static final ConcurrentMap f2468e = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = Y(0);

    /* renamed from: f, reason: collision with root package name */
    public static final ZoneOffset f2469f = Y(-64800);

    /* renamed from: g, reason: collision with root package name */
    public static final ZoneOffset f2470g = Y(64800);

    @Override // java.lang.Comparable
    public final int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.f2471b - this.f2471b;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0091 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.ZoneOffset V(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap r0 = j$.time.ZoneOffset.f2468e
            java.util.concurrent.ConcurrentHashMap r0 = (java.util.concurrent.ConcurrentHashMap) r0
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto L12
            return r0
        L12:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L65
            r1 = 3
            if (r0 == r1) goto L81
            r4 = 5
            if (r0 == r4) goto L5c
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L52
            r5 = 7
            if (r0 == r5) goto L45
            r1 = 9
            if (r0 != r1) goto L39
            int r0 = Z(r7, r2, r3)
            int r1 = Z(r7, r6, r2)
            int r2 = Z(r7, r5, r2)
            goto L87
        L39:
            j$.time.c r0 = new j$.time.c
            java.lang.String r1 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L45:
            int r0 = Z(r7, r2, r3)
            int r1 = Z(r7, r1, r3)
            int r2 = Z(r7, r4, r3)
            goto L87
        L52:
            int r0 = Z(r7, r2, r3)
            int r1 = Z(r7, r6, r2)
        L5a:
            r2 = r3
            goto L87
        L5c:
            int r0 = Z(r7, r2, r3)
            int r1 = Z(r7, r1, r3)
            goto L5a
        L65:
            char r0 = r7.charAt(r3)
            char r7 = r7.charAt(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0"
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
        L81:
            int r0 = Z(r7, r2, r3)
            r1 = r3
            r2 = r1
        L87:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto La0
            if (r3 != r5) goto L94
            goto La0
        L94:
            j$.time.c r0 = new j$.time.c
            java.lang.String r1 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        La0:
            if (r3 != r5) goto Laa
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.ZoneOffset r7 = X(r7, r0, r1)
            return r7
        Laa:
            j$.time.ZoneOffset r7 = X(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.V(java.lang.String):j$.time.ZoneOffset");
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f s() {
        return new j$.time.zone.f(this);
    }

    public static int Z(CharSequence charSequence, int i2, boolean z) {
        if (z) {
            String str = (String) charSequence;
            if (str.charAt(i2 - 1) != ':') {
                throw new RuntimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) str));
            }
        }
        String str2 = (String) charSequence;
        char charAt = str2.charAt(i2);
        char charAt2 = str2.charAt(i2 + 1);
        if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
            return (charAt2 - '0') + ((charAt - '0') * 10);
        }
        throw new RuntimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) str2));
    }

    public static ZoneOffset X(int i2, int i3, int i4) {
        if (i2 < -18 || i2 > 18) {
            throw new RuntimeException("Zone offset hours not in valid range: value " + i2 + " is not in the range -18 to 18");
        }
        if (i2 > 0) {
            if (i3 < 0 || i4 < 0) {
                throw new RuntimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i2 < 0) {
            if (i3 > 0 || i4 > 0) {
                throw new RuntimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i3 > 0 && i4 < 0) || (i3 < 0 && i4 > 0)) {
            throw new RuntimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (i3 < -59 || i3 > 59) {
            throw new RuntimeException("Zone offset minutes not in valid range: value " + i3 + " is not in the range -59 to 59");
        }
        if (i4 < -59 || i4 > 59) {
            throw new RuntimeException("Zone offset seconds not in valid range: value " + i4 + " is not in the range -59 to 59");
        }
        if (Math.abs(i2) == 18 && (i3 | i4) != 0) {
            throw new RuntimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        return Y((i3 * 60) + (i2 * 3600) + i4);
    }

    public static ZoneOffset Y(int i2) {
        if (i2 < -64800 || i2 > 64800) {
            throw new RuntimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i2 % 900 == 0) {
            Integer valueOf = Integer.valueOf(i2);
            ConcurrentMap concurrentMap = f2467d;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentMap.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentMap.putIfAbsent(valueOf, new ZoneOffset(i2));
            ZoneOffset zoneOffset2 = (ZoneOffset) concurrentMap.get(valueOf);
            f2468e.putIfAbsent(zoneOffset2.f2472c, zoneOffset2);
            return zoneOffset2;
        }
        return new ZoneOffset(i2);
    }

    public ZoneOffset(int i2) {
        String sb;
        this.f2471b = i2;
        if (i2 == 0) {
            sb = "Z";
        } else {
            int abs = Math.abs(i2);
            StringBuilder sb2 = new StringBuilder();
            int i3 = abs / 3600;
            int i4 = (abs / 60) % 60;
            sb2.append(i2 < 0 ? "-" : "+");
            sb2.append(i3 < 10 ? "0" : BuildConfig.FLAVOR);
            sb2.append(i3);
            sb2.append(i4 < 10 ? ":0" : ":");
            sb2.append(i4);
            int i5 = abs % 60;
            if (i5 != 0) {
                sb2.append(i5 < 10 ? ":0" : ":");
                sb2.append(i5);
            }
            sb = sb2.toString();
        }
        this.f2472c = sb;
    }

    @Override // j$.time.ZoneId
    public final String q() {
        return this.f2472c;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.OFFSET_SECONDS : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f2471b;
        }
        if (qVar != null) {
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return super.l(qVar).a(i(qVar), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f2471b;
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        return (iVar == j$.time.temporal.r.f2671d || iVar == j$.time.temporal.r.f2672e) ? this : super.b(iVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(this.f2471b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    @Override // j$.time.ZoneId
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.f2471b == ((ZoneOffset) obj).f2471b;
    }

    @Override // j$.time.ZoneId
    public final int hashCode() {
        return this.f2471b;
    }

    @Override // j$.time.ZoneId
    public final String toString() {
        return this.f2472c;
    }

    private Object writeReplace() {
        return new t((byte) 8, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    public final void P(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        b0(dataOutput);
    }

    public final void b0(DataOutput dataOutput) {
        int i2 = this.f2471b;
        int i3 = i2 % 900 == 0 ? i2 / 900 : 127;
        dataOutput.writeByte(i3);
        if (i3 == 127) {
            dataOutput.writeInt(i2);
        }
    }

    public static ZoneOffset a0(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? Y(dataInput.readInt()) : Y(readByte * 900);
    }
}
