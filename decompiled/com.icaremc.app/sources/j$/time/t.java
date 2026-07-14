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
    public byte f4743a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4744b;

    public t() {
    }

    public t(byte b4, Object obj) {
        this.f4743a = b4;
        this.f4744b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b4 = this.f4743a;
        Object obj = this.f4744b;
        objectOutput.writeByte(b4);
        switch (b4) {
            case 1:
                e eVar = (e) obj;
                objectOutput.writeLong(eVar.f4635a);
                objectOutput.writeInt(eVar.f4636b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.f4555a);
                objectOutput.writeInt(instant.f4556b);
                return;
            case 3:
                h hVar = (h) obj;
                objectOutput.writeInt(hVar.f4713a);
                objectOutput.writeByte(hVar.f4714b);
                objectOutput.writeByte(hVar.f4715c);
                return;
            case 4:
                ((l) obj).h0(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                h hVar2 = localDateTime.f4559a;
                objectOutput.writeInt(hVar2.f4713a);
                objectOutput.writeByte(hVar2.f4714b);
                objectOutput.writeByte(hVar2.f4715c);
                localDateTime.f4560b.h0(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.f4571a;
                h hVar3 = localDateTime2.f4559a;
                objectOutput.writeInt(hVar3.f4713a);
                objectOutput.writeByte(hVar3.f4714b);
                objectOutput.writeByte(hVar3.f4715c);
                localDateTime2.f4560b.h0(objectOutput);
                zonedDateTime.f4572b.b0(objectOutput);
                zonedDateTime.f4573c.P(objectOutput);
                return;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                objectOutput.writeUTF(((y) obj).f4786b);
                return;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                ((ZoneOffset) obj).b0(objectOutput);
                return;
            case 9:
                r rVar = (r) obj;
                rVar.f4737a.h0(objectOutput);
                rVar.f4738b.b0(objectOutput);
                return;
            case 10:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.f4562a;
                h hVar4 = localDateTime3.f4559a;
                objectOutput.writeInt(hVar4.f4713a);
                objectOutput.writeByte(hVar4.f4714b);
                objectOutput.writeByte(hVar4.f4715c);
                localDateTime3.f4560b.h0(objectOutput);
                offsetDateTime.f4563b.b0(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((v) obj).f4779a);
                return;
            case 12:
                x xVar = (x) obj;
                objectOutput.writeInt(xVar.f4783a);
                objectOutput.writeByte(xVar.f4784b);
                return;
            case 13:
                p pVar = (p) obj;
                objectOutput.writeByte(pVar.f4733a);
                objectOutput.writeByte(pVar.f4734b);
                return;
            case 14:
                s sVar = (s) obj;
                objectOutput.writeInt(sVar.f4740a);
                objectOutput.writeInt(sVar.f4741b);
                objectOutput.writeInt(sVar.f4742c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.f4743a = readByte;
        this.f4744b = a(readByte, objectInput);
    }

    public static Object a(byte b4, ObjectInput objectInput) {
        switch (b4) {
            case 1:
                e eVar = e.f4634c;
                long readLong = objectInput.readLong();
                long readInt = objectInput.readInt();
                return e.A(Math.addExact(readLong, Math.floorDiv(readInt, 1000000000L)), (int) Math.floorMod(readInt, 1000000000L));
            case 2:
                Instant instant = Instant.f4554c;
                return Instant.A(objectInput.readLong(), objectInput.readInt());
            case 3:
                h hVar = h.f4711d;
                return h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return l.c0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f4557c;
                h hVar2 = h.f4711d;
                return LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.f4557c;
                h hVar3 = h.f4711d;
                LocalDateTime I3 = LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput));
                ZoneOffset a02 = ZoneOffset.a0(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || a02.equals(zoneId)) {
                    return new ZonedDateTime(I3, zoneId, a02);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                int i4 = y.f4785d;
                return ZoneId.A(objectInput.readUTF(), false);
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                return ZoneOffset.a0(objectInput);
            case 9:
                int i5 = r.f4736c;
                return new r(l.c0(objectInput), ZoneOffset.a0(objectInput));
            case 10:
                int i6 = OffsetDateTime.f4561c;
                h hVar4 = h.f4711d;
                return new OffsetDateTime(LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput)), ZoneOffset.a0(objectInput));
            case 11:
                int i7 = v.f4778b;
                return v.s(objectInput.readInt());
            case 12:
                int i8 = x.f4782c;
                int readInt2 = objectInput.readInt();
                byte readByte = objectInput.readByte();
                j$.time.temporal.a.YEAR.X(readInt2);
                j$.time.temporal.a.MONTH_OF_YEAR.X(readByte);
                return new x(readInt2, readByte);
            case 13:
                int i9 = p.f4732c;
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                n I4 = n.I(readByte2);
                Objects.requireNonNull(I4, "month");
                j$.time.temporal.a.DAY_OF_MONTH.X(readByte3);
                if (readByte3 <= I4.F()) {
                    return new p(I4.getValue(), readByte3);
                }
                throw new RuntimeException("Illegal value for DayOfMonth field, value " + ((int) readByte3) + " is not valid for month " + I4.name());
            case 14:
                s sVar = s.f4739d;
                return s.a(objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f4744b;
    }
}
