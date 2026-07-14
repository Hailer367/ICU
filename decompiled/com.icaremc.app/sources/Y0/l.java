package Y0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final a f2058a;

    /* renamed from: b, reason: collision with root package name */
    public final W0.c f2059b;

    public /* synthetic */ l(a aVar, W0.c cVar) {
        this.f2058a = aVar;
        this.f2059b = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (Z0.r.g(this.f2058a, lVar.f2058a) && Z0.r.g(this.f2059b, lVar.f2059b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2058a, this.f2059b});
    }

    public final String toString() {
        E0.a aVar = new E0.a(this);
        aVar.e(this.f2058a, "key");
        aVar.e(this.f2059b, "feature");
        return aVar.toString();
    }
}
