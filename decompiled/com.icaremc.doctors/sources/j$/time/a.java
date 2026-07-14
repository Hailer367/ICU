package j$.time;

import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class a extends b implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f2476b;
    private static final long serialVersionUID = 6740630888130243051L;

    /* renamed from: a, reason: collision with root package name */
    public final ZoneId f2477a;

    public a(ZoneId zoneId) {
        this.f2477a = zoneId;
    }

    static {
        System.currentTimeMillis();
        f2476b = new a(ZoneOffset.UTC);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f2477a.equals(((a) obj).f2477a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2477a.hashCode() + 1;
    }

    public final String toString() {
        return "SystemClock[" + this.f2477a + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
    }
}
