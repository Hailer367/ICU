package c3;

import K2.i;
import T2.h;
import android.os.Handler;
import android.os.Looper;
import b3.A;
import b3.AbstractC0242q;
import b3.InterfaceC0248x;
import b3.N;
import b3.r;
import g3.n;
import i3.e;
import java.util.concurrent.CancellationException;
import r2.k;

/* loaded from: classes.dex */
public final class c extends AbstractC0242q implements InterfaceC0248x {

    /* renamed from: h, reason: collision with root package name */
    public final Handler f3326h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3327i;

    /* renamed from: j, reason: collision with root package name */
    public final c f3328j;

    public c(Handler handler, boolean z) {
        c cVar;
        this.f3326h = handler;
        this.f3327i = z;
        if (z) {
            cVar = this;
        } else {
            cVar = new c(handler, true);
        }
        this.f3328j = cVar;
    }

    @Override // b3.AbstractC0242q
    public final void d(i iVar, Runnable runnable) {
        if (!this.f3326h.post(runnable)) {
            CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
            N n3 = (N) iVar.e(r.f3295g);
            if (n3 != null) {
                n3.b(cancellationException);
            }
            e eVar = A.f3236a;
            i3.d.f4172h.d(iVar, runnable);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.f3326h == this.f3326h && cVar.f3327i == this.f3327i) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // b3.AbstractC0242q
    public final boolean f(i iVar) {
        if (this.f3327i && h.a(Looper.myLooper(), this.f3326h.getLooper())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i4;
        int identityHashCode = System.identityHashCode(this.f3326h);
        if (this.f3327i) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return identityHashCode ^ i4;
    }

    @Override // b3.AbstractC0242q
    public final String toString() {
        c cVar;
        String str;
        e eVar = A.f3236a;
        c cVar2 = n.f3803a;
        if (this == cVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = cVar2.f3328j;
            } catch (UnsupportedOperationException unused) {
                cVar = null;
            }
            if (this == cVar) {
                str = "Dispatchers.Main.immediate";
            } else {
                str = null;
            }
        }
        if (str == null) {
            String handler = this.f3326h.toString();
            if (this.f3327i) {
                return k.a(handler, ".immediate");
            }
            return handler;
        }
        return str;
    }
}
