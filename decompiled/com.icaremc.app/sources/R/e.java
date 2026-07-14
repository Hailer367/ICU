package R;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.AbstractC0163u;
import androidx.datastore.preferences.protobuf.AbstractC0165w;
import androidx.datastore.preferences.protobuf.C0152i;
import androidx.datastore.preferences.protobuf.C0154k;
import androidx.datastore.preferences.protobuf.C0158o;
import androidx.datastore.preferences.protobuf.I;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.T;
import androidx.datastore.preferences.protobuf.V;
import androidx.datastore.preferences.protobuf.W;
import androidx.datastore.preferences.protobuf.c0;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends AbstractC0165w {
    private static final e DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private I preferences_ = I.f2569g;

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        AbstractC0165w.j(e.class, eVar);
    }

    public static I l(e eVar) {
        I i4 = eVar.preferences_;
        if (!i4.f2570f) {
            eVar.preferences_ = i4.b();
        }
        return eVar.preferences_;
    }

    public static c n() {
        return (c) ((AbstractC0163u) DEFAULT_INSTANCE.c(5));
    }

    public static e o(FileInputStream fileInputStream) {
        e eVar = DEFAULT_INSTANCE;
        C0152i c0152i = new C0152i(fileInputStream);
        C0158o a4 = C0158o.a();
        AbstractC0165w i4 = eVar.i();
        try {
            T t3 = T.f2593c;
            t3.getClass();
            W a5 = t3.a(i4.getClass());
            C0154k c0154k = c0152i.f2656b;
            if (c0154k == null) {
                c0154k = new C0154k(c0152i);
            }
            a5.g(i4, c0154k, a4);
            a5.d(i4);
            if (AbstractC0165w.f(i4, true)) {
                return (e) i4;
            }
            throw new IOException(new c0().getMessage());
        } catch (A e4) {
            if (e4.f2547f) {
                throw new IOException(e4.getMessage(), e4);
            }
            throw e4;
        } catch (c0 e5) {
            throw new IOException(e5.getMessage());
        } catch (IOException e6) {
            if (e6.getCause() instanceof A) {
                throw ((A) e6.getCause());
            }
            throw new IOException(e6.getMessage(), e6);
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof A) {
                throw ((A) e7.getCause());
            }
            throw e7;
        }
    }

    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.Object, androidx.datastore.preferences.protobuf.S] */
    @Override // androidx.datastore.preferences.protobuf.AbstractC0165w
    public final Object c(int i4) {
        S s3;
        switch (i.b(i4)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new V(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", d.f1521a});
            case 3:
                return new e();
            case 4:
                return new AbstractC0163u(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                S s4 = PARSER;
                if (s4 == null) {
                    synchronized (e.class) {
                        try {
                            S s5 = PARSER;
                            s3 = s5;
                            if (s5 == null) {
                                ?? obj = new Object();
                                PARSER = obj;
                                s3 = obj;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return s3;
                }
                return s4;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final Map m() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
