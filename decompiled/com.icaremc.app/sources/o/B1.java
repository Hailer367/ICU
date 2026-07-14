package o;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.Executor;
import s2.InterfaceC0646r;
import s2.InterfaceC0647s;

/* loaded from: classes.dex */
public final class B1 implements K0.b, p2.b {

    /* renamed from: f, reason: collision with root package name */
    public Object f5414f;

    /* renamed from: g, reason: collision with root package name */
    public Object f5415g;

    /* renamed from: h, reason: collision with root package name */
    public Object f5416h;

    /* renamed from: i, reason: collision with root package name */
    public Object f5417i;

    /* renamed from: j, reason: collision with root package name */
    public Object f5418j;
    public Object k;

    /* renamed from: l, reason: collision with root package name */
    public Object f5419l;

    public void a(InterfaceC0646r interfaceC0646r) {
        ((HashSet) this.f5417i).add(interfaceC0646r);
    }

    public void b(InterfaceC0647s interfaceC0647s) {
        ((HashSet) this.f5418j).add(interfaceC0647s);
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [R0.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [R0.a, java.lang.Object] */
    @Override // G2.a
    public Object get() {
        return new O0.l((Context) ((G2.a) this.f5414f).get(), (J0.e) ((G2.a) this.f5415g).get(), (P0.d) ((G2.a) this.f5416h).get(), (O0.d) ((A2.t) this.f5417i).get(), (Executor) ((G2.a) this.f5418j).get(), (Q0.c) ((G2.a) this.k).get(), new Object(), new Object(), (P0.c) ((G2.a) this.f5419l).get());
    }
}
