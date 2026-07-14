package q1;

import A2.x;
import n.p;
import r1.InterfaceC0622c;

/* renamed from: q1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0604d implements InterfaceC0622c {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5949f;

    /* renamed from: g, reason: collision with root package name */
    public final p f5950g;

    public /* synthetic */ C0604d(p pVar, int i4) {
        this.f5949f = i4;
        this.f5950g = pVar;
    }

    @Override // r1.InterfaceC0622c
    public final Object n() {
        switch (this.f5949f) {
            case 0:
                return new C0603c(((x) this.f5950g.f5322g).f117a);
            default:
                return new k(((x) this.f5950g.f5322g).f117a);
        }
    }
}
