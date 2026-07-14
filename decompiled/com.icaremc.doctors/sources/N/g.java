package N;

import androidx.datastore.preferences.protobuf.AbstractC0075b;
import androidx.datastore.preferences.protobuf.AbstractC0093u;
import androidx.datastore.preferences.protobuf.AbstractC0095w;
import androidx.datastore.preferences.protobuf.AbstractC0097y;
import androidx.datastore.preferences.protobuf.InterfaceC0096x;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.U;
import androidx.datastore.preferences.protobuf.V;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes.dex */
public final class g extends AbstractC0095w {
    private static final g DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private InterfaceC0096x strings_ = U.f1377f;

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        AbstractC0095w.j(g.class, gVar);
    }

    public static void l(g gVar, Set set) {
        int i2;
        InterfaceC0096x interfaceC0096x = gVar.strings_;
        if (!((AbstractC0075b) interfaceC0096x).f1400c) {
            U u2 = (U) interfaceC0096x;
            int i3 = u2.f1379e;
            if (i3 == 0) {
                i2 = 10;
            } else {
                i2 = i3 * 2;
            }
            gVar.strings_ = u2.c(i2);
        }
        RandomAccess randomAccess = gVar.strings_;
        Charset charset = AbstractC0097y.f1494a;
        set.getClass();
        if (randomAccess instanceof ArrayList) {
            ((ArrayList) randomAccess).ensureCapacity(set.size() + ((U) randomAccess).f1379e);
        }
        U u3 = (U) randomAccess;
        int i4 = u3.f1379e;
        for (Object obj : set) {
            if (obj == null) {
                String str = "Element at index " + (u3.f1379e - i4) + " is null.";
                for (int i5 = u3.f1379e - 1; i5 >= i4; i5--) {
                    u3.remove(i5);
                }
                throw new NullPointerException(str);
            }
            u3.add(obj);
        }
    }

    public static g m() {
        return DEFAULT_INSTANCE;
    }

    public static f o() {
        return (f) ((AbstractC0093u) DEFAULT_INSTANCE.c(5));
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
                return new V(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new g();
            case 4:
                return new AbstractC0093u(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                S s3 = PARSER;
                if (s3 == null) {
                    synchronized (g.class) {
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

    public final InterfaceC0096x n() {
        return this.strings_;
    }
}
