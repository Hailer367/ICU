package K;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class F extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f358c;

    /* renamed from: d, reason: collision with root package name */
    public Object f359d;

    /* renamed from: e, reason: collision with root package name */
    public Serializable f360e;

    /* renamed from: f, reason: collision with root package name */
    public kotlin.jvm.internal.q f361f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f362g;

    /* renamed from: h, reason: collision with root package name */
    public int f363h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f364i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Q f365j;

    /* renamed from: k, reason: collision with root package name */
    public int f366k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(Q q, V0.c cVar) {
        super(cVar);
        this.f365j = q;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f364i = obj;
        this.f366k |= Integer.MIN_VALUE;
        return Q.e(this.f365j, false, this);
    }
}
