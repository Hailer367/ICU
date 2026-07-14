package W1;

import b2.C0223a;
import com.dexterous.flutterlocalnotifications.RuntimeTypeAdapterFactory;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class r extends T1.s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1959a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1960b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1961c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1962d;

    public r(T1.e eVar, T1.s sVar, Type type) {
        this.f1960b = eVar;
        this.f1961c = sVar;
        this.f1962d = type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v36, types: [W1.o, b2.a] */
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        switch (this.f1959a) {
            case 0:
                int x3 = c0223a.x();
                if (x3 == 9) {
                    c0223a.t();
                    return null;
                }
                Map map = (Map) ((V1.p) this.f1962d).g();
                if (x3 == 1) {
                    c0223a.a();
                    while (c0223a.k()) {
                        c0223a.a();
                        Object b4 = ((T1.s) ((r) this.f1960b).f1961c).b(c0223a);
                        if (map.put(b4, ((T1.s) ((r) this.f1961c).f1961c).b(c0223a)) == null) {
                            c0223a.e();
                        } else {
                            throw new RuntimeException("duplicate key: " + b4);
                        }
                    }
                    c0223a.e();
                } else {
                    c0223a.b();
                    while (c0223a.k()) {
                        H1.f.f662h.getClass();
                        if (c0223a instanceof C0124o) {
                            C0124o c0124o = (C0124o) c0223a;
                            c0124o.G(5);
                            Map.Entry entry = (Map.Entry) ((Iterator) c0124o.K()).next();
                            c0124o.M(entry.getValue());
                            c0124o.M(new T1.l((String) entry.getKey()));
                        } else {
                            int i4 = c0223a.f3214l;
                            if (i4 == 0) {
                                i4 = c0223a.d();
                            }
                            if (i4 == 13) {
                                c0223a.f3214l = 9;
                            } else if (i4 == 12) {
                                c0223a.f3214l = 8;
                            } else if (i4 == 14) {
                                c0223a.f3214l = 10;
                            } else {
                                throw c0223a.F("a name");
                            }
                        }
                        Object b5 = ((T1.s) ((r) this.f1960b).f1961c).b(c0223a);
                        if (map.put(b5, ((T1.s) ((r) this.f1961c).f1961c).b(c0223a)) != null) {
                            throw new RuntimeException("duplicate key: " + b5);
                        }
                    }
                    c0223a.f();
                }
                return map;
            case 1:
                return ((T1.s) this.f1961c).b(c0223a);
            default:
                T1.h i5 = V1.d.i(c0223a);
                T1.k b6 = i5.b();
                RuntimeTypeAdapterFactory runtimeTypeAdapterFactory = (RuntimeTypeAdapterFactory) this.f1962d;
                T1.h hVar = (T1.h) b6.f1621f.remove(RuntimeTypeAdapterFactory.c(runtimeTypeAdapterFactory));
                if (hVar != null) {
                    String c4 = hVar.c();
                    T1.s sVar = (T1.s) ((LinkedHashMap) this.f1960b).get(c4);
                    if (sVar != 0) {
                        try {
                            ?? c0223a2 = new C0223a(C0124o.f1949y);
                            c0223a2.f1950u = new Object[32];
                            c0223a2.f1951v = 0;
                            c0223a2.f1952w = new String[32];
                            c0223a2.f1953x = new int[32];
                            c0223a2.M(i5);
                            return sVar.b(c0223a2);
                        } catch (IOException e4) {
                            throw new RuntimeException(e4);
                        }
                    }
                    throw new RuntimeException("cannot deserialize " + RuntimeTypeAdapterFactory.a(runtimeTypeAdapterFactory) + " subtype named " + c4 + "; did you forget to register a subtype?");
                }
                throw new RuntimeException("cannot deserialize " + RuntimeTypeAdapterFactory.a(runtimeTypeAdapterFactory) + " because it does not define a field named " + RuntimeTypeAdapterFactory.c(runtimeTypeAdapterFactory));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x012b, code lost:
    
        if ((r2 instanceof W1.AbstractC0131w) == false) goto L53;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    @Override // T1.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(b2.C0224b r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.r.c(b2.b, java.lang.Object):void");
    }

    public r(C0113d c0113d, T1.e eVar, Type type, T1.s sVar, Type type2, T1.s sVar2, V1.p pVar) {
        this.f1960b = new r(eVar, sVar, type);
        this.f1961c = new r(eVar, sVar2, type2);
        this.f1962d = pVar;
    }

    public r(RuntimeTypeAdapterFactory runtimeTypeAdapterFactory, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2) {
        this.f1962d = runtimeTypeAdapterFactory;
        this.f1960b = linkedHashMap;
        this.f1961c = linkedHashMap2;
    }
}
