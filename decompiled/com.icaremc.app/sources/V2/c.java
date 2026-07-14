package V2;

import T2.h;
import java.util.Random;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: g, reason: collision with root package name */
    public final b f1771g = new ThreadLocal();

    @Override // V2.a
    public final Random a() {
        Object obj = this.f1771g.get();
        h.d(obj, "get(...)");
        return (Random) obj;
    }
}
