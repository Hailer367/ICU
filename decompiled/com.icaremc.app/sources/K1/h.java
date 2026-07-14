package K1;

import p1.C0580i;

/* loaded from: classes.dex */
public final class h implements j {

    /* renamed from: a, reason: collision with root package name */
    public final C0580i f930a;

    public h(C0580i c0580i) {
        this.f930a = c0580i;
    }

    @Override // K1.j
    public final boolean a(L1.b bVar) {
        int i4 = bVar.f1010b;
        if (i4 == 3 || i4 == 4 || i4 == 5) {
            this.f930a.d(bVar.f1009a);
            return true;
        }
        return false;
    }

    @Override // K1.j
    public final boolean b(Exception exc) {
        return false;
    }
}
