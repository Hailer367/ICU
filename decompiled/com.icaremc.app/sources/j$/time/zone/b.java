package j$.time.zone;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class b implements Comparable, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f4791e = 0;
    private static final long serialVersionUID = -6946044323557704546L;

    /* renamed from: a, reason: collision with root package name */
    public final long f4792a;

    /* renamed from: b, reason: collision with root package name */
    public final LocalDateTime f4793b;

    /* renamed from: c, reason: collision with root package name */
    public final ZoneOffset f4794c;

    /* renamed from: d, reason: collision with root package name */
    public final ZoneOffset f4795d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f4792a, ((b) obj).f4792a);
    }

    public b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f4792a = localDateTime.w(zoneOffset);
        this.f4793b = localDateTime;
        this.f4794c = zoneOffset;
        this.f4795d = zoneOffset2;
    }

    public b(long j4, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f4792a = j4;
        this.f4793b = LocalDateTime.P(j4, 0, zoneOffset);
        this.f4794c = zoneOffset;
        this.f4795d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public final boolean s() {
        return this.f4795d.f4569b > this.f4794c.f4569b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f4792a == bVar.f4792a && this.f4794c.equals(bVar.f4794c) && this.f4795d.equals(bVar.f4795d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f4793b.hashCode() ^ this.f4794c.f4569b) ^ Integer.rotateLeft(this.f4795d.f4569b, 16);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        sb.append(s() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f4793b);
        sb.append(this.f4794c);
        sb.append(" to ");
        sb.append(this.f4795d);
        sb.append(']');
        return sb.toString();
    }
}
