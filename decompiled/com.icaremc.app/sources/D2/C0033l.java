package D2;

import android.webkit.ValueCallback;

/* renamed from: D2.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0033l implements ValueCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f414a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ S2.l f415b;

    public /* synthetic */ C0033l(S2.l lVar, int i4) {
        this.f414a = i4;
        this.f415b = lVar;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        switch (this.f414a) {
            case 0:
                A2.h hVar = (A2.h) this.f415b;
                T2.s.a(1, hVar);
                hVar.f(new H2.f((Boolean) obj));
                return;
            default:
                A2.h hVar2 = (A2.h) this.f415b;
                T2.s.a(1, hVar2);
                hVar2.f(new H2.f((String) obj));
                return;
        }
    }
}
