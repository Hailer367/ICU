package Y0;

import P1.x;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.Map;
import p1.C0580i;

/* loaded from: classes.dex */
public final class s extends p {

    /* renamed from: b, reason: collision with root package name */
    public final h f2076b;

    /* renamed from: c, reason: collision with root package name */
    public final C0580i f2077c;

    /* renamed from: d, reason: collision with root package name */
    public final W0.g f2078d;

    public s(h hVar, C0580i c0580i, W0.g gVar) {
        super(2);
        this.f2077c = c0580i;
        this.f2076b = hVar;
        this.f2078d = gVar;
        if (!hVar.f2044b) {
        } else {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // Y0.p
    public final W0.c[] a(k kVar) {
        return (W0.c[]) this.f2076b.f2043a;
    }

    @Override // Y0.p
    public final boolean b(k kVar) {
        return this.f2076b.f2044b;
    }

    @Override // Y0.p
    public final int c(k kVar) {
        return 0;
    }

    @Override // Y0.p
    public final void d(Status status) {
        x xVar;
        this.f2078d.getClass();
        if (status.f3368h != null) {
            xVar = new x(status);
        } else {
            xVar = new x(status);
        }
        this.f2077c.c(xVar);
    }

    @Override // Y0.p
    public final void e(Exception exc) {
        this.f2077c.c(exc);
    }

    @Override // Y0.p
    public final void f(E0.a aVar, boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        Map map = (Map) aVar.f460h;
        C0580i c0580i = this.f2077c;
        map.put(c0580i, valueOf);
        c0580i.f5821a.h(new E0.a(aVar, c0580i));
    }

    @Override // Y0.p
    public final void g(k kVar) {
        C0580i c0580i = this.f2077c;
        try {
            h hVar = this.f2076b;
            ((g) ((h) hVar.f2045c).f2045c).accept(kVar.f2048g, c0580i);
        } catch (DeadObjectException e4) {
            throw e4;
        } catch (RemoteException e5) {
            d(p.h(e5));
        } catch (RuntimeException e6) {
            c0580i.c(e6);
        }
    }
}
