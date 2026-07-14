package t1;

import java.util.concurrent.atomic.AtomicReferenceArray;
import q1.r;

/* loaded from: classes.dex */
public final class i extends r {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f3672e;

    public i(long j2, i iVar, int i2) {
        super(j2, iVar, i2);
        this.f3672e = new AtomicReferenceArray(h.f3671f);
    }

    @Override // q1.r
    public final int f() {
        return h.f3671f;
    }

    @Override // q1.r
    public final void g(int i2, T0.i iVar) {
        this.f3672e.set(i2, h.f3670e);
        h();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f3542c + ", hashCode=" + hashCode() + ']';
    }
}
