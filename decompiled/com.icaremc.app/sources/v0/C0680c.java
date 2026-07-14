package v0;

/* renamed from: v0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0680c {

    /* renamed from: a, reason: collision with root package name */
    public final s0.b f6268a;

    /* renamed from: b, reason: collision with root package name */
    public final C0679b f6269b;

    /* renamed from: c, reason: collision with root package name */
    public final C0679b f6270c;

    public C0680c(s0.b bVar, C0679b c0679b, C0679b c0679b2) {
        int i4 = bVar.f6126b;
        this.f6268a = bVar;
        this.f6269b = c0679b;
        this.f6270c = c0679b2;
        int i5 = bVar.f6127c;
        int i6 = bVar.f6125a;
        if (i5 - i6 == 0 && bVar.f6128d - i4 == 0) {
            throw new IllegalArgumentException("Bounds must be non zero");
        }
        if (i6 != 0 && i4 != 0) {
            throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
        }
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!C0680c.class.equals(cls)) {
            return false;
        }
        T2.h.c(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        C0680c c0680c = (C0680c) obj;
        if (T2.h.a(this.f6268a, c0680c.f6268a) && T2.h.a(this.f6269b, c0680c.f6269b) && T2.h.a(this.f6270c, c0680c.f6270c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6270c.hashCode() + ((this.f6269b.hashCode() + (this.f6268a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return C0680c.class.getSimpleName() + " { " + this.f6268a + ", type=" + this.f6269b + ", state=" + this.f6270c + " }";
    }
}
