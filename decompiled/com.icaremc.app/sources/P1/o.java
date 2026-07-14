package P1;

import com.google.firebase.messaging.FirebaseMessaging;
import p1.C0585n;
import p1.InterfaceC0578g;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements InterfaceC0578g, V1.p {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1431f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f1432g;

    public /* synthetic */ o(String str, int i4) {
        this.f1431f = i4;
        this.f1432g = str;
    }

    @Override // p1.InterfaceC0578g
    public C0585n a(Object obj) {
        int i4 = this.f1431f;
        String str = this.f1432g;
        G g4 = (G) obj;
        switch (i4) {
            case 0:
                A a4 = FirebaseMessaging.f3406l;
                g4.getClass();
                C0585n d4 = g4.d(new D("S", str));
                g4.f();
                return d4;
            default:
                A a5 = FirebaseMessaging.f3406l;
                g4.getClass();
                C0585n d5 = g4.d(new D("U", str));
                g4.f();
                return d5;
        }
    }

    @Override // V1.p
    public Object g() {
        switch (this.f1431f) {
            case 2:
                throw new RuntimeException(this.f1432g);
            default:
                throw new RuntimeException(this.f1432g);
        }
    }
}
