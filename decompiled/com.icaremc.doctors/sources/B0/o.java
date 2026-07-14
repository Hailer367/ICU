package B0;

import androidx.lifecycle.C0152w;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.J;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.FirebaseInstallations;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import m.C0271s;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f124c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f125d;

    public /* synthetic */ o(int i2, Object obj) {
        this.f124c = i2;
        this.f125d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f124c) {
            case 0:
                p pVar = (p) this.f125d;
                ((C0.j) pVar.f129d).f(new h(3, pVar));
                return;
            case 1:
                J j2 = (J) this.f125d;
                C0152w c0152w = j2.f1790h;
                if (j2.f1786d == 0) {
                    j2.f1787e = true;
                    c0152w.e(EnumC0144n.ON_PAUSE);
                }
                if (j2.f1785c == 0 && j2.f1787e) {
                    c0152w.e(EnumC0144n.ON_STOP);
                    j2.f1788f = true;
                    return;
                }
                return;
            case 2:
                ((FirebaseInstallations) this.f125d).lambda$getId$1();
                return;
            case 3:
                d.i iVar = (d.i) this.f125d;
                Runnable runnable = iVar.f2126d;
                if (runnable != null) {
                    runnable.run();
                    iVar.f2126d = null;
                    return;
                }
                return;
            case 4:
                d.m.a((d.m) this.f125d);
                return;
            case 5:
                ((PlatformViewsController) this.f125d).lambda$onEndFrame$3();
                return;
            case 6:
                FlutterFirebasePluginRegistry.a((TaskCompletionSource) this.f125d);
                return;
            default:
                ((C0271s) this.f125d).getClass();
                return;
        }
    }
}
