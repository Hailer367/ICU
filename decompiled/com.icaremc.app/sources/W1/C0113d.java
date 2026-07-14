package W1;

import a2.C0143a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* renamed from: W1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0113d implements T1.t {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1908f;

    /* renamed from: g, reason: collision with root package name */
    public final E0.a f1909g;

    public /* synthetic */ C0113d(E0.a aVar, int i4) {
        this.f1908f = i4;
        this.f1909g = aVar;
    }

    @Override // T1.t
    public final T1.s create(T1.e eVar, C0143a c0143a) {
        Type[] typeArr;
        T1.s sVar;
        int i4 = this.f1908f;
        E0.a aVar = this.f1909g;
        Type type = Object.class;
        switch (i4) {
            case 0:
                Type type2 = c0143a.f2217b;
                Class cls = c0143a.f2216a;
                if (!Collection.class.isAssignableFrom(cls)) {
                    return null;
                }
                if (type2 instanceof WildcardType) {
                    type2 = ((WildcardType) type2).getUpperBounds()[0];
                }
                V1.d.b(Collection.class.isAssignableFrom(cls));
                Type k = V1.d.k(type2, cls, V1.d.g(type2, cls, Collection.class), new HashMap());
                if (k instanceof ParameterizedType) {
                    type = ((ParameterizedType) k).getActualTypeArguments()[0];
                }
                return new C0112c(eVar, type, eVar.c(new C0143a(type)), aVar.x(c0143a));
            default:
                Type type3 = c0143a.f2217b;
                Class cls2 = c0143a.f2216a;
                if (!Map.class.isAssignableFrom(cls2)) {
                    return null;
                }
                if (Properties.class.isAssignableFrom(cls2)) {
                    typeArr = new Type[]{String.class, String.class};
                } else {
                    if (type3 instanceof WildcardType) {
                        type3 = ((WildcardType) type3).getUpperBounds()[0];
                    }
                    V1.d.b(Map.class.isAssignableFrom(cls2));
                    Type k4 = V1.d.k(type3, cls2, V1.d.g(type3, cls2, Map.class), new HashMap());
                    if (k4 instanceof ParameterizedType) {
                        typeArr = ((ParameterizedType) k4).getActualTypeArguments();
                    } else {
                        typeArr = new Type[]{type, type};
                    }
                }
                Type type4 = typeArr[0];
                if (type4 != Boolean.TYPE && type4 != Boolean.class) {
                    sVar = eVar.c(new C0143a(type4));
                } else {
                    sVar = i0.f1918c;
                }
                T1.s c4 = eVar.c(new C0143a(typeArr[1]));
                V1.p x3 = aVar.x(c0143a);
                Type[] typeArr2 = typeArr;
                return new r(this, eVar, typeArr2[0], sVar, typeArr2[1], c4, x3);
        }
    }
}
