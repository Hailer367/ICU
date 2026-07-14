package n;

import android.view.ActionProvider;
import android.view.View;

/* loaded from: classes.dex */
public final class r implements ActionProvider.VisibilityListener {

    /* renamed from: a, reason: collision with root package name */
    public final ActionProvider f5350a;

    /* renamed from: b, reason: collision with root package name */
    public p f5351b;

    public r(v vVar, ActionProvider actionProvider) {
        this.f5350a = actionProvider;
    }

    public final View a(q qVar) {
        return this.f5350a.onCreateActionView(qVar);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z) {
        p pVar = this.f5351b;
        if (pVar != null) {
            n nVar = ((q) pVar.f5322g).f5338n;
            nVar.f5301h = true;
            nVar.p(true);
        }
    }
}
