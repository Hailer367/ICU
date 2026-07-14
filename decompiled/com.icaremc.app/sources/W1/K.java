package W1;

import b2.C0223a;
import b2.C0224b;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public class K extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        String v3 = c0223a.v();
        try {
            return V1.d.j(v3);
        } catch (NumberFormatException e4) {
            throw new RuntimeException("Failed parsing '" + v3 + "' as BigDecimal; at path " + c0223a.j(), e4);
        }
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        c0224b.q((BigDecimal) obj);
    }
}
