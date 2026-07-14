package Z0;

import androidx.appcompat.widget.ActionMenuView;
import j.C0403K;
import n.InterfaceC0448A;
import o.C0515f;
import o.C0523j;

/* loaded from: classes.dex */
public final class D implements InterfaceC0448A {

    /* renamed from: f, reason: collision with root package name */
    public boolean f2107f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f2108g;

    public D(String str, boolean z) {
        this.f2108g = str;
        this.f2107f = z;
    }

    @Override // n.InterfaceC0448A
    public void a(n.n nVar, boolean z) {
        C0523j c0523j;
        C0403K c0403k = (C0403K) this.f2108g;
        if (this.f2107f) {
            return;
        }
        this.f2107f = true;
        ActionMenuView actionMenuView = c0403k.f4894a.f5734a.f2474f;
        if (actionMenuView != null && (c0523j = actionMenuView.f2354y) != null) {
            c0523j.c();
            C0515f c0515f = c0523j.f5619y;
            if (c0515f != null && c0515f.b()) {
                c0515f.f5369i.dismiss();
            }
        }
        c0403k.f4895b.onPanelClosed(108, nVar);
        this.f2107f = false;
    }

    public void b(boolean z) {
        if (!this.f2107f) {
            this.f2107f = true;
            h2.w wVar = (h2.w) this.f2108g;
            int i4 = wVar.f4061b - 1;
            wVar.f4061b = i4;
            boolean z3 = z | wVar.f4062c;
            wVar.f4062c = z3;
            if (i4 == 0 && !z3) {
                wVar.f4063d.Q(wVar.f4060a);
                return;
            }
            return;
        }
        throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
    }

    @Override // n.InterfaceC0448A
    public boolean c(n.n nVar) {
        ((C0403K) this.f2108g).f4895b.onMenuOpened(108, nVar);
        return true;
    }

    public D(h2.w wVar) {
        this.f2108g = wVar;
        this.f2107f = false;
    }

    public D(C0403K c0403k) {
        this.f2108g = c0403k;
    }
}
