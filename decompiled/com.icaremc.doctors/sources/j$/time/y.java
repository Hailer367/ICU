package j$.time;

import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class y extends ZoneId {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f2688d = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: b, reason: collision with root package name */
    public final String f2689b;

    /* renamed from: c, reason: collision with root package name */
    public final transient j$.time.zone.f f2690c;

    public static y V(String str, boolean z) {
        j$.time.zone.f fVar;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i2 == 0) && ((charAt < '0' || charAt > '9' || i2 == 0) && ((charAt != '~' || i2 == 0) && ((charAt != '.' || i2 == 0) && ((charAt != '_' || i2 == 0) && ((charAt != '+' || i2 == 0) && (charAt != '-' || i2 == 0))))))))) {
                    throw new RuntimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                }
            }
            try {
                fVar = j$.time.zone.i.a(str);
            } catch (j$.time.zone.g e2) {
                if (z) {
                    throw e2;
                }
                fVar = null;
            }
            return new y(str, fVar);
        }
        throw new RuntimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
    }

    public y(String str, j$.time.zone.f fVar) {
        this.f2689b = str;
        this.f2690c = fVar;
    }

    @Override // j$.time.ZoneId
    public final String q() {
        return this.f2689b;
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f s() {
        j$.time.zone.f fVar = this.f2690c;
        return fVar != null ? fVar : j$.time.zone.i.a(this.f2689b);
    }

    private Object writeReplace() {
        return new t((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    public final void P(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.f2689b);
    }
}
