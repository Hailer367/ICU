package B0;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Objects;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f93c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ v0.j f94d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f95e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Runnable f96f;

    public /* synthetic */ g(n nVar, v0.j jVar, int i2, Runnable runnable) {
        this.f93c = nVar;
        this.f94d = jVar;
        this.f95e = i2;
        this.f96f = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final v0.j jVar = this.f94d;
        final int i2 = this.f95e;
        Runnable runnable = this.f96f;
        final n nVar = this.f93c;
        D0.c cVar = nVar.f120f;
        try {
            try {
                C0.d dVar = nVar.f117c;
                Objects.requireNonNull(dVar);
                ((C0.j) cVar).f(new h(1, dVar));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) nVar.f115a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    nVar.a(jVar, i2);
                } else {
                    ((C0.j) cVar).f(new D0.b() { // from class: B0.i
                        @Override // D0.b
                        public final Object a() {
                            n.this.f118d.a(jVar, i2 + 1, false);
                            return null;
                        }
                    });
                }
                runnable.run();
            } catch (D0.a unused) {
                nVar.f118d.a(jVar, i2 + 1, false);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }
}
