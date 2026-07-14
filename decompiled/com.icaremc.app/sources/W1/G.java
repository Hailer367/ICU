package W1;

import b2.C0223a;
import b2.C0224b;

/* loaded from: classes.dex */
public class G extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        return Float.valueOf((float) c0223a.o());
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        Number number = (Number) obj;
        if (number == null) {
            c0224b.i();
            return;
        }
        if (!(number instanceof Float)) {
            number = Float.valueOf(number.floatValue());
        }
        c0224b.q(number);
    }
}
