package W1;

import b2.C0223a;
import b2.C0224b;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes.dex */
public class E extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        ArrayList arrayList = new ArrayList();
        c0223a.a();
        while (c0223a.k()) {
            try {
                arrayList.add(Integer.valueOf(c0223a.p()));
            } catch (NumberFormatException e4) {
                throw new RuntimeException(e4);
            }
        }
        c0223a.e();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i4 = 0; i4 < size; i4++) {
            atomicIntegerArray.set(i4, ((Integer) arrayList.get(i4)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        c0224b.b();
        int length = ((AtomicIntegerArray) obj).length();
        for (int i4 = 0; i4 < length; i4++) {
            c0224b.o(r6.get(i4));
        }
        c0224b.e();
    }
}
