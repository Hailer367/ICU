package j$.time.zone;

import j$.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final class a implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;

    /* renamed from: a, reason: collision with root package name */
    public byte f2692a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2693b;

    public a() {
    }

    public a(byte b2, Object obj) {
        this.f2692a = b2;
        this.f2693b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b2 = this.f2692a;
        Object obj = this.f2693b;
        objectOutput.writeByte(b2);
        if (b2 != 1) {
            if (b2 == 2) {
                b bVar = (b) obj;
                c(bVar.f2695a, objectOutput);
                d(bVar.f2697c, objectOutput);
                d(bVar.f2698d, objectOutput);
                return;
            }
            if (b2 == 3) {
                ((e) obj).b(objectOutput);
                return;
            } else {
                if (b2 != 100) {
                    throw new InvalidClassException("Unknown serialized type");
                }
                objectOutput.writeUTF(((f) obj).f2720g.getID());
                return;
            }
        }
        f fVar = (f) obj;
        objectOutput.writeInt(fVar.f2714a.length);
        for (long j2 : fVar.f2714a) {
            c(j2, objectOutput);
        }
        for (ZoneOffset zoneOffset : fVar.f2715b) {
            d(zoneOffset, objectOutput);
        }
        objectOutput.writeInt(fVar.f2716c.length);
        for (long j3 : fVar.f2716c) {
            c(j3, objectOutput);
        }
        for (ZoneOffset zoneOffset2 : fVar.f2718e) {
            d(zoneOffset2, objectOutput);
        }
        objectOutput.writeByte(fVar.f2719f.length);
        for (e eVar : fVar.f2719f) {
            eVar.b(objectOutput);
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        Object fVar;
        byte readByte = objectInput.readByte();
        this.f2692a = readByte;
        if (readByte == 1) {
            long[] jArr = f.f2710i;
            int readInt = objectInput.readInt();
            long[] jArr2 = readInt == 0 ? jArr : new long[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                jArr2[i2] = a(objectInput);
            }
            int i3 = readInt + 1;
            ZoneOffset[] zoneOffsetArr = new ZoneOffset[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                zoneOffsetArr[i4] = b(objectInput);
            }
            int readInt2 = objectInput.readInt();
            if (readInt2 != 0) {
                jArr = new long[readInt2];
            }
            long[] jArr3 = jArr;
            for (int i5 = 0; i5 < readInt2; i5++) {
                jArr3[i5] = a(objectInput);
            }
            int i6 = readInt2 + 1;
            ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                zoneOffsetArr2[i7] = b(objectInput);
            }
            int readByte2 = objectInput.readByte();
            e[] eVarArr = readByte2 == 0 ? f.f2711j : new e[readByte2];
            for (int i8 = 0; i8 < readByte2; i8++) {
                eVarArr[i8] = e.a(objectInput);
            }
            fVar = new f(jArr2, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
        } else if (readByte == 2) {
            int i9 = b.f2694e;
            long a2 = a(objectInput);
            ZoneOffset b2 = b(objectInput);
            ZoneOffset b3 = b(objectInput);
            if (b2.equals(b3)) {
                throw new IllegalArgumentException("Offsets must not be equal");
            }
            fVar = new b(a2, b2, b3);
        } else if (readByte == 3) {
            fVar = e.a(objectInput);
        } else {
            if (readByte != 100) {
                throw new StreamCorruptedException("Unknown serialized type");
            }
            fVar = new f(TimeZone.getTimeZone(objectInput.readUTF()));
        }
        this.f2693b = fVar;
    }

    private Object readResolve() {
        return this.f2693b;
    }

    public static ZoneOffset b(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.Y(dataInput.readInt()) : ZoneOffset.Y(readByte * 900);
    }

    public static void c(long j2, DataOutput dataOutput) {
        if (j2 >= -4575744000L && j2 < 10413792000L && j2 % 900 == 0) {
            int i2 = (int) ((j2 + 4575744000L) / 900);
            dataOutput.writeByte((i2 >>> 16) & 255);
            dataOutput.writeByte((i2 >>> 8) & 255);
            dataOutput.writeByte(i2 & 255);
            return;
        }
        dataOutput.writeByte(255);
        dataOutput.writeLong(j2);
    }

    public static long a(DataInput dataInput) {
        if ((dataInput.readByte() & 255) == 255) {
            return dataInput.readLong();
        }
        return ((((r0 << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255)) * 900) - 4575744000L;
    }

    public static void d(ZoneOffset zoneOffset, DataOutput dataOutput) {
        int i2 = zoneOffset.f2471b;
        int i3 = i2 % 900 == 0 ? i2 / 900 : 127;
        dataOutput.writeByte(i3);
        if (i3 == 127) {
            dataOutput.writeInt(i2);
        }
    }
}
