package P0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f1321a;

    /* renamed from: b, reason: collision with root package name */
    public final I0.j f1322b;

    /* renamed from: c, reason: collision with root package name */
    public final I0.i f1323c;

    public b(long j4, I0.j jVar, I0.i iVar) {
        this.f1321a = j4;
        this.f1322b = jVar;
        this.f1323c = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f1321a == bVar.f1321a && this.f1322b.equals(bVar.f1322b) && this.f1323c.equals(bVar.f1323c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f1321a;
        return ((((((int) ((j4 >>> 32) ^ j4)) ^ 1000003) * 1000003) ^ this.f1322b.hashCode()) * 1000003) ^ this.f1323c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f1321a + ", transportContext=" + this.f1322b + ", event=" + this.f1323c + "}";
    }
}
