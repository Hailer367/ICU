package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0158o {

    /* renamed from: a, reason: collision with root package name */
    public static volatile C0158o f2678a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0158o f2679b;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.datastore.preferences.protobuf.o, java.lang.Object] */
    static {
        ?? obj = new Object();
        Map map = Collections.EMPTY_MAP;
        f2679b = obj;
    }

    public static C0158o a() {
        C0158o c0158o;
        T t3 = T.f2593c;
        C0158o c0158o2 = f2678a;
        if (c0158o2 == null) {
            synchronized (C0158o.class) {
                try {
                    c0158o = f2678a;
                    if (c0158o == null) {
                        Class cls = AbstractC0157n.f2677a;
                        C0158o c0158o3 = null;
                        if (cls != null) {
                            try {
                                c0158o3 = (C0158o) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                            } catch (Exception unused) {
                            }
                        }
                        if (c0158o3 != null) {
                            c0158o = c0158o3;
                        } else {
                            c0158o = f2679b;
                        }
                        f2678a = c0158o;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0158o;
        }
        return c0158o2;
    }
}
