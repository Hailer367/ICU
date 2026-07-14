package T1;

import W1.C0122m;
import W1.i0;
import b2.C0224b;
import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes.dex */
public abstract class h {
    public boolean a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final k b() {
        if (this instanceof k) {
            return (k) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public String c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            C0224b c0224b = new C0224b(stringWriter);
            c0224b.f3232m = 1;
            i0.z.getClass();
            C0122m.e(c0224b, this);
            return stringWriter.toString();
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }
}
