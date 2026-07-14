package x1;

import java.util.Set;
import u1.C0667b;

/* loaded from: classes.dex */
public final class p implements G1.b {

    /* renamed from: a, reason: collision with root package name */
    public final Set f6492a;

    /* renamed from: b, reason: collision with root package name */
    public final G1.b f6493b;

    public p(Set set, G1.b bVar) {
        this.f6492a = set;
        this.f6493b = bVar;
    }

    @Override // G1.b
    public final void a(G1.a aVar) {
        if (this.f6492a.contains(C0667b.class)) {
            this.f6493b.a(aVar);
            return;
        }
        throw new RuntimeException("Attempting to publish an undeclared event " + aVar + ".");
    }
}
