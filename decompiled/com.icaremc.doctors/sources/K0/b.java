package K0;

import Q0.j;
import com.google.android.play.core.appupdate.AppUpdateManager;
import d.r;
import d.t;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements c1.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f573c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f574d;

    public /* synthetic */ b(int i2, Object obj) {
        this.f573c = i2;
        this.f574d = obj;
    }

    @Override // c1.a
    public final Object invoke() {
        switch (this.f573c) {
            case 0:
                AppUpdateManager appUpdateManager = ((h) this.f574d).f593k;
                if (appUpdateManager != null) {
                    appUpdateManager.completeUpdate();
                }
                return j.f722a;
            default:
                return new r((t) this.f574d);
        }
    }
}
