package W1;

import b2.C0223a;
import b2.C0224b;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes.dex */
public class S extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        try {
            String v3 = c0223a.v();
            if (v3.equals("null")) {
                return null;
            }
            return new URI(v3);
        } catch (URISyntaxException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        String aSCIIString;
        URI uri = (URI) obj;
        if (uri == null) {
            aSCIIString = null;
        } else {
            aSCIIString = uri.toASCIIString();
        }
        c0224b.r(aSCIIString);
    }
}
