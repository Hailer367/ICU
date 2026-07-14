package F0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Q1.e f522a;

    /* renamed from: b, reason: collision with root package name */
    public final b f523b;

    public a(Q1.e eVar, b bVar) {
        this.f522a = eVar;
        this.f523b = bVar;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                aVar.getClass();
                Q1.e eVar = aVar.f522a;
                b bVar = aVar.f523b;
                if (this.f522a.equals(eVar)) {
                    Object obj2 = d.f526f;
                    if (obj2.equals(obj2) && this.f523b.equals(bVar)) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f523b.hashCode() ^ (((((1000003 * 1000003) ^ this.f522a.hashCode()) * 1000003) ^ d.f526f.hashCode()) * 1000003);
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f522a + ", priority=" + d.f526f + ", productData=" + this.f523b + "}";
    }
}
