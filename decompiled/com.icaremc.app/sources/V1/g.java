package V1;

import a2.C0143a;
import b2.C0223a;
import b2.C0224b;

/* loaded from: classes.dex */
public final class g extends T1.s {

    /* renamed from: a, reason: collision with root package name */
    public volatile T1.s f1730a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1731b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f1732c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ T1.e f1733d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0143a f1734e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f1735f;

    public g(h hVar, boolean z, boolean z3, T1.e eVar, C0143a c0143a) {
        this.f1735f = hVar;
        this.f1731b = z;
        this.f1732c = z3;
        this.f1733d = eVar;
        this.f1734e = c0143a;
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (this.f1731b) {
            c0223a.D();
            return null;
        }
        T1.s sVar = this.f1730a;
        if (sVar == null) {
            sVar = this.f1733d.d(this.f1735f, this.f1734e);
            this.f1730a = sVar;
        }
        return sVar.b(c0223a);
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        if (this.f1732c) {
            c0224b.i();
            return;
        }
        T1.s sVar = this.f1730a;
        if (sVar == null) {
            sVar = this.f1733d.d(this.f1735f, this.f1734e);
            this.f1730a = sVar;
        }
        sVar.c(c0224b, obj);
    }
}
