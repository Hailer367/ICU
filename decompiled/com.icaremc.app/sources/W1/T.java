package W1;

import b2.C0223a;
import b2.C0224b;
import java.net.InetAddress;

/* loaded from: classes.dex */
public class T extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        return InetAddress.getByName(c0223a.v());
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        String hostAddress;
        InetAddress inetAddress = (InetAddress) obj;
        if (inetAddress == null) {
            hostAddress = null;
        } else {
            hostAddress = inetAddress.getHostAddress();
        }
        c0224b.r(hostAddress);
    }
}
