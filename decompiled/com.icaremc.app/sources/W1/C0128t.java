package W1;

import b2.C0223a;
import b2.C0224b;

/* renamed from: W1.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0128t extends T1.s {

    /* renamed from: b, reason: collision with root package name */
    public static final C0127s f1965b = new C0127s(0, new C0128t(T1.q.f1624g));

    /* renamed from: a, reason: collision with root package name */
    public final T1.q f1966a;

    public C0128t(T1.q qVar) {
        this.f1966a = qVar;
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        int x3 = c0223a.x();
        int b4 = R.i.b(x3);
        if (b4 != 5 && b4 != 6) {
            if (b4 == 8) {
                c0223a.t();
                return null;
            }
            throw new RuntimeException("Expecting number, got: " + A2.i.s(x3) + "; at path " + c0223a.h());
        }
        return this.f1966a.a(c0223a);
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        c0224b.q((Number) obj);
    }
}
