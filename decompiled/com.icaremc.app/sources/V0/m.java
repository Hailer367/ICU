package V0;

import P1.x;
import android.os.Bundle;
import android.util.Log;
import p1.C0580i;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final int f1707a;

    /* renamed from: b, reason: collision with root package name */
    public final C0580i f1708b = new C0580i();

    /* renamed from: c, reason: collision with root package name */
    public final int f1709c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f1710d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1711e;

    public m(int i4, int i5, Bundle bundle, int i6) {
        this.f1711e = i6;
        this.f1707a = i4;
        this.f1709c = i5;
        this.f1710d = bundle;
    }

    public final boolean a() {
        switch (this.f1711e) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public final void b(x xVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + xVar.toString());
        }
        this.f1708b.a(xVar);
    }

    public final void c(Bundle bundle) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(bundle));
        }
        this.f1708b.b(bundle);
    }

    public final String toString() {
        return "Request { what=" + this.f1709c + " id=" + this.f1707a + " oneWay=" + a() + "}";
    }
}
