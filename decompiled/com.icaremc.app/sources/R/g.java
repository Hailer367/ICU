package R;

import androidx.datastore.preferences.protobuf.AbstractC0145b;
import androidx.datastore.preferences.protobuf.AbstractC0163u;
import androidx.datastore.preferences.protobuf.AbstractC0165w;
import androidx.datastore.preferences.protobuf.AbstractC0167y;
import androidx.datastore.preferences.protobuf.InterfaceC0166x;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.U;
import androidx.datastore.preferences.protobuf.V;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes.dex */
public final class g extends AbstractC0165w {
    private static final g DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private InterfaceC0166x strings_ = U.f2596i;

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        AbstractC0165w.j(g.class, gVar);
    }

    public static void l(g gVar, Set set) {
        int i4;
        InterfaceC0166x interfaceC0166x = gVar.strings_;
        if (!((AbstractC0145b) interfaceC0166x).f2618f) {
            U u3 = (U) interfaceC0166x;
            int i5 = u3.f2598h;
            if (i5 == 0) {
                i4 = 10;
            } else {
                i4 = i5 * 2;
            }
            gVar.strings_ = u3.c(i4);
        }
        RandomAccess randomAccess = gVar.strings_;
        Charset charset = AbstractC0167y.f2709a;
        set.getClass();
        if (randomAccess instanceof ArrayList) {
            ((ArrayList) randomAccess).ensureCapacity(set.size() + ((U) randomAccess).f2598h);
        }
        U u4 = (U) randomAccess;
        int i6 = u4.f2598h;
        for (Object obj : set) {
            if (obj == null) {
                String str = "Element at index " + (u4.f2598h - i6) + " is null.";
                for (int i7 = u4.f2598h - 1; i7 >= i6; i7--) {
                    u4.remove(i7);
                }
                throw new NullPointerException(str);
            }
            u4.add(obj);
        }
    }

    public static g m() {
        return DEFAULT_INSTANCE;
    }

    public static f o() {
        return (f) ((AbstractC0163u) DEFAULT_INSTANCE.c(5));
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
                return new V(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new g();
            case 4:
                return new AbstractC0163u(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                S s4 = PARSER;
                if (s4 == null) {
                    synchronized (g.class) {
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

    public final InterfaceC0166x n() {
        return this.strings_;
    }
}
