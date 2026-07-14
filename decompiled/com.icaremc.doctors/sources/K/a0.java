package K;

import java.io.FileOutputStream;

/* loaded from: classes.dex */
public final class a0 extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public FileOutputStream f451c;

    /* renamed from: d, reason: collision with root package name */
    public FileOutputStream f452d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f453e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b0 f454f;

    /* renamed from: g, reason: collision with root package name */
    public int f455g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(b0 b0Var, V0.c cVar) {
        super(cVar);
        this.f454f = b0Var;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f453e = obj;
        this.f455g |= Integer.MIN_VALUE;
        return this.f454f.b(null, this);
    }
}
