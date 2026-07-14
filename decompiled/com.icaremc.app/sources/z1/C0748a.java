package z1;

import O.C0073b;
import R.m;
import S2.l;
import T2.q;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import java.util.LinkedHashSet;

/* renamed from: z1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0748a implements l {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6634f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f6635g;

    public /* synthetic */ C0748a(h hVar, int i4) {
        this.f6634f = i4;
        this.f6635g = hVar;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [M2.h, R.k] */
    @Override // S2.l
    public final Object f(Object obj) {
        switch (this.f6634f) {
            case 0:
                C0073b c0073b = (C0073b) obj;
                T2.h.e(c0073b, "ex");
                Log.w(q.a(h.class).b(), "CorruptionException in " + this.f6635g.f6648a + " DataStore running in process " + Process.myPid(), c0073b);
                return new S.b(true);
            default:
                Context context = (Context) obj;
                T2.h.e(context, "it");
                String str = this.f6635g.f6648a;
                LinkedHashSet linkedHashSet = m.f1525a;
                T2.h.e(str, "sharedPreferencesName");
                T2.h.e(linkedHashSet, "keysToMigrate");
                return android.support.v4.media.session.a.p(new Q.d(context, str, Q.e.f1490a, new R.l(linkedHashSet, null), new M2.h(3, null)));
        }
    }
}
