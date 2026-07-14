package E;

import d.RunnableC0173b;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: E.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0014n {

    /* renamed from: a, reason: collision with root package name */
    public final RunnableC0173b f241a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f242b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f243c = new HashMap();

    public C0014n(RunnableC0173b runnableC0173b) {
        this.f241a = runnableC0173b;
    }

    public final void a(InterfaceC0016p interfaceC0016p) {
        this.f242b.remove(interfaceC0016p);
        C0013m c0013m = (C0013m) this.f243c.remove(interfaceC0016p);
        if (c0013m != null) {
            c0013m.f239a.b(c0013m.f240b);
            c0013m.f240b = null;
        }
        this.f241a.run();
    }
}
