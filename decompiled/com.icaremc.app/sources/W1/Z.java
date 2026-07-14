package W1;

import b2.C0223a;
import b2.C0224b;
import java.util.BitSet;

/* loaded from: classes.dex */
public class Z extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        boolean z;
        BitSet bitSet = new BitSet();
        c0223a.a();
        int x3 = c0223a.x();
        int i4 = 0;
        while (x3 != 2) {
            int b4 = R.i.b(x3);
            if (b4 != 5 && b4 != 6) {
                if (b4 == 7) {
                    z = c0223a.n();
                } else {
                    throw new RuntimeException("Invalid bitset value type: " + A2.i.s(x3) + "; at path " + c0223a.h());
                }
            } else {
                int p3 = c0223a.p();
                if (p3 == 0) {
                    z = false;
                } else if (p3 == 1) {
                    z = true;
                } else {
                    throw new RuntimeException("Invalid bitset value " + p3 + ", expected 0 or 1; at path " + c0223a.j());
                }
            }
            if (z) {
                bitSet.set(i4);
            }
            i4++;
            x3 = c0223a.x();
        }
        c0223a.e();
        return bitSet;
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        BitSet bitSet = (BitSet) obj;
        c0224b.b();
        int length = bitSet.length();
        for (int i4 = 0; i4 < length; i4++) {
            c0224b.o(bitSet.get(i4) ? 1L : 0L);
        }
        c0224b.e();
    }
}
