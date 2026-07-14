package j$.time;

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
    public static final l f4720e;

    /* renamed from: f, reason: collision with root package name */
    public static final l f4721f;

    /* renamed from: g, reason: collision with root package name */
    public static final l f4722g;

    /* renamed from: h, reason: collision with root package name */
    public static final l[] f4723h = new l[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* renamed from: a, reason: collision with root package name */
    public final byte f4724a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f4725b;

    /* renamed from: c, reason: collision with root package name */
    public final byte f4726c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4727d;

    static {
        int i4 = 0;
        while (true) {
            l[] lVarArr = f4723h;
            if (i4 < lVarArr.length) {
                lVarArr[i4] = new l(i4, 0, 0, 0);
                i4++;
            } else {
                l lVar = lVarArr[0];
                f4722g = lVar;
                l lVar2 = lVarArr[12];
                f4720e = lVar;
                f4721f = new l(23, 59, 59, 999999999);
                return;
            }
        }
    }

    public static l P(int i4, int i5, int i6, int i7) {
        j$.time.temporal.a.HOUR_OF_DAY.X(i4);
        j$.time.temporal.a.MINUTE_OF_HOUR.X(i5);
        j$.time.temporal.a.SECOND_OF_MINUTE.X(i6);
        j$.time.temporal.a.NANO_OF_SECOND.X(i7);
        return A(i4, i5, i6, i7);
    }

    public static l V(long j4) {
        j$.time.temporal.a.NANO_OF_DAY.X(j4);
        int i4 = (int) (j4 / 3600000000000L);
        long j5 = j4 - (i4 * 3600000000000L);
        int i5 = (int) (j5 / 60000000000L);
        long j6 = j5 - (i5 * 60000000000L);
        int i6 = (int) (j6 / 1000000000);
        return A(i4, i5, i6, (int) (j6 - (i6 * 1000000000)));
    }

    public static l F(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.b(j$.time.temporal.r.f4771g);
        if (lVar != null) {
            return lVar;
        }
        throw new RuntimeException("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static l A(int i4, int i5, int i6, int i7) {
        if ((i5 | i6 | i7) == 0) {
            return f4723h[i4];
        }
        return new l(i4, i5, i6, i7);
    }

    public l(int i4, int i5, int i6, int i7) {
        this.f4724a = (byte) i4;
        this.f4725b = (byte) i5;
        this.f4726c = (byte) i6;
        this.f4727d = i7;
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
        switch (k.f4718a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f4727d;
            case 2:
                throw new RuntimeException("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.f4727d / 1000;
            case 4:
                throw new RuntimeException("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.f4727d / 1000000;
            case 6:
                return (int) (d0() / 1000000);
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return this.f4726c;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                return e0();
            case 9:
                return this.f4725b;
            case 10:
                return (this.f4724a * 60) + this.f4725b;
            case 11:
                return this.f4724a % 12;
            case 12:
                int i4 = this.f4724a % 12;
                if (i4 % 12 == 0) {
                    return 12;
                }
                return i4;
            case 13:
                return this.f4724a;
            case 14:
                byte b4 = this.f4724a;
                if (b4 == 0) {
                    return 24;
                }
                return b4;
            case 15:
                return this.f4724a / 12;
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
    public final l c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            aVar.X(j4);
            switch (k.f4718a[aVar.ordinal()]) {
                case 1:
                    return g0((int) j4);
                case 2:
                    return V(j4);
                case 3:
                    return g0(((int) j4) * 1000);
                case 4:
                    return V(j4 * 1000);
                case 5:
                    return g0(((int) j4) * 1000000);
                case 6:
                    return V(j4 * 1000000);
                case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    int i4 = (int) j4;
                    if (this.f4726c != i4) {
                        j$.time.temporal.a.SECOND_OF_MINUTE.X(i4);
                        return A(this.f4724a, this.f4725b, i4, this.f4727d);
                    }
                    return this;
                case R.j.BYTES_FIELD_NUMBER /* 8 */:
                    return b0(j4 - e0());
                case 9:
                    int i5 = (int) j4;
                    if (this.f4725b != i5) {
                        j$.time.temporal.a.MINUTE_OF_HOUR.X(i5);
                        return A(this.f4724a, i5, this.f4726c, this.f4727d);
                    }
                    return this;
                case 10:
                    return Z(j4 - ((this.f4724a * 60) + this.f4725b));
                case 11:
                    return Y(j4 - (this.f4724a % 12));
                case 12:
                    if (j4 == 12) {
                        j4 = 0;
                    }
                    return Y(j4 - (this.f4724a % 12));
                case 13:
                    int i6 = (int) j4;
                    if (this.f4724a != i6) {
                        j$.time.temporal.a.HOUR_OF_DAY.X(i6);
                        return A(i6, this.f4725b, this.f4726c, this.f4727d);
                    }
                    return this;
                case 14:
                    if (j4 == 24) {
                        j4 = 0;
                    }
                    int i7 = (int) j4;
                    if (this.f4724a != i7) {
                        j$.time.temporal.a.HOUR_OF_DAY.X(i7);
                        return A(i7, this.f4725b, this.f4726c, this.f4727d);
                    }
                    return this;
                case 15:
                    return Y((j4 - (this.f4724a / 12)) * 12);
                default:
                    throw new RuntimeException(d.a("Unsupported field: ", qVar));
            }
        }
        return (l) qVar.V(this, j4);
    }

    public final l g0(int i4) {
        if (this.f4727d == i4) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.X(i4);
        return A(this.f4724a, this.f4725b, this.f4726c, i4);
    }

    @Override // j$.time.temporal.m
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final l d(long j4, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (k.f4719b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return a0(j4);
                case 2:
                    return a0((j4 % 86400000000L) * 1000);
                case 3:
                    return a0((j4 % 86400000) * 1000000);
                case 4:
                    return b0(j4);
                case 5:
                    return Z(j4);
                case 6:
                    return Y(j4);
                case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    return Y((j4 % 2) * 12);
                default:
                    throw new RuntimeException("Unsupported unit: " + sVar);
            }
        }
        return (l) sVar.s(this, j4);
    }

    public final l Y(long j4) {
        return j4 == 0 ? this : A(((((int) (j4 % 24)) + this.f4724a) + 24) % 24, this.f4725b, this.f4726c, this.f4727d);
    }

    public final l Z(long j4) {
        if (j4 != 0) {
            int i4 = (this.f4724a * 60) + this.f4725b;
            int i5 = ((((int) (j4 % 1440)) + i4) + 1440) % 1440;
            if (i4 != i5) {
                return A(i5 / 60, i5 % 60, this.f4726c, this.f4727d);
            }
        }
        return this;
    }

    public final l b0(long j4) {
        if (j4 != 0) {
            int i4 = (this.f4725b * 60) + (this.f4724a * 3600) + this.f4726c;
            int i5 = ((((int) (j4 % 86400)) + i4) + 86400) % 86400;
            if (i4 != i5) {
                return A(i5 / 3600, (i5 / 60) % 60, i5 % 60, this.f4727d);
            }
        }
        return this;
    }

    public final l a0(long j4) {
        if (j4 != 0) {
            long d02 = d0();
            long j5 = (((j4 % 86400000000000L) + d02) + 86400000000000L) % 86400000000000L;
            if (d02 != j5) {
                return A((int) (j5 / 3600000000000L), (int) ((j5 / 60000000000L) % 60), (int) ((j5 / 1000000000) % 60), (int) (j5 % 1000000000));
            }
        }
        return this;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j4, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f4766b || iVar == j$.time.temporal.r.f4765a || iVar == j$.time.temporal.r.f4769e || iVar == j$.time.temporal.r.f4768d) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f4771g) {
            return this;
        }
        if (iVar == j$.time.temporal.r.f4770f) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f4767c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(d0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    public final int e0() {
        return (this.f4725b * 60) + (this.f4724a * 3600) + this.f4726c;
    }

    public final long d0() {
        return (this.f4726c * 1000000000) + (this.f4725b * 60000000000L) + (this.f4724a * 3600000000000L) + this.f4727d;
    }

    @Override // java.lang.Comparable
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final int compareTo(l lVar) {
        int compare = Integer.compare(this.f4724a, lVar.f4724a);
        return (compare == 0 && (compare = Integer.compare(this.f4725b, lVar.f4725b)) == 0 && (compare = Integer.compare(this.f4726c, lVar.f4726c)) == 0) ? Integer.compare(this.f4727d, lVar.f4727d) : compare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f4724a == lVar.f4724a && this.f4725b == lVar.f4725b && this.f4726c == lVar.f4726c && this.f4727d == lVar.f4727d) {
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
        byte b4 = this.f4724a;
        byte b5 = this.f4725b;
        byte b6 = this.f4726c;
        int i4 = this.f4727d;
        sb.append(b4 < 10 ? "0" : "");
        sb.append((int) b4);
        sb.append(b5 < 10 ? ":0" : ":");
        sb.append((int) b5);
        if (b6 > 0 || i4 > 0) {
            sb.append(b6 < 10 ? ":0" : ":");
            sb.append((int) b6);
            if (i4 > 0) {
                sb.append('.');
                if (i4 % 1000000 == 0) {
                    sb.append(Integer.toString((i4 / 1000000) + 1000).substring(1));
                } else if (i4 % 1000 == 0) {
                    sb.append(Integer.toString((i4 / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i4 + 1000000000).substring(1));
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
        if (this.f4727d == 0) {
            if (this.f4726c == 0) {
                if (this.f4725b == 0) {
                    dataOutput.writeByte(~this.f4724a);
                    return;
                } else {
                    dataOutput.writeByte(this.f4724a);
                    dataOutput.writeByte(~this.f4725b);
                    return;
                }
            }
            dataOutput.writeByte(this.f4724a);
            dataOutput.writeByte(this.f4725b);
            dataOutput.writeByte(~this.f4726c);
            return;
        }
        dataOutput.writeByte(this.f4724a);
        dataOutput.writeByte(this.f4725b);
        dataOutput.writeByte(this.f4726c);
        dataOutput.writeInt(this.f4727d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    public static l c0(DataInput dataInput) {
        int readInt;
        int i4;
        int readByte = dataInput.readByte();
        byte b4 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            i4 = 0;
            readInt = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                ?? r5 = ~readByte2;
                readInt = 0;
                b4 = r5;
                i4 = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i4 = ~readByte3;
                    readInt = 0;
                    b4 = readByte2;
                } else {
                    readInt = dataInput.readInt();
                    b4 = readByte2;
                    i4 = readByte3;
                }
            }
        }
        return P(readByte, b4, i4, readInt);
    }
}
