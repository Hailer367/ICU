package j3;

import g3.r;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class i extends r {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f5105e;

    public i(long j4, i iVar, int i4) {
        super(j4, iVar, i4);
        this.f5105e = new AtomicReferenceArray(h.f5104f);
    }

    @Override // g3.r
    public final int f() {
        return h.f5104f;
    }

    @Override // g3.r
    public final void g(int i4, K2.i iVar) {
        this.f5105e.set(i4, h.f5103e);
        h();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f3807c + ", hashCode=" + hashCode() + ']';
    }
}
