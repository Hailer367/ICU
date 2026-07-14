package androidx.fragment.app;

import java.util.ArrayList;

/* renamed from: androidx.fragment.app.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0110f0 implements InterfaceC0108e0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f1609a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f1610b;

    public C0110f0(h0 h0Var, int i2) {
        this.f1610b = h0Var;
        this.f1609a = i2;
    }

    @Override // androidx.fragment.app.InterfaceC0108e0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        h0 h0Var = this.f1610b;
        H h2 = h0Var.y;
        int i2 = this.f1609a;
        if (h2 != null && i2 < 0 && h2.getChildFragmentManager().R(-1, 0)) {
            return false;
        }
        return h0Var.S(arrayList, arrayList2, i2, 1);
    }
}
