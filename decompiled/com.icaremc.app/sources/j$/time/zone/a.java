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
    public byte f4789a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4790b;

    public a() {
    }

    public a(byte b4, Object obj) {
        this.f4789a = b4;
        this.f4790b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b4 = this.f4789a;
        Object obj = this.f4790b;
        objectOutput.writeByte(b4);
        if (b4 != 1) {
            if (b4 == 2) {
                b bVar = (b) obj;
                c(bVar.f4792a, objectOutput);
                d(bVar.f4794c, objectOutput);
                d(bVar.f4795d, objectOutput);
                return;
            }
            if (b4 == 3) {
                ((e) obj).b(objectOutput);
                return;
            } else {
                if (b4 != 100) {
                    throw new InvalidClassException("Unknown serialized type");
                }
                objectOutput.writeUTF(((f) obj).f4816g.getID());
                return;
            }
        }
        f fVar = (f) obj;
        objectOutput.writeInt(fVar.f4810a.length);
        for (long j4 : fVar.f4810a) {
            c(j4, objectOutput);
        }
        for (ZoneOffset zoneOffset : fVar.f4811b) {
            d(zoneOffset, objectOutput);
        }
        objectOutput.writeInt(fVar.f4812c.length);
        for (long j5 : fVar.f4812c) {
            c(j5, objectOutput);
        }
        for (ZoneOffset zoneOffset2 : fVar.f4814e) {
            d(zoneOffset2, objectOutput);
        }
        objectOutput.writeByte(fVar.f4815f.length);
        for (e eVar : fVar.f4815f) {
            eVar.b(objectOutput);
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        Object fVar;
        byte readByte = objectInput.readByte();
        this.f4789a = readByte;
        if (readByte == 1) {
            long[] jArr = f.f4807i;
            int readInt = objectInput.readInt();
            long[] jArr2 = readInt == 0 ? jArr : new long[readInt];
            for (int i4 = 0; i4 < readInt; i4++) {
                jArr2[i4] = a(objectInput);
            }
            int i5 = readInt + 1;
            ZoneOffset[] zoneOffsetArr = new ZoneOffset[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                zoneOffsetArr[i6] = b(objectInput);
            }
            int readInt2 = objectInput.readInt();
            if (readInt2 != 0) {
                jArr = new long[readInt2];
            }
            long[] jArr3 = jArr;
            for (int i7 = 0; i7 < readInt2; i7++) {
                jArr3[i7] = a(objectInput);
            }
            int i8 = readInt2 + 1;
            ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i8];
            for (int i9 = 0; i9 < i8; i9++) {
                zoneOffsetArr2[i9] = b(objectInput);
            }
            int readByte2 = objectInput.readByte();
            e[] eVarArr = readByte2 == 0 ? f.f4808j : new e[readByte2];
            for (int i10 = 0; i10 < readByte2; i10++) {
                eVarArr[i10] = e.a(objectInput);
            }
            fVar = new f(jArr2, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
        } else if (readByte == 2) {
            int i11 = b.f4791e;
            long a4 = a(objectInput);
            ZoneOffset b4 = b(objectInput);
            ZoneOffset b5 = b(objectInput);
            if (b4.equals(b5)) {
                throw new IllegalArgumentException("Offsets must not be equal");
            }
            fVar = new b(a4, b4, b5);
        } else if (readByte == 3) {
            fVar = e.a(objectInput);
        } else {
            if (readByte != 100) {
                throw new StreamCorruptedException("Unknown serialized type");
            }
            fVar = new f(TimeZone.getTimeZone(objectInput.readUTF()));
        }
        this.f4790b = fVar;
    }

    private Object readResolve() {
        return this.f4790b;
    }

    public static ZoneOffset b(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.Y(dataInput.readInt()) : ZoneOffset.Y(readByte * 900);
    }

    public static void c(long j4, DataOutput dataOutput) {
        if (j4 >= -4575744000L && j4 < 10413792000L && j4 % 900 == 0) {
            int i4 = (int) ((j4 + 4575744000L) / 900);
            dataOutput.writeByte((i4 >>> 16) & 255);
            dataOutput.writeByte((i4 >>> 8) & 255);
            dataOutput.writeByte(i4 & 255);
            return;
        }
        dataOutput.writeByte(255);
        dataOutput.writeLong(j4);
    }

    public static long a(DataInput dataInput) {
        if ((dataInput.readByte() & 255) == 255) {
            return dataInput.readLong();
        }
        return ((((r0 << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255)) * 900) - 4575744000L;
    }

    public static void d(ZoneOffset zoneOffset, DataOutput dataOutput) {
        int i4 = zoneOffset.f4569b;
        int i5 = i4 % 900 == 0 ? i4 / 900 : 127;
        dataOutput.writeByte(i5);
        if (i5 == 127) {
            dataOutput.writeInt(i4);
        }
    }
}
