package j$.time;

import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class t implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* renamed from: a, reason: collision with root package name */
    public byte f2646a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2647b;

    public t() {
    }

    public t(byte b2, Object obj) {
        this.f2646a = b2;
        this.f2647b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b2 = this.f2646a;
        Object obj = this.f2647b;
        objectOutput.writeByte(b2);
        switch (b2) {
            case 1:
                e eVar = (e) obj;
                objectOutput.writeLong(eVar.f2538a);
                objectOutput.writeInt(eVar.f2539b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.f2457a);
                objectOutput.writeInt(instant.f2458b);
                return;
            case 3:
                h hVar = (h) obj;
                objectOutput.writeInt(hVar.f2616a);
                objectOutput.writeByte(hVar.f2617b);
                objectOutput.writeByte(hVar.f2618c);
                return;
            case 4:
                ((l) obj).h0(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                h hVar2 = localDateTime.f2461a;
                objectOutput.writeInt(hVar2.f2616a);
                objectOutput.writeByte(hVar2.f2617b);
                objectOutput.writeByte(hVar2.f2618c);
                localDateTime.f2462b.h0(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.f2473a;
                h hVar3 = localDateTime2.f2461a;
                objectOutput.writeInt(hVar3.f2616a);
                objectOutput.writeByte(hVar3.f2617b);
                objectOutput.writeByte(hVar3.f2618c);
                localDateTime2.f2462b.h0(objectOutput);
                zonedDateTime.f2474b.b0(objectOutput);
                zonedDateTime.f2475c.P(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((y) obj).f2689b);
                return;
            case 8:
                ((ZoneOffset) obj).b0(objectOutput);
                return;
            case 9:
                r rVar = (r) obj;
                rVar.f2640a.h0(objectOutput);
                rVar.f2641b.b0(objectOutput);
                return;
            case 10:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.f2464a;
                h hVar4 = localDateTime3.f2461a;
                objectOutput.writeInt(hVar4.f2616a);
                objectOutput.writeByte(hVar4.f2617b);
                objectOutput.writeByte(hVar4.f2618c);
                localDateTime3.f2462b.h0(objectOutput);
                offsetDateTime.f2465b.b0(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((v) obj).f2682a);
                return;
            case 12:
                x xVar = (x) obj;
                objectOutput.writeInt(xVar.f2686a);
                objectOutput.writeByte(xVar.f2687b);
                return;
            case 13:
                p pVar = (p) obj;
                objectOutput.writeByte(pVar.f2636a);
                objectOutput.writeByte(pVar.f2637b);
                return;
            case 14:
                s sVar = (s) obj;
                objectOutput.writeInt(sVar.f2643a);
                objectOutput.writeInt(sVar.f2644b);
                objectOutput.writeInt(sVar.f2645c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.f2646a = readByte;
        this.f2647b = a(readByte, objectInput);
    }

    public static Object a(byte b2, ObjectInput objectInput) {
        switch (b2) {
            case 1:
                e eVar = e.f2537c;
                long readLong = objectInput.readLong();
                long readInt = objectInput.readInt();
                return e.A(Math.addExact(readLong, Math.floorDiv(readInt, 1000000000L)), (int) Math.floorMod(readInt, 1000000000L));
            case 2:
                Instant instant = Instant.f2456c;
                return Instant.ofEpochSecond(objectInput.readLong(), objectInput.readInt());
            case 3:
                h hVar = h.f2614d;
                return h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return l.c0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f2459c;
                h hVar2 = h.f2614d;
                return LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.f2459c;
                h hVar3 = h.f2614d;
                LocalDateTime I2 = LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput));
                ZoneOffset a02 = ZoneOffset.a0(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || a02.equals(zoneId)) {
                    return new ZonedDateTime(I2, zoneId, a02);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case 7:
                int i2 = y.f2688d;
                return ZoneId.A(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.a0(objectInput);
            case 9:
                int i3 = r.f2639c;
                return new r(l.c0(objectInput), ZoneOffset.a0(objectInput));
            case 10:
                int i4 = OffsetDateTime.f2463c;
                h hVar4 = h.f2614d;
                return new OffsetDateTime(LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput)), ZoneOffset.a0(objectInput));
            case 11:
                int i5 = v.f2681b;
                return v.s(objectInput.readInt());
            case 12:
                int i6 = x.f2685c;
                int readInt2 = objectInput.readInt();
                byte readByte = objectInput.readByte();
                j$.time.temporal.a.YEAR.X(readInt2);
                j$.time.temporal.a.MONTH_OF_YEAR.X(readByte);
                return new x(readInt2, readByte);
            case 13:
                int i7 = p.f2635c;
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                n I3 = n.I(readByte2);
                Objects.requireNonNull(I3, "month");
                j$.time.temporal.a.DAY_OF_MONTH.X(readByte3);
                if (readByte3 <= I3.F()) {
                    return new p(I3.getValue(), readByte3);
                }
                throw new RuntimeException("Illegal value for DayOfMonth field, value " + ((int) readByte3) + " is not valid for month " + I3.name());
            case 14:
                s sVar = s.f2642d;
                return s.a(objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f2647b;
    }
}
