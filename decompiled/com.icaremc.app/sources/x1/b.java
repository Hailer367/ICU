package x1;

import java.util.Set;

/* loaded from: classes.dex */
public interface b {
    default Object a(Class cls) {
        return e(o.a(cls));
    }

    J1.a b(o oVar);

    default Set c(o oVar) {
        return (Set) b(oVar).get();
    }

    default J1.a d(Class cls) {
        return f(o.a(cls));
    }

    default Object e(o oVar) {
        J1.a f4 = f(oVar);
        if (f4 == null) {
            return null;
        }
        return f4.get();
    }

    J1.a f(o oVar);
}
