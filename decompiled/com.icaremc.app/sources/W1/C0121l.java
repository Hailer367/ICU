package W1;

import a2.C0143a;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: W1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0121l implements T1.t {

    /* renamed from: h, reason: collision with root package name */
    public static final C0120k f1944h;

    /* renamed from: i, reason: collision with root package name */
    public static final C0120k f1945i;

    /* renamed from: f, reason: collision with root package name */
    public final E0.a f1946f;

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap f1947g = new ConcurrentHashMap();

    static {
        int i4 = 0;
        f1944h = new C0120k(i4);
        f1945i = new C0120k(i4);
    }

    public C0121l(E0.a aVar) {
        this.f1946f = aVar;
    }

    public final T1.s a(E0.a aVar, T1.e eVar, C0143a c0143a, U1.a aVar2, boolean z) {
        T1.g gVar;
        C0120k c0120k;
        T1.s sVar;
        Object g4 = aVar.x(new C0143a(aVar2.value())).g();
        boolean nullSafe = aVar2.nullSafe();
        if (g4 instanceof T1.s) {
            sVar = (T1.s) g4;
        } else if (g4 instanceof T1.t) {
            T1.t tVar = (T1.t) g4;
            if (z) {
                T1.t tVar2 = (T1.t) this.f1947g.putIfAbsent(c0143a.f2216a, tVar);
                if (tVar2 != null) {
                    tVar = tVar2;
                }
            }
            sVar = tVar.create(eVar, c0143a);
        } else if (g4 instanceof T1.g) {
            if (g4 != null) {
                gVar = (T1.g) g4;
            } else {
                gVar = null;
            }
            T1.g gVar2 = gVar;
            if (z) {
                c0120k = f1944h;
            } else {
                c0120k = f1945i;
            }
            D d4 = new D(gVar2, eVar, c0143a, c0120k, nullSafe);
            nullSafe = false;
            sVar = d4;
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + g4.getClass().getName() + " as a @JsonAdapter for " + V1.d.l(c0143a.f2217b) + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (sVar != null && nullSafe) {
            return sVar.a();
        }
        return sVar;
    }

    @Override // T1.t
    public final T1.s create(T1.e eVar, C0143a c0143a) {
        U1.a aVar = (U1.a) c0143a.f2216a.getAnnotation(U1.a.class);
        if (aVar == null) {
            return null;
        }
        return a(this.f1946f, eVar, c0143a, aVar, true);
    }
}
