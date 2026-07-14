package j$.time.zone;

import j$.time.DayOfWeek;
import j$.time.ZoneOffset;
import j$.time.l;
import j$.time.n;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* renamed from: a, reason: collision with root package name */
    public final n f4798a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f4799b;

    /* renamed from: c, reason: collision with root package name */
    public final DayOfWeek f4800c;

    /* renamed from: d, reason: collision with root package name */
    public final l f4801d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4802e;

    /* renamed from: f, reason: collision with root package name */
    public final d f4803f;

    /* renamed from: g, reason: collision with root package name */
    public final ZoneOffset f4804g;

    /* renamed from: h, reason: collision with root package name */
    public final ZoneOffset f4805h;

    /* renamed from: i, reason: collision with root package name */
    public final ZoneOffset f4806i;

    public e(n nVar, int i4, DayOfWeek dayOfWeek, l lVar, boolean z, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f4798a = nVar;
        this.f4799b = (byte) i4;
        this.f4800c = dayOfWeek;
        this.f4801d = lVar;
        this.f4802e = z;
        this.f4803f = dVar;
        this.f4804g = zoneOffset;
        this.f4805h = zoneOffset2;
        this.f4806i = zoneOffset3;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final void b(DataOutput dataOutput) {
        int e02 = this.f4802e ? 86400 : this.f4801d.e0();
        int i4 = this.f4804g.f4569b;
        int i5 = this.f4805h.f4569b - i4;
        int i6 = this.f4806i.f4569b - i4;
        byte b4 = e02 % 3600 == 0 ? this.f4802e ? (byte) 24 : this.f4801d.f4724a : (byte) 31;
        int i7 = i4 % 900 == 0 ? (i4 / 900) + 128 : 255;
        int i8 = (i5 == 0 || i5 == 1800 || i5 == 3600) ? i5 / 1800 : 3;
        int i9 = (i6 == 0 || i6 == 1800 || i6 == 3600) ? i6 / 1800 : 3;
        DayOfWeek dayOfWeek = this.f4800c;
        dataOutput.writeInt((this.f4798a.getValue() << 28) + ((this.f4799b + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.getValue()) << 19) + (b4 << 14) + (this.f4803f.ordinal() << 12) + (i7 << 4) + (i8 << 2) + i9);
        if (b4 == 31) {
            dataOutput.writeInt(e02);
        }
        if (i7 == 255) {
            dataOutput.writeInt(i4);
        }
        if (i8 == 3) {
            dataOutput.writeInt(this.f4805h.f4569b);
        }
        if (i9 == 3) {
            dataOutput.writeInt(this.f4806i.f4569b);
        }
    }

    public static e a(DataInput dataInput) {
        d dVar;
        l lVar;
        int i4;
        int i5;
        int readInt = dataInput.readInt();
        n I3 = n.I(readInt >>> 28);
        int i6 = ((264241152 & readInt) >>> 22) - 32;
        int i7 = (3670016 & readInt) >>> 19;
        DayOfWeek s3 = i7 == 0 ? null : DayOfWeek.s(i7);
        int i8 = (507904 & readInt) >>> 14;
        d dVar2 = d.values()[(readInt & 12288) >>> 12];
        int i9 = (readInt & 4080) >>> 4;
        int i10 = (readInt & 12) >>> 2;
        int i11 = readInt & 3;
        if (i8 == 31) {
            long readInt2 = dataInput.readInt();
            l lVar2 = l.f4720e;
            j$.time.temporal.a.SECOND_OF_DAY.X(readInt2);
            int i12 = (int) (readInt2 / 3600);
            long j4 = readInt2 - (i12 * 3600);
            dVar = dVar2;
            lVar = l.A(i12, (int) (j4 / 60), (int) (j4 - (r14 * 60)), 0);
        } else {
            dVar = dVar2;
            int i13 = i8 % 24;
            l lVar3 = l.f4720e;
            j$.time.temporal.a.HOUR_OF_DAY.X(i13);
            lVar = l.f4723h[i13];
        }
        ZoneOffset Y3 = ZoneOffset.Y(i9 == 255 ? dataInput.readInt() : (i9 - 128) * 900);
        if (i10 == 3) {
            i4 = dataInput.readInt();
        } else {
            i4 = (i10 * 1800) + Y3.f4569b;
        }
        ZoneOffset Y4 = ZoneOffset.Y(i4);
        if (i11 == 3) {
            i5 = dataInput.readInt();
        } else {
            i5 = (i11 * 1800) + Y3.f4569b;
        }
        ZoneOffset Y5 = ZoneOffset.Y(i5);
        boolean z = i8 == 24;
        Objects.requireNonNull(I3, "month");
        Objects.requireNonNull(lVar, "time");
        d dVar3 = dVar;
        Objects.requireNonNull(dVar3, "timeDefnition");
        if (i6 < -28 || i6 > 31 || i6 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (z && !lVar.equals(l.f4722g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (lVar.f4727d != 0) {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
        return new e(I3, i6, s3, lVar, z, dVar3, Y3, Y4, Y5);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f4798a == eVar.f4798a && this.f4799b == eVar.f4799b && this.f4800c == eVar.f4800c && this.f4803f == eVar.f4803f && this.f4801d.equals(eVar.f4801d) && this.f4802e == eVar.f4802e && this.f4804g.equals(eVar.f4804g) && this.f4805h.equals(eVar.f4805h) && this.f4806i.equals(eVar.f4806i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int e02 = ((this.f4801d.e0() + (this.f4802e ? 1 : 0)) << 15) + (this.f4798a.ordinal() << 11) + ((this.f4799b + 32) << 5);
        DayOfWeek dayOfWeek = this.f4800c;
        return ((this.f4804g.f4569b ^ (this.f4803f.ordinal() + (e02 + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)))) ^ this.f4805h.f4569b) ^ this.f4806i.f4569b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        sb.append(this.f4806i.f4569b - this.f4805h.f4569b > 0 ? "Gap " : "Overlap ");
        sb.append(this.f4805h);
        sb.append(" to ");
        sb.append(this.f4806i);
        sb.append(", ");
        DayOfWeek dayOfWeek = this.f4800c;
        if (dayOfWeek != null) {
            byte b4 = this.f4799b;
            if (b4 == -1) {
                sb.append(dayOfWeek.name());
                sb.append(" on or before last day of ");
                sb.append(this.f4798a.name());
            } else if (b4 < 0) {
                sb.append(dayOfWeek.name());
                sb.append(" on or before last day minus ");
                sb.append((-this.f4799b) - 1);
                sb.append(" of ");
                sb.append(this.f4798a.name());
            } else {
                sb.append(dayOfWeek.name());
                sb.append(" on or after ");
                sb.append(this.f4798a.name());
                sb.append(' ');
                sb.append((int) this.f4799b);
            }
        } else {
            sb.append(this.f4798a.name());
            sb.append(' ');
            sb.append((int) this.f4799b);
        }
        sb.append(" at ");
        sb.append(this.f4802e ? "24:00" : this.f4801d.toString());
        sb.append(" ");
        sb.append(this.f4803f);
        sb.append(", standard offset ");
        sb.append(this.f4804g);
        sb.append(']');
        return sb.toString();
    }
}
