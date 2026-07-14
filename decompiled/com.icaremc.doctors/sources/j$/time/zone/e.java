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
    public final n f2701a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f2702b;

    /* renamed from: c, reason: collision with root package name */
    public final DayOfWeek f2703c;

    /* renamed from: d, reason: collision with root package name */
    public final l f2704d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f2705e;

    /* renamed from: f, reason: collision with root package name */
    public final d f2706f;

    /* renamed from: g, reason: collision with root package name */
    public final ZoneOffset f2707g;

    /* renamed from: h, reason: collision with root package name */
    public final ZoneOffset f2708h;

    /* renamed from: i, reason: collision with root package name */
    public final ZoneOffset f2709i;

    public e(n nVar, int i2, DayOfWeek dayOfWeek, l lVar, boolean z, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f2701a = nVar;
        this.f2702b = (byte) i2;
        this.f2703c = dayOfWeek;
        this.f2704d = lVar;
        this.f2705e = z;
        this.f2706f = dVar;
        this.f2707g = zoneOffset;
        this.f2708h = zoneOffset2;
        this.f2709i = zoneOffset3;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final void b(DataOutput dataOutput) {
        int e02 = this.f2705e ? 86400 : this.f2704d.e0();
        int i2 = this.f2707g.f2471b;
        int i3 = this.f2708h.f2471b - i2;
        int i4 = this.f2709i.f2471b - i2;
        byte b2 = e02 % 3600 == 0 ? this.f2705e ? (byte) 24 : this.f2704d.f2627a : (byte) 31;
        int i5 = i2 % 900 == 0 ? (i2 / 900) + 128 : 255;
        int i6 = (i3 == 0 || i3 == 1800 || i3 == 3600) ? i3 / 1800 : 3;
        int i7 = (i4 == 0 || i4 == 1800 || i4 == 3600) ? i4 / 1800 : 3;
        DayOfWeek dayOfWeek = this.f2703c;
        dataOutput.writeInt((this.f2701a.getValue() << 28) + ((this.f2702b + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.getValue()) << 19) + (b2 << 14) + (this.f2706f.ordinal() << 12) + (i5 << 4) + (i6 << 2) + i7);
        if (b2 == 31) {
            dataOutput.writeInt(e02);
        }
        if (i5 == 255) {
            dataOutput.writeInt(i2);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.f2708h.f2471b);
        }
        if (i7 == 3) {
            dataOutput.writeInt(this.f2709i.f2471b);
        }
    }

    public static e a(DataInput dataInput) {
        d dVar;
        l lVar;
        int i2;
        int i3;
        int readInt = dataInput.readInt();
        n I2 = n.I(readInt >>> 28);
        int i4 = ((264241152 & readInt) >>> 22) - 32;
        int i5 = (3670016 & readInt) >>> 19;
        DayOfWeek s2 = i5 == 0 ? null : DayOfWeek.s(i5);
        int i6 = (507904 & readInt) >>> 14;
        d dVar2 = d.values()[(readInt & 12288) >>> 12];
        int i7 = (readInt & 4080) >>> 4;
        int i8 = (readInt & 12) >>> 2;
        int i9 = readInt & 3;
        if (i6 == 31) {
            long readInt2 = dataInput.readInt();
            l lVar2 = l.f2623e;
            j$.time.temporal.a.SECOND_OF_DAY.X(readInt2);
            int i10 = (int) (readInt2 / 3600);
            long j2 = readInt2 - (i10 * 3600);
            dVar = dVar2;
            lVar = l.A(i10, (int) (j2 / 60), (int) (j2 - (r14 * 60)), 0);
        } else {
            dVar = dVar2;
            int i11 = i6 % 24;
            l lVar3 = l.f2623e;
            j$.time.temporal.a.HOUR_OF_DAY.X(i11);
            lVar = l.f2626h[i11];
        }
        ZoneOffset Y2 = ZoneOffset.Y(i7 == 255 ? dataInput.readInt() : (i7 - 128) * 900);
        if (i8 == 3) {
            i2 = dataInput.readInt();
        } else {
            i2 = (i8 * 1800) + Y2.f2471b;
        }
        ZoneOffset Y3 = ZoneOffset.Y(i2);
        if (i9 == 3) {
            i3 = dataInput.readInt();
        } else {
            i3 = (i9 * 1800) + Y2.f2471b;
        }
        ZoneOffset Y4 = ZoneOffset.Y(i3);
        boolean z = i6 == 24;
        Objects.requireNonNull(I2, "month");
        Objects.requireNonNull(lVar, "time");
        d dVar3 = dVar;
        Objects.requireNonNull(dVar3, "timeDefnition");
        if (i4 < -28 || i4 > 31 || i4 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (z && !lVar.equals(l.f2625g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (lVar.f2630d != 0) {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
        return new e(I2, i4, s2, lVar, z, dVar3, Y2, Y3, Y4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f2701a == eVar.f2701a && this.f2702b == eVar.f2702b && this.f2703c == eVar.f2703c && this.f2706f == eVar.f2706f && this.f2704d.equals(eVar.f2704d) && this.f2705e == eVar.f2705e && this.f2707g.equals(eVar.f2707g) && this.f2708h.equals(eVar.f2708h) && this.f2709i.equals(eVar.f2709i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int e02 = ((this.f2704d.e0() + (this.f2705e ? 1 : 0)) << 15) + (this.f2701a.ordinal() << 11) + ((this.f2702b + 32) << 5);
        DayOfWeek dayOfWeek = this.f2703c;
        return ((this.f2707g.f2471b ^ (this.f2706f.ordinal() + (e02 + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)))) ^ this.f2708h.f2471b) ^ this.f2709i.f2471b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        sb.append(this.f2709i.f2471b - this.f2708h.f2471b > 0 ? "Gap " : "Overlap ");
        sb.append(this.f2708h);
        sb.append(" to ");
        sb.append(this.f2709i);
        sb.append(", ");
        DayOfWeek dayOfWeek = this.f2703c;
        if (dayOfWeek != null) {
            byte b2 = this.f2702b;
            if (b2 == -1) {
                sb.append(dayOfWeek.name());
                sb.append(" on or before last day of ");
                sb.append(this.f2701a.name());
            } else if (b2 < 0) {
                sb.append(dayOfWeek.name());
                sb.append(" on or before last day minus ");
                sb.append((-this.f2702b) - 1);
                sb.append(" of ");
                sb.append(this.f2701a.name());
            } else {
                sb.append(dayOfWeek.name());
                sb.append(" on or after ");
                sb.append(this.f2701a.name());
                sb.append(' ');
                sb.append((int) this.f2702b);
            }
        } else {
            sb.append(this.f2701a.name());
            sb.append(' ');
            sb.append((int) this.f2702b);
        }
        sb.append(" at ");
        sb.append(this.f2705e ? "24:00" : this.f2704d.toString());
        sb.append(" ");
        sb.append(this.f2706f);
        sb.append(", standard offset ");
        sb.append(this.f2707g);
        sb.append(']');
        return sb.toString();
    }
}
