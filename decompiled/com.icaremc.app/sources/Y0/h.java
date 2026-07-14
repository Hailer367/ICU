package Y0;

import java.util.ArrayDeque;
import p1.AbstractC0579h;
import p1.InterfaceC0584m;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public Object f2043a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2044b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2045c;

    public h(h hVar, W0.c[] cVarArr, boolean z) {
        this.f2045c = hVar;
        this.f2043a = cVarArr;
        boolean z3 = false;
        if (cVarArr != null && z) {
            z3 = true;
        }
        this.f2044b = z3;
    }

    public void a(double d4, double d5) {
        double[] dArr = (double[]) this.f2045c;
        double d6 = 1.0d;
        if (!this.f2044b) {
            d6 = 1.0d / (((dArr[7] * d5) + (dArr[3] * d4)) + dArr[15]);
        }
        double d7 = ((dArr[4] * d5) + (dArr[0] * d4) + dArr[12]) * d6;
        double d8 = ((dArr[5] * d5) + (dArr[1] * d4) + dArr[13]) * d6;
        double[] dArr2 = (double[]) this.f2043a;
        if (d7 < dArr2[0]) {
            dArr2[0] = d7;
        } else if (d7 > dArr2[1]) {
            dArr2[1] = d7;
        }
        if (d8 < dArr2[2]) {
            dArr2[2] = d8;
        } else if (d8 > dArr2[3]) {
            dArr2[3] = d8;
        }
    }

    public void b(InterfaceC0584m interfaceC0584m) {
        synchronized (this.f2045c) {
            try {
                if (((ArrayDeque) this.f2043a) == null) {
                    this.f2043a = new ArrayDeque();
                }
                ((ArrayDeque) this.f2043a).add(interfaceC0584m);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(AbstractC0579h abstractC0579h) {
        InterfaceC0584m interfaceC0584m;
        synchronized (this.f2045c) {
            if (((ArrayDeque) this.f2043a) != null && !this.f2044b) {
                this.f2044b = true;
                while (true) {
                    synchronized (this.f2045c) {
                        try {
                            interfaceC0584m = (InterfaceC0584m) ((ArrayDeque) this.f2043a).poll();
                            if (interfaceC0584m == null) {
                                this.f2044b = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    interfaceC0584m.a(abstractC0579h);
                }
            }
        }
    }
}
