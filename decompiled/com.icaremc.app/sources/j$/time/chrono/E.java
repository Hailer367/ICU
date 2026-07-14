package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class E implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;

    /* renamed from: a, reason: collision with root package name */
    public byte f4580a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4581b;

    public E() {
    }

    public E(byte b4, Object obj) {
        this.f4580a = b4;
        this.f4581b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b4 = this.f4580a;
        Object obj = this.f4581b;
        objectOutput.writeByte(b4);
        switch (b4) {
            case 1:
                objectOutput.writeUTF(((AbstractC0383a) obj).q());
                return;
            case 2:
                C0389g c0389g = (C0389g) obj;
                objectOutput.writeObject(c0389g.f4591a);
                objectOutput.writeObject(c0389g.f4592b);
                return;
            case 3:
                k kVar = (k) obj;
                objectOutput.writeObject(kVar.f4600a);
                objectOutput.writeObject(kVar.f4601b);
                objectOutput.writeObject(kVar.f4602c);
                return;
            case 4:
                x xVar = (x) obj;
                xVar.getClass();
                objectOutput.writeInt(xVar.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(xVar.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(xVar.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((y) obj).f4630a);
                return;
            case 6:
                q qVar = (q) obj;
                objectOutput.writeObject(qVar.f4614a);
                objectOutput.writeInt(qVar.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(qVar.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(qVar.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                C c4 = (C) obj;
                c4.getClass();
                objectOutput.writeInt(c4.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(c4.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(c4.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                I i4 = (I) obj;
                i4.getClass();
                objectOutput.writeInt(i4.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(i4.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(i4.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 9:
                C0390h c0390h = (C0390h) obj;
                objectOutput.writeUTF(c0390h.f4594a.q());
                objectOutput.writeInt(c0390h.f4595b);
                objectOutput.writeInt(c0390h.f4596c);
                objectOutput.writeInt(c0390h.f4597d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        Object of;
        byte readByte = objectInput.readByte();
        this.f4580a = readByte;
        switch (readByte) {
            case 1:
                ConcurrentHashMap concurrentHashMap = AbstractC0383a.f4587a;
                of = l.of(objectInput.readUTF());
                break;
            case 2:
                of = ((InterfaceC0384b) objectInput.readObject()).L((j$.time.l) objectInput.readObject());
                break;
            case 3:
                of = ((InterfaceC0387e) objectInput.readObject()).E((ZoneOffset) objectInput.readObject()).D((ZoneId) objectInput.readObject());
                break;
            case 4:
                j$.time.h hVar = x.f4624d;
                int readInt = objectInput.readInt();
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                v.f4622c.getClass();
                of = new x(j$.time.h.b0(readInt, readByte2, readByte3));
                break;
            case 5:
                y yVar = y.f4628d;
                of = y.r(objectInput.readByte());
                break;
            case 6:
                o oVar = (o) objectInput.readObject();
                int readInt2 = objectInput.readInt();
                byte readByte4 = objectInput.readByte();
                byte readByte5 = objectInput.readByte();
                oVar.getClass();
                of = new q(oVar, readInt2, readByte4, readByte5);
                break;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                int readInt3 = objectInput.readInt();
                byte readByte6 = objectInput.readByte();
                byte readByte7 = objectInput.readByte();
                A.f4576c.getClass();
                of = new C(j$.time.h.b0(readInt3 + 1911, readByte6, readByte7));
                break;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                int readInt4 = objectInput.readInt();
                byte readByte8 = objectInput.readByte();
                byte readByte9 = objectInput.readByte();
                G.f4583c.getClass();
                of = new I(j$.time.h.b0(readInt4 - 543, readByte8, readByte9));
                break;
            case 9:
                int i4 = C0390h.f4593e;
                of = new C0390h(l.of(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f4581b = of;
    }

    private Object readResolve() {
        return this.f4581b;
    }
}
