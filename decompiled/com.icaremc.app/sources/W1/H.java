package W1;

import b2.C0223a;
import b2.C0224b;

/* loaded from: classes.dex */
public class H extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        return Double.valueOf(c0223a.o());
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        Number number = (Number) obj;
        if (number == null) {
            c0224b.i();
        } else {
            c0224b.n(number.doubleValue());
        }
    }
}
