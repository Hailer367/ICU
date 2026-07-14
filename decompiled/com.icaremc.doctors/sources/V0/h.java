package V0;

import kotlin.jvm.internal.r;

/* loaded from: classes.dex */
public abstract class h extends c implements kotlin.jvm.internal.f {
    private final int arity;

    public h(int i2, T0.d dVar) {
        super(dVar);
        this.arity = i2;
    }

    @Override // kotlin.jvm.internal.f
    public int getArity() {
        return this.arity;
    }

    @Override // V0.a
    public String toString() {
        if (getCompletion() == null) {
            r.f2790a.getClass();
            String obj = getClass().getGenericInterfaces()[0].toString();
            if (obj.startsWith("kotlin.jvm.functions.")) {
                obj = obj.substring(21);
            }
            kotlin.jvm.internal.h.d(obj, "renderLambdaToString(...)");
            return obj;
        }
        return super.toString();
    }
}
