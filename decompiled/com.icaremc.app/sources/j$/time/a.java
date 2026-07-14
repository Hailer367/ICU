package j$.time;

import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class a extends b implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4574b;
    private static final long serialVersionUID = 6740630888130243051L;

    /* renamed from: a, reason: collision with root package name */
    public final ZoneId f4575a;

    public a(ZoneId zoneId) {
        this.f4575a = zoneId;
    }

    static {
        System.currentTimeMillis();
        f4574b = new a(ZoneOffset.UTC);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f4575a.equals(((a) obj).f4575a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4575a.hashCode() + 1;
    }

    public final String toString() {
        return "SystemClock[" + this.f4575a + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
    }
}
