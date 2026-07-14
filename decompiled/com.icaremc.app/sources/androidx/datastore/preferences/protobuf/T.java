package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class T {

    /* renamed from: c, reason: collision with root package name */
    public static final T f2593c = new T();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2595b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final F f2594a = new F();

    public final W a(Class cls) {
        W w2;
        Class cls2;
        AbstractC0167y.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f2595b;
        W w3 = (W) concurrentHashMap.get(cls);
        if (w3 == null) {
            F f4 = this.f2594a;
            f4.getClass();
            Class cls3 = X.f2603a;
            if (!AbstractC0165w.class.isAssignableFrom(cls) && (cls2 = X.f2603a) != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
            V a4 = ((E) f4.f2563a).a(cls);
            int i4 = a4.f2602d;
            AbstractC0144a abstractC0144a = a4.f2599a;
            if ((i4 & 2) == 2) {
                if (AbstractC0165w.class.isAssignableFrom(cls)) {
                    w2 = new O(X.f2605c, AbstractC0160q.f2680a, abstractC0144a);
                } else {
                    e0 e0Var = X.f2604b;
                    C0159p c0159p = AbstractC0160q.f2681b;
                    if (c0159p != null) {
                        w2 = new O(e0Var, c0159p, abstractC0144a);
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
            } else if (AbstractC0165w.class.isAssignableFrom(cls)) {
                C0159p c0159p2 = null;
                P p3 = Q.f2592b;
                C c4 = D.f2560b;
                e0 e0Var2 = X.f2605c;
                if (R.i.b(a4.a()) != 1) {
                    c0159p2 = AbstractC0160q.f2680a;
                }
                C0159p c0159p3 = c0159p2;
                J j4 = K.f2572b;
                int[] iArr = N.f2574n;
                if (a4 instanceof V) {
                    w2 = N.w(a4, p3, c4, e0Var2, c0159p3, j4);
                } else {
                    a4.getClass();
                    throw new ClassCastException();
                }
            } else {
                C0159p c0159p4 = null;
                P p4 = Q.f2591a;
                C c5 = D.f2559a;
                e0 e0Var3 = X.f2604b;
                if (R.i.b(a4.a()) == 1 || (c0159p4 = AbstractC0160q.f2681b) != null) {
                    C0159p c0159p5 = c0159p4;
                    J j5 = K.f2571a;
                    int[] iArr2 = N.f2574n;
                    if (a4 instanceof V) {
                        w2 = N.w(a4, p4, c5, e0Var3, c0159p5, j5);
                    } else {
                        a4.getClass();
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
