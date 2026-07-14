package H1;

import android.content.Context;
import android.os.UserManager;
import java.util.Set;
import java.util.concurrent.Executor;
import p1.C0585n;
import q1.AbstractC0602b;
import x1.k;

/* loaded from: classes.dex */
public final class e implements g, h {

    /* renamed from: a, reason: collision with root package name */
    public final k f655a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f656b;

    /* renamed from: c, reason: collision with root package name */
    public final J1.a f657c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f658d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f659e;

    public e(Context context, String str, Set set, J1.a aVar, Executor executor) {
        this.f655a = new k(new c(0, context, str));
        this.f658d = set;
        this.f659e = executor;
        this.f657c = aVar;
        this.f656b = context;
    }

    public final C0585n a() {
        if (!((UserManager) this.f656b.getSystemService(UserManager.class)).isUserUnlocked()) {
            return AbstractC0602b.A("");
        }
        return AbstractC0602b.g(this.f659e, new d(this, 0));
    }

    public final void b() {
        if (this.f658d.size() <= 0) {
            AbstractC0602b.A(null);
        } else if (!((UserManager) this.f656b.getSystemService(UserManager.class)).isUserUnlocked()) {
            AbstractC0602b.A(null);
        } else {
            AbstractC0602b.g(this.f659e, new d(this, 1));
        }
    }
}
