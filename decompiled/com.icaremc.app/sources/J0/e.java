package J0;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final E0.a f885a;

    /* renamed from: b, reason: collision with root package name */
    public final d f886b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f887c;

    public e(Context context, d dVar) {
        E0.a aVar = new E0.a(3, context);
        this.f887c = new HashMap();
        this.f885a = aVar;
        this.f886b = dVar;
    }

    public final synchronized f a(String str) {
        if (this.f887c.containsKey(str)) {
            return (f) this.f887c.get(str);
        }
        CctBackendFactory y3 = this.f885a.y(str);
        if (y3 == null) {
            return null;
        }
        d dVar = this.f886b;
        f create = y3.create(new b(dVar.f882a, dVar.f883b, dVar.f884c, str));
        this.f887c.put(str, create);
        return create;
    }
}
