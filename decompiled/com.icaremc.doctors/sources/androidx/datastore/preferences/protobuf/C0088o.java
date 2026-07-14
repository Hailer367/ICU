package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0088o {

    /* renamed from: a, reason: collision with root package name */
    public static volatile C0088o f1461a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0088o f1462b;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.datastore.preferences.protobuf.o, java.lang.Object] */
    static {
        ?? obj = new Object();
        Map map = Collections.EMPTY_MAP;
        f1462b = obj;
    }

    public static C0088o a() {
        C0088o c0088o;
        T t2 = T.f1374c;
        C0088o c0088o2 = f1461a;
        if (c0088o2 == null) {
            synchronized (C0088o.class) {
                try {
                    c0088o = f1461a;
                    if (c0088o == null) {
                        Class cls = AbstractC0087n.f1460a;
                        C0088o c0088o3 = null;
                        if (cls != null) {
                            try {
                                c0088o3 = (C0088o) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                            } catch (Exception unused) {
                            }
                        }
                        if (c0088o3 != null) {
                            c0088o = c0088o3;
                        } else {
                            c0088o = f1462b;
                        }
                        f1461a = c0088o;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0088o;
        }
        return c0088o2;
    }
}
