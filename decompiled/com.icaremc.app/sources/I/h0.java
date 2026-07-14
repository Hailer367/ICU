package I;

import android.graphics.Rect;
import f1.AbstractC0286a;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final v0 f739a;

    /* renamed from: b, reason: collision with root package name */
    public B.c[] f740b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect[][] f741c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect[][] f742d;

    public h0() {
        this(new v0());
    }

    public final void a() {
        B.c[] cVarArr = this.f740b;
        if (cVarArr != null) {
            B.c cVar = cVarArr[0];
            B.c cVar2 = cVarArr[1];
            v0 v0Var = this.f739a;
            if (cVar2 == null) {
                cVar2 = v0Var.f788a.h(2);
            }
            if (cVar == null) {
                cVar = v0Var.f788a.h(1);
            }
            h(B.c.a(cVar, cVar2));
            B.c cVar3 = this.f740b[AbstractC0286a.w(16)];
            if (cVar3 != null) {
                g(cVar3);
            }
            B.c cVar4 = this.f740b[AbstractC0286a.w(32)];
            if (cVar4 != null) {
                e(cVar4);
            }
            B.c cVar5 = this.f740b[AbstractC0286a.w(64)];
            if (cVar5 != null) {
                i(cVar5);
            }
        }
    }

    public abstract v0 b();

    public void c(v0 v0Var) {
        for (int i4 = 1; i4 <= 512; i4 <<= 1) {
            List<Rect> e4 = v0Var.f788a.e(i4);
            int w2 = AbstractC0286a.w(i4);
            this.f741c[w2] = (Rect[]) e4.toArray(new Rect[e4.size()]);
            if (i4 != 8) {
                List<Rect> f4 = v0Var.f788a.f(i4);
                this.f742d[w2] = (Rect[]) f4.toArray(new Rect[f4.size()]);
            }
        }
    }

    public void d(int i4, B.c cVar) {
        if (this.f740b == null) {
            this.f740b = new B.c[10];
        }
        for (int i5 = 1; i5 <= 512; i5 <<= 1) {
            if ((i4 & i5) != 0) {
                this.f740b[AbstractC0286a.w(i5)] = cVar;
            }
        }
    }

    public abstract void f(B.c cVar);

    public abstract void h(B.c cVar);

    public h0(v0 v0Var) {
        this.f741c = new Rect[10];
        this.f742d = new Rect[10];
        this.f739a = v0Var;
        c(v0Var);
    }

    public void e(B.c cVar) {
    }

    public void g(B.c cVar) {
    }

    public void i(B.c cVar) {
    }
}
