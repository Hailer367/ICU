package l0;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final i0.b f2925a;

    /* renamed from: b, reason: collision with root package name */
    public final b f2926b;

    /* renamed from: c, reason: collision with root package name */
    public final b f2927c;

    public c(i0.b bVar, b bVar2, b bVar3) {
        int i2 = bVar.f2332b;
        this.f2925a = bVar;
        this.f2926b = bVar2;
        this.f2927c = bVar3;
        int i3 = bVar.f2333c;
        int i4 = bVar.f2331a;
        if (i3 - i4 == 0 && bVar.f2334d - i2 == 0) {
            throw new IllegalArgumentException("Bounds must be non zero");
        }
        if (i4 != 0 && i2 != 0) {
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
        if (!c.class.equals(cls)) {
            return false;
        }
        kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        c cVar = (c) obj;
        if (kotlin.jvm.internal.h.a(this.f2925a, cVar.f2925a) && kotlin.jvm.internal.h.a(this.f2926b, cVar.f2926b) && kotlin.jvm.internal.h.a(this.f2927c, cVar.f2927c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f2927c.hashCode() + ((this.f2926b.hashCode() + (this.f2925a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return c.class.getSimpleName() + " { " + this.f2925a + ", type=" + this.f2926b + ", state=" + this.f2927c + " }";
    }
}
