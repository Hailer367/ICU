package a0;

import java.util.ArrayList;

/* renamed from: a0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0061c extends t {

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f939e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f940f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f941g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f942h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f943i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f944j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f945k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f946l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f947m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f948n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f949o;

    public static void c(ArrayList arrayList) {
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        arrayList.get(size).getClass();
        throw new ClassCastException();
    }

    @Override // a0.t
    public final void a() {
        ArrayList arrayList = this.f943i;
        ArrayList arrayList2 = this.f944j;
        ArrayList arrayList3 = this.f940f;
        ArrayList arrayList4 = this.f945k;
        ArrayList arrayList5 = this.f942h;
        ArrayList arrayList6 = this.f939e;
        ArrayList arrayList7 = this.f941g;
        int size = arrayList7.size() - 1;
        if (size < 0) {
            for (int size2 = arrayList6.size() - 1; size2 >= 0; size2--) {
                if (arrayList6.get(size2) == null) {
                    if (this.f1000a == null) {
                        arrayList6.remove(size2);
                    } else {
                        throw null;
                    }
                } else {
                    throw new ClassCastException();
                }
            }
            int size3 = arrayList3.size() - 1;
            if (size3 < 0) {
                int size4 = arrayList5.size() - 1;
                if (size4 < 0) {
                    arrayList5.clear();
                    if (!b()) {
                        return;
                    }
                    for (int size5 = arrayList2.size() - 1; size5 >= 0; size5--) {
                        ArrayList arrayList8 = (ArrayList) arrayList2.get(size5);
                        int size6 = arrayList8.size() - 1;
                        if (size6 >= 0) {
                            O.a.l(arrayList8.get(size6));
                            throw null;
                        }
                    }
                    for (int size7 = arrayList.size() - 1; size7 >= 0; size7--) {
                        ArrayList arrayList9 = (ArrayList) arrayList.get(size7);
                        int size8 = arrayList9.size() - 1;
                        if (size8 >= 0) {
                            arrayList9.get(size8).getClass();
                            throw new ClassCastException();
                        }
                    }
                    for (int size9 = arrayList4.size() - 1; size9 >= 0; size9--) {
                        ArrayList arrayList10 = (ArrayList) arrayList4.get(size9);
                        int size10 = arrayList10.size() - 1;
                        if (size10 >= 0) {
                            O.a.l(arrayList10.get(size10));
                            throw null;
                        }
                    }
                    c(this.f948n);
                    c(this.f947m);
                    c(this.f946l);
                    c(this.f949o);
                    ArrayList arrayList11 = this.f1001b;
                    if (arrayList11.size() <= 0) {
                        arrayList11.clear();
                        return;
                    } else {
                        arrayList11.get(0).getClass();
                        throw new ClassCastException();
                    }
                }
                O.a.l(arrayList5.get(size4));
                throw null;
            }
            arrayList3.get(size3).getClass();
            throw new ClassCastException();
        }
        O.a.l(arrayList7.get(size));
        throw null;
    }

    @Override // a0.t
    public final boolean b() {
        if (this.f940f.isEmpty() && this.f942h.isEmpty() && this.f941g.isEmpty() && this.f939e.isEmpty() && this.f947m.isEmpty() && this.f948n.isEmpty() && this.f946l.isEmpty() && this.f949o.isEmpty() && this.f944j.isEmpty() && this.f943i.isEmpty() && this.f945k.isEmpty()) {
            return false;
        }
        return true;
    }
}
