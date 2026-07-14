package G0;

import A2.q;
import E1.d;
import H0.e;
import H0.g;
import H0.h;
import H0.i;
import H0.j;
import H0.k;
import H0.l;
import H0.n;
import H0.o;
import H0.r;
import H0.s;
import H0.v;
import J0.f;
import android.content.Context;
import android.net.ConnectivityManager;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name */
    public final q f563a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f564b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f565c;

    /* renamed from: d, reason: collision with root package name */
    public final URL f566d;

    /* renamed from: e, reason: collision with root package name */
    public final R0.a f567e;

    /* renamed from: f, reason: collision with root package name */
    public final R0.a f568f;

    /* renamed from: g, reason: collision with root package name */
    public final int f569g;

    public c(Context context, R0.a aVar, R0.a aVar2) {
        d dVar = new d();
        H0.c cVar = H0.c.f585a;
        dVar.a(o.class, cVar);
        dVar.a(i.class, cVar);
        H0.f fVar = H0.f.f598a;
        dVar.a(s.class, fVar);
        dVar.a(l.class, fVar);
        H0.d dVar2 = H0.d.f587a;
        dVar.a(H0.q.class, dVar2);
        dVar.a(j.class, dVar2);
        H0.b bVar = H0.b.f573a;
        dVar.a(H0.a.class, bVar);
        dVar.a(h.class, bVar);
        e eVar = e.f590a;
        dVar.a(r.class, eVar);
        dVar.a(k.class, eVar);
        g gVar = g.f606a;
        dVar.a(v.class, gVar);
        dVar.a(n.class, gVar);
        dVar.f472d = true;
        this.f563a = new q(2, dVar);
        this.f565c = context;
        this.f564b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f566d = b(a.f554c);
        this.f567e = aVar2;
        this.f568f = aVar;
        this.f569g = 130000;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e4) {
            throw new IllegalArgumentException(r2.k.d("Invalid url: ", str), e4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
    
        if (((H0.t) H0.t.f640f.get(r0)) != null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final I0.i a(I0.i r7) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: G0.c.a(I0.i):I0.i");
    }
}
