package r1;

/* loaded from: classes.dex */
public final class l extends j {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6026g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f6027h;

    public /* synthetic */ l(int i4, Object obj) {
        this.f6026g = i4;
        this.f6027h = obj;
    }

    @Override // r1.j
    public final void a() {
        switch (this.f6026g) {
            case 0:
                synchronized (((o) this.f6027h).f6037f) {
                    try {
                        if (((o) this.f6027h).k.get() > 0 && ((o) this.f6027h).k.decrementAndGet() > 0) {
                            ((o) this.f6027h).f6033b.o("Leaving the connection open for other ongoing calls.", new Object[0]);
                            return;
                        }
                        o oVar = (o) this.f6027h;
                        if (oVar.f6043m != null) {
                            oVar.f6033b.o("Unbind from service.", new Object[0]);
                            o oVar2 = (o) this.f6027h;
                            oVar2.f6032a.unbindService(oVar2.f6042l);
                            o oVar3 = (o) this.f6027h;
                            oVar3.f6038g = false;
                            oVar3.f6043m = null;
                            oVar3.f6042l = null;
                        }
                        ((o) this.f6027h).d();
                        return;
                    } finally {
                    }
                }
            default:
                o oVar4 = ((n) this.f6027h).f6030a;
                oVar4.f6033b.o("unlinkToDeath", new Object[0]);
                oVar4.f6043m.asBinder().unlinkToDeath(oVar4.f6041j, 0);
                oVar4.f6043m = null;
                oVar4.f6038g = false;
                return;
        }
    }
}
