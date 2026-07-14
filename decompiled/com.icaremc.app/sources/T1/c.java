package T1;

import b2.C0223a;
import b2.C0224b;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes.dex */
public final class c extends s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1606a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f1607b;

    public /* synthetic */ c(s sVar, int i4) {
        this.f1606a = i4;
        this.f1607b = sVar;
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        switch (this.f1606a) {
            case 0:
                return new AtomicLong(((Number) this.f1607b.b(c0223a)).longValue());
            default:
                ArrayList arrayList = new ArrayList();
                c0223a.a();
                while (c0223a.k()) {
                    arrayList.add(Long.valueOf(((Number) this.f1607b.b(c0223a)).longValue()));
                }
                c0223a.e();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i4 = 0; i4 < size; i4++) {
                    atomicLongArray.set(i4, ((Long) arrayList.get(i4)).longValue());
                }
                return atomicLongArray;
        }
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        switch (this.f1606a) {
            case 0:
                this.f1607b.c(c0224b, Long.valueOf(((AtomicLong) obj).get()));
                return;
            default:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                c0224b.b();
                int length = atomicLongArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    this.f1607b.c(c0224b, Long.valueOf(atomicLongArray.get(i4)));
                }
                c0224b.e();
                return;
        }
    }
}
