package V0;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import p1.AbstractC0579h;
import p1.C0585n;
import p1.InterfaceC0572a;
import p1.InterfaceC0578g;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements InterfaceC0572a, InterfaceC0578g {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ d f1684g = new d(0);

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ d f1685h = new d(1);

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ d f1686i = new d(2);

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1687f;

    public /* synthetic */ d(int i4) {
        this.f1687f = i4;
    }

    @Override // p1.InterfaceC0578g
    public C0585n a(Object obj) {
        Bundle bundle = (Bundle) obj;
        int i4 = b.f1673h;
        if (bundle != null && bundle.containsKey("google.messenger")) {
            return AbstractC0602b.A(null);
        }
        return AbstractC0602b.A(bundle);
    }

    @Override // p1.InterfaceC0572a
    public Object b(AbstractC0579h abstractC0579h) {
        switch (this.f1687f) {
            case 0:
                if (abstractC0579h.f()) {
                    return (Bundle) abstractC0579h.d();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Error making request: ".concat(String.valueOf(abstractC0579h.c())));
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", abstractC0579h.c());
            default:
                Intent intent = (Intent) ((Bundle) abstractC0579h.d()).getParcelable("notification_data");
                if (intent != null) {
                    return new a(intent);
                }
                return null;
        }
    }
}
