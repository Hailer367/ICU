package W;

import d.C0172a;
import d.o;
import java.util.LinkedHashSet;
import o1.v;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final B0.h f794a;

    /* renamed from: b, reason: collision with root package name */
    public final g f795b = new g();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f796c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f797d;

    public c(B0.h hVar) {
        this.f794a = hVar;
        new LinkedHashSet();
        this.f796c = new LinkedHashSet();
        this.f797d = new LinkedHashSet();
    }

    public final void a(f fVar) {
        if (this.f797d.add(fVar)) {
            this.f795b.a(this, fVar, -1);
        }
    }

    public final void b(j jVar, int i2) {
        if (i2 != 1 && i2 != 0) {
            throw new IllegalArgumentException(O.a.c(i2, "Unsupported priority value: ").toString());
        }
        if (this.f797d.add(jVar)) {
            this.f795b.a(this, jVar, i2);
        }
    }

    public final void c(f fVar, b bVar) {
        g gVar = this.f795b;
        gVar.getClass();
        if (gVar.f808g == 0) {
            o c2 = gVar.c(-1);
            gVar.f807f = c2;
            gVar.f808g = -1;
            gVar.f809h = fVar;
            if (bVar != null) {
                if (c2 != null) {
                    c2.f2145f.handleOnBackStarted(new C0172a(bVar));
                }
                v vVar = gVar.f802a;
                i iVar = new i(bVar);
                vVar.getClass();
                vVar.c(null, iVar);
            }
        }
    }
}
