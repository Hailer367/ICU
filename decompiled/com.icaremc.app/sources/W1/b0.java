package W1;

import b2.C0223a;
import b2.C0224b;

/* loaded from: classes.dex */
public class b0 extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        int x3 = c0223a.x();
        if (x3 == 9) {
            c0223a.t();
            return null;
        }
        if (x3 == 6) {
            return Boolean.valueOf(Boolean.parseBoolean(c0223a.v()));
        }
        return Boolean.valueOf(c0223a.n());
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        c0224b.p((Boolean) obj);
    }
}
