package W1;

import b2.C0223a;
import b2.C0224b;

/* loaded from: classes.dex */
public class c0 extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        return Boolean.valueOf(c0223a.v());
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        String bool;
        Boolean bool2 = (Boolean) obj;
        if (bool2 == null) {
            bool = "null";
        } else {
            bool = bool2.toString();
        }
        c0224b.r(bool);
    }
}
