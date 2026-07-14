package m1;

import T0.i;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.h;
import l1.AbstractC0240s;
import l1.C;
import l1.C0241t;
import l1.InterfaceC0247z;
import l1.O;
import q1.n;
import s1.e;

/* loaded from: classes.dex */
public final class c extends AbstractC0240s implements InterfaceC0247z {

    /* renamed from: e, reason: collision with root package name */
    public final Handler f3283e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3284f;

    /* renamed from: g, reason: collision with root package name */
    public final c f3285g;

    public c(Handler handler, boolean z) {
        c cVar;
        this.f3283e = handler;
        this.f3284f = z;
        if (z) {
            cVar = this;
        } else {
            cVar = new c(handler, true);
        }
        this.f3285g = cVar;
    }

    @Override // l1.AbstractC0240s
    public final void e(i iVar, Runnable runnable) {
        if (!this.f3283e.post(runnable)) {
            CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
            O o2 = (O) iVar.k(C0241t.f3012d);
            if (o2 != null) {
                o2.b(cancellationException);
            }
            e eVar = C.f2950a;
            s1.d.f3615e.e(iVar, runnable);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.f3283e == this.f3283e && cVar.f3284f == this.f3284f) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // l1.AbstractC0240s
    public final boolean f(i iVar) {
        if (this.f3284f && h.a(Looper.myLooper(), this.f3283e.getLooper())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2;
        int identityHashCode = System.identityHashCode(this.f3283e);
        if (this.f3284f) {
            i2 = 1231;
        } else {
            i2 = 1237;
        }
        return identityHashCode ^ i2;
    }

    @Override // l1.AbstractC0240s
    public final String toString() {
        c cVar;
        String str;
        e eVar = C.f2950a;
        c cVar2 = n.f3538a;
        if (this == cVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = cVar2.f3285g;
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
            String handler = this.f3283e.toString();
            if (this.f3284f) {
                return O.a.f(handler, ".immediate");
            }
            return handler;
        }
        return str;
    }
}
