package P1;

import D2.Y;
import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import p1.C0580i;

/* loaded from: classes.dex */
public final class K extends Binder {

    /* renamed from: f, reason: collision with root package name */
    public final R1.c f1380f;

    public K(R1.c cVar) {
        this.f1380f = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.concurrent.Executor, java.lang.Object] */
    public final void a(L l3) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "service received new intent via bind strategy");
            }
            Intent intent = l3.f1381a;
            AbstractServiceC0103g abstractServiceC0103g = (AbstractServiceC0103g) this.f1380f.f1532g;
            C0580i c0580i = new C0580i();
            abstractServiceC0103g.f1411f.execute(new Y(abstractServiceC0103g, intent, c0580i, 3));
            c0580i.f5821a.g(new Object(), new D2.J(12, l3));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
