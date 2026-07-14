package i0;

import K.V;
import com.google.firebase.encoders.json.BuildConfig;
import java.math.BigInteger;

/* loaded from: classes.dex */
public final class h implements Comparable {

    /* renamed from: h, reason: collision with root package name */
    public static final h f2347h;

    /* renamed from: c, reason: collision with root package name */
    public final int f2348c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2349d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2350e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2351f;

    /* renamed from: g, reason: collision with root package name */
    public final Q0.h f2352g = new Q0.h(new V(3, this));

    static {
        new h(0, 0, 0, BuildConfig.FLAVOR);
        f2347h = new h(0, 1, 0, BuildConfig.FLAVOR);
        new h(1, 0, 0, BuildConfig.FLAVOR);
    }

    public h(int i2, int i3, int i4, String str) {
        this.f2348c = i2;
        this.f2349d = i3;
        this.f2350e = i4;
        this.f2351f = str;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        h other = (h) obj;
        kotlin.jvm.internal.h.e(other, "other");
        Object a2 = this.f2352g.a();
        kotlin.jvm.internal.h.d(a2, "<get-bigInteger>(...)");
        Object a3 = other.f2352g.a();
        kotlin.jvm.internal.h.d(a3, "<get-bigInteger>(...)");
        return ((BigInteger) a2).compareTo((BigInteger) a3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f2348c != hVar.f2348c || this.f2349d != hVar.f2349d || this.f2350e != hVar.f2350e) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((((527 + this.f2348c) * 31) + this.f2349d) * 31) + this.f2350e;
    }

    public final String toString() {
        String str;
        String str2 = this.f2351f;
        if (!k1.h.P(str2)) {
            str = "-" + str2;
        } else {
            str = BuildConfig.FLAVOR;
        }
        return this.f2348c + '.' + this.f2349d + '.' + this.f2350e + str;
    }
}
