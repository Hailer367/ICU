package d;

import androidx.lifecycle.AbstractC0146p;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.InterfaceC0148s;
import androidx.lifecycle.InterfaceC0150u;

/* loaded from: classes.dex */
public final class s implements InterfaceC0148s, AutoCloseable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f2151c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0146p f2152d;

    public s(o oVar, t tVar, AbstractC0146p abstractC0146p) {
        this.f2151c = oVar;
        this.f2152d = abstractC0146p;
    }

    @Override // androidx.lifecycle.InterfaceC0148s
    public final void a(InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
        EnumC0144n enumC0144n2 = EnumC0144n.ON_START;
        o oVar = this.f2151c;
        if (enumC0144n == enumC0144n2) {
            oVar.b(true);
        } else if (enumC0144n == EnumC0144n.ON_STOP) {
            oVar.b(false);
        }
        if (enumC0144n == EnumC0144n.ON_DESTROY) {
            oVar.a();
            this.f2152d.b(this);
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f2152d.b(this);
    }
}
