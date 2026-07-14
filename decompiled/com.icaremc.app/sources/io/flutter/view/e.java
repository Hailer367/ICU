package io.flutter.view;

import android.view.accessibility.AccessibilityManager;
import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: classes.dex */
public final class e implements AccessibilityManager.AccessibilityStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f4424a;

    public e(j jVar) {
        this.f4424a = jVar;
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        j jVar = this.f4424a;
        A2.t tVar = jVar.f4510b;
        if (!jVar.f4528u) {
            boolean z3 = true;
            if (z) {
                ((FlutterJNI) tVar.f100h).setSemanticsEnabled(true);
            } else {
                jVar.j(false);
                ((FlutterJNI) tVar.f100h).setSemanticsEnabled(false);
            }
            A2.q qVar = jVar.f4526s;
            if (qVar != null) {
                boolean isTouchExplorationEnabled = jVar.f4511c.isTouchExplorationEnabled();
                h2.p pVar = (h2.p) qVar.f93g;
                if (!pVar.f4031o.f4107b.f4233a.getIsSoftwareRenderingEnabled()) {
                    if (z || isTouchExplorationEnabled) {
                        z3 = false;
                    }
                    pVar.setWillNotDraw(z3);
                    return;
                }
                pVar.setWillNotDraw(false);
            }
        }
    }
}
