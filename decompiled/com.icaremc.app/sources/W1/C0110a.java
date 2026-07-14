package W1;

import a2.C0143a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* renamed from: W1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0110a implements T1.t {
    @Override // T1.t
    public final T1.s create(T1.e eVar, C0143a c0143a) {
        Type componentType;
        Type type = c0143a.f2217b;
        boolean z = type instanceof GenericArrayType;
        if (!z && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        if (z) {
            componentType = ((GenericArrayType) type).getGenericComponentType();
        } else {
            componentType = ((Class) type).getComponentType();
        }
        return new C0111b(eVar, eVar.c(new C0143a(componentType)), V1.d.h(componentType));
    }
}
