package h2;

import android.content.res.AssetManager;
import android.util.Log;
import android.view.KeyEvent;
import f1.AbstractC0286a;
import i2.C0368c;
import io.flutter.view.FlutterCallbackInformation;
import j2.C0427b;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import m2.C0447e;
import s2.C0644p;

/* loaded from: classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4050f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4051g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f4052h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f4053i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4054j;

    public /* synthetic */ t(A2.t tVar, C0447e c0447e, A2.q qVar, long j4) {
        this.f4050f = 2;
        this.f4051g = tVar;
        this.f4052h = c0447e;
        this.f4054j = qVar;
        this.f4053i = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4050f) {
            case 0:
                u uVar = (u) this.f4051g;
                C0341A c0341a = (C0341A) this.f4052h;
                KeyEvent keyEvent = (KeyEvent) this.f4054j;
                uVar.getClass();
                uVar.c(false, Long.valueOf(c0341a.f3949b), Long.valueOf(this.f4053i), keyEvent.getEventTime());
                return;
            case 1:
                u uVar2 = (u) this.f4051g;
                C0341A c0341a2 = (C0341A) this.f4052h;
                KeyEvent keyEvent2 = (KeyEvent) this.f4054j;
                uVar2.getClass();
                uVar2.c(false, Long.valueOf(c0341a2.f3949b), Long.valueOf(this.f4053i), keyEvent2.getEventTime());
                return;
            default:
                A2.t tVar = (A2.t) this.f4051g;
                C0447e c0447e = (C0447e) this.f4052h;
                A2.q qVar = (A2.q) this.f4054j;
                String str = (String) c0447e.f5206d.f1439c;
                AssetManager assets = AbstractC0286a.f3704c.getAssets();
                if (!((AtomicBoolean) tVar.f99g).get()) {
                    if (qVar != null) {
                        Log.i("FLTFireBGExecutor", "Creating background FlutterEngine instance, with args: " + Arrays.toString(qVar.K()));
                        tVar.f101i = new C0368c(AbstractC0286a.f3704c, qVar.K());
                    } else {
                        Log.i("FLTFireBGExecutor", "Creating background FlutterEngine instance.");
                        tVar.f101i = new C0368c(AbstractC0286a.f3704c, null);
                    }
                    FlutterCallbackInformation lookupCallbackInformation = FlutterCallbackInformation.lookupCallbackInformation(this.f4053i);
                    if (lookupCallbackInformation == null) {
                        Log.e("FLTFireBGExecutor", "Failed to find registered callback");
                        return;
                    }
                    C0427b c0427b = ((C0368c) tVar.f101i).f4108c;
                    C0644p c0644p = new C0644p(c0427b, "plugins.flutter.io/firebase_messaging_background");
                    tVar.f100h = c0644p;
                    c0644p.b(tVar);
                    c0427b.c(new A2.t(assets, str, lookupCallbackInformation, 20));
                    return;
                }
                return;
        }
    }

    public /* synthetic */ t(u uVar, C0341A c0341a, long j4, KeyEvent keyEvent, int i4) {
        this.f4050f = i4;
        this.f4051g = uVar;
        this.f4052h = c0341a;
        this.f4053i = j4;
        this.f4054j = keyEvent;
    }
}
