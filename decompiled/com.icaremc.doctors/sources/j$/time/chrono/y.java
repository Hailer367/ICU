package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class y implements m, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final y f2531d;

    /* renamed from: e, reason: collision with root package name */
    public static final y[] f2532e;
    private static final long serialVersionUID = 1466499369062886794L;

    /* renamed from: a, reason: collision with root package name */
    public final transient int f2533a;

    /* renamed from: b, reason: collision with root package name */
    public final transient j$.time.h f2534b;

    /* renamed from: c, reason: collision with root package name */
    public final transient String f2535c;

    static {
        y yVar = new y(-1, j$.time.h.b0(1868, 1, 1), "Meiji");
        f2531d = yVar;
        y yVar2 = new y(0, j$.time.h.b0(1912, 7, 30), "Taisho");
        y yVar3 = new y(1, j$.time.h.b0(1926, 12, 25), "Showa");
        y yVar4 = new y(2, j$.time.h.b0(1989, 1, 8), "Heisei");
        y yVar5 = new y(3, j$.time.h.b0(2019, 5, 1), "Reiwa");
        f2532e = r7;
        y[] yVarArr = {yVar, yVar2, yVar3, yVar4, yVar5};
    }

    public final y q() {
        if (this == f2532e[r0.length - 1]) {
            return null;
        }
        return r(this.f2533a + 1);
    }

    public y(int i2, j$.time.h hVar, String str) {
        this.f2533a = i2;
        this.f2534b = hVar;
        this.f2535c = str;
    }

    public static y r(int i2) {
        int i3 = i2 + 1;
        if (i3 >= 0) {
            y[] yVarArr = f2532e;
            if (i3 < yVarArr.length) {
                return yVarArr[i3];
            }
        }
        throw new RuntimeException("Invalid era: " + i2);
    }

    public static y p(j$.time.h hVar) {
        if (hVar.X(x.f2527d)) {
            throw new RuntimeException("JapaneseDate before Meiji 6 are not supported");
        }
        for (int length = f2532e.length - 1; length >= 0; length--) {
            y yVar = f2532e[length];
            if (hVar.compareTo(yVar.f2534b) >= 0) {
                return yVar;
            }
        }
        return null;
    }

    @Override // j$.time.chrono.m
    public final int getValue() {
        return this.f2533a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        if (qVar == aVar) {
            return v.f2525c.y(aVar);
        }
        return super.l(qVar);
    }

    public final String toString() {
        return this.f2535c;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 5, this);
    }
}
