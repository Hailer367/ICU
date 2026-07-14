package b3;

import D2.C0037p;

/* renamed from: b3.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0242q extends K2.a implements K2.f {

    /* renamed from: g, reason: collision with root package name */
    public static final C0241p f3293g = new C0241p(K2.e.f941f, new C0037p(4));

    public AbstractC0242q() {
        super(K2.e.f941f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (((K2.g) r3.f3291f.f(r2)) != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        return K2.j.f942f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        if (K2.e.f941f == r3) goto L15;
     */
    @Override // K2.a, K2.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final K2.i c(K2.h r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            T2.h.e(r3, r0)
            boolean r0 = r3 instanceof b3.C0241p
            if (r0 == 0) goto L20
            b3.p r3 = (b3.C0241p) r3
            K2.h r0 = r2.f937f
            if (r0 == r3) goto L15
            K2.h r1 = r3.f3292g
            if (r1 != r0) goto L14
            goto L15
        L14:
            return r2
        L15:
            S2.l r3 = r3.f3291f
            java.lang.Object r3 = r3.f(r2)
            K2.g r3 = (K2.g) r3
            if (r3 == 0) goto L27
            goto L24
        L20:
            K2.e r0 = K2.e.f941f
            if (r0 != r3) goto L27
        L24:
            K2.j r3 = K2.j.f942f
            return r3
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.AbstractC0242q.c(K2.h):K2.i");
    }

    public abstract void d(K2.i iVar, Runnable runnable);

    @Override // K2.a, K2.i
    public final K2.g e(K2.h hVar) {
        K2.g gVar;
        T2.h.e(hVar, "key");
        if (hVar instanceof C0241p) {
            C0241p c0241p = (C0241p) hVar;
            K2.h hVar2 = this.f937f;
            if ((hVar2 == c0241p || c0241p.f3292g == hVar2) && (gVar = (K2.g) c0241p.f3291f.f(this)) != null) {
                return gVar;
            }
        } else if (K2.e.f941f == hVar) {
            return this;
        }
        return null;
    }

    public boolean f(K2.i iVar) {
        return !(this instanceof f0);
    }

    public AbstractC0242q g(int i4) {
        g3.a.a(i4);
        return new g3.g(this, i4);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0245u.b(this);
    }
}
