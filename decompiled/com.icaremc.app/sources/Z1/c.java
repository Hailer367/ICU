package Z1;

import T1.s;
import T1.t;
import a2.C0143a;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes.dex */
public class c implements t {
    @Override // T1.t
    public final s create(T1.e eVar, C0143a c0143a) {
        if (c0143a.f2216a == Timestamp.class) {
            eVar.getClass();
            return new d(eVar.c(new C0143a(Date.class)));
        }
        return null;
    }
}
