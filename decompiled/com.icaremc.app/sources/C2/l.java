package C2;

import java.util.Map;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f272a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f273b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f274c;

    public l(boolean z, boolean z3, Map map) {
        this.f272a = z;
        this.f273b = z3;
        this.f274c = map;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(l.class)) {
            if (this != obj) {
                l lVar = (l) obj;
                if (AbstractC0602b.s(Boolean.valueOf(this.f272a), Boolean.valueOf(lVar.f272a)) && AbstractC0602b.s(Boolean.valueOf(this.f273b), Boolean.valueOf(lVar.f273b)) && AbstractC0602b.s(this.f274c, lVar.f274c)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0602b.t(this.f274c) + ((AbstractC0602b.t(Boolean.valueOf(this.f273b)) + ((AbstractC0602b.t(Boolean.valueOf(this.f272a)) + (l.class.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "WebViewOptions(enableJavaScript=" + this.f272a + ", enableDomStorage=" + this.f273b + ", headers=" + this.f274c + ")";
    }
}
