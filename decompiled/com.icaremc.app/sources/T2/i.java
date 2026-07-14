package T2;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class i implements f, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final int f1640f;

    public i(int i4) {
        this.f1640f = i4;
    }

    @Override // T2.f
    public final int b() {
        return this.f1640f;
    }

    public final String toString() {
        q.f1646a.getClass();
        String obj = getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
        }
        h.d(obj, "renderLambdaToString(...)");
        return obj;
    }
}
