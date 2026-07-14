package W1;

import a2.C0143a;
import java.util.Date;

/* renamed from: W1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0114e implements T1.t {
    @Override // T1.t
    public final T1.s create(T1.e eVar, C0143a c0143a) {
        if (c0143a.f2216a == Date.class) {
            return new C0117h(AbstractC0116g.f1910a);
        }
        return null;
    }

    public final String toString() {
        return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
    }
}
