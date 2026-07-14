package K;

import l1.C0236n;

/* renamed from: K.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0049y extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f562c;

    /* renamed from: d, reason: collision with root package name */
    public Q f563d;

    /* renamed from: e, reason: collision with root package name */
    public C0236n f564e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f565f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Q f566g;

    /* renamed from: h, reason: collision with root package name */
    public int f567h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0049y(Q q, V0.c cVar) {
        super(cVar);
        this.f566g = q;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f565f = obj;
        this.f567h |= Integer.MIN_VALUE;
        return Q.b(this.f566g, null, this);
    }
}
