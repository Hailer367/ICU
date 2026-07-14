package e;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import f0.C0281a;
import g.InterfaceC0290b;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3559f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3560g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f3561h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f3562i;

    public /* synthetic */ j(Object obj, int i4, Object obj2, int i5) {
        this.f3559f = i5;
        this.f3560g = obj;
        this.f3561h = i4;
        this.f3562i = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0290b interfaceC0290b;
        switch (this.f3559f) {
            case 0:
                k kVar = (k) this.f3560g;
                Object obj = ((A2.q) this.f3562i).f93g;
                String str = (String) kVar.f3753a.get(Integer.valueOf(this.f3561h));
                if (str != null) {
                    g.e eVar = (g.e) kVar.f3757e.get(str);
                    if (eVar != null) {
                        interfaceC0290b = eVar.f3746a;
                    } else {
                        interfaceC0290b = null;
                    }
                    if (interfaceC0290b == null) {
                        kVar.f3759g.remove(str);
                        kVar.f3758f.put(str, obj);
                        return;
                    } else {
                        InterfaceC0290b interfaceC0290b2 = eVar.f3746a;
                        if (kVar.f3756d.remove(str)) {
                            interfaceC0290b2.c(obj);
                            return;
                        }
                        return;
                    }
                }
                return;
            case 1:
                ((k) this.f3560g).a(this.f3561h, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f3562i));
                return;
            case 2:
                C0281a c0281a = (C0281a) this.f3560g;
                c0281a.f3663b.m(this.f3561h, this.f3562i);
                return;
            default:
                ((r.p) this.f3560g).onGreatestScrollPercentageIncreased(this.f3561h, (Bundle) this.f3562i);
                return;
        }
    }
}
