package O0;

import D2.J;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Objects;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ l f1276f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ I0.j f1277g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f1278h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Runnable f1279i;

    public /* synthetic */ f(l lVar, I0.j jVar, int i4, Runnable runnable) {
        this.f1276f = lVar;
        this.f1277g = jVar;
        this.f1278h = i4;
        this.f1279i = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final I0.j jVar = this.f1277g;
        final int i4 = this.f1278h;
        Runnable runnable = this.f1279i;
        final l lVar = this.f1276f;
        Q0.c cVar = lVar.f1302f;
        try {
            try {
                P0.d dVar = lVar.f1299c;
                Objects.requireNonNull(dVar);
                ((P0.h) cVar).f(new J(8, dVar));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) lVar.f1297a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    lVar.a(jVar, i4);
                } else {
                    ((P0.h) cVar).f(new Q0.b() { // from class: O0.g
                        @Override // Q0.b
                        public final Object d() {
                            l.this.f1300d.a(jVar, i4 + 1, false);
                            return null;
                        }
                    });
                }
                runnable.run();
            } catch (Q0.a unused) {
                lVar.f1300d.a(jVar, i4 + 1, false);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }
}
