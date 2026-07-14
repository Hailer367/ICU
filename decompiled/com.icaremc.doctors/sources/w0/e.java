package w0;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final B.c f3955a;

    /* renamed from: b, reason: collision with root package name */
    public final d f3956b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3957c;

    public e(Context context, d dVar) {
        B.c cVar = new B.c(context);
        this.f3957c = new HashMap();
        this.f3955a = cVar;
        this.f3956b = dVar;
    }

    public final synchronized f a(String str) {
        if (this.f3957c.containsKey(str)) {
            return (f) this.f3957c.get(str);
        }
        CctBackendFactory c2 = this.f3955a.c(str);
        if (c2 == null) {
            return null;
        }
        d dVar = this.f3956b;
        f create = c2.create(new C0342b(dVar.f3952a, dVar.f3953b, dVar.f3954c, str));
        this.f3957c.put(str, create);
        return create;
    }
}
