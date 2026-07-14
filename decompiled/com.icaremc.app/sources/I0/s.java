package I0;

import A2.t;
import android.content.Context;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: e, reason: collision with root package name */
    public static volatile k f850e;

    /* renamed from: a, reason: collision with root package name */
    public final R0.a f851a;

    /* renamed from: b, reason: collision with root package name */
    public final R0.a f852b;

    /* renamed from: c, reason: collision with root package name */
    public final N0.c f853c;

    /* renamed from: d, reason: collision with root package name */
    public final O0.l f854d;

    public s(R0.a aVar, R0.a aVar2, N0.c cVar, O0.l lVar, O0.m mVar) {
        this.f851a = aVar;
        this.f852b = aVar2;
        this.f853c = cVar;
        this.f854d = lVar;
        mVar.f1306a.execute(new A.k(3, mVar));
    }

    public static s a() {
        k kVar = f850e;
        if (kVar != null) {
            return (s) kVar.k.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [A2.l, java.lang.Object] */
    public static void b(Context context) {
        if (f850e == null) {
            synchronized (s.class) {
                try {
                    if (f850e == null) {
                        ?? obj = new Object();
                        context.getClass();
                        obj.f82a = context;
                        f850e = obj.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final r c(l lVar) {
        Set singleton;
        byte[] bytes;
        if (lVar != null) {
            singleton = Collections.unmodifiableSet(G0.a.f555d);
        } else {
            singleton = Collections.singleton(new F0.c("proto"));
        }
        t a4 = j.a();
        lVar.getClass();
        a4.f99g = "cct";
        G0.a aVar = (G0.a) lVar;
        String str = aVar.f558a;
        String str2 = aVar.f559b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = ("1$" + str + "\\" + str2).getBytes(Charset.forName("UTF-8"));
        }
        a4.f100h = bytes;
        return new r(singleton, a4.x(), this);
    }
}
