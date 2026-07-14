package W1;

import b2.C0223a;
import b2.C0224b;
import java.net.URL;

/* loaded from: classes.dex */
public class Q extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        String v3 = c0223a.v();
        if (v3.equals("null")) {
            return null;
        }
        return new URL(v3);
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        String externalForm;
        URL url = (URL) obj;
        if (url == null) {
            externalForm = null;
        } else {
            externalForm = url.toExternalForm();
        }
        c0224b.r(externalForm);
    }
}
