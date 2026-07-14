package androidx.fragment.app;

import f.AbstractC0193i;
import f.InterfaceC0186b;
import f.InterfaceC0194j;
import g.AbstractC0199b;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class D extends F {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C f1510a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1511b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0199b f1512c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0186b f1513d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ H f1514e;

    public D(H h2, C c2, AtomicReference atomicReference, AbstractC0199b abstractC0199b, InterfaceC0186b interfaceC0186b) {
        this.f1514e = h2;
        this.f1510a = c2;
        this.f1511b = atomicReference;
        this.f1512c = abstractC0199b;
        this.f1513d = interfaceC0186b;
    }

    @Override // androidx.fragment.app.F
    public final void a() {
        AbstractC0193i activityResultRegistry;
        H h2 = this.f1514e;
        String generateActivityResultKey = h2.generateActivityResultKey();
        C c2 = this.f1510a;
        switch (c2.f1505a) {
            case 0:
                H h3 = (H) c2.f1506b;
                Object obj = h3.mHost;
                if (obj instanceof InterfaceC0194j) {
                    activityResultRegistry = ((InterfaceC0194j) obj).getActivityResultRegistry();
                    break;
                } else {
                    activityResultRegistry = h3.requireActivity().getActivityResultRegistry();
                    break;
                }
            default:
                activityResultRegistry = (AbstractC0193i) c2.f1506b;
                break;
        }
        this.f1511b.set(activityResultRegistry.c(generateActivityResultKey, h2, this.f1512c, this.f1513d));
    }
}
