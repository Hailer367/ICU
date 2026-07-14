package e0;

import a.AbstractC0051a;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class x extends s {
    public int z;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList f2243x = new ArrayList();
    public boolean y = true;

    /* renamed from: A, reason: collision with root package name */
    public boolean f2241A = false;

    /* renamed from: B, reason: collision with root package name */
    public int f2242B = 0;

    @Override // e0.s
    public final void A(AbstractC0051a abstractC0051a) {
        this.f2232s = abstractC0051a;
        this.f2242B |= 8;
        int size = this.f2243x.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((s) this.f2243x.get(i2)).A(abstractC0051a);
        }
    }

    @Override // e0.s
    public final void B() {
        this.f2242B |= 1;
        ArrayList arrayList = this.f2243x;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((s) this.f2243x.get(i2)).B();
            }
        }
    }

    @Override // e0.s
    public final void C(A0.f fVar) {
        super.C(fVar);
        this.f2242B |= 4;
        if (this.f2243x != null) {
            for (int i2 = 0; i2 < this.f2243x.size(); i2++) {
                ((s) this.f2243x.get(i2)).C(fVar);
            }
        }
    }

    @Override // e0.s
    public final void D() {
        this.f2242B |= 2;
        int size = this.f2243x.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((s) this.f2243x.get(i2)).D();
        }
    }

    @Override // e0.s
    public final void E(long j2) {
        this.f2219d = j2;
    }

    @Override // e0.s
    public final String G(String str) {
        String G2 = super.G(str);
        for (int i2 = 0; i2 < this.f2243x.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(G2);
            sb.append("\n");
            sb.append(((s) this.f2243x.get(i2)).G(str + "  "));
            G2 = sb.toString();
        }
        return G2;
    }

    public final void H(s sVar) {
        this.f2243x.add(sVar);
        sVar.f2224i = this;
        if ((this.f2242B & 1) != 0) {
            sVar.B();
        }
        if ((this.f2242B & 2) != 0) {
            sVar.D();
        }
        if ((this.f2242B & 4) != 0) {
            sVar.C(this.f2233t);
        }
        if ((this.f2242B & 8) != 0) {
            sVar.A(this.f2232s);
        }
    }

    @Override // e0.s
    public final void b(View view) {
        for (int i2 = 0; i2 < this.f2243x.size(); i2++) {
            ((s) this.f2243x.get(i2)).b(view);
        }
        this.f2221f.add(view);
    }

    @Override // e0.s
    public final void d() {
        super.d();
        int size = this.f2243x.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((s) this.f2243x.get(i2)).d();
        }
    }

    @Override // e0.s
    public final void e(z zVar) {
        if (t(zVar.f2248b)) {
            ArrayList arrayList = this.f2243x;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                s sVar = (s) obj;
                if (sVar.t(zVar.f2248b)) {
                    sVar.e(zVar);
                    zVar.f2249c.add(sVar);
                }
            }
        }
    }

    @Override // e0.s
    public final void g(z zVar) {
        int size = this.f2243x.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((s) this.f2243x.get(i2)).g(zVar);
        }
    }

    @Override // e0.s
    public final void h(z zVar) {
        if (t(zVar.f2248b)) {
            ArrayList arrayList = this.f2243x;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                s sVar = (s) obj;
                if (sVar.t(zVar.f2248b)) {
                    sVar.h(zVar);
                    zVar.f2249c.add(sVar);
                }
            }
        }
    }

    @Override // e0.s
    /* renamed from: k */
    public final s clone() {
        x xVar = (x) super.clone();
        xVar.f2243x = new ArrayList();
        int size = this.f2243x.size();
        for (int i2 = 0; i2 < size; i2++) {
            s clone = ((s) this.f2243x.get(i2)).clone();
            xVar.f2243x.add(clone);
            clone.f2224i = xVar;
        }
        return xVar;
    }

    @Override // e0.s
    public final void m(ViewGroup viewGroup, B0.q qVar, B0.q qVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j2 = this.f2219d;
        int size = this.f2243x.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = (s) this.f2243x.get(i2);
            if (j2 > 0 && (this.y || i2 == 0)) {
                long j3 = sVar.f2219d;
                if (j3 > 0) {
                    sVar.E(j3 + j2);
                } else {
                    sVar.E(j2);
                }
            }
            sVar.m(viewGroup, qVar, qVar2, arrayList, arrayList2);
        }
    }

    @Override // e0.s
    public final void v(View view) {
        super.v(view);
        int size = this.f2243x.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((s) this.f2243x.get(i2)).v(view);
        }
    }

    @Override // e0.s
    public final void x(View view) {
        for (int i2 = 0; i2 < this.f2243x.size(); i2++) {
            ((s) this.f2243x.get(i2)).x(view);
        }
        this.f2221f.remove(view);
    }

    @Override // e0.s
    public final void y(View view) {
        super.y(view);
        int size = this.f2243x.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((s) this.f2243x.get(i2)).y(view);
        }
    }

    @Override // e0.s
    public final void z() {
        if (this.f2243x.isEmpty()) {
            F();
            n();
            return;
        }
        h hVar = new h();
        hVar.f2196b = this;
        ArrayList arrayList = this.f2243x;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((s) obj).a(hVar);
        }
        this.z = this.f2243x.size();
        if (!this.y) {
            for (int i4 = 1; i4 < this.f2243x.size(); i4++) {
                ((s) this.f2243x.get(i4 - 1)).a(new h(1, (s) this.f2243x.get(i4)));
            }
            s sVar = (s) this.f2243x.get(0);
            if (sVar != null) {
                sVar.z();
                return;
            }
            return;
        }
        ArrayList arrayList2 = this.f2243x;
        int size2 = arrayList2.size();
        while (i2 < size2) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            ((s) obj2).z();
        }
    }
}
