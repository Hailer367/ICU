package q1;

import android.os.RemoteException;
import io.flutter.plugin.platform.s;
import n.p;
import p1.C0580i;
import r1.o;

/* loaded from: classes.dex */
public final class f extends r1.j {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5954g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C0580i f5955h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f5956i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f5957j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Object obj, C0580i c0580i, C0580i c0580i2, Object obj2, int i4) {
        super(c0580i);
        this.f5954g = i4;
        this.f5957j = obj;
        this.f5955h = c0580i2;
        this.f5956i = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [q1.g, q1.h] */
    @Override // r1.j
    public final void a() {
        switch (this.f5954g) {
            case 0:
                C0580i c0580i = this.f5955h;
                j jVar = (j) this.f5957j;
                String str = (String) this.f5956i;
                try {
                    jVar.f5964a.f6043m.c(jVar.f5965b, j.a(jVar, str), new i(jVar, c0580i, str));
                    return;
                } catch (RemoteException e4) {
                    j.f5962e.m(e4, "requestUpdateInfo(%s)", str);
                    c0580i.c(new RuntimeException(e4));
                    return;
                }
            case 1:
                C0580i c0580i2 = this.f5955h;
                j jVar2 = (j) this.f5957j;
                try {
                    jVar2.f5964a.f6043m.g(jVar2.f5965b, j.b(), new g(jVar2, new p("OnCompleteUpdateCallback"), c0580i2));
                    return;
                } catch (RemoteException e5) {
                    j.f5962e.m(e5, "completeUpdate(%s)", (String) this.f5956i);
                    c0580i2.c(new RuntimeException(e5));
                    return;
                }
            default:
                synchronized (((o) this.f5957j).f6037f) {
                    try {
                        o oVar = (o) this.f5957j;
                        C0580i c0580i3 = this.f5955h;
                        oVar.f6036e.add(c0580i3);
                        c0580i3.f5821a.h(new s(3, oVar, c0580i3, false));
                        if (((o) this.f5957j).k.getAndIncrement() > 0) {
                            ((o) this.f5957j).f6033b.o("Already connected to the service.", new Object[0]);
                        }
                        o.b((o) this.f5957j, (r1.j) this.f5956i);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(j jVar, C0580i c0580i, String str, C0580i c0580i2) {
        super(c0580i);
        this.f5954g = 0;
        this.f5957j = jVar;
        this.f5956i = str;
        this.f5955h = c0580i2;
    }
}
