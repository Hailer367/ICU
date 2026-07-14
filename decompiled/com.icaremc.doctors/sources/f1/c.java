package f1;

import java.util.Random;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: b, reason: collision with root package name */
    public final b f2279b = new ThreadLocal();

    @Override // f1.a
    public final Random b() {
        Object obj = this.f2279b.get();
        h.d(obj, "get(...)");
        return (Random) obj;
    }
}
