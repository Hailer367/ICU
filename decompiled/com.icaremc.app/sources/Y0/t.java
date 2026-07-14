package Y0;

import P1.x;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import p1.C0580i;

/* loaded from: classes.dex */
public final class t extends p {

    /* renamed from: b, reason: collision with root package name */
    public final C0580i f2079b;

    public t(C0580i c0580i) {
        super(4);
        this.f2079b = c0580i;
    }

    @Override // Y0.p
    public final W0.c[] a(k kVar) {
        if (kVar.k.get(null) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // Y0.p
    public final boolean b(k kVar) {
        if (kVar.k.get(null) == null) {
            return false;
        }
        throw new ClassCastException();
    }

    @Override // Y0.p
    public final int c(k kVar) {
        if (kVar.k.get(null) == null) {
            return -1;
        }
        throw new ClassCastException();
    }

    @Override // Y0.p
    public final void d(Status status) {
        this.f2079b.c(new x(status));
    }

    @Override // Y0.p
    public final void e(Exception exc) {
        this.f2079b.c(exc);
    }

    @Override // Y0.p
    public final void g(k kVar) {
        try {
            i(kVar);
        } catch (DeadObjectException e4) {
            d(p.h(e4));
            throw e4;
        } catch (RemoteException e5) {
            d(p.h(e5));
        } catch (RuntimeException e6) {
            this.f2079b.c(e6);
        }
    }

    public final void i(k kVar) {
        if (kVar.k.remove(null) == null) {
            this.f2079b.d(Boolean.FALSE);
            return;
        }
        throw new ClassCastException();
    }

    @Override // Y0.p
    public final /* bridge */ /* synthetic */ void f(E0.a aVar, boolean z) {
    }
}
