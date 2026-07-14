package A0;

import C0.h;
import C0.j;
import android.util.Log;
import v0.i;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements D0.b, h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f13c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f14d;

    public /* synthetic */ b(j jVar, Object obj, v0.j jVar2, int i2) {
        this.f11a = i2;
        this.f14d = jVar;
        this.f12b = obj;
        this.f13c = jVar2;
    }

    @Override // D0.b
    public Object a() {
        c cVar = (c) this.f14d;
        v0.j jVar = (v0.j) this.f13c;
        i iVar = (i) this.f12b;
        j jVar2 = (j) cVar.f19d;
        jVar2.getClass();
        s0.d dVar = jVar.f3915c;
        String str = iVar.f3907a;
        String str2 = jVar.f3913a;
        String p = android.support.v4.media.session.a.p("SQLiteEventStore");
        if (Log.isLoggable(p, 3)) {
            Log.d(p, "Storing event with priority=" + dVar + ", name=" + str + " for destination " + str2);
        }
        ((Long) jVar2.c(new b(jVar2, (Object) iVar, jVar, 1))).getClass();
        cVar.f16a.a(jVar, 1, false);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007b A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object, m.n] */
    @Override // C0.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object apply(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 978
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A0.b.apply(java.lang.Object):java.lang.Object");
    }

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i2) {
        this.f11a = i2;
        this.f14d = obj;
        this.f13c = obj2;
        this.f12b = obj3;
    }
}
