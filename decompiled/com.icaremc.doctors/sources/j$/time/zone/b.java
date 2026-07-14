package j$.time.zone;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class b implements Comparable, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f2694e = 0;
    private static final long serialVersionUID = -6946044323557704546L;

    /* renamed from: a, reason: collision with root package name */
    public final long f2695a;

    /* renamed from: b, reason: collision with root package name */
    public final LocalDateTime f2696b;

    /* renamed from: c, reason: collision with root package name */
    public final ZoneOffset f2697c;

    /* renamed from: d, reason: collision with root package name */
    public final ZoneOffset f2698d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f2695a, ((b) obj).f2695a);
    }

    public b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f2695a = localDateTime.w(zoneOffset);
        this.f2696b = localDateTime;
        this.f2697c = zoneOffset;
        this.f2698d = zoneOffset2;
    }

    public b(long j2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f2695a = j2;
        this.f2696b = LocalDateTime.P(j2, 0, zoneOffset);
        this.f2697c = zoneOffset;
        this.f2698d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public final boolean s() {
        return this.f2698d.f2471b > this.f2697c.f2471b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f2695a == bVar.f2695a && this.f2697c.equals(bVar.f2697c) && this.f2698d.equals(bVar.f2698d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f2696b.hashCode() ^ this.f2697c.f2471b) ^ Integer.rotateLeft(this.f2698d.f2471b, 16);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        sb.append(s() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f2696b);
        sb.append(this.f2697c);
        sb.append(" to ");
        sb.append(this.f2698d);
        sb.append(']');
        return sb.toString();
    }
}
