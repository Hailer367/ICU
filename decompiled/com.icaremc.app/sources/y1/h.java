package y1;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import n.p;
import v.AbstractFutureC0676h;
import v.C0669a;

/* loaded from: classes.dex */
public final class h extends AbstractFutureC0676h implements ScheduledFuture {

    /* renamed from: m, reason: collision with root package name */
    public final ScheduledFuture f6578m;

    public h(g gVar) {
        this.f6578m = gVar.a(new p(20, this));
    }

    @Override // v.AbstractFutureC0676h
    public final void b() {
        boolean z;
        ScheduledFuture scheduledFuture = this.f6578m;
        Object obj = this.f6256f;
        if ((obj instanceof C0669a) && ((C0669a) obj).f6240a) {
            z = true;
        } else {
            z = false;
        }
        scheduledFuture.cancel(z);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.f6578m.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f6578m.getDelay(timeUnit);
    }
}
