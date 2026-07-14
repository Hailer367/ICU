package v0;

import android.content.Context;
import com.google.firebase.encoders.json.BuildConfig;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import s0.C0301c;
import t0.C0303a;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: e, reason: collision with root package name */
    public static volatile k f3929e;

    /* renamed from: a, reason: collision with root package name */
    public final A0.f f3930a;

    /* renamed from: b, reason: collision with root package name */
    public final A0.f f3931b;

    /* renamed from: c, reason: collision with root package name */
    public final A0.e f3932c;

    /* renamed from: d, reason: collision with root package name */
    public final B0.n f3933d;

    public q(A0.f fVar, A0.f fVar2, A0.e eVar, B0.n nVar, B0.p pVar) {
        this.f3930a = fVar;
        this.f3931b = fVar2;
        this.f3932c = eVar;
        this.f3933d = nVar;
        pVar.f126a.execute(new B0.o(0, pVar));
    }

    public static q a() {
        k kVar = f3929e;
        if (kVar != null) {
            return (q) kVar.f3921h.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (f3929e == null) {
            synchronized (q.class) {
                try {
                    if (f3929e == null) {
                        F.h hVar = new F.h(18, false);
                        context.getClass();
                        hVar.f274d = context;
                        f3929e = hVar.j();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final p c(l lVar) {
        Set singleton;
        byte[] bytes;
        if (lVar != null) {
            singleton = Collections.unmodifiableSet(C0303a.f3639d);
        } else {
            singleton = Collections.singleton(new C0301c("proto"));
        }
        A0.g a2 = j.a();
        lVar.getClass();
        a2.f30d = "cct";
        C0303a c0303a = (C0303a) lVar;
        String str = c0303a.f3642a;
        String str2 = c0303a.f3643b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            bytes = ("1$" + str + "\\" + str2).getBytes(Charset.forName("UTF-8"));
        }
        a2.f31e = bytes;
        return new p(singleton, a2.a(), this);
    }
}
