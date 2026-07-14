package i3;

import b3.H;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes.dex */
public abstract class h extends H {

    /* renamed from: h, reason: collision with root package name */
    public c f4176h;

    @Override // b3.AbstractC0242q
    public final void d(K2.i iVar, Runnable runnable) {
        c cVar = this.f4176h;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.f4162m;
        cVar.b(runnable, false);
    }
}
