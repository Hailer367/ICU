package W1;

import b2.C0223a;
import b2.C0224b;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class g0 extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        try {
            return new AtomicInteger(c0223a.p());
        } catch (NumberFormatException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        c0224b.o(((AtomicInteger) obj).get());
    }
}
