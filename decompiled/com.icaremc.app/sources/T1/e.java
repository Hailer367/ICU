package T1;

import W1.A;
import W1.C0111b;
import W1.C0113d;
import W1.C0117h;
import W1.C0121l;
import W1.C0122m;
import W1.C0127s;
import W1.C0128t;
import W1.C0129u;
import W1.F;
import W1.Y;
import W1.a0;
import W1.i0;
import a2.C0143a;
import b2.C0223a;
import b2.C0224b;
import b2.C0225c;
import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: h, reason: collision with root package name */
    public static final a f1609h = a.f1601d;

    /* renamed from: i, reason: collision with root package name */
    public static final m f1610i = q.f1623f;

    /* renamed from: j, reason: collision with root package name */
    public static final n f1611j = q.f1624g;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f1612a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f1613b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final E0.a f1614c;

    /* renamed from: d, reason: collision with root package name */
    public final C0121l f1615d;

    /* renamed from: e, reason: collision with root package name */
    public final List f1616e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1617f;

    /* renamed from: g, reason: collision with root package name */
    public final a f1618g;

    public e(V1.h hVar, HashMap hashMap, a aVar, ArrayList arrayList, q qVar, q qVar2, ArrayList arrayList2) {
        C0127s c0127s;
        C0127s c0127s2;
        E0.a aVar2 = new E0.a(12, hashMap, arrayList2);
        this.f1614c = aVar2;
        this.f1617f = true;
        this.f1618g = aVar;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(i0.f1914A);
        if (qVar == q.f1623f) {
            c0127s = C0129u.f1967c;
        } else {
            c0127s = new C0127s(1, qVar);
        }
        arrayList3.add(c0127s);
        arrayList3.add(hVar);
        arrayList3.addAll(arrayList);
        arrayList3.add(i0.f1930p);
        arrayList3.add(i0.f1922g);
        arrayList3.add(i0.f1919d);
        arrayList3.add(i0.f1920e);
        arrayList3.add(i0.f1921f);
        F f4 = i0.k;
        arrayList3.add(new a0(Long.TYPE, Long.class, f4));
        arrayList3.add(new a0(Double.TYPE, Double.class, new b(0)));
        arrayList3.add(new a0(Float.TYPE, Float.class, new b(1)));
        if (qVar2 == q.f1624g) {
            c0127s2 = C0128t.f1965b;
        } else {
            c0127s2 = new C0127s(0, new C0128t(qVar2));
        }
        arrayList3.add(c0127s2);
        arrayList3.add(i0.f1923h);
        arrayList3.add(i0.f1924i);
        arrayList3.add(new Y(AtomicLong.class, new c(f4, 0).a(), 0));
        int i4 = 0;
        arrayList3.add(new Y(AtomicLongArray.class, new c(f4, 1).a(), i4));
        arrayList3.add(i0.f1925j);
        arrayList3.add(i0.f1926l);
        arrayList3.add(i0.f1931q);
        arrayList3.add(i0.f1932r);
        arrayList3.add(new Y(BigDecimal.class, i0.f1927m, i4));
        arrayList3.add(new Y(BigInteger.class, i0.f1928n, i4));
        arrayList3.add(new Y(V1.j.class, i0.f1929o, i4));
        arrayList3.add(i0.f1933s);
        arrayList3.add(i0.f1934t);
        arrayList3.add(i0.f1936v);
        arrayList3.add(i0.f1937w);
        arrayList3.add(i0.f1939y);
        arrayList3.add(i0.f1935u);
        arrayList3.add(i0.f1917b);
        arrayList3.add(C0117h.f1911c);
        arrayList3.add(i0.f1938x);
        if (Z1.f.f2199a) {
            arrayList3.add(Z1.f.f2201c);
            arrayList3.add(Z1.f.f2200b);
            arrayList3.add(Z1.f.f2202d);
        }
        arrayList3.add(C0111b.f1902c);
        arrayList3.add(i0.f1916a);
        arrayList3.add(new C0113d(aVar2, 0));
        arrayList3.add(new C0113d(aVar2, 1));
        C0121l c0121l = new C0121l(aVar2);
        this.f1615d = c0121l;
        arrayList3.add(c0121l);
        arrayList3.add(i0.f1915B);
        arrayList3.add(new A(aVar2, hVar, c0121l, arrayList2));
        this.f1616e = Collections.unmodifiableList(arrayList3);
    }

    public static void a(double d4) {
        if (!Double.isNaN(d4) && !Double.isInfinite(d4)) {
            return;
        }
        throw new IllegalArgumentException(d4 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    /* JADX WARN: Finally extract failed */
    public final Object b(String str, Type type) {
        C0143a c0143a = new C0143a(type);
        Object obj = null;
        if (str == null) {
            return null;
        }
        C0223a c0223a = new C0223a(new StringReader(str));
        c0223a.f3222t = 2;
        boolean z = true;
        c0223a.f3222t = 1;
        try {
            try {
                try {
                    c0223a.x();
                    z = false;
                    obj = c(c0143a).b(c0223a);
                } catch (EOFException e4) {
                    if (!z) {
                        throw new RuntimeException(e4);
                    }
                } catch (IllegalStateException e5) {
                    throw new RuntimeException(e5);
                }
                c0223a.f3222t = 2;
                if (obj != null) {
                    try {
                        if (c0223a.x() != 10) {
                            throw new RuntimeException("JSON document was not fully consumed.");
                        }
                    } catch (C0225c e6) {
                        throw new RuntimeException(e6);
                    } catch (IOException e7) {
                        throw new RuntimeException(e7);
                    }
                }
                return obj;
            } catch (IOException e8) {
                throw new RuntimeException(e8);
            } catch (AssertionError e9) {
                throw new AssertionError("AssertionError (GSON 2.12.0): " + e9.getMessage(), e9);
            }
        } catch (Throwable th) {
            c0223a.f3222t = 2;
            throw th;
        }
    }

    public final s c(C0143a c0143a) {
        boolean z;
        Objects.requireNonNull(c0143a, "type must not be null");
        ConcurrentHashMap concurrentHashMap = this.f1613b;
        s sVar = (s) concurrentHashMap.get(c0143a);
        if (sVar != null) {
            return sVar;
        }
        ThreadLocal threadLocal = this.f1612a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z = true;
        } else {
            s sVar2 = (s) map.get(c0143a);
            if (sVar2 != null) {
                return sVar2;
            }
            z = false;
        }
        try {
            d dVar = new d();
            map.put(c0143a, dVar);
            Iterator it = this.f1616e.iterator();
            s sVar3 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                sVar3 = ((t) it.next()).create(this, c0143a);
                if (sVar3 != null) {
                    if (dVar.f1608a == null) {
                        dVar.f1608a = sVar3;
                        map.put(c0143a, sVar3);
                    } else {
                        throw new AssertionError("Delegate is already set");
                    }
                }
            }
            if (z) {
                threadLocal.remove();
            }
            if (sVar3 != null) {
                if (z) {
                    concurrentHashMap.putAll(map);
                }
                return sVar3;
            }
            throw new IllegalArgumentException("GSON (2.12.0) cannot handle " + c0143a);
        } catch (Throwable th) {
            if (z) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0055, code lost:
    
        if (r3 == r7) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
    
        if (r3 == r7) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T1.s d(T1.t r7, a2.C0143a r8) {
        /*
            r6 = this;
            java.lang.String r0 = "skipPast must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r8, r0)
            W1.l r0 = r6.f1615d
            r0.getClass()
            java.util.concurrent.ConcurrentHashMap r1 = r0.f1947g
            W1.k r2 = W1.C0121l.f1944h
            if (r7 != r2) goto L16
            goto L57
        L16:
            java.lang.Class r2 = r8.f2216a
            java.lang.Object r3 = r1.get(r2)
            T1.t r3 = (T1.t) r3
            if (r3 == 0) goto L23
            if (r3 != r7) goto L58
            goto L57
        L23:
            java.lang.Class<U1.a> r3 = U1.a.class
            java.lang.annotation.Annotation r3 = r2.getAnnotation(r3)
            U1.a r3 = (U1.a) r3
            if (r3 != 0) goto L2e
            goto L58
        L2e:
            java.lang.Class r3 = r3.value()
            java.lang.Class<T1.t> r4 = T1.t.class
            boolean r4 = r4.isAssignableFrom(r3)
            if (r4 != 0) goto L3b
            goto L58
        L3b:
            E0.a r4 = r0.f1946f
            a2.a r5 = new a2.a
            r5.<init>(r3)
            V1.p r3 = r4.x(r5)
            java.lang.Object r3 = r3.g()
            T1.t r3 = (T1.t) r3
            java.lang.Object r1 = r1.putIfAbsent(r2, r3)
            T1.t r1 = (T1.t) r1
            if (r1 == 0) goto L55
            r3 = r1
        L55:
            if (r3 != r7) goto L58
        L57:
            r7 = r0
        L58:
            java.util.List r0 = r6.f1616e
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L5f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L78
            java.lang.Object r2 = r0.next()
            T1.t r2 = (T1.t) r2
            if (r1 != 0) goto L71
            if (r2 != r7) goto L5f
            r1 = 1
            goto L5f
        L71:
            T1.s r2 = r2.create(r6, r8)
            if (r2 == 0) goto L5f
            return r2
        L78:
            if (r1 != 0) goto L7f
            T1.s r7 = r6.c(r8)
            return r7
        L7f:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "GSON cannot serialize or deserialize "
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: T1.e.d(T1.t, a2.a):T1.s");
    }

    public final C0224b e(Writer writer) {
        C0224b c0224b = new C0224b(writer);
        c0224b.k(this.f1618g);
        c0224b.f3233n = this.f1617f;
        c0224b.l(2);
        c0224b.f3235p = false;
        return c0224b;
    }

    public final String f(Serializable serializable) {
        if (serializable == null) {
            StringWriter stringWriter = new StringWriter();
            try {
                g(e(stringWriter));
                return stringWriter.toString();
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }
        Class cls = serializable.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            h(serializable, cls, e(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    public final void g(C0224b c0224b) {
        j jVar = j.f1620f;
        int i4 = c0224b.f3232m;
        boolean z = c0224b.f3233n;
        boolean z3 = c0224b.f3235p;
        c0224b.f3233n = this.f1617f;
        c0224b.f3235p = false;
        if (i4 == 2) {
            c0224b.f3232m = 1;
        }
        try {
            try {
                i0.z.getClass();
                C0122m.e(c0224b, jVar);
                c0224b.l(i4);
                c0224b.f3233n = z;
                c0224b.f3235p = z3;
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            } catch (AssertionError e5) {
                throw new AssertionError("AssertionError (GSON 2.12.0): " + e5.getMessage(), e5);
            }
        } catch (Throwable th) {
            c0224b.l(i4);
            c0224b.f3233n = z;
            c0224b.f3235p = z3;
            throw th;
        }
    }

    public final void h(Object obj, Class cls, C0224b c0224b) {
        s c4 = c(new C0143a(cls));
        int i4 = c0224b.f3232m;
        if (i4 == 2) {
            c0224b.f3232m = 1;
        }
        boolean z = c0224b.f3233n;
        boolean z3 = c0224b.f3235p;
        c0224b.f3233n = this.f1617f;
        c0224b.f3235p = false;
        try {
            try {
                c4.c(c0224b, obj);
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            } catch (AssertionError e5) {
                throw new AssertionError("AssertionError (GSON 2.12.0): " + e5.getMessage(), e5);
            }
        } finally {
            c0224b.l(i4);
            c0224b.f3233n = z;
            c0224b.f3235p = z3;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f1616e + ",instanceCreators:" + this.f1614c + "}";
    }
}
