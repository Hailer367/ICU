package P1;

import com.google.firebase.messaging.FirebaseMessaging;
import f1.AbstractC0286a;
import p1.InterfaceC0576e;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements InterfaceC0576e {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1429f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f1430g;

    public /* synthetic */ n(FirebaseMessaging firebaseMessaging, int i4) {
        this.f1429f = i4;
        this.f1430g = firebaseMessaging;
    }

    @Override // p1.InterfaceC0576e
    public final void e(Object obj) {
        int i4 = this.f1429f;
        FirebaseMessaging firebaseMessaging = this.f1430g;
        switch (i4) {
            case 0:
                G g4 = (G) obj;
                if (firebaseMessaging.f3413e.b()) {
                    g4.f();
                    return;
                }
                return;
            default:
                V0.a aVar = (V0.a) obj;
                A a4 = FirebaseMessaging.f3406l;
                firebaseMessaging.getClass();
                if (aVar != null) {
                    AbstractC0286a.y(aVar.f1672f);
                    firebaseMessaging.g();
                    return;
                }
                return;
        }
    }
}
