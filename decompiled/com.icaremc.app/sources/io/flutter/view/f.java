package io.flutter.view;

import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public final class f implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AccessibilityManager f4425a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f4426b;

    public f(j jVar, AccessibilityManager accessibilityManager) {
        this.f4426b = jVar;
        this.f4425a = accessibilityManager;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        j jVar = this.f4426b;
        if (!jVar.f4528u) {
            boolean z3 = false;
            if (!z) {
                jVar.j(false);
                i iVar = jVar.f4523p;
                if (iVar != null) {
                    jVar.h(iVar.f4483b, 256);
                    jVar.f4523p = null;
                }
            }
            A2.q qVar = jVar.f4526s;
            if (qVar != null) {
                boolean isEnabled = this.f4425a.isEnabled();
                h2.p pVar = (h2.p) qVar.f93g;
                if (!pVar.f4031o.f4107b.f4233a.getIsSoftwareRenderingEnabled()) {
                    if (!isEnabled && !z) {
                        z3 = true;
                    }
                    pVar.setWillNotDraw(z3);
                    return;
                }
                pVar.setWillNotDraw(false);
            }
        }
    }
}
