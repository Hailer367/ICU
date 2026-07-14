package h0;

import java.util.ArrayList;

/* renamed from: h0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0315c extends AbstractC0332t {

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f3863e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f3864f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f3865g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f3866h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f3867i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f3868j;
    public ArrayList k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f3869l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f3870m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f3871n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f3872o;

    public static void c(ArrayList arrayList) {
        int size = arrayList.size() - 1;
        if (size < 0) {
        } else {
            throw A2.i.f(arrayList, size);
        }
    }

    @Override // h0.AbstractC0332t
    public final void a() {
        ArrayList arrayList = this.f3867i;
        ArrayList arrayList2 = this.f3868j;
        ArrayList arrayList3 = this.f3864f;
        ArrayList arrayList4 = this.k;
        ArrayList arrayList5 = this.f3866h;
        ArrayList arrayList6 = this.f3863e;
        ArrayList arrayList7 = this.f3865g;
        int size = arrayList7.size() - 1;
        if (size < 0) {
            for (int size2 = arrayList6.size() - 1; size2 >= 0; size2--) {
                if (arrayList6.get(size2) == null) {
                    if (this.f3926a == null) {
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
                            A2.i.o(arrayList8.get(size6));
                            throw null;
                        }
                    }
                    for (int size7 = arrayList.size() - 1; size7 >= 0; size7--) {
                        ArrayList arrayList9 = (ArrayList) arrayList.get(size7);
                        int size8 = arrayList9.size() - 1;
                        if (size8 >= 0) {
                            throw A2.i.f(arrayList9, size8);
                        }
                    }
                    for (int size9 = arrayList4.size() - 1; size9 >= 0; size9--) {
                        ArrayList arrayList10 = (ArrayList) arrayList4.get(size9);
                        int size10 = arrayList10.size() - 1;
                        if (size10 >= 0) {
                            A2.i.o(arrayList10.get(size10));
                            throw null;
                        }
                    }
                    c(this.f3871n);
                    c(this.f3870m);
                    c(this.f3869l);
                    c(this.f3872o);
                    ArrayList arrayList11 = this.f3927b;
                    if (arrayList11.size() <= 0) {
                        arrayList11.clear();
                        return;
                    }
                    throw A2.i.f(arrayList11, 0);
                }
                A2.i.o(arrayList5.get(size4));
                throw null;
            }
            throw A2.i.f(arrayList3, size3);
        }
        A2.i.o(arrayList7.get(size));
        throw null;
    }

    @Override // h0.AbstractC0332t
    public final boolean b() {
        if (this.f3864f.isEmpty() && this.f3866h.isEmpty() && this.f3865g.isEmpty() && this.f3863e.isEmpty() && this.f3870m.isEmpty() && this.f3871n.isEmpty() && this.f3869l.isEmpty() && this.f3872o.isEmpty() && this.f3868j.isEmpty() && this.f3867i.isEmpty() && this.k.isEmpty()) {
            return false;
        }
        return true;
    }
}
