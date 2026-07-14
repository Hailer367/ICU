package Y0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f2017a;

    /* renamed from: b, reason: collision with root package name */
    public final E0.a f2018b;

    /* renamed from: c, reason: collision with root package name */
    public final X0.b f2019c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2020d;

    public a(E0.a aVar, X0.b bVar, String str) {
        this.f2018b = aVar;
        this.f2019c = bVar;
        this.f2020d = str;
        this.f2017a = Arrays.hashCode(new Object[]{aVar, bVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!Z0.r.g(this.f2018b, aVar.f2018b) || !Z0.r.g(this.f2019c, aVar.f2019c) || !Z0.r.g(this.f2020d, aVar.f2020d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f2017a;
    }
}
