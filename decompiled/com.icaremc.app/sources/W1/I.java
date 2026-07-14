package W1;

import b2.C0223a;
import b2.C0224b;

/* loaded from: classes.dex */
public class I extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        String v3 = c0223a.v();
        if (v3.length() == 1) {
            return Character.valueOf(v3.charAt(0));
        }
        throw new RuntimeException("Expecting character, got: " + v3 + "; at " + c0223a.j());
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        String valueOf;
        Character ch = (Character) obj;
        if (ch == null) {
            valueOf = null;
        } else {
            valueOf = String.valueOf(ch);
        }
        c0224b.r(valueOf);
    }
}
