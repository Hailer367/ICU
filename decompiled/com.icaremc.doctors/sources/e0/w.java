package e0;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import r.C0293e;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final C0178a f2238a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f2239b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f2240c;

    /* JADX WARN: Type inference failed for: r0v0, types: [e0.a, e0.x] */
    static {
        ?? xVar = new x();
        xVar.y = false;
        xVar.H(new i(2));
        xVar.H(new s());
        xVar.H(new i(1));
        f2238a = xVar;
        f2239b = new ThreadLocal();
        f2240c = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [r.e, java.lang.Object, r.j] */
    public static C0293e a() {
        C0293e c0293e;
        ThreadLocal threadLocal = f2239b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (c0293e = (C0293e) weakReference.get()) != null) {
            return c0293e;
        }
        ?? jVar = new r.j(0);
        threadLocal.set(new WeakReference(jVar));
        return jVar;
    }
}
