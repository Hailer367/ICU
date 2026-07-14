package androidx.fragment.app;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

/* renamed from: androidx.fragment.app.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0117l implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1673c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1674d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1675e;

    public /* synthetic */ RunnableC0117l(z0 z0Var, View view, Rect rect) {
        this.f1674d = view;
        this.f1675e = rect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1673c) {
            case 0:
                E0 operation = (E0) this.f1674d;
                C0119n this$0 = (C0119n) this.f1675e;
                kotlin.jvm.internal.h.e(operation, "$operation");
                kotlin.jvm.internal.h.e(this$0, "this$0");
                if (h0.K(2)) {
                    Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
                }
                operation.c(this$0);
                return;
            default:
                z0.g((View) this.f1674d, (Rect) this.f1675e);
                return;
        }
    }

    public /* synthetic */ RunnableC0117l(E0 e02, C0119n c0119n) {
        this.f1674d = e02;
        this.f1675e = c0119n;
    }
}
