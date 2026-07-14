package N;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.AbstractC0093u;
import androidx.datastore.preferences.protobuf.AbstractC0095w;
import androidx.datastore.preferences.protobuf.C0082i;
import androidx.datastore.preferences.protobuf.C0084k;
import androidx.datastore.preferences.protobuf.C0088o;
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
public final class e extends AbstractC0095w {
    private static final e DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private I preferences_ = I.f1349d;

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        AbstractC0095w.j(e.class, eVar);
    }

    public static I l(e eVar) {
        I i2 = eVar.preferences_;
        if (!i2.f1350c) {
            eVar.preferences_ = i2.b();
        }
        return eVar.preferences_;
    }

    public static c n() {
        return (c) ((AbstractC0093u) DEFAULT_INSTANCE.c(5));
    }

    public static e o(FileInputStream fileInputStream) {
        e eVar = DEFAULT_INSTANCE;
        C0082i c0082i = new C0082i(fileInputStream);
        C0088o a2 = C0088o.a();
        AbstractC0095w i2 = eVar.i();
        try {
            T t2 = T.f1374c;
            t2.getClass();
            W a3 = t2.a(i2.getClass());
            C0084k c0084k = c0082i.f1439b;
            if (c0084k == null) {
                c0084k = new C0084k(c0082i);
            }
            a3.g(i2, c0084k, a2);
            a3.d(i2);
            if (AbstractC0095w.f(i2, true)) {
                return (e) i2;
            }
            throw new IOException(new c0().getMessage());
        } catch (A e2) {
            if (e2.f1326c) {
                throw new IOException(e2.getMessage(), e2);
            }
            throw e2;
        } catch (c0 e3) {
            throw new IOException(e3.getMessage());
        } catch (IOException e4) {
            if (e4.getCause() instanceof A) {
                throw ((A) e4.getCause());
            }
            throw new IOException(e4.getMessage(), e4);
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof A) {
                throw ((A) e5.getCause());
            }
            throw e5;
        }
    }

    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.Object, androidx.datastore.preferences.protobuf.S] */
    @Override // androidx.datastore.preferences.protobuf.AbstractC0095w
    public final Object c(int i2) {
        S s2;
        switch (i.b(i2)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new V(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", d.f619a});
            case 3:
                return new e();
            case 4:
                return new AbstractC0093u(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                S s3 = PARSER;
                if (s3 == null) {
                    synchronized (e.class) {
                        try {
                            S s4 = PARSER;
                            s2 = s4;
                            if (s4 == null) {
                                ?? obj = new Object();
                                PARSER = obj;
                                s2 = obj;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return s2;
                }
                return s3;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final Map m() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
