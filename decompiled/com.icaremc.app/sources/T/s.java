package T;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f1590a;

    /* renamed from: b, reason: collision with root package name */
    public o f1591b;

    public s(int i4) {
        this.f1590a = new SparseArray(i4);
    }

    public final void a(o oVar, int i4, int i5) {
        s sVar;
        int a4 = oVar.a(i4);
        SparseArray sparseArray = this.f1590a;
        if (sparseArray == null) {
            sVar = null;
        } else {
            sVar = (s) sparseArray.get(a4);
        }
        if (sVar == null) {
            sVar = new s(1);
            sparseArray.put(oVar.a(i4), sVar);
        }
        if (i5 > i4) {
            sVar.a(oVar, i4 + 1, i5);
        } else {
            sVar.f1591b = oVar;
        }
    }
}
