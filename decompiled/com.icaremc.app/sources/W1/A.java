package W1;

import a2.C0143a;
import f1.AbstractC0286a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class A implements T1.t {

    /* renamed from: f, reason: collision with root package name */
    public final E0.a f1883f;

    /* renamed from: g, reason: collision with root package name */
    public final V1.h f1884g;

    /* renamed from: h, reason: collision with root package name */
    public final C0121l f1885h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f1886i;

    public A(E0.a aVar, V1.h hVar, C0121l c0121l, ArrayList arrayList) {
        this.f1883f = aVar;
        this.f1884g = hVar;
        this.f1885h = c0121l;
        this.f1886i = arrayList;
    }

    public static void a(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + Y1.c.c(field) + " and " + Y1.c.c(field2) + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("duplicate-fields"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018c A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b1  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final W1.C0133y b(T1.e r29, a2.C0143a r30, java.lang.Class r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.A.b(T1.e, a2.a, java.lang.Class, boolean):W1.y");
    }

    public final boolean c(Field field, boolean z) {
        List list;
        boolean z3;
        V1.h hVar = this.f1884g;
        hVar.getClass();
        if ((136 & field.getModifiers()) != 0 || field.isSynthetic() || hVar.a(field.getType(), z)) {
            z3 = true;
        } else {
            if (z) {
                list = hVar.f1737f;
            } else {
                list = hVar.f1738g;
            }
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
            }
            z3 = false;
        }
        return !z3;
    }

    @Override // T1.t
    public final T1.s create(T1.e eVar, C0143a c0143a) {
        Class cls = c0143a.f2216a;
        if (!Object.class.isAssignableFrom(cls)) {
            return null;
        }
        AbstractC0286a abstractC0286a = Y1.c.f2084a;
        if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return new T1.b(2);
        }
        V1.d.f(this.f1886i);
        if (Y1.c.f2084a.x(cls)) {
            return new C0134z(cls, b(eVar, c0143a, cls, true));
        }
        return new C0132x(this.f1883f.x(c0143a), b(eVar, c0143a, cls, false));
    }
}
