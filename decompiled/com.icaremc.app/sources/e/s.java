package e;

import androidx.lifecycle.AbstractC0208o;
import androidx.lifecycle.EnumC0206m;
import androidx.lifecycle.InterfaceC0212t;

/* loaded from: classes.dex */
public final class s implements androidx.lifecycle.r, AutoCloseable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p f3582f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractC0208o f3583g;

    public s(p pVar, t tVar, AbstractC0208o abstractC0208o) {
        this.f3582f = pVar;
        this.f3583g = abstractC0208o;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f3583g.b(this);
    }

    @Override // androidx.lifecycle.r
    public final void d(InterfaceC0212t interfaceC0212t, EnumC0206m enumC0206m) {
        EnumC0206m enumC0206m2 = EnumC0206m.ON_START;
        p pVar = this.f3582f;
        if (enumC0206m == enumC0206m2) {
            pVar.c(true);
        } else if (enumC0206m == EnumC0206m.ON_STOP) {
            pVar.c(false);
        }
        if (enumC0206m == EnumC0206m.ON_DESTROY) {
            pVar.b();
            this.f3583g.b(this);
        }
    }
}
