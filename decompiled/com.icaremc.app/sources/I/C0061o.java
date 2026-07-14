package I;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: I.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0061o {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f774a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f775b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f776c = new HashMap();

    public C0061o(Runnable runnable) {
        this.f774a = runnable;
    }

    public final boolean a() {
        Iterator it = this.f775b.iterator();
        while (it.hasNext()) {
            if (((androidx.fragment.app.H) ((InterfaceC0062p) it.next())).f2725a.p()) {
                return true;
            }
        }
        return false;
    }

    public final void b(InterfaceC0062p interfaceC0062p) {
        this.f775b.remove(interfaceC0062p);
        C0060n c0060n = (C0060n) this.f776c.remove(interfaceC0062p);
        if (c0060n != null) {
            c0060n.f772a.b(c0060n.f773b);
            c0060n.f773b = null;
        }
        this.f774a.run();
    }
}
