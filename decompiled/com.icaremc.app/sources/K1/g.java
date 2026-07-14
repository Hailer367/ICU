package K1;

import p1.C0580i;

/* loaded from: classes.dex */
public final class g implements j {

    /* renamed from: a, reason: collision with root package name */
    public final k f928a;

    /* renamed from: b, reason: collision with root package name */
    public final C0580i f929b;

    public g(k kVar, C0580i c0580i) {
        this.f928a = kVar;
        this.f929b = c0580i;
    }

    @Override // K1.j
    public final boolean a(L1.b bVar) {
        if (bVar.f1010b != 4 || this.f928a.a(bVar)) {
            return false;
        }
        String str = bVar.f1011c;
        if (str != null) {
            long j4 = bVar.f1013e;
            long j5 = bVar.f1014f;
            byte b4 = (byte) (((byte) 1) | 2);
            if (b4 == 3) {
                this.f929b.b(new a(str, j4, j5));
                return true;
            }
            StringBuilder sb = new StringBuilder();
            if ((b4 & 1) == 0) {
                sb.append(" tokenExpirationTimestamp");
            }
            if ((b4 & 2) == 0) {
                sb.append(" tokenCreationTimestamp");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }
        throw new NullPointerException("Null token");
    }

    @Override // K1.j
    public final boolean b(Exception exc) {
        this.f929b.c(exc);
        return true;
    }
}
