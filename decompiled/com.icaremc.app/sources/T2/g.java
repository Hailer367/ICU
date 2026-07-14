package T2;

/* loaded from: classes.dex */
public abstract class g extends c implements f, Y2.a, H2.a {

    /* renamed from: l, reason: collision with root package name */
    public final int f1637l;

    /* renamed from: m, reason: collision with root package name */
    public final int f1638m;

    public g(int i4, Class cls, String str, String str2, int i5) {
        this(i4, b.f1629f, cls, str, str2, i5, 0);
    }

    @Override // T2.f
    public final int b() {
        return this.f1637l;
    }

    @Override // T2.c
    public final Y2.a d() {
        q.f1646a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (this.f1633i.equals(gVar.f1633i) && this.f1634j.equals(gVar.f1634j) && this.f1638m == gVar.f1638m && this.f1637l == gVar.f1637l && this.f1631g.equals(gVar.f1631g) && g().equals(gVar.g())) {
                    return true;
                }
                return false;
            }
            if (obj instanceof g) {
                Y2.a aVar = this.f1630f;
                if (aVar == null) {
                    d();
                    this.f1630f = this;
                    aVar = this;
                }
                return obj.equals(aVar);
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        g();
        return this.f1634j.hashCode() + ((this.f1633i.hashCode() + (g().hashCode() * 31)) * 31);
    }

    public final String toString() {
        Y2.a aVar = this.f1630f;
        if (aVar == null) {
            d();
            this.f1630f = this;
            aVar = this;
        }
        if (aVar != this) {
            return aVar.toString();
        }
        String str = this.f1633i;
        if ("<init>".equals(str)) {
            return "constructor (Kotlin reflection is not available)";
        }
        return r2.k.b("function ", str, " (Kotlin reflection is not available)");
    }

    public g(int i4, Object obj, Class cls, String str, String str2, int i5, int i6) {
        super(obj, cls, str, str2, (i5 & 1) == 1);
        this.f1637l = i4;
        this.f1638m = 0;
    }
}
