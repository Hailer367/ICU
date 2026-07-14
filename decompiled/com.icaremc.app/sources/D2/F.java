package D2;

import java.util.List;
import s2.InterfaceC0631c;

/* loaded from: classes.dex */
public final /* synthetic */ class F implements InterfaceC0631c {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f285f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ M f286g;

    public /* synthetic */ F(M m3, int i4) {
        this.f285f = i4;
        this.f286g = m3;
    }

    @Override // s2.InterfaceC0631c
    public final void t(Object obj) {
        switch (this.f285f) {
            case 0:
                S2.l lVar = (S2.l) this.f286g.f302g;
                if (obj instanceof List) {
                    List list = (List) obj;
                    if (list.size() > 1) {
                        Object obj2 = list.get(0);
                        T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                        Object obj3 = list.get(1);
                        T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                        lVar.f(new N(k3.b.f(new C0022a((String) obj2, (String) obj3, (String) list.get(2)))));
                        return;
                    }
                    lVar.f(new N((String) list.get(0)));
                    return;
                }
                lVar.f(new N(k3.b.f(new C0022a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsPrompt'.", ""))));
                return;
            case 1:
                S2.l lVar2 = (S2.l) this.f286g.f302g;
                if (obj instanceof List) {
                    List list2 = (List) obj;
                    if (list2.size() > 1) {
                        Object obj4 = list2.get(0);
                        T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                        Object obj5 = list2.get(1);
                        T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                        lVar2.f(new N(k3.b.f(new C0022a((String) obj4, (String) obj5, (String) list2.get(2)))));
                        return;
                    }
                    lVar2.f(new N(H2.i.f681a));
                    return;
                }
                lVar2.f(new N(k3.b.f(new C0022a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsAlert'.", ""))));
                return;
            case 2:
                S2.l lVar3 = (S2.l) this.f286g.f302g;
                if (obj instanceof List) {
                    List list3 = (List) obj;
                    if (list3.size() > 1) {
                        Object obj6 = list3.get(0);
                        T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                        Object obj7 = list3.get(1);
                        T2.h.c(obj7, "null cannot be cast to non-null type kotlin.String");
                        lVar3.f(new N(k3.b.f(new C0022a((String) obj6, (String) obj7, (String) list3.get(2)))));
                        return;
                    }
                    if (list3.get(0) == null) {
                        lVar3.f(new N(k3.b.f(new C0022a("null-error", "Flutter api returned null value for non-null return value.", ""))));
                        return;
                    }
                    Object obj8 = list3.get(0);
                    T2.h.c(obj8, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    lVar3.f(new N((List) obj8));
                    return;
                }
                lVar3.f(new N(k3.b.f(new C0022a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowFileChooser'.", ""))));
                return;
            default:
                S2.l lVar4 = (S2.l) this.f286g.f302g;
                if (obj instanceof List) {
                    List list4 = (List) obj;
                    if (list4.size() > 1) {
                        Object obj9 = list4.get(0);
                        T2.h.c(obj9, "null cannot be cast to non-null type kotlin.String");
                        Object obj10 = list4.get(1);
                        T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                        lVar4.f(new N(k3.b.f(new C0022a((String) obj9, (String) obj10, (String) list4.get(2)))));
                        return;
                    }
                    if (list4.get(0) == null) {
                        lVar4.f(new N(k3.b.f(new C0022a("null-error", "Flutter api returned null value for non-null return value.", ""))));
                        return;
                    }
                    Object obj11 = list4.get(0);
                    T2.h.c(obj11, "null cannot be cast to non-null type kotlin.Boolean");
                    lVar4.f(new N((Boolean) obj11));
                    return;
                }
                lVar4.f(new N(k3.b.f(new C0022a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsConfirm'.", ""))));
                return;
        }
    }
}
