package Y;

import android.content.Intent;
import android.content.IntentSender;
import f.C0190f;
import f.InterfaceC0186b;
import g.C0198a;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f837c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f838d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f839e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f840f;

    public /* synthetic */ a(Object obj, int i2, Object obj2, int i3) {
        this.f837c = i3;
        this.f839e = obj;
        this.f838d = i2;
        this.f840f = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0186b interfaceC0186b;
        switch (this.f837c) {
            case 0:
                b bVar = (b) this.f839e;
                bVar.f842b.g(this.f838d, this.f840f);
                return;
            case 1:
                d.j jVar = (d.j) this.f839e;
                Object obj = ((C0198a) this.f840f).f2281c;
                String str = (String) jVar.f2265a.get(Integer.valueOf(this.f838d));
                if (str != null) {
                    C0190f c0190f = (C0190f) jVar.f2269e.get(str);
                    if (c0190f != null) {
                        interfaceC0186b = c0190f.f2257a;
                    } else {
                        interfaceC0186b = null;
                    }
                    if (interfaceC0186b == null) {
                        jVar.f2271g.remove(str);
                        jVar.f2270f.put(str, obj);
                        return;
                    }
                    InterfaceC0186b interfaceC0186b2 = c0190f.f2257a;
                    kotlin.jvm.internal.h.c(interfaceC0186b2, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
                    if (jVar.f2268d.remove(str)) {
                        interfaceC0186b2.a(obj);
                        return;
                    }
                    return;
                }
                return;
            default:
                ((d.j) this.f839e).a(this.f838d, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f840f));
                return;
        }
    }
}
