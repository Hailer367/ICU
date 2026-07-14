package s0;

import O.S;
import java.math.BigInteger;

/* loaded from: classes.dex */
public final class h implements Comparable {
    public static final h k;

    /* renamed from: f, reason: collision with root package name */
    public final int f6141f;

    /* renamed from: g, reason: collision with root package name */
    public final int f6142g;

    /* renamed from: h, reason: collision with root package name */
    public final int f6143h;

    /* renamed from: i, reason: collision with root package name */
    public final String f6144i;

    /* renamed from: j, reason: collision with root package name */
    public final H2.g f6145j = new H2.g(new S(4, this));

    static {
        new h(0, 0, 0, "");
        k = new h(0, 1, 0, "");
        new h(1, 0, 0, "");
    }

    public h(int i4, int i5, int i6, String str) {
        this.f6141f = i4;
        this.f6142g = i5;
        this.f6143h = i6;
        this.f6144i = str;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        h hVar = (h) obj;
        T2.h.e(hVar, "other");
        Object a4 = this.f6145j.a();
        T2.h.d(a4, "<get-bigInteger>(...)");
        Object a5 = hVar.f6145j.a();
        T2.h.d(a5, "<get-bigInteger>(...)");
        return ((BigInteger) a4).compareTo((BigInteger) a5);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f6141f != hVar.f6141f || this.f6142g != hVar.f6142g || this.f6143h != hVar.f6143h) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((((527 + this.f6141f) * 31) + this.f6142g) * 31) + this.f6143h;
    }

    public final String toString() {
        String str;
        String str2 = this.f6144i;
        if (!a3.h.D(str2)) {
            str = "-" + str2;
        } else {
            str = "";
        }
        return this.f6141f + '.' + this.f6142g + '.' + this.f6143h + str;
    }
}
