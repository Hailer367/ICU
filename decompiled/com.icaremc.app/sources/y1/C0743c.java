package y1;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import n.p;

/* renamed from: y1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0743c implements g {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6564f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f f6565g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Runnable f6566h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f6567i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f6568j;
    public final /* synthetic */ TimeUnit k;

    public /* synthetic */ C0743c(f fVar, Runnable runnable, long j4, long j5, TimeUnit timeUnit, int i4) {
        this.f6564f = i4;
        this.f6565g = fVar;
        this.f6566h = runnable;
        this.f6567i = j4;
        this.f6568j = j5;
        this.k = timeUnit;
    }

    @Override // y1.g
    public final ScheduledFuture a(p pVar) {
        switch (this.f6564f) {
            case 0:
                f fVar = this.f6565g;
                return fVar.f6577g.scheduleAtFixedRate(new d(fVar, this.f6566h, pVar, 0), this.f6567i, this.f6568j, this.k);
            default:
                f fVar2 = this.f6565g;
                return fVar2.f6577g.scheduleWithFixedDelay(new d(fVar2, this.f6566h, pVar, 2), this.f6567i, this.f6568j, this.k);
        }
    }
}
