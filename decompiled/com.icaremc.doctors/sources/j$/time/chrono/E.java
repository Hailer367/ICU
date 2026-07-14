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
    public byte f2482a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2483b;

    public E() {
    }

    public E(byte b2, Object obj) {
        this.f2482a = b2;
        this.f2483b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b2 = this.f2482a;
        Object obj = this.f2483b;
        objectOutput.writeByte(b2);
        switch (b2) {
            case 1:
                objectOutput.writeUTF(((AbstractC0205a) obj).q());
                return;
            case 2:
                C0211g c0211g = (C0211g) obj;
                objectOutput.writeObject(c0211g.f2493a);
                objectOutput.writeObject(c0211g.f2494b);
                return;
            case 3:
                k kVar = (k) obj;
                objectOutput.writeObject(kVar.f2502a);
                objectOutput.writeObject(kVar.f2503b);
                objectOutput.writeObject(kVar.f2504c);
                return;
            case 4:
                x xVar = (x) obj;
                xVar.getClass();
                objectOutput.writeInt(xVar.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(xVar.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(xVar.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((y) obj).f2533a);
                return;
            case 6:
                q qVar = (q) obj;
                objectOutput.writeObject(qVar.f2517a);
                objectOutput.writeInt(qVar.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(qVar.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(qVar.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 7:
                C c2 = (C) obj;
                c2.getClass();
                objectOutput.writeInt(c2.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(c2.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(c2.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 8:
                I i2 = (I) obj;
                i2.getClass();
                objectOutput.writeInt(i2.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(i2.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(i2.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 9:
                C0212h c0212h = (C0212h) obj;
                objectOutput.writeUTF(c0212h.f2496a.q());
                objectOutput.writeInt(c0212h.f2497b);
                objectOutput.writeInt(c0212h.f2498c);
                objectOutput.writeInt(c0212h.f2499d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        Object of;
        byte readByte = objectInput.readByte();
        this.f2482a = readByte;
        switch (readByte) {
            case 1:
                ConcurrentHashMap concurrentHashMap = AbstractC0205a.f2489a;
                of = l.of(objectInput.readUTF());
                break;
            case 2:
                of = ((InterfaceC0206b) objectInput.readObject()).L((j$.time.l) objectInput.readObject());
                break;
            case 3:
                of = ((InterfaceC0209e) objectInput.readObject()).E((ZoneOffset) objectInput.readObject()).D((ZoneId) objectInput.readObject());
                break;
            case 4:
                j$.time.h hVar = x.f2527d;
                int readInt = objectInput.readInt();
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                v.f2525c.getClass();
                of = new x(j$.time.h.b0(readInt, readByte2, readByte3));
                break;
            case 5:
                y yVar = y.f2531d;
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
            case 7:
                int readInt3 = objectInput.readInt();
                byte readByte6 = objectInput.readByte();
                byte readByte7 = objectInput.readByte();
                A.f2478c.getClass();
                of = new C(j$.time.h.b0(readInt3 + 1911, readByte6, readByte7));
                break;
            case 8:
                int readInt4 = objectInput.readInt();
                byte readByte8 = objectInput.readByte();
                byte readByte9 = objectInput.readByte();
                G.f2485c.getClass();
                of = new I(j$.time.h.b0(readInt4 - 543, readByte8, readByte9));
                break;
            case 9:
                int i2 = C0212h.f2495e;
                of = new C0212h(l.of(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f2483b = of;
    }

    private Object readResolve() {
        return this.f2483b;
    }
}
