package T;

import P1.y;
import f1.AbstractC0286a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e extends AbstractC0286a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f1548d;

    public e(f fVar) {
        this.f1548d = fVar;
    }

    @Override // f1.AbstractC0286a
    public final void A(Throwable th) {
        this.f1548d.f1549a.d(th);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [H1.f, java.lang.Object] */
    @Override // f1.AbstractC0286a
    public final void B(y yVar) {
        f fVar = this.f1548d;
        fVar.f1551c = yVar;
        fVar.f1550b = new E0.a(fVar.f1551c, (H1.f) new Object(), fVar.f1549a.f1564h);
        k kVar = fVar.f1549a;
        kVar.getClass();
        ArrayList arrayList = new ArrayList();
        kVar.f1557a.writeLock().lock();
        try {
            kVar.f1559c = 1;
            arrayList.addAll(kVar.f1558b);
            kVar.f1558b.clear();
            kVar.f1557a.writeLock().unlock();
            kVar.f1560d.post(new i(arrayList, kVar.f1559c, null));
        } catch (Throwable th) {
            kVar.f1557a.writeLock().unlock();
            throw th;
        }
    }
}
