package C0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f144a;

    /* renamed from: b, reason: collision with root package name */
    public final v0.j f145b;

    /* renamed from: c, reason: collision with root package name */
    public final v0.i f146c;

    public b(long j2, v0.j jVar, v0.i iVar) {
        this.f144a = j2;
        this.f145b = jVar;
        this.f146c = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f144a == bVar.f144a && this.f145b.equals(bVar.f145b) && this.f146c.equals(bVar.f146c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f144a;
        return ((((((int) ((j2 >>> 32) ^ j2)) ^ 1000003) * 1000003) ^ this.f145b.hashCode()) * 1000003) ^ this.f146c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f144a + ", transportContext=" + this.f145b + ", event=" + this.f146c + "}";
    }
}
