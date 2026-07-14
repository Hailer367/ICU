package C2;

import A2.t;
import android.app.Activity;
import android.util.Log;
import o.B1;
import p2.InterfaceC0586a;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public final class g implements o2.c, InterfaceC0586a {

    /* renamed from: f, reason: collision with root package name */
    public t f267f;

    @Override // p2.InterfaceC0586a
    public final void onAttachedToActivity(p2.b bVar) {
        t tVar = this.f267f;
        if (tVar == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            tVar.f101i = (Activity) ((B1) bVar).f5414f;
        }
    }

    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
        t tVar = new t(bVar.f5785a);
        this.f267f = tVar;
        e eVar = f.f266c;
        InterfaceC0634f interfaceC0634f = bVar.f5787c;
        eVar.getClass();
        e.a(interfaceC0634f, tVar);
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivity() {
        t tVar = this.f267f;
        if (tVar == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            tVar.f101i = null;
        }
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
        if (this.f267f == null) {
            Log.wtf("UrlLauncherPlugin", "Already detached from the engine.");
            return;
        }
        e eVar = f.f266c;
        InterfaceC0634f interfaceC0634f = bVar.f5787c;
        eVar.getClass();
        e.a(interfaceC0634f, null);
        this.f267f = null;
    }

    @Override // p2.InterfaceC0586a
    public final void onReattachedToActivityForConfigChanges(p2.b bVar) {
        onAttachedToActivity(bVar);
    }
}
