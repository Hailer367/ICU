package K;

import java.io.FileInputStream;

/* loaded from: classes.dex */
public final class S extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f419c;

    /* renamed from: d, reason: collision with root package name */
    public FileInputStream f420d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f421e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ T f422f;

    /* renamed from: g, reason: collision with root package name */
    public int f423g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(T t2, V0.c cVar) {
        super(cVar);
        this.f422f = t2;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f421e = obj;
        this.f423g |= Integer.MIN_VALUE;
        return T.a(this.f422f, this);
    }
}
