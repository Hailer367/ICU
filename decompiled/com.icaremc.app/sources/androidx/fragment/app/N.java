package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class N implements M {

    /* renamed from: a, reason: collision with root package name */
    public final int f2732a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ P f2733b;

    public N(P p3, int i4) {
        this.f2733b = p3;
        this.f2732a = i4;
    }

    @Override // androidx.fragment.app.M
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        P p3 = this.f2733b;
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = p3.f2773y;
        int i4 = this.f2732a;
        if (abstractComponentCallbacksC0187t != null && i4 < 0 && abstractComponentCallbacksC0187t.c().Q()) {
            return false;
        }
        return p3.R(arrayList, arrayList2, i4, 1);
    }
}
