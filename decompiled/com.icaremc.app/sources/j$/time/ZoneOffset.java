package j$.time;

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
    public final int f4569b;

    /* renamed from: c, reason: collision with root package name */
    public final transient String f4570c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentMap f4565d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e, reason: collision with root package name */
    public static final ConcurrentMap f4566e = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = Y(0);

    /* renamed from: f, reason: collision with root package name */
    public static final ZoneOffset f4567f = Y(-64800);

    /* renamed from: g, reason: collision with root package name */
    public static final ZoneOffset f4568g = Y(64800);

    @Override // java.lang.Comparable
    public final int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.f4569b - this.f4569b;
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
            java.util.concurrent.ConcurrentMap r0 = j$.time.ZoneOffset.f4566e
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

    public static int Z(CharSequence charSequence, int i4, boolean z) {
        if (z) {
            String str = (String) charSequence;
            if (str.charAt(i4 - 1) != ':') {
                throw new RuntimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) str));
            }
        }
        String str2 = (String) charSequence;
        char charAt = str2.charAt(i4);
        char charAt2 = str2.charAt(i4 + 1);
        if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
            return (charAt2 - '0') + ((charAt - '0') * 10);
        }
        throw new RuntimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) str2));
    }

    public static ZoneOffset X(int i4, int i5, int i6) {
        if (i4 < -18 || i4 > 18) {
            throw new RuntimeException("Zone offset hours not in valid range: value " + i4 + " is not in the range -18 to 18");
        }
        if (i4 > 0) {
            if (i5 < 0 || i6 < 0) {
                throw new RuntimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i4 < 0) {
            if (i5 > 0 || i6 > 0) {
                throw new RuntimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i5 > 0 && i6 < 0) || (i5 < 0 && i6 > 0)) {
            throw new RuntimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (i5 < -59 || i5 > 59) {
            throw new RuntimeException("Zone offset minutes not in valid range: value " + i5 + " is not in the range -59 to 59");
        }
        if (i6 < -59 || i6 > 59) {
            throw new RuntimeException("Zone offset seconds not in valid range: value " + i6 + " is not in the range -59 to 59");
        }
        if (Math.abs(i4) == 18 && (i5 | i6) != 0) {
            throw new RuntimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        return Y((i5 * 60) + (i4 * 3600) + i6);
    }

    public static ZoneOffset Y(int i4) {
        if (i4 < -64800 || i4 > 64800) {
            throw new RuntimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i4 % 900 == 0) {
            Integer valueOf = Integer.valueOf(i4);
            ConcurrentMap concurrentMap = f4565d;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentMap.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentMap.putIfAbsent(valueOf, new ZoneOffset(i4));
            ZoneOffset zoneOffset2 = (ZoneOffset) concurrentMap.get(valueOf);
            f4566e.putIfAbsent(zoneOffset2.f4570c, zoneOffset2);
            return zoneOffset2;
        }
        return new ZoneOffset(i4);
    }

    public ZoneOffset(int i4) {
        String sb;
        this.f4569b = i4;
        if (i4 == 0) {
            sb = "Z";
        } else {
            int abs = Math.abs(i4);
            StringBuilder sb2 = new StringBuilder();
            int i5 = abs / 3600;
            int i6 = (abs / 60) % 60;
            sb2.append(i4 < 0 ? "-" : "+");
            sb2.append(i5 < 10 ? "0" : "");
            sb2.append(i5);
            sb2.append(i6 < 10 ? ":0" : ":");
            sb2.append(i6);
            int i7 = abs % 60;
            if (i7 != 0) {
                sb2.append(i7 < 10 ? ":0" : ":");
                sb2.append(i7);
            }
            sb = sb2.toString();
        }
        this.f4570c = sb;
    }

    @Override // j$.time.ZoneId
    public final String q() {
        return this.f4570c;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.OFFSET_SECONDS : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f4569b;
        }
        if (qVar != null) {
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return super.l(qVar).a(i(qVar), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f4569b;
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        return (iVar == j$.time.temporal.r.f4768d || iVar == j$.time.temporal.r.f4769e) ? this : super.b(iVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(this.f4569b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    @Override // j$.time.ZoneId
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.f4569b == ((ZoneOffset) obj).f4569b;
    }

    @Override // j$.time.ZoneId
    public final int hashCode() {
        return this.f4569b;
    }

    @Override // j$.time.ZoneId
    public final String toString() {
        return this.f4570c;
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
        int i4 = this.f4569b;
        int i5 = i4 % 900 == 0 ? i4 / 900 : 127;
        dataOutput.writeByte(i5);
        if (i5 == 127) {
            dataOutput.writeInt(i4);
        }
    }

    public static ZoneOffset a0(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? Y(dataInput.readInt()) : Y(readByte * 900);
    }
}
