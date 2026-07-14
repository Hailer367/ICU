package androidx.fragment.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* renamed from: androidx.fragment.app.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0112g0 implements InterfaceC0108e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f1616a;

    public C0112g0(h0 h0Var) {
        this.f1616a = h0Var;
    }

    @Override // androidx.fragment.app.InterfaceC0108e0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        h0 h0Var = this.f1616a;
        ArrayList arrayList3 = h0Var.f1636d;
        C0099a c0099a = (C0099a) arrayList3.get(arrayList3.size() - 1);
        h0Var.f1640h = c0099a;
        ArrayList arrayList4 = c0099a.f1735a;
        int size = arrayList4.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList4.get(i3);
            i3++;
            H h2 = ((q0) obj).f1726b;
            if (h2 != null) {
                h2.mTransitioning = true;
            }
        }
        boolean S2 = h0Var.S(arrayList, arrayList2, -1, 0);
        if (!h0Var.f1645m.isEmpty() && arrayList.size() > 0) {
            ((Boolean) arrayList2.get(arrayList.size() - 1)).getClass();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size2 = arrayList.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayList.get(i4);
                i4++;
                linkedHashSet.addAll(h0.F((C0099a) obj2));
            }
            ArrayList arrayList5 = h0Var.f1645m;
            int size3 = arrayList5.size();
            while (i2 < size3) {
                Object obj3 = arrayList5.get(i2);
                i2++;
                if (obj3 == null) {
                    Iterator it = linkedHashSet.iterator();
                    if (it.hasNext()) {
                        throw null;
                    }
                } else {
                    throw new ClassCastException();
                }
            }
        }
        return S2;
    }
}
