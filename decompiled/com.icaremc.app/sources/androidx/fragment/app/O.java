package androidx.fragment.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class O implements M {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ P f2734a;

    public O(P p3) {
        this.f2734a = p3;
    }

    @Override // androidx.fragment.app.M
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        P p3 = this.f2734a;
        ArrayList arrayList3 = p3.f2753d;
        C0169a c0169a = (C0169a) arrayList3.get(arrayList3.size() - 1);
        p3.f2757h = c0169a;
        ArrayList arrayList4 = c0169a.f2816a;
        int size = arrayList4.size();
        int i4 = 0;
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList4.get(i5);
            i5++;
            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = ((Y) obj).f2808b;
            if (abstractComponentCallbacksC0187t != null) {
                abstractComponentCallbacksC0187t.f2935r = true;
            }
        }
        boolean R3 = p3.R(arrayList, arrayList2, -1, 0);
        if (!p3.f2761m.isEmpty() && arrayList.size() > 0) {
            ((Boolean) arrayList2.get(arrayList.size() - 1)).getClass();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size2 = arrayList.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = arrayList.get(i6);
                i6++;
                linkedHashSet.addAll(P.E((C0169a) obj2));
            }
            ArrayList arrayList5 = p3.f2761m;
            int size3 = arrayList5.size();
            while (i4 < size3) {
                Object obj3 = arrayList5.get(i4);
                i4++;
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
        return R3;
    }
}
