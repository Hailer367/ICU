package W1;

import b2.C0223a;
import b2.C0224b;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class h0 extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        return new AtomicBoolean(c0223a.n());
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        c0224b.s(((AtomicBoolean) obj).get());
    }
}
