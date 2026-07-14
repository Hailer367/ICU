package n;

import j.O;

/* renamed from: n.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0456f implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0457g f5252f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q f5253g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n f5254h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ O f5255i;

    public RunnableC0456f(O o3, C0457g c0457g, q qVar, n nVar) {
        this.f5255i = o3;
        this.f5252f = c0457g;
        this.f5253g = qVar;
        this.f5254h = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewOnKeyListenerC0458h viewOnKeyListenerC0458h = (ViewOnKeyListenerC0458h) this.f5255i.f4911g;
        C0457g c0457g = this.f5252f;
        if (c0457g != null) {
            viewOnKeyListenerC0458h.f5263E = true;
            c0457g.f5257b.c(false);
            viewOnKeyListenerC0458h.f5263E = false;
        }
        q qVar = this.f5253g;
        if (qVar.isEnabled() && qVar.hasSubMenu()) {
            this.f5254h.q(qVar, null, 4);
        }
    }
}
