package j$.time;

import com.google.firebase.encoders.json.BuildConfig;
import j$.time.temporal.TemporalAccessor;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class l implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final l f2623e;

    /* renamed from: f, reason: collision with root package name */
    public static final l f2624f;

    /* renamed from: g, reason: collision with root package name */
    public static final l f2625g;

    /* renamed from: h, reason: collision with root package name */
    public static final l[] f2626h = new l[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* renamed from: a, reason: collision with root package name */
    public final byte f2627a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f2628b;

    /* renamed from: c, reason: collision with root package name */
    public final byte f2629c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2630d;

    static {
        int i2 = 0;
        while (true) {
            l[] lVarArr = f2626h;
            if (i2 < lVarArr.length) {
                lVarArr[i2] = new l(i2, 0, 0, 0);
                i2++;
            } else {
                l lVar = lVarArr[0];
                f2625g = lVar;
                l lVar2 = lVarArr[12];
                f2623e = lVar;
                f2624f = new l(23, 59, 59, 999999999);
                return;
            }
        }
    }

    public static l P(int i2, int i3, int i4, int i5) {
        j$.time.temporal.a.HOUR_OF_DAY.X(i2);
        j$.time.temporal.a.MINUTE_OF_HOUR.X(i3);
        j$.time.temporal.a.SECOND_OF_MINUTE.X(i4);
        j$.time.temporal.a.NANO_OF_SECOND.X(i5);
        return A(i2, i3, i4, i5);
    }

    public static l V(long j2) {
        j$.time.temporal.a.NANO_OF_DAY.X(j2);
        int i2 = (int) (j2 / 3600000000000L);
        long j3 = j2 - (i2 * 3600000000000L);
        int i3 = (int) (j3 / 60000000000L);
        long j4 = j3 - (i3 * 60000000000L);
        int i4 = (int) (j4 / 1000000000);
        return A(i2, i3, i4, (int) (j4 - (i4 * 1000000000)));
    }

    public static l F(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.b(j$.time.temporal.r.f2674g);
        if (lVar != null) {
            return lVar;
        }
        throw new RuntimeException("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static l A(int i2, int i3, int i4, int i5) {
        if ((i3 | i4 | i5) == 0) {
            return f2626h[i2];
        }
        return new l(i2, i3, i4, i5);
    }

    public l(int i2, int i3, int i4, int i5) {
        this.f2627a = (byte) i2;
        this.f2628b = (byte) i3;
        this.f2629c = (byte) i4;
        this.f2630d = i5;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y();
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return I(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.NANO_OF_DAY) {
                return d0();
            }
            if (qVar == j$.time.temporal.a.MICRO_OF_DAY) {
                return d0() / 1000;
            }
            return I(qVar);
        }
        return qVar.P(this);
    }

    public final int I(j$.time.temporal.q qVar) {
        switch (k.f2621a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f2630d;
            case 2:
                throw new RuntimeException("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.f2630d / 1000;
            case 4:
                throw new RuntimeException("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.f2630d / 1000000;
            case 6:
                return (int) (d0() / 1000000);
            case 7:
                return this.f2629c;
            case 8:
                return e0();
            case 9:
                return this.f2628b;
            case 10:
                return (this.f2627a * 60) + this.f2628b;
            case 11:
                return this.f2627a % 12;
            case 12:
                int i2 = this.f2627a % 12;
                if (i2 % 12 == 0) {
                    return 12;
                }
                return i2;
            case 13:
                return this.f2627a;
            case 14:
                byte b2 = this.f2627a;
                if (b2 == 0) {
                    return 24;
                }
                return b2;
            case 15:
                return this.f2627a / 12;
            default:
                throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return (l) hVar.e(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final l c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            aVar.X(j2);
            switch (k.f2621a[aVar.ordinal()]) {
                case 1:
                    return g0((int) j2);
                case 2:
                    return V(j2);
                case 3:
                    return g0(((int) j2) * 1000);
                case 4:
                    return V(j2 * 1000);
                case 5:
                    return g0(((int) j2) * 1000000);
                case 6:
                    return V(j2 * 1000000);
                case 7:
                    int i2 = (int) j2;
                    if (this.f2629c != i2) {
                        j$.time.temporal.a.SECOND_OF_MINUTE.X(i2);
                        return A(this.f2627a, this.f2628b, i2, this.f2630d);
                    }
                    return this;
                case 8:
                    return b0(j2 - e0());
                case 9:
                    int i3 = (int) j2;
                    if (this.f2628b != i3) {
                        j$.time.temporal.a.MINUTE_OF_HOUR.X(i3);
                        return A(this.f2627a, i3, this.f2629c, this.f2630d);
                    }
                    return this;
                case 10:
                    return Z(j2 - ((this.f2627a * 60) + this.f2628b));
                case 11:
                    return Y(j2 - (this.f2627a % 12));
                case 12:
                    if (j2 == 12) {
                        j2 = 0;
                    }
                    return Y(j2 - (this.f2627a % 12));
                case 13:
                    int i4 = (int) j2;
                    if (this.f2627a != i4) {
                        j$.time.temporal.a.HOUR_OF_DAY.X(i4);
                        return A(i4, this.f2628b, this.f2629c, this.f2630d);
                    }
                    return this;
                case 14:
                    if (j2 == 24) {
                        j2 = 0;
                    }
                    int i5 = (int) j2;
                    if (this.f2627a != i5) {
                        j$.time.temporal.a.HOUR_OF_DAY.X(i5);
                        return A(i5, this.f2628b, this.f2629c, this.f2630d);
                    }
                    return this;
                case 15:
                    return Y((j2 - (this.f2627a / 12)) * 12);
                default:
                    throw new RuntimeException(d.a("Unsupported field: ", qVar));
            }
        }
        return (l) qVar.V(this, j2);
    }

    public final l g0(int i2) {
        if (this.f2630d == i2) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.X(i2);
        return A(this.f2627a, this.f2628b, this.f2629c, i2);
    }

    @Override // j$.time.temporal.m
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final l d(long j2, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (k.f2622b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return a0(j2);
                case 2:
                    return a0((j2 % 86400000000L) * 1000);
                case 3:
                    return a0((j2 % 86400000) * 1000000);
                case 4:
                    return b0(j2);
                case 5:
                    return Z(j2);
                case 6:
                    return Y(j2);
                case 7:
                    return Y((j2 % 2) * 12);
                default:
                    throw new RuntimeException("Unsupported unit: " + sVar);
            }
        }
        return (l) sVar.s(this, j2);
    }

    public final l Y(long j2) {
        return j2 == 0 ? this : A(((((int) (j2 % 24)) + this.f2627a) + 24) % 24, this.f2628b, this.f2629c, this.f2630d);
    }

    public final l Z(long j2) {
        if (j2 != 0) {
            int i2 = (this.f2627a * 60) + this.f2628b;
            int i3 = ((((int) (j2 % 1440)) + i2) + 1440) % 1440;
            if (i2 != i3) {
                return A(i3 / 60, i3 % 60, this.f2629c, this.f2630d);
            }
        }
        return this;
    }

    public final l b0(long j2) {
        if (j2 != 0) {
            int i2 = (this.f2628b * 60) + (this.f2627a * 3600) + this.f2629c;
            int i3 = ((((int) (j2 % 86400)) + i2) + 86400) % 86400;
            if (i2 != i3) {
                return A(i3 / 3600, (i3 / 60) % 60, i3 % 60, this.f2630d);
            }
        }
        return this;
    }

    public final l a0(long j2) {
        if (j2 != 0) {
            long d02 = d0();
            long j3 = (((j2 % 86400000000000L) + d02) + 86400000000000L) % 86400000000000L;
            if (d02 != j3) {
                return A((int) (j3 / 3600000000000L), (int) ((j3 / 60000000000L) % 60), (int) ((j3 / 1000000000) % 60), (int) (j3 % 1000000000));
            }
        }
        return this;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j2, j$.time.temporal.s sVar) {
        return j2 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j2, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f2669b || iVar == j$.time.temporal.r.f2668a || iVar == j$.time.temporal.r.f2672e || iVar == j$.time.temporal.r.f2671d) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f2674g) {
            return this;
        }
        if (iVar == j$.time.temporal.r.f2673f) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f2670c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(d0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    public final int e0() {
        return (this.f2628b * 60) + (this.f2627a * 3600) + this.f2629c;
    }

    public final long d0() {
        return (this.f2629c * 1000000000) + (this.f2628b * 60000000000L) + (this.f2627a * 3600000000000L) + this.f2630d;
    }

    @Override // java.lang.Comparable
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final int compareTo(l lVar) {
        int compare = Integer.compare(this.f2627a, lVar.f2627a);
        return (compare == 0 && (compare = Integer.compare(this.f2628b, lVar.f2628b)) == 0 && (compare = Integer.compare(this.f2629c, lVar.f2629c)) == 0) ? Integer.compare(this.f2630d, lVar.f2630d) : compare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f2627a == lVar.f2627a && this.f2628b == lVar.f2628b && this.f2629c == lVar.f2629c && this.f2630d == lVar.f2630d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long d02 = d0();
        return (int) (d02 ^ (d02 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b2 = this.f2627a;
        byte b3 = this.f2628b;
        byte b4 = this.f2629c;
        int i2 = this.f2630d;
        sb.append(b2 < 10 ? "0" : BuildConfig.FLAVOR);
        sb.append((int) b2);
        sb.append(b3 < 10 ? ":0" : ":");
        sb.append((int) b3);
        if (b4 > 0 || i2 > 0) {
            sb.append(b4 < 10 ? ":0" : ":");
            sb.append((int) b4);
            if (i2 > 0) {
                sb.append('.');
                if (i2 % 1000000 == 0) {
                    sb.append(Integer.toString((i2 / 1000000) + 1000).substring(1));
                } else if (i2 % 1000 == 0) {
                    sb.append(Integer.toString((i2 / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i2 + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new t((byte) 4, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void h0(DataOutput dataOutput) {
        if (this.f2630d == 0) {
            if (this.f2629c == 0) {
                if (this.f2628b == 0) {
                    dataOutput.writeByte(~this.f2627a);
                    return;
                } else {
                    dataOutput.writeByte(this.f2627a);
                    dataOutput.writeByte(~this.f2628b);
                    return;
                }
            }
            dataOutput.writeByte(this.f2627a);
            dataOutput.writeByte(this.f2628b);
            dataOutput.writeByte(~this.f2629c);
            return;
        }
        dataOutput.writeByte(this.f2627a);
        dataOutput.writeByte(this.f2628b);
        dataOutput.writeByte(this.f2629c);
        dataOutput.writeInt(this.f2630d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    public static l c0(DataInput dataInput) {
        int readInt;
        int i2;
        int readByte = dataInput.readByte();
        byte b2 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            i2 = 0;
            readInt = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                ?? r5 = ~readByte2;
                readInt = 0;
                b2 = r5;
                i2 = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i2 = ~readByte3;
                    readInt = 0;
                    b2 = readByte2;
                } else {
                    readInt = dataInput.readInt();
                    b2 = readByte2;
                    i2 = readByte3;
                }
            }
        }
        return P(readByte, b2, i2, readInt);
    }
}
