package l1;

/* renamed from: l1.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0240s extends T0.a implements T0.f {

    /* renamed from: d, reason: collision with root package name */
    public static final r f3010d = new r(T0.e.f773c, new Object());

    public AbstractC0240s() {
        super(T0.e.f773c);
    }

    public abstract void e(T0.i iVar, Runnable runnable);

    public boolean f(T0.i iVar) {
        return !(this instanceof g0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (((T0.g) r3.f3008c.invoke(r2)) != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        return T0.j.f774c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        if (T0.e.f773c == r3) goto L15;
     */
    @Override // T0.a, T0.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T0.i g(T0.h r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.h.e(r3, r0)
            boolean r0 = r3 instanceof l1.r
            if (r0 == 0) goto L20
            l1.r r3 = (l1.r) r3
            T0.h r0 = r2.f769c
            if (r0 == r3) goto L15
            T0.h r1 = r3.f3009d
            if (r1 != r0) goto L14
            goto L15
        L14:
            return r2
        L15:
            c1.l r3 = r3.f3008c
            java.lang.Object r3 = r3.invoke(r2)
            T0.g r3 = (T0.g) r3
            if (r3 == 0) goto L27
            goto L24
        L20:
            T0.e r0 = T0.e.f773c
            if (r0 != r3) goto L27
        L24:
            T0.j r3 = T0.j.f774c
            return r3
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.AbstractC0240s.g(T0.h):T0.i");
    }

    public AbstractC0240s h(int i2) {
        q1.a.a(i2);
        return new q1.g(this, i2);
    }

    @Override // T0.a, T0.i
    public final T0.g k(T0.h key) {
        T0.g gVar;
        kotlin.jvm.internal.h.e(key, "key");
        if (key instanceof r) {
            r rVar = (r) key;
            T0.h hVar = this.f769c;
            if ((hVar == rVar || rVar.f3009d == hVar) && (gVar = (T0.g) rVar.f3008c.invoke(this)) != null) {
                return gVar;
            }
        } else if (T0.e.f773c == key) {
            return this;
        }
        return null;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0244w.b(this);
    }
}
