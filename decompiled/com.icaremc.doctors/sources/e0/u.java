package e0;

import java.util.ArrayList;
import r.C0293e;

/* loaded from: classes.dex */
public final class u extends t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0293e f2234a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f2235b;

    public u(v vVar, C0293e c0293e) {
        this.f2235b = vVar;
        this.f2234a = c0293e;
    }

    @Override // e0.r
    public final void b(s sVar) {
        ((ArrayList) this.f2234a.get(this.f2235b.f2237d)).remove(sVar);
        sVar.w(this);
    }
}
