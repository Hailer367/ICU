package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class T {

    /* renamed from: c, reason: collision with root package name */
    public static final T f1374c = new T();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f1376b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final F f1375a = new F();

    public final W a(Class cls) {
        W w2;
        Class cls2;
        AbstractC0097y.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f1376b;
        W w3 = (W) concurrentHashMap.get(cls);
        if (w3 == null) {
            F f2 = this.f1375a;
            f2.getClass();
            Class cls3 = X.f1384a;
            if (!AbstractC0095w.class.isAssignableFrom(cls) && (cls2 = X.f1384a) != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
            V a2 = ((E) f2.f1343a).a(cls);
            int i2 = a2.f1383d;
            AbstractC0074a abstractC0074a = a2.f1380a;
            if ((i2 & 2) == 2) {
                if (AbstractC0095w.class.isAssignableFrom(cls)) {
                    w2 = new O(X.f1386c, AbstractC0090q.f1463a, abstractC0074a);
                } else {
                    e0 e0Var = X.f1385b;
                    C0089p c0089p = AbstractC0090q.f1464b;
                    if (c0089p != null) {
                        w2 = new O(e0Var, c0089p, abstractC0074a);
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
            } else if (AbstractC0095w.class.isAssignableFrom(cls)) {
                C0089p c0089p2 = null;
                P p = Q.f1373b;
                C c2 = D.f1340b;
                e0 e0Var2 = X.f1386c;
                if (N.i.b(a2.a()) != 1) {
                    c0089p2 = AbstractC0090q.f1463a;
                }
                C0089p c0089p3 = c0089p2;
                J j2 = K.f1352b;
                int[] iArr = N.f1354n;
                if (a2 instanceof V) {
                    w2 = N.w(a2, p, c2, e0Var2, c0089p3, j2);
                } else {
                    a2.getClass();
                    throw new ClassCastException();
                }
            } else {
                C0089p c0089p4 = null;
                P p2 = Q.f1372a;
                C c3 = D.f1339a;
                e0 e0Var3 = X.f1385b;
                if (N.i.b(a2.a()) == 1 || (c0089p4 = AbstractC0090q.f1464b) != null) {
                    C0089p c0089p5 = c0089p4;
                    J j3 = K.f1351a;
                    int[] iArr2 = N.f1354n;
                    if (a2 instanceof V) {
                        w2 = N.w(a2, p2, c3, e0Var3, c0089p5, j3);
                    } else {
                        a2.getClass();
                        throw new ClassCastException();
                    }
                } else {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
            }
            W w4 = (W) concurrentHashMap.putIfAbsent(cls, w2);
            if (w4 != null) {
                return w4;
            }
            return w2;
        }
        return w3;
    }
}
