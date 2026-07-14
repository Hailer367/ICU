package x1;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Class f6490a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f6491b;

    public o(Class cls, Class cls2) {
        this.f6490a = cls;
        this.f6491b = cls2;
    }

    public static o a(Class cls) {
        return new o(n.class, cls);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (!this.f6491b.equals(oVar.f6491b)) {
            return false;
        }
        return this.f6490a.equals(oVar.f6490a);
    }

    public final int hashCode() {
        return this.f6490a.hashCode() + (this.f6491b.hashCode() * 31);
    }

    public final String toString() {
        Class cls = this.f6491b;
        Class cls2 = this.f6490a;
        if (cls2 == n.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + " " + cls.getName();
    }
}
