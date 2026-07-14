package M2;

import T2.q;

/* loaded from: classes.dex */
public abstract class h extends c implements T2.f {

    /* renamed from: i, reason: collision with root package name */
    public final int f1059i;

    public h(int i4, K2.d dVar) {
        super(dVar);
        this.f1059i = i4;
    }

    @Override // T2.f
    public final int b() {
        return this.f1059i;
    }

    @Override // M2.a
    public final String toString() {
        if (this.f1050f == null) {
            q.f1646a.getClass();
            String obj = getClass().getGenericInterfaces()[0].toString();
            if (obj.startsWith("kotlin.jvm.functions.")) {
                obj = obj.substring(21);
            }
            T2.h.d(obj, "renderLambdaToString(...)");
            return obj;
        }
        return super.toString();
    }
}
