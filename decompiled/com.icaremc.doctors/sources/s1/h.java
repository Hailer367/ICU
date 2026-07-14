package s1;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import l1.I;

/* loaded from: classes.dex */
public abstract class h extends I {

    /* renamed from: e, reason: collision with root package name */
    public c f3619e;

    @Override // l1.AbstractC0240s
    public final void e(T0.i iVar, Runnable runnable) {
        c cVar = this.f3619e;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.f3604j;
        cVar.b(runnable, false);
    }
}
