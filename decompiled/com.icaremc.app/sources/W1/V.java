package W1;

import b2.C0223a;
import b2.C0224b;
import java.util.Currency;

/* loaded from: classes.dex */
public class V extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        String v3 = c0223a.v();
        try {
            return Currency.getInstance(v3);
        } catch (IllegalArgumentException e4) {
            throw new RuntimeException("Failed parsing '" + v3 + "' as Currency; at path " + c0223a.j(), e4);
        }
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        c0224b.r(((Currency) obj).getCurrencyCode());
    }
}
